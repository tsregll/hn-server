package com.ruoyi.business.service.impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;
import com.ruoyi.business.mapper.BusinessFullMonthElectricityStatisticsMapper;
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
import com.ruoyi.business.mapper.BusinessHnElectrifiedGridMapper;
import com.ruoyi.business.domain.BusinessHnElectrifiedGrid;
import com.ruoyi.business.service.IBusinessHnElectrifiedGridService;

/**
 * 湖南电网发电量后台Service业务层处理
 *
 * @author ruoyi
 * @date 2021-03-13
 */
@Service
public class BusinessHnElectrifiedGridServiceImpl implements IBusinessHnElectrifiedGridService
{
    @Autowired
    private BusinessHnElectrifiedGridMapper businessHnElectrifiedGridMapper;
    @Autowired
    private BusinessFullMonthElectricityStatisticsMapper businessFullMonthElectricityStatisticsMapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 查询湖南电网发电量后台
     *
     * @param id 湖南电网发电量后台ID
     * @return 湖南电网发电量后台
     */
    @Override
    public BusinessHnElectrifiedGrid selectBusinessHnElectrifiedGridById(Long id)
    {
        return businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridById(id);
    }

    /**
     * 查询湖南电网发电量后台列表
     *
     * @param businessHnElectrifiedGrid 湖南电网发电量后台
     * @return 湖南电网发电量后台
     */
    @Override
    public List<BusinessHnElectrifiedGrid> selectBusinessHnElectrifiedGridList(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        List<BusinessHnElectrifiedGrid> selectList = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridListOrderByDateTime(businessHnElectrifiedGrid);
        for(BusinessHnElectrifiedGrid bh:selectList){
            bh.setMonthIndustry(ToolUtils.size4(bh.getMonthIndustry()));
            bh.setLastMonthIndustry(ToolUtils.size4(bh.getLastMonthIndustry()));
            bh.setLastMonthContrast(ToolUtils.size4(bh.getLastMonthContrast()));
            bh.setMonthElectricity(ToolUtils.size4(bh.getMonthElectricity()));
            bh.setYearAllElectricity(ToolUtils.size4(bh.getYearAllElectricity()));
            bh.setLastYearAllContrast(ToolUtils.size4(bh.getLastYearAllContrast()));
            bh.setYearContrast(ToolUtils.size4(bh.getYearContrast()));
        }
        return selectList;
    }

    @Override
    public List<BusinessHnElectrifiedGrid> selectByTimeHnElectrifiedGridList(BusinessHnElectrifiedGrid businessHnElectrifiedGrid) {
        List<BusinessHnElectrifiedGrid> selectList = businessHnElectrifiedGridMapper.selectByTimeHnElectrifiedGridList(businessHnElectrifiedGrid);
        for(BusinessHnElectrifiedGrid bh:selectList){
            bh.setMonthIndustry(ToolUtils.size4(bh.getMonthIndustry()));
            bh.setLastMonthIndustry(ToolUtils.size4(bh.getLastMonthIndustry()));
            bh.setLastMonthContrast(ToolUtils.size4(bh.getLastMonthContrast()));
            bh.setMonthElectricity(ToolUtils.size4(bh.getMonthElectricity()));
            bh.setYearAllElectricity(ToolUtils.size4(bh.getYearAllElectricity()));
            bh.setLastYearAllContrast(ToolUtils.size4(bh.getLastYearAllContrast()));
            bh.setYearContrast(ToolUtils.size4(bh.getYearContrast()));
        }
        return selectList;
    }

