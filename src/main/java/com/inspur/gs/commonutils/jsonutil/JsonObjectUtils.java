package com.inspur.gs.commonutils.jsonutil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * @author tianjinzan01
 */
public class JsonObjectUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 此配置的作用为当使用此工具将json中的属性还原到bean时，如果有bean中没有的属性，是否报错
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * json 转换成 bean
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        if (json == null || clazz == null) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json node 转换成bean
     */
    public static <T> T nodeToBean(JsonNode node, Class<T> clazz) {
        if (node == null || clazz == null) {
            return null;
        }
        try {
            return objectMapper.treeToValue(node,clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * bean 转换成 json
     */
    public static String beanToJson(Object bean) {

        if (bean == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(bean);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode stringToJsonNode(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        try {
            return objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}