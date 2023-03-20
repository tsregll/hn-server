package com.ruoyi.business.service.impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.annotation.Excel;
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
import com.ruoyi.business.mapper.BusinessFullMonthElectricityStatisticsMapper;
import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;
import com.ruoyi.business.service.IBusinessFullMonthElectricityStatisticsService;

/**
 * 全月日电量统计Service业务层处理
 * 
 * @author yrb
 * @date 2021-03-13
 */
@Service
public class BusinessFullMonthElectricityStatisticsServiceImpl implements IBusinessFullMonthElectricityStatisticsService 
{
    @Autowired
    private BusinessFullMonthElectricityStatisticsMapper businessFullMonthElectricityStatisticsMapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 查询全月日电量统计
     * 
     * @param id 全月日电量统计ID
     * @return 全月日电量统计
     */
    @Override
    public BusinessFullMonthElectricityStatistics selectBusinessFullMonthElectricityStatisticsById(Long id)
    {
        return businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsById(id);
    }

    @Override
    public List<BusinessFullMonthElectricityStatistics> selectByTimeFullMonthElectricityStatisticsList(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics) {
        List<BusinessFullMonthElectricityStatistics> selectList = businessFullMonthElectricityStatisticsMapper.selectByTimeFullMonthElectricityStatisticsList(businessFullMonthElectricityStatistics);
        for(BusinessFullMonthElectricityStatistics bf:selectList){
            bf.setConsumptionElectricityAll(ToolUtils.size4(bf.getConsumptionElectricityAll()));
            bf.setGeneratingElectricityAll(ToolUtils.size4(bf.getGeneratingElectricityAll()));
            bf.setBurthenMax(ToolUtils.size4(bf.getBurthenMax()));
            bf.setBurthenMin(ToolUtils.size4(bf.getBurthenMin()));
            bf.setBurthenAverage(ToolUtils.size4(bf.getBurthenAverage()));
            bf.setBurthenFire(ToolUtils.size4(bf.getBurthenFire()));
            bf.setBurthenCoal(ToolUtils.size4(bf.getBurthenCoal()));
            bf.setBurthenWater(ToolUtils.size4(bf.getBurthenWater()));
            bf.setBurthenWind(ToolUtils.size4(bf.getBurthenWind()));
            bf.setBurthenBiomass(ToolUtils.size4(bf.getBurthenBiomass()));
            bf.setBurthenLight(ToolUtils.size4(bf.getBurthenLight()));
            bf.setOutsourcingQszl(ToolUtils.size4(bf.getOutsourcingQszl()));
            bf.setOutsourcingSxgzb(ToolUtils.size4(bf.getOutsourcingSxgzb()));
            bf.setLaunchLinkLine(ToolUtils.size4(bf.getLaunchLinkLine()));
        }
        return selectList;
    }

    /**
     * 查询全月日电量统计列表
     * 
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 全月日电量统计
     */
    @Override
    public List<BusinessFullMonthElectricityStatistics> selectBusinessFullMonthElectricityStatisticsList(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        List<BusinessFullMonthElectricityStatistics> selectList = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsListOrderByDateTime(businessFullMonthElectricityStatistics);
        for(BusinessFullMonthElectricityStatistics bf:selectList){
            bf.setConsumptionElectricityAll(ToolUtils.size4(bf.getConsumptionElectricityAll()));
            bf.setGeneratingElectricityAll(ToolUtils.size4(bf.getGeneratingElectricityAll()));
            bf.setBurthenMax(ToolUtils.size4(bf.getBurthenMax()));
            bf.setBurthenMin(ToolUtils.size4(bf.getBurthenMin()));
            bf.setBurthenAverage(ToolUtils.size4(bf.getBurthenAverage()));
            bf.setBurthenFire(ToolUtils.size4(bf.getBurthenFire()));
            bf.setBurthenCoal(ToolUtils.size4(bf.getBurthenCoal()));
            bf.setBurthenWater(ToolUtils.size4(bf.getBurthenWater()));
            bf.setBurthenWind(ToolUtils.size4(bf.getBurthenWind()));
            bf.setBurthenBiomass(ToolUtils.size4(bf.getBurthenBiomass()));
            bf.setBurthenLight(ToolUtils.size4(bf.getBurthenLight()));
            bf.setOutsourcingQszl(ToolUtils.size4(bf.getOutsourcingQszl()));
            bf.setOutsourcingSxgzb(ToolUtils.size4(bf.getOutsourcingSxgzb()));
            bf.setLaunchLinkLine(ToolUtils.size4(bf.getLaunchLinkLine()));
        }
        return selectList;
    }

