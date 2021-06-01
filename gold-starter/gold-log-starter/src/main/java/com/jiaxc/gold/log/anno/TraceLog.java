package com.jiaxc.gold.log.anno;

import com.jiaxc.gold.common.constist.enums.OperationDescEnum;
import com.jiaxc.gold.common.constist.enums.OperationEnum;

import java.lang.annotation.*;

/**
 * @author ratel
 * @version 1.0
 * @description: 日志切面，记录用户IP，用户名，工号，操作类型，入参 等信息
 * @date 2021/4/18 10:16
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TraceLog {
    OperationEnum option();
    OperationDescEnum desc();

    /**
     * SPEL 表达式
     * @return
     */
    String businessKey() default "";
}
