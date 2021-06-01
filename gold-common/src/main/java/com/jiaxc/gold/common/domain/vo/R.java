package com.jiaxc.gold.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.jiaxc.gold.common.constist.constant.RConstant.Code.SUCCESS;

/**
 * @author ratel
 * @version 1.0
 * @description: API 响应对象
 * @date 2021/4/18 10:36
 */
@Data
@AllArgsConstructor
public class R<T> extends BaseVO{
    private String code;
    private boolean success;
    private String msg;
    private T data;

    private R() {
    }

    public static <T> R ok(String msg,T data){
        return new R<>(SUCCESS,true,msg,data);
    }
    public static <T> R ok(String msg){
        return new R<>(SUCCESS,true,msg,null);
    }
    public static <T> R ok(T data){
        return new R<T>(SUCCESS,true,null,data);
    }
    public static <T> R ok(){
        return new R<T>(SUCCESS,true,null,null);
    }
}
