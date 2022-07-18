package com.inspur.gs.commonutils.demo.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tjz
 * @date 2022/7/16
 * @description 单例模式实现缓存实例存储
 */
public class CacheManagers {

    private static Map<String, Object> cacheManager = null;

    private static volatile CacheManagers instance = new CacheManagers();

    private CacheManagers () {
        cacheManager = new HashMap<>(16);
    }

    public static CacheManagers getInstance(){
        if (instance == null) {
            synchronized (CacheManagers.class) {
                if (instance == null) {
                    instance = new CacheManagers();
                }
            }
        }
        return instance;
    }

    /**
     * 添加到内存
     */
    public void addCache(String key,Object obj){
        cacheManager.put(key,obj);
    }

    /**
     * 从内存中取出
     */
    public Object getCache(String key){
        return cacheManager.get(key);
    }

    /**
     * 从内存中清除
     */
    public void removeCache(String key){
        cacheManager.remove(key);
    }

}
