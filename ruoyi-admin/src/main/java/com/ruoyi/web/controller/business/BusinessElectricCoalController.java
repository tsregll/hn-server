package com.ruoyi.web.controller.business;

import java.util.List;

import com.ruoyi.business.domain.BusinessElectricArea;
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
import com.ruoyi.business.domain.BusinessElectricCoal;
import com.ruoyi.business.service.IBusinessElectricCoalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 煤机发电总貌Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/coal")
public class BusinessElectricCoalController extends BaseController
{
    @Autowired
    private IBusinessElectricCoalService businessElectricCoalService;

    /**
     * 查询煤机发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:coal:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessElectricCoal businessElectricCoal)
    {
        startPage();
        List<BusinessElectricCoal> list = businessElectricCoalService.selectBusinessElectricCoalList(businessElectricCoal);
        return getDataTable(list);
    }

    /**
     * 导出煤机发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:coal:export')")
    @Log(title = "煤机发电总貌", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessElectricCoal businessElectricCoal)
    {
        List<BusinessElectricCoal> list = businessElectricCoalService.selectBusinessElectricCoalList(businessElectricCoal);
        ExcelUtil<BusinessElectricCoal> util = new ExcelUtil<BusinessElectricCoal>(BusinessElectricCoal.class);
        return util.exportExcel(list, "coal");
    }

    /**
     * 获取煤机发电总貌详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:coal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessElectricCoalService.selectBusinessElectricCoalById(id));
    }

    /**
     * 新增煤机发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:coal:add')")
    @Log(title = "煤机发电总貌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessElectricCoal businessElectricCoal)
    {
        BusinessElectricCoal selectBusinessElectricCoal = new BusinessElectricCoal();
        selectBusinessElectricCoal.setYear(businessElectricCoal.getYear());
        int count = businessElectricCoalService.selectBusinessElectricCoalList(selectBusinessElectricCoal).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessElectricCoalService.insertBusinessElectricCoal(businessElectricCoal));
    }

    /**
     * 修改煤机发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:coal:edit')")
    @Log(title = "煤机发电总貌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessElectricCoal businessElectricCoal)
    {
        return toAjax(businessElectricCoalService.updateBusinessElectricCoal(businessElectricCoal));
    }

    /**
     * 删除煤机发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:coal:remove')")
    @Log(title = "煤机发电总貌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessElectricCoalService.deleteBusinessElectricCoalByIds(ids));
    }
}
