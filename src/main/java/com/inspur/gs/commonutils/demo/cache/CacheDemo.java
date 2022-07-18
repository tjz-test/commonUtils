package com.inspur.gs.commonutils.demo.cache;

import io.iec.edp.caf.commons.layeringcache.cache.Cache;
import io.iec.edp.caf.commons.layeringcache.manager.CacheManager;
import io.iec.edp.caf.commons.layeringcache.serializer.DefaultJsonSerializer;
import io.iec.edp.caf.commons.layeringcache.setting.LayeringCacheSetting;
import io.iec.edp.caf.commons.layeringcache.support.ExpireMode;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import java.util.concurrent.TimeUnit;

/**
 * 开发接入规范：
 * 1、所有的key必须设置过期时间。
 * 2、key是按hash查找的，理论上越短越快，设置Key时尽量短小。
 * 3、单个缓存value值越小越好，一般来讲，100KB大小的值就已经认为是比较大的了。
 * 4、尽量分散key的使用，不要产生热点key.
 * 5､ 程序中同一Name的Cache接口对象、相同缓存的配置项等最好只创建一次， 通过静态变量或者单例模式持有。
 * 6､ 不建议同一Name的Cache使用不同的过期时间策略。
 * 7、由于序列化限制，请尽量不要使用带泛型类型的缓存值。如果必须要使用，请自定义序列化器。
 * 注意: 缓存作为底层组件，不进行应用和业务层面的分实例、多租户的处理，开发时需要根据实际清空进行区分。
 *
 *
 * maven依赖
 * <dependency>
 *    <groupId>io.iec.edp</groupId>
 *    <artifactId>caf-boot-starter-caching</artifactId>
 * </dependency>
 * @author 14791
 */
public class CacheDemo {

    private CacheDemo() { }

    /**
     * 静态内部类实现单例
     */
    private static class InnerClass {
        /**
         * 内部类对象（单例模式）
         */
        private static final CacheDemo.InnerClass INSTANCE = new InnerClass();

        private static CacheManager CACHE_MANAGER = null;

        /**
         * 此名称应与业务相关，实现缓存隔离
         */
        private static final String CACHE_NAME = "TestCache";

        private Cache cache;

        private InnerClass() {
            CACHE_MANAGER = SpringBeanUtils.getBean(CacheManager.class);
            getCustomCache();
        }

        /**
         * 配置缓存
         */
        private void getCustomCache() {

            /**
             * 多级缓存配置说明
             *
             * 关于缓存配置构造器：LayeringCacheSetting.Builder()
             * 该构造器所有的构造方法均为可选的。若不选择配置，将以默认值生成缓存配置对象。
             *
             * 配置默认值：
             *
             * 一级缓存开关：开
             * 一级缓存初始容量：10
             * 一级缓存最大容量：500
             * 一级缓存有效时间：1分钟
             * 一级缓存过期策略：写入后过期
             * 二级缓存开关：开
             * 二级缓存有效时间：5分钟
             * 二级缓存重载时间：1分钟(仅在2.3.2 注解方式使用下有效)
             * 二级缓存强制刷新：关 (仅在2.3.2 注解方式使用下有效)
             * 二级缓存允许空值：不允许 (仅在2.3.2 注解方式使用下有效)
             * 二级缓存空值比例：10 (仅在2.3.2 注解方式使用下有效)
             * 二级缓存序列化器：io.iec.edp.caf.commons.layeringcache.serializer.DefaultJsonSerializer
             *
             * cache支持get、put、evict、clear、putIfAbsent等方法，其中get(key)方法不支持外部调用，请使用带泛型的get(key,clazz)方法。
             * 如果需要自定义序列化器，请实现RedisDataSerializer接口，并将序列化器实例传入设置项。
             * 当二级缓存允许空值设置为true时，可设置空值时间过期比例。比例=(空值过期时间/非空值过期时间)，如配置缓存有效时间为200秒，比例设置为10，则当缓存value为null时，缓存有效时间为20秒，非空时为200秒。
             */

            //声明当前要使用的缓存配置，建议此配置通过静态变量持有
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
            cache = CACHE_MANAGER.getCache(CACHE_NAME, layeringCacheSetting);
        }

        /**
         * 对外提供cache
         */
        public Cache getCache() {
            return this.cache;
        }
    }

    /**
     * 对外提供缓存实例
     */
    public static Cache getCacheManager() {
        return CacheDemo.InnerClass.INSTANCE.getCache();
    }

}
