package com.ruoyi.business.toolUtil;

import com.ruoyi.common.utils.StringUtils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ToolUtils {
    /**
     * 保留小数点后2位，如果是0或者-100则返回-
     * @param sum 传入的String类型数据
     * @return 返回的结果
     */
    public static String size4(String sum){
        if( sum == null || sum.trim().equals("") || sum.trim().equals("0.00") || sum.trim().equals("0") || sum.trim().equals("0.0") || sum.trim().equals("-100") || sum.trim().equals("-100.0")) return  "-";
        if( sum.trim().equals("-")) return  sum;
        Double s = new Double(sum);
        if(s>=1||s<=-1){
            DecimalFormat sdf = new DecimalFormat("#.0000");
            sdf.setMaximumFractionDigits(4);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.0000");
            sdf.setMaximumFractionDigits(4);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }
    }

    /**
     * 保留小数点后两位（新增or后台列表使用的）
     * @param sum 需要转换的Double类型
     * @return 返回String的数值
     */
    public static String size4(Double sum){
        if(sum.toString().equals("-100") || sum.toString().equals("-100.0")) return  "0.00";
        if( sum == null ) return  "0.00";
        if(sum>=1||sum<=-1){
            DecimalFormat sdf = new DecimalFormat("#.0000");
            sdf.setMaximumFractionDigits(4);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(sum);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.0000");
            sdf.setMaximumFractionDigits(4);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(sum);
        }
    }
    /**
     * 保留小数点2位（全月日专用）
     * @param sum String类型的数值
     * @return 保留两位小数之后的结果
     */
    public static String size4(String sum,Integer type){
        if( sum == null || sum.trim().equals("") || sum.trim().equals("0.00") || sum.trim().equals("0") || sum.trim().equals("0.0") || sum.trim().equals("-100") || sum.trim().equals("-100.0")) return  "-";
        if( sum.trim().equals("-")) return  sum;
        Double s = new Double(sum);
        if(type == 0){
            s = s/10000;
        }
        if(s>=1||s<=-1){
            DecimalFormat sdf = new DecimalFormat("#.0000");
            sdf.setMaximumFractionDigits(4);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.0000");
            sdf.setMaximumFractionDigits(4);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }
    }

    /**
     * 保留小数点后2位，如果是0或者-100则返回-
     * @param sum 传入的String类型数据
     * @return 返回的结果
     */
    public static String size2(String sum){
        if( sum == null || sum.trim().equals("")) return  "-";
        if(sum.equals("0") || sum.trim().equals("0.00") || sum.trim().equals("0") || sum.trim().equals("0.0") || sum.trim().equals("-100") || sum.trim().equals("-100.0"))return "0.00";
        Double s = new Double(sum);
        if(s>=1||s<=-1){
            DecimalFormat sdf = new DecimalFormat("#.00");
            sdf.setMaximumFractionDigits(2);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.00");
            sdf.setMaximumFractionDigits(2);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }
    }

    /**
     * 保留小数点后两位（新增or后台列表使用的）
     * @param sum 需要转换的Double类型
     * @return 返回String的数值
     */
    public static String size2(Double sum){
        if(sum.toString().equals("-100") || sum.toString().equals("-100.0")) return  "0.00";
        if( sum == null ) return  "0.00";
        if(sum>=1||sum<=-1){
            DecimalFormat sdf = new DecimalFormat("#.00");
            sdf.setMaximumFractionDigits(2);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(sum);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.00");
            sdf.setMaximumFractionDigits(2);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(sum);
        }
    }
    /**
     * 保留小数点后3位，如果是0或者-100则返回-
     * @param sum 传入的String类型数据
     * @return 返回的结果
     */
    public static String size3(String sum){
        if( sum == null || sum.trim().equals("") || sum.trim().equals("0.00") || sum.trim().equals("0") || sum.trim().equals("0.0") || sum.trim().equals("-100") || sum.trim().equals("-100.0")) return  "-";
        if( sum.trim().equals("-")) return  sum;
        Double s = new Double(sum);
        if(s>=1||s<=-1){
            DecimalFormat sdf = new DecimalFormat("#.000");
            sdf.setMaximumFractionDigits(3);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.000");
            sdf.setMaximumFractionDigits(3);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(s);
        }
    }

    /**
     * 保留小数点后三位（新增or后台列表使用的）
     * @param sum 需要转换的Double类型
     * @return 返回String的数值
     */
    public static String size3(Double sum){
        if(sum.toString().equals("-100") || sum.toString().equals("-100.0")) return  "0.00";
        if( sum == null ) return  "0.00";
        if(sum>=1||sum<=-1){
            DecimalFormat sdf = new DecimalFormat("#.000");
            sdf.setMaximumFractionDigits(3);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(sum);
        }else{
            DecimalFormat sdf = new DecimalFormat("0.000");
            sdf.setMaximumFractionDigits(3);
            sdf.setGroupingSize(0);
            sdf.setRoundingMode(RoundingMode.DOWN);
            return sdf.format(sum);
        }
    }
    /**
     * 判断是否为空日期，为空默认赋值当前日期的前一个月
     * @param defaultDate 要判断的日期
     * @param type 默认方式（0：当天，1：当月，2：昨天，3：上个月）
     * @return 计算后的日期
     */
    public static String defaultLastMonth(String defaultDate,String type){
        //获取传入参数
        String returnDefaultDate = defaultDate;
        //判断是否为空
        if(StringUtils.isEmpty(returnDefaultDate)){
            //定义转换对象（天）
            SimpleDateFormat dayDf = new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat monthDf = new SimpleDateFormat ("yyyy-MM");
            //定义天用的转换对象
            Calendar ca =Calendar.getInstance ();
            //定义转换用字符串
            String caString ="";
            //定义转换用Date对象
            Date date = null;
            //获取年月日
            Integer year = LocalDate.now().getYear();
            Integer month = LocalDate.now().getMonthValue();
            Integer day = LocalDate.now().getDayOfMonth();
            //转换成String的2长度数据(月与日)
            String monthStr = month.toString().length()<2?"0"+month.toString():month.toString();
            String dayStr = day.toString().length()<2?"0"+day.toString():day.toString();
            //判断默认类型：0为获取当天，1为前天，2为当月，3为上个月
            try {
                if(type.trim().equals("0")){
                    //当前天数无须转换，直接赋值
                    returnDefaultDate = year.toString() + "-" + monthStr + "-" + dayStr;
                }else if(type.trim().equals("1")){
                    caString = year.toString() + "-" + monthStr + "-" + dayStr;
                    date = dayDf.parse(caString);
                    ca.setTime(date);
                    ca.add (Calendar.DATE,-1);
                    returnDefaultDate = dayDf.format(ca.getTime());
                }else if(type.trim().equals("2")){
                    //当前月份无须转换，直接赋值
                    returnDefaultDate = year.toString() + "-" + monthStr;
                }else if(type.trim().equals("3")){
                    caString = year.toString() + "-" + monthStr + "-01";
                    date = dayDf.parse(caString);
                    ca.setTime(date);
                    ca.add (Calendar.DATE,-1);
                    returnDefaultDate = monthDf.format(ca.getTime());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return returnDefaultDate;
    }
    /**
     * 判断是否为空日期，为空默认赋值本地时间日期
     * @param defaultDate 要判断的日期
     * @param type 默认方式（0：本地时间当天，1：本地时间当月，2：参数时间当天，3：参数时间当月，4：参数时间当年，5：参数时间增加一个月，6：参数时间增加一年，7：本地时间当年，8：参数时间减少一个月）
     * @return 计算后的日期
     */
    public static String changeTime(String defaultDate,String type){
        //获取传入参数
        String returnDefaultDate = defaultDate;
        String returnChangeDate = defaultDate;
        //判断是否为空
        if(StringUtils.isNotEmpty(returnDefaultDate)){
            //获取当前系统时间
            Date date = new Date();
            SimpleDateFormat dayDf = new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat monthDf = new SimpleDateFormat ("yyyy-MM");
            SimpleDateFormat yearDf = new SimpleDateFormat ("yyyy");

            Calendar cal = Calendar.getInstance();
            try {
                Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(defaultDate);
                cal.setTime(currentDate);//设置为获取的时间
                if(type.equals("0")){
                    returnChangeDate=dayDf.format(date);
                }else if(type.equals("1")){
                    returnChangeDate=monthDf.format(date);
                }else if(type.equals("2")){
                    returnChangeDate=dayDf.format(currentDate);
                }else if(type.equals("3")){
                    returnChangeDate=monthDf.format(currentDate);
                }else if(type.equals("4")){
                    returnChangeDate=yearDf.format(currentDate);
                }else if(type.equals("5")){
                    cal.setTime(monthDf.parse(returnDefaultDate));
                    cal.add(Calendar.MONTH, 1);//增加一个月
                    returnChangeDate= monthDf.format(cal.getTime());
                }else if(type.equals("6")){
                    cal.add(Calendar.YEAR, 1);//增加一年
                    returnChangeDate=monthDf.format(cal.getTime());
                }else if(type.equals("7")){
                    returnChangeDate=yearDf.format(date);
                }else if(type.equals("8")){
                    cal.add(Calendar.MONTH, -1);//增加一个月
                    returnChangeDate=monthDf.format(cal.getTime());
                }
                return returnChangeDate;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Date date = new Date();
            SimpleDateFormat MonthDf = new SimpleDateFormat ("yyyy-MM");
            returnDefaultDate=MonthDf.format(date);
        }
        return returnDefaultDate;
    }
    /**
     * 0增加一个月，1获得参数本年1月，2获得参数当月，3增加一年，4本地当月，5减去一个月
     * @param date 要判断的日期
     * @return 计算后的日期
     */
    public static String changeTime2(String date,String type){
        SimpleDateFormat monthDf = new SimpleDateFormat ("yyyy-MM");
        SimpleDateFormat yearDf = new SimpleDateFormat ("yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(monthDf.parse(date));
            if(type.equals("0")){
                cal.add(Calendar.MONTH, 1);//增加一个月
                date= monthDf.format(cal.getTime());
            }else if(type.equals("1")){
                cal.setTime(yearDf.parse(date));
                date=monthDf.format(cal.getTime());
            }else if(type.equals("2")){
                date=monthDf.format(cal.getTime());
            }else if(type.equals("3")){
                cal.add(Calendar.YEAR, 1);//增加一年
                date= monthDf.format(cal.getTime());
            }else if(type.equals("4")){
                Date newDate = new Date();
                date= monthDf.format(newDate);
            }else if(type.equals("5")){
                cal.add(Calendar.MONTH, -1);//减去一个月
                date= monthDf.format(cal.getTime());
            }else if(type.equals("6")){
                cal.setTime(yearDf.parse(date));
                date=yearDf.format(cal.getTime());
            }else if(type.equals("7")){
                Date newDate = new SimpleDateFormat("yyyy").parse(date);
                date=monthDf.format(newDate);
            }else if(type.equals("8")){
                cal.setTime(yearDf.parse(date));
                cal.add(Calendar.MONTH, -1);//减去一个月
                date= monthDf.format(cal.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 字符转Data类
     * @param date 要判断的日期
     * @param type 默认方式（0：日，1：月）
     * @return 计算后的日期
     */
    public static Date toData(String date,String type){
        Date ruturnDate = null;
        SimpleDateFormat monthDf = new SimpleDateFormat ("yyyy-MM");
        if(StringUtils.isEmpty(date)){
            SimpleDateFormat dayDf = new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat yearDf = new SimpleDateFormat ("yyyy");
            try {
                if(type.equals("0")){
                    ruturnDate = dayDf.parse(date);
                }else if(type.equals("1")){
                    ruturnDate = monthDf.parse(date);
                }
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(null == ruturnDate){
            date = monthDf.format(new Date());
            try {
                return monthDf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return ruturnDate;
    }

    public static String dataToString(Date date,String type){
        String ruturnDate = new String();
        SimpleDateFormat monthDf = new SimpleDateFormat ("yyyy-MM");
        if(null!=date){
            SimpleDateFormat dayDf = new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat yearDf = new SimpleDateFormat ("yyyy");
            try {
                if(type.equals("0")){
                    ruturnDate = dayDf.format(date);
                }else if(type.equals("1")){
                    ruturnDate = monthDf.format(date);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(null == ruturnDate){
            ruturnDate = monthDf.format(new Date());
        }
        return ruturnDate;
    }


    public static String size1(Float sum,Integer count){
        if(count==null){
            if(sum == null || sum.toString().equals("0") || sum.toString().equals("0.0")) return  "-";
            if(sum>=1||sum<=-1){
                DecimalFormat sdf = new DecimalFormat("#.0");
                sdf.setMaximumFractionDigits(1);
                sdf.setGroupingSize(0);
                sdf.setRoundingMode(RoundingMode.DOWN);
                return sdf.format(sum);
            }else{
                DecimalFormat sdf = new DecimalFormat("#.0");
                sdf.setMaximumFractionDigits(1);
                sdf.setGroupingSize(0);
                sdf.setRoundingMode(RoundingMode.DOWN);
                return sdf.format(sum);
            }
        }else{
            if(  count== null || count.toString().equals("0")){
                return  "-";
            }else{
                return count.toString();
            }
        }
    }
}
