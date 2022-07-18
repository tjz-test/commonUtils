package com.inspur.gs.commonutils.demo.cache;

import io.iec.edp.caf.commons.layeringcache.cache.Cache;
import io.iec.edp.caf.commons.layeringcache.manager.CacheManager;
import io.iec.edp.caf.commons.layeringcache.serializer.DefaultJsonSerializer;
import io.iec.edp.caf.commons.layeringcache.setting.LayeringCacheSetting;
import io.iec.edp.caf.commons.layeringcache.support.ExpireMode;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author tjz
 * @date 2022/7/16
 * @description
 */
public class UseDemo {

    public Cache getCache(String key) {
        if (Optional.ofNullable(CacheManagers.getInstance().getCache(key)).isPresent()) {
            return (Cache) CacheManagers.getInstance().getCache("TestCache");
        } else {
            Cache cache = customCache();
            CacheManagers.getInstance().addCache(key, cache);
            return cache;
        }
    }

    private Cache customCache() {

        CacheManager cacheManager = SpringBeanUtils.getBean(CacheManager.class);

        LayeringCacheSetting layeringCacheSetting = new LayeringCacheSetting.Builder()
                //开启一级缓存
                .enableFirstCache()
                //一级缓存过期策略(可选写入后过期、访问后过期)
                .firstCacheExpireMode(ExpireMode.WRITE)
                //一级缓存过期时间
                .firstCacheExpireTime(1)
                //一级缓存过期时间单位
                .firstCacheTimeUnit(TimeUnit.HOURS)
                //一级缓存初始容量
                .firstCacheInitialCapacity(10)
                //一级缓存最大容量(到达最大容量后 开始驱逐低频缓存)
                .firstCacheMaximumSize(1000)
                //开启二级缓存
                .enableSecondCache()
                //二级缓存过期时间
                .secondCacheExpireTime(24)
                //二级缓存时间单位
                .secondCacheTimeUnit(TimeUnit.HOURS)
                //二级缓存允许空值
                .allowNullValue(true)
                //二级缓存空值过期时间比率
                .magnification(10)
                //二级缓存序列化器
                .dataSerializer(new DefaultJsonSerializer())
                //缓存配置说明
                .depict("cache demo").build();
        //获取缓存实例，通过cache操作缓存
        return cacheManager.getCache("TestCache", layeringCacheSetting);
    }
}
