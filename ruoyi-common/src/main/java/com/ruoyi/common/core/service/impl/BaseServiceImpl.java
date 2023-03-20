package com.ruoyi.common.core.service.impl;

import com.ruoyi.common.core.service.IBaseService;
import com.ruoyi.common.exception.BaseException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName BaseService
 * @Author wangliang(460098508 @ qq.com)
 * @Date 2021-03-13 1:24
 * @Description 业务层管理公共父接口的实现类，实现了新增和批量新增的方法。
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<T> insertList(List<T> list) {
        for (T entity : list) {
            //添加了验证方法以及前置方法
            if (this.validate(entity) && this.beforeInsert(entity)) {
                this.insertObject(entity);
            } else {
                throw new BaseException("业务数据验证不通过！");
            }
        }
        return list;
    }

    /**
     * 实体对象的验证方法
     *
     * @param entity
     * @return
     */
    protected boolean validate(T entity) {
        return true;
    }

    /**
     * 在保存之前的执行方法。
     *
     * @param entity
     * @return
     */
    protected boolean beforeInsert(T entity) {
        return true;
    }

}
