package com.ruoyi.web.controller.business.front;


import com.ruoyi.business.domain.*;
import com.ruoyi.business.service.*;
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

/**
 * 前端总貌需要的接口控制器
 */
@Api(value = "generalAppearanceController", tags = "前端总貌需要的接口控制器")
@RestController
@RequestMapping("/general/appearance")
public class GeneralAppearanceController {

    @Autowired
    private IBusinessElectricCoalService businessElectricCoalService;
    @Autowired
    private IBusinessElectricPhotovoltaicService businessElectricPhotovoltaicService;
    @Autowired
    private IBusinessElectricWaterService businessElectricWaterService;
    @Autowired
    private IBusinessElectricWindService businessElectricWindService;
    @Autowired
    private IBusinessHeartScoreService businessHeartScoreService;



    /**
     * 定义区域发电总貌服务对象
     */
    @Autowired
    private IBusinessElectricAreaService businessElectricAreaService;

    /**
     * 查询煤机发电总貌列表
     */
    @GetMapping("/coal")
    @ApiOperation(value = "4.5.2 煤机年度绩效目标接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricCoal.class)
    })
    public AjaxResult coal() {
        BusinessElectricCoal businessElectricCoal = new BusinessElectricCoal();
        businessElectricCoal.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessElectricCoal> list = businessElectricCoalService.selectBusinessElectricCoalList(businessElectricCoal);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }

    /**
     * 当年区域发电总貌年度绩效查询接口
     */
    @GetMapping("/area")
    @ApiOperation(value = "当年区域发电总貌年度绩效查询接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricArea.class)
    })
    public AjaxResult areaList()
    {
        BusinessElectricArea businessElectricArea = new BusinessElectricArea();
        businessElectricArea.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessElectricArea> areaList = businessElectricAreaService.selectBusinessElectricAreaList(businessElectricArea);
        if (areaList != null && areaList.size()>0){
            return AjaxResult.success(areaList);
        }else{
            return null;
        }
    }

    /**
     * 查询煤机发电总貌列表
     */
    @GetMapping("/photovoltaic")
    @ApiOperation(value = "4.5.3 光伏年度绩效目标接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricPhotovoltaic.class)
    })
    public AjaxResult photovoltaic() {
        BusinessElectricPhotovoltaic businessElectricPhotovoltaic = new BusinessElectricPhotovoltaic();
        businessElectricPhotovoltaic.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessElectricPhotovoltaic> list = businessElectricPhotovoltaicService.selectBusinessElectricPhotovoltaicList(businessElectricPhotovoltaic);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }

    /**
     * 查询煤机发电总貌列表
     */
    @GetMapping("/water")
    @ApiOperation(value = "4.5.4 水电年度绩效目标接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricWater.class)
    })
    public AjaxResult water() {
        BusinessElectricWater businessElectricWater = new BusinessElectricWater();
        businessElectricWater.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessElectricWater> list = businessElectricWaterService.selectBusinessElectricWaterList(businessElectricWater);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }

    /**
     * 查询煤机发电总貌列表
     */
    @GetMapping("/wind")
    @ApiOperation(value = "4.5.5 风电年度绩效目标")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricWind.class)
    })
    public AjaxResult wind() {
        BusinessElectricWind businessElectricWind = new BusinessElectricWind();
        businessElectricWind.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessElectricWind> list = businessElectricWindService.selectBusinessElectricWindList(businessElectricWind);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }

    /**
     * 查询煤机发电总貌列表
     */
    @GetMapping("/heart")
    @ApiOperation(value = "4.5.6 供热年度绩效目标")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessHeartScore.class)
    })
    public AjaxResult heart() {
        BusinessHeartScore businessHeartScore = new BusinessHeartScore();
        businessHeartScore.setYear(Long.parseLong(Calendar.YEAR+""));
        List<BusinessHeartScore> list = businessHeartScoreService.selectBusinessHeartScoreList(businessHeartScore);
        if(list!=null && list.size()>0){
            return  AjaxResult.success(list.get(0));
        }
        return null;
    }


}
