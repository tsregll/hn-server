package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.ConsumptionElectricityFiveVo;
import com.ruoyi.business.vo.ConsumptionElectricityVo;
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
import com.ruoyi.business.mapper.BusinessSocietyConsumptionElectricityMapper;
import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;
import com.ruoyi.business.service.IBusinessSocietyConsumptionElectricityService;

/**
 * 全社会用电量情况Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@Service
public class BusinessSocietyConsumptionElectricityServiceImpl implements IBusinessSocietyConsumptionElectricityService 
{
    @Autowired
    private BusinessSocietyConsumptionElectricityMapper businessSocietyConsumptionElectricityMapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 查询全社会用电量情况
     * 
     * @param id 全社会用电量情况ID
     * @return 全社会用电量情况
     */
    @Override
    public BusinessSocietyConsumptionElectricity selectBusinessSocietyConsumptionElectricityById(Long id)
    {
        return businessSocietyConsumptionElectricityMapper.selectBusinessSocietyConsumptionElectricityById(id);
    }

    /**
     * 查询全社会用电量情况列表
     * 
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 全社会用电量情况
     */
    @Override
    public List<BusinessSocietyConsumptionElectricity> selectBusinessSocietyConsumptionElectricityList(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        List<BusinessSocietyConsumptionElectricity> selectList = businessSocietyConsumptionElectricityMapper.selectBusinessSocietyConsumptionElectricityListOrderByDateTime(businessSocietyConsumptionElectricity);
        for(BusinessSocietyConsumptionElectricity bc :selectList){
            bc.setMonthIndustry(ToolUtils.size4(bc.getMonthIndustry()));
            bc.setLastMonthIndustry(ToolUtils.size4(bc.getLastMonthIndustry()));
            bc.setYearElectricity(ToolUtils.size4(bc.getYearElectricity()));
            bc.setLastYearElectricity(ToolUtils.size4(bc.getLastYearElectricity()));
            bc.setYearContrast(ToolUtils.size4(bc.getYearContrast()));
            bc.setMonthContrast(ToolUtils.size4(bc.getMonthContrast()));
            bc.setLastMonthContrast(ToolUtils.size4(bc.getLastMonthContrast()));
        }
        return selectList;
    }

    @Override
    public List<BusinessSocietyConsumptionElectricity> selectByTimeSocietyConsumptionElectricityList(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity) {
        List<BusinessSocietyConsumptionElectricity> selectList = businessSocietyConsumptionElectricityMapper.selectByTimeSocietyConsumptionElectricityList(businessSocietyConsumptionElectricity);
        for(BusinessSocietyConsumptionElectricity bc :selectList){
            bc.setMonthIndustry(ToolUtils.size4(bc.getMonthIndustry()));
            bc.setLastMonthIndustry(ToolUtils.size4(bc.getLastMonthIndustry()));
            bc.setYearElectricity(ToolUtils.size4(bc.getYearElectricity()));
            bc.setLastYearElectricity(ToolUtils.size4(bc.getLastYearElectricity()));
            bc.setYearContrast(ToolUtils.size4(bc.getYearContrast()));
            bc.setMonthContrast(ToolUtils.size4(bc.getMonthContrast()));
            bc.setLastMonthContrast(ToolUtils.size4(bc.getLastMonthContrast()));
        }
        return selectList;
    }

    /**
     * 新增全社会用电量情况
     * 
     * @param bsce 全社会用电量情况
     * @return 结果
     */
    @Override
    public int insertBusinessSocietyConsumptionElectricity(BusinessSocietyConsumptionElectricity bsce)
    {
        //获取输入年份
        String year = bsce.getEnteringDate().substring(0,4);
        //获取当前月份
        String Monitor = bsce.getEnteringDate().substring(5,7);
        //获取去年同月
        String lastYear = (Integer.parseInt(year)-1)+"-"+Monitor;
        //获取上一个月份
        String Monitor1 =  Monitor.equals("01")?"12":Integer.parseInt(Monitor)-1+"";
        String szyf = "";
        if(Monitor1.equals("12")){
            szyf =  (Integer.parseInt(year)-1)+"-"+Monitor1;
        }else{
            szyf = year+"-"+(Monitor1.length()<2?"0"+Monitor1:Monitor1);
        }
        //定义查询对象
        BusinessSocietyConsumptionElectricity bs = new BusinessSocietyConsumptionElectricity();
        //查询本年度累计(条件本年and同类型)
        bs.setEnteringDate(year);
        bs.setIndustryType(bsce.getIndustryType());
        List<BusinessSocietyConsumptionElectricity> yearList = businessSocietyConsumptionElectricityMapper.selectBusinessSocietyConsumptionElectricityList(bs);
        //定义数据对象
        Double sum = new Double(0);
        Double lastSum = new Double(0);
        //循环遍历集合并且累加全年同类型数据
        for (BusinessSocietyConsumptionElectricity bsc:yearList) {
            sum += Double.parseDouble(bsc.getMonthIndustry());
        }
        sum+=Double.parseDouble(bsce.getMonthIndustry());
        //年累计用电量添加
        bsce.setYearElectricity(sum.toString());
        //查询去年同月（同年）
        bs.setEnteringDate(lastYear);
        List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityMapper.selectBusinessSocietyConsumptionElectricityList(bs);
        //同期用电量输入
        bsce.setLastMonthIndustry(list != null&&list.size()>0?list.get(0).getMonthIndustry():"0");
        //去年年累计用电量
        bsce.setLastYearElectricity(list != null&&list.size()>0?list.get(0).getYearElectricity():"0");
        //获取用电量
        sum = new Double(bsce.getMonthIndustry());
        //同期用电量
        lastSum = new Double(bsce.getLastMonthIndustry());
        //定义最后字段
        Double tb = new Double(0);
        //判断同期和本期用电量是否为0，如果为0则对应判断
        if(lastSum > 0 || lastSum<0){
            tb = ((((sum)/(lastSum))-1)*100);
        };
        //保存同比
        bsce .setMonthContrast(ToolUtils.size4(tb));
        //输入上个月
        bs.setEnteringDate(szyf);
        //查询上个月数据
        list = businessSocietyConsumptionElectricityMapper.selectBusinessSocietyConsumptionElectricityList(bs);
        //判断查询结果，如果不为0.00则进行计算
        tb = new Double(0);
        lastSum = new Double(list != null&&list.size()>0?list.get(0).getMonthIndustry():"0");
        if(lastSum>0 || lastSum<0){
            tb = ((((sum)/(lastSum))-1)*100);
        };
        //输入月度环比
        bsce.setLastMonthContrast(ToolUtils.size4(tb));
        //输入年同期
        Double lastYearSum = new Double(bsce.getLastYearElectricity());
        //判断年同比
        tb =new Double(0);
        Double YearSum = new Double(bsce.getYearElectricity()!=null?bsce.getYearElectricity():"0");
        if(lastYearSum>0|| lastYearSum<0){
            tb = ((((YearSum)/(lastYearSum))-1)*100);
        };
        //输入年同比
        bsce.setYearContrast(ToolUtils.size4(tb));
        //新增操作
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bsce.setCreateBy(loginUser.getUsername());
        bsce.setStatus("1");
        bsce.setCreateTime(DateUtils.getNowDate());
        return businessSocietyConsumptionElectricityMapper.insertBusinessSocietyConsumptionElectricity(bsce);
    }

    /**
     * 修改全社会用电量情况
     * 
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 结果
     */
    @Override
    public int updateBusinessSocietyConsumptionElectricity(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        businessSocietyConsumptionElectricity.setUpdateTime(DateUtils.getNowDate());
        return businessSocietyConsumptionElectricityMapper.updateBusinessSocietyConsumptionElectricity(businessSocietyConsumptionElectricity);
    }

    /**
     * 批量删除全社会用电量情况
     * 
     * @param ids 需要删除的全社会用电量情况ID
     * @return 结果
     */
    @Override
    public int deleteBusinessSocietyConsumptionElectricityByIds(Long[] ids)
    {
        return businessSocietyConsumptionElectricityMapper.deleteBusinessSocietyConsumptionElectricityByIds(ids);
    }

    /**
     * 删除全社会用电量情况信息
     *
     * @param id 全社会用电量情况ID
     * @return 结果
     */
    @Override
    public int deleteBusinessSocietyConsumptionElectricityById(Long id)
    {
        return businessSocietyConsumptionElectricityMapper.deleteBusinessSocietyConsumptionElectricityById(id);
    }

    /**
     * 查询用电量与同比用电量（传入年数or传入类型）
     * @param businessSocietyConsumptionElectricity
     * @return
     */
    @Override
    public ConsumptionElectricityVo selectFiveByType(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        if(businessSocietyConsumptionElectricity.getIndustryType()==null||businessSocietyConsumptionElectricity.getIndustryType().trim().equals("")){
            businessSocietyConsumptionElectricity.setIndustryType("0");
        }
        //定义查询日期
        String year = "";
        LocalDate ld = LocalDate.now();
        int yearInt = ld.getYear()-4;
        //定义返回对象（vo）
        ConsumptionElectricityVo returnList = new ConsumptionElectricityVo();
        String[] monthIndustry = new String[5];
        String[] lastMonthIndustry = new String[5];
        String[] years = new String[5];
        //循环年份
        for(int i = 0;i<5;i++) {
            //获得年份
            year = (yearInt + i) + "";
            //输入年份
            businessSocietyConsumptionElectricity.setEnteringDate(year);
            //通过年份和类型模糊查询当前年份所有的数据
            List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityMapper.selectFiveByType(businessSocietyConsumptionElectricity);
            Double monthIndustrySum = new Double("0");
            Double lastMonthIndustrySum = new Double("0");
            for (BusinessSocietyConsumptionElectricity obj : list){
                //累加数据值
                monthIndustrySum += (Double.parseDouble(obj.getMonthIndustry())/10000);
                lastMonthIndustrySum += (Double.parseDouble(obj.getLastMonthIndustry())/10000);
            }
            //填充到数组
            monthIndustry[i] = ToolUtils.size4(monthIndustrySum.toString());
            Double sum = new Double("0");
            //计算年同比
            if(lastMonthIndustrySum > 0 || lastMonthIndustrySum< 0)sum = ((monthIndustrySum)/(lastMonthIndustrySum));
            Double sumLasts = ((sum-1)*100);
            //添加同比到数组and添加年份到数组
            lastMonthIndustry[i] = ToolUtils.size4(sumLasts.toString());
            years[i] = year;
        }
        returnList.setTypes("累计用电量");
        returnList.setLastType("累计同比增长");
        returnList.setDatas(monthIndustry);
        returnList.setLastDatas(lastMonthIndustry);
        returnList.setYears(years);
        return returnList;
    }

    /**
     * 查询各个类型近五年数据
     * @return
     */
    @Override
    public List<ConsumptionElectricityFiveVo> selectFive() {
        //定义对象
        BusinessSocietyConsumptionElectricity bs = new BusinessSocietyConsumptionElectricity();
        String year = "";
        //获取日期和返回对象
        LocalDate ld = LocalDate.now();
        List<ConsumptionElectricityFiveVo> returnList = new ArrayList<>();
        int yearInt = ld.getYear()-4;
        //循环查询类型
        for (int count = 1;count<5;count++) {
            //定义vo对象
            ConsumptionElectricityFiveVo vo =new ConsumptionElectricityFiveVo();
            //查询类型的近五年数据组
            String[] datas = new String[5];
            bs.setIndustryType((count)+"");
            //循环年份
            for (int i = 0; i < 5; i++) {
                year = (yearInt + i) + "";
                bs.setEnteringDate(year);
                List<BusinessSocietyConsumptionElectricity> selectList = businessSocietyConsumptionElectricityMapper.selectFiveByType(bs);
                Double monthIndustry = new Double("0.00");
                //累加数据
                for (BusinessSocietyConsumptionElectricity bsc : selectList){
                    monthIndustry += bsc.getMonthIndustry()!=null ?(Double.parseDouble(bsc.getMonthIndustry())/10000):new Double("0");
                }
                datas[i] = ToolUtils.size4(monthIndustry.toString());
            }
            vo.setName(count == 1?"第一产业":count == 2?"第二产业":count == 3?"第三产业":"城乡居民");
            vo.setType("bar");
            vo.setStack("总量");
            vo.setData(datas);
            returnList.add(vo);
        }
        return returnList;
    }

    /**
     * 查询某一年份数据
     * @param businessSocietyConsumptionElectricity
     * @return
     */
    @Override
    public Map<String,Object> selectOneYear(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity) {
        //定义返回集合
        List<Map<String,Object>> returnList = new ArrayList<>();
        //判断日期是否为空为空取当前年份
        if(businessSocietyConsumptionElectricity.getEnteringDate() == null)businessSocietyConsumptionElectricity.setEnteringDate(LocalDate.now().getYear()+"");
        //判断类型是否为空，为空取全部产业
        if(businessSocietyConsumptionElectricity.getIndustryType() == null)businessSocietyConsumptionElectricity.setIndustryType("0");
        //查询数据集合
        List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityMapper.selectElectricityList(businessSocietyConsumptionElectricity);
        //定义返回的12月份数据
        String[] monthIndustry = new String[12];
        String[] monthContrast = new String[12];
        for (int i = 0;i<list.size();i++) {
            monthIndustry[i] = list.get(i).getMonthIndustry() !=null?ToolUtils.size4((Double.parseDouble(list.get(i).getMonthIndustry())/10000)+""):"0.00";
            monthContrast[i] = list.get(i).getMonthContrast()!=null?ToolUtils.size4((Double.parseDouble(list.get(i).getMonthContrast()))+""):"0.00";
        }
        Map<String,Object> monthIndustryVo = new HashMap<>();
        monthIndustryVo.put("name","月度用电量");
        monthIndustryVo.put("type","bar");
        monthIndustryVo.put("data",monthIndustry);
        returnList.add(monthIndustryVo);
        Map<String,Object> monthContrastVo = new HashMap<>();
        monthContrastVo.put("name","月度同比");
        monthContrastVo.put("type","line");
        monthContrastVo.put("yAxisIndex",1);
        monthContrastVo.put("symbol","circle");
        monthContrastVo.put("symbolSize","4");
        monthContrastVo.put("data",monthContrast);
        returnList.add(monthContrastVo);
        Map<String,Object> dateTime = new HashMap<>();
        dateTime.put("data",returnList);
        dateTime.put("dateTime",businessSocietyConsumptionElectricity.getEnteringDate());
        return dateTime;
    }

    /**
     * 查询全社会用电量表格表格
     * @param bsce 查询条件
     * @return
     */
    @Override
    public Map<String,Object> selectByTable(BusinessSocietyConsumptionElectricity bsce) {
        //获取用户输入的日期如果为空则获取上个月的日期
        String enteringDate = bsce.getEnteringDate();
        if(enteringDate == null||enteringDate.trim().equals("")){
            if(LocalDate.now().getMonthValue()>1){
                Integer monthInt = LocalDate.now().getMonthValue()-1;
                String month = (monthInt+"").length()<2?"0"+monthInt:monthInt.toString();
                enteringDate = LocalDate.now().getYear()+"-"+month;
                bsce.setEnteringDate(enteringDate);
            }else{
                String month = "12";
                enteringDate = (LocalDate.now().getYear()-1)+"-"+month;
                bsce.setEnteringDate(enteringDate);
            }
        }
        //定义用户查看表格使用的map集合（多个）
        List<Map<String,String>> returnVo = new ArrayList<>();
        Map<String,String> mapVo1 = new HashMap();
        mapVo1.put("industry_type","月度用电量");
        mapVo1.put("unit","亿千瓦时");
        Map<String,String> mapVo2 = new HashMap();
        mapVo2.put("industry_type","同期用电量");
        mapVo2.put("unit","亿千瓦时");
        Map<String,String> mapVo3 = new HashMap();
        mapVo3.put("industry_type","月度同比");
        mapVo3.put("unit","%");
        Map<String,String> mapVo4 = new HashMap();
        mapVo4.put("industry_type","月度环比");
        mapVo4.put("unit","%");
        Map<String,String> mapVo5 = new HashMap();
        mapVo5.put("industry_type","年累计用电量");
        mapVo5.put("unit","亿千瓦时");
        Map<String,String> mapVo6 = new HashMap();
        mapVo6.put("industry_type","同期用电量");
        mapVo6.put("unit","亿千瓦时");
        Map<String,String> mapVo7 = new HashMap();
        mapVo7.put("industry_type","年累计同比");
        mapVo7.put("unit","%");
        //查询数据
        List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityMapper.selectElectricityList(bsce);
        //如果有数据显示数据，没数据则全填充为0
        if(list.size()>0){
            for (BusinessSocietyConsumptionElectricity i :list){
                Double sum = new Double(0);
                i.setMonthIndustry(ToolUtils.size4(new Double(i.getMonthIndustry())/10000));
                sum = new Double(0);
                i.setLastMonthIndustry(ToolUtils.size4(new Double(i.getLastMonthIndustry())/10000));
                sum = new Double(0);
                i.setYearElectricity(ToolUtils.size4(new Double(i.getYearElectricity())/10000));
                sum = new Double(0);
                i.setLastYearElectricity(ToolUtils.size4(new Double(i.getLastYearElectricity())/10000));
                String type = i.getIndustryType();
                String stringType = type.equals("0")?"industry_all":type.equals("1")?"industry_first":type.equals("2")?"industry_second":type.equals("3")?"industry_thirdly":"industry_countryside";
                mapVo1.put(stringType,ToolUtils.size4(i.getMonthIndustry()));
                mapVo2.put(stringType,ToolUtils.size4(i.getLastMonthIndustry()));
                mapVo3.put(stringType,ToolUtils.size4(i.getMonthContrast()));
                mapVo4.put(stringType,ToolUtils.size4(i.getLastMonthContrast()));
                mapVo5.put(stringType,ToolUtils.size4(i.getYearElectricity()));
                mapVo6.put(stringType,ToolUtils.size4(i.getLastYearElectricity()));
                mapVo7.put(stringType,ToolUtils.size4(i.getYearContrast()));
            }
        }else{
            for(int i =0;i<5;i++){
                String stringType = i==0?"industry_all":i==1?"industry_first":i==2?"industry_second":i==3?"industry_thirdly":"industry_countryside";
                mapVo1.put(stringType,ToolUtils.size4("-"));
                mapVo2.put(stringType,ToolUtils.size4("-"));
                mapVo3.put(stringType,ToolUtils.size4("-"));
                mapVo4.put(stringType,ToolUtils.size4("-"));
                mapVo5.put(stringType,ToolUtils.size4("-"));
                mapVo6.put(stringType,ToolUtils.size4("-"));
                mapVo7.put(stringType,ToolUtils.size4("-"));
            }
        }
        returnVo.add(mapVo1);
        returnVo.add(mapVo2);
        returnVo.add(mapVo3);
        returnVo.add(mapVo4);
        returnVo.add(mapVo5);
        returnVo.add(mapVo6);
        returnVo.add(mapVo7);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("data",returnVo);
        returnMap.put("dateTime",enteringDate);
        return returnMap;
    }

    @Override
    public String importDatas(List<BusinessSocietyConsumptionElectricity> bsce) {
        if(StringUtils.isEmpty(bsce)||bsce.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessSocietyConsumptionElectricity bsc:bsce) {
            String industryType = bsc.getIndustryType();
            industryType = industryType.equals("0")?"全社会用电量":industryType.equals("1")?"第一产业":industryType.equals("2")?"第二产业":industryType.equals("3")?"第三产业":"城乡居民";
            try {
                String date = bsc.getEnteringDate();
                if(date.length()>7) {
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
                    date = year + "-" + (month.length() < 2 ? "0" + month : month);
                    bsc.setEnteringDate(date);
                }
                BusinessSocietyConsumptionElectricity select = new BusinessSocietyConsumptionElectricity();
                select.setEnteringDate(date);
                select.setIndustryType(bsc.getIndustryType());
                int count = this.selectBusinessSocietyConsumptionElectricityList(select).size();
                if(count>0){
                    continue;
                }

                this.insertBusinessSocietyConsumptionElectricity(bsc);
                successNum++;
                successMsg.append("<br/>" + bsc.getEnteringDate()+"的"+industryType + " 导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + bsc.getEnteringDate() + "的" + industryType + " 导入失败：";
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