    /**
     * 新增湖南电网发电量后台
     *
     * @param bh 湖南电网发电量后台
     * @return 结果
     */
    @Override
    public int insertBusinessHnElectrifiedGrid(BusinessHnElectrifiedGrid bh)
    {
        //基础信息录入
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bh.setCreateBy(loginUser.getUsername());
        bh.setStatus("1");
        bh.setCreateTime(DateUtils.getNowDate());

        String dateTime = bh.getEnteringDate();
        if(dateTime.equals("2021-01")){
            String is = "";
        }
        Integer year = Integer.parseInt(dateTime.substring(0,4));
        Integer month = Integer.parseInt(dateTime.substring(5,7));
        String lastYear = year-1+"";
        String lastMonth = "";
        if(month<2){
            lastMonth = lastYear+"-12";
        }else{
            Integer months = month-1;
            lastMonth = months.toString().length()< 2?year+"-0"+(months):year+"-"+(months);
        }
        BusinessHnElectrifiedGrid select = new BusinessHnElectrifiedGrid();
        select.setIndustryType(bh.getIndustryType());
        select.setEnteringDate(lastYear+"-"+(month.toString().length()<2?"0"+month:month));
        List<BusinessHnElectrifiedGrid> list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(select);
        //同期
        if(list!=null && list.size()>0){
            bh.setLastMonthIndustry(list.get(0).getMonthIndustry());
        }else{
            bh.setLastMonthIndustry("0");
        }
        //同比
        Double sum = new Double(0);
        if(Double.parseDouble(bh.getLastMonthIndustry())>0){
            sum = ((Double.parseDouble(bh.getMonthIndustry()))/(Double.parseDouble(bh.getLastMonthIndustry()))-1)*100;
        }
        bh.setLastMonthContrast(ToolUtils.size4(sum));
        //环比
        select.setEnteringDate(lastMonth);
        list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(select);
        sum = new Double(0);
        if(list!=null && list.size()>0){
            String hsum = list.get(0).getMonthIndustry();
            if(hsum!=null&&!hsum.trim().equals("")){
                if(Double.parseDouble(hsum)>0){
                    sum = ((Double.parseDouble(bh.getMonthIndustry()))/(Double.parseDouble(hsum))-1)*100;
                }
            }
        }
        bh.setMonthElectricity(ToolUtils.size4(sum));
        //年累计
        select.setEnteringDate(year+"");
        list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(select);
        Double sums = new Double(0);
        for (BusinessHnElectrifiedGrid bhe:list) {
            sums +=(new Double(bhe.getMonthIndustry()));
        }
        sums+=new Double(bh.getMonthIndustry());
        bh.setYearAllElectricity(sums+"");
        //年同比
        select.setEnteringDate(lastYear);
        list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(select);
        sums = new Double(0);
        for (BusinessHnElectrifiedGrid bhe:list) {
            Integer m = Integer.parseInt(bhe.getEnteringDate().substring(5,7));
            if(m<=month&&bhe.getIndustryType().equals(bh.getIndustryType())){
                sums+=(new Double(bhe.getMonthIndustry()));
            }
        }
        bh.setLastYearAllContrast(sums+"");
        if(sums>0){
            sum = ((Double.parseDouble(bh.getYearAllElectricity()))/(Double.parseDouble(sums+""))-1)*100;
        }
        bh.setYearContrast(ToolUtils.size4(sum));
        return businessHnElectrifiedGridMapper.insertBusinessHnElectrifiedGrid(bh);
    }

    /**
     * 修改湖南电网发电量后台
     *
     * @param businessHnElectrifiedGrid 湖南电网发电量后台
     * @return 结果
     */
    @Override
    public int updateBusinessHnElectrifiedGrid(BusinessHnElectrifiedGrid businessHnElectrifiedGrid)
    {
        businessHnElectrifiedGrid.setUpdateTime(DateUtils.getNowDate());
        return businessHnElectrifiedGridMapper.updateBusinessHnElectrifiedGrid(businessHnElectrifiedGrid);
    }

