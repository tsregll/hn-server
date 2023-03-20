package com.ruoyi.business.service;

import java.io.IOException;
import java.util.List;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentDetails;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展项目详情后台Service接口
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
public interface IBusinessPlanningDevelopmentDetailsService 
{
    /**
     * 查询规划发展项目详情后台
     * 
     * @param id 规划发展项目详情后台ID
     * @return 规划发展项目详情后台
     */
    public BusinessPlanningDevelopmentDetails selectBusinessPlanningDevelopmentDetailsById(Long id);

    /**
     * 查询规划发展项目详情后台列表
     * 
     * @param businessPlanningDevelopmentDetails 规划发展项目详情后台
     * @return 规划发展项目详情后台集合
     */
    public List<BusinessPlanningDevelopmentDetails> selectBusinessPlanningDevelopmentDetailsList(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails);

    /**
     * 新增规划发展项目详情后台
     * 
     * @param businessPlanningDevelopmentDetails 规划发展项目详情后台
     * @return 结果
     */
    public int insertBusinessPlanningDevelopmentDetails(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails);

    /**
     * 修改规划发展项目详情后台
     * 
     * @param businessPlanningDevelopmentDetails 规划发展项目详情后台
     * @return 结果
     */
    public AjaxResult updateBusinessPlanningDevelopmentDetails(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails);

    /**
     * 批量删除规划发展项目详情后台
     * 
     * @param ids 需要删除的规划发展项目详情后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentDetailsByIds(Long[] ids);

    /**
     * 删除规划发展项目详情后台信息
     * 
     * @param id 规划发展项目详情后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentDetailsById(Long id);

    /**
     * 上传xlsx
     * @return 结果
     */
    public AjaxResult projectFileNameSave(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) throws IOException;
}
