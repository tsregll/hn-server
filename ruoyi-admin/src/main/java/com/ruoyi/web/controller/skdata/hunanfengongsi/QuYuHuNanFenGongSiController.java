package com.ruoyi.web.controller.skdata.hunanfengongsi;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.BusinessStatisticsYueyangElectricity;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.IBusinessStatisticsYueyangElectricityService;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/business/hunanfengongsi")
public class QuYuHuNanFenGongSiController {

    @Autowired
    private ISkBbLabelService skBbLabelService;
    @Autowired
    private IBusinessStatisticsYueyangElectricityService businessStatisticsYueyangElectricityService;
    /**
     * 湖南分公司总貌/岳阳电厂总貌
     */
    @GetMapping("/selectSkQuYuZongMao")
    public JSONObject selectSkQuYuZongMao(@RequestParam(value = "type",required = false) String type){
        String name= type.trim().equals("0")?"湖南分公司总貌":"岳阳电厂总貌";
        String place= type.trim().equals("0")?"湖南分公司":"岳阳电厂";
        List<String> labelNameList =new ArrayList<> ();
        labelNameList.add("本月发电量完成进度");
        labelNameList.add("本年发电量完成进度");
        labelNameList.add("本月供热量完成进度");
        labelNameList.add("本年供热量完成进度");
        labelNameList.add("本年年度EVA绩效");
        labelNameList.add("本年年累计EVA");
        List<String> lis = selectLable(name,place,labelNameList);
        labelNameList.add("本月计划发电量");
        labelNameList.add("本月实际发电量");
        labelNameList.add("本年计划发电量");
        labelNameList.add("本年实际发电量");
        labelNameList.add("本月计划供热量");
        labelNameList.add("本月实际供热量");
        labelNameList.add("本年计划供热量");
        labelNameList.add("本年实际供热量");
        labelNameList.add("当年标煤采购单价年度绩效");
        labelNameList.add("当年标煤采购单价实际完成");
        labelNameList.add("当年利润总额年度绩效");
        labelNameList.add("当年利润总额实际完成");
        labelNameList.add("本日实时发电功率");
        labelNameList.add("当日发电量");
        //新增加的标签，0分公司，1岳阳
        if(type.trim().equals("0")){
            labelNameList.add("湖南分公司月发电量");
            labelNameList.add("湖南分公司年累计发电量");
            labelNameList.add("岳阳全厂月发电量");
            labelNameList.add("岳阳全厂发年累计发电量");
            labelNameList.add("清能公司月发电量");
            labelNameList.add("清能公司年累计发电量");
            labelNameList.add("湖南分公司当年累计EVA");
            labelNameList.add("岳阳全厂当年累计EVA");
            labelNameList.add("清能公司当年累计EVA");
            labelNameList.add("岳阳全厂月供热量");
            labelNameList.add("岳阳全厂年供热量");
            labelNameList.add("湖南分公司本月标煤采购单价");
            labelNameList.add("湖南分公司本年标煤采购单价");
            labelNameList.add("湖南分公司本月利润总额");
            labelNameList.add("湖南分公司本年利润总额");
            labelNameList.add("岳阳全厂本月利润总额");
            labelNameList.add("岳阳全厂本年利润总额");
            labelNameList.add("清能公司本月利润总额");
            labelNameList.add("清能公司本年利润总额");
            labelNameList.add("湖南分公司实时发电功率");
            labelNameList.add("岳阳全厂实时发电功率");
            labelNameList.add("清能公司实时发电功率");
            labelNameList.add("湖南分公司日发电量");
            labelNameList.add("岳阳全厂日发电量");
            labelNameList.add("清能公司日发电量");
        }else{
            labelNameList.add("#1机组月发电量");
            labelNameList.add("#1机组年累计发电量");
            labelNameList.add("#2机组月发电量");
            labelNameList.add("#2机组年累计发电量");
            labelNameList.add("#3机组月发电量");
            labelNameList.add("#3机组年累计发电量");
            labelNameList.add("#4机组月发电量");
            labelNameList.add("#4机组年累计发电量");
            labelNameList.add("#5机组月发电量");
            labelNameList.add("#5机组年累计发电量");
            labelNameList.add("#6机组月发电量");
            labelNameList.add("#6机组年累计发电量");
            labelNameList.add("光伏月发电量");
            labelNameList.add("光伏年累计发电量");
            labelNameList.add("新港光伏月发电量");
            labelNameList.add("新港光伏年累计发电量");
            labelNameList.add("擂鼓台光伏月发电量");
            labelNameList.add("擂鼓台光伏年累计发电量");
            labelNameList.add("三灰湖光伏月发电量");
            labelNameList.add("三灰湖光伏年累计发电量");
            labelNameList.add("岳阳全厂当年累计EVA");
            labelNameList.add("岳阳全厂月供热量");
            labelNameList.add("岳阳全厂年供热量");
            labelNameList.add("岳阳全厂本月标煤采购单价");
            labelNameList.add("岳阳全厂本年标煤采购单价");
            labelNameList.add("岳阳全厂本月利润总额");
            labelNameList.add("岳阳全厂本年利润总额");
            labelNameList.add("#1机组实时发电功率");
            labelNameList.add("#2机组实时发电功率");
            labelNameList.add("#3机组实时发电功率");
            labelNameList.add("#4机组实时发电功率");
            labelNameList.add("#5机组实时发电功率");
            labelNameList.add("#6机组实时发电功率");
            labelNameList.add("光伏实时发电功率");
            labelNameList.add("新港光伏实时发电功率");
            labelNameList.add("擂鼓台光伏实时发电功率");
            labelNameList.add("三灰湖光伏实时发电功率");
            labelNameList.add("#1机组日发电量");
            labelNameList.add("#2机组日发电量");
            labelNameList.add("#3机组日发电量");
            labelNameList.add("#4机组日发电量");
            labelNameList.add("#5机组日发电量");
            labelNameList.add("#6机组日发电量");
            labelNameList.add("光伏日发电量");
            labelNameList.add("新港光伏日发电量");
            labelNameList.add("擂鼓台光伏日发电量");
            labelNameList.add("三灰湖光伏日发电量");
        }
//        labelNameList.add("湖南分公司实时总负荷");
//        labelNameList.add("岳阳电厂实时总负荷");
//        labelNameList.add("苏宝顶风电实时总负荷");
//        labelNameList.add("桂东风电实时总负荷");
//        labelNameList.add("连坪风电实时总负荷");
//        labelNameList.add("梅桥风电实时总负荷");
//        labelNameList.add("北湖风电实时总负荷");
//        labelNameList.add("回龙圩风电实时总负荷");
//        labelNameList.add("湘祁水电实时总负荷");
        List<String> lists = selectLable(name,place,labelNameList);
//        JSONObject jsob =  test(lists,lis);//DataUtil.dataUtil (lists,lis);
        JSONObject jsob =  DataUtil.dataUtil (lists,lis);
        return jsob;
    }


//    private JSONObject test(List<String> lists,List<String> lis){
//        HashMap<String, Object> map1=new HashMap<> ();
//        NumberFormat tfNumberFormat=NumberFormat.getNumberInstance ();
//        tfNumberFormat.setMaximumFractionDigits (0);
//        for(int i=0;i<lists.size();i++){
//            map1.put (lists.get (i).replace (".","_"),tfNumberFormat.format (new Double(221613.888)).replace (",",""));
//        }
//        JSONObject jsonObject=new JSONObject ();
//        jsonObject.put ("data",map1);
//        return jsonObject;
//    }

