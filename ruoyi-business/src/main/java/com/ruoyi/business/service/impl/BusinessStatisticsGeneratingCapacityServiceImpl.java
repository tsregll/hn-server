package com.ruoyi.business.service.impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;
import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessStatisticsGeneratingCapacityMapper;
import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;
import com.ruoyi.business.service.IBusinessStatisticsGeneratingCapacityService;

/**
 * 统调发电量Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
@Service
public class BusinessStatisticsGeneratingCapacityServiceImpl implements IBusinessStatisticsGeneratingCapacityService 
{
    @Autowired
    private BusinessStatisticsGeneratingCapacityMapper businessStatisticsGeneratingCapacityMapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 查询统调发电量
     * 
     * @param id 统调发电量ID
     * @return 统调发电量
     */
    @Override
    public BusinessStatisticsGeneratingCapacity selectBusinessStatisticsGeneratingCapacityById(Long id)
    {
        return businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityById(id);
    }

    /**
     * 查询统调发电量列表
     * 
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 统调发电量
     */
    @Override
    public List<BusinessStatisticsGeneratingCapacity> selectBusinessStatisticsGeneratingCapacityList(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity)
    {
        List<BusinessStatisticsGeneratingCapacity> selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityListOrderByDateTime(businessStatisticsGeneratingCapacity);
        for(BusinessStatisticsGeneratingCapacity bs:selectList){
            bs.setStatisticsAll(ToolUtils.size4(bs.getStatisticsAll()));
            bs.setStatisticsLastMonth(ToolUtils.size4(bs.getStatisticsLastMonth()));
            bs.setStatisticsYear(ToolUtils.size4(bs.getStatisticsYear()));
            bs.setStatisticsLastYear(ToolUtils.size4(bs.getStatisticsLastYear()));
        }
        return selectList;
    }

    @Override
    public List<BusinessStatisticsGeneratingCapacity> selectByTimeStatisticsGeneratingCapacityList(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity) {
        List<BusinessStatisticsGeneratingCapacity> selectList = businessStatisticsGeneratingCapacityMapper.selectByTimeStatisticsGeneratingCapacityList(businessStatisticsGeneratingCapacity);
        for(BusinessStatisticsGeneratingCapacity bs:selectList){
            bs.setStatisticsAll(ToolUtils.size4(bs.getStatisticsAll()));
            bs.setStatisticsLastMonth(ToolUtils.size4(bs.getStatisticsLastMonth()));
            bs.setStatisticsYear(ToolUtils.size4(bs.getStatisticsYear()));
            bs.setStatisticsLastYear(ToolUtils.size4(bs.getStatisticsLastYear()));
        }
        return selectList;
    }

    /**
     * 新增统调发电量
     * 
     * @param bsgc 统调发电量
     * @return 结果
     */
    @Override
    public int insertBusinessStatisticsGeneratingCapacity(BusinessStatisticsGeneratingCapacity bsgc)
    {
        //基础信息录入
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bsgc.setCreateBy(loginUser.getUsername());
        bsgc.setStatus("1");
        bsgc.setCreateTime(DateUtils.getNowDate());
        //定义Double对象
        Double sum = new Double("0");
        //获取用户输入的发电量
        String statisticsAll = bsgc.getStatisticsAll();
        //获取输入年份
        String year = bsgc.getEnteringDate().substring(0,4);
        //获取输入月份
        String Monitor = bsgc.getEnteringDate().substring(5,7);
        //获取去年同月
        String lastYear = (Integer.parseInt(year)-1)+"-"+Monitor;
        //获取上个月
        String Monitor1 =  Monitor.equals("01")?"12":Integer.parseInt(Monitor)-1+"";
        String lastMonitor ="";
        if(Monitor1.equals("12")){
            lastMonitor = (Integer.parseInt(year)-1)+"-"+Monitor1;
        }else{
            lastMonitor = year+"-"+(Monitor1.length()<2?"0"+Monitor1:Monitor1);
        }
        //定义查询对象
        BusinessStatisticsGeneratingCapacity selectCon = new BusinessStatisticsGeneratingCapacity();
        selectCon.setStatisticsType(bsgc.getStatisticsType());
        //月度同期电量
        selectCon.setEnteringDate(lastYear);
        List<BusinessStatisticsGeneratingCapacity> selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(selectCon);
        bsgc.setStatisticsLastMonth(selectList.size()>0?selectList.get(0).getStatisticsAll():"0");
        //月度同比
        String statisticsLastMonth = bsgc.getStatisticsLastMonth();
        if(statisticsLastMonth!=null&&Double.parseDouble(statisticsLastMonth)>0){
            sum = (((Double.parseDouble(statisticsAll))/(Double.parseDouble(statisticsLastMonth)))-1)*100;
        }else{
            sum = new Double("0");
        }
        bsgc.setContrastMonth(ToolUtils.size4(sum));
        //月度环比
        sum = new Double("0");
        selectCon.setEnteringDate(lastMonitor);
        selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(selectCon);
        String contrastLastMonth = selectList.size()>0?selectList.get(0).getStatisticsAll():"0";
        if(contrastLastMonth!=null&&Double.parseDouble(contrastLastMonth)>0){
            sum = (((Double.parseDouble(statisticsAll))/(Double.parseDouble(contrastLastMonth)))-1)*100;
        }else{
            sum = new Double("0");
        }
        bsgc.setContrastLastMonth(ToolUtils.size4(sum));
        //年累计电量
        sum =  new Double("0");
        selectCon.setEnteringDate(year);
        selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(selectCon);
        for (BusinessStatisticsGeneratingCapacity bs:selectList){
            sum+=Double.parseDouble(bs.getStatisticsAll());
        }
        sum+=Double.parseDouble(bsgc.getStatisticsAll());
        bsgc.setStatisticsYear(sum.toString());
        //年累计同期电量
        sum = new Double("0");
        Integer monitors = Integer.parseInt(Monitor);
        selectCon.setEnteringDate(Integer.parseInt(year)-1+"");
        selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(selectCon);
        for (BusinessStatisticsGeneratingCapacity bs:selectList){
            Integer bsm = Integer.parseInt(bs.getEnteringDate().substring(5,7));
            if(bsm<=monitors&&bs.getStatisticsType().equals(bsgc.getStatisticsType())){
                sum+=Double.parseDouble(bs.getStatisticsAll());
            }
        }
        bsgc.setStatisticsLastYear(sum.toString());
        //年累计同比
        Double contrastYear = new Double("0");
        String statisticsYear = bsgc.getStatisticsYear();
        String statisticsLastYear = bsgc.getStatisticsLastYear();
        if(statisticsLastYear!=null&&Double.parseDouble(statisticsLastYear)>0){
            contrastYear = (((Double.parseDouble(statisticsYear))/(Double.parseDouble(statisticsLastYear)))-1)*100;
        }else{
            contrastYear = new Double("0");
        }
        bsgc.setContrastYear(ToolUtils.size4(contrastYear));
        //调用新增接口
        return businessStatisticsGeneratingCapacityMapper.insertBusinessStatisticsGeneratingCapacity(bsgc);
    }

    /**
     * 修改统调发电量
     * 
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 结果
     */
    @Override
    public int updateBusinessStatisticsGeneratingCapacity(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity)
    {
        businessStatisticsGeneratingCapacity.setUpdateTime(DateUtils.getNowDate());
        return businessStatisticsGeneratingCapacityMapper.updateBusinessStatisticsGeneratingCapacity(businessStatisticsGeneratingCapacity);
    }

    /**
     * 批量删除统调发电量
     * 
     * @param ids 需要删除的统调发电量ID
     * @return 结果
     */
    @Override
    public int deleteBusinessStatisticsGeneratingCapacityByIds(Long[] ids)
    {
        return businessStatisticsGeneratingCapacityMapper.deleteBusinessStatisticsGeneratingCapacityByIds(ids);
    }

    /**
     * 删除统调发电量信息
     *
     * @param id 统调发电量ID
     * @return 结果
     */
    @Override
    public int deleteBusinessStatisticsGeneratingCapacityById(Long id)
    {
        return businessStatisticsGeneratingCapacityMapper.deleteBusinessStatisticsGeneratingCapacityById(id);
    }

    /**
     * 查询近五年的统调发电量
     * @param bsgc
     * @return
     */
    @Override
    public Map<String,Object> selectByFive(BusinessStatisticsGeneratingCapacity bsgc){
        //定义相关集合对象
        Map<String,Object> returnMap = new HashMap<>();
        String[] years = new String[5];
        List<Map<String,Object>> returnList = new ArrayList<>();
        //获取五年前（包括今年）的年份
        Integer year = LocalDate.now().getYear()-4;
        //定义给图形使用的map对象
        Map<String,Object> statisticsYear = new HashMap<>();
        statisticsYear.put("name","累计发电量");
        statisticsYear.put("type","bar");
        Map<String,Object> contrastYear = new HashMap<>();
        contrastYear.put("name","累计同比增长");
        contrastYear.put("type","line");
        contrastYear.put("yAxisIndex",1);
        contrastYear.put("symbol","circle");
        contrastYear.put("symbolSize",4);
        //计算数据的对象
        String[] sums = new String[5];
        String[] lastSums = new String[5];
        //循环年份
        for (int i=0;i<5;i++){
            //获取年份并且添加到集合与查询参数
            String enteringDate  = year+i+"";
            years[i] = enteringDate;
            bsgc.setEnteringDate(enteringDate);
            List<BusinessStatisticsGeneratingCapacity> selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(bsgc);

            //查询去年的数据累计
            enteringDate  = ((year-1)+i)+"";
            bsgc.setEnteringDate(enteringDate);
            List<BusinessStatisticsGeneratingCapacity> selectLists = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(bsgc);
            Double lastSum = new Double("0");
            Double sum = new Double("0");
            //循环累加查询的结果值累计
            for(int count=0;count<selectList.size();count++){
                BusinessStatisticsGeneratingCapacity bs = selectList.get(count);
                sum += (Double.parseDouble(bs.getStatisticsAll()));
                for(int counts=0;counts<selectLists.size();counts++){
                    BusinessStatisticsGeneratingCapacity bss = selectLists.get(counts);
                    if(bs.getEnteringDate().substring(5,7).equals(bss.getEnteringDate().substring(5,7))&&bs.getStatisticsType().equals(bss.getStatisticsType())){
                        lastSum += (Double.parseDouble(bss.getStatisticsAll()));
                    }
                }
            }
            lastSum = lastSum/10000;
            sum = sum/10000;
            //添加到数据集合
            sums[i] = ToolUtils.size4(sum.toString());
            //计算年同比
            lastSum = lastSum>0?(((sum/lastSum)-1)*100):0;
            //添加到年同比数据组中
            lastSums[i] = ToolUtils.size4(lastSum.toString());
        }
        statisticsYear.put("data",sums);
        contrastYear.put("data",lastSums);
        returnList.add(statisticsYear);
        returnList.add(contrastYear);
        returnMap.put("year",years);
        returnMap.put("datas",returnList);
        return returnMap;
    }

    /**
     * 通过年份与类型查询一年的数据
     * @param bsgc
     * @return
     */
    @Override
    public Map<String,Object> selectByYearOrType(BusinessStatisticsGeneratingCapacity bsgc){
        //定义返回对象与年份数组
        Map<String,Object> returnMap = new HashMap<>();
        List<Map<String,Object>> returnList = new ArrayList<>();
        String[] month = new String[12];
        //定义前端图形显示的map
        Map<String,Object> statisticsYear = new HashMap<>();
        statisticsYear.put("name","累计发电量");
        statisticsYear.put("type","bar");
        Map<String,Object> contrastYear = new HashMap<>();
        contrastYear.put("name","累计同比增长");
        contrastYear.put("type","line");
        contrastYear.put("yAxisIndex",1);
        contrastYear.put("symbol","circle");
        contrastYear.put("symbolSize",4);
        //定义数据集合
        String[] sums = new String[12];
        String[] lastSums = new String[12];
        //判断用户输入的年份，如果用户输入的年份为空则自动获取当前年份
        String year = bsgc.getEnteringDate() == null?LocalDate.now().getYear()+"":bsgc.getEnteringDate();
        String lastYear = ""+(Integer.parseInt(year)-1);
        //循环年份进行查询（i从1开始是因为月份从1开始），数组这些自动-1计算
        for(int i = 1;i<13;i++){
            Double sum = new Double("0");
            Double lastSum = new Double("0");
            //定义年月的查询条件
            String yearMonth = year + "-"+ ((i+"").length()<2?"0"+i:i+"");
            month[i-1] = ((i+"").length()<2?"0"+i:i+"");
            //输入查询条件
            bsgc.setEnteringDate(yearMonth);
            List<BusinessStatisticsGeneratingCapacity> selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(bsgc);
            //累加查询结果
            for (int count = 0;count<selectList.size();count++){
                sum+=(Double.parseDouble(selectList.get(count).getStatisticsAll())/10000);
            }
            sums[i-1] = ToolUtils.size4(sum.toString());
            //添加去年的查询条件
            yearMonth = lastYear + "-"+ ((i+"").length()<2?"0"+i:i+"");
            bsgc.setEnteringDate(yearMonth);
            selectList = businessStatisticsGeneratingCapacityMapper.selectBusinessStatisticsGeneratingCapacityList(bsgc);
            for (int count = 0;count<selectList.size();count++){
                lastSum+=(Double.parseDouble(selectList.get(count).getStatisticsAll())/10000);
            }
            //计算同比并且添加
            lastSum = lastSum>0?(((sum/lastSum)-1)*100):0;
            lastSums[i-1] = ToolUtils.size4(lastSum.toString());
        }
        statisticsYear.put("data",sums);
        contrastYear.put("data",lastSums);
        returnList.add(statisticsYear);
        returnList.add(contrastYear);
        returnMap.put("month",month);
        returnMap.put("datas",returnList);
        returnMap.put("dateTime",year);
        return returnMap;
    }

    /**
     * 查询表格，通过年月查询
     * @param bsgc
     * @return
     */
    @Override
    public Map<String, Object> selectByMonth(BusinessStatisticsGeneratingCapacity bsgc) {
        //获取年月，如果为空自动获取当月
        String year = bsgc.getEnteringDate();
        if(year==null || year.trim().equals("")){
            if(LocalDate.now().getMonthValue()<2){
                year = (LocalDate.now().getYear()-1)+"-12";
            }else{
                Integer month = LocalDate.now().getMonthValue()-1;
                year = LocalDate.now().getYear()+"-"+(month.toString().length()<2?"0"+month:month);
            }
        }
        //定义返回map集合（物理上的）
        List<Map<String,Object>> returnList = new ArrayList<>();
        Map<String,Object>statistics_all = new HashMap<>();
        statistics_all.put("indicators","月度电量");
        statistics_all.put("unit","亿千瓦时");
        Map<String,Object>statistics_last_month = new HashMap<>();
        statistics_last_month.put("indicators","月度同期电量");
        statistics_last_month.put("unit","亿千瓦时");
        Map<String,Object>contrast_month = new HashMap<>();
        contrast_month.put("indicators","月度同比");
        contrast_month.put("unit","%");
        Map<String,Object>contrast_last_month = new HashMap<>();
        contrast_last_month.put("indicators","月度环比");
        contrast_last_month.put("unit","%");
        Map<String,Object>statistics_year = new HashMap<>();
        statistics_year.put("indicators","年累计电量");
        statistics_year.put("unit","亿千瓦时");
        Map<String,Object>statistics_last_year = new HashMap<>();
        statistics_last_year.put("indicators","年度同期电量");
        statistics_last_year.put("unit","亿千瓦时");
        Map<String,Object>contrast_year = new HashMap<>();
        contrast_year.put("indicators","年累计同比");
        contrast_year.put("unit","%");
        //填入查询条件并且查询
        bsgc.setEnteringDate(year);
        List<BusinessStatisticsGeneratingCapacity> selectlist = businessStatisticsGeneratingCapacityMapper.selectByMonth(bsgc);
        //为空则返回0数值集合，有数值则填充
        if(selectlist.size()>0){
            for (BusinessStatisticsGeneratingCapacity bs:selectlist) {
                String statisticsType = bs.getStatisticsType().equals("0")?"water":bs.getStatisticsType().equals("1")?"fire":bs.getStatisticsType().equals("2")?"wind":"light";
                Double sum = new Double(0);
                sum = new Double(bs.getStatisticsAll())/10000;
                statistics_all.put(statisticsType,ToolUtils.size4(sum.toString()));
                sum = new Double(0);
                sum = new Double(bs.getStatisticsLastMonth())/10000;
                statistics_last_month.put(statisticsType,ToolUtils.size4(sum.toString()));
                sum = new Double(0);
                sum = new Double(bs.getStatisticsYear())/10000;
                statistics_year.put(statisticsType,ToolUtils.size4(sum.toString()));
                sum = new Double(0);
                sum = new Double(bs.getStatisticsLastYear())/10000;
                statistics_last_year.put(statisticsType,ToolUtils.size4(sum.toString()));
                contrast_month.put(statisticsType,ToolUtils.size4(bs.getContrastMonth()));
                contrast_last_month.put(statisticsType,ToolUtils.size4(bs.getContrastLastMonth()));
                contrast_year.put(statisticsType,ToolUtils.size4(bs.getContrastYear()));
            }
        }else{
            for(int i = 0;i<4;i++){
                String statisticsType = i==0?"water":i==1?"fire":i==2?"wind":"light";
                statistics_all.put(statisticsType,ToolUtils.size4("0"));
                statistics_last_month.put(statisticsType,ToolUtils.size4("0"));
                statistics_year.put(statisticsType,ToolUtils.size4("0"));
                statistics_last_year.put(statisticsType,ToolUtils.size4("0"));
                contrast_month.put(statisticsType,ToolUtils.size4("0"));
                contrast_last_month.put(statisticsType,ToolUtils.size4("0"));
                contrast_year.put(statisticsType,ToolUtils.size4("0"));
            }
        }
        returnList.add(statistics_all);
        returnList.add(statistics_last_month);
        returnList.add(contrast_month);
        returnList.add(contrast_last_month);
        returnList.add(statistics_year);
        returnList.add(statistics_last_year);
        returnList.add(contrast_year);
        Map<String,Object>returnMap = new HashMap<>();
        returnMap.put("data",returnList);
        returnMap.put("dateTime",year);
        return returnMap;
    }

    @Override
    public String importDatas(List<BusinessStatisticsGeneratingCapacity> bsgc) {
        if(StringUtils.isEmpty(bsgc)||bsgc.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessStatisticsGeneratingCapacity bsg:bsgc) {
            String statisticsType = bsg.getStatisticsType();
            statisticsType = statisticsType.equals("0")?"水电":statisticsType.equals("1")?"火电":statisticsType.equals("2")?"风电":"太阳能";
            try {
                String date = bsg.getEnteringDate();
                if(date.length()>7){
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear()+"";
                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue()+"";
                    date = year+"-"+(month.length()<2?"0"+month:month);
                }
                bsg.setEnteringDate(date);


                BusinessStatisticsGeneratingCapacity select = new BusinessStatisticsGeneratingCapacity();
                select.setEnteringDate(date);
                select.setStatisticsType(bsg.getStatisticsType());
                int count = this.selectBusinessStatisticsGeneratingCapacityList(select).size();
                if(count>0){
                    continue;
                }
                this.insertBusinessStatisticsGeneratingCapacity(bsg);
                successNum++;
                successMsg.append("<br/>" + bsg.getEnteringDate()+"的"+statisticsType + " 导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + bsg.getEnteringDate() + "的 " + statisticsType + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
