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
import com.ruoyi.business.domain.BusinessElectricWater;
import com.ruoyi.business.service.IBusinessElectricWaterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水力发电总貌Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/water")
public class BusinessElectricWaterController extends BaseController
{
    @Autowired
    private IBusinessElectricWaterService businessElectricWaterService;

    /**
     * 查询水力发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:water:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessElectricWater businessElectricWater)
    {
        startPage();
        List<BusinessElectricWater> list = businessElectricWaterService.selectBusinessElectricWaterList(businessElectricWater);
        return getDataTable(list);
    }

    /**
     * 导出水力发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:water:export')")
    @Log(title = "水力发电总貌", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessElectricWater businessElectricWater)
    {
        List<BusinessElectricWater> list = businessElectricWaterService.selectBusinessElectricWaterList(businessElectricWater);
        ExcelUtil<BusinessElectricWater> util = new ExcelUtil<BusinessElectricWater>(BusinessElectricWater.class);
        return util.exportExcel(list, "water");
    }

    /**
     * 获取水力发电总貌详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:water:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessElectricWaterService.selectBusinessElectricWaterById(id));
    }

    /**
     * 新增水力发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:water:add')")
    @Log(title = "水力发电总貌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessElectricWater businessElectricWater)
    {
        BusinessElectricWater selectBusinessElectricWater = new BusinessElectricWater();
        selectBusinessElectricWater.setYear(businessElectricWater.getYear());
        int count = businessElectricWaterService.selectBusinessElectricWaterList(selectBusinessElectricWater).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessElectricWaterService.insertBusinessElectricWater(businessElectricWater));
    }

    /**
     * 修改水力发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:water:edit')")
    @Log(title = "水力发电总貌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessElectricWater businessElectricWater)
    {
        return toAjax(businessElectricWaterService.updateBusinessElectricWater(businessElectricWater));
    }

    /**
     * 删除水力发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:water:remove')")
    @Log(title = "水力发电总貌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessElectricWaterService.deleteBusinessElectricWaterByIds(ids));
    }
}
