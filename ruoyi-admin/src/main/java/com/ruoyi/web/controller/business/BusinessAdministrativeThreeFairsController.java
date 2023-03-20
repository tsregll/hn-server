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
import com.ruoyi.business.domain.BusinessAdministrativeThreeFairs;
import com.ruoyi.business.service.IBusinessAdministrativeThreeFairsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 三公经费Controller
 *
 * @author gwsh
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/fairs")
public class BusinessAdministrativeThreeFairsController extends BaseController {
    @Autowired
    private IBusinessAdministrativeThreeFairsService businessAdministrativeThreeFairsService;

    /**
     * 查询三公经费列表
     */
    @PreAuthorize("@ss.hasPermi('business:fairs:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs) {
        startPage();
        List<BusinessAdministrativeThreeFairs> list = businessAdministrativeThreeFairsService.selectBusinessAdministrativeThreeFairsList(businessAdministrativeThreeFairs);
        return getDataTable(list);
    }

    /**
     * 导出三公经费列表
     */
    @PreAuthorize("@ss.hasPermi('business:fairs:export')")
    @Log(title = "三公经费", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs) {
        List<BusinessAdministrativeThreeFairs> list = businessAdministrativeThreeFairsService.selectBusinessAdministrativeThreeFairsList(businessAdministrativeThreeFairs);
        ExcelUtil<BusinessAdministrativeThreeFairs> util = new ExcelUtil<BusinessAdministrativeThreeFairs>(BusinessAdministrativeThreeFairs.class);
        return util.exportExcel(list, "fairs");
    }

    /**
     * 获取三公经费详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:fairs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessAdministrativeThreeFairsService.selectBusinessAdministrativeThreeFairsById(id));
    }

    /**
     * 新增三公经费
     */
    @PreAuthorize("@ss.hasPermi('business:fairs:add')")
    @Log(title = "三公经费", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessAdministrativeThreeFairs.setCreateBy(loginUser.getUsername());
        businessAdministrativeThreeFairs.setCreateTime(new Date());
        businessAdministrativeThreeFairs.setUpdateBy(loginUser.getUsername());
        businessAdministrativeThreeFairs.setUpdateTime(new Date());
        businessAdministrativeThreeFairs.setStatus("1");
        return toAjax(businessAdministrativeThreeFairsService.insertBusinessAdministrativeThreeFairs(businessAdministrativeThreeFairs));
    }

    /**
     * 修改三公经费
     */
    @PreAuthorize("@ss.hasPermi('business:fairs:edit')")
    @Log(title = "三公经费", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs) {
        return toAjax(businessAdministrativeThreeFairsService.updateBusinessAdministrativeThreeFairs(businessAdministrativeThreeFairs));
    }

    /**
     * 删除三公经费
     */
    @PreAuthorize("@ss.hasPermi('business:fairs:remove')")
    @Log(title = "三公经费", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessAdministrativeThreeFairsService.deleteBusinessAdministrativeThreeFairsByIds(ids));
    }
}
