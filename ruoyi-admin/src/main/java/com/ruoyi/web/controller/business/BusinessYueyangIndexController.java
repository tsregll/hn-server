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
import com.ruoyi.business.domain.BusinessYueyangIndex;
import com.ruoyi.business.service.IBusinessYueyangIndexService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 岳阳电厂年度指标录入Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/yueyangIndex")
public class BusinessYueyangIndexController extends BaseController
{
    @Autowired
    private IBusinessYueyangIndexService businessYueyangIndexService;

    /**
     * 查询岳阳电厂年度指标录入列表
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangIndex:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessYueyangIndex businessYueyangIndex)
    {
        startPage();
        List<BusinessYueyangIndex> list = businessYueyangIndexService.selectBusinessYueyangIndexList(businessYueyangIndex);
        return getDataTable(list);
    }

    /**
     * 导出岳阳电厂年度指标录入列表
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangIndex:export')")
    @Log(title = "岳阳电厂年度指标录入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessYueyangIndex businessYueyangIndex)
    {
        List<BusinessYueyangIndex> list = businessYueyangIndexService.selectBusinessYueyangIndexList(businessYueyangIndex);
        ExcelUtil<BusinessYueyangIndex> util = new ExcelUtil<BusinessYueyangIndex>(BusinessYueyangIndex.class);
        return util.exportExcel(list, "yueyangIndex");
    }

    /**
     * 获取岳阳电厂年度指标录入详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangIndex:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessYueyangIndexService.selectBusinessYueyangIndexById(id));
    }

    /**
     * 新增岳阳电厂年度指标录入
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangIndex:add')")
    @Log(title = "岳阳电厂年度指标录入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessYueyangIndex businessYueyangIndex)
    {
        return toAjax(businessYueyangIndexService.insertBusinessYueyangIndex(businessYueyangIndex));
    }

    /**
     * 修改岳阳电厂年度指标录入
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangIndex:edit')")
    @Log(title = "岳阳电厂年度指标录入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessYueyangIndex businessYueyangIndex)
    {
        return toAjax(businessYueyangIndexService.updateBusinessYueyangIndex(businessYueyangIndex));
    }

    /**
     * 删除岳阳电厂年度指标录入
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangIndex:remove')")
    @Log(title = "岳阳电厂年度指标录入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessYueyangIndexService.deleteBusinessYueyangIndexByIds(ids));
    }
}
