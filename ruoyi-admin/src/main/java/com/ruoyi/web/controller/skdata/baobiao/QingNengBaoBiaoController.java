package com.ruoyi.web.controller.skdata.baobiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.NianDuBaoBiaoVo;
import com.ruoyi.web.controller.view.QingNengBaoBiaoVo;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/qingnengbaobiao")
public class QingNengBaoBiaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 清能日报表导出
     */
    @PreAuthorize("@ss.hasPermi('business:qingnengbaobiao:export')")
    @GetMapping("/qingnengbaobiaoexport")
    public AjaxResult qingnengbaobiaoexport(@RequestParam(value = "exportType", required = false) String exportType, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "type", required = false) String type) {
        ExcelUtil<QingNengBaoBiaoVo> util = new ExcelUtil<QingNengBaoBiaoVo>(QingNengBaoBiaoVo.class);
        List<HashMap<String, String>> selectList = null;
        String name = "";
        if(type.equals("1")){
            selectList = qingnengribaobiaochaxun(date,type);
            name = "清能公司生产日报表";
        }else if(type.equals("2")){
            selectList = qingnengzhoubaobiaochaxun(date,type);
            name = "清能公司生产周报表";
        }else if(type.equals("3")){
            ExcelUtil<NianDuBaoBiaoVo> nianUtil = new ExcelUtil<NianDuBaoBiaoVo>(NianDuBaoBiaoVo.class);
            selectList = qingnengnianbaobiaochaxun(date,type);
            name = "清能公司生产月年报表";
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
        List<QingNengBaoBiaoVo> returnList = new ArrayList<>();
        for(HashMap<String,String> map :selectList){
            QingNengBaoBiaoVo q = new QingNengBaoBiaoVo();
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
            q.setKey8(map.get("key8"));
            q.setKey9(map.get("key9"));
            q.setKey10(map.get("key10"));
            q.setKey11(map.get("key11"));
            returnList.add(q);
        }
        return util.exportExcelRewrite(returnList,name,date);
    }

    /**
     * 清能日报表
     */
    @GetMapping("qingnengribaobiao")
    public JSONObject qingnengribaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",qingnengribaobiaochaxun(date, type));
        return jsonObject;
    }
    public List<HashMap<String,String>> qingnengribaobiaochaxun(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type =null;
        }
        String name="清能日报表";
        String label="期末装机容量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="其中试运电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="上网电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="外购电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="其他电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="综合厂用电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="发电厂用电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="综合厂用电量率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="发电厂用电率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="出力系数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="运行小时";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="利用小时";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="水电耗水耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="等效可用系数";
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

    /**
     * 清能周报表
     */
    @GetMapping("qingnengzhoubaobiao")
    public JSONObject qingnengzhoubaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",qingnengzhoubaobiaochaxun(date, type));
        return jsonObject;
    }
    public List<HashMap<String,String>> qingnengzhoubaobiaochaxun(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowWeek(date)){
            date =null;
            type =null;
        }else{
            date = DataUtil.returnDate(date);
        }
        String name="清能周报表";
        String label="期末装机容量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="其中试运电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="上网电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="外购电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="其他电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="综合厂用电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="发电厂用电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="综合厂用电量率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="发电厂用电率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="出力系数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="运行小时";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="利用小时";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="水电耗水耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="等效可用系数";
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

    /**
     * 清能月报表
     */
    @GetMapping("qingnengnianbaobiao")
    public JSONObject qingnengnianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",qingnengnianbaobiaochaxun(date, type));
        return jsonObject;
    }
    public List<HashMap<String,String>> qingnengnianbaobiaochaxun(String date,String type){
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowMonth(date)){
            date =null;
            type =null;
        }
        String name="清能报表（月度和年度）";
        String label="期末装机容量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="其中试运电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="上网电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="外购电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="其他电量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="综合厂用电量";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="发电厂用电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="综合厂用电量率";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="发电厂用电率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="出力系数";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="运行小时";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="利用小时";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="水电耗水耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="等效可用系数";
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

    /**
     * 清能分析报表
     */
    @GetMapping("qingnengfenxianbaobiao")
    public JSONObject qingnengfenxianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="清能公司分析报表";
        String label="发电机组台数";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="日历小时";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="发电量";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="其中：试运电量";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="上网电量";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="发电设备平均容量";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="发电设备平均利用小时";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="计算场用电率的发电量";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="外购电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="其他电量";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="风电场全部耗用电量";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="发电场用电量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="综合场用电率";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="场用电率";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="运行小时";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="备用小时";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

        String label17="计划停运小时";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

        String label18="非计划停运小时";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName (name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY (byLabelName18,date,type);

        String label19="等效可用小时";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName (name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY (byLabelName19,date,type);

        String label20="等效可用系数";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName (name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY (byLabelName20,date,type);

        String label21="平均利用率";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName (name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY (byLabelName21,date,type);

        String label22="平均可调出力";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName (name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY (byLabelName22,date,type);

        String label23="非计划停运次数";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName (name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY (byLabelName23,date,type);

        String label24="安全运行天数";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName (name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY (byLabelName24,date,type);

        String label25="平均风速";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName (name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY (byLabelName25,date,type);

        String label26="最高负荷";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName (name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY (byLabelName26,date,type);

        String label27="弃风电量";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName (name, label27);
        HashMap<String, String> map27 = DataUtil.dataListY (byLabelName27,date,type);

        String label28="其中：网架原因";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName (name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY (byLabelName28,date,type);

        String label29="机组本身故障";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName (name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY (byLabelName29,date,type);

        String label30="其它原因";
        List<SkBbLabel> byLabelName30 = skBbLabelService.findByLabelName (name, label30);
        HashMap<String, String> map30 = DataUtil.dataListY (byLabelName30,date,type);

        String label31="弃风率";
        List<SkBbLabel> byLabelName31 = skBbLabelService.findByLabelName (name, label31);
        HashMap<String, String> map31 = DataUtil.dataListY (byLabelName31,date,type);

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
        list.add (map18);
        list.add (map19);
        list.add (map20);
        list.add (map21);
        list.add (map22);
        list.add (map23);
        list.add (map24);
        list.add (map25);
        list.add (map26);
        list.add (map27);
        list.add (map28);
        list.add (map29);
        list.add (map30);
        list.add (map31);


        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }
}
