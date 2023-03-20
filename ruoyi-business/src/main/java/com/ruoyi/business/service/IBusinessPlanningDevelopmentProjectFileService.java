package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectFile;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展项目文件后台Service接口
 * 
 * @author yrb
 * @date 2021-04-28
 */
public interface IBusinessPlanningDevelopmentProjectFileService 
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
     * 批量删除规划发展项目文件后台
     *
     * @param ids 需要删除的规划发展项目文件后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectFileByIds(Long[] ids);

    /**
     * 删除规划发展项目文件后台信息
     *
     * @param id 规划发展项目文件后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentProjectFileById(Long id);

    /**
     * 查询已投产项目列表
     * @return 结果
     */
    public List<BusinessPlanningDevelopment> selectFinalProjectList();

    /**
     * 查询图片未满5张的已投产项目列表
     * @return
     */
    public List<BusinessPlanningDevelopment> selectFileInsProjectList();
    public AjaxResult finalProjectFileUpload(MultipartFile file, String projectDate,String projectNumber, String projectFileIllustration);
}
