package com.ruoyi.web.controller.skdata.baobiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.NianDuBaoBiaoVo;
import com.ruoyi.web.controller.view.QingNengBaoBiaoVo;
import com.ruoyi.web.controller.view.YiYangBaoBiaoVo;
import com.ruoyi.web.controller.view.YueYangNianBaoBiaoVo;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/yueyangbaobiao")
public class YueYangBaoBiaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 岳阳日报表
     */
    @GetMapping("yueyangribaobiao")
    public JSONObject yueyangribaobiao(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", yueyangribaobiaoselect(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> yueyangribaobiaoselect(String date,String type){
        String name = "岳阳电厂日报表";
        String label = "期末装机容量";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, label);
        HashMap<String, String> map = DataUtil.dataListY(byLabelName, date, type);

        String label1 = "发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName(name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY(byLabelName1, date, type);

        String label2 = "发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName(name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY(byLabelName2, date, type);

        String label3 = "其中：试运电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName(name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY(byLabelName3, date, type);

        String label4 = "上网电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName(name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY(byLabelName4, date, type);

        String label5 = "外购电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName(name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY(byLabelName5, date, type);

        String label6 = "其他电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName(name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY(byLabelName6, date, type);

        String label7 = "综合厂用电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName(name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY(byLabelName7, date, type);

        String label8 = "发电厂用电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName(name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY(byLabelName8, date, type);

        String label9 = "供热厂用电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName(name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY(byLabelName9, date, type);

        String label10 = "综合厂用电量率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName(name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY(byLabelName10, date, type);

        String label11 = "发电厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName(name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY(byLabelName11, date, type);

        String label12 = "工业抽汽量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName(name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY(byLabelName12, date, type);

        String label13 = "发电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName(name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY(byLabelName13, date, type);

        String label14 = "供电煤耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName(name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY(byLabelName14, date, type);

        String label15 = "综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName(name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY(byLabelName15, date, type);

        String label16 = "原煤耗用量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName(name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY(byLabelName16, date, type);

        String label17 = "其中：发电原煤耗用量";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName(name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY(byLabelName17, date, type);

        String label18 = "供热耗用原煤量";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName(name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY(byLabelName18, date, type);

        String label19 = "燃油量";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName(name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY(byLabelName19, date, type);

        String label20 = "入炉煤低位发热值";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName(name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY(byLabelName20, date, type);

        String label21 = "等效可用系数";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName(name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY(byLabelName21, date, type);

        String label22 = "出力系数";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName(name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY(byLabelName22, date, type);

        String label23 = "运行小时";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName(name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY(byLabelName23, date, type);

        String label24 = "利用小时";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName(name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY(byLabelName24, date, type);

        String label25 = "供热比";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName(name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY(byLabelName25, date, type);

        String label26 = "NOX排放浓度（CEMS）";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName(name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY(byLabelName26, date, type);

        String label27 = "SO2排放浓度（CEMS）";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName(name, label27);
        HashMap<String, String> map27 = DataUtil.dataListY(byLabelName27, date, type);

        String label28 = "粉尘排放浓度（CEMS)";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName(name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY(byLabelName28, date, type);

        String label29 = "火电发电补水率";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName(name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY(byLabelName29, date, type);


        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        list.add(map10);
        list.add(map11);
        list.add(map12);
        list.add(map13);
        list.add(map14);
        list.add(map15);
        list.add(map16);
        list.add(map17);
        list.add(map18);
        list.add(map19);
        list.add(map20);
        list.add(map21);
        list.add(map22);
        list.add(map23);
        list.add(map24);
        list.add(map25);
        list.add(map26);
        list.add(map27);
        list.add(map28);
        list.add(map29);
        return list;
    }

    /**
     * 岳阳周报表
     */
    @GetMapping("yueyangzhoubaobiao")
    public JSONObject yueyangzhoubaobiao(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", yueyangzhoubaobiaoselect(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> yueyangzhoubaobiaoselect(String date,String type){
        String name = "岳阳电厂周报表";
        String label = "期末装机容量";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowWeek(date)){
            date =null;
        }else{
            date = DataUtil.returnDate(date);
        }
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, label);
        HashMap<String, String> map = DataUtil.dataListY(byLabelName, date, type);

        String label1 = "发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName(name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY(byLabelName1, date, type);

        String label2 = "发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName(name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY(byLabelName2, date, type);

        String label3 = "其中：试运电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName(name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY(byLabelName3, date, type);

        String label4 = "上网电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName(name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY(byLabelName4, date, type);

        String label5 = "外购电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName(name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY(byLabelName5, date, type);

        String label6 = "其他电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName(name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY(byLabelName6, date, type);

        String label7 = "综合厂用电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName(name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY(byLabelName7, date, type);

        String label8 = "发电厂用电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName(name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY(byLabelName8, date, type);

        String label9 = "供热厂用电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName(name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY(byLabelName9, date, type);

        String label10 = "综合厂用电量率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName(name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY(byLabelName10, date, type);

        String label11 = "发电厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName(name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY(byLabelName11, date, type);

        String label12 = "工业抽汽量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName(name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY(byLabelName12, date, type);

        String label13 = "发电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName(name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY(byLabelName13, date, type);

        String label14 = "供电煤耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName(name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY(byLabelName14, date, type);

        String label15 = "综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName(name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY(byLabelName15, date, type);

        String label16 = "原煤耗用量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName(name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY(byLabelName16, date, type);

        String label17 = "其中：发电原煤耗用量";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName(name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY(byLabelName17, date, type);

        String label18 = "供热耗用原煤量";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName(name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY(byLabelName18, date, type);

        String label19 = "燃油量";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName(name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY(byLabelName19, date, type);

        String label20 = "入炉煤低位发热值";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName(name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY(byLabelName20, date, type);

        String label21 = "等效可用系数";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName(name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY(byLabelName21, date, type);

        String label22 = "出力系数";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName(name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY(byLabelName22, date, type);

        String label23 = "运行小时";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName(name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY(byLabelName23, date, type);

        String label24 = "利用小时";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName(name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY(byLabelName24, date, type);

        String label25 = "供热比";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName(name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY(byLabelName25, date, type);

        String label26 = "NOX排放浓度（CEMS）";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName(name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY(byLabelName26, date, type);

        String label27 = "SO2排放浓度（CEMS）";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName(name, label27);
        HashMap<String, String> map27 = DataUtil.dataListY(byLabelName27, date, type);

        String label28 = "粉尘排放浓度（CEMS)";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName(name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY(byLabelName28, date, type);

        String label29 = "火电发电补水率";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName(name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY(byLabelName29, date, type);


        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);

        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        list.add(map10);
        list.add(map11);
        list.add(map12);
        list.add(map13);
        list.add(map14);
        list.add(map15);
        list.add(map16);
        list.add(map17);
        list.add(map18);
        list.add(map19);
        list.add(map20);
        list.add(map21);
        list.add(map22);
        list.add(map23);
        list.add(map24);
        list.add(map25);
        list.add(map26);
        list.add(map27);
        list.add(map28);
        list.add(map29);
        return list;
    }

    /**
     * 岳阳月报表
     */
    @GetMapping("yueyangnianbaobiao")
    public JSONObject yueyangnianbaobiao(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", yueyangnianselect(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> yueyangnianselect(String date,String type){
        String name = "岳阳电厂报表（月度和年度）";
        String label = "期末装机容量";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowMonth(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, label);
        HashMap<String, String> map = DataUtil.dataListY(byLabelName, date, type);

        String label1 = "发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName(name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY(byLabelName1, date, type);

        String label2 = "发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName(name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY(byLabelName2, date, type);

        String label3 = "其中：试运电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName(name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY(byLabelName3, date, type);

        String label4 = "上网电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName(name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY(byLabelName4, date, type);

        String label5 = "外购电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName(name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY(byLabelName5, date, type);

        String label6 = "其他电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName(name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY(byLabelName6, date, type);

        String label7 = "综合厂用电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName(name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY(byLabelName7, date, type);

        String label8 = "发电厂用电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName(name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY(byLabelName8, date, type);

        String label9 = "供热厂用电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName(name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY(byLabelName9, date, type);

        String label10 = "综合厂用电量率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName(name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY(byLabelName10, date, type);

        String label11 = "发电厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName(name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY(byLabelName11, date, type);

        String label12 = "工业抽汽量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName(name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY(byLabelName12, date, type);

        String label13 = "发电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName(name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY(byLabelName13, date, type);

        String label14 = "供电煤耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName(name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY(byLabelName14, date, type);

        String label15 = "综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName(name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY(byLabelName15, date, type);

        String label16 = "原煤耗用量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName(name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY(byLabelName16, date, type);

        String label17 = "其中：发电原煤耗用量";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName(name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY(byLabelName17, date, type);

        String label18 = "供热耗用原煤量";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName(name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY(byLabelName18, date, type);

        String label19 = "燃油量";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName(name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY(byLabelName19, date, type);

        String label20 = "入炉煤低位发热值";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName(name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY(byLabelName20, date, type);

        String label21 = "等效可用系数";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName(name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY(byLabelName21, date, type);

        String label22 = "出力系数";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName(name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY(byLabelName22, date, type);

        String label23 = "运行小时";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName(name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY(byLabelName23, date, type);

        String label24 = "利用小时";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName(name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY(byLabelName24, date, type);

        String label25 = "供热比";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName(name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY(byLabelName25, date, type);

        String label26 = "NOX排放浓度（CEMS）";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName(name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY(byLabelName26, date, type);

        String label27 = "SO2排放浓度（CEMS）";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName(name, label27);
        HashMap<String, String> map27 = DataUtil.dataListY(byLabelName27, date, type);

        String label28 = "粉尘排放浓度（CEMS)";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName(name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY(byLabelName28, date, type);

        String label29 = "火电发电补水率";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName(name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY(byLabelName29, date, type);


        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);

        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        list.add(map10);
        list.add(map11);
        list.add(map12);
        list.add(map13);
        list.add(map14);
        list.add(map15);
        list.add(map16);
        list.add(map17);
        list.add(map18);
        list.add(map19);
        list.add(map20);
        list.add(map21);
        list.add(map22);
        list.add(map23);
        list.add(map24);
        list.add(map25);
        list.add(map26);
        list.add(map27);
        list.add(map28);
        list.add(map29);
        return list;
    }

    /**
     * 岳阳报表导出
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangbaobiao:export')")
    @GetMapping("/yueyangbaobiaoexport")
    public AjaxResult yueyangbaobiaoexport(@RequestParam(value = "exportType", required = false) String exportType, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        ExcelUtil<YiYangBaoBiaoVo> util = new ExcelUtil<YiYangBaoBiaoVo>(YiYangBaoBiaoVo.class);
        List<HashMap<String, String>> selectList = null;
        String name = "";
        if(type.equals("1")){
            selectList = yueyangribaobiaoselect(date,type);
            name = "岳阳电厂生产日报表";
        }else if(type.equals("2")){
            selectList = yueyangzhoubaobiaoselect(date,type);
            name = "岳阳电厂生产周报表";
        }else if(type.equals("3")){
            ExcelUtil<NianDuBaoBiaoVo> nianUtil = new ExcelUtil<NianDuBaoBiaoVo>(NianDuBaoBiaoVo.class);
            selectList = yueyangnianselect(date,type);
            name = "岳阳月年生产报表";
            List<NianDuBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList){
                NianDuBaoBiaoVo q = new NianDuBaoBiaoVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                q.setKey4(map.get("key4"));
                q.setKey5(map.get("key5"));
                q.setKey6(map.get("key6"));
                q.setKey7(map.get("key7"));
                returnList.add(q);
            }
            return nianUtil.exportExcelRewrite(returnList,name,date);
        }else{
            return AjaxResult.error("导出失败");
        }
        List<YiYangBaoBiaoVo> returnList = new ArrayList<>();
        for(HashMap<String,String> map :selectList){
            YiYangBaoBiaoVo q = new YiYangBaoBiaoVo();
            q.setIndexName(map.get("labelName"));
            q.setCompany(map.get("unit"));
            q.setTotal(map.get("key0"));
            q.setCrew1(map.get("key1"));
            q.setCrew2(map.get("key2"));
            q.setCrew3(map.get("key3"));
            q.setCrew4(map.get("key4"));
            q.setCrew5(map.get("key5"));
            q.setCrew6(map.get("key6"));
            q.setXggf(map.get("key7"));
            q.setLgtgf(map.get("key8"));
            q.setShhgf(map.get("key9"));
            returnList.add(q);
        }
        return util.exportExcelRewrite(returnList,name,date);
    }

//    /**
//     * 导出列表
//     */
//    @GetMapping("/export")
//    public AjaxResult export(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
//        //1.获取头部标签数据
//        List<YiYangBaoBiaoVo> list = new ArrayList<>();
//        String name = "岳阳电厂报表（月度和年度）";
//        String[] head = this.getTableHead("yiyang");
//        //2.获取表第一排数据
//        //3.查询所有数据
//        Map map;
//        for (int i = 0; i < head.length; i++) {
//            if ("".equals(date)) date = null;
//            List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
//            map = DataUtil.dataListY(byLabelName, date, type);
//            JSONObject json = new JSONObject(map);
//            YiYangBaoBiaoVo yiYangBaoBiaoVo = json.toJavaObject(YiYangBaoBiaoVo.class);
//            list.add(yiYangBaoBiaoVo);
//
//        }
//        ExcelUtil<YiYangBaoBiaoVo> util = new ExcelUtil<>(YiYangBaoBiaoVo.class);
//        return util.exportExcel(list, "YiYangBaoBiao");
//    }

    /**
     * 导出车辆里程台账列表
     */
    @GetMapping("/export1")
    public AjaxResult export1(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        //1.获取头部标签数据
        List<YueYangNianBaoBiaoVo> list = new ArrayList<>();
        String name = "岳阳电厂报表（月度和年度）";
        String[] head = this.getTableHead("yiyang");
        //2.获取表第一排数据
        //3.查询所有数据
        Map map;
        for (int i = 0; i < head.length; i++) {
            if ("".equals(date)) date = null;
            List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
            map = DataUtil.dataListY(byLabelName, date, type);
            JSONObject json = new JSONObject(map);
            YueYangNianBaoBiaoVo yueYangNianBaoBiaoVo = json.toJavaObject(YueYangNianBaoBiaoVo.class);
            list.add(yueYangNianBaoBiaoVo);

        }
        ExcelUtil<YueYangNianBaoBiaoVo> util = new ExcelUtil<>(YueYangNianBaoBiaoVo.class);
        return util.exportExcel(list, "YiYangBaoBiao");
    }




    public String[] getTableHead(String tableType) {
        Properties properties = new Properties();
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("baobiao.properties");
            //遍历取值
            Set<Object> objects = properties.keySet();
            StringBuffer tableHead = new StringBuffer();
            String head;
            if (tableType.equals("yiyang")) {
                head = new String(properties.getProperty("yiyangbaobiaotou").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("")) {

            } else if (tableType.equals("")) {

            } else if (tableType.equals("")) {

            }
            String[] tablehead = tableHead.toString().split(",");
            return tablehead;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 日期格式
        c.setTime(new Date());
        boolean isFirstSunday = (c.getFirstDayOfWeek() == Calendar.SUNDAY);
        int weekDay = c.get(Calendar.DAY_OF_WEEK);
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        int Day = c.get(Calendar.WEEK_OF_YEAR);
        Date[] week = new Date[6];
        int begin = 0;
        int end = 6;
        for (int i = 0; i < 6; i++) {
            if (i == weekDay) {
                week[i] = new Date();
                begin=0-i;
                end=6-i;
            }
        }
        System.out.println(begin);
        System.out.println(end);

        Date beginDate = addDate(new Date(), begin); // 指定日期加上20天
        Date endDate = addDate(new Date(), end); // 指定日期加上20天
        System.out.println(dateFormat.format(beginDate));// 输出格式化后的日期
        System.out.println(dateFormat.format(endDate));
    }

    // 注意day 必须是long类型 否者会超精度影响结果
    public static Date addDate(Date date,long day) {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
        time+=day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }

}