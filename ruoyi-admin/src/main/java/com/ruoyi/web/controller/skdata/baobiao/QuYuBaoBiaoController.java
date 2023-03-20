
package com.ruoyi.web.controller.skdata.baobiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.JiDuBaoBiaoVo;
import com.ruoyi.web.controller.view.NianDuBaoBiaoVo;
import com.ruoyi.web.controller.view.QuYuBaoBiaoVo;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/quyubaobiao")
public class QuYuBaoBiaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     * 区域合计日报表
     */
    @GetMapping("quyuribaobiao")
    public JSONObject quyuribaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",ribaobiao(date, type));
        return jsonObject;
    }
    /**
     * 区域周报表
     */
    @GetMapping("quyuzhoubaobiao")
    public JSONObject quyuzhoubaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
//        Date d = new Date();
//        try {
//            d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar ca =Calendar.getInstance ();
//        ca.setTime(d);
////        ca.setFirstDayOfWeek(Calendar.THURSDAY);//设置周一为一周的第一天
//        int num = ca.get(Calendar.DAY_OF_WEEK);
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",zhoubaobiao(date, type));
        return jsonObject;
    }
    /**
     * 区域月报表
     */
    @GetMapping("quyunianbaobiao")
    public JSONObject quyunianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){

        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",yuenianbaobiao(date, type));
        return jsonObject;
    }
    //----------------------导出-------------------------
    /**
     * 区域日报表导出
     */
    @PreAuthorize("@ss.hasPermi('business:quyubaobiao:export')")
    @Log(title = "区域报表导出", businessType = BusinessType.EXPORT)
    @GetMapping("quyubaobiaoexport")
    public AjaxResult quyubaobiaoexport(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type, @RequestParam(value = "abandonmentGroup",required = false) String quarter){
        ExcelUtil<QuYuBaoBiaoVo> util = new ExcelUtil<QuYuBaoBiaoVo>(QuYuBaoBiaoVo.class);
        List<HashMap<String,String>> list = null;
        String name = "";
        if(type.equals("1")){
            list = ribaobiao(date,type);
            name = "湖南分公司日生产报表";
        }else if(type.equals("2")){
            list = zhoubaobiao(date,type);
            name = "湖南分公司周生产报表";
        }else if(type.equals("3")){
            ExcelUtil<NianDuBaoBiaoVo> nianUtil = new ExcelUtil<NianDuBaoBiaoVo>(NianDuBaoBiaoVo.class);
            list = yuenianbaobiao(date,type);
            name = "湖南分公司月年生产报表";
            List<NianDuBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :list){
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
            AjaxResult ar = nianUtil.exportExcelRewrite(returnList,name,date);
            return ar;
        }else if(type.equals("4")){
            ExcelUtil<JiDuBaoBiaoVo> nianUtil = new ExcelUtil<JiDuBaoBiaoVo>(JiDuBaoBiaoVo.class);
            list = jibaobiao(date,quarter);
            name = "湖南分公司";
            if(quarter == null || quarter.trim().equals("")){
                Integer month = LocalDate.now().getMonthValue();
                if(month<4){
                    quarter ="0";
                }else if(month<7){
                    quarter ="1";
                }else if(month<10){
                    quarter ="2";
                }else{
                    quarter ="3";
                }
            }
            List<JiDuBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :list){
                JiDuBaoBiaoVo q = new JiDuBaoBiaoVo();
                q.setLabelName(map.get("labelName"));
                q.setUnit(map.get("unit"));
                q.setKey0(map.get("key5"));
                q.setKey1(map.get("key0"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key7"));
                q.setKey4(map.get("key3"));
                q.setKey5(map.get("key6"));
                q.setKey6(map.get("key1"));
                q.setKey7(map.get("key4"));
                returnList.add(q);
            }
            return nianUtil.exportExcelRewrite(returnList,name,(quarter.equals("0")?"第一季度":quarter.equals("1")?"第二季度":quarter.equals("2")?"第三季度":"第四季度")+"生产报表");
        }else{
            return AjaxResult.error("导出失败");
        }
        List<QuYuBaoBiaoVo> listt = new ArrayList<>();
        for(HashMap<String,String> map :list){
            QuYuBaoBiaoVo q = new QuYuBaoBiaoVo();
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
            q.setKey12(map.get("key12"));
            q.setKey13(map.get("key13"));
            q.setKey14(map.get("key14"));
            listt.add(q);
        }
        return util.exportExcelRewrite(listt,name,date);
    }
    //--------------------结束--------------------------
    /**
     * 区域月报表查询
     * @param date
     * @param type
     * @return
     */
    private List<HashMap<String,String>> yuenianbaobiao(String date,String type){
        if(date == null||date.trim().equals("")||DataUtil.dateTimeToNowMonth(date)){
            date =null;
            type = null;
        }
        String name="区域报表（月度和年度）";
        String label="期末装机容量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="其中：试运电量";
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

        String label9="供热厂用电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="综合厂用电量率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="发电厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="工业抽汽量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="发电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="供电煤耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="原煤耗用量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

        String label17="其中：发电原煤耗用量";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

        String label18="供热耗用原煤量";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName (name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY (byLabelName18,date,type);

        String label19="燃油量";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName (name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY (byLabelName19,date,type);

        String name20="区域报表（月度和年度）";
        String label20="入炉煤低位发热值";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName (name20, label20);
        HashMap<String, String> map20 = DataUtil.dataListY (byLabelName20,date,type);

        String name21="区域报表（月度和年度）";
        String label21="等效可用系数";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName (name21, label21);
        HashMap<String, String> map21 = DataUtil.dataListY (byLabelName21,date,type);

        String name22="区域报表（月度和年度）";
        String label22="出力系数";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName (name22, label22);
        HashMap<String, String> map22 = DataUtil.dataListY (byLabelName22,date,type);

        String name23="区域报表（月度和年度）";
        String label23="运行小时";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName (name23, label23);
        HashMap<String, String> map23 = DataUtil.dataListY (byLabelName23,date,type);

        String name24="区域报表（月度和年度）";
        String label24="利用小时";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName (name24, label24);
        HashMap<String, String> map24 = DataUtil.dataListY (byLabelName24,date,type);

        String name25="区域报表（月度和年度）";
        String label25="供热比";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName (name25, label25);
        HashMap<String, String> map25 = DataUtil.dataListY (byLabelName25,date,type);

        String name26="区域报表（月度和年度）";
        String label26="NOX排放浓度（CEMS）";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName (name26, label26);
        HashMap<String, String> map26 = DataUtil.dataListY (byLabelName26,date,type);

        String name27="区域报表（月度和年度）";
        String label27="SO2排放浓度（CEMS）";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName (name27, label27);
        HashMap<String, String> map27 = DataUtil.dataListY (byLabelName27,date,type);

        String name28="区域报表（月度和年度）";
        String label28="粉尘排放浓度（CEMS)";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName (name28, label28);
        HashMap<String, String> map28 = DataUtil.dataListY (byLabelName28,date,type);

        String name29="区域报表（月度和年度）";
        String label29="火电发电补水率";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName (name29, label29);
        HashMap<String, String> map29 = DataUtil.dataListY (byLabelName29,date,type);

        String name30="区域报表（月度和年度）";
        String label30="水电耗水耗";
        List<SkBbLabel> byLabelName30 = skBbLabelService.findByLabelName (name30, label30);
        HashMap<String, String> map30 = DataUtil.dataListY (byLabelName30,date,type);

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
        return list;
    }
    /**
     * 区域周报表查询
     * @param date 日期
     * @param type 类型
     * @return
     */
    private List<HashMap<String,String>> zhoubaobiao(String date,String type) {
        if (date == null || date.trim().equals("")||DataUtil.dateTimeToNowWeek(date)) {
            date = null;
            type = null;
        }
        date = DataUtil.returnDate(date);
        String name="区域周报表（周）";
        String label="期末装机容量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="其中：试运电量";
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

        String label9="供热厂用电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="综合厂用电量率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="发电厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="工业抽汽量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="发电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="供电煤耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="原煤耗用量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

        String label17="其中：发电原煤耗用量";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

        String label18="供热耗用原煤量";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName (name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY (byLabelName18,date,type);

        String label19="燃油量";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName (name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY (byLabelName19,date,type);

        String label20="入炉煤低位发热值";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName (name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY (byLabelName20,date,type);

        String label21="等效可用系数";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName (name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY (byLabelName21,date,type);

        String label22="出力系数";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName (name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY (byLabelName22,date,type);

        String label23="运行小时";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName (name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY (byLabelName23,date,type);

        String label24="利用小时";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName (name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY (byLabelName24,date,type);

        String label25="供热比";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName (name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY (byLabelName25,date,type);

        String label26="NOX排放浓度（CEMS）";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName (name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY (byLabelName26,date,type);

        String label27="SO2排放浓度（CEMS）";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName (name, label27);
        HashMap<String, String> map27 = DataUtil.dataListY (byLabelName27,date,type);

        String label28="粉尘排放浓度（CEMS)";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName (name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY (byLabelName28,date,type);

        String label29="火电发电补水率";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName (name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY (byLabelName29,date,type);

        String label30="水电耗水耗";
        List<SkBbLabel> byLabelName30 = skBbLabelService.findByLabelName (name, label30);
        HashMap<String, String> map30 = DataUtil.dataListY (byLabelName30,date,type);

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
        return list;
    }
    /**
     * 区域日报表查询
     * @param date 天
     * @param type 类型
     * @return
     */
    private List<HashMap<String,String>> ribaobiao(String date,String type){
        if(date == null||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type = null;
        }
        String name="区域日报表（日）";
        String label="期末装机容量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="发电设备平均容量";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="发电量";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="其中：试运电量";
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

        String label9="供热厂用电量";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="综合厂用电量率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="发电厂用电率";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="工业抽汽量";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="发电煤耗";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="供电煤耗";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="综合供电煤耗";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="原煤耗用量";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

        String label17="其中：发电原煤耗用量";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

        String label18="供热耗用原煤量";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName (name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY (byLabelName18,date,type);

        String label19="燃油量";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName (name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY (byLabelName19,date,type);

        String label20="入炉煤低位发热值";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName (name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY (byLabelName20,date,type);

        String label21="等效可用系数";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName (name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY (byLabelName21,date,type);

        String label22="出力系数";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName (name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY (byLabelName22,date,type);

        String label23="运行小时";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName (name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY (byLabelName23,date,type);

        String label24="利用小时";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName (name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY (byLabelName24,date,type);

        String label25="供热比";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName (name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY (byLabelName25,date,type);

        String label26="NOX排放浓度（CEMS）";
        List<SkBbLabel> byLabelName26 = skBbLabelService.findByLabelName (name, label26);
        HashMap<String, String> map26 = DataUtil.dataListY (byLabelName26,date,type);

        String label27="SO2排放浓度（CEMS）";
        List<SkBbLabel> byLabelName27 = skBbLabelService.findByLabelName (name, label27);
        HashMap<String, String> map27 = DataUtil.dataListY (byLabelName27,date,type);

        String label28="粉尘排放浓度（CEMS)";
        List<SkBbLabel> byLabelName28 = skBbLabelService.findByLabelName (name, label28);
        HashMap<String, String> map28 = DataUtil.dataListY (byLabelName28,date,type);

        String label29="火电发电补水率";
        List<SkBbLabel> byLabelName29 = skBbLabelService.findByLabelName (name, label29);
        HashMap<String, String> map29 = DataUtil.dataListY (byLabelName29,date,type);

        String label30="水电耗水耗";
        List<SkBbLabel> byLabelName30 = skBbLabelService.findByLabelName (name, label30);
        HashMap<String, String> map30 = DataUtil.dataListY (byLabelName30,date,type);

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
        return list;
    }
    /**
     * 区域合计季度报表
     */
    @GetMapping("quyujidubaobiao")
    public JSONObject quyujidubaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "abandonmentGroup",required = false) String quarter){
        JSONObject jsonObject=new JSONObject ();
        //查询用月份
        Integer month = null;
        //返回用月份
        Integer returnMonth = null;
        //年份为空则获取当前年份
        if(date == null||date.trim().equals(""))date = String.valueOf(LocalDate.now().getYear());
        //获取当前月份所在季度
        returnMonth = LocalDate.now().getMonthValue();
        if(returnMonth<4){
            returnMonth =0;
        }else if(returnMonth<7){
            returnMonth =1;
        }else if(returnMonth<10){
            returnMonth =2;
        }else{
            returnMonth =3;
        }
        //如果用户传入了季度则转换
        if(StringUtils.isNotEmpty(quarter)){
            month = Integer.parseInt(quarter);
        }

        String strignMonth = month==null||month==returnMonth?null:month.toString();
        jsonObject.put ("data",jibaobiao(date,strignMonth));
        jsonObject.put ("quarter",month == null?returnMonth.toString():month.toString());
        jsonObject.put ("year",date);
        return jsonObject;
    }
    /**
     * 区域季报表查询
     * @param year 天
     * @param quarter 季度
     * @return
     */
    private List<HashMap<String,String>> jibaobiao(String year,String quarter){
        String date = "";
        String type = "3";
        if(StringUtils.isEmpty(quarter)){
            date = null;
            type = null;
        }else{
            if(quarter.trim().equals("0")){
                date = year+"-03-01";
            }else if(quarter.trim().equals("1")){
                date = year+"-06-01";
            }else if(quarter.trim().equals("2")){
                date = year+"-09-01";
            }else if(quarter.trim().equals("3")){
                date = year+"-12-01";
            }
        }
        String name="区域季报表";
        List<HashMap<String,String>> list=new ArrayList<> ();
        List<String> labelList = new ArrayList<>();
        labelList.add("期末装机容量");
        labelList.add("发电设备平均容量");
        labelList.add("发电量");
        labelList.add("其中：试运电量");
        labelList.add("上网电量");
        labelList.add("外购电量");
        labelList.add("其他电量");
        labelList.add("综合厂用电量");
        labelList.add("发电厂用电量");
        labelList.add("供热厂用电量");
        labelList.add("综合厂用电量率");
        labelList.add("发电厂用电率");
        labelList.add("工业抽汽量");
        labelList.add("发电煤耗");
        labelList.add("供电煤耗");
        labelList.add("综合供电煤耗");
        labelList.add("原煤耗用量");
        labelList.add("其中：发电原煤耗用量");
        labelList.add("供热耗用原煤量");
        labelList.add("燃油量");
        labelList.add("入炉煤低位发热值");
        labelList.add("利用小时");
        labelList.add("供热比");
        labelList.add("火电发电补水率");
        labelList.add("水电耗水耗");
        for(String labelName:labelList){
            List<String> label = new ArrayList<>();
            List<SkBbLabel> byLabelName = skBbLabelService.findByLabelNameOrder (name, labelName);
            for(SkBbLabel s : byLabelName){
                label.add(s.getPlace());
            }
            HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);
//            HashMap<String, String> map = test(date,type);
            if(byLabelName!=null && byLabelName.size()>0){
                map.put("labelName",byLabelName.get(0).getLabelName());
                map.put("unit",byLabelName.get(0).getUnit());
            }
            list.add (map);
        }
        return list;
    }

    private HashMap test(String date,String type){
        String value = "";
        if(date == null || type == null){
            value = "2021.02";
        }else{
            for(Integer year = 2020;year<2031;year++){
                for(Integer typeCount = 0;typeCount<4;typeCount++){
                    if(date.substring(0,4).equals(year.toString())&&type.equals(typeCount.toString())){
                        value = year.toString()+"."+typeCount.toString();
                    }
                }
            }
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("key0",value);
        map.put("key1",value);
        map.put("key2",value);
        map.put("key3",value);
        map.put("key4",value);
        map.put("key5",value);
        map.put("key6",value);
        map.put("key7",value);
        map.put("key8",value);
        map.put("key9",value);
        map.put("key10",value);
        map.put("key11",value);
        map.put("key12",value);
        map.put("key13",value);
        map.put("key14",value);
        map.put("key15",value);
        map.put("key16",value);
        map.put("key17",value);
        map.put("key18",value);
        map.put("key19",value);
        map.put("key20",value);
        map.put("key21",value);
        return map;
    }
}
