package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessPlanningDevelop;

/**
 * 规划发展Service接口
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public interface IBusinessPlanningDevelopService 
{
    /**
     * 查询规划发展
     * 
     * @param id 规划发展ID
     * @return 规划发展
     */
    public BusinessPlanningDevelop selectBusinessPlanningDevelopById(Long id);

    /**
     * 查询规划发展列表
     * 
     * @param businessPlanningDevelop 规划发展
     * @return 规划发展集合
     */
    public List<BusinessPlanningDevelop> selectBusinessPlanningDevelopList(BusinessPlanningDevelop businessPlanningDevelop);

    /**
     * 新增规划发展
     * 
     * @param businessPlanningDevelop 规划发展
     * @return 结果
     */
    public int insertBusinessPlanningDevelop(BusinessPlanningDevelop businessPlanningDevelop);

    /**
     * 修改规划发展
     * 
     * @param businessPlanningDevelop 规划发展
     * @return 结果
     */
    public int updateBusinessPlanningDevelop(BusinessPlanningDevelop businessPlanningDevelop);

    /**
     * 批量删除规划发展
     * 
     * @param ids 需要删除的规划发展ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopByIds(Long[] ids);

    /**
     * 删除规划发展信息
     * 
     * @param id 规划发展ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopById(Long id);
}