    /**
     * 批量删除湖南电网发电量后台
     *
     * @param ids 需要删除的湖南电网发电量后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessHnElectrifiedGridByIds(Long[] ids)
    {
        return businessHnElectrifiedGridMapper.deleteBusinessHnElectrifiedGridByIds(ids);
    }

    @Override
    public String importDatas(List<BusinessHnElectrifiedGrid> bsgc) {
        if(StringUtils.isEmpty(bsgc)||bsgc.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessHnElectrifiedGrid bsg:bsgc) {
            String statisticsType = bsg.getIndustryType();
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


                BusinessHnElectrifiedGrid select = new BusinessHnElectrifiedGrid();
                select.setEnteringDate(date);
                select.setIndustryType(bsg.getIndustryType());
                int count = this.selectBusinessHnElectrifiedGridList(select).size();
                if(count>0){
                    continue;
                }
                this.insertBusinessHnElectrifiedGrid(bsg);
                successNum++;
                successMsg.append("<br/>" + bsg.getEnteringDate()+"的"+statisticsType + " 导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + bsg.getEnteringDate() + "的" + statisticsType + " 导入失败：";
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

    /**
     * 删除湖南电网发电量后台信息
     *
     * @param id 湖南电网发电量后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessHnElectrifiedGridById(Long id)
    {
        return businessHnElectrifiedGridMapper.deleteBusinessHnElectrifiedGridById(id);
    }

    /**
     * 查询近五年湖南电网发电量（根据类型）
     * @param bheg
     * @return
     */
    @Override
    public Map<String, Object> selectFive(BusinessHnElectrifiedGrid bheg) {
        Map<String,Object> returnMap = new HashMap<>();
        //获取类型和近五年的年份
        Integer type = bheg.getIndustryType() == null || bheg.getIndustryType().trim().isEmpty()?null:Integer.parseInt(bheg.getIndustryType());
        Integer year = LocalDate.now().getYear();
        year = year-4;
        //定义返回对象
        String[] years = new String[5];
        String[] data1 = new String[5];
        String[] data2 = new String[5];
        List<Map<String,Object>> returnList = new ArrayList<>();
        Map<String,Object> maps = new HashMap<>();
        maps.put("name","累计发电量");
        maps.put("type","bar");
        Map<String,Object> mpas = new HashMap<>();
        mpas.put("name","累计同比增长");
        mpas.put("type","line");
        mpas.put("yAxisInde",1);
        mpas.put("symbol","circle");
        mpas.put("symbolSize",4);
        //根据用户选择的类型进行查询（1-3）or(4以上)
        if(type == null || type<4){
            //1-3类型的近五年循环查询
            for(int i = 0;i<5;i++){
                Double sum = new Double("0");
                Double tb = new Double("0");
                String stringYear = (year+i)+"";
                String lastStringYear = ((year-1)+i)+"";
                bheg.setEnteringDate(stringYear);
                if(type!=null)bheg.setIndustryType(type+"");
                List<BusinessHnElectrifiedGrid> list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(bheg);
                bheg.setEnteringDate(lastStringYear);
                List<BusinessHnElectrifiedGrid> lists = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(bheg);
                for (BusinessHnElectrifiedGrid bh:list) {
                    sum+=(new Double(bh.getMonthIndustry()));
                    String m = bh.getEnteringDate().substring(5,7);
                    for (BusinessHnElectrifiedGrid bhs:lists) {
                        String ms = bhs.getEnteringDate().substring(5,7);
                        if(m.equals(ms)&&bh.getIndustryType().equals(bhs.getIndustryType())){
                            tb+=(new Double(bhs.getMonthIndustry()));
                        }
                    }
                }
                data1[i] = ToolUtils.size4((sum/10000)+"");
                Double tbSum = new Double(0);
                if(tb.intValue()!=0){
                    tbSum = (((sum/10000)/(tb/10000))-1)*100;
                }
                data2[i] = ToolUtils.size4(tbSum.toString());
                years[i] = stringYear;
            }
        }else if(type>3){
            for(int i = 0;i<5;i++){
                BusinessFullMonthElectricityStatistics bf = new BusinessFullMonthElectricityStatistics();
                Double sum = new Double("0");
                Double tb = new Double("0");
                String stringYear = (year+i)+"";
                String lastStringYear = ((year-1)+i)+"";

                bf.setEnteringDate(stringYear);
                List<BusinessFullMonthElectricityStatistics> list = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(bf);
                bf.setEnteringDate(lastStringYear);
                List<BusinessFullMonthElectricityStatistics> lists = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(bf);
                for (BusinessFullMonthElectricityStatistics bfm:list) {
                    if(type == 4){
                        sum+=(new Double(bfm.getOutsourcingQszl())/10000);
                        sum+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                    }else if(type == 5){
                        sum+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                    }else if(type == 6){
                        sum+=(new Double(bfm.getOutsourcingQszl())/10000);
                    }else if(type == 7){
                        sum+=(new Double(bfm.getLaunchLinkLine())/10000);
                    }else if(type == 8){
                        sum+=(new Double(bfm.getOutsourcingQszl())/10000);
                        sum+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                        sum+=(new Double(bfm.getLaunchLinkLine())/10000);
                    }
                    String m = bfm.getEnteringDate().substring(5,7);
                    for (BusinessFullMonthElectricityStatistics bfms:lists) {
                        String ms = bfms.getEnteringDate().substring(5,7);
                        if(!m.equals(ms))continue;
                        if(type == 4){
                            tb+= (new Double(bfm.getOutsourcingQszl())/10000);
                            tb+= (new Double(bfm.getOutsourcingSxgzb())/10000);
                        }else if(type == 5){
                            tb+= (new Double(bfm.getOutsourcingSxgzb())/10000);
                        }else if(type == 6){
                            tb+= (new Double(bfm.getOutsourcingQszl())/10000);
                        }else if(type == 7){
                            tb+= (new Double(bfm.getLaunchLinkLine())/10000);
                        }else if(type == 8){
                            tb+= (new Double(bfm.getOutsourcingQszl())/10000);
                            tb+= (new Double(bfm.getOutsourcingSxgzb())/10000);
                            tb+= (new Double(bfm.getLaunchLinkLine())/10000);
                        }
                    }
                }
                data1[i] = ToolUtils.size4(sum.toString());
                Double tbSum = new Double(0);
                if(tb!=0){
                    tbSum = ((sum/tb)-1)*100;
                }
                data2[i] =ToolUtils.size4(tbSum.toString());
                years[i] = stringYear;
            }
        }
        maps.put("data",data1);
        mpas.put("data",data2);
        returnList.add(maps);
        returnList.add(mpas);
        returnMap.put("years",years);
        returnMap.put("datas",returnList);
        return returnMap;
    }

