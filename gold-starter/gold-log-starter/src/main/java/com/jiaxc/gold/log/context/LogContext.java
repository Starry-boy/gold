package com.jiaxc.gold.log.context;

import org.slf4j.MDC;


/**
 * @author ratel
 * @version 1.0
 * @description: 日志上下文
 * @date 2021/4/18 11:59
 */
public class LogContext {
    public static void setAttribute(String k,String v){
        MDC.put(k, v);
    }

    public static String getAttribute(String k){
        return MDC.get(k);
    }

    public static void clear(){
        MDC.clear();
    }
}
