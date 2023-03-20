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
import com.ruoyi.business.domain.BusinessVehicleInformation;
import com.ruoyi.business.service.IBusinessVehicleInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 车辆字典Controller
 * 
 * @author ruoyi
 * @date 2021-04-22
 */
@RestController
@RequestMapping("/business/vehicleinformation")
public class BusinessVehicleInformationController extends BaseController
{
    @Autowired
    private IBusinessVehicleInformationService businessVehicleInformationService;

    /**
     * 查询车辆字典列表
     */
    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:list')")
    @GetMapping("/list")
    public AjaxResult list(BusinessVehicleInformation businessVehicleInformation)
    {
        List<BusinessVehicleInformation> list = businessVehicleInformationService.selectBusinessVehicleInformationList(businessVehicleInformation);
        return AjaxResult.success(list);
    }
    /**
     * 导出车辆字典列表
     */
    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:export')")
    @Log(title = "车辆字典", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessVehicleInformation businessVehicleInformation)
    {
        List<BusinessVehicleInformation> list = businessVehicleInformationService.selectBusinessVehicleInformationList(businessVehicleInformation);
        ExcelUtil<BusinessVehicleInformation> util = new ExcelUtil<BusinessVehicleInformation>(BusinessVehicleInformation.class);
        return util.exportExcel(list, "vehicleinformation");
    }

    /**
     * 获取车辆字典详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessVehicleInformationService.selectBusinessVehicleInformationById(id));
    }

    /**
     * 新增车辆字典
     */
    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:add')")
    @Log(title = "车辆字典", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessVehicleInformation businessVehicleInformation)
    {
        return toAjax(businessVehicleInformationService.insertBusinessVehicleInformation(businessVehicleInformation));
    }

    /**
     * 修改车辆字典
     */
    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:edit')")
    @Log(title = "车辆字典", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessVehicleInformation businessVehicleInformation)
    {
        return toAjax(businessVehicleInformationService.updateBusinessVehicleInformation(businessVehicleInformation));
    }

    /**
     * 删除车辆字典
     */
    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:remove')")
    @Log(title = "车辆字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessVehicleInformationService.deleteBusinessVehicleInformationByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('business:vehicleinformation:selectData')")
    @GetMapping("/selectData")
    public AjaxResult selectData(BusinessVehicleInformation businessVehicleInformation)
    {
        List<BusinessVehicleInformation> list = businessVehicleInformationService.selectVehicleInformationData(businessVehicleInformation);
        return AjaxResult.success(list);
    }
}