    /**
     * 清洁能源公司总貌
     * @return
     */
    @GetMapping("/selectQjnyGszm")
    public JSONObject selectQjnyGszm(){
        String name = "清洁能源公司总貌";
        String place = "清洁能源公司";
        List<String> labelNameList =new ArrayList<> ();
        labelNameList.add("本月发电量完成进度");
        labelNameList.add("本年发电量完成进度");
        labelNameList.add("本月利润总额完成进度");
        labelNameList.add("本年利润总额完成进度");
        labelNameList.add("本年年度EVA绩效");
        labelNameList.add("本年年累计EVA");
        List<String> lis = selectLable(name,place,labelNameList);
        labelNameList.add("本月计划发电量");
        labelNameList.add("本月实际发电量");
        labelNameList.add("本年计划发电量");
        labelNameList.add("本年实际发电量");
        labelNameList.add("本月利润总额计划");
        labelNameList.add("本月实际利润总额");
        labelNameList.add("本年利润总额计划");
        labelNameList.add("本年实际利润总额");
        labelNameList.add("水电实时发电功率");
        labelNameList.add("水电实时入库流量");
        labelNameList.add("水电实时发电功率");
        labelNameList.add("风电实时发电功率");
        labelNameList.add("清能公司实时发电功率");
        labelNameList.add("当日发电量");
        labelNameList.add("苏宝顶风电实时总负荷");
        labelNameList.add("桂东风电实时总负荷");
        labelNameList.add("连坪风电实时总负荷");
        labelNameList.add("梅桥风电实时总负荷");
        labelNameList.add("北湖风电实时总负荷");
        labelNameList.add("回龙圩风电实时总负荷");
        labelNameList.add("湘祁水电实时总负荷");
        //新增的点标签
        labelNameList.add("清能公司月发电量");
        labelNameList.add("清能公司年累计发电量");
        labelNameList.add("湘祁水电月发电量");
        labelNameList.add("湘祁水电年累计发电量");
        labelNameList.add("苏宝顶风月发电量");
        labelNameList.add("苏宝顶风年累计发电量");
        labelNameList.add("桂东风电月发电量");
        labelNameList.add("桂东风电年累计发电量");
        labelNameList.add("连坪风电月发电量");
        labelNameList.add("连坪风电年累计发电量");
        labelNameList.add("梅桥风电月发电量");
        labelNameList.add("梅桥风电年累计发电量");
        labelNameList.add("北湖风电月发电量");
        labelNameList.add("北湖风电年累计发电量");
        labelNameList.add("回龙圩风电月发电量");
        labelNameList.add("回龙圩风电年累计发电量");
        labelNameList.add("清能公司当年累计EVA");
        labelNameList.add("湘祁水电当年累计EVA");
        labelNameList.add("苏宝顶风电当年累计EVA");
        labelNameList.add("桂东风电当年累计EVA");
        labelNameList.add("连坪风电当年累计EVA");
        labelNameList.add("梅桥风电当年累计EVA");
        labelNameList.add("北湖风电当年累计EVA");
        labelNameList.add("回龙圩风电当年累计EVA");
        labelNameList.add("清能公司本月利润总额");
        labelNameList.add("清能公司本年利润总额");
        labelNameList.add("湘祁水电本月利润总额");
        labelNameList.add("湘祁水电本年利润总额");
        labelNameList.add("苏宝顶风本月利润总额");
        labelNameList.add("苏宝顶风本年利润总额");
        labelNameList.add("桂东风电本月利润总额");
        labelNameList.add("桂东风电本年利润总额");
        labelNameList.add("连坪风电本月利润总额");
        labelNameList.add("连坪风电本年利润总额");
        labelNameList.add("梅桥风电本月利润总额");
        labelNameList.add("梅桥风电本年利润总额");
        labelNameList.add("北湖风电本月利润总额");
        labelNameList.add("北湖风电本年利润总额");
        labelNameList.add("回龙圩风电本月利润总额");
        labelNameList.add("回龙圩风电本年利润总额");
        labelNameList.add("#1机组实时发电功率");
        labelNameList.add("#2机组实时发电功率");
        labelNameList.add("#3机组实时发电功率");
        labelNameList.add("#4机组实时发电功率");
        labelNameList.add("苏宝顶风电实时发电功率");
        labelNameList.add("桂东风电实时发电功率");
        labelNameList.add("连坪风电实时发电功率");
        labelNameList.add("梅桥风电实时发电功率");
        labelNameList.add("北湖风电实时发电功率");
        labelNameList.add("回龙圩风电实时发电功率");
        labelNameList.add("水电实时发电功率");
        labelNameList.add("风电实时发电功率");
        labelNameList.add("清能公司日发电量");
        labelNameList.add("湘祁水电日发电量");
        labelNameList.add("苏宝顶风电日发电量");
        labelNameList.add("桂东风电日发电量");
        labelNameList.add("连坪风电日发电量");
        labelNameList.add("梅桥风电日发电量");
        labelNameList.add("北湖风电日发电量");
        labelNameList.add("回龙圩风电日发电量");
        labelNameList.add("江口风电月发电量");
        labelNameList.add("江口风电年累计发电量");
        labelNameList.add("江口风电当年累计EVA");
        labelNameList.add("江口风电本月利润总额");
        labelNameList.add("江口风电本年利润总额");
        labelNameList.add("江口风电实时发电功率");
        labelNameList.add("江口风电日发电量");
        List<String> lists = selectLable(name,place,labelNameList);
//        JSONObject jsob =  test(lists);//DataUtil.dataUtil (lists,lis);
        JSONObject jsob =  DataUtil.dataUtil (lists,lis);
        return jsob;
    }
//    private JSONObject test(List<String> lists){
//        HashMap<String, Object> map1=new HashMap<> ();
//        NumberFormat tfNumberFormat=NumberFormat.getNumberInstance ();
//        tfNumberFormat.setMaximumFractionDigits (0);
//        for(int i=0;i<lists.size();i++){
//            map1.put (lists.get (i).replace (".","_"),"-"+i);
//        }
//        JSONObject jsonObject=new JSONObject ();
//        jsonObject.put ("data",map1);
//        return jsonObject;
//    }

