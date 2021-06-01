package com.jiaxc.gold.log.aspect;

import com.jiaxc.gold.common.context.SessionContext;
import com.jiaxc.gold.common.domain.bo.UserBO;
import com.jiaxc.gold.common.domain.vo.R;
import com.jiaxc.gold.common.utils.JsonUtil;
import com.jiaxc.gold.log.anno.TraceLog;
import com.jiaxc.gold.log.context.LogContext;
import com.jiaxc.gold.log.factory.APILogDTOFactory;
import com.jiaxc.gold.log.model.dto.APILogDTO;
import com.jiaxc.gold.log.service.APILogService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Optional;

/**
 * @author ratel
 * @version 1.0
 * @description: 日志切面，记录用户IP，用户名，工号，操作类型，入参 等信息
 * @date 2021/4/18 10:20
 * @see TraceLog
 */
@Slf4j
@Aspect
public class TradeLogAspect {

    @Setter
    private APILogService apiLogService;

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    @Pointcut("@annotation(com.jiaxc.gold.log.anno.TraceLog)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public R around(ProceedingJoinPoint joinPoint) throws Throwable {
        //目标对象
        Object target = joinPoint.getTarget();
        //方法签名
        Signature signature = joinPoint.getSignature();
        //用户ID
        Long userId = Optional.ofNullable(SessionContext.getCurrentUser()).orElse(new UserBO()).getId();
        Date requestDate = new Date();
        APILogDTO apiLogDTO = null;

        if (signature instanceof MethodSignature) {
            Method method = ((MethodSignature) signature).getMethod();
            TraceLog traceLog = method.getAnnotation(TraceLog.class);
            apiLogDTO = APILogDTOFactory.get(traceLog, userId, requestDate, joinPoint.getArgs());

            //将操作人的信息保存到日志上下文
            if (apiLogDTO != null) {
                Object[] args = joinPoint.getArgs();
                if (args != null && args.length > 0){
                    ExpressionParser parser = new SpelExpressionParser();
                    Expression expression = parser.parseExpression(traceLog.businessKey());
                    EvaluationContext evaluationContext = bindParam(method, joinPoint.getArgs());
                    Object value = expression.getValue(evaluationContext);
                    LogContext.setAttribute("BUSINESS_KEY", Optional.ofNullable(value).orElse("").toString());
                }

                LogContext.setAttribute("IP", apiLogDTO.getIp());
                LogContext.setAttribute("OS", apiLogDTO.getOs());
                LogContext.setAttribute("BROWER", apiLogDTO.getBrower());
                LogContext.setAttribute("USER_ID", apiLogDTO.getUserId().toString());
                LogContext.setAttribute("USER_NAME", "");
                LogContext.setAttribute("OPTION_TYPE", apiLogDTO.getOperationEnum().name());
                LogContext.setAttribute("DESC", apiLogDTO.getDesc());
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("APILogAspect API 类名:{} 方法名:{} 入参:{}", target.getClass().getSimpleName(), signature.getName(), JsonUtil.toString(joinPoint.getArgs()));
        }

        R r = null;
        try {
            r = (R) joinPoint.proceed(joinPoint.getArgs());
            return r;

        } finally {
            //记录接口调用日志
            if (apiLogService != null && apiLogDTO != null && r != null) {
                apiLogDTO.setResponseResult(JsonUtil.toString(r.getData()))
                        .setCode(r.getCode())
                        .setSuccess(r.isSuccess())
                        .setResponseTime(new Date())
                        .setElapsedTime(apiLogDTO.getResponseTime().getTime() - apiLogDTO.getRequestTime().getTime());
                apiLogService.saveLog(apiLogDTO);
            }

            if (log.isDebugEnabled()) {
                log.debug("APILogAspect API 类名:{} 方法名:{} 返回结果:{}", target.getClass().getSimpleName(), signature.getName(),JsonUtil.toString(r));
            }

            //清理日志上下文，避免内存泄漏
            LogContext.clear();
        }
    }

    /**
     * 写入api日志
     *
     * @param apiLogDTO
     */
    private void saveApiLog(APILogDTO apiLogDTO) {
        apiLogService.saveLog(apiLogDTO);
    }


    private EvaluationContext bindParam(Method method, Object[] args) {
        //获取方法的参数名
        String[] params = discoverer.getParameterNames(method);

        //将参数名与参数值对应起来
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        return context;
    }
}
