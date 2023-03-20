package com.ruoyi.web.controller.skdata.baobiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.IBusinessElectricTradeService;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.NianDuBaoBiaoVo;
import com.ruoyi.web.controller.view.QingNengBaoBiaoVo;
import com.ruoyi.web.controller.view.ShiChangJiaoYiBaoBiaoVo;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shichangjiaoyibaobiao")
public class ShiChangJiaoyiBaoBiaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;
    @Autowired
    private IBusinessElectricTradeService businessElectricTradeService;

    /**
     * 市场交易情况明细表导出
     */
    @PreAuthorize("@ss.hasPermi('business:shichangjiaoyibaobiao:export')")
    @GetMapping("/shichangjiaoyibaobiaoexport")
    public AjaxResult shichangjiaoyibaobiaoexport(@RequestParam(value = "date", required = false) String date) {
        ExcelUtil<ShiChangJiaoYiBaoBiaoVo> util = new ExcelUtil<>(ShiChangJiaoYiBaoBiaoVo.class);
        List<HashMap<String, String>> selectList = null;
        String name = "";
            ExcelUtil<ShiChangJiaoYiBaoBiaoVo> nianUtil = new ExcelUtil<>(ShiChangJiaoYiBaoBiaoVo.class);
        selectList = businessElectricTradeService.selectGroupByMonthTrade(date);
        name = "市场交易情况明细表";
            List<ShiChangJiaoYiBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList){
                ShiChangJiaoYiBaoBiaoVo q = new ShiChangJiaoYiBaoBiaoVo();
                q.setUnit(map.get("name"));
                q.setKey00(map.get("dl1"));
                q.setKey01(map.get("dl2"));
                q.setKey02(map.get("dl3"));
                q.setKey03(map.get("dl4"));
                q.setKey04(map.get("dl5"));
                q.setKey05(map.get("dl6"));
                q.setKey06(map.get("dl7"));
                q.setKey07(map.get("dl8"));
                q.setKey08(map.get("dl9"));
                q.setKey09(map.get("dl10"));
                q.setKey010(map.get("dl11"));
                q.setKey011(map.get("dl12"));
                q.setKey012(map.get("yeardl"));
                q.setKey10(map.get("dj1"));
                q.setKey11(map.get("dj2"));
                q.setKey12(map.get("dj3"));
                q.setKey13(map.get("dj4"));
                q.setKey14(map.get("dj5"));
                q.setKey15(map.get("dj6"));
                q.setKey16(map.get("dj7"));
                q.setKey17(map.get("dj8"));
                q.setKey18(map.get("dj9"));
                q.setKey19(map.get("dj10"));
                q.setKey110(map.get("dj11"));
                q.setKey111(map.get("dj12"));
                q.setKey112(map.get("yeardj"));
                returnList.add(q);
            }
            return nianUtil.exportExcelRewrite(returnList,name,date);
    }
}
