package com.ruoyi.web.controller.skdata.kekaoxingzhibiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.MeiJiZhiBiao;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("mjzb")
public class MeiJiZhiBiaoController {
    @Autowired
    private ISkBbLabelService skBbLabelService;


    /**
     * 煤机环保指标
     */
    @GetMapping("mjhbzb")
    public JSONObject mjhbzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="煤机环保指标";
        String label="原烟气S02浓度";
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="SCR（A侧）进口NOX浓度";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="SCR（B侧）进口NOX浓度";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="粉尘排放浓度";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="SO2排放浓度";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="NOX排放浓度";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="脱硫效率";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="脱硝效率A侧";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="脱硝效率B侧";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
        list.add (map5);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }
    /**
     * 煤机小指标
     */
    @GetMapping("mjxzb")
    public JSONObject mjxzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="煤机小指标";
        String label="运行小时数";
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="负荷率";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电厂用电率";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="空预器出口排烟温度";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="排烟温度（低省）";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

//        String label5="飞灰含碳量";
//        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
//        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="烟气含氧量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="给水温度";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="主汽温度";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="再热气温";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);


        String label10="烟气差压（空预器）A侧";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="烟气差压（空预器）B侧";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);


        String label12="过热器喷水量A侧一级";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="过热器喷水量A侧二级";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="过热器喷水量B侧一级";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="过热器喷水量B侧二级";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="再热器喷水量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

//        String label17="高加投入率";
//        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
//        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

        String label18="高压缸排汽压力";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName (name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY (byLabelName18,date,type);

//        String label19="收球率";
//        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName (name, label19);
//        HashMap<String, String> map19 = DataUtil.dataListY (byLabelName19,date,type);

        String label20="中压缸排汽压力";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName (name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY (byLabelName20,date,type);

        String label21="低压缸排汽压力";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName (name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY (byLabelName21,date,type);

        String label22="真空度";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName (name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY (byLabelName22,date,type);

        String label23="高压缸排汽温度";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName (name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY (byLabelName23,date,type);

        String label24="中压缸排汽温度";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName (name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY (byLabelName24,date,type);

        String label25="低压缸排汽温度";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName (name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY (byLabelName25,date,type);

        String label26="凝汽器端差";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName (name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY (byLabelName26,date,type);

//        String label27="真空系统严密性";
//        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName (name, label27);
//        HashMap<String, String> map27 = DataUtil.dataListY (byLabelName27,date,type);

        String label28="补水率（包括供热）";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName (name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY (byLabelName28,date,type);

        String label29="总给煤量";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName (name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY (byLabelName29,date,type);

        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
//        list.add (map5);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        list.add (map9);
        list.add (map10);
        list.add (map11);
        list.add (map12);
        list.add (map13);
        list.add (map14);
        list.add (map15);
        list.add (map16);
//        list.add (map17);
        list.add (map18);
//        list.add (map19);
        list.add (map20);
        list.add (map21);
        list.add (map22);
        list.add (map23);
        list.add (map24);
        list.add (map25);
        list.add (map26);
//        list.add (map27);
        list.add (map28);
        list.add (map29);


        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }


    /**
     * 导出列表
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermi('business:mjzb:export')")
    public AjaxResult export(@RequestParam(value = "date", required = false) String dateTime, @RequestParam(value = "type", required = false) String type,@RequestParam(value = "name", required = false) String name) throws IOException {
        //1.获取头部标签数据
        List<MeiJiZhiBiao> list = new ArrayList<>();
        Map map;
        String date = dateTime;
        if(name.equals("煤机环保指标")){
            String[] head = DataUtil.getTableHead("meiji1");
            for (int i = 0; i < head.length; i++) {
                if (date==null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
                List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
                map = DataUtil.dataListY(byLabelName, date, type);
                MeiJiZhiBiao meiJiZhiBiao=new MeiJiZhiBiao();
                for(Object key:map.keySet()){
                    meiJiZhiBiao.setIndexName(map.get("labelName").toString());
                    meiJiZhiBiao.setCompany(map.get("unit").toString());
                    meiJiZhiBiao.setCrew1(map.get("key0").toString());
                    meiJiZhiBiao.setCrew2(map.get("key1").toString());
                    meiJiZhiBiao.setCrew3(map.get("key2").toString());
                    meiJiZhiBiao.setCrew4(map.get("key3").toString());
                    meiJiZhiBiao.setCrew5(map.get("key4").toString());
                    meiJiZhiBiao.setCrew6(map.get("key5").toString());
                }
                list.add(meiJiZhiBiao);
            }
            ExcelUtil<MeiJiZhiBiao> util = new ExcelUtil<>(MeiJiZhiBiao.class);
            return util.exportExcelRewrite(list, "煤机环保指标",dateTime);
        }else if(name.equals("煤机小指标")){
            String[] head = DataUtil.getTableHead("meiji2");
            for (int i = 0; i < head.length; i++) {
                if (date==null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
                List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
                map = DataUtil.dataListY(byLabelName, date, type);
                MeiJiZhiBiao meiJiZhiBiao=new MeiJiZhiBiao();
                for(Object key:map.keySet()){
                    meiJiZhiBiao.setIndexName(map.get("labelName").toString());
                    meiJiZhiBiao.setCompany(map.get("unit").toString());
                    meiJiZhiBiao.setCrew1(map.get("key0").toString());
                    meiJiZhiBiao.setCrew2(map.get("key1").toString());
                    meiJiZhiBiao.setCrew3(map.get("key2").toString());
                    meiJiZhiBiao.setCrew4(map.get("key3").toString());
                    meiJiZhiBiao.setCrew5(map.get("key4").toString());
                    meiJiZhiBiao.setCrew6(map.get("key5").toString());
                }
                list.add(meiJiZhiBiao);
            }
            ExcelUtil<MeiJiZhiBiao> util = new ExcelUtil<>(MeiJiZhiBiao.class);
            return util.exportExcelRewrite(list, "煤机小指标",dateTime);
        }
        return null;
    }

}
