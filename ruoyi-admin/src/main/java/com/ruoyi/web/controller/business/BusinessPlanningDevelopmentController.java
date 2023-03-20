package com.ruoyi.web.controller.business;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.vo.PlanningDevelopmentDetailsVo;
import com.ruoyi.business.vo.PlanningDevelopmentHunanVo;
import com.ruoyi.business.vo.PlanningDevelopmentVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规划发展项目后台Controller
 * 
 * @author yrb
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/business/planningdevelopment")
public class BusinessPlanningDevelopmentController extends BaseController
{
    @Autowired
    private IBusinessPlanningDevelopmentService businessPlanningDevelopmentService;

    /**
     * 查询规划发展项目后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopment:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        startPage();
        List<BusinessPlanningDevelopment> list = businessPlanningDevelopmentService.selectBusinessPlanningDevelopmentList(businessPlanningDevelopment);
        return getDataTable(list);
    }

    /**
     * 导出规划发展项目后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopment:export')")
    @Log(title = "规划发展项目后台", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        List<BusinessPlanningDevelopment> list = businessPlanningDevelopmentService.selectBusinessPlanningDevelopmentList(businessPlanningDevelopment);
        ExcelUtil<BusinessPlanningDevelopment> util = new ExcelUtil<BusinessPlanningDevelopment>(BusinessPlanningDevelopment.class);
        return util.exportExcel(list, "planningdevelopment");
    }

    /**
     * 获取规划发展项目后台详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessPlanningDevelopmentService.selectBusinessPlanningDevelopmentById(id));
    }

    /**
     * 新增规划发展项目后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopment:add')")
    @Log(title = "规划发展项目后台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        return toAjax(businessPlanningDevelopmentService.insertBusinessPlanningDevelopment(businessPlanningDevelopment));
    }

    /**
     * 修改规划发展项目后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopment:edit')")
    @Log(title = "规划发展项目后台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        return toAjax(businessPlanningDevelopmentService.updateBusinessPlanningDevelopment(businessPlanningDevelopment));
    }

    /**
     * 删除规划发展项目后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopment:remove')")
    @Log(title = "规划发展项目后台", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessPlanningDevelopmentService.deleteBusinessPlanningDevelopmentByIds(ids));
    }

    /**
     * 规划发展（湖南柱状图）
     * @param projectType 项目类型
     * @return 柱状图数据
     */
    @GetMapping("/selectHnHistogram")
    public AjaxResult selectHnHistogram(@RequestParam("projectType") String projectType){
        Map<String,Object> returnMap = businessPlanningDevelopmentService.selectHnHistogram(projectType);
        return AjaxResult.success(returnMap);
    }
    /**
     * 规划发展（湖南表格）
     * @return 表格数据
     */
    @GetMapping("/selectHnTable")
    public AjaxResult selectHnTable(){
        List<PlanningDevelopmentVo> returnList = businessPlanningDevelopmentService.selectHnTable();
        return AjaxResult.success(returnList);
    }
    /**
     * 规划发展（市区柱状图）
     * @param projectType 项目类型
     * @param projectRegionDistrict 市级地区
     * @return 柱状图数据
     */
    @GetMapping("/selectDistrictHistogram")
    public AjaxResult selectDistrictHistogram(@RequestParam("projectType") String projectType,@RequestParam("projectRegionDistrict") String projectRegionDistrict){
        Map<String,Object> returnMap = businessPlanningDevelopmentService.selectDistrictHistogram(projectType,projectRegionDistrict);
        return AjaxResult.success(returnMap);
    }
    /**
     * 规划发展（市区表格）
     * @param projectRegionDistrict 市级地区
     * @return 表格数据
     */
    @GetMapping("/selectDistrictTable")
    public AjaxResult selectDistrictTable(@RequestParam("projectType") String projectType,@RequestParam("projectRegionDistrict") String projectRegionDistrict){
        List<Map<String,Object>> returnList = businessPlanningDevelopmentService.selectDistrictTable(projectType,projectRegionDistrict);
        return AjaxResult.success(returnList);
    }

    /**
     * 规划发展（三级菜单表格）
     * @param projectStatus 项目状态
     * @param projectRegionDistrict 项目所在地区
     * @return 表格数据
     */
    @GetMapping("/selectTableDetails")
    public AjaxResult selectTableDetails(@RequestParam("projectStatus") String projectStatus,@RequestParam("projectRegionDistrict") String projectRegionDistrict){
        Map<String,Object> returnList = businessPlanningDevelopmentService.selectTableDetails(projectStatus,projectRegionDistrict);
        return AjaxResult.success(returnList);
    }

    /**
     * 新规划发展一级菜单
     * @return 地图上全部的点信息Vo
     */
    @GetMapping("/selectHnProjects")
    public AjaxResult selectHnProjects()
    {
        List<Map<String,Object>> list = businessPlanningDevelopmentService.selectHnProjects();
        return AjaxResult.success(list);
    }

    /**
     * 新规划发展二级菜单（前期开发，已（拟）开工）
     * @param projectNumber 项目编号（项目id）
     * @param projectStatus 项目状态
     * @return 查询的数据Vo
     */
    @GetMapping("/selectProjectByStatus")
    public AjaxResult selectProjectByStatus(@RequestParam("projectNumber")Long projectNumber,@RequestParam("projectStatus")String projectStatus)
    {
        Map<String,Object> list = businessPlanningDevelopmentService.selectProjectByStatus(projectNumber,projectStatus);
        return AjaxResult.success(list);
    }

    @GetMapping("/selectProjectDetailByStatus")
    public AjaxResult selectProjectDetailByStatus(@RequestParam("projectNumber")Long projectNumber,@RequestParam("projectStatus")String projectStatus)
    {
        Map<String,Object> list = businessPlanningDevelopmentService.selectProjectDetailByStatus(projectNumber,projectStatus);
        return AjaxResult.success(list);
    }
    /**
     * 新规划发展三级菜单（已竣工）
     * @param projectNumber 项目编号（项目id）
     * @return 查询的数据Vo
     */
    @GetMapping("/selectImgFileByProjectNumber")
    public AjaxResult selectImgFileByProjectNumber(@RequestParam("projectNumber")Long projectNumber)
    {
        Map<String,Object> list = businessPlanningDevelopmentService.selectImgFileByProjectNumber(projectNumber);
        return AjaxResult.success(list);
    }
}
