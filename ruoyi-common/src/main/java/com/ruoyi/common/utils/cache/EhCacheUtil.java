package com.ruoyi.common.utils.cache;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @author: liangw(460098508 @ qq.com)
 * @time: 2021/2/25 16:25
 * @description:
 */
@Component("ehCacheUtil")
public class EhCacheUtil implements ICacheUtil {

    @Autowired(required = false)
    private CacheManager cacheManager;

    private static final String DEFAULT_CACHE_NAME = "default_cache";

    @Override
    public <T> T getCacheObject(String key) {
        Cache cache = cacheManager.getCache(DEFAULT_CACHE_NAME);
        return (T) cache.get(key);
    }

    @Override
    public <T> T getCacheObject(String key, String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        return (T) cache.get(key);
    }

    @Override
    public <T> void setCacheObject(String key, T value) {
        Cache cache = cacheManager.getCache(DEFAULT_CACHE_NAME);
        cache.put(key, value);
    }

    @Override
    public <T> void setCacheObject(String key, T value, String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        cache.put(key, value);
    }

    @Override
    public void clear(String key) {
        Cache cache = cacheManager.getCache(DEFAULT_CACHE_NAME);
        if (StringUtils.isEmpty(key)) {
            cache.clear();
        } else {
            cache.put(key, null);
        }
    }
}
