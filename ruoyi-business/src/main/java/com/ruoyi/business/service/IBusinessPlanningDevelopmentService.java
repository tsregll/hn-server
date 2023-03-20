package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.business.vo.PlanningDevelopmentDetailsVo;
import com.ruoyi.business.vo.PlanningDevelopmentHunanVo;
import com.ruoyi.business.vo.PlanningDevelopmentVo;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 规划发展项目后台Service接口
 * 
 * @author yrb
 * @date 2021-04-12
 */
public interface IBusinessPlanningDevelopmentService 
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
     * 批量删除规划发展项目后台
     *
     * @param ids 需要删除的规划发展项目后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentByIds(Long[] ids);

    /**
     * 删除规划发展项目后台信息
     *
     * @param id 规划发展项目后台ID
     * @return 结果
     */
    public int deleteBusinessPlanningDevelopmentById(Long id);


    /**
     * 查询湖南省规划发展的柱状图
     * @param projectType 项目类型
     * @return 柱状图数据
     */
    public Map<String,Object> selectHnHistogram(String projectType);

    /**
     * 查询湖南省规划发展的表格数据
     * @return 表格数据集合
     */
    public List<PlanningDevelopmentVo> selectHnTable();

    /**
     * 查询市区规划发展的柱状图
     * @param projectType 项目类型
     * @param projectRegionDistrict 市级地区
     * @return 柱状图数据
     */
    public Map<String,Object> selectDistrictHistogram(String projectType,String projectRegionDistrict);
    /**
     * 查询市区规划发展的表格数据
     * @param projectType 项目类型
     * @param projectRegionDistrict 市级地区
     * @return 表格数据集合
     */
    public List<Map<String,Object>> selectDistrictTable(String projectType,String projectRegionDistrict);

    /**
     * 查询市区规划发展的详情表格
     * @param projectStatus 项目状态
     * @param projectRegionDistrict 市级地区
     * @return 表格数据集合
     */
    public Map<String,Object> selectTableDetails(String projectStatus,String projectRegionDistrict);

    /**
     * 新规划发展一级菜单
     * @return 地图上全部的点信息Vo
     */
    public List<Map<String,Object>> selectHnProjects();


    /**
     * 新规划发展二级菜单（前期开发，已（拟）开工）
     * @param projectNumber 项目编号（项目id）
     * @param projectStatus 项目状态
     * @return 查询的数据Vo
     */
    public Map<String,Object> selectProjectByStatus(Long projectNumber, String projectStatus);
    public Map<String,Object> selectProjectDetailByStatus(Long projectNumber, String projectStatus);

    /**
     * 新规划发展三级菜单（已竣工）
     * @param projectNumber 项目编号（项目id）
     * @return 查询的数据Vo
     */
    public Map<String,Object> selectImgFileByProjectNumber(Long projectNumber);
}
