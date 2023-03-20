package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessPlanningDevelopMapper;
import com.ruoyi.business.domain.BusinessPlanningDevelop;
import com.ruoyi.business.service.IBusinessPlanningDevelopService;

/**
 * 规划发展Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-02
 */
@Service
public class BusinessPlanningDevelopServiceImpl implements IBusinessPlanningDevelopService 
{
    @Autowired
    private BusinessPlanningDevelopMapper businessPlanningDevelopMapper;

    /**
     * 查询规划发展
     * 
     * @param id 规划发展ID
     * @return 规划发展
     */
    @Override
    public BusinessPlanningDevelop selectBusinessPlanningDevelopById(Long id)
    {
        return businessPlanningDevelopMapper.selectBusinessPlanningDevelopById(id);
    }

    /**
     * 查询规划发展列表
     * 
     * @param businessPlanningDevelop 规划发展
     * @return 规划发展
     */
    @Override
    public List<BusinessPlanningDevelop> selectBusinessPlanningDevelopList(BusinessPlanningDevelop businessPlanningDevelop)
    {
        return businessPlanningDevelopMapper.selectBusinessPlanningDevelopList(businessPlanningDevelop);
    }

    /**
     * 新增规划发展
     * 
     * @param businessPlanningDevelop 规划发展
     * @return 结果
     */
    @Override
    public int insertBusinessPlanningDevelop(BusinessPlanningDevelop businessPlanningDevelop)
    {
        businessPlanningDevelop.setCreateTime(DateUtils.getNowDate());
        return businessPlanningDevelopMapper.insertBusinessPlanningDevelop(businessPlanningDevelop);
    }

    /**
     * 修改规划发展
     * 
     * @param businessPlanningDevelop 规划发展
     * @return 结果
     */
    @Override
    public int updateBusinessPlanningDevelop(BusinessPlanningDevelop businessPlanningDevelop)
    {
        businessPlanningDevelop.setUpdateTime(DateUtils.getNowDate());
        return businessPlanningDevelopMapper.updateBusinessPlanningDevelop(businessPlanningDevelop);
    }

    /**
     * 批量删除规划发展
     * 
     * @param ids 需要删除的规划发展ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopByIds(Long[] ids)
    {
        return businessPlanningDevelopMapper.deleteBusinessPlanningDevelopByIds(ids);
    }

    /**
     * 删除规划发展信息
     * 
     * @param id 规划发展ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopById(Long id)
    {
        return businessPlanningDevelopMapper.deleteBusinessPlanningDevelopById(id);
    }
}
