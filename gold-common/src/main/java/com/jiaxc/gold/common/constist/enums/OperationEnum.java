package com.jiaxc.gold.common.constist.enums;

/**
 * @author ratel
 * @version 1.0
 * @description: 操作类型
 * @date 2021/4/18 11:28
 */
public enum OperationEnum {
    ADD("新增"), MODIFY("修改"), DELETE("删除"), REMOVE("移除"), QUERY("查询");

    private String name;

    OperationEnum(String name) {
        this.name = name;
    }
}
