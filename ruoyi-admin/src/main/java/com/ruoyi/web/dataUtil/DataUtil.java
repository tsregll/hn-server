package com.ruoyi.web.dataUtil;

import cn.com.skdb.api.ISkApi;
import cn.com.skdb.api.SkFactory;
import cn.com.skdb.api.SkHisval;
import cn.com.skdb.api.SkNowval;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.exception.CustomException;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;


public class DataUtil {


    public  static  List<SkNowval> dataList(List<String> list)
    {
        //接受实时数据对象的集合
        List<SkNowval> skNowvals=null;
        ISkApi connect = null;
        try {
            //神库中台通道
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);

            //添加有功测点
            if(list.size ()>0){
                skNowvals = connect.GetNowValue (list);
            }
            //返回实时数据对象的集合

        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new CustomException ("网络错误！数据访问失败");
            //e.printStackTrace();
        }finally {
            //关闭连接
            connect.Close();
        }
        return  skNowvals;
    }

    /**
     * 报表
     * @param list
     * @param da
     * @param type
     * @return
     */
    public  static HashMap<String,String> dataListY(List<SkBbLabel> list,String da,String type)
    {
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        HashMap<String,String> map=null;
        if(da==null||type==null){

            List<SkNowval> skNowvals=null;
            ISkApi connect = null;

            try {
                connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);
                List<String> vCpids = new ArrayList<String> ();
                //添加有功测点
                if(list.size ()>0){
                    for(SkBbLabel s:list){
                        vCpids.add (s.getLabel ());
                    }
                }
                skNowvals = connect.GetNowValue (vCpids);
                map=new HashMap<> ();
                //添加表头 和单位
                map.put ("unit",list.get (0).getUnit ());
                map.put ("labelName",list.get (0).getLabelName ());
                map.put ("place",list.get (0).getPlace ());
                for(int i=0;i<skNowvals.size ();i++){

                    if(skNowvals.get (i).value.Status==0){
                        //如果返回的对象状态为0将值设置为/
                        map.put ("key"+i,"/");
                    }else {
                        //拼接键值
                        map.put ("key"+i,numberFormat.format (skNowvals.get (i).value.Value));
                    }

                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new CustomException ("网络错误！数据访问失败");
                //e.printStackTrace();
            }finally {
                connect.Close();
            }
            return map;
        }
        else {
            //前台传过来没有带时分秒  神库那边需要时分秒 所以做一个拼接
            String date=da+" 00:00:00";
            String date1=da+" 01:00:00";
            //设置格式
            SimpleDateFormat t=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
            Calendar ca =Calendar.getInstance ();
            Calendar ca1 =Calendar.getInstance ();
            Date dateNew=null;
            Date dateNew1=null;
            List<SkHisval> skHisvals=null;
            List<String> label=new ArrayList<> ();
            for(SkBbLabel sj:list){
                label.add (sj.getLabel ());
            }
            try{
                dateNew=t.parse (date);
                dateNew1=t.parse (date1);
                ca.setTime (dateNew);
                ca1.setTime (dateNew1);
                if(date!=null||date.length ()!=0){
                    //type =1 获取天的历史数据 2是周的历史数据  3是月的历史数据  4是年的历史数据
                    if(type.equals ("1")){
                        ca.add (Calendar.DATE,1);
                        ca1.add (Calendar.DATE,1);
                        skHisvals= list2 (label, ca.getTime (), ca.getTime ());
                    }else if(type.equals ("2")){
                        ca.add (Calendar.DATE,7);
                        ca1.add (Calendar.DATE,7);
                        skHisvals= list2 (label, ca.getTime (), ca1.getTime ());
                    }else if(type.equals ("3")){
                        ca.set(Calendar.DAY_OF_MONTH,1);
                        ca.add(Calendar.MONTH, 1);
                        ca1.set(Calendar.DAY_OF_MONTH,1);
                        ca1.add(Calendar.MONTH, 1);
                        skHisvals= list2 (label, ca.getTime (), ca.getTime ());
                    }else if(type.equals ("a")){
                        ca.add (Calendar.DATE,0);
                        ca1.add (Calendar.DATE,0);
                        skHisvals= list2 (label, ca.getTime (), ca.getTime ());
                    }else {
                        ca.set(Calendar.DAY_OF_YEAR,1);
                        ca.add(Calendar.YEAR, 1);
                        ca1.set(Calendar.DAY_OF_YEAR,1);
                        ca1.add(Calendar.YEAR, 1);
                        skHisvals= list2 (label, ca.getTime (), ca.getTime ());
                    }
                }
                map=new HashMap<> ();
                map.put ("unit",list.get (0).getUnit ());
                map.put ("labelName",list.get (0).getLabelName ());
                for(int i=0;i<skHisvals.size ();i++){
                    if(skHisvals.get (i).values.size ()==0){
                        map.put ("key"+i,"0");
                    }else if(skHisvals.get (i).values.get (0).Status==0){
                        map.put ("key"+i,"/");
                    } else{
                        map.put ("key"+i,numberFormat.format (skHisvals.get (i).values.get (0).Value));
                    }
                }
            }catch (ParseException e){
                e.printStackTrace();
            }
            return map;
        }
    }
    /**
     * 报表
     * @param list
     * @param da
     * @return
     */
    public  static HashMap<String,List<String>> dataListY(List<SkBbLabel> list,String da)
    {
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        HashMap<String,List<String>> map= new HashMap();
        if(da==null){
            List<SkNowval> skNowvals=null;
            ISkApi connect = null;
            try {
                connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);
                List<String> vCpids = new ArrayList<String> ();
                //添加有功测点
                for(SkBbLabel s:list){
                    vCpids.add (s.getLabel ());
                }
                skNowvals = connect.GetNowValue (vCpids);
                //添加表头 和单位
                List<String> nameList = new ArrayList<>();
                List<String> sumList = new ArrayList<>();
                for(int i=0;i<skNowvals.size ();i++){
                    nameList.add(list.get(i).getPlace()+list.get(i).getLabelName());
                    if(skNowvals.get (i).value.Status==0){
                        sumList.add("/");
                    }else {
                        sumList.add(numberFormat.format (skNowvals.get (i).value.Value));
                    }
                }
                map.put("name",nameList);
                map.put("date",sumList);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new CustomException ("网络错误！数据访问失败");
                //e.printStackTrace();
            }finally {
                connect.Close();
            }
            return map;
        }
        else {
            //前台传过来没有带时分秒  神库那边需要时分秒 所以做一个拼接
            String date=da+" 00:00:00";
            String date1=da+" 01:00:00";
            //设置格式
            SimpleDateFormat t=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
            Calendar ca =Calendar.getInstance ();
            Calendar ca1 =Calendar.getInstance ();
            Date dateNew=null;
            Date dateNew1=null;
            List<SkHisval> skHisvals=null;
            List<String> label=new ArrayList<> ();
            for(SkBbLabel sj:list){
                label.add (sj.getLabel ());
            }
            try{
                dateNew=t.parse (date);
                dateNew1=t.parse (date1);
                ca.setTime (dateNew);
                ca1.setTime (dateNew1);
                ca.set(Calendar.DAY_OF_MONTH,1);
                ca.add(Calendar.MONTH, 1);
                skHisvals= list2 (label, ca.getTime (), ca.getTime ());
                List<String> nameList = new ArrayList<>();
                List<String> sumList = new ArrayList<>();
                for(int i=0;i<skHisvals.size ();i++){
                    nameList.add(list.get(i).getPlace()+list.get(i).getLabelName());
                    if(skHisvals.get(i).values.get(0).Status==0){
                        sumList.add("/");
                    }else {
                        sumList.add(numberFormat.format (skHisvals.get (i).values.get(0).Value));
                    }
                }
                map.put("name",nameList);
                map.put("date",sumList);
            }catch (ParseException e){
                e.printStackTrace();
            }
            return map;
        }
    }

    /**
     *
     * @param list 标签集合
     * @param date 前一天的时间
     * @param date1 今天的时间
     * @return
     */
    public static   List<SkHisval> list1(List<String> list,Date date,Date date1)
    {

        List<SkHisval> skHisvals=null;
        ISkApi connect = null;
        try {
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);

            //添加有功测点

            skHisvals = connect.GetHistoryValue (list,date,date1,120000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new CustomException ("网络错误！数据访问失败");
            //e.printStackTrace();
        }finally {
            connect.Close();
        }
        return  skHisvals;
    }

    /**
     * 查询历史数据
     * @param list  标签集合
     * @param date
     * @param date1
     * @return
     */
    public static   List<SkHisval> list2(List<String> list,Date date,Date date1)
    {
        List<SkHisval> skHisvals=null;
        ISkApi connect = null;
        String date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String date3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        try {
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);

            //添加有功测点

            // 参数（标签集合，起始时间，结束时间，时间间隔（毫秒））
            if(date2.equals(date3)){
                skHisvals = connect.GetHistoryValue (list,date,date1,60);
            }else{
                skHisvals = connect.GetHistoryValue (list,date,date1,60000);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new CustomException ("网络错误！数据访问失败");
            //e.printStackTrace();
        }finally {
            connect.Close();
        }
        return  skHisvals;
    }
    /**
     *  点对点
     * @param list  标签集合
     * @return
     */
    public static   JSONObject dataUtil(List<String> list){
        List<SkNowval> skNowvals= null;
        try {
            skNowvals = dataList (list);
        } catch (Exception e) {
            throw new CustomException ("网络错误！数据访问失败");
        }
        HashMap<String, Object> map1=new HashMap<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);

        for(int i=0;i<skNowvals.size ();i++){
            if(skNowvals.get (i).value.Status==0){
                //状态为0 为异常数据  设置/   把标签做键   把标签的. 换成_方便前台识别
                map1.put (list.get (i).replace (".","_"),"/");
            }else {
                //把标签的. 换成_方便前台识别
                map1.put (list.get (i).replace (".","_"),numberFormat.format (skNowvals.get (i).value.Value).replace (",",""));
            }
        }
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",map1);
        return jsonObject;
    }
    /**
     *  柱图
     * @param list  标签集合
     * @return
     */
    public static   JSONObject dataTbUtil(List<String> list,List<String> list1){
        List<SkNowval> skNowvals= null;
        try {
            skNowvals = dataList (list);
        } catch (Exception e) {
            throw new CustomException ("网络错误！数据访问失败");
        }
        HashMap<String, Object> map1=new HashMap<> ();
        HashMap<String, Object> map2=new HashMap<> ();
        HashMap<String, Object> map3=new HashMap<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        List<HashMap<String, Object>> value=new ArrayList<> ();
        List<String> zt=new ArrayList<> ();
        //总负荷率
        List<String> fhl=new ArrayList<> ();
//        for(int i=0;i<skNowvals.size ();i++){
//            zt.add (numberFormat.format (skNowvals.get (i).value.Value));
//        }
        for(int i=0;i<skNowvals.size ();i++){
            if(skNowvals.get (i).value.Status==0){
                zt.add ("/");
            }else {
                zt.add (numberFormat.format (skNowvals.get (i).value.Value).replace (",",""));
            }
        }
        List<String> list2 = dataDateUtil1 (list1);
        map1.put ("barWidth",20);
        map1.put ("barGap","-100%");
        map1.put ("data",list2);
        map1.put ("name","总负荷");
        map1.put ("type","bar");
//        map1.put ("stack","总量");


        map2.put ("barWidth",20);
        map2.put ("data",zt);
        map2.put ("name","总装机容量");
        map2.put ("type","bar");
//        map2.put ("stack","总量");


        double t1=0;
        double t2=0;
        for (int i = 1; i < list2.size()-1; i++) {
            if (!list2.get(i).equals("/") && !zt.get(i).equals("/") &&Double.parseDouble(list2.get(i))>5){
                t1+=Double.parseDouble(list2.get(i));
                t2+=Double.parseDouble(zt.get(i));
            }
        }
        Integer t3=(int)(100*t1/t2);
        fhl.add(t3.toString());
        for (int i = 1; i < list2.size(); i++) {
            if("/".equals(zt.get(i))){
                fhl.add("0");
            }else{
                Double v1 = "/".equals(list2.get(i))?0:Double.parseDouble(list2.get(i));
                Double v2 = "/".equals(zt.get(i))?0:Double.parseDouble(zt.get(i));
                Integer v3 = (int)(100*v1/v2);
                fhl.add(v3.toString());
            }
        }
        map3.put ("barWidth",20);
        map3.put ("barGap","-100%");
        map3.put ("data",fhl);
        map3.put ("name","总负荷率(%)");
        map3.put ("type","scatter");
//        map3.put ("type","line");
//        Map<String,Object> lineStyle = new HashMap<>();
//        lineStyle.put("color","#0000FF");
//        map3.put ("lineStyle",lineStyle);
//        map3.put ("smooth","true");
//        map3.put ("showSymbol","false");

//        {
//            name: '芜湖起飞',
//            type: 'line',
//            stack: '总量',
//             smooth: true,
//            showSymbol: false,
//            emphasis: {
//            focus: 'series'
//        },
//            data: ['24', '32','40' , '28']//2400, 3200, 3000, 2800, 1800, 500, 4000,1200, 2200, 1100, 2400, 2000,
//        }

        value.add (map2);
        value.add (map1);
        value.add (map3);
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",value);
        jsonObject.put ("data2",map3);

        return jsonObject;
    }

    /**
     * 折线图用的
     * @param list
     * @return
     */
    public static   List<String> dataDateUtil(List<String> list){
        SimpleDateFormat t=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Calendar ca =Calendar.getInstance ();
        //设置0秒
        ca.set (Calendar.SECOND,0);
        //设置0分
        ca.set (Calendar.MINUTE,0);
        //设置0时
        ca.set (Calendar.HOUR_OF_DAY,0);
        Date date=new Date ();
        Date date1=new Date ();
        //今天
        date=ca.getTime ();
        //前一天
        ca.add (Calendar.DATE,1);
        date1=ca.getTime ();
       // HashMap<String, List<String>> map1=new HashMap<> ();
        List<String> zxsz=new ArrayList<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        List<SkHisval> skHisvals = list1 (list, date, date1);
            for(SkHisval s:skHisvals) {
                for (int i = 0; i < s.values.size (); i++) {
                    if(s.values.get (i).Status==0){
                        zxsz.add ("/");
                    }else{
                        zxsz.add (numberFormat.format (s.values.get (i).Value).replace (",",""));
                    }
                }
                 //   map1.put (list.get (0).replace (".", "_"), zxsz);
            }
//        JSONObject jsonObject=new JSONObject ();
//        jsonObject.put ("data",map1);
        return zxsz;
    }
    /**
     * 折线图用的
     * @param list
     * @return
     */
    public static   List<String> datatimeUtil(List<String> list){
        SimpleDateFormat t=new SimpleDateFormat ("HH:mm");
        Calendar ca =Calendar.getInstance ();
        //设置0秒
        ca.set (Calendar.SECOND,0);
        //设置0分
        ca.set (Calendar.MINUTE,0);
        //设置0时
        ca.set (Calendar.HOUR_OF_DAY,0);
        Date date=new Date ();
        Date date1=new Date ();
        //今天
        date=ca.getTime ();
        //前一天
        ca.add (Calendar.DATE,1);
        date1=ca.getTime ();
        // HashMap<String, List<String>> map1=new HashMap<> ();
        List<String> zxsz=new ArrayList<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        List<SkHisval> skHisvals = list1 (list, date, date1);
        for(SkHisval s:skHisvals) {
            for (int i = 0; i < s.values.size (); i++) {
                if(s.values.get (i).Status==0){
                    zxsz.add (t.format (s.values.get (i).Time));
                }else{
                    zxsz.add (t.format (s.values.get (i).Time));
                }
            }
            //   map1.put (list.get (0).replace (".", "_"), zxsz);
        }
//        JSONObject jsonObject=new JSONObject ();
//        jsonObject.put ("data",map1);
        return zxsz;
    }
    /**
     * 柱图用的
     * @param list
     * @return
     */
    public static   List<String> dataDateUtil1(List<String> list){
        Calendar ca =Calendar.getInstance ();
        //设置0秒
        ca.set (Calendar.SECOND,0);
        //设置0分
        ca.set (Calendar.MINUTE,0);
        //设置0时
        ca.set (Calendar.HOUR_OF_DAY,0);
        Date date=new Date ();
        //前一天
        ca.add (Calendar.DATE,-1);
        date=ca.getTime ();
        HashMap<String, List<String>> map1=new HashMap<> ();
        List<String> zxsz=new ArrayList<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        List<SkNowval> skNowvals = dataList(list);
        for(int i=0;i<skNowvals.size ();i++){
            if(skNowvals.get (i).value.Status==0){
                zxsz.add ("/");
            }else {
                zxsz.add (numberFormat.format (skNowvals.get (i).value.Value).replace (",",""));
            }
        }
//        for(SkNowval s:skNowvals) {
//            for (int i = 0; i < s.value.Value. (); i++) {
//                if(s.values.get (i).Status==0){
//                    zxsz.add("-");
//                }else{
//                    zxsz.add (numberFormat.format (s.values.get (i).Value).replace (",",""));
//                }
//            }
//
//        }

        return zxsz;
    }



    /**
     * 通过点标签获取值（折线图）
     * @param list 点标签集合
     * @param t 格式日期对象
     * @param date 旧日期
     * @param date1 新日期
     * @return 查询结果
     */
    public static   List<String> lastDataDateUtil(List<String> list, SimpleDateFormat t,Date date,Date date1,int ty,int gs){
        List<String> zxsz=new ArrayList<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        List<SkHisval> skHisvals = null;
        if(gs ==0){
            if(ty ==0){
                skHisvals = listDayByMM (list, date, date1);
            }else{
                skHisvals = listByDay (list, date, date1);
            }
        }else{
            if(ty < 3){
                skHisvals = listDayByMM (list, date, date1);
            }else{
                skHisvals = listByDay (list, date, date1);
            }

        }
        for(SkHisval s:skHisvals) {
            for (int i = 0; i < s.values.size (); i++) {
                if(s.values.get (i).Status==0){
                    zxsz.add ("/");
                }else{
                    zxsz.add (numberFormat.format (s.values.get (i).Value).replace (",",""));
                }
            }
        }
        return zxsz;
    }


    //获得日期集合(折线图)

    public static   List<String> lastDataTimeUtil(List<String> list, SimpleDateFormat t,Date date,Date date1,int ty,int gs){
        List<String> zxsz=new ArrayList<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        List<SkHisval> skHisvals = null;
        if(gs==0){
            if(ty ==0){
                skHisvals = listDayByMM (list, date, date1);
            }else{
                skHisvals = listByDay (list, date, date1);
            }
        }else{
            if(ty <3){
                skHisvals = listDayByMM (list, date, date1);
            }else{
                skHisvals = listByDay (list, date, date1);
            }
        }
        for(SkHisval s:skHisvals) {
            for (int i = 0; i < s.values.size (); i++) {
                if(s.values.get (i).Status==0){
                    zxsz.add (t.format (s.values.get (i).Time));
                }else{
                    zxsz.add (t.format (s.values.get (i).Time));
                }
            }
        }
        return zxsz;
    }


    /**
     *重写list1，实现天数查询
     * @return
     */
    public static   List<SkHisval> listByDay(List<String> list,Date date,Date date1)
    {

        List<SkHisval> skHisvals=null;
        ISkApi connect = null;
        try {
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);

            //添加有功测点
            skHisvals = connect.GetHistoryValue (list,date,date1,86400000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new CustomException ("网络错误！数据访问失败");
            //e.printStackTrace();
        }finally {
            connect.Close();
        }
        return  skHisvals;
    }

    /**
     *  重写点对点
     * @param list  标签集合
     * @return
     */
    public static   JSONObject dataUtil(List<String> list,List<String> jd){
        List<SkNowval> skNowvals= null;
        try {
            skNowvals = dataList (list);
        } catch (Exception e) {
            throw new CustomException ("网络错误！数据访问失败");
        }
        HashMap<String, Object> map1=new HashMap<> ();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);

        NumberFormat tfNumberFormat=NumberFormat.getNumberInstance ();
        tfNumberFormat.setMaximumFractionDigits (0);

        for(int i=0;i<skNowvals.size ();i++){
            boolean tf = false;
            for(String jds :jd){
                if(skNowvals.get(i).Cpid.equals(jds))tf = true;
            }
            if(tf){//HNHN_QJNYGSZM_BYLRZEWCJD_SKCAL
//                    map1.put (list.get (i).replace (".","_"),tfNumberFormat.format (new Double(25.35)).replace (",",""));
                if(skNowvals.get (i).value.Status==0){
                    map1.put (list.get (i).replace (".","_"),"0");
                }else {
                    map1.put (list.get (i).replace (".","_"),tfNumberFormat.format (skNowvals.get (i).value.Value).replace (",",""));
                }
            }else{
                //状态为0 为异常数据  设置/   把标签做键   把标签的. 换成_方便前台识别
                if(skNowvals.get (i).value.Status==0){
                    map1.put (list.get (i).replace (".","_"),"/");
                }else {
                    //把标签的. 换成_方便前台识别
                    map1.put (list.get (i).replace (".","_"),numberFormat.format (skNowvals.get (i).value.Value).replace (",",""));
                }
            }
        }
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",map1);
        return jsonObject;
    }

    public static List<List<String>> yearList(List<String> list1,List<String> time){
        List<List<String>> returnList = new ArrayList<>();
        List<String> ifList = new ArrayList<>();
        List<String> ifTime= new ArrayList<>();
        for(int i =0;i<time.size();i++){
            //yyyy-MM-dd
            Integer dateDay = Integer.parseInt(time.get(i).substring(8,10));
            if(dateDay==1){
                ifList.add(list1.get(i));
                ifTime.add(time.get(i));
            }
        }
        returnList.add(ifList);
        returnList.add(ifTime);
        return returnList;
    }

    /**
     *
     * @param list 标签集合
     * @param date 前一天的时间
     * @param date1 今天的时间
     * @return
     */
    public static   List<SkHisval> listDayByMM(List<String> list,Date date,Date date1)
    {

        List<SkHisval> skHisvals=null;
        ISkApi connect = null;
        try {
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);

            //添加有功测点

            skHisvals = connect.GetHistoryValue (list,date,date1,3600000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new CustomException ("网络错误！数据访问失败");
            //e.printStackTrace();
        }finally {
            connect.Close();
        }
        return  skHisvals;
    }
    //市场交易
    public static List<Double> selectETInsert(List<String> lable,String dateTime){
        if(dateTime.isEmpty()){
            dateTime = ToolUtils.changeTime(dateTime,"1");
        }
        List<Double> returnList = new ArrayList<>();
        SimpleDateFormat t=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        if(dateTime.length()==7)dateTime = dateTime+"-01 00:00:00";
        Calendar ca =Calendar.getInstance ();
        try {
            Date dateNew = t.parse(dateTime);
            ca.setTime(dateNew);
            ca.set(Calendar.DAY_OF_MONTH, 1);
            ca.add(Calendar.MONTH, 1);
            Date beTime = ca.getTime();
            ca.add(Calendar.HOUR, 1);
            Date enTime = ca.getTime();
            List<SkHisval> skHisvals = list2(lable,beTime,enTime);
            for (int i =0;i<skHisvals.size();i++){
                SkHisval sk = skHisvals.get(i);
                if(sk.values.size()>0){
                    returnList.add(sk.values.get(0).Value);
                }else{
                    returnList.add(new Double(0.00));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    /**
     * 重写为弃风月度使用
     * @param lable
     * @param dateTime
     * @return
     */
    public static Map<String,Double> selectQfInsert(List<String> lable,String dateTime){
        SimpleDateFormat t=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Map<String,Double> returnMap = new HashMap<>();
        if(dateTime.length()==7)dateTime = dateTime+"-01 00:00:00";
        Calendar ca =Calendar.getInstance ();
        try {
            Date dateNew = t.parse(dateTime);
            ca.setTime(dateNew);
            ca.set(Calendar.DAY_OF_MONTH, 1);
            ca.add(Calendar.MONTH, 1);
            Date beTime = ca.getTime();
            ca.add(Calendar.HOUR, 1);
            Date enTime = ca.getTime();
            List<SkHisval> skHisvals = list2(lable,beTime,enTime);
            for (int i =0;i<skHisvals.size();i++){
                SkHisval sk = skHisvals.get(i);
                if(sk.values.size()>0){
                    returnMap.put(lable.get(i),sk.values.get(0).Value);
                }else{
                    returnMap.put(lable.get(i),0.00);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }


    public static String[] getTableHead(String tableType) {
        Properties properties;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("baobiao.properties");
            //遍历取值
            StringBuffer tableHead = new StringBuffer();
            String head;
            if (tableType.equals("yiyang")) {
                head = new String(properties.getProperty("yiyangbaobiaotou").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("meiji1")) {
                head = new String(properties.getProperty("meijibaobiao1").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("meiji2")) {
                head = new String(properties.getProperty("meijibaobiao2").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("yyzb")) {
                head = new String(properties.getProperty("yyzb").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("fdkkxzb")) {
                head = new String(properties.getProperty("fdkkxzb").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("gfkkxzb")) {
                head = new String(properties.getProperty("gfkkxzb").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            } else if (tableType.equals("xqsdkkxzb")) {
                head = new String(properties.getProperty("xqsdkkxzb").getBytes("iso-8859-1"), "UTF-8");
                tableHead.append(head);
            }

            String[] tablehead = tableHead.toString().trim().split(",");
            return tablehead;
        } catch (Exception  e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *  重写点对点
     * @param list  标签集合
     * @return
     */
    public static   JSONObject dataUtilByName(List<String> list,List<String> name){
        JSONObject jsonObject=new JSONObject ();
        List<SkNowval> skNowvals= null;
        try {
            skNowvals = dataList (list);
        } catch (Exception e) {
            throw new CustomException ("网络错误！数据访问失败");
        }
        List<HashMap<String,Object>> lists = new ArrayList<>();
        NumberFormat numberFormat=NumberFormat.getNumberInstance ();
        numberFormat.setMaximumFractionDigits (2);
        for(int i=0;i<skNowvals.size ();i++){
            HashMap<String, Object> map1=new HashMap<> ();
            map1.put("name",name.get(i).substring(0,name.get(i).indexOf("实时总负荷")));
            //状态为0 为异常数据  设置/   把标签做键   把标签的. 换成_方便前台识别
            if(skNowvals.get (i).value.Status==0){
                map1.put ("num","/");
            }else {
                //把标签的. 换成_方便前台识别
                map1.put ("num",numberFormat.format (skNowvals.get (i).value.Value).replace (",",""));
            }
            lists.add(map1);
        }
        jsonObject.put ("data",lists);
        return jsonObject;
    }

    public static Boolean dateTimeToNowDay(String date){
        Boolean booleans = new Boolean(false);
        try {
            Date setDateTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            String nowDate = LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getDayOfMonth();
            Date nowDateTime = new SimpleDateFormat("yyyy-MM-dd").parse(nowDate);
            if(setDateTime.compareTo(nowDateTime)==0){
                booleans = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return booleans;
        }
    }

    public static Boolean dateTimeToNowMonth(String date){
        Boolean booleans = new Boolean(false);
        try {
            Date setDateTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            String nowDate = LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-01";
            Date nowDateTime = new SimpleDateFormat("yyyy-MM-dd").parse(nowDate);
            if(setDateTime.compareTo(nowDateTime)==0){
                booleans = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return booleans;
        }
    }
    public static Boolean dateTimeToNowWeek(String date){
        Boolean booleans = new Boolean(false);
        try {
            Calendar setDateTime = Calendar.getInstance();
            setDateTime.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            setDateTime.add (Calendar.DAY_OF_MONTH,-1);
            String year = LocalDate.now().getYear()+"";
            String month = LocalDate.now().getMonthValue()+"";
            String day = LocalDate.now().getDayOfMonth()+"";
            String now = year+"-"+(month.length()<2?"0"+month:month)+"-"+(day.length()<2?"0"+day:day);
            Date d = new Date();
            Calendar nowDateTime = Calendar.getInstance();
            nowDateTime.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(now));
            nowDateTime.add (Calendar.DAY_OF_MONTH,-1);
            String nows = new SimpleDateFormat("yyyy-MM-dd").format(setDateTime.getTime());
            String set = new SimpleDateFormat("yyyy-MM-dd").format(nowDateTime.getTime());
            Integer setWeek = Integer.parseInt(new SimpleDateFormat("WW").format(setDateTime.getTime()));
            Integer nowWeek = Integer.parseInt(new SimpleDateFormat("WW").format(nowDateTime.getTime()));
            booleans = setWeek == nowWeek;
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return booleans;
        }
    }
    public static String returnDate(String date){
        try {
            Calendar setDateTime = Calendar.getInstance();
            setDateTime.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            Integer setYear = Integer.parseInt(date.substring(0,4));
            Integer setMonth = Integer.parseInt(date.substring(5,7));
            Integer setDay = Integer.parseInt(date.substring(8,10));
            LocalDate ld = LocalDate.of(setYear,setMonth,setDay);
            DayOfWeek week = ld.getDayOfWeek();
            Integer weekInt = week.getValue();
            for(int i = 0;i<weekInt-1;i++){
                setDateTime.add (Calendar.DAY_OF_MONTH,-1);
            }
            date = new SimpleDateFormat("yyyy-MM-dd").format(setDateTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return date;
        }
    }


//    public static void main(String[] args) throws ParseException {
//        String da="2021-3-9";
//        SimpleDateFormat t=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
//        Calendar ca =Calendar.getInstance ();
//        Date date=t.parse (da);
//        ca.setTime (date);
//
//        ca.add (Calendar.DATE,-1);
//        List<SkBbLabel> list=new ArrayList<> ();
//        SkBbLabel skBbLabel=new SkBbLabel ();
//        SkBbLabel skBbLabel1=new SkBbLabel ();
//        SkBbLabel skBbLabel2=new SkBbLabel ();
//        skBbLabel.setLabel ("HNHN.QNSUM.MZJRL.SKCAL");
//        skBbLabel1.setLabel ("HNHN.QNSUM.MPJRL.SKCAL");
//        skBbLabel2.setLabel ("HNHN.QNSUM.MFDL.SKCAL");
//        list.add (skBbLabel);
//        list.add (skBbLabel1);
//        list.add (skBbLabel2);
//        String type="1";
//        HashMap<String, String> map = dataListDate (list, da, type);
//        System.out.println (map.get ("key1"));
//        System.out.println (map.get ("key2"));
//        System.out.println (map.get ("key0"));
//    }
}
