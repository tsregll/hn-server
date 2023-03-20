package com.ruoyi.web.controller.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessAdministrativeVehicle;
import com.ruoyi.business.service.IBusinessAdministrativeVehicleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 车辆管理
 * Controller
 *
 * @author gwsh
 * @date 2021-03-03
 */
@RestController
@RequestMapping("/business/vehicle")
public class BusinessAdministrativeVehicleController extends BaseController {
    @Autowired
    private IBusinessAdministrativeVehicleService businessAdministrativeVehicleService;

    /**
     * 查询车辆管理
     * 列表
     */
    @PreAuthorize("@ss.hasPermi('business:vehicle:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessAdministrativeVehicle businessAdministrativeVehicle) {
        startPage();
        List<BusinessAdministrativeVehicle> list = businessAdministrativeVehicleService.selectOrderByMileageAdministrativeVehicleList(businessAdministrativeVehicle);
        return getDataTable(list);
    }

    /**
     * 查询车辆管理
     * 列表
     */
//    @PreAuthorize("@ss.hasPermi('business:vehicle:list')")
    @GetMapping("/selectFiveList")
    public TableDataInfo selectFiveList(BusinessAdministrativeVehicle businessAdministrativeVehicle) {
        startPage();
        List<BusinessAdministrativeVehicle> list = businessAdministrativeVehicleService.selectOrderByMileageAdministrativeVehicleList(businessAdministrativeVehicle);
        if(list.size()>5){
            List<BusinessAdministrativeVehicle> returnList = new ArrayList<>();
            for (int i = 0; i <5 ; i++) {
                returnList.add(list.get(i));
            }
            return getDataTable(returnList);
        }
        return getDataTable(list);
    }

    /**
     * 导出车辆管理列表
     */
    @PreAuthorize("@ss.hasPermi('business:vehicle:export')")
    @Log(title = "车辆管理 ", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessAdministrativeVehicle businessAdministrativeVehicle) {
        List<BusinessAdministrativeVehicle> list = businessAdministrativeVehicleService.selectBusinessAdministrativeVehicleList(businessAdministrativeVehicle);
        ExcelUtil<BusinessAdministrativeVehicle> util = new ExcelUtil<BusinessAdministrativeVehicle>(BusinessAdministrativeVehicle.class);
        return util.exportExcel(list, "vehicle");
    }

    /**
     * 获取车辆管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:vehicle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessAdministrativeVehicleService.selectBusinessAdministrativeVehicleById(id));
    }

    /**
     * 新增车辆管理
     */
    @PreAuthorize("@ss.hasPermi('business:vehicle:add')")
    @Log(title = "车辆管理 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessAdministrativeVehicle businessAdministrativeVehicle) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessAdministrativeVehicle.setCreateBy(loginUser.getUsername());
        businessAdministrativeVehicle.setCreateTime(new Date());
        businessAdministrativeVehicle.setUpdateBy(loginUser.getUsername());
        businessAdministrativeVehicle.setUpdateTime(new Date());
        businessAdministrativeVehicle.setStatus("1");
        return toAjax(businessAdministrativeVehicleService.insertBusinessAdministrativeVehicle(businessAdministrativeVehicle));
    }

    /**
     * 修改车辆管理
     */
    @PreAuthorize("@ss.hasPermi('business:vehicle:edit')")
    @Log(title = "车辆管理 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAdministrativeVehicle businessAdministrativeVehicle) {
        return toAjax(businessAdministrativeVehicleService.updateBusinessAdministrativeVehicle(businessAdministrativeVehicle));
    }

    /**
     * 删除车辆管理
     */
    @PreAuthorize("@ss.hasPermi('business:vehicle:remove')")
    @Log(title = "车辆管理 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessAdministrativeVehicleService.deleteBusinessAdministrativeVehicleByIds(ids));
    }

    /**
     * 车辆图片上传
     */
    @Log(title = "车辆图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/vehicleFileUpload")
    public AjaxResult vehicleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("licensePlateNumber")String licensePlateNumber,@RequestParam("id")Long id) throws IOException {
        return businessAdministrativeVehicleService.vehicleFileUpload(file, licensePlateNumber, id);
    }

}
