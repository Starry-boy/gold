package com.jiaxc.gold.cache;

import java.util.List;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 10:54
 */
public interface CacheService {

    String get(String key);

    <T> T get(String key,Class<T> type);


    <T> List<T> list(String key, Class<T> type);

    List<String> list(String key);

    boolean remove(String key);

    boolean put(String key,Object value);
}
