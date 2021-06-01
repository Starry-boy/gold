package com.jiaxc.gold.report.constist.enums;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 16:23
 */
public enum CacheKeyEnum {
    MODEL_PREFIX("MODEL:%s"),
    SQL_TEMPLATE_PREFIX("SQL_TEMPLATE:%s"),
    ;
    private String name;

    CacheKeyEnum(String name) {
        this.name = name;
    }

    public String toCacheKey(String ... key){
        return String.format(this.toString(),key);
    }
}
