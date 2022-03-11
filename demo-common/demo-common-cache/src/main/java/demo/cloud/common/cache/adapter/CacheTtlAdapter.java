package demo.cloud.common.cache.adapter;

import demo.cloud.common.cache.bo.CacheNameWithTtlBO;

import java.util.List;

public interface CacheTtlAdapter {

    /**
     * 根据缓存的cacheName和ttl将缓存进行过期
     * @return 需要独立设置过期时间的缓存列表
     */
    List<CacheNameWithTtlBO> listCacheNameWithTtl();
}