    /**
     * 通过类型与时间查询一年的
     * @param bheg
     * @return
     */
    @Override
    public Map<String, Object> selectOneYear(BusinessHnElectrifiedGrid bheg) {
        Map<String,Object> returnMap = new HashMap<>();
        String types = bheg.getIndustryType();
        Integer type = types != null && !types.trim().isEmpty()?Integer.parseInt(bheg.getIndustryType()):null;
        Integer year = bheg.getEnteringDate()!=null?Integer.parseInt(bheg.getEnteringDate()):LocalDate.now().getYear();
        String[] years = new String[12];
        String[] data1 = new String[12];
        String[] data2 = new String[12];
        List<Map<String,Object>> returnList = new ArrayList<>();
        Map<String,Object> maps = new HashMap<>();
        maps.put("name","月度发电量");
        maps.put("type","bar");
        Map<String,Object> mpas = new HashMap<>();
        mpas.put("name","月度同比");
        mpas.put("type","line");
        mpas.put("yAxisInde",1);
        mpas.put("symbol","circle");
        mpas.put("symbolSize",4);
        if(type == null || type<4){
            for(int i = 1;i<13;i++){
                Double sum = new Double("0");
                Double tb = new Double("0");
                String stringYear = year+"-"+((i+"").length()<2?"0"+i:i);
                String lastStringYear = (year-1)+"-"+((i+"").length()<2?"0"+i:i);
                bheg.setEnteringDate(stringYear);
                if(type != null )bheg.setIndustryType(type+"");
                List<BusinessHnElectrifiedGrid> list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(bheg);
                if(list.size()<1)continue;
                for (BusinessHnElectrifiedGrid bh:list) {
                    sum+=(new Double(bh.getMonthIndustry())/10000);
                }
                data1[i-1] = ToolUtils.size4(sum.toString());
                bheg.setEnteringDate(lastStringYear);
                list = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(bheg);
                for (BusinessHnElectrifiedGrid bh:list) {
                    tb+=(new Double(bh.getMonthIndustry())/10000);
                }
                Double tbSum = new Double(0);
                if(tb!=0){
                    tbSum = ((sum/tb)-1)*100;
                }
                    data2[i-1] =ToolUtils.size4(tbSum.toString());
                years[i-1] = stringYear;
            }
        }else if(type>3){
            for(int i = 1;i<13;i++){
                BusinessFullMonthElectricityStatistics bf = new BusinessFullMonthElectricityStatistics();
                Double sum = new Double("0");
                Double tb = new Double("0");
                String stringYear = year+"-"+((i+"").length()<2?"0"+i:i);
                String lastStringYear = (year-1)+"-"+((i+"").length()<2?"0"+i:i);

                bf.setEnteringDate(stringYear);
                List<BusinessFullMonthElectricityStatistics> list = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(bf);
                if(list.size()<1)continue;
                for (BusinessFullMonthElectricityStatistics bfm:list) {
                    if(type == 4){
                        sum+=(new Double(bfm.getOutsourcingQszl())/10000);
                        sum+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                    }else if(type == 5){
                        sum+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                    }else if(type == 6){
                        sum+=(new Double(bfm.getOutsourcingQszl())/10000);

                    }else if(type == 7){
                        sum+=(new Double(bfm.getLaunchLinkLine())/10000);
                    }else if(type == 8){
                        sum+=(new Double(bfm.getOutsourcingQszl())/10000);
                        sum+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                        sum+=(new Double(bfm.getLaunchLinkLine())/10000);
                    }
                }
                data1[i-1] = ToolUtils.size4(sum.toString());
                bf.setEnteringDate(lastStringYear);
                list = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(bf);
                for (BusinessFullMonthElectricityStatistics bfm:list) {
                    if(type == 4){
                        tb+=(new Double(bfm.getOutsourcingQszl())/10000);
                        tb+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                    }else if(type == 5){
                        tb+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                    }else if(type == 6){
                        tb+=(new Double(bfm.getOutsourcingQszl())/10000);

                    }else if(type == 7){
                        tb+=(new Double(bfm.getLaunchLinkLine())/10000);
                    }else if(type == 8){
                        tb+=(new Double(bfm.getOutsourcingQszl())/10000);
                        tb+=(new Double(bfm.getOutsourcingSxgzb())/10000);
                        tb+=(new Double(bfm.getLaunchLinkLine())/10000);
                    }
                }
                Double tbSum = new Double(0);
                if(tb.intValue()!=0){
                    tbSum =((sum/tb)-1)*100;
                }
                data2[i-1] = ToolUtils.size4(tbSum.toString());
                years[i-1] = stringYear;
            }
        }
        maps.put("data",data1);
        mpas.put("data",data2);
        returnList.add(maps);
        returnList.add(mpas);
        returnMap.put("years",years);
        returnMap.put("datas",returnList);
        returnMap.put("dateTime",year.toString());
        return returnMap;
    }

