package com.jiaxc.gold.log.factory;

import com.jiaxc.gold.log.BuriedPointTypeEnumInterface;
import com.jiaxc.gold.log.service.BuriedPointAble;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/9 10:40
 */
public class BuriedPointFactory {

    private static ConcurrentHashMap<BuriedPointTypeEnumInterface, BuriedPointAble> buriedPointContext = new ConcurrentHashMap<>();

    public static BuriedPointAble  getBuriedPointAble(BuriedPointTypeEnumInterface buriedPointTypeEnum){
        return buriedPointContext.get(buriedPointTypeEnum);
    }

    public static boolean registration(BuriedPointTypeEnumInterface en, BuriedPointAble cacheService){
        return buriedPointContext.putIfAbsent(en, cacheService) == null;
    }
}