    /**
     * 湖南分公司总貌/岳阳电厂总貌
     * 折线图
     * ,@RequestParam(value = "times",required = false) String times
     */
    @GetMapping("/seectByLastDay")
    public AjaxResult seectByLastDay(@RequestParam(value = "type",required = false) String type,@RequestParam(value = "stringDate",required = false) String stringDate) {
        //报表名称
        String name= type.trim().equals("0")?"湖南分公司总貌":"岳阳电厂总貌";
        String place= type.trim().equals("0")?"湖南分公司":"岳阳电厂";
        int ty = stringDate.trim().equals("day")?0:stringDate.trim().equals("lastDay")?1:stringDate.trim().equals("lrze")?2:3;
        String labelNameNow= ty == 0?"今日0~24点实时发电功率":ty==1?"今年按目前日历倒推12天日发电量":ty==2?"今年1-12月利润总额实际完成":"今年1-12月标煤采购单价";
        String labelNameLast= ty == 0?"昨日0~24点实时发电功率":ty==1?"去年按目前日历倒推12天日发电量":ty==2?"去年1-12月利润总额实际完成":"去年1-12月标煤采购单价";
        //获取点标签
        SkBbLabel byNameNow = skBbLabelService.find (name, labelNameNow, place);
        List<String> selectNow = new ArrayList<> ();
        selectNow.add (byNameNow.getLabel());
        SkBbLabel byNameLast = skBbLabelService.find (name, labelNameLast, place);
        List<String> selectLast= new ArrayList<> ();
        selectLast.add (byNameLast.getLabel());
        //创建时间格式
        SimpleDateFormat t=null;
        if(ty==0){
            t = new SimpleDateFormat ("HH:mm");
        }else if(ty==1){
            t = new SimpleDateFormat ("MM-dd");
        }else{
            t = new SimpleDateFormat ("yyyy-MM-dd");
        }
        //设置0时0分0秒
        Calendar nowCa =Calendar.getInstance ();
        nowCa.set (Calendar.SECOND,0);
        nowCa.set (Calendar.MINUTE,0);
        nowCa.set (Calendar.HOUR_OF_DAY,0);
        Date nowStartDate=new Date ();
        Date nowEnddate=new Date ();
        Date rfdlNowStartDate=new Date ();
        Date rfdlNowEnddate=new Date ();

        //设置0时0分0秒
        Calendar lastCa =Calendar.getInstance ();
        lastCa.set (Calendar.SECOND,0);
        lastCa.set (Calendar.MINUTE,0);
        lastCa.set (Calendar.HOUR_OF_DAY,0);
        Date lastStartDate=new Date ();
        Date lastEnddate=new Date ();
        Date rfdlLastStartDate=new Date ();
        Date rfdlLastEnddate=new Date ();
        //判断查询日期
        //0=昨日0~24点实时发电功率
        //1=去年按目前日历倒推12天日发电量
        //2=去年1-12月利润总额实际完成
        //3=去年1-12月标煤采购单价
        if(ty==0){
            //今日
            nowStartDate=nowCa.getTime ();
            nowCa.add (Calendar.DATE,1);
            nowEnddate=nowCa.getTime ();

            //昨日
            lastEnddate=lastCa.getTime ();
            lastCa.add (Calendar.DATE,-1);
            lastStartDate=lastCa.getTime ();
        }else if(ty==1){
            //十二天前
            nowCa.add (Calendar.DATE,0);
            nowEnddate=nowCa.getTime ();
            nowCa.add (Calendar.DATE,-12);
            nowStartDate=nowCa.getTime ();



            //去年十二天前
            lastCa.add (Calendar.YEAR,-1);
            lastCa.add (Calendar.DATE,0);
            lastEnddate=lastCa.getTime ();
            lastCa.add (Calendar.DATE,-12);
            lastStartDate=lastCa.getTime ();

            //十二天前
            nowCa.add (Calendar.DATE,-1);
            rfdlNowStartDate=nowCa.getTime ();
            nowCa.add (Calendar.DATE,12);
            rfdlNowEnddate=nowCa.getTime ();



            //去年十二天前
            lastCa.add (Calendar.DATE,-1);
            rfdlLastStartDate=lastCa.getTime ();
            lastCa.add (Calendar.DATE,12);
            rfdlLastEnddate=lastCa.getTime ();
        }else if(ty==2 || ty ==3){
            //今年一整年
            nowCa.set(Calendar.DAY_OF_YEAR,1);
            nowStartDate=nowCa.getTime ();
            nowCa.set(Calendar.MONTH,11);
            nowEnddate=nowCa.getTime ();

            //去年一整年
            lastCa.set(Calendar.DAY_OF_YEAR,1);
            lastCa.add (Calendar.YEAR,-1);
            lastStartDate=lastCa.getTime ();
            lastCa.set(Calendar.MONTH,11);
            lastEnddate=lastCa.getTime ();
        }
        String nowStartDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowStartDate);
        String nowEndDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowEnddate);
        String lastStartDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastStartDate);
        String lastEndDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastEnddate);


        try {
            nowStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(nowStartDateTime);
            nowEnddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(nowEndDateTime);
            lastStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lastStartDateTime);
            lastEnddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lastEndDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> nowList = DataUtil.lastDataDateUtil(selectNow,t,nowStartDate,nowEnddate,ty,0);
        List<String> nowTime= DataUtil.lastDataTimeUtil(selectNow,t,nowStartDate,nowEnddate,ty,0);


        List<String> lastList = DataUtil.lastDataDateUtil(selectLast,t,lastStartDate,lastEnddate,ty,0);
        List<String> lastTime= DataUtil.lastDataTimeUtil(selectLast,t,lastStartDate,lastEnddate,ty,0);
        if(ty==1){
            nowTime= DataUtil.lastDataTimeUtil(selectNow,t,rfdlNowStartDate,rfdlNowEnddate,ty,0);
            lastTime= DataUtil.lastDataTimeUtil(selectLast,t,rfdlLastStartDate,rfdlLastEnddate,ty,0);
        }
        if(ty==2 || ty ==3){
            List<List<String>> returnNowList = DataUtil.yearList(nowList,nowTime);
            nowList = returnNowList.get(0);
            nowTime = returnNowList.get(1);
            List<List<String>> returnLastList = DataUtil.yearList(lastList,lastTime);
            lastList = returnLastList.get(0);
            lastTime = returnLastList.get(1);
        }
        HashMap<String, Object> nowMap=new HashMap<> ();
        nowMap.put ("data", nowList);
        nowMap.put ("name",labelNameNow.substring(0,2));
        nowMap.put ("type","line");
        nowMap.put ("symbolSize",6);
