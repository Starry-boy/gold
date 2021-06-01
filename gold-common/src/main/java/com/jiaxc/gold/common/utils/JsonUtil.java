package com.jiaxc.gold.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaxc.gold.common.exception.runtime.JsonParseRuntimeException;

import java.io.IOException;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 10:50
 */
public class JsonUtil {
    private static ObjectMapper jsonMapper = new ObjectMapper();

    public static String toString(Object obj){
        try {
            return jsonMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonParseRuntimeException(e.getMessage(),e);
        }
    }

    public <T> T toObject(String jsonStr,Class<T> cls){
        try {
            return jsonMapper.readValue(jsonStr, cls);
        } catch (IOException e) {
            throw new JsonParseRuntimeException(e.getMessage(),e);
        }
    }
}
