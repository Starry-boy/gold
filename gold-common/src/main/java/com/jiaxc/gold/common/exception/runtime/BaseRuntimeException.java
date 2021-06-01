package com.jiaxc.gold.common.exception.runtime;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 10:53
 */
public class BaseRuntimeException extends RuntimeException{

    public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseRuntimeException() {
    }
}