    /**
     * 根据用户输入的时间查询先关数据
     * @param bheg
     * @return
     */
    @Override
    public Map<String,Object> selectByTable(BusinessHnElectrifiedGrid bheg) {
        String enteringDate = bheg.getEnteringDate();
        if(enteringDate == null ||enteringDate.trim().equals("")){
            Integer yearNow = LocalDate.now().getYear();
            Integer monthNow = LocalDate.now().getMonthValue();
            if(monthNow<2){
                enteringDate = (yearNow-1)+"-12";
            }else{
                monthNow = monthNow-1;
                enteringDate = yearNow+"-"+(monthNow.toString().length()<2?"0"+monthNow:monthNow);
            }
        }
        Integer year = Integer.parseInt(enteringDate.substring(0,4));
        Integer month = Integer.parseInt(enteringDate.substring(5,7));
//        Integer LastYear = Integer.parseInt(enteringDate.substring(0,4));
//        if(enteringDate!=null){
//            month = Integer.parseInt(enteringDate.substring(5,7));
//        }else{
//            if(LocalDate.now().getMonthValue()>1){
//                month = LocalDate.now().getMonthValue();
//            }else{
//                LastYear =  LastYear-1;
//                month = 12;
//            }
//        }
        String dateTime = year+"-"+((month+"").length()<2?"0"+month:month);
        List<Map<String,Object>> returnList = new ArrayList<>();
        Map<String,Object> monthIndustry = new HashMap<>();
        monthIndustry.put("indicators","月度电量");
        monthIndustry.put("unit","亿千瓦时");
        Map<String,Object> lastMonthIndustry = new HashMap<>();
        lastMonthIndustry.put("indicators","月度同期电量");
        lastMonthIndustry.put("unit","亿千瓦时");
        Map<String,Object> lastMonthContrast = new HashMap<>();
        lastMonthContrast.put("indicators","月度同比");
        lastMonthContrast.put("unit","%");
        Map<String,Object> monthElectricity = new HashMap<>();
        monthElectricity.put("indicators","月度环比");
        monthElectricity.put("unit","%");
        Map<String,Object> yearAllElectricity = new HashMap<>();
        yearAllElectricity.put("indicators","年累计电量");
        yearAllElectricity.put("unit","亿千瓦时");
        Map<String,Object> lastYearAllContrast = new HashMap<>();
        lastYearAllContrast.put("indicators","年度同期电量");
        lastYearAllContrast.put("unit","亿千瓦时");
        Map<String,Object> yearContrast = new HashMap<>();
        yearContrast.put("indicators","年累计同比");
        yearContrast.put("unit","%");
        bheg.setEnteringDate(dateTime);
        List<BusinessHnElectrifiedGrid> bhList = businessHnElectrifiedGridMapper.selectBusinessHnElectrifiedGridList(bheg);
        if(bhList.size()>0){
            for (BusinessHnElectrifiedGrid bh:bhList) {
                String statisticsType = bh.getIndustryType().equals("0")?"water":bh.getIndustryType().equals("1")?"fire":bh.getIndustryType().equals("2")?"wind":"light";
                monthIndustry.put(statisticsType,ToolUtils.size4(((new Double(bh.getMonthIndustry()!=null?bh.getMonthIndustry():"0")/10000))+""));
                lastMonthIndustry.put(statisticsType,ToolUtils.size4(((new Double(bh.getLastMonthIndustry()!=null?bh.getLastMonthIndustry():"0")/10000))+""));
                lastMonthContrast.put(statisticsType,ToolUtils.size4(bh.getLastMonthContrast()));
                monthElectricity.put(statisticsType,ToolUtils.size4(bh.getMonthElectricity()));
                yearAllElectricity.put(statisticsType,ToolUtils.size4(((new Double(bh.getYearAllElectricity()!=null?bh.getYearAllElectricity():"0")/10000))+""));
                lastYearAllContrast.put(statisticsType,ToolUtils.size4(((new Double(bh.getLastYearAllContrast()!=null?bh.getLastYearAllContrast():"0")/10000))+""));
                yearContrast.put(statisticsType,ToolUtils.size4(bh.getYearContrast()));
            }
        }else{
            for (int i = 0;i<4;i++){
                String statisticsType = i ==0 ?"water":i == 1?"fire":i == 2?"wind":"light";
                monthIndustry.put(statisticsType,ToolUtils.size4("-"));
                lastMonthIndustry.put(statisticsType,ToolUtils.size4("-"));
                lastMonthContrast.put(statisticsType,ToolUtils.size4("-"));
                monthElectricity.put(statisticsType,ToolUtils.size4("-"));
                yearAllElectricity.put(statisticsType,ToolUtils.size4("-"));
                lastYearAllContrast.put(statisticsType,ToolUtils.size4("-"));
                yearContrast.put(statisticsType,ToolUtils.size4("-"));
            }
        }
        BusinessFullMonthElectricityStatistics select = new BusinessFullMonthElectricityStatistics();
        select.setEnteringDate(dateTime);
        List<BusinessFullMonthElectricityStatistics> bfList = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(select);
        //当前查询月份的
        Double qszl = new Double(0);
        Double sxgzb = new Double(0);
        Double link = new Double(0);
        Double wgd = new Double(0);
        Double jwgd = new Double(0);
        for (BusinessFullMonthElectricityStatistics bf:bfList) {
            qszl+=(new Double(bf.getOutsourcingQszl())/10000);
            sxgzb+=(new Double(bf.getOutsourcingSxgzb())/10000);
            link+=(new Double(bf.getLaunchLinkLine())/10000);
        }
        wgd+=(qszl)+(sxgzb);
        jwgd+=(wgd)-(link);
        monthIndustry.put("qszl",ToolUtils.size4(qszl.toString()));
        monthIndustry.put("sxgzb",ToolUtils.size4(sxgzb.toString()));
        monthIndustry.put("link",ToolUtils.size4(link.toString()));
        monthIndustry.put("wgd",ToolUtils.size4(wgd.toString()));
        monthIndustry.put("jwgd",ToolUtils.size4(jwgd.toString()));
        //当前年份
        bfList = new ArrayList<>();
        for(int i = 1;i<=month;i++){
            dateTime = year+"-"+((i+"").length()<2?"0"+i:i);
            select.setEnteringDate(dateTime);
            bfList.addAll(businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(select));
        }
        Double yearQszl = new Double(0);
        Double yearSxgzb = new Double(0);
        Double yearLink = new Double(0);
        Double yearwgd = new Double(0);
        Double yearjwgd = new Double(0);
        for (BusinessFullMonthElectricityStatistics bf:bfList) {
            yearQszl+=(new Double(bf.getOutsourcingQszl())/10000);
            yearSxgzb+=(new Double(bf.getOutsourcingSxgzb())/10000);
            yearLink+=(new Double(bf.getLaunchLinkLine())/10000);
        }
        yearwgd+=(yearQszl)+(yearSxgzb);
        yearjwgd+=(yearwgd)-(yearLink);
        yearAllElectricity.put("qszl",ToolUtils.size4(yearQszl.toString()));
        yearAllElectricity.put("sxgzb",ToolUtils.size4(yearSxgzb.toString()));
        yearAllElectricity.put("link",ToolUtils.size4(yearLink.toString()));
        yearAllElectricity.put("wgd",ToolUtils.size4(yearwgd.toString()));
        yearAllElectricity.put("jwgd",ToolUtils.size4(yearjwgd.toString()));
        //去年同期
        dateTime = (year-1)+"-"+((month+"").length()<2?"0"+month:month);
        select.setEnteringDate(dateTime);
        bfList = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(select);
        Double lastYearQszl = new Double(0);
        Double lastYearSxgzb = new Double(0);
        Double lastYearLink = new Double(0);
        Double lastYearwgd = new Double(0);
        Double lastYearjwgd = new Double(0);
        for (BusinessFullMonthElectricityStatistics bf:bfList) {
            lastYearQszl+=(new Double(bf.getOutsourcingQszl())/10000);
            lastYearSxgzb+=(new Double(bf.getOutsourcingSxgzb())/10000);
            lastYearLink+=(new Double(bf.getLaunchLinkLine())/10000);
        }
        lastYearwgd+=(lastYearQszl)+(lastYearSxgzb);
        lastYearjwgd+=(lastYearwgd)-(lastYearLink);
        lastMonthIndustry.put("qszl",ToolUtils.size4(lastYearQszl.toString()));
        lastMonthIndustry.put("sxgzb",ToolUtils.size4(lastYearSxgzb.toString()));
        lastMonthIndustry.put("link",ToolUtils.size4(lastYearLink.toString()));
        lastMonthIndustry.put("wgd",ToolUtils.size4(lastYearwgd.toString()));
        lastMonthIndustry.put("jwgd",ToolUtils.size4(lastYearjwgd.toString()));
        //月度同比
        Double fCqszl = Double.parseDouble(lastYearQszl+"")>0?(Double.parseDouble(qszl+"")/Double.parseDouble(lastYearQszl+"")-1)*100:new Double("0");
        Double fSxgzb = Double.parseDouble(lastYearSxgzb+"")>0?(Double.parseDouble(sxgzb+"")/Double.parseDouble(lastYearSxgzb+"")-1)*100:new Double("0");
        Double fLink = Double.parseDouble(lastYearLink+"")>0?(Double.parseDouble(link+"")/Double.parseDouble(lastYearLink+"")-1)*100:new Double("0");
        Double fwgd = Double.parseDouble(lastYearwgd+"")>0?(Double.parseDouble(wgd+"")/Double.parseDouble(lastYearwgd+"")-1)*100:new Double("0");
        Double fjwgd = Double.parseDouble(lastYearjwgd+"")>0?(Double.parseDouble(jwgd+"")/Double.parseDouble(lastYearjwgd+"")-1)*100:new Double("0");
        lastMonthContrast.put("qszl",ToolUtils.size4(fCqszl.toString()));
        lastMonthContrast.put("sxgzb",ToolUtils.size4(fSxgzb.toString()));
        lastMonthContrast.put("link",ToolUtils.size4(fLink.toString()));
        lastMonthContrast.put("wgd",ToolUtils.size4(fwgd.toString()));
        lastMonthContrast.put("jwgd",ToolUtils.size4(fjwgd.toString()));
        //月度环比
        if(month<2){
            dateTime = (year-1)+"-12";
        }else{
            Integer months = month-1;
            dateTime = (year)+"-"+(months.toString().length()<2?"0"+months:months);
        }
        select.setEnteringDate(dateTime);
        bfList = businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(select);
        Double monthQszl = new Double(0);
        Double monthSxgzb = new Double(0);
        Double monthLink = new Double(0);
        Double monthwgd = new Double(0);
        Double monthjwgd = new Double(0);
        List<String> dateTimes = new ArrayList<>();
        for (BusinessFullMonthElectricityStatistics bf:bfList) {
            monthQszl+=(new Double(bf.getOutsourcingQszl())/10000);
            monthSxgzb+=(new Double(bf.getOutsourcingSxgzb())/10000);
            monthLink+=(new Double(bf.getLaunchLinkLine())/10000);
            dateTimes.add(bf.getEnteringDate());
        }
        monthwgd+=(monthQszl)+(monthSxgzb);
        monthjwgd+=(monthwgd)-(monthLink);
        Double fmonthQszl = Double.parseDouble(monthQszl+"")>0?(Double.parseDouble(qszl+"")/Double.parseDouble(monthQszl+"")-1)*100:new Double("0");
        Double fmonthSxgzb = Double.parseDouble(monthSxgzb+"")>0?(Double.parseDouble(sxgzb+"")/Double.parseDouble(monthSxgzb+"")-1)*100:new Double("0");
        Double fmonthLink = Double.parseDouble(monthLink+"")>0?(Double.parseDouble(link+"")/Double.parseDouble(monthLink+"")-1)*100:new Double("0");
        Double fmonthwgd = Double.parseDouble(monthwgd+"")>0?(Double.parseDouble(wgd+"")/Double.parseDouble(monthwgd+"")-1)*100:new Double("0");
        Double fmonthjwgd = Double.parseDouble(monthjwgd+"")>0?(Double.parseDouble(jwgd+"")/Double.parseDouble(monthjwgd+"")-1)*100:new Double("0");
        monthElectricity.put("qszl",ToolUtils.size4(fmonthQszl.toString()));
        monthElectricity.put("sxgzb",ToolUtils.size4(fmonthSxgzb.toString()));
        monthElectricity.put("link",ToolUtils.size4(fmonthLink.toString()));
        monthElectricity.put("wgd",ToolUtils.size4(fmonthwgd.toString()));
        monthElectricity.put("jwgd",ToolUtils.size4(fmonthjwgd.toString()));
        //年度同期
        Double yearAllQszl = new Double(0);
        Double yearAllSxgzb = new Double(0);
        Double yearAllLink = new Double(0);
        Double yearAllwgd = new Double(0);
        Double yearAlljwgd = new Double(0);
        for(int i = 1;i<=month;i++){
            dateTime = (year-1)+"-"+((i+"").length()<2?"0"+i:i);
            select.setEnteringDate(dateTime);
            bfList.addAll(businessFullMonthElectricityStatisticsMapper.selectBusinessFullMonthElectricityStatisticsList(select));
        }
        for (BusinessFullMonthElectricityStatistics bf:bfList) {
            yearAllQszl+=(new Double(bf.getOutsourcingQszl())/10000);
            yearAllSxgzb+=(new Double(bf.getOutsourcingSxgzb())/10000);
            yearAllLink+=(new Double(bf.getLaunchLinkLine())/10000);
        }
        yearAllwgd+=(yearAllQszl)+(yearAllSxgzb);
        yearAlljwgd+=(yearAllwgd)-(yearAllLink);
        lastYearAllContrast.put("qszl",ToolUtils.size4(yearAllQszl.toString()));
        lastYearAllContrast.put("sxgzb",ToolUtils.size4(yearAllSxgzb.toString()));
        lastYearAllContrast.put("link",ToolUtils.size4(yearAllLink.toString()));
        lastYearAllContrast.put("wgd",ToolUtils.size4(yearAllwgd.toString()));
        lastYearAllContrast.put("jwgd",ToolUtils.size4(yearAlljwgd.toString()));
        Double fyearAllQszl = Double.parseDouble(yearAllQszl+"")>0?(Double.parseDouble(yearQszl+"")/Double.parseDouble(yearAllQszl+"")-1)*100:new Double("0");
        Double fyearAllSxgzb = Double.parseDouble(yearAllSxgzb+"")>0?(Double.parseDouble(yearSxgzb+"")/Double.parseDouble(yearAllSxgzb+"")-1)*100:new Double("0");
        Double fyearAllLink = Double.parseDouble(yearAllLink+"")>0?(Double.parseDouble(yearLink+"")/Double.parseDouble(yearAllLink+"")-1)*100:new Double("0");
        Double fyearAllwgd = Double.parseDouble(yearAllwgd+"")>0?(Double.parseDouble(yearwgd+"")/Double.parseDouble(yearAllwgd+"")-1)*100:new Double("0");
        Double fyearAlljwgd = Double.parseDouble(yearAlljwgd+"")>0?(Double.parseDouble(yearjwgd+"")/Double.parseDouble(yearAlljwgd+"")-1)*100:new Double("0");
        yearContrast.put("qszl",ToolUtils.size4(fyearAllQszl.toString()));
        yearContrast.put("sxgzb",ToolUtils.size4(fyearAllSxgzb.toString()));
        yearContrast.put("link",ToolUtils.size4(fyearAllLink.toString()));
        yearContrast.put("wgd",ToolUtils.size4(fyearAllwgd.toString()));
        yearContrast.put("jwgd",ToolUtils.size4(fyearAlljwgd.toString()));
        returnList.add(monthIndustry );
        returnList.add(lastMonthIndustry );
        returnList.add(lastMonthContrast );
        returnList.add(monthElectricity );
        returnList.add(yearAllElectricity );
        returnList.add(lastYearAllContrast );
        returnList.add(yearContrast );
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("dateTime",enteringDate);
        returnMap.put("data",returnList);
        return returnMap;
    }

}
