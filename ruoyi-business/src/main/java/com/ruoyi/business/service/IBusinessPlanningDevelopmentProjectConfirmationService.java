package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectConfirmation;

/**
 * 规划发展项目详情Service接口
 * 
 * @author ruoyi
 * @date 2021-06-15
 */
public interface IBusinessPlanningDevelopmentProjectConfirmationService 
{
    /**
     * 查询规划发展项目详情
     * 
     * @param id 规划发展项目详情ID
     * @return 规划发展项目详情
     */
    public BusinessPlanningDevelopmentProjectConfirmation selectBusinessPlanningDevelopmentProjectConfirmationById(Long id);
    public BusinessPlanningDevelopmentProjectConfirmation selectBusinessPlanningDevelopmentProjectConfirmationByVoid();
    /**
     * 查询规划发展项目详情列表
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 规划发展项目详情集合
     */
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessPlanningDevelopmentProjectConfirmationList(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessPlanningDevelopmentProjectConfirmationList2(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessProjectConfirmationTotalList(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation);
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
     * 批量删除规划发展项目详情
     * 
     * @param ids 需要删除的规划发展项目详情ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectConfirmationByIds(Long[] ids);

    /**
     * 删除规划发展项目详情信息
     * 
     * @param id 规划发展项目详情ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectConfirmationById(Long id);

    public String importDatas(List<BusinessPlanningDevelopmentProjectConfirmation> bsce);
}
