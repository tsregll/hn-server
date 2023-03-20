package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessPlanningDevelopment;

/**
 * 规划发展项目后台Mapper接口
 * 
 * @author yrb
 * @date 2021-04-12
 */
public interface BusinessPlanningDevelopmentMapper 
{
    /**
     * 查询规划发展项目后台
     * 
     * @param id 规划发展项目后台ID
     * @return 规划发展项目后台
     */
    public BusinessPlanningDevelopment selectBusinessPlanningDevelopmentById(Long id);

    /**
     * 查询规划发展项目后台列表
     * 
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 规划发展项目后台集合
     */
    public List<BusinessPlanningDevelopment> selectBusinessPlanningDevelopmentList(BusinessPlanningDevelopment businessPlanningDevelopment);
    /**
     * 新增规划发展项目后台
     *
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 结果
     */
    public int insertBusinessPlanningDevelopment(BusinessPlanningDevelopment businessPlanningDevelopment);

    /**
     * 修改规划发展项目后台
     *
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 结果
     */
    public int updateBusinessPlanningDevelopment(BusinessPlanningDevelopment businessPlanningDevelopment);

    /**
     * 删除规划发展项目后台
     *
     * @param id 规划发展项目后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentById(Long id);

    /**
     * 批量删除规划发展项目后台
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentByIds(Long[] ids);

    /**
     * 查询列表通过项目类型排序
     *
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 规划发展项目后台集合
     */
    public List<BusinessPlanningDevelopment> selectListOrderByProjectType(BusinessPlanningDevelopment businessPlanningDevelopment);

    /**
     * 查询图片未满5张的规划发展项目列表
     *
     * @param businessPlanningDevelopment 查询条件
     * @return 查询结果
     */
    public List<BusinessPlanningDevelopment> selectFileNotFiveDevelopmentList(BusinessPlanningDevelopment businessPlanningDevelopment);
}