//        nowMap.put ("symbol","circle");
        HashMap<String, Object> lastMap=new HashMap<> ();
        lastMap.put ("data", lastList);
        lastMap.put ("name",labelNameLast.substring(0,2));
        lastMap.put ("type","line");
        lastMap.put ("symbolSize",6);
//        lastMap.put ("symbol","circle");
        List<HashMap<String,Object>> listzxt=new ArrayList<> ();
        listzxt.add (nowMap);
        listzxt.add (lastMap);
        if(ty==0 && "1".equals(type)){
            HashMap<String, Object> newMap=new HashMap<> ();
            List<String> newList= new ArrayList<>();
            BusinessStatisticsYueyangElectricity temp = new BusinessStatisticsYueyangElectricity();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            temp.setPreparationDate(date);
            List<BusinessStatisticsYueyangElectricity> list = businessStatisticsYueyangElectricityService.selectBusinessStatisticsYueyangElectricityList(temp);
            if(list.size()>0){
                temp=list.get(0);
            }
            newList.add(temp.getKey0());
            newList.add(temp.getKey1());
            newList.add(temp.getKey2());
            newList.add(temp.getKey3());
            newList.add(temp.getKey4());
            newList.add(temp.getKey5());
            newList.add(temp.getKey6());
            newList.add(temp.getKey7());
            newList.add(temp.getKey8());
            newList.add(temp.getKey9());
            newList.add(temp.getKey10());
            newList.add(temp.getKey11());
            newList.add(temp.getKey12());
            newList.add(temp.getKey13());
            newList.add(temp.getKey14());
            newList.add(temp.getKey15());
            newList.add(temp.getKey16());
            newList.add(temp.getKey17());
            newList.add(temp.getKey18());
            newList.add(temp.getKey19());
            newList.add(temp.getKey20());
            newList.add(temp.getKey21());
            newList.add(temp.getKey22());
            newList.add(temp.getKey23());
            newList.add(temp.getKey24());
            newMap.put ("data", newList);
            newMap.put ("name","今日计划");
            newMap.put ("type","line");
            newMap.put ("symbolSize",6);
            listzxt.add (newMap);
//            HashMap<String, Object> nowMap=new HashMap<> ();
//            List<String> nowList= new ArrayList<>();
//            List<String> lastList= new ArrayList<>();
//            nowList.add(temp.getKey4());
//            nowList.add(temp.getKey5());
//            nowList.add(temp.getKey9());
//            nowList.add(temp.getKey19());
//            nowList.add(temp.getKey6());
//            nowList.add(temp.getKey5());
//            nowList.add(temp.getKey6());
//            nowList.add(temp.getKey7());
//            nowList.add(temp.getKey8());
//            nowList.add(temp.getKey9());
//            nowList.add(temp.getKey10());
//            nowList.add(temp.getKey11());
//            nowList.add(temp.getKey12());
//            nowList.add(temp.getKey13());
//            nowList.add(temp.getKey14());
//            nowList.add(temp.getKey15());
//            nowList.add(temp.getKey16());
//            nowList.add(temp.getKey17());
//            nowList.add(temp.getKey18());
//            nowList.add(temp.getKey19());
//            nowList.add(temp.getKey20());
//            nowList.add(temp.getKey21());
//            nowList.add(temp.getKey22());
//            nowList.add(temp.getKey23());
//            nowList.add(temp.getKey24());
//            lastList.add(temp.getKey3());
//            lastList.add(temp.getKey12());
//            lastList.add(temp.getKey22());
//            lastList.add(temp.getKey13());
//            lastList.add(temp.getKey14());
//            lastList.add(temp.getKey5());
//            lastList.add(temp.getKey6());
//            lastList.add(temp.getKey7());
//            lastList.add(temp.getKey8());
//            lastList.add(temp.getKey9());
//            lastList.add(temp.getKey10());
//            lastList.add(temp.getKey11());
//            lastList.add(temp.getKey12());
//            lastList.add(temp.getKey13());
//            lastList.add(temp.getKey14());
//            lastList.add(temp.getKey15());
//            lastList.add(temp.getKey16());
//            lastList.add(temp.getKey17());
//            lastList.add(temp.getKey18());
//            lastList.add(temp.getKey19());
//            lastList.add(temp.getKey20());
//            lastList.add(temp.getKey21());
//            lastList.add(temp.getKey22());
//            lastList.add(temp.getKey23());
//            lastList.add(temp.getKey24());
//        nowMap.put ("data", nowList);
//        nowMap.put ("name","今日");
//        nowMap.put ("type","line");
//        nowMap.put ("symbolSize",6);
////        nowMap.put ("symbol","circle");
//        HashMap<String, Object> lastMap=new HashMap<> ();
//        lastMap.put ("data", lastList);
//        lastMap.put ("name","昨日");
//        lastMap.put ("type","line");
//        lastMap.put ("symbolSize",6);
//            listzxt.add (lastMap);
//            listzxt.add (newMap);
        }
        HashMap<String,Object> timeAndData=new HashMap<> ();
