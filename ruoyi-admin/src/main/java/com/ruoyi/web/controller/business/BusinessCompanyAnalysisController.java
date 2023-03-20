package com.ruoyi.business.controller;

import java.util.List;
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
import com.ruoyi.business.domain.BusinessCompanyAnalysis;
import com.ruoyi.business.service.IBusinessCompanyAnalysisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 清能公司分析指标Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/companyAnalysis")
public class BusinessCompanyAnalysisController extends BaseController
{
    @Autowired
    private IBusinessCompanyAnalysisService businessCompanyAnalysisService;

    /**
     * 查询清能公司分析指标列表
     */
    @PreAuthorize("@ss.hasPermi('business:companyAnalysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        startPage();
        List<BusinessCompanyAnalysis> list = businessCompanyAnalysisService.selectBusinessCompanyAnalysisList(businessCompanyAnalysis);
        return getDataTable(list);
    }

    /**
     * 导出清能公司分析指标列表
     */
    @PreAuthorize("@ss.hasPermi('business:companyAnalysis:export')")
    @Log(title = "清能公司分析指标", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        List<BusinessCompanyAnalysis> list = businessCompanyAnalysisService.selectBusinessCompanyAnalysisList(businessCompanyAnalysis);
        ExcelUtil<BusinessCompanyAnalysis> util = new ExcelUtil<BusinessCompanyAnalysis>(BusinessCompanyAnalysis.class);
        return util.exportExcel(list, "companyAnalysis");
    }

    /**
     * 获取清能公司分析指标详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:companyAnalysis:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessCompanyAnalysisService.selectBusinessCompanyAnalysisById(id));
    }

    /**
     * 新增清能公司分析指标
     */
    @PreAuthorize("@ss.hasPermi('business:companyAnalysis:add')")
    @Log(title = "清能公司分析指标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        return toAjax(businessCompanyAnalysisService.insertBusinessCompanyAnalysis(businessCompanyAnalysis));
    }

    /**
     * 修改清能公司分析指标
     */
    @PreAuthorize("@ss.hasPermi('business:companyAnalysis:edit')")
    @Log(title = "清能公司分析指标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        return toAjax(businessCompanyAnalysisService.updateBusinessCompanyAnalysis(businessCompanyAnalysis));
    }

    /**
     * 删除清能公司分析指标
     */
    @PreAuthorize("@ss.hasPermi('business:companyAnalysis:remove')")
    @Log(title = "清能公司分析指标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessCompanyAnalysisService.deleteBusinessCompanyAnalysisByIds(ids));
    }
}
