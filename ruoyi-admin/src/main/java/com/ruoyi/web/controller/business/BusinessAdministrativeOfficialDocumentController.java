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
import com.ruoyi.business.domain.BusinessAdministrativeOfficialDocument;
import com.ruoyi.business.service.IBusinessAdministrativeOfficialDocumentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公文发文功能Controller
 *
 * @author gwsh
 * @date 2021-03-03
 */
@RestController
@RequestMapping("/business/officialdocument")
public class BusinessAdministrativeOfficialDocumentController extends BaseController {
    @Autowired
    private IBusinessAdministrativeOfficialDocumentService businessAdministrativeOfficialDocumentService;

    /**
     * 查询公文发文功能列表
     */
    @PreAuthorize("@ss.hasPermi('business:officialdocument:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument) {
        startPage();
        List<BusinessAdministrativeOfficialDocument> list = businessAdministrativeOfficialDocumentService.selectBusinessAdministrativeOfficialDocumentList(businessAdministrativeOfficialDocument);
        return getDataTable(list);
    }

    /**
     * 导出公文发文功能列表
     */
    @PreAuthorize("@ss.hasPermi('business:officialdocument:export')")
    @Log(title = "公文发文功能", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument) {
        List<BusinessAdministrativeOfficialDocument> list = businessAdministrativeOfficialDocumentService.selectBusinessAdministrativeOfficialDocumentList(businessAdministrativeOfficialDocument);
        ExcelUtil<BusinessAdministrativeOfficialDocument> util = new ExcelUtil<BusinessAdministrativeOfficialDocument>(BusinessAdministrativeOfficialDocument.class);
        return util.exportExcel(list, "officialdocument");
    }

    /**
     * 获取公文发文功能详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:officialdocument:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessAdministrativeOfficialDocumentService.selectBusinessAdministrativeOfficialDocumentById(id));
    }

    /**
     * 新增公文发文功能
     */
    @PreAuthorize("@ss.hasPermi('business:officialdocument:add')")
    @Log(title = "公文发文功能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessAdministrativeOfficialDocument.setCreateBy(loginUser.getUsername());
        businessAdministrativeOfficialDocument.setCreateTime(new Date());
        businessAdministrativeOfficialDocument.setUpdateBy(loginUser.getUsername());
        businessAdministrativeOfficialDocument.setUpdateTime(new Date());
        businessAdministrativeOfficialDocument.setStatus("1");
        return toAjax(businessAdministrativeOfficialDocumentService.insertBusinessAdministrativeOfficialDocument(businessAdministrativeOfficialDocument));
    }

    /**
     * 修改公文发文功能
     */
    @PreAuthorize("@ss.hasPermi('business:officialdocument:edit')")
    @Log(title = "公文发文功能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument) {
        return toAjax(businessAdministrativeOfficialDocumentService.updateBusinessAdministrativeOfficialDocument(businessAdministrativeOfficialDocument));
    }

    /**
     * 删除公文发文功能
     */
    @PreAuthorize("@ss.hasPermi('business:officialdocument:remove')")
    @Log(title = "公文发文功能", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessAdministrativeOfficialDocumentService.deleteBusinessAdministrativeOfficialDocumentByIds(ids));
    }
}
