package com.ruoyi.web.controller.business.front;

import com.ruoyi.business.service.IBusinessAdministrativeVehicleService;
import com.ruoyi.common.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 车辆管理
 * Controller
 *
 * @author gwsh
 * @date 2021-03-03
 */
@RestController
@RequestMapping("/front/vehicle")
public class VehicleController extends BaseController {
    @Autowired
    private IBusinessAdministrativeVehicleService businessAdministrativeVehicleService;


}
