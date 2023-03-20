package com.ruoyi.common.core.service;

import java.util.List;

/**
 * @ClassName IBaseService
 * @Author wangliang(460098508 @ qq.com)
 * @Date 2021-03-13 1:22
 * @Description 业务层管理接口公共父类，定义了新增和批量新增的方法。
 */
public interface IBaseService<T> {

    /**
     * 批量新增对象
     *
     * @param list
     * @return
     */
    public List<T> insertList(List<T> list);

    /**
     * 新增一个对象
     *
     * @param entity
     * @return
     */
    public T insertObject(T entity);
}
