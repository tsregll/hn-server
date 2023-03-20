package com.ruoyi.web.controller.business;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.business.vo.drmb.StatisticsGeneratingCapacityVo;
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
import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;
import com.ruoyi.business.service.IBusinessStatisticsGeneratingCapacityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 统调发电量Controller
 * 
 * @author yrb
 * @date 2021-03-12
 */
@Api(value = "BusinessStatisticsGeneratingCapacityController", tags = "统调发电量接口")
@RestController
@RequestMapping("/business/statisticsgeneratingcapacity")
public class BusinessStatisticsGeneratingCapacityController extends BaseController
{
    @Autowired
    private IBusinessStatisticsGeneratingCapacityService businessStatisticsGeneratingCapacityService;

    /**
     * 查询统调发电量列表
     */
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity)
    {
        startPage();
//        List<BusinessStatisticsGeneratingCapacity> list = businessStatisticsGeneratingCapacityService.selectBusinessStatisticsGeneratingCapacityList(businessStatisticsGeneratingCapacity);
        List<BusinessStatisticsGeneratingCapacity> list = businessStatisticsGeneratingCapacityService.selectByTimeStatisticsGeneratingCapacityList(businessStatisticsGeneratingCapacity);
        return getDataTable(list);
    }

    /**
     * 导出统调发电量列表
     */
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:export')")
    @Log(title = "统调发电量", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity)
    {
        List<BusinessStatisticsGeneratingCapacity> list = businessStatisticsGeneratingCapacityService.selectByTimeStatisticsGeneratingCapacityList(businessStatisticsGeneratingCapacity);
        ExcelUtil<BusinessStatisticsGeneratingCapacity> util = new ExcelUtil<BusinessStatisticsGeneratingCapacity>(BusinessStatisticsGeneratingCapacity.class);
        return util.exportExcel(list, "statisticsgeneratingcapacity");
    }

    /**
     * 获取统调发电量详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessStatisticsGeneratingCapacityService.selectBusinessStatisticsGeneratingCapacityById(id));
    }

    /**
     * 新增统调发电量
     */
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:add')")
    @Log(title = "统调发电量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity)
    {
        BusinessStatisticsGeneratingCapacity bs = new BusinessStatisticsGeneratingCapacity();
        bs.setEnteringDate(businessStatisticsGeneratingCapacity.getEnteringDate());
        bs.setStatisticsType(businessStatisticsGeneratingCapacity.getStatisticsType());
        int count = businessStatisticsGeneratingCapacityService.selectBusinessStatisticsGeneratingCapacityList(bs).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessStatisticsGeneratingCapacityService.insertBusinessStatisticsGeneratingCapacity(businessStatisticsGeneratingCapacity));
    }

    /**
     * 修改统调发电量
     */
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:edit')")
    @Log(title = "统调发电量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity)
    {
        return toAjax(businessStatisticsGeneratingCapacityService.updateBusinessStatisticsGeneratingCapacity(businessStatisticsGeneratingCapacity));
    }

    /**
     * 删除统调发电量
     */
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:remove')")
    @Log(title = "统调发电量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessStatisticsGeneratingCapacityService.deleteBusinessStatisticsGeneratingCapacityByIds(ids));
    }

    @ApiOperation(value = "统调发电量（返回近五年数据，通过类别查询）")
	@GetMapping("/selectByFive")
    public AjaxResult selectByFive(BusinessStatisticsGeneratingCapacity bs)
    {
        return AjaxResult.success(businessStatisticsGeneratingCapacityService.selectByFive(bs));
    }
    @ApiOperation(value = "统调发电量（返回1年数据，通过年份与类别查询）")
	@GetMapping("/selectByYearOrType")
    public AjaxResult selectByYearOrType(BusinessStatisticsGeneratingCapacity bs)
    {
        return AjaxResult.success(businessStatisticsGeneratingCapacityService.selectByYearOrType(bs));
    }
    @ApiOperation(value = "统调发电量（返回一个月的数据，通过月份查询）")
	@GetMapping("/selectByMonth")
    public AjaxResult selectByMonth(BusinessStatisticsGeneratingCapacity bs)
    {
        return AjaxResult.success(businessStatisticsGeneratingCapacityService.selectByMonth(bs));
    }

    /**
     * 导入统调发电量
     */
    @ApiOperation(value = "导入统调发电量")
    @Log(title = "导入统调发电量", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:statisticsgeneratingcapacity:import')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<BusinessStatisticsGeneratingCapacity> util = new ExcelUtil<BusinessStatisticsGeneratingCapacity>(BusinessStatisticsGeneratingCapacity.class);
        List<BusinessStatisticsGeneratingCapacity> bsgc = util.importExcel(file.getInputStream());
        String message = businessStatisticsGeneratingCapacityService.importDatas(bsgc);
        return AjaxResult.success(message);
    }

/*
   @ApiOperation(value = "导入统调发电量的模板")
    @GetMapping("/importstatisticsgeneratingcapacity")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessStatisticsGeneratingCapacity> util = new ExcelUtil<BusinessStatisticsGeneratingCapacity>(BusinessStatisticsGeneratingCapacity.class);
        return util.importTemplateExcel("统调发电量数据");
    }*/

    @ApiOperation(value = "导入统调发电量的模板")
    @GetMapping("/importstatisticsgeneratingcapacity")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<StatisticsGeneratingCapacityVo> util = new ExcelUtil<StatisticsGeneratingCapacityVo>(StatisticsGeneratingCapacityVo.class);
        List<StatisticsGeneratingCapacityVo> list =new ArrayList<>();
        for (Integer group = 0; group <4 ; group++) {
            StatisticsGeneratingCapacityVo bet = new StatisticsGeneratingCapacityVo();
            String name = group.toString();
            bet.setStatisticsType(name);
            list.add(bet);
        }
        return util.exportExcel(list,"统调发电量数据");
    }
}
