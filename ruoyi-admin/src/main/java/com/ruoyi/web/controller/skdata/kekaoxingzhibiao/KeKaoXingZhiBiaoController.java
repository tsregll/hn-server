package com.ruoyi.web.controller.skdata.kekaoxingzhibiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.FdkkxzbVo;
import com.ruoyi.web.controller.view.GfkkxzbVo;
import com.ruoyi.web.controller.view.XqsdkkxzbVo;
import com.ruoyi.web.controller.view.YyzbVo;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kkxzb")
public class KeKaoXingZhiBiaoController {
    @Autowired
    private ISkBbLabelService skBbLabelService;


    /**
     * 岳阳煤机可靠性指标
     */
    @GetMapping("yymjkkxzb")
    public JSONObject yymjkkxzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="岳阳煤机可靠性指标";
        String label="运行小时";
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="停用小时";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

//        String label2="备用小时";
//        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
//        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);
//
//        String label3="计停小时";
//        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
//        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);
//
//        String label4="非计停小时";
//        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
//        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);
//
//        String label5="降低出力等效停运小时";
//        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
//        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="等效可用小时";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="等效可用系数";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="出力系数";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="平均利用率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="平均可调出力";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="停机次数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

//        String label12="非计划停机次数";
//        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
//        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);
//
//        String label13="全厂安全运行天数";
//        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
//        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);
//
//        String label14="全厂安全运行月数";
//        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
//        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);




        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
//        list.add (map2);
//        list.add (map3);
//        list.add (map4);
//        list.add (map5);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        list.add (map9);
        list.add (map10);
        list.add (map11);
//        list.add (map12);
//        list.add (map13);
//        list.add (map14);


        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }


    /**
     * 湘祁水电可靠性指标
     */
    @GetMapping("xqsdkkxzb")
    public JSONObject xqsdkkxzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="湘祁水电可靠性指标";
        String label="运行小时";
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="停用小时";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

//        String label2="备用小时";
//        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
//        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);
//
//        String label3="计停小时";
//        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
//        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);
//
//        String label4="非计停小时";
//        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
//        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label6="等效可用小时";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="等效可用系数";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="出力系数";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="平均利用率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="平均可调出力";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="停机次数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

//        String label12="非计划停机次数";
//        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
//        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);
//
//        String label13="全厂安全运行天数";
//        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
//        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);
//
//        String label14="全厂安全运行月数";
//        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
//        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);




        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
//        list.add (map2);
//        list.add (map3);
//        list.add (map4);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        list.add (map9);
        list.add (map10);
        list.add (map11);
//        list.add (map12);
//        list.add (map13);
//        list.add (map14);


        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }

    /**
     * 风电可靠性指标
     */
    @GetMapping("fdkkxzb")
    public JSONObject fdkkxzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="风电可靠性指标";
        String label="运行小时";
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="停用小时";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

//        String label2="备用小时";
//        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
//        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);
//
//        String label3="计停小时";
//        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
//        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);
//
//        String label4="非计停小时";
//        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
//        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label6="等效可用小时";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="等效可用系数";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="出力系数";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="平均利用率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="平均可调出力";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="停机次数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

//        String label12="非计划停机次数";
//        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
//        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);
//
//        String label13="全厂安全运行天数";
//        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
//        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);
//
//        String label14="全厂安全运行月数";
//        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
//        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);




        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
//        list.add (map2);
//        list.add (map3);
//        list.add (map4);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        list.add (map9);
        list.add (map10);
        list.add (map11);
//        list.add (map12);
//        list.add (map13);
//        list.add (map14);


        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }
    /**
     * 光伏可靠性指标
     */
    @GetMapping("gfkkxzb")
    public JSONObject gfkkxzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="光伏可靠性指标";
        String label="运行小时";
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="停用小时";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

//        String label2="备用小时";
//        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
//        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);
//
//        String label3="计停小时";
//        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
//        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);
//
//        String label4="非计停小时";
//        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
//        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label6="等效可用小时";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="等效可用系数";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="出力系数";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="平均利用率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="平均可调出力";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="停机次数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

//        String label12="非计划停机次数";
//        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
//        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);
//
//        String label13="全厂安全运行天数";
//        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
//        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);
//
//        String label14="全厂安全运行月数";
//        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
//        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);


        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
//        list.add (map2);
//        list.add (map3);
//        list.add (map4);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        list.add (map9);
        list.add (map10);
        list.add (map11);