//        String[] nowTime={"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00"
//                ,"11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};
        timeAndData.put ("data",listzxt);
        timeAndData.put ("nowTime",nowTime);
        timeAndData.put ("lastTime",lastTime);
        if(ty==0){
            timeAndData.put ("newTime",nowTime);
        }
        return  AjaxResult.success (timeAndData);
    }
    /**
     * 清洁能源公司总貌
     * 折线图
     */
    @GetMapping("/seectByLastDayQjny")
    public AjaxResult seectByLastDayQjny(@RequestParam(value = "type",required = false) String type,@RequestParam(value = "stringDate",required = false) String stringDate) {
        //报表名称
        String name= "清洁能源公司总貌";
        String place= "清洁能源公司";
        int ty = stringDate.trim().equals("sd")?0:stringDate.trim().equals("fd")?1:stringDate.trim().equals("qngs")?2:3;
        String labelNameNow= ty == 0?"今日0~24点水电实时发电功率":ty==1?"今日0~24点风电实时发电功率":ty==2?"今日0~24点清能公司实时发电功率":"今年按目前日历倒推12天日发电量";
        String labelNameLast= ty == 0?"昨日0~24点水电实时发电功率":ty==1?"昨日0~24点风电实时发电功率":ty==2?"昨日0~24点清能公司实时发电功率":"去年按目前日历倒推12天日发电量";

        //获取点标签
        SkBbLabel byNameNow = skBbLabelService.find (name, labelNameNow, place);
        List<String> selectNow = new ArrayList<> ();
        selectNow.add (byNameNow.getLabel());
        SkBbLabel byNameLast = skBbLabelService.find (name, labelNameLast, place);
        List<String> selectLast= new ArrayList<> ();
        selectLast.add (byNameLast.getLabel());
        //创建时间格式
        SimpleDateFormat t=null;
        if(ty==0 || ty==1 || ty==2){
            t = new SimpleDateFormat ("HH:mm");
        }else{
            t = new SimpleDateFormat ("MM-dd");
        }
        //设置0时0分0秒
        Calendar nowCa =Calendar.getInstance ();
        nowCa.set (Calendar.SECOND,0);
        nowCa.set (Calendar.MINUTE,0);
        nowCa.set (Calendar.HOUR_OF_DAY,0);
        Date nowStartDate=new Date ();
        Date nowEnddate=new Date ();
        Date rfdlNowStartDate=new Date ();
        Date rfdlNowEnddate=new Date ();

        //设置0时0分0秒
        Calendar lastCa =Calendar.getInstance ();
        lastCa.set (Calendar.SECOND,0);
        lastCa.set (Calendar.MINUTE,0);
        lastCa.set (Calendar.HOUR_OF_DAY,0);
        Date lastStartDate=new Date ();
        Date lastEnddate=new Date ();
        Date rfdlLastStartDate=new Date ();
        Date rfdlLastEnddate=new Date ();
        //判断查询日期
        //0=昨日0~24点实时发电功率
        //1=去年按目前日历倒推12天日发电量
        //2=去年1-12月利润总额实际完成
        //3=去年1-12月标煤采购单价
        if(ty==0 || ty==1 || ty==2){
            //今日
            nowStartDate=nowCa.getTime ();
            nowCa.add (Calendar.DATE,1);
            nowEnddate=nowCa.getTime ();

            //昨日
            lastEnddate=lastCa.getTime ();
            lastCa.add (Calendar.DATE,-1);
            lastStartDate=lastCa.getTime ();
        }else if(ty==3){
            //十二天前
            nowCa.add (Calendar.DATE,0);
            nowEnddate=nowCa.getTime ();
            nowCa.add (Calendar.DATE,-12);
            nowStartDate=nowCa.getTime ();



            //去年十二天前
            lastCa.add (Calendar.YEAR,-1);
            lastCa.add (Calendar.DATE,0);
            lastEnddate=lastCa.getTime ();
            lastCa.add (Calendar.DATE,-12);
            lastStartDate=lastCa.getTime ();

            //十二天前
            nowCa.add (Calendar.DATE,-1);
            rfdlNowStartDate=nowCa.getTime ();
            nowCa.add (Calendar.DATE,12);
            rfdlNowEnddate=nowCa.getTime ();



            //去年十二天前
            lastCa.add (Calendar.DATE,-1);
            rfdlLastStartDate=lastCa.getTime ();
            lastCa.add (Calendar.DATE,12);
            rfdlLastEnddate=lastCa.getTime ();
        }
        String nowStartDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowStartDate);
        String nowEndDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowEnddate);
        String lastStartDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastStartDate);
        String lastEndDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastEnddate);


        try {
            nowStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(nowStartDateTime);
            nowEnddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(nowEndDateTime);
            lastStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lastStartDateTime);
            lastEnddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lastEndDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> nowList = DataUtil.lastDataDateUtil(selectNow,t,nowStartDate,nowEnddate,ty,1);
        List<String> nowTime= DataUtil.lastDataTimeUtil(selectNow,t,nowStartDate,nowEnddate,ty,1);


        List<String> lastList = DataUtil.lastDataDateUtil(selectLast,t,lastStartDate,lastEnddate,ty,1);
        List<String> lastTime= DataUtil.lastDataTimeUtil(selectLast,t,lastStartDate,lastEnddate,ty,1);
        if(ty==3){
            nowTime= DataUtil.lastDataTimeUtil(selectNow,t,rfdlNowStartDate,rfdlNowEnddate,ty,1);
            lastTime= DataUtil.lastDataTimeUtil(selectLast,t,rfdlLastStartDate,rfdlLastEnddate,ty,1);
        }
        HashMap<String, Object> nowMap=new HashMap<> ();
        nowMap.put ("data", nowList);
        nowMap.put ("name",labelNameNow.substring(0,2));
        nowMap.put ("type","line");
        nowMap.put ("symbolSize",6);
