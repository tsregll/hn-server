package com.ruoyi.web.controller.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.vo.BusinessInstallationStatisticsVo;
import com.ruoyi.business.vo.StatisticsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessInstallationStatistics;
import com.ruoyi.business.service.IBusinessInstallationStatisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 装机统计Controller
 * 
 * @author yrb
 * @date 2021-03-10
 */
@Api(value = "BusinessInstallationStatisticsController", tags = "装机统计接口")
@RestController
@RequestMapping("/business/businessInstallationStatistics")
public class BusinessInstallationStatisticsController extends BaseController
{
    @Autowired
    private IBusinessInstallationStatisticsService businessInstallationStatisticsService;

    /**
     * 查询装机统计列表
     */
    @ApiOperation(value = "查询装机统计列表")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessInstallationStatistics businessInstallationStatistics)
    {
        startPage();
//        List<BusinessInstallationStatistics> list = businessInstallationStatisticsService.selectBusinessInstallationStatisticsList(businessInstallationStatistics);
        List<BusinessInstallationStatistics> list = businessInstallationStatisticsService.selectByTimeInstallationStatisticsList(businessInstallationStatistics);
        return getDataTable(list);
    }

    /**
     * 导出装机统计列表
     */
    @ApiOperation(value = "导出装机统计列表")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:export')")
    @Log(title = "装机统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessInstallationStatistics businessInstallationStatistics)
    {
        List<BusinessInstallationStatistics> list = businessInstallationStatisticsService.selectByTimeInstallationStatisticsList(businessInstallationStatistics);
        ExcelUtil<BusinessInstallationStatistics> util = new ExcelUtil<BusinessInstallationStatistics>(BusinessInstallationStatistics.class);
        return util.exportExcel(list, "statistics");
    }
    /**
     * 获取装机统计详细信息
     */
    @ApiOperation(value = "获取装机统计详细信息")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessInstallationStatisticsService.selectBusinessInstallationStatisticsById(id));
    }

    /**
     * 新增装机统计
     */
    @ApiOperation(value = "新增装机统计")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:add')")
    @Log(title = "装机统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessInstallationStatistics businessInstallationStatistics)
    {
        BusinessInstallationStatistics bs = new BusinessInstallationStatistics();
        bs.setEnteringDate(businessInstallationStatistics.getEnteringDate());
        bs.setInstallationType(businessInstallationStatistics.getInstallationType());
        int count = businessInstallationStatisticsService.selectBusinessInstallationStatisticsList(bs).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessInstallationStatisticsService.insertBusinessInstallationStatistics(businessInstallationStatistics));
    }

    /**
     * 修改装机统计
     */
    @ApiOperation(value = "修改装机统计")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:edit')")
    @Log(title = "装机统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessInstallationStatistics businessInstallationStatistics)
    {
        return toAjax(businessInstallationStatisticsService.updateBusinessInstallationStatistics(businessInstallationStatistics));
    }

    /**
     * 删除装机统计
     */
    @ApiOperation(value = "删除装机统计")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:remove')")
    @Log(title = "装机统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessInstallationStatisticsService.deleteBusinessInstallationStatisticsByIds(ids));
    }

    /**
     * 装机统计表（月度表格）
     */
    @GetMapping("/selectStatistics")
    @ApiOperation(value = "装机统计表（月度表格）")
    public AjaxResult selectStatistics(BusinessInstallationStatistics businessInstallationStatistics)
    {
        Map<String,Object> list = businessInstallationStatisticsService.selectStatistics(businessInstallationStatistics);
        return AjaxResult.success(list);
    }
    /**
     * 近5年装机容量分析表
     */
    @GetMapping("/fiveInstallationStatistics")
    @ApiOperation(value = "近5年装机容量分析表")
    public AjaxResult fiveInstallationStatistics(BusinessInstallationStatistics bs)
    {
        Map<String,Object> vo = businessInstallationStatisticsService.selectFiveInstallationStatisticsByYear(bs);
        return AjaxResult.success(vo);
    }
    /**
     * 条件查询统计（饼状图）
     */
    @GetMapping("/selectByYearOrType")
    @ApiOperation(value = "条件查询统计（饼状图）")
    public AjaxResult selectByYearOrType(BusinessInstallationStatistics businessInstallationStatistics)
    {
        Map<String,Object> statisticsVo = businessInstallationStatisticsService.selectByYearOrType(businessInstallationStatistics);
        return AjaxResult.success(statisticsVo);
    }
    /**
     * 导出装机统计列表
     */
    @ApiOperation(value = "导入装机统计")
    @Log(title = "装机统计", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:businessInstallationStatistics:import')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<BusinessInstallationStatistics> util = new ExcelUtil<BusinessInstallationStatistics>(BusinessInstallationStatistics.class);
        List<BusinessInstallationStatistics> bis = util.importExcel(file.getInputStream());
        String message = businessInstallationStatisticsService.importDatas(bis);
        return AjaxResult.success(message);
    }
/*
    @ApiOperation(value = "装机统计模板")
    @GetMapping("/importBusinessInstallationStatistics")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessInstallationStatistics> util = new ExcelUtil<BusinessInstallationStatistics>(BusinessInstallationStatistics.class);
        return util.importTemplateExcel("装机统计模板");
    }*/

    @ApiOperation(value = "装机统计模板")
    @GetMapping("/importBusinessInstallationStatistics")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessInstallationStatistics> util = new ExcelUtil<BusinessInstallationStatistics>(BusinessInstallationStatistics.class);
        List<BusinessInstallationStatistics> list =new ArrayList<>();
        for (Integer group = 0; group <3 ; group++) {
            BusinessInstallationStatistics bet = new BusinessInstallationStatistics();
            String name = group.toString();
            bet.setInstallationType(name);
            list.add(bet);
        }
        return util.exportExcel(list,"装机统计模板");
    }
}
