package com.ruoyi.web.controller.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessHnElectrifiedGrid;
import com.ruoyi.business.vo.drmb.FullMonthElectricityStatisticsVo;
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
import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;
import com.ruoyi.business.service.IBusinessFullMonthElectricityStatisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 全月日电量统计Controller
 * 
 * @author yrb
 * @date 2021-03-13
 */
@RestController
@RequestMapping("/business/fullmonthelectricitystatistics")
public class BusinessFullMonthElectricityStatisticsController extends BaseController
{
    @Autowired
    private IBusinessFullMonthElectricityStatisticsService businessFullMonthElectricityStatisticsService;

    /**
     * 查询全月日电量统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        startPage();
//        List<BusinessFullMonthElectricityStatistics> list = businessFullMonthElectricityStatisticsService.selectBusinessFullMonthElectricityStatisticsList(businessFullMonthElectricityStatistics);
        List<BusinessFullMonthElectricityStatistics> list = businessFullMonthElectricityStatisticsService.selectByTimeFullMonthElectricityStatisticsList(businessFullMonthElectricityStatistics);
        return getDataTable(list);
    }

    /**
     * 导出全月日电量统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:export')")
    @Log(title = "全月日电量统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        List<BusinessFullMonthElectricityStatistics> list = businessFullMonthElectricityStatisticsService.selectByTimeFullMonthElectricityStatisticsList(businessFullMonthElectricityStatistics);
        ExcelUtil<BusinessFullMonthElectricityStatistics> util = new ExcelUtil<BusinessFullMonthElectricityStatistics>(BusinessFullMonthElectricityStatistics.class);
        return util.exportExcel(list, "全月日电量统计");
    }

    /**
     * 获取全月日电量统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessFullMonthElectricityStatisticsService.selectBusinessFullMonthElectricityStatisticsById(id));
    }

    /**
     * 新增全月日电量统计
     */
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:add')")
    @Log(title = "全月日电量统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        return toAjax(businessFullMonthElectricityStatisticsService.insertBusinessFullMonthElectricityStatistics(businessFullMonthElectricityStatistics));
    }

    /**
     * 修改全月日电量统计
     */
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:edit')")
    @Log(title = "全月日电量统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        return toAjax(businessFullMonthElectricityStatisticsService.updateBusinessFullMonthElectricityStatistics(businessFullMonthElectricityStatistics));
    }

    /**
     * 删除全月日电量统计
     */
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:remove')")
    @Log(title = "全月日电量统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessFullMonthElectricityStatisticsService.deleteBusinessFullMonthElectricityStatisticsByIds(ids));
    }

    /**
     * 导入全月日电量
     */
    @ApiOperation(value = "导入全月日电量")
    @Log(title = "全月日电量", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:fullmonthelectricitystatistics:importDatas')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<BusinessFullMonthElectricityStatistics> util = new ExcelUtil<BusinessFullMonthElectricityStatistics>(BusinessFullMonthElectricityStatistics.class);
        List<BusinessFullMonthElectricityStatistics> bfmes = util.importExcel(file.getInputStream());
        String message = businessFullMonthElectricityStatisticsService.importDatas(bfmes);
        return AjaxResult.success(message);
    }

//    @ApiOperation(value = "全月日电量模板")
//    @GetMapping("/importfullmonthelectricitystatistics")
//    public AjaxResult importBusinessInstallationStatistics() {
//        ExcelUtil<FullMonthElectricityStatisticsVo> util = new ExcelUtil<FullMonthElectricityStatisticsVo>(FullMonthElectricityStatisticsVo.class);
//        List<FullMonthElectricityStatisticsVo> list =new ArrayList<>();
////        for (Integer date = 0; date <31 ; date++) {
////            FullMonthElectricityStatisticsVo bet = new FullMonthElectricityStatisticsVo();
////            String name = date.toString()+"日";
////            bet.setEnteringDate(name);
////            list.add(bet);
////        }
//        return util.importTemplateExcel("全月日电量模板");
//    }

    @ApiOperation(value = "全月日电量模板")
    @GetMapping("/importfullmonthelectricitystatistics")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessFullMonthElectricityStatistics> util = new ExcelUtil<BusinessFullMonthElectricityStatistics>(BusinessFullMonthElectricityStatistics.class);
        return util.importTemplateExcel("全月日电量模板");
    }
    /**
     * 查询全日月
     */
    @ApiOperation(value = "全日月查询一个月接口（通过年月查询）")
    @GetMapping("/selectByMonth")
    public AjaxResult selectByMonth(BusinessFullMonthElectricityStatistics bf)
    {
        Map<String, Object> list = businessFullMonthElectricityStatisticsService.selectByMonth(bf);
        return AjaxResult.success(list);
    }
    /**
     * 查询湖南电网发电量后台列表
     */
    @ApiOperation(value = "全日月查询表格接口")
    @GetMapping("/selectByTable")
    public AjaxResult selectByTable(BusinessFullMonthElectricityStatistics bf)
    {
        Map<String, Object> list = businessFullMonthElectricityStatisticsService.selectByTable(bf);
        return AjaxResult.success(list);
    }
}
