package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentGroupProject;

/**
 * 规划发展基建专业组项目Service接口
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
public interface IBusinessDevelopmentGroupProjectService 
{
    /**
     * 查询规划发展基建专业组项目
     * 
     * @param id 规划发展基建专业组项目ID
     * @return 规划发展基建专业组项目
     */
    public BusinessDevelopmentGroupProject selectBusinessDevelopmentGroupProjectById(Long id);

    public BusinessDevelopmentGroupProject selectBusinessDevelopmentGroupProjectByVoid();

    /**
     * 查询规划发展基建专业组项目列表
     * 
     * @param businessDevelopmentGroupProject 规划发展基建专业组项目
     * @return 规划发展基建专业组项目集合
     */
    public List<BusinessDevelopmentGroupProject> selectBusinessDevelopmentGroupProjectList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject);

    /**
     * 新增规划发展基建专业组项目
     * 
     * @param businessDevelopmentGroupProject 规划发展基建专业组项目
     * @return 结果
     */
    public int insertBusinessDevelopmentGroupProject(BusinessDevelopmentGroupProject businessDevelopmentGroupProject);

    /**
     * 修改规划发展基建专业组项目
     * 
     * @param businessDevelopmentGroupProject 规划发展基建专业组项目
     * @return 结果
     */
    public int updateBusinessDevelopmentGroupProject(BusinessDevelopmentGroupProject businessDevelopmentGroupProject);

    /**
     * 批量删除规划发展基建专业组项目
     * 
     * @param ids 需要删除的规划发展基建专业组项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentGroupProjectByIds(Long[] ids);

    /**
     * 删除规划发展基建专业组项目信息
     * 
     * @param id 规划发展基建专业组项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentGroupProjectById(Long id);

    List<String> selectBusinessDevelopmentGroupProjectOperatorList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject);

    List<String> selectBusinessDevelopmentGroupProjectGroupMemberList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject);

    List<String> selectBusinessDevelopmentGroupProjectGroupLeaderList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject);
}
