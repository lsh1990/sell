package com.lsh.utils.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Objects;

/**
 * @ClassName JsonUtil
 * @Description: json格式化工具
 * @Author lsh
 * @Date 2018/10/22 20:43
 * @Version
 */
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static GsonBuilder gsonBuilder = new GsonBuilder();

    /**
     * Convert target object to json string.
     *
     * @param obj target object.
     * @return converted json string.
     */
    public static String toJson(Object obj) {
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create().toJson(obj);
    }

    /**
     * Convert json string to target object.
     *
     * @param json      json string.
     * @param valueType target object class type.
     * @param <T>       target class type.
     * @return converted target object.
     */
    public static <T> T toObject(String json, Class<T> valueType) {
        Objects.requireNonNull(json, "json is null.");
        Objects.requireNonNull(valueType, "value type is null.");

        try {
            return mapper.readValue(json, valueType);
        } catch (IOException e) {
            throw new IllegalStateException("fail to convert [" + json + "] to [" + valueType + "].", e);
        }
    }
}
