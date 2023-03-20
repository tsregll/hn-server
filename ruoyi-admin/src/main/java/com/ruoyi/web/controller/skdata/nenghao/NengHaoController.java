package com.ruoyi.web.controller.skdata.nenghao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.*;
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

@RestController
@RequestMapping("/nenghao")
public class NengHaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 区域能耗报表导出
     */
    @PreAuthorize("@ss.hasPermi('business:nenghao:export')")
    @GetMapping("/nenghaobaobiaoexport")
    public AjaxResult nenghaobaobiaoexport(@RequestParam(value = "exportType", required = false) String exportType, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        List<HashMap<String, String>> selectList = null;
        String name = "";
        if (exportType.equals("1")) {
            selectList = quyuhejinenghaochaxun(date, type);
            name = "区域能耗合计报表";
            ExcelUtil<NengHaoGuanLiQuYuVo> util = new ExcelUtil<NengHaoGuanLiQuYuVo>(NengHaoGuanLiQuYuVo.class);
            List<NengHaoGuanLiQuYuVo> returnList = new ArrayList<>();
            for (HashMap<String, String> map : selectList) {
                NengHaoGuanLiQuYuVo q = new NengHaoGuanLiQuYuVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                q.setKey4(map.get("key4"));
                returnList.add(q);
            }
            return util.exportExcelRewrite(returnList,name,date);
        } else if (exportType.equals("2")) {
            selectList = meijinenghaochaxun(date, type);
            name = "煤机能耗报表";
            ExcelUtil<NengHaoGuanLiMeiJiVo> util = new ExcelUtil<NengHaoGuanLiMeiJiVo>(NengHaoGuanLiMeiJiVo.class);
            List<NengHaoGuanLiMeiJiVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList){
                NengHaoGuanLiMeiJiVo q = new NengHaoGuanLiMeiJiVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                q.setKey4(map.get("key4"));
                q.setKey5(map.get("key5"));
                q.setKey6(map.get("key6"));
                returnList.add(q);
            }
            return util.exportExcelRewrite(returnList,name,date);
        } else if (exportType.equals("3")) {
            selectList = shuidiannenghaochaxun(date, type);
            name = "水电能耗报表";
            ExcelUtil<NengHaoGuanLiShuiDianVo> util = new ExcelUtil<NengHaoGuanLiShuiDianVo>(NengHaoGuanLiShuiDianVo.class);
            List<NengHaoGuanLiShuiDianVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList){
                NengHaoGuanLiShuiDianVo q = new NengHaoGuanLiShuiDianVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                q.setKey4(map.get("key4"));
                returnList.add(q);
            }
            return util.exportExcelRewrite(returnList,name,date);
        } else if (exportType.equals("4")) {
            selectList = fengdiannenghaochaxun(date, type);
            name = "风电能耗报表";
            ExcelUtil<NengHaoGuanLiFengDianVo> util = new ExcelUtil<NengHaoGuanLiFengDianVo>(NengHaoGuanLiFengDianVo.class);
            List<NengHaoGuanLiFengDianVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList){
                NengHaoGuanLiFengDianVo q = new NengHaoGuanLiFengDianVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                q.setKey4(map.get("key4"));
                q.setKey5(map.get("key5"));
                q.setKey6(map.get("key6"));
                returnList.add(q);
            }
            return util.exportExcelRewrite(returnList,name,date);
        } else if (exportType.equals("5")) {
            selectList = guangfunenghaochaxun(date, type);
            name = "光伏能耗报表";
            ExcelUtil<NengHaoGuanLiGuangFuVo> util = new ExcelUtil<NengHaoGuanLiGuangFuVo>(NengHaoGuanLiGuangFuVo.class);
            List<NengHaoGuanLiGuangFuVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList){
                NengHaoGuanLiGuangFuVo q = new NengHaoGuanLiGuangFuVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                returnList.add(q);
            }
            return util.exportExcelRewrite(returnList,name,date);
        } else {
            return AjaxResult.error("导出失败");
        }
    }

    //-------------------------------------------------------------------------------
    /**
     * 区域合计能耗
     */
    @GetMapping("/quyuhejinenghao")
    public JSONObject quyuhejinenghao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",quyuhejinenghaochaxun(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> quyuhejinenghaochaxun(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type =null;
        }
        String name="区域合计能耗";
        String label="日生产厂用电率";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="日发电煤耗";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="日供电煤耗";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="日综合供电煤耗";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="日耗水率";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="年度累计生产厂用电率";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="年度累计发电煤耗";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="年度累计供电煤耗";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="年度累计综合供电煤耗";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="年度累计耗水率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

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
        list.add (map9);
        return list;
    }

    //------------------------------------------------------------------------------------------------
    /**
     * 风电能耗
     */
    @GetMapping("/fengdiannenghao")
    public JSONObject fengdiannenghao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){

        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",fengdiannenghaochaxun(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> fengdiannenghaochaxun(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type =null;
        }
        String name="风电能耗";
        String label="日发电量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="日上网电量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="生产厂用电率";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="平均风速";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="综合厂用电率";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="日利用小时数";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="年度累计发电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="年度累计上网电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="年度累计生产厂用电率";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="年平均风速";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="年度综合厂用电率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="年度利用小时数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

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
        list.add (map9);
        list.add (map10);
        list.add (map11);
        return list;
    }

    //------------------------------------------------------------------------------------------------
    /**
     * 光伏能耗
     */
    @GetMapping("/guangfunenghao")
    public JSONObject guangfunenghao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",guangfunenghaochaxun(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> guangfunenghaochaxun(String date,String type) {
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) {
            date = null;
            type = null;
        }
        String name="光伏能耗";
        String label="日发电量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="日上网电量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="日生产厂用电率";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="日利用小时数";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="年度累计发电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="年度累计上网电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="年度累计生产厂用电率";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="年度累计利用小时数";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);
        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
        list.add (map5);
        list.add (map6);
        list.add (map7);
        return list;
    }

    //------------------------------------------------------------------------------------------------
    /**
     * 煤机能耗
     */
    @GetMapping("/meijinenghao")
    public JSONObject meijinenghao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",meijinenghaochaxun(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> meijinenghaochaxun(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type =null;
        }
        String name="煤机能耗";
        String label="日发电量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="日上网电量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="日生产厂用电率";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="日发电煤耗";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="日供电煤耗";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="日综合厂用电率";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="日综合供电煤耗";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="日机组负荷率";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="日利用小时数";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="年度累计发电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="年度累计上网电量";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="年度累计生产厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="年度累计发电煤耗";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="年度累计供电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="年度累计综合厂用电率";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="年度累计综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="年度累计机组负荷率";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

        String label17="年度累计利用小时数";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

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
        list.add (map9);
        list.add (map10);
        list.add (map11);
        list.add (map12);
        list.add (map13);
        list.add (map14);
        list.add (map15);
        list.add (map16);
        list.add (map17);
        return list;
    }

    //------------------------------------------------------------------------------------------------
    /**
     * 水电能耗
     */
    @GetMapping("/shuidiannenghao")
    public JSONObject shuidiannenghao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",shuidiannenghaochaxun(date, type));
        return jsonObject;
    }
    private List<HashMap<String,String>> shuidiannenghaochaxun(String date,String type) {
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) {
            date = null;
            type = null;
        }
        String name="水电能耗";
        String label="日发电量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="日上网电量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="日入库流量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="日出库流量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="日耗水率";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="日生产厂用电率";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="日综合厂用电率";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="日利用小时数";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="年度累计发电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="年度累计上网电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="年度累计入库流量";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="年度累计出库流量";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="年度累计耗水率";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="年度累计生产厂用电率";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="年度累计综合厂用电率";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="年度累计利用小时数";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);



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
        list.add (map9);
        list.add (map10);
        list.add (map11);
        list.add (map12);
        list.add (map13);
        list.add (map14);
        list.add (map15);
    return list;
    }
}
