package com.ruoyi.web.controller.business;

import java.util.List;

import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.business.domain.SkBbLabelData;
import com.ruoyi.business.service.ISkBbLabelDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * SkBbLabelController
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
@RestController
@RequestMapping("/business/SkBbLabelData")
public class SkBbLabelDataController extends BaseController
{
    @Autowired
    private ISkBbLabelDataService skBbLabelService;

    /**
     * 查询SkBbLabel列表
     */
    @PreAuthorize("@ss.hasPermi('business:SkBbLabelData:list')")
    @GetMapping("/list")
    public TableDataInfo list(SkBbLabelData skBbLabel)
    {
        startPage();
        List<SkBbLabelData> list = skBbLabelService.selectSkBbLabelList(skBbLabel);
        return getDataTable(list);
    }

    /**
     * 导出SkBbLabel列表
     */
    @PreAuthorize("@ss.hasPermi('business:SkBbLabel:export')")
    @Log(title = "SkBbLabel", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SkBbLabelData skBbLabel)
    {
        List<SkBbLabelData> list = skBbLabelService.selectSkBbLabelList(skBbLabel);
        ExcelUtil<SkBbLabelData> util = new ExcelUtil<SkBbLabelData>(SkBbLabelData.class);
        return util.exportExcel(list, "SkBbLabel");
    }

    /**
     * 获取SkBbLabel详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:SkBbLabel:query')")
    @GetMapping(value = "/{name}")
    public AjaxResult getInfo(@PathVariable("name") String name)
    {
        return AjaxResult.success(skBbLabelService.selectSkBbLabelById(name));
    }

    /**
     * 新增SkBbLabel
     */
    @PreAuthorize("@ss.hasPermi('business:SkBbLabel:add')")
    @Log(title = "SkBbLabel", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkBbLabelData skBbLabel)
    {
        return toAjax(skBbLabelService.insertSkBbLabel(skBbLabel));
    }

    /**
     * 修改SkBbLabel
     */
    @PreAuthorize("@ss.hasPermi('business:SkBbLabel:edit')")
    @Log(title = "SkBbLabel", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkBbLabelData skBbLabel)
    {
        return toAjax(skBbLabelService.updateSkBbLabel(skBbLabel));
    }

    /**
     * 删除SkBbLabel
     */
    @PreAuthorize("@ss.hasPermi('business:SkBbLabel:remove')")
    @Log(title = "SkBbLabel", businessType = BusinessType.DELETE)
	@DeleteMapping("/{names}")
    public AjaxResult remove(@PathVariable String[] names)
    {
        return toAjax(skBbLabelService.deleteSkBbLabelByIds(names));
    }


    @ApiOperation(value = "导入神库标签")
    @Log(title = "导入神库标签", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @PreAuthorize("@ss.hasPermi('business:SkBbLabel:import')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<SkBbLabelData> util = new ExcelUtil<SkBbLabelData>(SkBbLabelData.class);
        List<SkBbLabelData> bsgc = util.importExcel(file.getInputStream());
        String message = skBbLabelService.importData(bsgc);
        return AjaxResult.success(message);
    }
}