//        list.add (map12);
//        list.add (map13);
//        list.add (map14);


        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }


    /**
     * 导出列表
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermi('business:kkxzb:export')")
    public AjaxResult export(@RequestParam(value = "date", required = false) String dateTime, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "name", required = false) String name) throws IOException {
        //1.获取头部标签数据
        Map map;
        String date = dateTime;
        if(name.equals("岳阳煤机可靠性指标")){
            List<YyzbVo> list = new ArrayList<>();
            String[] head = DataUtil.getTableHead("yyzb");
            for (int i = 0; i < head.length; i++) {
                if (date == null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
                List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
                map = DataUtil.dataListY(byLabelName, date, type);
                YyzbVo yyzbVo=new YyzbVo();
                for(Object key:map.keySet()){
                    yyzbVo.setIndexName(map.get("labelName").toString());
                    yyzbVo.setCompany(map.get("unit").toString());
                    yyzbVo.setCrew1(map.get("key0").toString());
                    yyzbVo.setCrew2(map.get("key1").toString());
                    yyzbVo.setCrew3(map.get("key2").toString());
                    yyzbVo.setCrew4(map.get("key3").toString());
                    yyzbVo.setCrew5(map.get("key4").toString());
                    yyzbVo.setCrew6(map.get("key5").toString());
                    yyzbVo.setTotal(map.get("key6").toString());
                }
                list.add(yyzbVo);
            }
            ExcelUtil<YyzbVo> util = new ExcelUtil<>(YyzbVo.class);
            return util.exportExcelRewrite(list, "岳阳煤机可靠性指标",dateTime);
        }else if(name.equals("风电可靠性指标")){
            List<FdkkxzbVo> list = new ArrayList<>();
            String[] head = DataUtil.getTableHead("fdkkxzb");
            for (int i = 0; i < head.length; i++) {
                if (date == null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
                List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
                map = DataUtil.dataListY(byLabelName, date, type);
                FdkkxzbVo fdkkxzbVo=new FdkkxzbVo();
                for(Object key:map.keySet()){
                    fdkkxzbVo.setIndexName(map.get("labelName").toString());
                    fdkkxzbVo.setCompany(map.get("unit").toString());
                    fdkkxzbVo.setCrew1(map.get("key0").toString());
                    fdkkxzbVo.setCrew2(map.get("key1").toString());
                    fdkkxzbVo.setCrew3(map.get("key2").toString());
                    fdkkxzbVo.setCrew4(map.get("key3").toString());
                    fdkkxzbVo.setCrew5(map.get("key4").toString());
                    fdkkxzbVo.setCrew6(map.get("key5").toString());
                    fdkkxzbVo.setTotal(map.get("key6").toString());
                }
                list.add(fdkkxzbVo);
            }
            ExcelUtil<FdkkxzbVo> util = new ExcelUtil<>(FdkkxzbVo.class);
            return util.exportExcelRewrite(list, "风电可靠性指标",dateTime);
        }else if(name.equals("光伏可靠性指标")){
            List<GfkkxzbVo> list = new ArrayList<>();
            String[] head = DataUtil.getTableHead("gfkkxzb");
            for (int i = 0; i < head.length; i++) {
                if (date == null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
                List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
                map = DataUtil.dataListY(byLabelName, date, type);
                GfkkxzbVo gfkkxzbVo=new GfkkxzbVo();
                for(Object key:map.keySet()){
                    gfkkxzbVo.setIndexName(map.get("labelName").toString());
                    gfkkxzbVo.setCompany(map.get("unit").toString());
                    gfkkxzbVo.setCrew1(map.get("key0").toString());
                    gfkkxzbVo.setCrew2(map.get("key1").toString());
                    gfkkxzbVo.setCrew3(map.get("key2").toString());
                    gfkkxzbVo.setCrew4(map.get("key3").toString());
                }
                list.add(gfkkxzbVo);
            }
            ExcelUtil<GfkkxzbVo> util = new ExcelUtil<>(GfkkxzbVo.class);
            return util.exportExcelRewrite(list, "光伏可靠性指标",dateTime);
        }else if(name.equals("湘祁水电可靠性指标")){
            List<XqsdkkxzbVo> list = new ArrayList<>();
            String[] head = DataUtil.getTableHead("xqsdkkxzb");
            for (int i = 0; i < head.length; i++) {
                if (date == null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
                List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, head[i]);
                map = DataUtil.dataListY(byLabelName, date, type);
                XqsdkkxzbVo xqsdkkxzbVo=new XqsdkkxzbVo();
                for(Object key:map.keySet()){
                    xqsdkkxzbVo.setIndexName(map.get("labelName").toString());
                    xqsdkkxzbVo.setCompany(map.get("unit").toString());
                    xqsdkkxzbVo.setCrew1(map.get("key0").toString());
                    xqsdkkxzbVo.setCrew2(map.get("key1").toString());
                    xqsdkkxzbVo.setCrew3(map.get("key2").toString());
                    xqsdkkxzbVo.setCrew4(map.get("key3").toString());
                    xqsdkkxzbVo.setCrew5(map.get("key4").toString());
                }
                list.add(xqsdkkxzbVo);
            }
            ExcelUtil<XqsdkkxzbVo> util = new ExcelUtil<>(XqsdkkxzbVo.class);
            return util.exportExcelRewrite(list, "湘祁水电可靠性指标",dateTime);
        }
        return null;
    }
}
