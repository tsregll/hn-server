package com.ruoyi.web.controller.business;

import java.util.Date;
import java.util.List;

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
import com.ruoyi.business.domain.BusinessAdministrativeDecision;
import com.ruoyi.business.service.IBusinessAdministrativeDecisionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 决策事项Controller
 *
 * @author gwsh
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/decision")
public class BusinessAdministrativeDecisionController extends BaseController {
    @Autowired
    private IBusinessAdministrativeDecisionService businessAdministrativeDecisionService;

    /**
     * 查询决策事项列表
     */
    @PreAuthorize("@ss.hasPermi('business:decision:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessAdministrativeDecision businessAdministrativeDecision) {
        startPage();
        List<BusinessAdministrativeDecision> list = businessAdministrativeDecisionService.selectBusinessAdministrativeDecisionList(businessAdministrativeDecision);
        return getDataTable(list);
    }

    /**
     * 导出决策事项列表
     */
    @PreAuthorize("@ss.hasPermi('business:decision:export')")
    @Log(title = "决策事项", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessAdministrativeDecision businessAdministrativeDecision) {
        List<BusinessAdministrativeDecision> list = businessAdministrativeDecisionService.selectBusinessAdministrativeDecisionList(businessAdministrativeDecision);
        ExcelUtil<BusinessAdministrativeDecision> util = new ExcelUtil<BusinessAdministrativeDecision>(BusinessAdministrativeDecision.class);
        return util.exportExcel(list, "decision");
    }

    /**
     * 获取决策事项详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:decision:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessAdministrativeDecisionService.selectBusinessAdministrativeDecisionById(id));
    }

    /**
     * 新增决策事项
     */
    @PreAuthorize("@ss.hasPermi('business:decision:add')")
    @Log(title = "决策事项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessAdministrativeDecision businessAdministrativeDecision) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessAdministrativeDecision.setCreateBy(loginUser.getUsername());
        businessAdministrativeDecision.setCreateTime(new Date());
        businessAdministrativeDecision.setUpdateBy(loginUser.getUsername());
        businessAdministrativeDecision.setUpdateTime(new Date());
        businessAdministrativeDecision.setStatus("1");
        return toAjax(businessAdministrativeDecisionService.insertBusinessAdministrativeDecision(businessAdministrativeDecision));
    }

    /**
     * 修改决策事项
     */
    @PreAuthorize("@ss.hasPermi('business:decision:edit')")
    @Log(title = "决策事项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAdministrativeDecision businessAdministrativeDecision) {
        return toAjax(businessAdministrativeDecisionService.updateBusinessAdministrativeDecision(businessAdministrativeDecision));
    }

    /**
     * 删除决策事项
     */
    @PreAuthorize("@ss.hasPermi('business:decision:remove')")
    @Log(title = "决策事项", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessAdministrativeDecisionService.deleteBusinessAdministrativeDecisionByIds(ids));
    }
}
