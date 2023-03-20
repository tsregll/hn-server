package com.ruoyi.web.controller.business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessAuditForm;
import com.ruoyi.business.domain.BusinessElectricData;
import com.ruoyi.business.service.IBusinessAuditFormService;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.business.domain.BusinessDisciplinaryManage;
import com.ruoyi.business.service.IBusinessDisciplinaryManageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 纪检管理Controller
 *
 * @author gwsh
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/disciplinary")
public class BusinessDisciplinaryManageController extends BaseController {
    @Autowired
    private IBusinessDisciplinaryManageService businessDisciplinaryManageService;
    @Autowired
    private IBusinessAuditFormService businessAuditFormService;

    /**
     * 查询纪检管理列表
     */
    @PreAuthorize("@ss.hasPermi('business:disciplinary:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDisciplinaryManage businessDisciplinaryManage) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessDisciplinaryManage.setCreateBy(loginUser.getUsername());
        startPage();
        List<BusinessDisciplinaryManage> list = businessDisciplinaryManageService.selectBusinessDisciplinaryManageList(businessDisciplinaryManage);
        for (BusinessDisciplinaryManage item : list) {
            BusinessAuditForm businessAuditForm = businessAuditFormService.selectBusinessAuditFormByDataId(item.getId());
            if (businessAuditForm != null) {
                item.setStatus(businessAuditForm.getStatus());
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出纪检管理列表
     */
    @PreAuthorize("@ss.hasPermi('business:disciplinary:export')")
    @Log(title = "纪检管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDisciplinaryManage businessDisciplinaryManage) {
        List<BusinessDisciplinaryManage> list = businessDisciplinaryManageService.selectBusinessDisciplinaryManageList(businessDisciplinaryManage);
        ExcelUtil<BusinessDisciplinaryManage> util = new ExcelUtil<BusinessDisciplinaryManage>(BusinessDisciplinaryManage.class);
        return util.exportExcel(list, "disciplinary");
    }

    /**
     * 获取纪检管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:disciplinary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        BusinessDisciplinaryManage businessDisciplinaryManageData = businessDisciplinaryManageService.selectBusinessDisciplinaryManageById(id);
        result.put("businessDisciplinaryManageData", businessDisciplinaryManageData);
        BusinessAuditForm businessAuditForm = businessAuditFormService.selectBusinessAuditFormByDataId(businessDisciplinaryManageData.getId());
        if (businessAuditForm != null) {
            result.put("businessAuditForm", businessAuditForm);
        }
        return AjaxResult.success(result);
    }

    /**
     * 新增纪检管理
     */
    @PreAuthorize("@ss.hasPermi('business:disciplinary:add')")
    @Log(title = "纪检管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDisciplinaryManage businessDisciplinaryManage) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessDisciplinaryManage.setCreateBy(loginUser.getUsername());
        businessDisciplinaryManage.setCreateTime(new Date());
        businessDisciplinaryManage.setUpdateBy(loginUser.getUsername());
        businessDisciplinaryManage.setUpdateTime(new Date());
        businessDisciplinaryManage.setStatus("1");
        // 保存基本数据
        int result = businessDisciplinaryManageService.insertBusinessDisciplinaryManage(businessDisciplinaryManage);
        // 保存审核数据
//        BusinessAuditForm businessAuditForm = new BusinessAuditForm();
//        businessAuditForm.setDataId(businessDisciplinaryManage.getId());
//        businessAuditForm.setDataType(BusinessDisciplinaryManage.class.getSimpleName());
//        businessAuditForm.setStatus("1");
////        businessAuditForm.setDeptUserId(businessAuditForm);
////        businessAuditForm.setDeptUserName(vo.getDeptUserName());
//        businessAuditForm.setChargeUserId(vo.getChargeUserId());
//        businessAuditForm.setChargeUserName(vo.getChargeUserName());
//        businessAuditForm.setKeyUserId(vo.getKeyUserId());
//        businessAuditForm.setKeyUserName(vo.getKeyUserName());
//        businessAuditForm.setSubmitUserId(loginUser.getUser().getUserId());
//        businessAuditForm.setSubmitUserName(loginUser.getUsername());
//        businessAuditForm.setCreateBy(loginUser.getUsername());
//        businessAuditForm.setCreateTime(new Date());
//        businessAuditForm.setUpdateBy(loginUser.getUsername());
//        businessAuditForm.setUpdateTime(new Date());
//        int result = businessAuditFormService.insertBusinessAuditForm(businessAuditForm);
        return toAjax(result);
    }

    /**
     * 修改纪检管理
     */
    @PreAuthorize("@ss.hasPermi('business:disciplinary:edit')")
    @Log(title = "纪检管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDisciplinaryManage businessDisciplinaryManage) {
        return toAjax(businessDisciplinaryManageService.updateBusinessDisciplinaryManage(businessDisciplinaryManage));
    }

    /**
     * 删除纪检管理
     */
    @PreAuthorize("@ss.hasPermi('business:disciplinary:remove')")
    @Log(title = "纪检管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessDisciplinaryManageService.deleteBusinessDisciplinaryManageByIds(ids));
    }
}