    /**
     * 新增全月日电量统计
     * 
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 结果
     */
    @Override
    public int insertBusinessFullMonthElectricityStatistics(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessFullMonthElectricityStatistics.setCreateBy(loginUser.getUsername());
        businessFullMonthElectricityStatistics.setStatus("1");
        businessFullMonthElectricityStatistics.setCreateTime(DateUtils.getNowDate());
        return businessFullMonthElectricityStatisticsMapper.insertBusinessFullMonthElectricityStatistics(businessFullMonthElectricityStatistics);
    }

    /**
     * 修改全月日电量统计
     * 
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 结果
     */
    @Override
    public int updateBusinessFullMonthElectricityStatistics(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics)
    {
        businessFullMonthElectricityStatistics.setUpdateTime(DateUtils.getNowDate());
        return businessFullMonthElectricityStatisticsMapper.updateBusinessFullMonthElectricityStatistics(businessFullMonthElectricityStatistics);
    }

    /**
     * 批量删除全月日电量统计
     * 
     * @param ids 需要删除的全月日电量统计ID
     * @return 结果
     */
    @Override
    public int deleteBusinessFullMonthElectricityStatisticsByIds(Long[] ids)
    {
        return businessFullMonthElectricityStatisticsMapper.deleteBusinessFullMonthElectricityStatisticsByIds(ids);
    }

    /**
     * 删除全月日电量统计信息
     * 
     * @param id 全月日电量统计ID
     * @return 结果
     */
    @Override
    public int deleteBusinessFullMonthElectricityStatisticsById(Long id)
    {
        return businessFullMonthElectricityStatisticsMapper.deleteBusinessFullMonthElectricityStatisticsById(id);
    }

