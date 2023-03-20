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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * 前端总貌需要的接口控制器
 */
@Api(value = "ShowYearBusinessElectricController", tags = "本年度总貌查询接口")
@RestController
@RequestMapping("/showyear/businesselectric")
public class ShowYearBusinessElectricController {
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
    @Autowired
    private IBusinessElectricAreaService businessElectricAreaService;

    /**
     * 查询本年度煤机总貌
     */
    @GetMapping("/coal")
    @ApiOperation(value = "本年度煤机接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricCoal.class)
    })
    public AjaxResult coal() {
        BusinessElectricCoal businessElectricCoal = new BusinessElectricCoal();
        businessElectricCoal.setYear(Long.parseLong(LocalDate.now().getYear()+""));
        List<BusinessElectricCoal> list = businessElectricCoalService.selectBusinessElectricCoalList(businessElectricCoal);
        if(list!=null && list.size()>0){
            BusinessElectricCoal i = list.get(0);
            i.setGenerateCapacity(this.bl(i.getGenerateCapacity()));
            i.setGenerateCapacityFirst(this.bl(i.getGenerateCapacityFirst()));
            i.setGenerateCapacitySecond(this.bl(i.getGenerateCapacitySecond()));
            i.setGenerateCapacityThirdly(this.bl(i.getGenerateCapacityThirdly()));
            i.setHeatSupply(this.bl(i.getHeatSupply()));
            i.setCoalComsumer(this.bl(i.getCoalComsumer()));
            i.setRate(this.bl(i.getRate()));
            i.setIntegratedElectricity(this.bl(i.getIntegratedElectricity()));
            i.setPrice(new BigDecimal(this.bl(i.getPrice().toString())));
            i.setTotalPrice(new BigDecimal(this.bl(i.getTotalPrice().toString())));
            i.setEva(new BigDecimal(this.bl(i.getEva().toString())));
            return  AjaxResult.success(i);
        }
        return null;
    }

    /**
     * 查询本年度区域总貌
     */
    @GetMapping("/area")
    @ApiOperation(value = "本年度区域接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricArea.class)
    })
    public AjaxResult areaList()
    {
        BusinessElectricArea businessElectricArea = new BusinessElectricArea();
        businessElectricArea.setYear(Long.parseLong(LocalDate.now().getYear()+""));
        List<BusinessElectricArea> areaList = businessElectricAreaService.selectBusinessElectricAreaList(businessElectricArea);
        if (areaList != null && areaList.size()>0){
            BusinessElectricArea i = areaList.get(0);
            i.setGenerateCapacity(this.bl(i.getGenerateCapacity()));
            i.setHeatSupply(this.bl(i.getHeatSupply()));
            i.setPrice(new BigDecimal(this.bl(i.getPrice().toString())));
            i.setTotalPrice(new BigDecimal(this.bl(i.getTotalPrice().toString())));
            i.setEva(new BigDecimal(this.bl(i.getEva().toString())));


            i.setGenerateCapacityFire (this.bl(i.getGenerateCapacityFire ()));
            i.setGenerateCapacityWind (this.bl(i.getGenerateCapacityWind ()));
            i.setGenerateCapacityWater(this.bl(i.getGenerateCapacityWater()));
            i.setGenerateCapacityLight(this.bl(i.getGenerateCapacityLight()));
            return  AjaxResult.success(i);
        }else{
            return null;
        }
    }

    /**
     * 查询本年度光伏总貌
     */
    @GetMapping("/photovoltaic")
    @ApiOperation(value = "本年度光伏接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricPhotovoltaic.class)
    })
    public AjaxResult photovoltaic() {
        BusinessElectricPhotovoltaic businessElectricPhotovoltaic = new BusinessElectricPhotovoltaic();
        businessElectricPhotovoltaic.setYear(Long.parseLong(LocalDate.now().getYear()+""));
        List<BusinessElectricPhotovoltaic> list = businessElectricPhotovoltaicService.selectBusinessElectricPhotovoltaicList(businessElectricPhotovoltaic);
        if(list!=null && list.size()>0){
            BusinessElectricPhotovoltaic i = list.get(0);
            i.setGenerateCapacity(this.bl(i.getGenerateCapacity()));
            i.setHeatSupply(this.bl(i.getHeatSupply()));
            i.setRate(this.bl(i.getRate()));
            i.setTotalPrice(new BigDecimal(this.bl(i.getTotalPrice().toString())));
            i.setEva(new BigDecimal(this.bl(i.getEva().toString())));


            i.setGenerateCapacityXg  (this.bl(i.getGenerateCapacityXg  ().toString()));
            i.setGenerateCapacityLg  (this.bl(i.getGenerateCapacityLg  ().toString()));
            i.setGenerateCapacityHs  (this.bl(i.getGenerateCapacityHs  ().toString()));
            i.setIntegratedElectricity(this.bl(i.getIntegratedElectricity().toString()));
            return  AjaxResult.success(i);
        }
        return null;
    }

    /**
     * 查询本年度水电总貌
     */
    @GetMapping("/water")
    @ApiOperation(value = "本年度水电接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricWater.class)
    })
    public AjaxResult water() {
        BusinessElectricWater businessElectricWater = new BusinessElectricWater();
        businessElectricWater.setYear(Long.parseLong(LocalDate.now().getYear()+""));
        List<BusinessElectricWater> list = businessElectricWaterService.selectBusinessElectricWaterList(businessElectricWater);
        if(list!=null && list.size()>0){
            BusinessElectricWater i = list.get(0);
            i.setGenerateCapacity(this.bl(i.getGenerateCapacity()));
            i.setIntegratedelectricity(this.bl(i.getIntegratedelectricity()));
            i.setRate(this.bl(i.getRate()));
            i.setTotalPrice(new BigDecimal(this.bl(i.getTotalPrice().toString())));
            i.setEva(new BigDecimal(this.bl(i.getEva().toString())));


            return  AjaxResult.success(i);
        }
        return null;
    }

    /**
     * 查询本年度风电总貌
     */
    @GetMapping("/wind")
    @ApiOperation(value = "本年度风电接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricWind.class)
    })
    public AjaxResult wind() {
        BusinessElectricWind businessElectricWind = new BusinessElectricWind();
        businessElectricWind.setYear(Long.parseLong(LocalDate.now().getYear()+""));
        List<BusinessElectricWind> list = businessElectricWindService.selectBusinessElectricWindList(businessElectricWind);
        if(list!=null && list.size()>0){
            BusinessElectricWind i = list.get(0);
            i.setGenerateCapacity(this.bl(i.getGenerateCapacity()));
            i.setTotalPrice(new BigDecimal(this.bl(i.getTotalPrice().toString())));
            i.setEva(new BigDecimal(this.bl(i.getEva().toString())));

            i.setGenerateCapacitySbd(this.bl(i.getGenerateCapacitySbd().toString()));
            i.setGenerateCapacityGd (this.bl(i.getGenerateCapacityGd ().toString()));
            i.setGenerateCapacityLp (this.bl(i.getGenerateCapacityLp ().toString()));
            i.setGenerateCapacityMq (this.bl(i.getGenerateCapacityMq ().toString()));
            i.setGenerateCapacityBh (this.bl(i.getGenerateCapacityBh ().toString()));
            i.setGenerateCapacityHly(this.bl(i.getGenerateCapacityHly().toString()));
            i.setTotalPriceSbd      (new BigDecimal(this.bl(i.getTotalPriceSbd      ().toString())));
            i.setTotalPriceGd       (new BigDecimal(this.bl(i.getTotalPriceGd       ().toString())));
            i.setTotalPriceLp       (new BigDecimal(this.bl(i.getTotalPriceLp       ().toString())));
            i.setTotalPriceMq       (new BigDecimal(this.bl(i.getTotalPriceMq       ().toString())));
            i.setTotalPriceBh       (new BigDecimal(this.bl(i.getTotalPriceBh       ().toString())));
            i.setTotalPriceHly      (new BigDecimal(this.bl(i.getTotalPriceHly      ().toString())));
            i.setEvaSbd              (new BigDecimal(this.bl(i.getEvaSbd              ().toString())));
            i.setEvaGd               (new BigDecimal(this.bl(i.getEvaGd               ().toString())));
            i.setEvaLp               (new BigDecimal(this.bl(i.getEvaLp               ().toString())));
            i.setEvaMq               (new BigDecimal(this.bl(i.getEvaMq               ().toString())));
            i.setEvaBh               (new BigDecimal(this.bl(i.getEvaBh               ().toString())));
            i.setEvaHly              (new BigDecimal(this.bl(i.getEvaHly              ().toString())));

            return  AjaxResult.success(i);
        }
        return null;
    }

    /**
     * 查询本年度供热总貌
     */
    @GetMapping("/heart")
    @ApiOperation(value = "本年度供热接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessHeartScore.class)
    })
    public AjaxResult heart() {
        BusinessHeartScore businessHeartScore = new BusinessHeartScore();
        businessHeartScore.setYear(Long.parseLong(LocalDate.now().getYear()+""));
        List<BusinessHeartScore> list = businessHeartScoreService.selectBusinessHeartScoreList(businessHeartScore);
        if(list!=null && list.size()>0){
            BusinessHeartScore i = list.get(0);
            i.setGenerateCapacity(this.bl(i.getGenerateCapacity()));
            i.setTotalPrice(new BigDecimal(this.bl(i.getTotalPrice().toString())));
            i.setIncome(new BigDecimal(this.bl(i.getIncome().toString())));
            i.setGenerateCapacityFirst  (this.bl(i.getGenerateCapacityFirst  ()));
            i.setGenerateCapacitySecond (this.bl(i.getGenerateCapacitySecond ()));
            i.setGenerateCapacityThirdly(this.bl(i.getGenerateCapacityThirdly()));

            return  AjaxResult.success(i);
        }
        return null;
    }
    /**
     * 计算当前日历进度
     */
    @GetMapping("/progress")
    @ApiOperation(value = "计算当前日历进度")
    @ApiResponses({
            @ApiResponse(code = 200,message = "日历进度（**.**%）",response = BusinessHeartScore.class)
    })
    public AjaxResult progress() {
        double day = LocalDate.now().getDayOfYear();
        double year = LocalDate.now().lengthOfYear();
        String dayProgress = new java.text.DecimalFormat("#.00").format(((day/year)*100))+"%";
        return  AjaxResult.success(dayProgress);
    }

    private String bl(String sum){
        if( sum == null) return  "";
        Double s = new Double(sum);
        if(s>=1||s<0){
            return new DecimalFormat("#.00").format(s);
        }else{
            return new DecimalFormat("0.00").format(s);
        }
    }
}
