package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectFile;

/**
 * 规划发展项目文件后台Mapper接口
 * 
 * @author yrb
 * @date 2021-04-28
 */
public interface BusinessPlanningDevelopmentProjectFileMapper 
{
    /**
     * 查询规划发展项目文件后台
     * 
     * @param id 规划发展项目文件后台ID
     * @return 规划发展项目文件后台
     */
    public BusinessPlanningDevelopmentProjectFile selectBusinessPlanningDevelopmentProjectFileById(Long id);

    /**
     * 查询规划发展项目文件后台列表
     * 
     * @param businessPlanningDevelopmentProjectFile 规划发展项目文件后台
     * @return 规划发展项目文件后台集合
     */
    public List<BusinessPlanningDevelopmentProjectFile> selectBusinessPlanningDevelopmentProjectFileList(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile);

    /**
     * 新增规划发展项目文件后台
     * 
     * @param businessPlanningDevelopmentProjectFile 规划发展项目文件后台
     * @return 结果
     */
    public int insertBusinessPlanningDevelopmentProjectFile(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile);

    /**
     * 修改规划发展项目文件后台
     * 
     * @param businessPlanningDevelopmentProjectFile 规划发展项目文件后台
     * @return 结果
     */
    public int updateBusinessPlanningDevelopmentProjectFile(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile);

    /**
     * 删除规划发展项目文件后台
     * 
     * @param id 规划发展项目文件后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectFileById(Long id);

    /**
     * 批量删除规划发展项目文件后台
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectFileByIds(Long[] ids);
}
