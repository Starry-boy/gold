package com.jiaxc.gold.cache.factory.adpater.impl;

import com.jiaxc.gold.cache.CacheServiceEnumInterface;
import com.jiaxc.gold.cache.constist.enums.CacheServiceEnum;
import com.jiaxc.gold.cache.factory.adpater.CacheAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 11:01
 */
@Slf4j
@Component
public class RedisSingleCacheAdapter implements CacheAdapter{
    @Override
    public <T> T get(String key, Class<T> type) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public <T> List<T> list(String key, Class<T> type) {
        return null;
    }

    @Override
    public List<String> list(String key) {
        return null;
    }

    @Override
    public boolean remove(String key) {
        return false;
    }

    @Override
    public boolean put(String key, Object value) {
        return false;
    }

    @Override
    public CacheServiceEnumInterface getCacheType() {
        return CacheServiceEnum.REDIS_SINGLE;
    }


}
