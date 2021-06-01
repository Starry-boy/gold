package com.jiaxc.gold.cache.factory.adpater;

import com.jiaxc.gold.cache.CacheService;
import com.jiaxc.gold.cache.CacheServiceEnumInterface;
import com.jiaxc.gold.cache.constist.enums.CacheServiceEnum;
import com.jiaxc.gold.cache.factory.CacheFactory;

import javax.annotation.PostConstruct;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 11:04
 */
public interface CacheAdapter extends CacheService {

    CacheServiceEnumInterface getCacheType();

    @PostConstruct
    default void init(){
        CacheFactory.registration(getCacheType(),this);
    }
}
