package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.BusinessAuditForm;
import com.ruoyi.business.domain.BusinessElectricData;
import com.ruoyi.business.service.IBusinessAuditFormService;
import com.ruoyi.business.service.IBusinessElectricDataService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.AuditFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 部门审批流程Controller
 *
 * @author ruoyi
 * @date 2021-02-26
 */
@RestController
@RequestMapping("/business/audit")
public class BusinessAuditFormController extends BaseController {
    @Autowired
    private IBusinessAuditFormService businessAuditFormService;
    @Autowired
    private IBusinessElectricDataService businessElectricDataService;

    /**
     * 我的待审批列表
     */
    @GetMapping("/my-auditing")
    public TableDataInfo myAuditing(BusinessAuditForm businessAuditForm) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<String> keyCodes = loginUser.getUser().getRoles().stream().map(SysRole::getRoleKey).collect(Collectors.toList());
        startPage();
        List<BusinessAuditForm> list = businessAuditFormService.myAuditingByRokeKey(loginUser.getUser().getUserId(), keyCodes.get(0), businessAuditForm);
        return getDataTable(list);
    }

    /**
     * 我的已审批列表
     */
    @GetMapping("/my-audited")
    public TableDataInfo myAudited(BusinessAuditForm businessAuditForm) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<String> keyCodes = loginUser.getUser().getRoles().stream().map(SysRole::getRoleKey).collect(Collectors.toList());
        startPage();
        List<BusinessAuditForm> list = businessAuditFormService.myAuditedByRokeKey(loginUser.getUser().getUserId(), keyCodes.get(0), businessAuditForm);
        return getDataTable(list);
    }


    /**
     * 获取部门审批流程详细和业务数据信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        BusinessAuditForm businessAuditForm = businessAuditFormService.selectBusinessAuditFormById(id);
        result.put("auditData", businessAuditForm);
        if (BusinessElectricData.class.getSimpleName().equals(businessAuditForm.getDataType())) {
            BusinessElectricData businessElectricData = businessElectricDataService.selectBusinessElectricDataById(businessAuditForm.getDataId());
            result.put("businessData", businessElectricData);
        }
        // TODO
        return AjaxResult.success(result);
    }

    /**
     * 部门领导审批接口
     */
    @Log(title = "部门审批流程", businessType = BusinessType.INSERT)
    @PostMapping("/approval")
    public AjaxResult approval(@RequestBody AuditFormVo vo) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<String> keyCodes = loginUser.getUser().getRoles().stream().map(SysRole::getRoleKey).collect(Collectors.toList());
        BusinessAuditForm businessAuditForm = businessAuditFormService.selectBusinessAuditFormById(vo.getId());
        if ("0".equals(vo.getStatus())) {// 不通过
            businessAuditForm.setStatus("9");
            businessAuditForm.setMsg(vo.getMsg());
            if ("deptLeader".equals(keyCodes.get(0))) {
                businessAuditForm.setDeptAuditTime(new Date());
            } else if ("chargeLeader".equals(keyCodes.get(0))) {
                businessAuditForm.setChargeAuditTime(new Date());
            } else if ("keyLeader".equals(keyCodes.get(0))) {
                businessAuditForm.setKeyAuditTime(new Date());
            }
        } else {// 通过
            if ("deptLeader".equals(keyCodes.get(0))) {
                businessAuditForm.setStatus("2");
                businessAuditForm.setDeptAuditTime(new Date());
            } else if ("chargeLeader".equals(keyCodes.get(0))) {
                businessAuditForm.setStatus("3");
                businessAuditForm.setChargeAuditTime(new Date());
            } else if ("keyLeader".equals(keyCodes.get(0))) {
                businessAuditForm.setStatus("6");
                businessAuditForm.setKeyAuditTime(new Date());
            }
        }
        if (StringUtils.isNotEmpty(vo.getRemark())) {
            businessAuditForm.setRemark(vo.getRemark());
        }
        businessAuditForm.setUpdateBy(loginUser.getUsername());
        businessAuditForm.setUpdateTime(new Date());
        return toAjax(businessAuditFormService.updateBusinessAuditForm(businessAuditForm));
    }

    /**
     * 修改部门审批流程
     */
    @Log(title = "部门审批流程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAuditForm businessAuditForm) {
        return toAjax(businessAuditFormService.updateBusinessAuditForm(businessAuditForm));
    }

    /**
     * 删除部门审批流程
     */
    @Log(title = "部门审批流程", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessAuditFormService.deleteBusinessAuditFormByIds(ids));
    }
}
