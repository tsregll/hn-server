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
import com.ruoyi.business.domain.BusinessElectricWind;
import com.ruoyi.business.service.IBusinessElectricWindService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 风能发电总貌Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/wind")
public class BusinessElectricWindController extends BaseController
{
    @Autowired
    private IBusinessElectricWindService businessElectricWindService;

    /**
     * 查询风能发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:wind:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessElectricWind businessElectricWind)
    {
        startPage();
        List<BusinessElectricWind> list = businessElectricWindService.selectBusinessElectricWindList(businessElectricWind);
        return getDataTable(list);
    }

    /**
     * 导出风能发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:wind:export')")
    @Log(title = "风能发电总貌", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessElectricWind businessElectricWind)
    {
        List<BusinessElectricWind> list = businessElectricWindService.selectBusinessElectricWindList(businessElectricWind);
        ExcelUtil<BusinessElectricWind> util = new ExcelUtil<BusinessElectricWind>(BusinessElectricWind.class);
        return util.exportExcel(list, "wind");
    }

    /**
     * 获取风能发电总貌详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:wind:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessElectricWindService.selectBusinessElectricWindById(id));
    }

    /**
     * 新增风能发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:wind:add')")
    @Log(title = "风能发电总貌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessElectricWind businessElectricWind)
    {
        BusinessElectricWind selectBusinessElectricWind = new BusinessElectricWind();
        selectBusinessElectricWind.setYear(businessElectricWind.getYear());
        int count = businessElectricWindService.selectBusinessElectricWindList(selectBusinessElectricWind).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessElectricWindService.insertBusinessElectricWind(businessElectricWind));
    }

    /**
     * 修改风能发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:wind:edit')")
    @Log(title = "风能发电总貌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessElectricWind businessElectricWind)
    {
        return toAjax(businessElectricWindService.updateBusinessElectricWind(businessElectricWind));
    }

    /**
     * 删除风能发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:wind:remove')")
    @Log(title = "风能发电总貌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessElectricWindService.deleteBusinessElectricWindByIds(ids));
    }
}