//        nowMap.put ("symbol","circle");
        HashMap<String, Object> lastMap=new HashMap<> ();
        lastMap.put ("data", lastList);
        lastMap.put ("name",labelNameLast.substring(0,2));
        lastMap.put ("type","line");
        lastMap.put ("symbolSize",6);
//        lastMap.put ("symbol","circle");
        List<HashMap<String,Object>> listzxt=new ArrayList<> ();
        listzxt.add (nowMap);
        listzxt.add (lastMap);
        HashMap<String,Object> timeAndData=new HashMap<> ();
        timeAndData.put ("data",listzxt);
        timeAndData.put ("nowTime",nowTime);
        timeAndData.put ("lastTime",lastTime);
        return  AjaxResult.success (timeAndData);
    }

    private List<String> selectLable(String name,String place,List<String> lableNameList){
        List<String> returnLable = new ArrayList<>();
        for(String labelName :lableNameList){
            SkBbLabel byName = skBbLabelService.find(name,labelName,place);
            if(byName!=null)returnLable.add (byName.getLabel ());
        }
        return returnLable;
    }

    /**
     * 湖南分公司总貌/岳阳电厂总貌
     */
    @GetMapping("/selectSkQuYuZongMaoByMap")
    public JSONObject selectSkQuYuZongMaoByMap(@RequestParam(value = "type",required = false) String type){
        String name= type.trim().equals("0")?"湖南分公司总貌":"岳阳电厂总貌";
        String place= type.trim().equals("0")?"湖南分公司":"岳阳电厂";
        List<String> labelNameList =new ArrayList<> ();
        labelNameList.add("湖南分公司实时总负荷");
        labelNameList.add("岳阳电厂实时总负荷");
        labelNameList.add("苏宝顶风电实时总负荷");
        labelNameList.add("桂东风电实时总负荷");
        labelNameList.add("连坪风电实时总负荷");
        labelNameList.add("梅桥风电实时总负荷");
        labelNameList.add("北湖风电实时总负荷");
        labelNameList.add("回龙圩风电实时总负荷");
        labelNameList.add("湘祁水电实时总负荷");
        labelNameList.add("江口风电实时总负荷");
        List<String> lists = selectLable(name,place,labelNameList);
        JSONObject jsob =  DataUtil.dataUtilByName(lists,labelNameList);
        return jsob;
    }

    /**
     * 清洁能源公司总貌
     * @return
     */
    @GetMapping("/selectQjnyGszmByMap")
    public JSONObject selectQjnyGszmByMap(){
        String name = "清洁能源公司总貌";
        String place = "清洁能源公司";
        List<String> labelNameList =new ArrayList<> ();
        labelNameList.add("苏宝顶风电实时总负荷");
        labelNameList.add("桂东风电实时总负荷");
        labelNameList.add("连坪风电实时总负荷");
        labelNameList.add("梅桥风电实时总负荷");
        labelNameList.add("北湖风电实时总负荷");
        labelNameList.add("回龙圩风电实时总负荷");
        labelNameList.add("湘祁水电实时总负荷");
        labelNameList.add("江口风电实时总负荷");
        List<String> lists = selectLable(name,place,labelNameList);
        JSONObject jsob =  DataUtil.dataUtilByName (lists,labelNameList);
        return jsob;
    }
}
