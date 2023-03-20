package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IBusinessStatisticsVehicleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/business/statisticsVehicle")
public class BusinessStatisticsVehicleController extends BaseController {

    @Autowired
    private IBusinessStatisticsVehicleService iBusinessStatisticsVehicleService;

    @GetMapping("/selectStaAll")
    public AjaxResult selectStaAll()
    {
//        SELECT bvm.license_plate_number,SUM(bvm.vehicle_mileage) sum_vehicle_mileage FROM business_vehicle_mileage bvm
//        LEFT JOIN business_administrative_vehicle bav ON bav.id=bvm.vehicleid
//        GROUP BY bvm.vehicleid
//        ORDER BY sum_vehicle_mileage DESC LIMIT 5
        List<Object> staAll=iBusinessStatisticsVehicleService.businessStatisticsVehicleForAll();
        if (!staAll.isEmpty()) {
            return AjaxResult.success(staAll);
        }else{
            return null;
        }
    }

    @GetMapping("/{id}")
    public AjaxResult selectStaForOne(@PathVariable("id") Long id)
    {
        List<Object> staAll=iBusinessStatisticsVehicleService.BusinessStatisticsVehicleForOne(id);
        if (!staAll.isEmpty()) {
            return AjaxResult.success(staAll);
        }else{
            return null;
        }
    }

    @GetMapping("/selectStaForYear")
    public AjaxResult selectStaForYear()
    {
        List<Object> staAll=iBusinessStatisticsVehicleService.businessStatisticsVehicleForYear();
        if (!staAll.isEmpty()) {
            return AjaxResult.success(staAll);
        }else{
            return null;
        }
    }
}