    @Override
    public String importDatas(List<BusinessFullMonthElectricityStatistics> list) {
        if(StringUtils.isEmpty(list)||list.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessFullMonthElectricityStatistics bfmes:list) {
            try {
                String date = bfmes.getEnteringDate();
                if(date.length()>7) {
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
                    String day = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getDayOfMonth() + "";
                    date = year + "-" + (month.length() < 2 ? "0" + month : month) + "-" + (day.length() < 2 ? "0" + day : day);
                }
                bfmes.setEnteringDate(date);

                BusinessFullMonthElectricityStatistics select = new BusinessFullMonthElectricityStatistics();
                select.setEnteringDate(date);
                int count = this.selectBusinessFullMonthElectricityStatisticsList(select).size();
                if(count>0){
                    continue;
                }


                this.insertBusinessFullMonthElectricityStatistics(bfmes);
                successNum++;
                successMsg.append("<br/>第" + successNum+"行数据导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>第" + successNum+"行数据导入失败：";
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

    @Override
    public Map<String, Object> selectByMonth(BusinessFullMonthElectricityStatistics bf) {
        List<Map<String,Object>> returnList = new ArrayList<>();
        String selectMonth = bf.getEnteringDate();
        if(selectMonth == null || selectMonth.isEmpty()){
            String year = LocalDate.now().getYear()+"-";
            String month = LocalDate.now().getMonthValue()<10?"0"+LocalDate.now().getMonthValue():LocalDate.now().getMonthValue()+"";
            selectMonth = year+month;
        }
        Map<String,Object> mapConsumptionElectricityAll = zMap("统调用电量",false);
        Map<String,Object> mapGeneratingElectricityAll = zMap("统调发电量",true);
        Map<String,Object> mapBurthenMax = zMap("统调最大日负荷",false);
        Map<String,Object> mapBurthenMin = zMap("统调最小日负荷",false);
        Map<String,Object> mapBurthenAverage = zMap("统调平均日负荷",true);
        Map<String,Object> mapBurthenFire = zMap("统调火电",false);
        Map<String,Object> mapBurthenCoal = zMap("统调公用火电",true);
        Map<String,Object> mapBurthenWater = zMap("统调水电",true);
        Map<String,Object> mapBurthenWind = zMap("风电",true);
        Map<String,Object> mapBurthenBiomass = zMap("生物质",false);
        Map<String,Object> mapBurthenLight = zMap("光伏",true);
        Map<String,Object> mapOutsourcingQszl = zMap("外购（祁韶直流）",true);
        Map<String,Object> mapOutsourcingSxgzb = zMap("外购（三峡、葛洲坝）",false);
        Map<String,Object> mapLaunchLinkLine = zMap("送出（联络线北送）",false);
        List<String> listConsumptionElectricityAll = new ArrayList<>();
        List<String> listGeneratingElectricityAll = new ArrayList<>();
        List<String> listBurthenMax = new ArrayList<>();
        List<String> listBurthenMin = new ArrayList<>();
        List<String> listBurthenAverage = new ArrayList<>();
        List<String> listBurthenFire = new ArrayList<>();
        List<String> listBurthenCoal = new ArrayList<>();
        List<String> listBurthenWater = new ArrayList<>();
        List<String> listBurthenWind = new ArrayList<>();
        List<String> listBurthenBiomass = new ArrayList<>();
        List<String> listBurthenLight = new ArrayList<>();
        List<String> listOutsourcingQszl = new ArrayList<>();
        List<String> listOutsourcingSxgzb = new ArrayList<>();
        List<String> listLaunchLinkLine = new ArrayList<>();
        LocalDate ld = LocalDate.parse((selectMonth+"-01"));
        for (int i = 0; i < ld.lengthOfMonth(); i++) {
            String day = selectMonth+"-"+(i<10?"0"+i:i+"");
            bf.setEnteringDate(day);
            List<BusinessFullMonthElectricityStatistics> selectList = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(bf);
            if(selectList!=null &&selectList.size()>0){
                listConsumptionElectricityAll.add(ToolUtils.size4(selectList.get(0).getConsumptionElectricityAll()));
                listGeneratingElectricityAll.add(ToolUtils.size4(selectList.get(0).getGeneratingElectricityAll()));
                listBurthenMax.add(ToolUtils.size4(selectList.get(0).getBurthenMax()));
                listBurthenMin.add(ToolUtils.size4(selectList.get(0).getBurthenMin()));
                listBurthenAverage.add(ToolUtils.size4(selectList.get(0).getBurthenAverage()));
                listBurthenFire.add(ToolUtils.size4(selectList.get(0).getBurthenFire()));
                listBurthenCoal.add(ToolUtils.size4(selectList.get(0).getBurthenCoal()));
                listBurthenWater.add(ToolUtils.size4(selectList.get(0).getBurthenWater()));
                listBurthenWind.add(ToolUtils.size4(selectList.get(0).getBurthenWind()));
                listBurthenBiomass.add(ToolUtils.size4(selectList.get(0).getBurthenBiomass()));
                listBurthenLight.add(ToolUtils.size4(selectList.get(0).getBurthenLight()));
                listOutsourcingQszl.add(ToolUtils.size4(selectList.get(0).getOutsourcingQszl()));
                listOutsourcingSxgzb.add(ToolUtils.size4(selectList.get(0).getOutsourcingSxgzb()));
                listLaunchLinkLine.add(ToolUtils.size4(selectList.get(0).getLaunchLinkLine()));
            }
        }
        //-------------内层数据结构
        Map<String,Object> markPoint = new HashMap<>();
        List<Map<String,String>> list1 = new ArrayList<>();
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("type","max");
        stringMap.put("name","最大值");
        stringMap.put("type","min");
        stringMap.put("name","最小值");
        list1.add(stringMap);
        list1.add(stringMap);
        markPoint.put("data",list1);
        //------------最外层
        mapConsumptionElectricityAll.put("markPoint",markPoint);
        mapGeneratingElectricityAll.put("markPoint",markPoint);
        mapBurthenMax.put("markPoint",markPoint);
        mapBurthenMin.put("markPoint",markPoint);
        mapBurthenAverage.put("markPoint",markPoint);
        mapBurthenFire.put("markPoint",markPoint);
        mapBurthenCoal.put("markPoint",markPoint);
        mapBurthenWater.put("markPoint",markPoint);
        mapBurthenWind.put("markPoint",markPoint);
        mapBurthenBiomass.put("markPoint",markPoint);
        mapBurthenLight.put("markPoint",markPoint);
        mapOutsourcingQszl.put("markPoint",markPoint);
        mapOutsourcingSxgzb.put("markPoint",markPoint);
        mapLaunchLinkLine.put("markPoint",markPoint);
        mapConsumptionElectricityAll.put("data",listConsumptionElectricityAll);
        mapGeneratingElectricityAll.put("data",listGeneratingElectricityAll);
        mapBurthenMax.put("data",listBurthenMax);
        mapBurthenMin.put("data",listBurthenMin);
        mapBurthenAverage.put("data",listBurthenAverage);
        mapBurthenFire.put("data",listBurthenFire);
        mapBurthenCoal.put("data",listBurthenCoal);
        mapBurthenWater.put("data",listBurthenWater);
        mapBurthenWind.put("data",listBurthenWind);
        mapBurthenBiomass.put("data",listBurthenBiomass);
        mapBurthenLight.put("data",listBurthenLight);
        mapOutsourcingQszl.put("data",listOutsourcingQszl);
        mapOutsourcingSxgzb.put("data",listOutsourcingSxgzb);
        mapLaunchLinkLine.put("data",listLaunchLinkLine);

        returnList.add(mapGeneratingElectricityAll);
        returnList.add(mapBurthenAverage);
        returnList.add(mapBurthenCoal);
        returnList.add(mapBurthenWater);
        returnList.add(mapBurthenWind);
        returnList.add(mapBurthenLight);
        returnList.add(mapOutsourcingQszl);

        returnList.add(mapConsumptionElectricityAll);
        returnList.add(mapBurthenMax);
        returnList.add(mapBurthenMin);
        returnList.add(mapBurthenFire);
        returnList.add(mapBurthenBiomass);
        returnList.add(mapOutsourcingSxgzb);
        returnList.add(mapLaunchLinkLine);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("dateTime",selectMonth);
        returnMap.put("data",returnList);
        return returnMap;
    }
    private Map<String,Object> zMap(String name,boolean hide){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("hide",hide);
        map.put("type","line");
        map.put("symbolSize",0);
        map.put("symbol","circle");
        return map;
    }



    @Override
    public Map<String, Object> selectByTable(BusinessFullMonthElectricityStatistics bf) {
        List<Map<String, Object>> returnList = new ArrayList<>();
        String selectMonth = bf.getEnteringDate();
        if (selectMonth == null || selectMonth.isEmpty()) {
            String year = LocalDate.now().getYear() + "-";
            String month = LocalDate.now().getMonthValue() < 10 ? "0" + LocalDate.now().getMonthValue() : LocalDate.now().getMonthValue() + "";
            selectMonth = year + month;
        }
        Map<String, Object> consumptionElectricityAll = new HashMap<>();
        consumptionElectricityAll.put("name", "统调用电量");
        consumptionElectricityAll.put("type", "亿千瓦时");
        Map<String, Object> generatingElectricityAll = new HashMap<>();
        generatingElectricityAll.put("name", "统调发电量");
        generatingElectricityAll.put("type", "亿千瓦时");
        Map<String, Object> burthenMax = new HashMap<>();
        burthenMax.put("name", "统调最大日负荷");
        burthenMax.put("type", "亿千瓦时");
        Map<String, Object> burthenMin = new HashMap<>();
        burthenMin.put("name", "统调最小日负荷");
        burthenMin.put("type", "亿千瓦时");
        Map<String, Object> burthenAverage = new HashMap<>();
        burthenAverage.put("name", "统调平均日负荷");
        burthenAverage.put("type", "亿千瓦时");
        Map<String, Object> burthenFire = new HashMap<>();
        burthenFire.put("name", "统调火电");
        burthenFire.put("type", "亿千瓦时");
        Map<String, Object> burthenCoal = new HashMap<>();
        burthenCoal.put("name", "统调20万千瓦以上煤机");
        burthenCoal.put("type", "亿千瓦时");
        Map<String, Object> burthenWater = new HashMap<>();
        burthenWater.put("name", "统调水电");
        burthenWater.put("type", "亿千瓦时");
        Map<String, Object> burthenWind = new HashMap<>();
        burthenWind.put("name", "风电");
        burthenWind.put("type", "亿千瓦时");
        Map<String, Object> burthenBiomass = new HashMap<>();
        burthenBiomass.put("name", "生物质");
        burthenBiomass.put("type", "亿千瓦时");
        Map<String, Object> burthenLight = new HashMap<>();
        burthenLight.put("name", "光伏");
        burthenLight.put("type", "亿千瓦时");
        Map<String, Object> outsourcingQszl = new HashMap<>();
        outsourcingQszl.put("name", "外购(祁韶直流)");
        outsourcingQszl.put("type", "亿千瓦时");
        Map<String, Object> outsourcingSxgzb = new HashMap<>();
        outsourcingSxgzb.put("name", "外购(三峡、葛洲坝)");
        outsourcingSxgzb.put("type", "亿千瓦时");
        Map<String, Object> launchLinkLine = new HashMap<>();
        launchLinkLine.put("name", "送出（联络线北送）");
        launchLinkLine.put("type", "亿千瓦时");
        bf.setEnteringDate(selectMonth);
        Double doubleConsumptionElectricityAll = new Double(0);
        Double doubleGeneratingElectricityAll = new Double(0);
        Double doubleBurthenMax = new Double(0);
        Double doubleBurthenMin = new Double(0);
        Double doubleBurthenAverage = new Double(0);
        Double doubleBurthenFire = new Double(0);
        Double doubleBurthenCoal = new Double(0);
        Double doubleBurthenWater = new Double(0);
        Double doubleBurthenWind = new Double(0);
        Double doubleBurthenBiomass = new Double(0);
        Double doubleBurthenLight = new Double(0);
        Double doubleOutsourcingQszl = new Double(0);
        Double doubleOutsourcingSxgzb = new Double(0);
        Double doubleLaunchLinkLine = new Double(0);
        List<BusinessFullMonthElectricityStatistics> selectList = businessFullMonthElectricityStatisticsMapper.selectByMonth(bf);
        LocalDate ld = LocalDate.parse((selectMonth+"-01"));
        for (int i = 0; i < ld.lengthOfMonth(); i++) {
            BusinessFullMonthElectricityStatistics bfm = new BusinessFullMonthElectricityStatistics();
            if(i<selectList.size())bfm = selectList.get(i);

            if(bfm.getConsumptionElectricityAll()!=null)doubleConsumptionElectricityAll += (new Double(bfm.getConsumptionElectricityAll())/10000);
            if(bfm.getGeneratingElectricityAll()!=null)doubleGeneratingElectricityAll += (new Double(bfm.getGeneratingElectricityAll())/10000);
            if(bfm.getBurthenMax()!=null)doubleBurthenMax += (new Double(bfm.getBurthenMax())/10000);
            if(bfm.getBurthenMin()!=null)doubleBurthenMin += (new Double(bfm.getBurthenMin())/10000);
            if(bfm.getBurthenAverage()!=null)doubleBurthenAverage += (new Double(bfm.getBurthenAverage())/10000);
            if(bfm.getBurthenFire()!=null)doubleBurthenFire += (new Double(bfm.getBurthenFire())/10000);
            if(bfm.getBurthenCoal()!=null)doubleBurthenCoal += (new Double(bfm.getBurthenCoal())/10000);
            if(bfm.getBurthenWater()!=null)doubleBurthenWater += (new Double(bfm.getBurthenWater())/10000);
            if(bfm.getBurthenWind()!=null)doubleBurthenWind += (new Double(bfm.getBurthenWind())/10000);
            if(bfm.getBurthenBiomass()!=null)doubleBurthenBiomass += (new Double(bfm.getBurthenBiomass())/10000);
            if(bfm.getBurthenLight()!=null)doubleBurthenLight += (new Double(bfm.getBurthenLight())/10000);
            if(bfm.getOutsourcingQszl()!=null)doubleOutsourcingQszl += (new Double(bfm.getOutsourcingQszl())/10000);
            if(bfm.getOutsourcingSxgzb()!=null)doubleOutsourcingSxgzb += (new Double(bfm.getOutsourcingSxgzb())/10000);
            if(bfm.getLaunchLinkLine()!=null)doubleLaunchLinkLine += (new Double(bfm.getLaunchLinkLine())/10000);



            String row = "row_" + i;
            consumptionElectricityAll.put(row, ToolUtils.size4((new Double(bfm.getConsumptionElectricityAll()!=null?bfm.getConsumptionElectricityAll() :"0")/10000)+""));
            generatingElectricityAll.put(row, ToolUtils.size4((new Double(bfm.getGeneratingElectricityAll()!=null?bfm.getGeneratingElectricityAll()  :"0")/10000)+""));
            burthenMax.put(row, ToolUtils.size4((new Double(bfm.getBurthenMax()!=null?bfm.getBurthenMax():"0")/10000)+""));
            burthenMin.put(row, ToolUtils.size4((new Double(bfm.getBurthenMin()!=null?bfm.getBurthenMin():"0")/10000)+""));
            burthenAverage.put(row, ToolUtils.size4((new Double(bfm.getBurthenAverage()!=null?bfm.getBurthenAverage():"0")/10000)+""));
            burthenFire.put(row, ToolUtils.size4((new Double(bfm.getBurthenFire()!=null?bfm.getBurthenFire():"0")/10000)+""));
            burthenCoal.put(row, ToolUtils.size4((new Double(bfm.getBurthenCoal()!=null?bfm.getBurthenCoal():"0")/10000)+""));
            burthenWater.put(row, ToolUtils.size4((new Double(bfm.getBurthenWater()!=null?bfm.getBurthenWater():"0")/10000)+""));
            burthenWind.put(row, ToolUtils.size4((new Double(bfm.getBurthenWind()!=null?bfm.getBurthenWind():"0")/10000)+""));
            burthenBiomass.put(row, ToolUtils.size4((new Double(bfm.getBurthenBiomass()!=null?bfm.getBurthenBiomass():"0")/10000)+""));
            burthenLight.put(row, ToolUtils.size4((new Double(bfm.getBurthenLight()!=null?bfm.getBurthenLight():"0")/10000)+""));
            outsourcingQszl.put(row, ToolUtils.size4((new Double(bfm.getOutsourcingQszl()!=null?bfm.getOutsourcingQszl():"0")/10000)+""));
            outsourcingSxgzb.put(row, ToolUtils.size4((new Double(bfm.getOutsourcingSxgzb()!=null?bfm.getOutsourcingSxgzb():"0")/10000)+""));
            launchLinkLine.put(row, ToolUtils.size4((new Double(bfm.getLaunchLinkLine()!=null?bfm.getLaunchLinkLine():"0")/10000)+""));
        }
        consumptionElectricityAll.put   ("sumAll", ToolUtils.size4(doubleConsumptionElectricityAll.toString()));
        generatingElectricityAll.put    ("sumAll", ToolUtils.size4(doubleGeneratingElectricityAll.toString()));
        burthenMax.put                  ("sumAll", ToolUtils.size4(doubleBurthenMax.toString()));
        burthenMin.put                  ("sumAll", ToolUtils.size4(doubleBurthenMin.toString()));
        burthenAverage.put              ("sumAll", ToolUtils.size4(doubleBurthenAverage.toString()));
        burthenFire.put                 ("sumAll", ToolUtils.size4(doubleBurthenFire.toString()));
        burthenCoal.put                 ("sumAll", ToolUtils.size4(doubleBurthenCoal.toString()));
        burthenWater.put                ("sumAll", ToolUtils.size4(doubleBurthenWater.toString()));
        burthenWind.put                 ("sumAll", ToolUtils.size4(doubleBurthenWind.toString()));
        burthenBiomass.put              ("sumAll", ToolUtils.size4(doubleBurthenBiomass.toString()));
        burthenLight.put                ("sumAll", ToolUtils.size4(doubleBurthenLight.toString()));
        outsourcingQszl.put             ("sumAll", ToolUtils.size4(doubleOutsourcingQszl.toString()));
        outsourcingSxgzb.put            ("sumAll", ToolUtils.size4(doubleOutsourcingSxgzb.toString()));
        launchLinkLine.put              ("sumAll", ToolUtils.size4(doubleLaunchLinkLine.toString()));
        returnList.add(consumptionElectricityAll);
        returnList.add(generatingElectricityAll);
        returnList.add(burthenMax);
        returnList.add(burthenMin);
        returnList.add(burthenAverage);
        returnList.add(burthenFire);
        returnList.add(burthenCoal);
        returnList.add(burthenWater);
        returnList.add(burthenWind);
        returnList.add(burthenBiomass);
        returnList.add(burthenLight);
        returnList.add(outsourcingQszl);
        returnList.add(outsourcingSxgzb);
        returnList.add(launchLinkLine);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("dateTime", selectMonth);
        returnMap.put("data", returnList);
        return returnMap;
    }
}
