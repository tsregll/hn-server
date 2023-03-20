package com.ruoyi.web.controller.business.front;

import com.ruoyi.business.domain.BusinessAreaIndex;
import com.ruoyi.business.domain.BusinessCompanyAnalysis;
import com.ruoyi.business.domain.BusinessCompanyStatistics;
import com.ruoyi.business.domain.BusinessYueyangIndex;
import com.ruoyi.business.service.IBusinessAreaIndexService;
import com.ruoyi.business.service.IBusinessCompanyAnalysisService;
import com.ruoyi.business.service.IBusinessCompanyStatisticsService;
import com.ruoyi.business.service.IBusinessYueyangIndexService;
import com.ruoyi.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@Api(value = "generalAppearanceController", tags = "前端生产管理报表需要的接口控制器")
@RestController
@RequestMapping("/product/manager")
public class ProductManagerController {

    @Autowired
    private IBusinessAreaIndexService businessAreaIndexService;
    @Autowired
    private IBusinessCompanyStatisticsService businessCompanyStatisticsService;
    @Autowired
    private IBusinessCompanyAnalysisService businessCompanyAnalysisService;
    @Autowired
    private IBusinessYueyangIndexService businessYueyangIndexService;
    /**
     * 录入区域年度计划接口
     */
    @GetMapping("/area-index")
    @ApiOperation(value = "4.8.1 录入区域年度计划接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessAreaIndex.class)
    })
    public AjaxResult areaIndex() {
        BusinessAreaIndex businessAreaIndex = new BusinessAreaIndex();
        businessAreaIndex.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessAreaIndex> list = businessAreaIndexService.selectBusinessAreaIndexList(businessAreaIndex);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }
    /**
     * 录入清能公司统计报表指标年度计划
     */
    @GetMapping("/qinneng-statistics")
    @ApiOperation(value = "4.9.1 录入清能公司统计报表指标年度计划")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessCompanyStatistics.class)
    })
    public AjaxResult qinnengStatistics() {
        BusinessCompanyStatistics businessCompanyStatistics = new BusinessCompanyStatistics();
        businessCompanyStatistics.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessCompanyStatistics> list = businessCompanyStatisticsService.selectBusinessCompanyStatisticsList(businessCompanyStatistics);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }
    /**
     * 录入清能公司分析报表指标年度计划录入
     */
    @GetMapping("/qinneng-annlysis")
    @ApiOperation(value = "4.10.1 录入清能公司分析报表指标年度计划录入")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessCompanyAnalysis.class)
    })
    public AjaxResult qinnengAnnlysis() {
        BusinessCompanyAnalysis businessCompanyAnalysis = new BusinessCompanyAnalysis();
        businessCompanyAnalysis.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessCompanyAnalysis> list = businessCompanyAnalysisService.selectBusinessCompanyAnalysisList(businessCompanyAnalysis);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }

    /**
     * 录入清能公司分析报表指标年度计划录入
     */
    @GetMapping("/yuyang-index")
    @ApiOperation(value = "4.11.1 录入岳阳电厂指标年度计划")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessYueyangIndex.class)
    })
    public AjaxResult yueyangIndex() {
        BusinessYueyangIndex businessYueyangIndex = new BusinessYueyangIndex();
        businessYueyangIndex.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessYueyangIndex> list = businessYueyangIndexService.selectBusinessYueyangIndexList(businessYueyangIndex);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }
}
