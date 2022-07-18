package com.inspur.gs.commonutils.jsonutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * GsonUtils
 * @author tianjinzan01
 */
public class GsonUtils {

    private static final Gson GSON;
    /**
     * 不过滤空值
     */
    private static final Gson GSON_NULL;

    static {
        GSON = new GsonBuilder().enableComplexMapKeySerialization().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().disableHtmlEscaping().create();
        GSON_NULL = new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().disableHtmlEscaping().create();
    }

    //获取gson解析器
    public static Gson getGson() {
        return GSON;
    }

    //获取gson解析器 有空值 解析
    public static Gson getWriteNullGson() {
        return GSON_NULL;
    }

    /**
     * 根据对象返回json
     * @param object obj
     * @param bool 是否过滤空值
     */
    public static String toJsonString(Object object,boolean bool) {
        if (bool) {
            return GSON.toJson(object);
        } else {
            return GSON_NULL.toJson(object);
        }
    }


    /**
     * 将字符串转化对象
     * @param json     源字符串
     * @param classOfT 目标对象类型
     */
    public static <T> T strToJavaBean(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    /**
     * 将json转化为对应的实体对象
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        return GSON.fromJson(json, typeOfT);
    }

    /**
     * 转成list
     */
    public static <T> List<T> strToList(String gsonString, Class<T> cls) {
        return GSON.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
    }

    /**
     * 转成list中有map的
     */
    public static <T> List<Map<String, T>> strToListMaps(String gsonString) {
        return GSON.fromJson(gsonString, new TypeToken<List<Map<String, String>>>() {}.getType());
    }

    /**
     * 转成map
     */
    public static <T> Map<String, T> strToMaps(String gsonString) {
        return GSON.fromJson(gsonString, new TypeToken<Map<String, T>>() {}.getType());
    }
}

