package com.jiaxc.gold.cache.factory;

import com.jiaxc.gold.cache.CacheService;
import com.jiaxc.gold.cache.CacheServiceEnumInterface;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 10:59
 */
public class CacheFactory {

    private static ConcurrentHashMap<CacheServiceEnumInterface,CacheService> cacheServiceContext = new ConcurrentHashMap<>();

    public CacheService  getCacheService(CacheServiceEnumInterface cacheServiceEnum){
        return cacheServiceContext.get(cacheServiceEnum);
    }

    public static boolean registration(CacheServiceEnumInterface en, CacheService cacheService){
        return cacheServiceContext.putIfAbsent(en, cacheService) == null;
    }
}
