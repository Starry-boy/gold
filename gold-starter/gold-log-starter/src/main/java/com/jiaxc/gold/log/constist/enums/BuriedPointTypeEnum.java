package com.jiaxc.gold.log.constist.enums;

import com.jiaxc.gold.log.BuriedPointTypeEnumInterface;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/9 10:42
 */
public enum BuriedPointTypeEnum implements BuriedPointTypeEnumInterface {
    DEFAULT("默认"),
    ;
    private String name;

    BuriedPointTypeEnum(String name) {
        this.name = name;
    }

}
