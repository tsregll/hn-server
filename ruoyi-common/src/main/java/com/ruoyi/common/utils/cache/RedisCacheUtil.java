package com.ruoyi.common.utils.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author: liangw(460098508 @ qq.com)
 * @time: 2021/2/25 16:14
 * @description:
 */
@Component("redisCacheUtil")
public class RedisCacheUtil implements ICacheUtil {

    @Autowired
    public RedisTemplate redisTemplate;

    @Override
    public <T> T getCacheObject(String key) {
        ValueOperations<String, T> operation = this.redisTemplate.opsForValue();
        return operation.get(key);
    }

    @Override
    public <T> T getCacheObject(String key, String cacheName) {
        return null;
    }

    @Override
    public <T> void setCacheObject(String key, T value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public <T> void setCacheObject(String key, T value, String cacheName) {

    }

    @Override
    public void clear(String key) {
        this.redisTemplate.delete(key);
    }
}
