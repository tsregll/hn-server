package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectConfirmation;

/**
 * 规划发展项目详情Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-15
 */
public interface BusinessPlanningDevelopmentProjectConfirmationMapper 
{
    /**
     * 查询规划发展项目详情
     * 
     * @param id 规划发展项目详情ID
     * @return 规划发展项目详情
     */
    public BusinessPlanningDevelopmentProjectConfirmation selectBusinessPlanningDevelopmentProjectConfirmationById(Long id);

    /**
     * 查询规划发展项目详情列表
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 规划发展项目详情集合
     */
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessPlanningDevelopmentProjectConfirmationList(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);
    public List<BusinessPlanningDevelopmentProjectConfirmation>selectBusinessProjectConfirmationTotalList(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);
    /**
     * 新增规划发展项目详情
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 结果
     */
    public int insertBusinessPlanningDevelopmentProjectConfirmation(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);

    /**
     * 修改规划发展项目详情
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 结果
     */
    public int updateBusinessPlanningDevelopmentProjectConfirmation(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);

    /**
     * 删除规划发展项目详情
     * 
     * @param id 规划发展项目详情ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectConfirmationById(Long id);

    /**
     * 批量删除规划发展项目详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectConfirmationByIds(Long[] ids);
}
