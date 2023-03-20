package com.ruoyi.web.controller.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.vo.drmb.HnElectrifiedGridVo;
import io.swagger.annotations.Api;
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
import com.ruoyi.business.domain.BusinessHnElectrifiedGrid;
import com.ruoyi.business.service.IBusinessHnElectrifiedGridService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 湖南电网发电量后台Controller
 * 
 * @author ruoyi
 * @date 2021-03-13
 */
@RestController
@Api(value = "BusinessHnElectrifiedGridController", tags = "湖南发电量接口")
@RequestMapping("/business/hnelectrifiedgrid")
public class BusinessHnElectrifiedGridController extends BaseController
{
    @Autowired
    private IBusinessHnElectrifiedGridService businessHnElectrifiedGridService;

    /**
     * 查询湖南电网发电量后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        startPage();
//        List<BusinessHnElectrifiedGrid> list = businessHnElectrifiedGridService.selectBusinessHnElectrifiedGridList(businessHnElectrifiedGrid);
        List<BusinessHnElectrifiedGrid> list = businessHnElectrifiedGridService.selectByTimeHnElectrifiedGridList(businessHnElectrifiedGrid);
        return getDataTable(list);
    }
    /**
     * 导出湖南电网发电量后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:export')")
    @Log(title = "湖南电网发电量后台", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        List<BusinessHnElectrifiedGrid> list = businessHnElectrifiedGridService.selectByTimeHnElectrifiedGridList(businessHnElectrifiedGrid);
        ExcelUtil<BusinessHnElectrifiedGrid> util = new ExcelUtil<BusinessHnElectrifiedGrid>(BusinessHnElectrifiedGrid.class);
        return util.exportExcel(list, "hnelectrifiedgrid");
    }

    /**
     * 获取湖南电网发电量后台详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessHnElectrifiedGridService.selectBusinessHnElectrifiedGridById(id));
    }

    /**
     * 新增湖南电网发电量后台
     */
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:add')")
    @Log(title = "湖南电网发电量后台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        return toAjax(businessHnElectrifiedGridService.insertBusinessHnElectrifiedGrid(businessHnElectrifiedGrid));
    }

    /**
     * 修改湖南电网发电量后台
     */
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:edit')")
    @Log(title = "湖南电网发电量后台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        return toAjax(businessHnElectrifiedGridService.updateBusinessHnElectrifiedGrid(businessHnElectrifiedGrid));
    }

    /**
     * 删除湖南电网发电量后台
     */
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:remove')")
    @Log(title = "湖南电网发电量后台", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessHnElectrifiedGridService.deleteBusinessHnElectrifiedGridByIds(ids));
    }

    /**
     * 查询湖南电网发电量后台列表
     */
    @ApiOperation(value = "湖南发电量查询近5年接口（通过类别查询的柱状图）")
    @GetMapping("/selectFive")
    public AjaxResult selectFive(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        Map<String,Object> list = businessHnElectrifiedGridService.selectFive(businessHnElectrifiedGrid);
        return AjaxResult.success(list);
    }
    /**
     * 查询湖南电网发电量后台列表
     */
    @ApiOperation(value = "湖南发电量查询一年接口（通过类别查询的柱状图）")
    @GetMapping("/selectOneYear")
    public AjaxResult selectOneYear(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        Map<String,Object> list = businessHnElectrifiedGridService.selectOneYear(businessHnElectrifiedGrid);
        return AjaxResult.success(list);
    }
    /**
     * 查询湖南电网发电量后台列表
     */
    @ApiOperation(value = "湖南发电量表格接口")
    @GetMapping("/selectByTable")
    public AjaxResult selectByTable(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        Map<String,Object> list = businessHnElectrifiedGridService.selectByTable(businessHnElectrifiedGrid);
        return AjaxResult.success(list);
    }

    /**
     * 导入湖南电网发电量
     */
    @ApiOperation(value = "导入湖南电网发电量")
    @Log(title = "导入湖南电网发电量", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:hnelectrifiedgrid:import')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<BusinessHnElectrifiedGrid> util = new ExcelUtil<BusinessHnElectrifiedGrid>(BusinessHnElectrifiedGrid.class);
        List<BusinessHnElectrifiedGrid> bsgc = util.importExcel(file.getInputStream());
        String message = businessHnElectrifiedGridService.importDatas(bsgc);
        return AjaxResult.success(message);
    }

    /*
    @ApiOperation(value = "导入湖南电网发电量的模板")
    @GetMapping("/importhnelectrifiedgrid")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessHnElectrifiedGrid> util = new ExcelUtil<BusinessHnElectrifiedGrid>(BusinessHnElectrifiedGrid.class);
        return util.importTemplateExcel("湖南电网发电量数据");
    }*/

    @ApiOperation(value = "导入湖南电网发电量的模板")
    @GetMapping("/importhnelectrifiedgrid")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<HnElectrifiedGridVo> util = new ExcelUtil<HnElectrifiedGridVo>(HnElectrifiedGridVo.class);
        List<HnElectrifiedGridVo> list =new ArrayList<>();
        for (Integer group = 0; group <4 ; group++) {
            HnElectrifiedGridVo bet = new HnElectrifiedGridVo();
            String name = group.toString();
            bet.setIndustryType(name);
            list.add(bet);
        }
        return util.exportExcel(list,"湖南电网发电量数据");
    }
}
