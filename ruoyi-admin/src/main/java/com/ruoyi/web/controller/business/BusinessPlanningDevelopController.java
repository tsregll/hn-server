package com.ruoyi.web.controller.business;

import java.util.Date;
import java.util.List;

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
import com.ruoyi.business.domain.BusinessPlanningDevelop;
import com.ruoyi.business.service.IBusinessPlanningDevelopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规划发展Controller
 *
 * @author gwsh
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/plde")
public class BusinessPlanningDevelopController extends BaseController {
    @Autowired
    private IBusinessPlanningDevelopService businessPlanningDevelopService;
    @Autowired
    private IBusinessAuditFormService businessAuditFormService;

    /**
     * 查询规划发展列表
     */
    @PreAuthorize("@ss.hasPermi('business:plde:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessPlanningDevelop businessPlanningDevelop) {
        startPage();
        List<BusinessPlanningDevelop> list = businessPlanningDevelopService.selectBusinessPlanningDevelopList(businessPlanningDevelop);
        return getDataTable(list);
    }

    /**
     * 导出规划发展列表
     */
    @PreAuthorize("@ss.hasPermi('business:plde:export')")
    @Log(title = "规划发展", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessPlanningDevelop businessPlanningDevelop) {
        List<BusinessPlanningDevelop> list = businessPlanningDevelopService.selectBusinessPlanningDevelopList(businessPlanningDevelop);
        ExcelUtil<BusinessPlanningDevelop> util = new ExcelUtil<BusinessPlanningDevelop>(BusinessPlanningDevelop.class);
        return util.exportExcel(list, "plde");
    }

    /**
     * 获取规划发展详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:plde:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessPlanningDevelopService.selectBusinessPlanningDevelopById(id));
    }

    /**
     * 新增规划发展
     */
    @PreAuthorize("@ss.hasPermi('business:plde:add')")
    @Log(title = "规划发展", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessPlanningDevelop businessPlanningDevelop) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessPlanningDevelop.setCreateBy(loginUser.getUsername());
        businessPlanningDevelop.setCreateTime(new Date());
        businessPlanningDevelop.setUpdateBy(loginUser.getUsername());
        businessPlanningDevelop.setUpdateTime(new Date());
        businessPlanningDevelop.setStatus("1");
        return toAjax(businessPlanningDevelopService.insertBusinessPlanningDevelop(businessPlanningDevelop));
    }

    /**
     * 修改规划发展
     */
    @PreAuthorize("@ss.hasPermi('business:plde:edit')")
    @Log(title = "规划发展", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessPlanningDevelop businessPlanningDevelop) {
        return toAjax(businessPlanningDevelopService.updateBusinessPlanningDevelop(businessPlanningDevelop));
    }

    /**
     * 删除规划发展
     */
    @PreAuthorize("@ss.hasPermi('business:plde:remove')")
    @Log(title = "规划发展", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessPlanningDevelopService.deleteBusinessPlanningDevelopByIds(ids));
    }
}
