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
import com.ruoyi.business.domain.BusinessMonitorPoint;
import com.ruoyi.business.service.IBusinessMonitorPointService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 监控探头配置Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/monitorPoint")
public class BusinessMonitorPointController extends BaseController
{
    @Autowired
    private IBusinessMonitorPointService businessMonitorPointService;

    /**
     * 查询监控探头配置列表
     */
    @PreAuthorize("@ss.hasPermi('business:monitorPoint:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessMonitorPoint businessMonitorPoint)
    {
        startPage();
        List<BusinessMonitorPoint> list = businessMonitorPointService.selectBusinessMonitorPointList(businessMonitorPoint);
        return getDataTable(list);
    }

    /**
     * 导出监控探头配置列表
     */
    @PreAuthorize("@ss.hasPermi('business:monitorPoint:export')")
    @Log(title = "监控探头配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessMonitorPoint businessMonitorPoint)
    {
        List<BusinessMonitorPoint> list = businessMonitorPointService.selectBusinessMonitorPointList(businessMonitorPoint);
        ExcelUtil<BusinessMonitorPoint> util = new ExcelUtil<BusinessMonitorPoint>(BusinessMonitorPoint.class);
        return util.exportExcel(list, "monitorPoint");
    }

    /**
     * 获取监控探头配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:monitorPoint:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessMonitorPointService.selectBusinessMonitorPointById(id));
    }

    /**
     * 新增监控探头配置
     */
    @PreAuthorize("@ss.hasPermi('business:monitorPoint:add')")
    @Log(title = "监控探头配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessMonitorPoint businessMonitorPoint)
    {
        return toAjax(businessMonitorPointService.insertBusinessMonitorPoint(businessMonitorPoint));
    }

    /**
     * 修改监控探头配置
     */
    @PreAuthorize("@ss.hasPermi('business:monitorPoint:edit')")
    @Log(title = "监控探头配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessMonitorPoint businessMonitorPoint)
    {
        return toAjax(businessMonitorPointService.updateBusinessMonitorPoint(businessMonitorPoint));
    }

    /**
     * 删除监控探头配置
     */
    @PreAuthorize("@ss.hasPermi('business:monitorPoint:remove')")
    @Log(title = "监控探头配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessMonitorPointService.deleteBusinessMonitorPointByIds(ids));
    }
}
