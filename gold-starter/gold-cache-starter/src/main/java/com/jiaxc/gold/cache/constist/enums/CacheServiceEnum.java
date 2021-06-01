package com.jiaxc.gold.cache.constist.enums;

import com.jiaxc.gold.cache.CacheServiceEnumInterface;
import lombok.Getter;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 11:18
 */
public enum CacheServiceEnum implements CacheServiceEnumInterface {
    REDIS_SINGLE("REDIS单例缓存服务"),
    REDIS_CLUSTER("REDIS集群缓存服务"),
    EHCACHE("EHCACHE硬盘缓存服务"),
    ;

    @Getter
    private String name;

    CacheServiceEnum(String name) {
        this.name = name;
    }

    public static CacheServiceEnum of(String code){
        if (code == null) {
            return null;
        }

        for (CacheServiceEnum en : values()) {
            if (en.toString().equals(code)) {
                return en;
            }
        }
        return null;
    }
}
