package com.ruoyi.web.controller.business;


import com.ruoyi.business.service.impl.BusinessXnyServiceImpl;
import com.ruoyi.business.vo.BusinessXnyProjectVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class BusinessXnyController {

    @Resource
    private BusinessXnyServiceImpl businessXnyService;


    @GetMapping("business/getlist")
    public List<BusinessXnyProjectVo> getProject(String selectYear){
        System.out.print(selectYear);
        return businessXnyService.getProject(selectYear);
    }

//    导入excel
    @RequestMapping("/business/UpdateNodeProgress")
    public void importFile(@RequestBody List<BusinessXnyProjectVo> businessXnyProjectVos){
        businessXnyService.importFile(businessXnyProjectVos);
    }


}
