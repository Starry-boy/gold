package com.jiaxc.gold.common.exception.runtime;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 10:53
 */
public class JsonParseRuntimeException extends BaseRuntimeException{

    public JsonParseRuntimeException(String message,Throwable throwable) {
        super(message,throwable);
    }
}
