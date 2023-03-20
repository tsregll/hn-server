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
import com.ruoyi.business.domain.BusinessAdministrativeReception;
import com.ruoyi.business.service.IBusinessAdministrativeReceptionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业务接待功能字段Controller
 *
 * @author gwsh
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/reception")
public class BusinessAdministrativeReceptionController extends BaseController {
    @Autowired
    private IBusinessAdministrativeReceptionService businessAdministrativeReceptionService;

    /**
     * 查询业务接待功能字段列表
     */
    @PreAuthorize("@ss.hasPermi('business:reception:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessAdministrativeReception businessAdministrativeReception) {
        startPage();
        List<BusinessAdministrativeReception> list = businessAdministrativeReceptionService.selectBusinessAdministrativeReceptionList(businessAdministrativeReception);
        return getDataTable(list);
    }

    /**
     * 导出业务接待功能字段列表
     */
    @PreAuthorize("@ss.hasPermi('business:reception:export')")
    @Log(title = "业务接待功能字段", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessAdministrativeReception businessAdministrativeReception) {
        List<BusinessAdministrativeReception> list = businessAdministrativeReceptionService.selectBusinessAdministrativeReceptionList(businessAdministrativeReception);
        ExcelUtil<BusinessAdministrativeReception> util = new ExcelUtil<BusinessAdministrativeReception>(BusinessAdministrativeReception.class);
        return util.exportExcel(list, "reception");
    }

    /**
     * 获取业务接待功能字段详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:reception:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessAdministrativeReceptionService.selectBusinessAdministrativeReceptionById(id));
    }

    /**
     * 新增业务接待功能字段
     */
    @PreAuthorize("@ss.hasPermi('business:reception:add')")
    @Log(title = "业务接待功能字段", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessAdministrativeReception businessAdministrativeReception) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessAdministrativeReception.setCreateBy(loginUser.getUsername());
        businessAdministrativeReception.setCreateTime(new Date());
        businessAdministrativeReception.setUpdateBy(loginUser.getUsername());
        businessAdministrativeReception.setUpdateTime(new Date());
        businessAdministrativeReception.setStatus("1");
        return toAjax(businessAdministrativeReceptionService.insertBusinessAdministrativeReception(businessAdministrativeReception));
    }

    /**
     * 修改业务接待功能字段
     */
    @PreAuthorize("@ss.hasPermi('business:reception:edit')")
    @Log(title = "业务接待功能字段", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAdministrativeReception businessAdministrativeReception) {
        return toAjax(businessAdministrativeReceptionService.updateBusinessAdministrativeReception(businessAdministrativeReception));
    }

    /**
     * 删除业务接待功能字段
     */
    @PreAuthorize("@ss.hasPermi('business:reception:remove')")
    @Log(title = "业务接待功能字段", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessAdministrativeReceptionService.deleteBusinessAdministrativeReceptionByIds(ids));
    }
}
