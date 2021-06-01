package com.jiaxc.gold.common.constist.enums;

import org.springframework.util.StringUtils;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/9 9:22
 */
public enum OperationDescEnum {
    S0001("登录"),
    S0002("登出"),
    S0003("注册"),
    S0004("健康检查"),
    ;

    private String name;

    OperationDescEnum(String name) {
        this.name = name;
    }

    public static OperationDescEnum of(String code){
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (OperationDescEnum en : values()) {
            if (en.toString().equals(code)) {
                return en;
            }
        }
        return null;
    }

}
