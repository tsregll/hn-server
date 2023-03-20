package com.ruoyi.web.controller.business;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.business.domain.BusinessVehicleMileage;
import com.ruoyi.business.service.IBusinessVehicleMileageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车辆里程台账Controller
 * 
 * @author xwq
 * @date 2021-03-25
 */
@RestController
//@RequestMapping("selectStaAll")
@RequestMapping("/business/mileage")
public class BusinessVehicleMileageController extends BaseController
{
    @Autowired
    private IBusinessVehicleMileageService businessVehicleMileageService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询车辆里程台账列表
     */
    @PreAuthorize("@ss.hasPermi('business:mileage:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessVehicleMileage businessVehicleMileage)
    {
        startPage();
        List<BusinessVehicleMileage> list = businessVehicleMileageService.selectBusinessVehicleMileageList(businessVehicleMileage);
        return getDataTable(list);
    }

    /**
     * 导出车辆里程台账列表
     */
    @PreAuthorize("@ss.hasPermi('business:mileage:export')")
    @Log(title = "车辆里程台账", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessVehicleMileage businessVehicleMileage)
    {
        List<BusinessVehicleMileage> list = businessVehicleMileageService.selectBusinessVehicleMileageList(businessVehicleMileage);
        ExcelUtil<BusinessVehicleMileage> util = new ExcelUtil<>(BusinessVehicleMileage.class);
        return util.exportExcel(list, "mileage");
    }

    /**
     * 获取车辆里程台账详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:mileage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessVehicleMileageService.selectBusinessVehicleMileageById(id));
    }

    /**
     * 新增车辆里程台账
     */
    @PreAuthorize("@ss.hasPermi('business:mileage:add')")
    @Log(title = "车辆里程台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessVehicleMileage businessVehicleMileage)
    {
        BusinessVehicleMileage bvm = new BusinessVehicleMileage();
        bvm.setLicensePlateNumber(businessVehicleMileage.getLicensePlateNumber());
        bvm.setVehicleyear(businessVehicleMileage.getVehicleyear());
        bvm.setVehiclemonth(businessVehicleMileage.getVehiclemonth());
        int count = businessVehicleMileageService.selectBusinessVehicleMileageList(bvm).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessVehicleMileageService.insertVehicleMileage(businessVehicleMileage));
//        return toAjax(businessVehicleMileageService.insertBusinessVehicleMileage(businessVehicleMileage));
    }

    /**
     * 修改车辆里程台账
     */
    @PreAuthorize("@ss.hasPermi('business:mileage:edit')")
    @Log(title = "车辆里程台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessVehicleMileage businessVehicleMileage)
    {
        return toAjax(businessVehicleMileageService.updateBusinessVehicleMileage(businessVehicleMileage));
    }

    /**
     * 删除车辆里程台账
     */
    @PreAuthorize("@ss.hasPermi('business:mileage:remove')")
    @Log(title = "车辆里程台账", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessVehicleMileageService.deleteBusinessVehicleMileageByIds(ids));
    }

    /**
     * 车辆台账模板下载
     * @return
     */
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<BusinessVehicleMileage> util = new ExcelUtil<>(BusinessVehicleMileage.class);
        return util.importTemplateExcel("车辆里程台账模板");
    }


    @Log(title = "车辆台账导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('business:mileage:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception {
        ExcelUtil<BusinessVehicleMileage> util = new ExcelUtil<>(BusinessVehicleMileage.class);
        List<BusinessVehicleMileage> businessVehicleMileages = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = businessVehicleMileageService.importData(businessVehicleMileages,operName);
        return AjaxResult.success(message);
    }
}
