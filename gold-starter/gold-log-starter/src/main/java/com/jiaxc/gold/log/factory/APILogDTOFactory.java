package com.jiaxc.gold.log.factory;

import com.jiaxc.gold.common.utils.JsonUtil;
import com.jiaxc.gold.common.utils.WebUtil;
import com.jiaxc.gold.log.anno.TraceLog;
import com.jiaxc.gold.log.model.dto.APILogDTO;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 14:35
 */
public class APILogDTOFactory {

    public static APILogDTO get(TraceLog traceLog, Long userId, Date requestTime, Object requestArgs) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest req = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        return new APILogDTO()
                .setUserId(userId)
                .setBrower(WebUtil.getBrowers(req))
                .setIp(WebUtil.getIpAddr(req))
                .setOs(WebUtil.getOS(req))
                .setOperationEnum(traceLog.option())
                .setDesc(traceLog.desc().toString())
                .setRequestTime(requestTime)
                .setCreateTime(new Date())
                .setRequestArgs(JsonUtil.toString(requestArgs));
    }
}
