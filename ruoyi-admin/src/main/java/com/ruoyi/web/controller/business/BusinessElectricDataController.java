package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.BusinessAuditForm;
import com.ruoyi.business.domain.BusinessElectricData;
import com.ruoyi.business.service.IBusinessAuditFormService;
import com.ruoyi.business.service.IBusinessElectricDataService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.ElectricDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用电数据Controller
 *
 * @author ruoyi
 * @date 2021-02-26
 */
@RestController
@RequestMapping("/business/electricData")
public class BusinessElectricDataController extends BaseController {
    @Autowired
    private IBusinessElectricDataService businessElectricDataService;
    @Autowired
    private IBusinessAuditFormService businessAuditFormService;

    /**
     * 查询用电数据列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BusinessElectricData businessElectricData) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        startPage();
        businessElectricData.setCreateBy(loginUser.getUsername());
        List<BusinessElectricData> list = businessElectricDataService.selectBusinessElectricDataList(businessElectricData);
        for (BusinessElectricData electricData : list) {
            BusinessAuditForm businessAuditForm = businessAuditFormService.selectBusinessAuditFormByDataId(electricData.getId());
            if (businessAuditForm != null) {
                electricData.setStatus(businessAuditForm.getStatus());
            }
        }
        return getDataTable(list);
    }


    /**
     * 获取用电数据详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        BusinessElectricData businessElectricData = businessElectricDataService.selectBusinessElectricDataById(id);
        result.put("businessElectricData", businessElectricData);
        BusinessAuditForm businessAuditForm = businessAuditFormService.selectBusinessAuditFormByDataId(businessElectricData.getId());
        if (businessAuditForm != null) {
            result.put("businessAuditForm", businessAuditForm);
        }
        return AjaxResult.success(result);
    }

    /**
     * 新增用电数据
     */
    @Log(title = "用电数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ElectricDataVo vo) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        BusinessElectricData businessElectricData = new BusinessElectricData();
        businessElectricData.setLoads(vo.getLoads());
        businessElectricData.setFees(vo.getFees());
        businessElectricData.setMonth(vo.getMonth());
        businessElectricData.setTotal(vo.getTotal());
        businessElectricData.setYear(vo.getYear());
        businessElectricData.setCreateBy(loginUser.getUsername());
        businessElectricData.setCreateTime(new Date());
        businessElectricData.setUpdateBy(loginUser.getUsername());
        businessElectricData.setUpdateTime(new Date());
        businessElectricData.setStatus("1");
        // 保存基础数据
        businessElectricDataService.insertBusinessElectricData(businessElectricData);
        // 保存审核数据
        BusinessAuditForm businessAuditForm = new BusinessAuditForm();
        businessAuditForm.setDataId(businessElectricData.getId());
        businessAuditForm.setDataType(BusinessElectricData.class.getSimpleName());
        businessAuditForm.setStatus("1");
        businessAuditForm.setDeptUserId(vo.getDeptUserId());
        businessAuditForm.setDeptUserName(vo.getDeptUserName());
        businessAuditForm.setChargeUserId(vo.getChargeUserId());
        businessAuditForm.setChargeUserName(vo.getChargeUserName());
        businessAuditForm.setKeyUserId(vo.getKeyUserId());
        businessAuditForm.setKeyUserName(vo.getKeyUserName());
        businessAuditForm.setSubmitUserId(loginUser.getUser().getUserId());
        businessAuditForm.setSubmitUserName(loginUser.getUsername());
        businessAuditForm.setCreateBy(loginUser.getUsername());
        businessAuditForm.setCreateTime(new Date());
        businessAuditForm.setUpdateBy(loginUser.getUsername());
        businessAuditForm.setUpdateTime(new Date());
        int result = businessAuditFormService.insertBusinessAuditForm(businessAuditForm);
        return toAjax(result);
    }

    /**
     * 修改用电数据
     */
    @Log(title = "用电数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessElectricData businessElectricData) {
        return toAjax(businessElectricDataService.updateBusinessElectricData(businessElectricData));
    }

    /**
     * 删除用电数据
     */
    @Log(title = "用电数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessElectricDataService.deleteBusinessElectricDataByIds(ids));
    }
}
