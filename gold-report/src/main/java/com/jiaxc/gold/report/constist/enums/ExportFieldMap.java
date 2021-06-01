package com.jiaxc.gold.report.constist.enums;

import lombok.Getter;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 16:10
 */
public interface ExportFieldMap {

    enum Type {
        NUMBER("数字"),
        STRING("字符串"),
        DATE("日期"),
        ;
        @Getter
        private String name;

        Type(String name) {
            this.name = name;
        }

        public static Type of(String code){
            if (code == null){
                return null;
            }

            for (Type type : values()) {
                if (type.toString().equals(code)) {
                    return type;
                }
            }

            return null;
        }

    }
}
