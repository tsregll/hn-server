package com.ruoyi.web.controller.business;

import java.io.IOException;
import java.util.List;

import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.ServerConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectFile;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentProjectFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展项目文件后台Controller
 * 
 * @author yrb
 * @date 2021-04-28
 */
@RestController
@RequestMapping("/business/planningdevelopmentfile")
public class BusinessPlanningDevelopmentProjectFileController extends BaseController
{
    @Autowired
    private IBusinessPlanningDevelopmentProjectFileService businessPlanningDevelopmentProjectFileService;

    /**
     * 查询规划发展项目文件后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentfile:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        startPage();
        List<BusinessPlanningDevelopmentProjectFile> list = businessPlanningDevelopmentProjectFileService.selectBusinessPlanningDevelopmentProjectFileList(businessPlanningDevelopmentProjectFile);
        return getDataTable(list);
    }

    /**
     * 查询规划发展项目文件后台列表
     */
    @GetMapping("/getProjectDate")
    public AjaxResult getProjectDateByList(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        String projectDate = null;
        List<BusinessPlanningDevelopmentProjectFile> list = businessPlanningDevelopmentProjectFileService.selectBusinessPlanningDevelopmentProjectFileList(businessPlanningDevelopmentProjectFile);
        if(list.size()>0){
            for(BusinessPlanningDevelopmentProjectFile temp:list){
                if(temp.getProjectDate()!=null){
                    projectDate = temp.getProjectDate();
                    return AjaxResult.success(projectDate);
                }
            }
        }
        return AjaxResult.success(projectDate);
    }

    /**
     * 导出规划发展项目文件后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentfile:export')")
    @Log(title = "规划发展项目文件后台", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        List<BusinessPlanningDevelopmentProjectFile> list = businessPlanningDevelopmentProjectFileService.selectBusinessPlanningDevelopmentProjectFileList(businessPlanningDevelopmentProjectFile);
        ExcelUtil<BusinessPlanningDevelopmentProjectFile> util = new ExcelUtil<BusinessPlanningDevelopmentProjectFile>(BusinessPlanningDevelopmentProjectFile.class);
        return util.exportExcel(list, "planningdevelopmentfile");
    }

    /**
     * 获取规划发展项目文件后台详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentfile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessPlanningDevelopmentProjectFileService.selectBusinessPlanningDevelopmentProjectFileById(id));
    }

    /**
     * 新增规划发展项目文件后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentfile:add')")
    @Log(title = "规划发展项目文件后台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        return toAjax(businessPlanningDevelopmentProjectFileService.insertBusinessPlanningDevelopmentProjectFile(businessPlanningDevelopmentProjectFile));
    }

    /**
     * 修改规划发展项目文件后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentfile:edit')")
    @Log(title = "规划发展项目文件后台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        return toAjax(businessPlanningDevelopmentProjectFileService.updateBusinessPlanningDevelopmentProjectFile(businessPlanningDevelopmentProjectFile));
    }

    /**
     * 删除规划发展项目文件后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentfile:remove')")
    @Log(title = "规划发展项目文件后台", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessPlanningDevelopmentProjectFileService.deleteBusinessPlanningDevelopmentProjectFileByIds(ids));
    }
    /**
     * 查询规划发展项目文件后台列表
     */
    @GetMapping("/selectFinalProjectList")
    public TableDataInfo selectFinalProjectList()
    {
        List<BusinessPlanningDevelopment> list = businessPlanningDevelopmentProjectFileService.selectFinalProjectList();
        return getDataTable(list);
    }
    /**
     * 查询图片文件未满5个的项目列表
     */
    @GetMapping("/selectFileInsProjectList")
    public TableDataInfo selectFileInsProjectList()
    {
        List<BusinessPlanningDevelopment> list = businessPlanningDevelopmentProjectFileService.selectFileInsProjectList();
        return getDataTable(list);
    }
    /**
     * 车辆图片上传
     */
    @Log(title = "已投产项目图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/finalProjectFileUpload")
    public AjaxResult finalProjectFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("projectDate")String projectDate, @RequestParam("projectNumber")String projectNumber, @RequestParam("projectFileIllustration")String projectFileIllustration) throws IOException {
        return businessPlanningDevelopmentProjectFileService.finalProjectFileUpload(file, projectDate,projectNumber, projectFileIllustration);
    }
}
