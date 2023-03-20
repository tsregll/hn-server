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
import com.ruoyi.business.domain.BusinessElectricPhotovoltaic;
import com.ruoyi.business.service.IBusinessElectricPhotovoltaicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 光伏发电总貌Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/photovoltaic")
public class BusinessElectricPhotovoltaicController extends BaseController
{
    @Autowired
    private IBusinessElectricPhotovoltaicService businessElectricPhotovoltaicService;

    /**
     * 查询光伏发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:photovoltaic:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        startPage();
        List<BusinessElectricPhotovoltaic> list = businessElectricPhotovoltaicService.selectBusinessElectricPhotovoltaicList(businessElectricPhotovoltaic);
        return getDataTable(list);
    }

    /**
     * 导出光伏发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:photovoltaic:export')")
    @Log(title = "光伏发电总貌", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        List<BusinessElectricPhotovoltaic> list = businessElectricPhotovoltaicService.selectBusinessElectricPhotovoltaicList(businessElectricPhotovoltaic);
        ExcelUtil<BusinessElectricPhotovoltaic> util = new ExcelUtil<BusinessElectricPhotovoltaic>(BusinessElectricPhotovoltaic.class);
        return util.exportExcel(list, "photovoltaic");
    }

    /**
     * 获取光伏发电总貌详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:photovoltaic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessElectricPhotovoltaicService.selectBusinessElectricPhotovoltaicById(id));
    }

    /**
     * 新增光伏发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:photovoltaic:add')")
    @Log(title = "光伏发电总貌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        BusinessElectricPhotovoltaic selectBusinessElectricPhotovoltaic = new BusinessElectricPhotovoltaic();
        selectBusinessElectricPhotovoltaic.setYear(businessElectricPhotovoltaic.getYear());
        int count = businessElectricPhotovoltaicService.selectBusinessElectricPhotovoltaicList(selectBusinessElectricPhotovoltaic).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessElectricPhotovoltaicService.insertBusinessElectricPhotovoltaic(businessElectricPhotovoltaic));
    }

    /**
     * 修改光伏发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:photovoltaic:edit')")
    @Log(title = "光伏发电总貌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        return toAjax(businessElectricPhotovoltaicService.updateBusinessElectricPhotovoltaic(businessElectricPhotovoltaic));
    }

    /**
     * 删除光伏发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:photovoltaic:remove')")
    @Log(title = "光伏发电总貌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessElectricPhotovoltaicService.deleteBusinessElectricPhotovoltaicByIds(ids));
    }
}
