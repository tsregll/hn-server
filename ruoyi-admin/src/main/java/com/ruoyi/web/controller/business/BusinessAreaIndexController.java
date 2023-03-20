package com.ruoyi.web.controller.business;

import java.util.List;
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
import com.ruoyi.business.domain.BusinessAreaIndex;
import com.ruoyi.business.service.IBusinessAreaIndexService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 区域年度指标录入Controller
 * 
 * @author lpf
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/areaIndex")
public class BusinessAreaIndexController extends BaseController
{
    @Autowired
    private IBusinessAreaIndexService businessAreaIndexService;

    /**
     * 查询区域年度指标录入列表
     */
    @PreAuthorize("@ss.hasPermi('business:areaIndex:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessAreaIndex businessAreaIndex)
    {
        startPage();
        List<BusinessAreaIndex> list = businessAreaIndexService.selectBusinessAreaIndexList(businessAreaIndex);
        return getDataTable(list);
    }

    /**
     * 导出区域年度指标录入列表
     */
    @PreAuthorize("@ss.hasPermi('business:areaIndex:export')")
    @Log(title = "区域年度指标录入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessAreaIndex businessAreaIndex)
    {
        List<BusinessAreaIndex> list = businessAreaIndexService.selectBusinessAreaIndexList(businessAreaIndex);
        ExcelUtil<BusinessAreaIndex> util = new ExcelUtil<BusinessAreaIndex>(BusinessAreaIndex.class);
        return util.exportExcel(list, "areaIndex");
    }

    /**
     * 获取区域年度指标录入详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:areaIndex:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessAreaIndexService.selectBusinessAreaIndexById(id));
    }

    /**
     * 新增区域年度指标录入
     */
    @PreAuthorize("@ss.hasPermi('business:areaIndex:add')")
    @Log(title = "区域年度指标录入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessAreaIndex businessAreaIndex)
    {
        return toAjax(businessAreaIndexService.insertBusinessAreaIndex(businessAreaIndex));
    }

    /**
     * 修改区域年度指标录入
     */
    @PreAuthorize("@ss.hasPermi('business:areaIndex:edit')")
    @Log(title = "区域年度指标录入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessAreaIndex businessAreaIndex)
    {
        return toAjax(businessAreaIndexService.updateBusinessAreaIndex(businessAreaIndex));
    }

    /**
     * 删除区域年度指标录入
     */
    @PreAuthorize("@ss.hasPermi('business:areaIndex:remove')")
    @Log(title = "区域年度指标录入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessAreaIndexService.deleteBusinessAreaIndexByIds(ids));
    }
}
