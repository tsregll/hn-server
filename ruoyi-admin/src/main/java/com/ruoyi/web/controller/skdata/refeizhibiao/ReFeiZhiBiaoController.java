package com.ruoyi.web.controller.skdata.refeizhibiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/refeibaobiao")
public class ReFeiZhiBiaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 岳阳日报表
     */
    @GetMapping("refeizhibiaobaobiao")
    public JSONObject refeizhibiaobaobiao(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", refeizhibiaobaobiaoselect(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> refeizhibiaobaobiaoselect(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowMonth(date)) date = null;
        if(type == null)type = "3";
        if(date != null) date = date+"-01";
        String name = "热费指标统计表";
        String label = "供热量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, label);
        HashMap<String, String> map = DataUtil.dataListY(byLabelName, date, type);

        String label1 = "售热量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName(name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY(byLabelName1, date, type);

        String label3 = "售热价格";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName(name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY(byLabelName3, date, type);

        String label4 = "应收热费";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName(name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY(byLabelName4, date, type);

        String label5 = "实收热费";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName(name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY(byLabelName5, date, type);

        String label6 = "汽折热系数";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName(name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY(byLabelName6, date, type);

        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        return list;
    }

    /**
     * 岳阳日报表
     */
    @GetMapping("refeizhibiaozhexian")
    public JSONObject refeizhibiaozhexian(@RequestParam(value = "date", required = false) String date) {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(date)){
            Integer year = LocalDate.now().getYear();
            Integer month = LocalDate.now().getMonthValue();
            month = month<2?12:month-1;
            date = year+"-"+(month<10?"0"+month:month.toString());
        }
        jsonObject.put("data", refeizhibiaozhexianselect(date));
        jsonObject.put("dateTime",date);
        return jsonObject;
    }
    private HashMap<String,List<String>> refeizhibiaozhexianselect(String date){
//        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowMonth(date)){
        String name = "热费指标统计表";
        String label3 = "售热价格";
        if(date != null) date = date+"-01";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName(name, label3);
        HashMap<String, List<String>> map3 = DataUtil.dataListY(byLabelName3, date);
        List<String> nameList = new ArrayList<>();
        for (SkBbLabel s:byLabelName3) {
            String place = "";
            if(s.getPlace().equals("本月"))place = "本月售热价格";
            if(s.getPlace().equals("同期"))place = "去年同期售热价格";
            if(s.getPlace().equals("同比"))place = "本月售热价格同比增加";
            if(s.getPlace().equals("年累计"))place = "年累计售热价格";
            if(s.getPlace().equals("年同期"))place = "年累计同期售热价格";
            if(s.getPlace().equals("年同比"))place = "本年售热价格同比增加";
            nameList.add(place);
        }
        map3.put("name",nameList);
        return map3;
    }
}