
package com.ruoyi.web.controller.skdata.baobiao;


import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
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

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/fengongsibaobiao")
public class FenGongSiBaoBiaoController {

    @Autowired
    private ISkBbLabelService skBbLabelService;


    public List<String> getWeekTimeList(String date){
        List<String> returnList = new ArrayList<>();
        Calendar ca =Calendar.getInstance ();
        Calendar ca2 =Calendar.getInstance ();
        Date d = null;
        try {
            if(null==date){
                d = new Date();
                //查询上周先减7天
                ca.add(Calendar.DATE, -7);
                d = ca.getTime();
                ca.setTime(d);
                ca2.setTime(d);
                Date d2 = d;
                int num = ca.get(Calendar.DAY_OF_WEEK);//num=5为周四
                int difference = Math.abs(num-5);//差值
                //        ToolUtils.changeTime();
                if(num<5){
                    ca.add(Calendar.DATE, difference-7);
                    ca2.add(Calendar.DATE, difference-1);
                }else {
                    ca.add(Calendar.DATE, -7-difference);
                    ca2.add(Calendar.DATE, -1-difference);
                }
                d = ca.getTime();
                d2 = ca2.getTime();
                date= new SimpleDateFormat("yyyy-MM-dd").format(d);
                String date2= new SimpleDateFormat("yyyy-MM-dd").format(d2);
                returnList.add(date);
                returnList.add(date2);
//                ca2.setTime(d);
//                ca2.add(Calendar.DATE, 6);
//                Date d2 = ca2.getTime();
//                date= new SimpleDateFormat("yyyy-MM-dd").format(d);
//                String date2= new SimpleDateFormat("yyyy-MM-dd").format(d2);
//                returnList.add(date);
//                returnList.add(date2);
            }else {
                d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                ca.setTime(d);
                ca2.setTime(d);
                ca2.add(Calendar.DATE, 6);
//                ca.setTime(d);
//                ca2.setTime(d);
//                Date d2 = d;
                int num = ca.get(Calendar.DAY_OF_WEEK);//num=5为周四
                if(5!= num){
                    throw new Exception("查询区域:只能查询上周四到周三！");
                }
//                int num = ca.get(Calendar.DAY_OF_WEEK);//num=5为周四
//                int difference = Math.abs(num-5);//差值
//                //        ToolUtils.changeTime();
//                if(num<5){
//                    ca.add(Calendar.DATE, difference-7);
//                    ca2.add(Calendar.DATE, difference-1);
//                }else {
//                    ca.add(Calendar.DATE, -7-difference);
//                    ca2.add(Calendar.DATE, -1-difference);
//                }
                d = ca.getTime();
                Date d2 = ca2.getTime();
                date= new SimpleDateFormat("yyyy-MM-dd").format(d);
                String date2= new SimpleDateFormat("yyyy-MM-dd").format(d2);
                returnList.add(date);
                returnList.add(date2);
            }

        } catch (Exception e) {
            e.printStackTrace();
            if("查询区域:只能查询上周四到周三！".equals(e.getMessage())){
                returnList.add("500");
                returnList.add("查询区域:只能查询上周四到周三！");
                returnList.add(null);
            }
        }finally {
            return  returnList;
        }
    }
    public JSONObject toDefaultTime(String date){
        JSONObject jsonObject=new JSONObject ();
        List<String> returnList = new ArrayList<>();
        if(null==date){
//            String[] dates="2021-05-30,2021-05-31,2021-06-01,2021-06-02,2021-06-03,2021-06-04,2021-06-05".split(",");
//            try {
//                d = new SimpleDateFormat("yyyy-MM-dd").parse(dates[i]);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            ca.setFirstDayOfWeek(Calendar.THURSDAY);
            returnList=getWeekTimeList(date);
            String date2= returnList.size()>0?returnList.get(1):"";
            jsonObject.put("date2",date2);
        }else {
            try {
                returnList=getWeekTimeList(date);
                String date2= returnList.size()>0?returnList.get(1):"";
                jsonObject.put("date2",date2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jsonObject.put("date1",returnList.size()>0?returnList.get(0):"");
        jsonObject.put("date",returnList);
        return jsonObject;
    }
    /**
     * 分公司周报表
     */
    @GetMapping("/fengongsizhoubaobiao")
    public JSONObject fengongsizhoubaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject = toDefaultTime(date);
//        List<String> tempList = new ArrayList();
//        if(null!= date) tempList=getWeekTimeList(date);
        List<String> tempList = getWeekTimeList(date);
        if(tempList.size()==3) {
            jsonObject.put("code",Integer.parseInt(tempList.get(0)));
            jsonObject.put("msg",tempList.get(1));
            jsonObject.put("data",null);
            return jsonObject;
        }
        jsonObject.put ("data",zhoubaobiao(tempList.size()>0?tempList.get(0):date, type));
        return jsonObject;
    }

    /**
     * 分公司火电指标报表
     */
    @GetMapping("/fengongsihuodianbaobiao")
    public JSONObject fengongsihuodianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject = toDefaultTime(date);
//        List<String> tempList = new ArrayList();
//        if(null!= date)tempList=getWeekTimeList(date);
        List<String> tempList = getWeekTimeList(date);
        jsonObject.put ("data",huodianbaobiao(tempList.size()>0?tempList.get(0):date, type));
        return jsonObject;
    }


    /**
     * 分公司光伏指标报表
     */
    @GetMapping("/fengongsiguangfubaobiao")
    public JSONObject fengongsiguangfubaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject = toDefaultTime(date);
        List<String> tempList = getWeekTimeList(date);
        jsonObject.put ("data",guangfubaobiao(tempList.size()>0?tempList.get(0):date, type));
        return jsonObject;
    }

