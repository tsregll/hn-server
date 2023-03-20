package com.ruoyi.web.controller.business;

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
import com.ruoyi.business.domain.BusinessCompanyStatistics;
import com.ruoyi.business.service.IBusinessCompanyStatisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 清能公司统计指标Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/statistics")
public class BusinessCompanyStatisticsController extends BaseController
{
    @Autowired
    private IBusinessCompanyStatisticsService businessCompanyStatisticsService;

    /**
     * 查询清能公司统计指标列表
     */
    @PreAuthorize("@ss.hasPermi('business:statistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessCompanyStatistics businessCompanyStatistics)
    {
        startPage();
        List<BusinessCompanyStatistics> list = businessCompanyStatisticsService.selectBusinessCompanyStatisticsList(businessCompanyStatistics);
        return getDataTable(list);
    }

    /**
     * 导出清能公司统计指标列表
     */
    @PreAuthorize("@ss.hasPermi('business:statistics:export')")
    @Log(title = "清能公司统计指标", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessCompanyStatistics businessCompanyStatistics)
    {
        List<BusinessCompanyStatistics> list = businessCompanyStatisticsService.selectBusinessCompanyStatisticsList(businessCompanyStatistics);
        ExcelUtil<BusinessCompanyStatistics> util = new ExcelUtil<BusinessCompanyStatistics>(BusinessCompanyStatistics.class);
        return util.exportExcel(list, "statistics");
    }

    /**
     * 获取清能公司统计指标详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:statistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessCompanyStatisticsService.selectBusinessCompanyStatisticsById(id));
    }

    /**
     * 新增清能公司统计指标
     */
    @PreAuthorize("@ss.hasPermi('business:statistics:add')")
    @Log(title = "清能公司统计指标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessCompanyStatistics businessCompanyStatistics)
    {
        return toAjax(businessCompanyStatisticsService.insertBusinessCompanyStatistics(businessCompanyStatistics));
    }

    /**
     * 修改清能公司统计指标
     */
    @PreAuthorize("@ss.hasPermi('business:statistics:edit')")
    @Log(title = "清能公司统计指标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessCompanyStatistics businessCompanyStatistics)
    {
        return toAjax(businessCompanyStatisticsService.updateBusinessCompanyStatistics(businessCompanyStatistics));
    }

    /**
     * 删除清能公司统计指标
     */
    @PreAuthorize("@ss.hasPermi('business:statistics:remove')")
    @Log(title = "清能公司统计指标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessCompanyStatisticsService.deleteBusinessCompanyStatisticsByIds(ids));
    }
}
