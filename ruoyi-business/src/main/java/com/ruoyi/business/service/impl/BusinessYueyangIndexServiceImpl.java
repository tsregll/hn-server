package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessYueyangIndexMapper;
import com.ruoyi.business.domain.BusinessYueyangIndex;
import com.ruoyi.business.service.IBusinessYueyangIndexService;

/**
 * 岳阳电厂年度指标录入Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessYueyangIndexServiceImpl implements IBusinessYueyangIndexService 
{
    @Autowired
    private BusinessYueyangIndexMapper businessYueyangIndexMapper;

    /**
     * 查询岳阳电厂年度指标录入
     * 
     * @param id 岳阳电厂年度指标录入ID
     * @return 岳阳电厂年度指标录入
     */
    @Override
    public BusinessYueyangIndex selectBusinessYueyangIndexById(Long id)
    {
        return businessYueyangIndexMapper.selectBusinessYueyangIndexById(id);
    }

    /**
     * 查询岳阳电厂年度指标录入列表
     * 
     * @param businessYueyangIndex 岳阳电厂年度指标录入
     * @return 岳阳电厂年度指标录入
     */
    @Override
    public List<BusinessYueyangIndex> selectBusinessYueyangIndexList(BusinessYueyangIndex businessYueyangIndex)
    {
        return businessYueyangIndexMapper.selectBusinessYueyangIndexList(businessYueyangIndex);
    }

    /**
     * 新增岳阳电厂年度指标录入
     * 
     * @param businessYueyangIndex 岳阳电厂年度指标录入
     * @return 结果
     */
    @Override
    public int insertBusinessYueyangIndex(BusinessYueyangIndex businessYueyangIndex)
    {
        businessYueyangIndex.setCreateTime(DateUtils.getNowDate());
        return businessYueyangIndexMapper.insertBusinessYueyangIndex(businessYueyangIndex);
    }

    /**
     * 修改岳阳电厂年度指标录入
     * 
     * @param businessYueyangIndex 岳阳电厂年度指标录入
     * @return 结果
     */
    @Override
    public int updateBusinessYueyangIndex(BusinessYueyangIndex businessYueyangIndex)
    {
        businessYueyangIndex.setUpdateTime(DateUtils.getNowDate());
        return businessYueyangIndexMapper.updateBusinessYueyangIndex(businessYueyangIndex);
    }

    /**
     * 批量删除岳阳电厂年度指标录入
     * 
     * @param ids 需要删除的岳阳电厂年度指标录入ID
     * @return 结果
     */
    @Override
    public int deleteBusinessYueyangIndexByIds(Long[] ids)
    {
        return businessYueyangIndexMapper.deleteBusinessYueyangIndexByIds(ids);
    }

    /**
     * 删除岳阳电厂年度指标录入信息
     * 
     * @param id 岳阳电厂年度指标录入ID
     * @return 结果
     */
    @Override
    public int deleteBusinessYueyangIndexById(Long id)
    {
        return businessYueyangIndexMapper.deleteBusinessYueyangIndexById(id);
    }
}