    /**
     * 分公司水电指标报表
     */
    @GetMapping("/fengongsishuidianbaobiao")
    public JSONObject fengongsishuidianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject = toDefaultTime(date);
//        List<String> tempList = new ArrayList();
//        if(null!= date)tempList=getWeekTimeList(date);
        List<String> tempList = getWeekTimeList(date);
        jsonObject.put ("data",shuidianbaobiao(tempList.size()>0?tempList.get(0):date, type));
        return jsonObject;
    }

    /**
     * 分公司风电指标报表
     */
    @GetMapping("/fengongsifengdianbaobiao")
    public JSONObject fengongsifengdianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject = toDefaultTime(date);
//        List<String> tempList = new ArrayList();
//        if(null!= date)tempList=getWeekTimeList(date);
        List<String> tempList = getWeekTimeList(date);
        jsonObject.put ("data",fengdianbaobiao(tempList.size()>0?tempList.get(0):date, type));
        return jsonObject;
    }

    /**
     * 分公司火电环保指标报表
     */
    @GetMapping("/fengongsihuodianhuanbaobaobiao")
    public JSONObject fengongsihuodianhuanbaobaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        JSONObject jsonObject = toDefaultTime(date);
//        List<String> tempList = new ArrayList();
//        if(null!= date)tempList=getWeekTimeList(date);
        List<String> tempList = getWeekTimeList(date);
        jsonObject.put ("data",huodianhuanbaobaobiao(tempList.size()>0?tempList.get(0):date, type));
        return jsonObject;
    }

    /**
     * 周报表查询
     * @param date 日期
     * @param type 类型
     * @return
     */
    private List<FenGongSiBaoBiaoVo> zhoubaobiao(String date, String type) {
        if (date == null || date.trim().equals("")) {
            date = null;
            type = null;
        }
//        date = DataUtil.returnDate(date);
        if(type!=null) type= "a"; //按日查询
        String name="周分公司数据指标汇总表";
        String label="周日均发电量";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="周电量环比";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="周电量同比";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="周生产厂用电率";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="周生产厂用电率环比";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="周完成供电煤耗";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="周供电煤耗环比";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="周三期日均发电占比";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="周三期日均发电占比环比";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="周三期周均发电占比";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);
        
        List<HashMap<String,String>> list=new ArrayList<>();
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
        List<FenGongSiBaoBiaoVo> list3=new ArrayList<>();
        FenGongSiBaoBiaoVo q = new FenGongSiBaoBiaoVo();
        FenGongSiBaoBiaoVo f = new FenGongSiBaoBiaoVo((String)map.get("key0"),(String)map1.get("key0"),(String)map2.get("key0"),(String)map3.get("key0"),(String)map4.get("key0"),(String)map5.get("key0"),(String)map6.get("key0"),(String)map7.get("key0"),(String)map8.get("key0"),(String)map9.get("key0"));
