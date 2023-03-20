package com.ruoyi.common.utils.cache;

/**
 * 系统中使用缓存的接口，原则上一个项目中只使用一个缓存类型
 *
 * @author: liangw(460098508 @ qq.com)
 * @time: 2021/2/25 9:31
 * @description:
 */
public interface ICacheUtil {

    /**
     * 根据KEY获取缓存对象
     *
     * @param key 缓存KEY
     * @param <T> 缓存对象
     * @return
     */
    public <T> T getCacheObject(final String key);

    /**
     * 根据KEY获取缓存对象
     *
     * @param key       缓存KEY
     * @param cacheName 缓存名称
     * @param <T>
     * @return
     */
    public <T> T getCacheObject(final String key, String cacheName);

    /**
     * 根据KEY向缓存中存入对象
     *
     * @param key   缓存KEY
     * @param value 存入对象
     * @param <T>
     */
    public <T> void setCacheObject(final String key, T value);

    /**
     * 根据KEY向缓存中存入对象
     *
     * @param key       缓存KEY
     * @param value     存入对象
     * @param cacheName 缓存名称
     * @param <T>
     */
    public <T> void setCacheObject(final String key, T value, String cacheName);

    /**
     * @param key
     */
    public void clear(final String key);
}
