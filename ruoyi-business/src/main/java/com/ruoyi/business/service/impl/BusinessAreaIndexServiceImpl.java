package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAreaIndexMapper;
import com.ruoyi.business.domain.BusinessAreaIndex;
import com.ruoyi.business.service.IBusinessAreaIndexService;

/**
 * 区域年度指标录入Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessAreaIndexServiceImpl implements IBusinessAreaIndexService 
{
    @Autowired
    private BusinessAreaIndexMapper businessAreaIndexMapper;

    /**
     * 查询区域年度指标录入
     * 
     * @param id 区域年度指标录入ID
     * @return 区域年度指标录入
     */
    @Override
    public BusinessAreaIndex selectBusinessAreaIndexById(Long id)
    {
        return businessAreaIndexMapper.selectBusinessAreaIndexById(id);
    }

    /**
     * 查询区域年度指标录入列表
     * 
     * @param businessAreaIndex 区域年度指标录入
     * @return 区域年度指标录入
     */
    @Override
    public List<BusinessAreaIndex> selectBusinessAreaIndexList(BusinessAreaIndex businessAreaIndex)
    {
        return businessAreaIndexMapper.selectBusinessAreaIndexList(businessAreaIndex);
    }

    /**
     * 新增区域年度指标录入
     * 
     * @param businessAreaIndex 区域年度指标录入
     * @return 结果
     */
    @Override
    public int insertBusinessAreaIndex(BusinessAreaIndex businessAreaIndex)
    {
        businessAreaIndex.setCreateTime(DateUtils.getNowDate());
        return businessAreaIndexMapper.insertBusinessAreaIndex(businessAreaIndex);
    }

    /**
     * 修改区域年度指标录入
     * 
     * @param businessAreaIndex 区域年度指标录入
     * @return 结果
     */
    @Override
    public int updateBusinessAreaIndex(BusinessAreaIndex businessAreaIndex)
    {
        businessAreaIndex.setUpdateTime(DateUtils.getNowDate());
        return businessAreaIndexMapper.updateBusinessAreaIndex(businessAreaIndex);
    }

    /**
     * 批量删除区域年度指标录入
     * 
     * @param ids 需要删除的区域年度指标录入ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAreaIndexByIds(Long[] ids)
    {
        return businessAreaIndexMapper.deleteBusinessAreaIndexByIds(ids);
    }

    /**
     * 删除区域年度指标录入信息
     * 
     * @param id 区域年度指标录入ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAreaIndexById(Long id)
    {
        return businessAreaIndexMapper.deleteBusinessAreaIndexById(id);
    }
}