//        for(HashMap<String,String> map10 :list){
//            String temp=(String)map10.get("labelName");
////            String db = label.equals(temp)?"rjfdl":label1.equals(temp)?"dlhb":label2.equals(temp)?"dltb":
////                    label3.equals(temp)?"wcsccydl":label4.equals(temp)?"cydlhb":label5.equals(temp)?"gdmh":
////                            label6.equals(temp)?"mhhb":label7.equals(temp)?"fdzb":label8.equals(temp)?"fdzbhb":"zjfdzb";
////            map11.put(db,map10.get("key0"));
//            if (label.equals(temp)) {
//                q.setCydlhb(map10.get("key0"));
//            }
//                else if (label1.equals(temp)) {
//                    q.setDlhb(map10.get("key0"));
//                }
//            else if (label2.equals(temp)) {
//                        q.setDltb(map10.get("key0"));
//                    }
//            else  if (label3.equals(temp)) {
//                            q.setWcsccydl(map10.get("key0"));
//                        }
//            else   if (label4.equals(temp)) {
//                                q.setCydlhb(map10.get("key0"));
//                            }
//            else    if (label5.equals(temp)) {
//                                    q.setGdmh(map10.get("key0"));
//                                }
//            else  if (label6.equals(temp)) {
//                                        q.setMhhb(map10.get("key0"));
//                                    }
//            else  if (label7.equals(temp)) {
//                                            q.setFdzb(map10.get("key0"));
//                                        }
//            else  if (label8.equals(temp)) {
//                                                q.setFdzbhb(map10.get("key0"));
//                                            }
//                                                q.setZjfdzb(map10.get("key0"));
//        }
//        list3.add(q);
        list3.add(f);
        return list3;
    }

    /**
     * 分公司火电指标报表查询
     * @param date 日期
     * @param type 类型
     * @return
     */
    private List<HashMap<String,String>> huodianbaobiao(String date, String type) {
        if (date == null || date.trim().equals("")) {
            date = null;
            type = null;
        }
        if(type!=null) type= "a"; //按日查询
//        date = DataUtil.returnDate(date);
        String name="火电机组周主要指标表";
        String label="合计";
        List<SkBbLabel> byByPlace = skBbLabelService.findByPlace (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byByPlace,date,type);
        String name1="火电机组周主要指标表";
        String label1="岳阳1#";
        List<SkBbLabel> byByPlace1 = skBbLabelService.findByPlace (name1, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byByPlace1,date,type);
        String name2="火电机组周主要指标表";
        String label2="岳阳2#";
        List<SkBbLabel> byByPlace2 = skBbLabelService.findByPlace (name2, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byByPlace2,date,type);
        String name3="火电机组周主要指标表";
        String label3="岳阳3#";
        List<SkBbLabel> byByPlace3 = skBbLabelService.findByPlace (name3, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byByPlace3,date,type);
        String name4="火电机组周主要指标表";
        String label4="岳阳4#";
        List<SkBbLabel> byByPlace4 = skBbLabelService.findByPlace (name4, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byByPlace4,date,type);
        String name5="火电机组周主要指标表";
        String label5="岳阳5#";
        List<SkBbLabel> byByPlace5 = skBbLabelService.findByPlace (name5, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byByPlace5,date,type);
        String name6="火电机组周主要指标表";
        String label6="岳阳6#";
        List<SkBbLabel> byByPlace6 = skBbLabelService.findByPlace (name6, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byByPlace6,date,type);
        map.put("place",label);
        map1.put("place",label1);
        map2.put("place",label2);
        map3.put("place",label3);
        map4.put("place",label4);
        map5.put("place",label5);
        map6.put("place",label6);
        List<HashMap<String,String>> list=new ArrayList<>();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
        list.add (map5);
        list.add (map6);
        return list;
    }

    /**
     * 分公司光伏指标报表查询
     * @param date 日期
     * @param type 类型
     * @return
     */
    private List<HashMap<String,String>> guangfubaobiao(String date, String type) {
        if (date == null || date.trim().equals("")) {
            date = null;
            type = null;
        }
        if(type!=null)type= "a"; //按日查询
//        date = DataUtil.returnDate(date);
        String name="光伏周发电主要指标表";
        String label="合计";
        List<SkBbLabel> byByPlace = skBbLabelService.findByPlace (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byByPlace,date,type);
        String name1="光伏周发电主要指标表";
        String label1="新港";
        List<SkBbLabel> byByPlace1 = skBbLabelService.findByPlace (name1, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byByPlace1,date,type);
        String name2="光伏周发电主要指标表";
        String label2="擂鼓台";
        List<SkBbLabel> byByPlace2 = skBbLabelService.findByPlace (name2, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byByPlace2,date,type);
        String name3="光伏周发电主要指标表";
        String label3="三灰湖";
        List<SkBbLabel> byByPlace3 = skBbLabelService.findByPlace (name3, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byByPlace3,date,type);
        String name4="光伏周发电主要指标表";
        String label4="白羊田";
        List<SkBbLabel> byByPlace4 = skBbLabelService.findByPlace (name4, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byByPlace4,date,type);
        map.put("place",label);
        map1.put("place",label1);
        map2.put("place",label2);
        map3.put("place",label3);
        map4.put("place",label4);
        List<HashMap<String,String>> list=new ArrayList<>();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
        return list;
    }

    /**
     * 分公司水电指标报表查询
     * @param date 日期
     * @param type 类型
     * @return
     */
    private List<HashMap<String,String>> shuidianbaobiao(String date, String type) {
        if (date == null || date.trim().equals("")) {
            date = null;
            type = null;
        }
        if(type!=null)type= "a"; //按日查询
//        date = DataUtil.returnDate(date);
        String name="水电机组周主要指标表";
        String label="湘祁";
        List<SkBbLabel> byByPlace = skBbLabelService.findByPlace (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byByPlace,date,type);
        map.put("place",label);
        List<HashMap<String,String>> list=new ArrayList<>();
        list.add (map);
        return list;
    }

    /**
     * 分公司风电指标报表查询
     * @param date 日期
     * @param type 类型
     * @return
     */
    private List<HashMap<String,String>> fengdianbaobiao(String date, String type) {
        if (date == null || date.trim().equals("")) {
            date = null;
            type = null;
        }
        if(type!=null)type= "a"; //按日查询
//        date = DataUtil.returnDate(date);
        String name="风电机组周主要指标表";
        String label="合计";
        List<SkBbLabel> byByPlace = skBbLabelService.findByPlace (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byByPlace,date,type);
        String name1="风电机组周主要指标表";
        String label1="苏宝顶";
        List<SkBbLabel> byByPlace1 = skBbLabelService.findByPlace (name1, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byByPlace1,date,type);
        String name2="风电机组周主要指标表";
        String label2="桂东";
        List<SkBbLabel> byByPlace2 = skBbLabelService.findByPlace (name2, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byByPlace2,date,type);
        String name3="风电机组周主要指标表";
        String label3="梅桥";
        List<SkBbLabel> byByPlace3 = skBbLabelService.findByPlace (name3, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byByPlace3,date,type);
        String name4="风电机组周主要指标表";
        String label4="连坪";
        List<SkBbLabel> byByPlace4 = skBbLabelService.findByPlace (name4, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byByPlace4,date,type);
        String name5="风电机组周主要指标表";
        String label5="北湖风电";
        List<SkBbLabel> byByPlace5 = skBbLabelService.findByPlace (name5, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byByPlace5,date,type);
        String name6="风电机组周主要指标表";
        String label6="回龙圩风电";
        List<SkBbLabel> byByPlace6 = skBbLabelService.findByPlace (name6, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byByPlace6,date,type);
        String name7="风电机组周主要指标表";
        String label7="江口风电";
        List<SkBbLabel> byByPlace7 = skBbLabelService.findByPlace (name7, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byByPlace7,date,type);
        map.put("place",label);
        map1.put("place",label1);
        map2.put("place",label2);
        map3.put("place",label3);
        map4.put("place",label4);
        map5.put("place",label5);
        map6.put("place",label6);
        map7.put("place",label7);
        List<HashMap<String,String>> list=new ArrayList<>();
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

    private List<HashMap<String,String>> huodianhuanbaobaobiao(String date,String type){
        String name = "火电机组周烟气排放环保指标表";
        String label = "SO2";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)) date = null;
        if(type!=null) type= "a";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName(name, label);
        HashMap<String, String> map = DataUtil.dataListY(byLabelName, date, type);

        String label1 = "NOX";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName(name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY(byLabelName1, date, type);

        String label2 = "粉尘";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName(name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY(byLabelName2, date, type);


        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        return list;
    }

    /**
     * 分公司报表导出
     */
    @PreAuthorize("@ss.hasPermi('business:fengongsibaobiao:export')")
    @GetMapping("/fengongsibaobiaoexport")
    public AjaxResult yueyangbaobiaoexport(@RequestParam(value = "date") String date, @RequestParam(value = "type") Integer oldType) {
        String type = oldType.toString();
        ExcelUtil<FenGongSiBaoBiaoVo> util = new ExcelUtil<FenGongSiBaoBiaoVo>(FenGongSiBaoBiaoVo.class);
        List<FenGongSiBaoBiaoVo> selectList = null;
        List<HashMap<String,String>> selectList2=null;
        String name = "";
        if("1".equals(type)|| null==type){
            selectList = zhoubaobiao(date,type);
            name = "分公司周报表";
        } else if("2".equals(type)){
            ExcelUtil<FenGongSiHuoDianBaoBiaoVo> huoDianUtil = new ExcelUtil<FenGongSiHuoDianBaoBiaoVo>(FenGongSiHuoDianBaoBiaoVo.class);
            selectList2 = huodianbaobiao(date,type);
            name = "分公司火电指标报表";
            List<FenGongSiHuoDianBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList2){
                FenGongSiHuoDianBaoBiaoVo q = new FenGongSiHuoDianBaoBiaoVo();
                q.setPlace(map.get("place"));
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
                returnList.add(q);
            }
            return huoDianUtil.exportExcelRewrite(returnList,name,date);
        }else if("3".equals(type)){
            ExcelUtil<FenGongSiGuangFuBaoBiaoVo> huoDianUtil = new ExcelUtil<FenGongSiGuangFuBaoBiaoVo>(FenGongSiGuangFuBaoBiaoVo.class);
            selectList2 = guangfubaobiao(date,type);
            name = "分公司光伏指标报表";
            List<FenGongSiGuangFuBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList2){
                FenGongSiGuangFuBaoBiaoVo q = new FenGongSiGuangFuBaoBiaoVo();
                q.setPlace(map.get("place"));
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
                returnList.add(q);
            }
            return huoDianUtil.exportExcelRewrite(returnList,name,date);
        }else if("4".equals(type)){
            ExcelUtil<FenGongSiShuiDianBaoBiaoVo> huoDianUtil = new ExcelUtil<FenGongSiShuiDianBaoBiaoVo>(FenGongSiShuiDianBaoBiaoVo.class);
            selectList2 = shuidianbaobiao(date,type);
            name = "分公司水电指标报表";
            List<FenGongSiShuiDianBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList2){
                FenGongSiShuiDianBaoBiaoVo q = new FenGongSiShuiDianBaoBiaoVo();
                q.setPlace(map.get("place"));
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
                returnList.add(q);
            }
            return huoDianUtil.exportExcelRewrite(returnList,name,date);
        }else if("5".equals(type)){
            ExcelUtil<FenGongSiFengDianBaoBiaoVo> huoDianUtil = new ExcelUtil<FenGongSiFengDianBaoBiaoVo>(FenGongSiFengDianBaoBiaoVo.class);
            selectList2 = fengdianbaobiao(date,type);
            name = "分公司风电指标报表";
            List<FenGongSiFengDianBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList2){
                FenGongSiFengDianBaoBiaoVo q = new FenGongSiFengDianBaoBiaoVo();
                q.setPlace(map.get("place"));
                q.setKey0(map.get("key0"));
                q.setKey1(map.get("key1"));
                q.setKey2(map.get("key2"));
                q.setKey3(map.get("key3"));
                q.setKey4(map.get("key4"));
                q.setKey5(map.get("key5"));
                q.setKey6(map.get("key6"));
                q.setKey7(map.get("key7"));
                q.setKey8(map.get("key8"));
                returnList.add(q);
            }
            return huoDianUtil.exportExcelRewrite(returnList,name,date);
        }else if("6".equals(type)){
            ExcelUtil<FenGongSiHuoDianHuanBaoBaoBiaoVo> huoDianUtil = new ExcelUtil<FenGongSiHuoDianHuanBaoBaoBiaoVo>(FenGongSiHuoDianHuanBaoBaoBiaoVo.class);
            selectList2 = huodianhuanbaobaobiao(date,type);
            name = "分公司火电环保指标报表";
            List<FenGongSiHuoDianHuanBaoBaoBiaoVo> returnList = new ArrayList<>();
            for(HashMap<String,String> map :selectList2){
                FenGongSiHuoDianHuanBaoBaoBiaoVo q = new FenGongSiHuoDianHuanBaoBaoBiaoVo(map.get("labelName"),map.get("unit"),map.get("key0"),map.get("key1"),map.get("key2"),map.get("key3"),map.get("key4"),map.get("key5"));
                returnList.add(q);
            }
            return huoDianUtil.exportExcelRewrite(returnList,name,date);
        }else{
            return AjaxResult.error("导出失败");
        }
        return util.exportExcelRewrite(selectList,name,date);
    }
}
