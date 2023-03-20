package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.NewElectricTradeVo;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessElectricTradeMapper;
import com.ruoyi.business.domain.BusinessElectricTrade;
import com.ruoyi.business.service.IBusinessElectricTradeService;

import javax.annotation.Resource;

/**
 * 电量及电价市场交易Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-27
 */
@Service
public class BusinessElectricTradeServiceImpl implements IBusinessElectricTradeService 
{
    @Resource
    private BusinessElectricTradeMapper businessElectricTradeMapper;
    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 查询电量及电价市场交易
     * 
     * @param id 电量及电价市场交易ID
     * @return 电量及电价市场交易
     */
    @Override
    public BusinessElectricTrade selectBusinessElectricTradeById(Long id)
    {
        return businessElectricTradeMapper.selectBusinessElectricTradeById(id);
    }

    /**
     * 查询电量及电价市场交易列表
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 电量及电价市场交易
     */
    @Override
    public List<BusinessElectricTrade> selectBusinessElectricTradeList(BusinessElectricTrade businessElectricTrade)
    {
        return selectByTimeElectricTradeList(businessElectricTrade);
    }
    /**
     * 按月查询电量及电价市场交易列表
     *
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    @Override
    public List<BusinessElectricTrade> selectByTimeElectricTradeList(BusinessElectricTrade businessElectricTrade) {
        List<BusinessElectricTrade> selectList = new ArrayList<>();
        if(null!=businessElectricTrade.getBeginTime()||null!=businessElectricTrade.getEndTime()){
//            Date date = businessElectricTrade.getElectricTradeTime();
//            String dateTime= ToolUtils.dataToString(date,"1");
            String endTime=null!=businessElectricTrade.getEndTime()?ToolUtils.changeTime2(businessElectricTrade.getEndTime(),"0"):"";
            businessElectricTrade.setEndTime(endTime);
            selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(businessElectricTrade.getBeginTime(),businessElectricTrade.getEndTime(),businessElectricTrade);
        }else {
            selectList = businessElectricTradeMapper.selectBusinessElectricTradeList(businessElectricTrade);
        }
        return selectList;
    }
    private String SelectLabel(String ac,String type){
        String name = "市场交易表";
        String place =
                ac.equals("0")?"华能":ac.equals("1")?"大唐":ac.equals("2")?"华电": ac.equals("3")?"国能投":ac.equals("4")?"国电投":ac.equals("5")?"长安":
                        ac.equals("6")?"华润":ac.equals("7")?"统调火电":ac.equals("8")?"其他电源": ac.equals("9")?"全省电源":ac.equals("10")?"湘祁水电":ac.equals("11")?"苏宝顶风电":
                                ac.equals("12")?"桂东风电":ac.equals("13")?"连坪风电":ac.equals("14")?"梅桥风电": ac.equals("15")?"北湖风电":ac.equals("16")?"回龙圩风电":ac.equals("17")?"清能公司":"";
        SkBbLabel byName = skBbLabelService.find(name,type,place);
        return  byName.getLabel ();
    }

    /**
     * 新增电量及电价市场交易
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    @Override
    public int insertBusinessElectricTrade(BusinessElectricTrade businessElectricTrade,Map<String,Double> sjMap)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricTrade.setCreateTime(DateUtils.getNowDate());
        businessElectricTrade.setElectricTradeConsumption(ToolUtils.size2(businessElectricTrade.getElectricTradeConsumption()));
        businessElectricTrade.setElectricTradeMonovalent(ToolUtils.size2(businessElectricTrade.getElectricTradeMonovalent()));
        int returnResult = businessElectricTradeMapper.insertBusinessElectricTrade(businessElectricTrade);
        BusinessElectricTrade select = new BusinessElectricTrade();
        //中台月装机容量
//        if(null!=sjMap){
//            BusinessElectricTrade bpc = new BusinessElectricTrade();
//            bpc.setCreateBy(loginUser.getUsername());
//            bpc.setStatus("1");
//            bpc.setCreateTime(DateUtils.getNowDate());
//            //获取用户选择的场站下标
//            String ac = businessElectricTrade.getElectricTradeUnit();
//            //通过下标选择对应的数据
//            String electricity  = SelectLabel(ac,"月装机容量");
//            bpc.setElectricTradeConsumption(sjMap.get(electricity).toString());
//            businessElectricTradeMapper.insertBusinessElectricTrade(bpc);
//        }
        BusinessElectricTrade td = new BusinessElectricTrade();
        BusinessElectricTrade qn = new BusinessElectricTrade();
        Date date = businessElectricTrade.getElectricTradeTime();
        select.setElectricTradeTime(date);
//        String dateTime= ToolUtils.dataToString(date,"1");
//        String dateTime1=ToolUtils.changeTime2(dateTime,"0");
        List<BusinessElectricTrade> selectList = selectByTimeElectricTradeList(select);
        BusinessElectricTrade tdSelect = new BusinessElectricTrade();
        BusinessElectricTrade qnSelect = new BusinessElectricTrade();
        tdSelect.setElectricTradeUnit("7");
        tdSelect.setElectricTradeTime(date);
        qnSelect.setElectricTradeUnit("17");
        qnSelect.setElectricTradeTime(date);
//        List<BusinessElectricTrade> tdSelectList = businessElectricTradeMapper.selectByTimeElectricTradeList(dateTime,dateTime1,tdSelect);
        List<BusinessElectricTrade> tdSelectList = selectByTimeElectricTradeList(tdSelect);
        List<BusinessElectricTrade> qnSelectList = selectByTimeElectricTradeList(qnSelect);
        if(tdSelectList.size()>0){
            td = sum7(selectList,"7");
            td.setId(tdSelectList.get(0).getId());
            updateBusinessElectricTrade(td);
        }else {
            td = sum7(tdSelectList,"7");
            td.setStatus("1");
            td.setElectricTradeUnit("7");
            td.setElectricTradeTime(date);
            td.setCreateBy(loginUser.getUsername());
            td.setCreateTime(DateUtils.getNowDate());
            businessElectricTradeMapper.insertBusinessElectricTrade(td);
        }
        if(qnSelectList.size()>0) {
            qn = sum7(selectList,"17");
            qn.setId(qnSelectList.get(0).getId());
            updateBusinessElectricTrade(qn);
        }else {
            qn = sum7(selectList,"17");
            qn.setStatus("1");
            qn.setElectricTradeUnit("17");
            qn.setElectricTradeTime(date);
            qn.setCreateBy(loginUser.getUsername());
            qn.setCreateTime(DateUtils.getNowDate());
            businessElectricTradeMapper.insertBusinessElectricTrade(qn);
        }
        return returnResult;
    }

    private BusinessElectricTrade sum7(List<BusinessElectricTrade> selectList,String electricTradeUnit) {
        BusinessElectricTrade insBET = new BusinessElectricTrade();
        Double tdConsumptionCount = new Double(0);
        Double tdCount = new Double(0);
        Double qingnengConsumptionCount = new Double(0);
        Double qingnengCount = new Double(0);
        for(BusinessElectricTrade bet : selectList){
            String ac = bet.getElectricTradeUnit();
            String electricTradeConsumption = bet.getElectricTradeConsumption();
            String electricTradeMonovalent = bet.getElectricTradeMonovalent();
            //年累计电价：【1月（电量*电价）+2月（电量*电价）+3月（电量*电价）+4月（电量*电价）】/【1月电量+2月电量+3月电量+4月电量】
            if(Integer.parseInt(ac)<7){
                tdConsumptionCount += Double.parseDouble(electricTradeConsumption);
                tdCount +=  Double.parseDouble(electricTradeMonovalent)*Double.parseDouble(electricTradeConsumption);
            }
            if(Integer.parseInt(ac)>9 && Integer.parseInt(ac)<17){
                qingnengConsumptionCount += Double.parseDouble(electricTradeConsumption);
                qingnengCount += Double.parseDouble(electricTradeMonovalent)*Double.parseDouble(electricTradeConsumption);
            }
        }
        Double tdMonovalentCount = new Double(0);
        Double qnMonovalentCount = new Double(0);
        if(0!=tdConsumptionCount){
            tdMonovalentCount=tdCount/tdConsumptionCount;//统调电价
        }
        if(0!=qingnengConsumptionCount){
            qnMonovalentCount=qingnengCount/qingnengConsumptionCount;//清能电价
        }
        if("7".equals(electricTradeUnit)){
            insBET.setElectricTradeConsumption(ToolUtils.size2(tdConsumptionCount));
            insBET.setElectricTradeMonovalent(ToolUtils.size2(tdMonovalentCount));
        }
        if("17".equals(electricTradeUnit)){
            insBET.setElectricTradeConsumption(ToolUtils.size2(qingnengConsumptionCount));
            insBET.setElectricTradeMonovalent(ToolUtils.size2(qnMonovalentCount));
        }
        return insBET;
    }

    /**
     * 修改电量及电价市场交易
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    @Override
    public int updateBusinessElectricTrade(BusinessElectricTrade businessElectricTrade)
    {
        businessElectricTrade.setUpdateTime(DateUtils.getNowDate());
        return businessElectricTradeMapper.updateBusinessElectricTrade(businessElectricTrade);
    }

    /**
     * 批量删除电量及电价市场交易
     * 
     * @param ids 需要删除的电量及电价市场交易ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricTradeByIds(Long[] ids)
    {
        return businessElectricTradeMapper.deleteBusinessElectricTradeByIds(ids);
    }

    /**
     * 删除电量及电价市场交易信息
     * 
     * @param id 电量及电价市场交易ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricTradeById(Long id)
    {
        return businessElectricTradeMapper.deleteBusinessElectricTradeById(id);
    }
    /**
     * 查询全省月度市场交易情况（柱状图）
     *
     * @param electricTradeTime
     * @return 结果
     */

    @Override
    public Map<String, Object> selectByMonthTradePillar(String electricTradeTime) {
        Map<String, Object> returnMap = new HashMap<>();
        BusinessElectricTrade select = new BusinessElectricTrade();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        String nextMonth = ToolUtils.changeTime2(electricTradeTime,"0");
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(electricTradeTime,nextMonth,select);
        List<Integer> categoryTradeCount = new ArrayList<>();
        List<String>  categoryList = new ArrayList<>();
        List<String> electricTradeConsumptionList = new ArrayList<>();
        List<String> electricTradeMonovalentList = new ArrayList<>();
        for(BusinessElectricTrade bet : selectList){
            String ac = bet.getElectricTradeUnit();
            if(Integer.parseInt(ac)>=7 && Integer.parseInt(ac)<=9){
                categoryTradeCount.add(Integer.parseInt(ac));
                String group = ac.equals("9")?"全省电源":ac.equals("7")?"统调火电":ac.equals("8")?"其他电源":"";
                String electricTradeConsumption = bet.getElectricTradeConsumption();
                String electricTradeMonovalent = bet.getElectricTradeMonovalent();
                categoryList.add(group);
                electricTradeConsumptionList.add(ToolUtils.size2(electricTradeConsumption));
                electricTradeMonovalentList.add(ToolUtils.size2(electricTradeMonovalent));
            }
        }
        for(Integer i =9;i>6;i--){
            Boolean bl = new Boolean(true);
            String group = i==9?"全省电源":i==7?"统调火电":i==8?"其他电源":"";
            for (Integer count : categoryTradeCount) {
                if(i==count){
                    bl = false;
                }
            }
            if(bl){
                electricTradeConsumptionList.add(ToolUtils.size2("0.00"));
                electricTradeMonovalentList.add(ToolUtils.size2("0.00"));
                categoryList.add(group);
            }
        }
        returnMap.put("consumption","交易电量（兆瓦时）");
        returnMap.put("monovalent","交易电价（元/兆瓦时）");
        returnMap.put("electricTradeConsumptionList",electricTradeConsumptionList);
        returnMap.put("electricTradeMonovalentList",electricTradeMonovalentList);
        returnMap.put("dateTime",electricTradeTime);//月
        returnMap.put("categoryList",categoryList);//类别
        return returnMap;
    }

    @Override
    public List<BusinessElectricTrade> selectByMonthTradeTable(String electricTradeTime) {
        List<BusinessElectricTrade> returnList = new ArrayList<>();
        BusinessElectricTrade select = new BusinessElectricTrade();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        //查询当月的数据
        String nextMonth = ToolUtils.changeTime2(electricTradeTime,"0");
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(electricTradeTime,nextMonth,select);
        for(BusinessElectricTrade bet : selectList){
            String ac = bet.getElectricTradeUnit();
            if(Integer.parseInt(ac)>=7 && Integer.parseInt(ac)<=9){
                Integer i = Integer.parseInt(bet.getElectricTradeUnit());
                String group = i==9?"全省电源":i==7?"统调火电":i==8?"其他电源":"";
                bet.setElectricTradeUnit(group);
                if(StringUtils.isEmpty(bet.getElectricTradeConsumption())){
                    bet.setElectricTradeConsumption("0.00");
                }
                if(StringUtils.isEmpty(bet.getElectricTradeMonovalent())){
                    bet.setElectricTradeMonovalent("0.00");
                }
                bet.setElectricTradeConsumption(ToolUtils.size2(bet.getElectricTradeConsumption()));//电量
                bet.setElectricTradeMonovalent(ToolUtils.size2(bet.getElectricTradeMonovalent()));//电价
                returnList.add(bet);
            }
        }
        if(returnList.size()==1){
            String ac=returnList.get(0).getElectricTradeUnit();
            if("9".equals(ac)){
                BusinessElectricTrade bet1=new BusinessElectricTrade();
                BusinessElectricTrade bet2=new BusinessElectricTrade();
                bet1.setElectricTradeUnit("统调火电");
                bet1.setElectricTradeConsumption("0.00");
                bet1.setElectricTradeMonovalent("0.00");
                bet2.setElectricTradeUnit("其他电源");
                bet2.setElectricTradeConsumption("0.00");
                bet2.setElectricTradeMonovalent("0.00");
                returnList.add(bet1);
                returnList.add(bet2);
            }else if("7".equals(ac)){
                BusinessElectricTrade bet1=new BusinessElectricTrade();
                BusinessElectricTrade bet2=new BusinessElectricTrade();
                bet1.setElectricTradeUnit("全省电源");
                bet1.setElectricTradeConsumption("0.00");
                bet1.setElectricTradeMonovalent("0.00");
                bet2.setElectricTradeUnit("其他电源");
                bet2.setElectricTradeConsumption("0.00");
                bet2.setElectricTradeMonovalent("0.00");
                returnList.add(0,bet1);
                returnList.add(bet2);
            }else {
                BusinessElectricTrade bet1=new BusinessElectricTrade();
                BusinessElectricTrade bet2=new BusinessElectricTrade();
                bet1.setElectricTradeUnit("全省电源");
                bet1.setElectricTradeConsumption("0.00");
                bet1.setElectricTradeMonovalent("0.00");
                bet2.setElectricTradeUnit("统调火电");
                bet2.setElectricTradeConsumption("0.00");
                bet2.setElectricTradeMonovalent("0.00");
                returnList.add(0,bet1);
                returnList.add(1,bet2);
            }
        }
        if(returnList.size()==2){
            String ac0=returnList.get(0).getElectricTradeUnit();
            String ac1=returnList.get(1).getElectricTradeUnit();
            if(("9".equals(ac0)||"9".equals(ac1)) && ("7".equals(ac0)||"7".equals(ac1))){
                BusinessElectricTrade bet=new BusinessElectricTrade();
                bet.setElectricTradeUnit("其他电源");
                bet.setElectricTradeConsumption("0.00");
                bet.setElectricTradeMonovalent("0.00");
                returnList.add(bet);
            }else if(("9".equals(ac0)||"9".equals(ac1)) && ("8".equals(ac0)||"8".equals(ac1))){
                BusinessElectricTrade bet=new BusinessElectricTrade();
                bet.setElectricTradeUnit("统调火电");
                bet.setElectricTradeConsumption("0.00");
                bet.setElectricTradeMonovalent("0.00");
                returnList.add(1,bet);
            }else {
                BusinessElectricTrade bet=new BusinessElectricTrade();
                bet.setElectricTradeUnit("全省电源");
                bet.setElectricTradeConsumption("0.00");
                bet.setElectricTradeMonovalent("0.00");
                returnList.add(0,bet);
            }
        }
        return returnList;
    }
    /**
     * 查询全省年度市场交易情况（柱状图）
     *
     * @param electricTradeTime
     * @return 结果
     */

    @Override
    public Map<String, Object> selectByYearTradePillar(String electricTradeTime) {
        Map<String, Object> returnMap = new HashMap<>();
        BusinessElectricTrade select = new BusinessElectricTrade();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        String currentMonth = electricTradeTime;
        String nextMonth = ToolUtils.changeTime2(currentMonth,"0");
        String currentYear = ToolUtils.changeTime2(currentMonth, "1");
        String january = ToolUtils.changeTime2(currentYear,"2");//先获取年份后默认得到1月份
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,select);
        Double[] consumptionYearCount = new Double[18];//各集团电量数组
        Double[] temp = new Double[18];
        Double[] monovalentYearCount = new Double[18];//各集团电价数组
        List<String> yearConsumptionList = new ArrayList<>();
        List<String> yearMonovalentList = new ArrayList<>();
        List<String> groupList = new ArrayList<>();
        if(selectList.size()>0){
            for (int i = 0; i < 18; i++) {
                consumptionYearCount[i]=new Double(0);
                temp[i]=new Double(0);
                monovalentYearCount[i]=new Double(0);
            }
            for(BusinessElectricTrade bet : selectList){
                String ac = bet.getElectricTradeUnit();
                String electricTradeConsumption = bet.getElectricTradeConsumption();
                String electricTradeMonovalent = bet.getElectricTradeMonovalent();
                //如果集团为统调或清能则再另外外计算
                String group = ac.equals("9")?"全省电源":ac.equals("7")?"统调火电":ac.equals("8")?"其他电源":"";
                //各集团年电量计算
                consumptionYearCount[Integer.parseInt(ac)] += Double.parseDouble(electricTradeConsumption);
                if(!(Integer.parseInt(ac)==7 ||Integer.parseInt(ac)==17)){
                    //各集团月度电量*电价相加
                    temp[Integer.parseInt(ac)] += Double.parseDouble(electricTradeMonovalent)*Double.parseDouble(electricTradeConsumption);
                }
            }
            for (int i = 0; i <=6; i++) {
                if(0!=consumptionYearCount[i]){
                    monovalentYearCount[i] = temp[i]/consumptionYearCount[i];
                }else {
                    monovalentYearCount[i]= new Double(0);
                }
                //统调 全年累计电量*电价
                temp[7] += monovalentYearCount[i]*consumptionYearCount[i];
            }
            if(0!=consumptionYearCount[7]){
                monovalentYearCount[7] = temp[7]/consumptionYearCount[7];
            }else {
                monovalentYearCount[7]= new Double(0);
            }
            for (int i = 8; i <=16; i++) {
                if(0!=consumptionYearCount[i]){
                    monovalentYearCount[i] = temp[i]/consumptionYearCount[i];
                }else {
                    monovalentYearCount[i]= new Double(0);
                }
                //清能 全年累计电量*电价
                if(i>=10 && i<=16){
                    temp[17] += monovalentYearCount[i]*consumptionYearCount[i];
                }
            }
            if(0!=consumptionYearCount[17]){
                monovalentYearCount[17] = temp[17]/consumptionYearCount[17];
            }else {
                monovalentYearCount[17]= new Double(0);
            }
        }
        groupList.add("全省电源");
        groupList.add("统调火电");
        groupList.add("其他电源");
        yearConsumptionList.add(selectList.size()>0?ToolUtils.size2(consumptionYearCount[9]):ToolUtils.size2("0.00"));
        yearConsumptionList.add(selectList.size()>0?ToolUtils.size2(consumptionYearCount[7]):ToolUtils.size2("0.00"));
        yearConsumptionList.add(selectList.size()>0?ToolUtils.size2(consumptionYearCount[8]):ToolUtils.size2("0.00"));
        yearMonovalentList.add(selectList.size()>0?ToolUtils.size2(monovalentYearCount[9]):ToolUtils.size2("0.00"));
        yearMonovalentList.add(selectList.size()>0?ToolUtils.size2(monovalentYearCount[7]):ToolUtils.size2("0.00"));
        yearMonovalentList.add(selectList.size()>0?ToolUtils.size2(monovalentYearCount[8]):ToolUtils.size2("0.00"));
        returnMap.put("group",groupList);
        returnMap.put("yearconsumption",yearConsumptionList);//年度电量统计
        returnMap.put("yearmonovalent",yearMonovalentList);//年度电价统计
        returnMap.put("dateTime",electricTradeTime);//月
        return returnMap;
    }

    @Override
    public List<BusinessElectricTrade> selectByYearTradeTable(String electricTradeTime) {
        List<BusinessElectricTrade> returnList = new ArrayList<>();
        BusinessElectricTrade select = new BusinessElectricTrade();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        String currentMonth = electricTradeTime;
        String nextMonth = ToolUtils.changeTime2(currentMonth,"0");
        String january = ToolUtils.changeTime2(ToolUtils.changeTime2(currentMonth,"1"),"2");//先获取年份后默认得到1月份
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,select);
        Double[] consumptionYearCount = new Double[18];//各集团电量数组
        Double[] temp = new Double[18];
        Double[] monovalentYearCount = new Double[18];//各集团电价数组
        if(selectList.size()>0){
            for (int i = 0; i < 18; i++) {
                consumptionYearCount[i]=new Double(0);
                temp[i]=new Double(0);
                monovalentYearCount[i]=new Double(0);
            }
            for(BusinessElectricTrade bet : selectList){
                String ac = bet.getElectricTradeUnit();
                String electricTradeConsumption = bet.getElectricTradeConsumption();
                String electricTradeMonovalent = bet.getElectricTradeMonovalent();
                //如果集团为统调或清能则再另外外计算
                String group = ac.equals("9")?"全省电源":ac.equals("7")?"统调火电":ac.equals("8")?"其他电源":"";
                //各集团年电量计算
                consumptionYearCount[Integer.parseInt(ac)] += Double.parseDouble(electricTradeConsumption);
                if(!(Integer.parseInt(ac)==7 ||Integer.parseInt(ac)==17)){
                    //各集团月度电量*电价相加
                    temp[Integer.parseInt(ac)] += Double.parseDouble(electricTradeMonovalent)*Double.parseDouble(electricTradeConsumption);
                }
            }
            for (int i = 0; i <=6; i++) {
                if(0!=consumptionYearCount[i]){
                    monovalentYearCount[i] = temp[i]/consumptionYearCount[i];
                }else {
                    monovalentYearCount[i]= new Double(0);
                }
                //统调 全年累计电量*电价
                temp[7] += monovalentYearCount[i]*consumptionYearCount[i];
            }
            if(0!=consumptionYearCount[7]){
                monovalentYearCount[7] = temp[7]/consumptionYearCount[7];
            }else {
                monovalentYearCount[7]= new Double(0);
            }
            for (int i = 8; i <=16; i++) {
                if(0!=consumptionYearCount[i]){
                    monovalentYearCount[i] = temp[i]/consumptionYearCount[i];
                }else {
                    monovalentYearCount[i]= new Double(0);
                }
                //清能 全年累计电量*电价
                if(i>=10 && i<=16){
                    temp[17] += monovalentYearCount[i]*consumptionYearCount[i];
                }
            }
            if(0!=consumptionYearCount[17]){
                monovalentYearCount[17] = temp[17]/consumptionYearCount[17];
            }else {
                monovalentYearCount[17]= new Double(0);
            }
            BusinessElectricTrade bet1 = new BusinessElectricTrade();
            BusinessElectricTrade bet2 = new BusinessElectricTrade();
            BusinessElectricTrade bet3 = new BusinessElectricTrade();
            //按全省-统调-其他String group = i==9?"全省电源":i==7?"统调火电":i==8?"其他电源":"";
            bet1.setElectricTradeUnit("全省电源");
            bet1.setElectricTradeConsumption(selectList.size()>0?ToolUtils.size2(consumptionYearCount[9]):ToolUtils.size2("0.00"));//电量
            bet1.setElectricTradeMonovalent(selectList.size()>0?ToolUtils.size2(monovalentYearCount[9]):ToolUtils.size2("0.00"));//电价
            returnList.add(bet1);
            bet2.setElectricTradeUnit("统调火电");
            bet2.setElectricTradeConsumption(selectList.size()>0?ToolUtils.size2(consumptionYearCount[7]):ToolUtils.size2("0.00"));//电量
            bet2.setElectricTradeMonovalent(selectList.size()>0?ToolUtils.size2(monovalentYearCount[7]):ToolUtils.size2("0.00"));//电价
            returnList.add(bet2);
            bet3.setElectricTradeUnit("其他电源");
            bet3.setElectricTradeConsumption(selectList.size()>0?ToolUtils.size2(consumptionYearCount[8]):ToolUtils.size2("0.00"));//电量
            bet3.setElectricTradeMonovalent(selectList.size()>0?ToolUtils.size2(monovalentYearCount[8]):ToolUtils.size2("0.00"));//电价
            returnList.add(bet3);
        }
        return returnList;
    }

    /**
     * 查询市场交易明细
     *
     * @param year 年份
     * @return 结果
     */
    public List<Map<String,Object>> selectGroupByMonthTradeTest(String year) {//electricTradeTime为yyyy
        year = year==null||year.trim().equals("")? LocalDate.now().getYear()+"":year;
        List<Map<String,Object>> returnList = new ArrayList<>();
        for(Integer group = 0; group <18; group++){
            Map<String,Object> groupMap = new HashMap<>();
            String name =
                    group ==0?"华能":
                    group ==1?"大唐":
                    group ==2?"华电":
                    group ==3?"国能投":
                    group ==4?"国电投":
                    group ==5?"长安":
                    group ==6?"华润":
                    group ==7?"统调火电":
                    group ==8?"其他电源":
                    group ==9?"全省":
                    group ==10?"湘祁水电":
                    group ==11?"苏宝顶风电":
                    group ==12?"桂东风电":
                    group ==13?"连坪风电":
                    group ==14?"梅桥风电":
                    group ==15?"北湖风电":
                    group ==16?"回龙圩风电":"清能公司";
            groupMap.put("name",name);
            //总电量
            Double sumConsumption = new Double(0);
            //总电价
            Double sumMonovalent = new Double(0);
            for(Integer month =1;month<13;month++){
                String date = year+"-"+(month<10?"0"+month:month.toString())+"-01";
                BusinessElectricTrade where =new BusinessElectricTrade();
                where.setElectricTradeTime(new Date(date));
                where.setElectricTradeUnit(group.toString());
                List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectBusinessElectricTradeList(where);
                if(selectList.size()<1)continue;
                where = selectList.get(0);
                groupMap.put("consumption"+month,where.getElectricTradeConsumption());
                groupMap.put("monovalent"+month,where.getElectricTradeMonovalent());
                sumConsumption+=new Double(StringUtils.isEmpty(where.getElectricTradeConsumption())?"0":where.getElectricTradeConsumption());
                sumMonovalent+=new Double(StringUtils.isEmpty(where.getElectricTradeMonovalent())?"0":where.getElectricTradeMonovalent());
            }
            groupMap.put("consumption13",sumConsumption);
            groupMap.put("monovalent13",sumMonovalent);
            returnList.add(groupMap);
        }
        return returnList;
    }
    /**
     * 查询市场交易明细
     *
     * @param electricTradeTime
     * @return 结果
     */
    @Override
    public List<HashMap<String,String>> selectGroupByMonthTrade(String electricTradeTime) {//electricTradeTime为yyyy
        List<HashMap<String,String>> returnList= new ArrayList<>();
        HashMap<String, String> returnMap = new HashMap<>();
        BusinessElectricTrade select = new BusinessElectricTrade();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = StringUtils.substringBefore(ToolUtils.changeTime("","1"),"-");
        }
        String currentYear = electricTradeTime;
        String currentMonth = new String();
        int currentMonthInt = 1;
//        currentYear = ToolUtils.changeTime2(electricTradeTime,"1");
        String january = ToolUtils.changeTime2(currentYear,"7")+"-01";//获得需要查询年份1月
        String nextYear = ToolUtils.changeTime2(january,"3");
        String localTimeMonth = ToolUtils.changeTime("","1");
        String localTimeYear=StringUtils.substringBefore(localTimeMonth,"-");
        //判断参数传入的年份是否为本地年份，如果不是则查询12个月的全部数据（前为参数年份，后为本地年份）
        if(!(currentYear.equals(localTimeYear))){
            currentMonth =electricTradeTime+"-12";
        }else {
            currentMonth =ToolUtils.changeTime("","1");
        }
        String[] selectMonth = new String[13];
        selectMonth[0] = january;
        String tempTime = january;
        for (int i = 1; i < 12 ; i++) {//下标1-11对应2-12月
            selectMonth[i] = ToolUtils.changeTime2(tempTime,"0");
            tempTime=selectMonth[i];
        }
        selectMonth[12] = nextYear;
        for (int i = 0; i < 12 ; i++) {
            if(currentMonth.equals(selectMonth[i])){
                currentMonthInt= i+1;
            }
        }
        String selectNextMonth = ToolUtils.changeTime2(currentMonth,"0");
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(january,selectNextMonth,select);
        Double[] consumptionYearCount = new Double[18];//各集团电量数组
        Double[] temp = new Double[18];
        Double[] monovalentYearCount = new Double[18];//各集团电价数组
        List<String> yearConsumptionList = new ArrayList<>();
        List<String> yearMonovalentList = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            consumptionYearCount[i]=new Double(0);
            temp[i]=new Double(0);
            monovalentYearCount[i]=new Double(0);
        }
        for(BusinessElectricTrade bet : selectList){
            String ac = bet.getElectricTradeUnit();
            String electricTradeConsumption = bet.getElectricTradeConsumption();
            String electricTradeMonovalent = bet.getElectricTradeMonovalent();
            //如果集团为统调或清能则再另外外计算
            String group = ac.equals("9")?"全省电源":ac.equals("7")?"统调火电":ac.equals("8")?"其他电源":"";
            //各集团年电量计算
            consumptionYearCount[Integer.parseInt(ac)] += Double.parseDouble(electricTradeConsumption);
            if(!(Integer.parseInt(ac)==7 ||Integer.parseInt(ac)==17)){
                //各集团月度电量*电价相加
                temp[Integer.parseInt(ac)] += Double.parseDouble(electricTradeMonovalent)*Double.parseDouble(electricTradeConsumption);
            }
        }
        for (int i = 0; i <=6; i++) {
            if(0!=consumptionYearCount[i]){
                monovalentYearCount[i] = temp[i]/consumptionYearCount[i];
            }else {
                monovalentYearCount[i]= new Double(0);
            }
            //统调 全年累计电量*电价
            temp[7] += monovalentYearCount[i]*consumptionYearCount[i];
        }
        if(0!=consumptionYearCount[7]){
            monovalentYearCount[7] = temp[7]/consumptionYearCount[7];
        }else {
            monovalentYearCount[7]= new Double(0);
        }
        for (int i = 8; i <=16; i++) {
            if(0!=consumptionYearCount[i]){
                monovalentYearCount[i] = temp[i]/consumptionYearCount[i];
            }else {
                monovalentYearCount[i]= new Double(0);
            }
            //清能 全年累计电量*电价
            if(i>=10 && i<=16){
                temp[17] += monovalentYearCount[i]*consumptionYearCount[i];
            }
        }
        if(0!=consumptionYearCount[17]){
            monovalentYearCount[17] = temp[17]/consumptionYearCount[17];
        }else {
            monovalentYearCount[17]= new Double(0);
        }
        for (int i = 0; i < 18; i++) {
            yearConsumptionList.add(selectList.size()>0?ToolUtils.size2(consumptionYearCount[i]):ToolUtils.size2("0.00"));
            yearMonovalentList.add(selectList.size()>0?ToolUtils.size2(monovalentYearCount[i]):ToolUtils.size2("0.00"));
        }
        for(Integer group = 0; group <18; group++){
            HashMap<String,String> groupMap = new HashMap<>();
            String name =
                    group ==0?"华能":
                            group ==1?"大唐":
                                    group ==2?"华电":
                                            group ==3?"国能投":
                                                    group ==4?"国电投":
                                                            group ==5?"长安":
                                                                    group ==6?"华润":
                                                                            group ==7?"统调火电":
                                                                                    group ==8?"其他电源":
                                                                                            group ==9?"全省":
                                                                                                    group ==10?"湘祁水电":
                                                                                                            group ==11?"苏宝顶风电":
                                                                                                                    group ==12?"桂东风电":
                                                                                                                            group ==13?"连坪风电":
                                                                                                                                    group ==14?"梅桥风电":
                                                                                                                                            group ==15?"北湖风电":
                                                                                                                                                    group ==16?"回龙圩风电":"清能公司";
            groupMap.put("name",name);
            //总电量
            for(Integer month =1;month<=currentMonthInt;month++){
                String date = currentYear+"-"+(month<10?"0"+month:month.toString());
                BusinessElectricTrade where =new BusinessElectricTrade();
                where.setElectricTradeUnit(group.toString());
                String nextMonth = ToolUtils.changeTime2(date,"0");
                List<BusinessElectricTrade> list = businessElectricTradeMapper.selectByTimeElectricTradeList(date,nextMonth,where);
                if(list.size()<1)continue;
                where = list.size()>0?list.get(0):where;
                groupMap.put("dl"+month,selectList.size()>0?where.getElectricTradeConsumption():"-");
                groupMap.put("dj"+month,selectList.size()>0?where.getElectricTradeMonovalent():"-");
            }
            for(Integer month =currentMonthInt+1;month<13;month++){
                groupMap.put("dl"+month,"-");
                groupMap.put("dj"+month,"-");
            }
            groupMap.put("yeardl",selectList.size()>0?ToolUtils.size2(consumptionYearCount[group]):"-");
            groupMap.put("yeardj",selectList.size()>0?ToolUtils.size2(monovalentYearCount[group]):"-");
            returnList.add(groupMap);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("dataTime",electricTradeTime);
        returnList.add(map);
        return returnList;
    }
    /**
     * 查询统调对标月度市场交易情况柱状图
     *
     * @param electricTradeTime
     * @return 结果
     */
    @Override
    public Map<String, Object> tdSelectByMonthTradePillar(String electricTradeTime,List<Double> doubles) {
        Map<String, Object> returnMap = new HashMap<>();
        BusinessElectricTrade select = new BusinessElectricTrade();
        List<String> groupList = new ArrayList<>();
        List<String> consumptionList = new ArrayList<>();
        List<String> volumeList = new ArrayList<>();
        List<String> tempConsumptionList = new ArrayList<>();
        List<String> tempVolumeList = new ArrayList<>();
        Integer[] groupInt = new Integer[8];
        for (int i = 0; i < 8; i++) {
            groupInt[i]=-1;
        }
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        String nextMonth = ToolUtils.changeTime2(electricTradeTime,"0");
        BusinessElectricTrade tdSelect = new BusinessElectricTrade();
        tdSelect.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
        tdSelect.setElectricTradeUnit("7");
        List<BusinessElectricTrade> tdSelectList = businessElectricTradeMapper.selectByTimeElectricTradeList(electricTradeTime,nextMonth,tdSelect);
        String tdConsumption = tdSelectList.size()>0?tdSelectList.get(0).getElectricTradeConsumption():"0.00";
        select.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(electricTradeTime,nextMonth,select);
        if(!(tdSelectList.size()==0 || "0.00".equals(tdSelectList.get(0).getElectricTradeConsumption()))){
            for(BusinessElectricTrade bet:selectList){
                Integer i = Integer.parseInt(bet.getElectricTradeUnit());
                String group = i ==0?"华能": i ==1?"大唐": i ==2?"华电": i ==3?"国能投": i ==4?"国电投": i ==5?"长安": i ==6?"华润": "";
                //集团不为空且不为统调火电时
                if(!(group.isEmpty()||"统调火电".equals(group))){
                    groupInt[i] = i;
                    Double tdVolume = doubles.size()>0?doubles.get(7):new Double(0);
                    String consumption="0.00";
                    if(Double.parseDouble(tdConsumption)!=0){
                        Double value=Double.parseDouble(bet.getElectricTradeConsumption())/Double.parseDouble(tdConsumption);
                        consumption = ToolUtils.size2(value*100);
                    }else {
                        consumption="0.00";
                    }
                    String volume="0.00";
                    if(tdVolume!=0){
                        Double value= doubles.size()>0?(Double.parseDouble(bet.getElectricTradeConsumption())/Double.parseDouble(tdConsumption))-(doubles.get(i)/tdVolume):Double.parseDouble(consumption)/100;
                        volume = ToolUtils.size2(value*100);
                    }else {
                        Double value= Double.parseDouble(consumption)/100;
                        volume = ToolUtils.size2(value*100);
                    }
    //                    Double.parseDouble(bet.getElectricTradeConsumption())/Double.parseDouble(tdConsumption)
                    tempConsumptionList.add(consumption);
                    tempVolumeList.add(volume);
                }
            }
        }
        int count=0;
        for (int i = 0; i < 7; i++) {
            String group = i ==0?"华能": i ==1?"大唐": i ==2?"华电": i ==3?"国能投": i ==4?"国电投": i ==5?"长安": i ==6?"华润":"";
            groupList.add(group);
            Double tdVolume = doubles.size()>0?doubles.get(7):new Double(0);
            if(groupInt[i]!=i){
                consumptionList.add("0.00");
                Double temp = doubles.size()>0&&tdVolume!=0?-doubles.get(i)/tdVolume:0;
                volumeList.add(ToolUtils.size2(temp));
            }else {
                consumptionList.add(tempConsumptionList.get(count));
                volumeList.add(tempVolumeList.get(count));
                count++;
            }
        }
        returnMap.put("group",groupList);
        returnMap.put("consumption",consumptionList);
        returnMap.put("volume",volumeList);
        returnMap.put("dateTime",electricTradeTime);//月
        return returnMap;
    }

    @Override
    public List<NewElectricTradeVo> tdSelectByMonthTradeTable(String electricTradeTime, List<Double> doubles) {
        List<NewElectricTradeVo> returnList = new ArrayList<>();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        BusinessElectricTrade tdSelect = new BusinessElectricTrade();
        tdSelect.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
        tdSelect.setElectricTradeUnit("7");
        String nextMonth = ToolUtils.changeTime2(electricTradeTime,"0");
        List<BusinessElectricTrade> tdSelectList = businessElectricTradeMapper.selectByTimeElectricTradeList(electricTradeTime,nextMonth,tdSelect);
        for (Integer i = 0; i < 7; i++) {
            String group = i ==0?"华能": i ==1?"大唐": i ==2?"华电": i ==3?"国能投": i ==4?"国电投": i ==5?"长安": i ==6?"华润": i ==7?"统调火电":"";
            NewElectricTradeVo returnbet = new NewElectricTradeVo();
            returnbet.setJt(group);
            returnbet.setZjrl(ToolUtils.size2(doubles.size()>0?doubles.get(i):new Double(0.0)));
            BusinessElectricTrade bet = new BusinessElectricTrade();
            bet.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
            bet.setElectricTradeUnit(i.toString());
            List<BusinessElectricTrade> list = businessElectricTradeMapper.selectByTimeElectricTradeList(electricTradeTime,nextMonth,bet);
            bet = list.size()>0?list.get(0):bet;
            String consumption="0.00";
            if(tdSelectList.size()>0 && Double.parseDouble(tdSelectList.get(0).getElectricTradeConsumption())!=0){
                Double value=null==bet.getElectricTradeConsumption()?new Double(0.0):Double.parseDouble(bet.getElectricTradeConsumption())/Double.parseDouble(tdSelectList.get(0).getElectricTradeConsumption());
                consumption = ToolUtils.size2(value*100);
            }else {
                consumption="0.00";
            }
            String rlfe= doubles.size()>0&&0!=doubles.get(7)?ToolUtils.size2(doubles.get(i)/doubles.get(7)):"0.00";
            returnbet.setRlfe(rlfe);
            returnbet.setDlzb(consumption);
            returnbet.setDl(bet.getElectricTradeConsumption());
            returnbet.setDj(bet.getElectricTradeMonovalent());
            returnbet.setJrlfe(ToolUtils.size2(Double.parseDouble(consumption)-Double.parseDouble(rlfe)));
            String djjpj = "-";
            if(tdSelectList.size()>0 && null!=bet.getElectricTradeMonovalent()){
                djjpj=ToolUtils.size2(Double.parseDouble(bet.getElectricTradeMonovalent())-Double.parseDouble(tdSelectList.get(0).getElectricTradeMonovalent()));
            }else if(tdSelectList.size()>0 && null==bet.getElectricTradeMonovalent()){
                djjpj=ToolUtils.size2(-Double.parseDouble(tdSelectList.get(0).getElectricTradeMonovalent()));
            }
            returnbet.setDjjpj(djjpj);
            returnList.add(returnbet);
        }
        return returnList;
    }

    @Override
    public Map<String, Object> tdSelectByYearTradePillar(String electricTradeTime, List<Double> doubles) {
        Map<String, Object> returnMap = new HashMap<>();
        List<String> groupList = new ArrayList<>();
        List<String> consumptionList = new ArrayList<>();
        List<String> volumeList = new ArrayList<>();
        List<Double> yearMonovalentList = new ArrayList<>();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        String currentMonth = electricTradeTime;
        String nextMonth = ToolUtils.changeTime2(currentMonth,"0");
        String currentYear = ToolUtils.changeTime2(currentMonth, "1");
        String january = ToolUtils.changeTime2(currentYear,"2");//先获取年份后默认得到1月份
        BusinessElectricTrade tdSelect = new BusinessElectricTrade();
        tdSelect.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
        tdSelect.setElectricTradeUnit("7");
        List<BusinessElectricTrade> tdSelectList = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,tdSelect);
        Double tdCount = new Double(0.0);
        Double tdTempCount = new Double(0.0);
        Double tdDJCount = new Double(0.0);//统调电价
        for(BusinessElectricTrade tdbet :tdSelectList){
            tdCount+= Double.parseDouble(tdbet.getElectricTradeConsumption());
        }
        for (Integer i = 0; i < 7; i++) {
            String group = i ==0?"华能": i ==1?"大唐": i ==2?"华电": i ==3?"国能投": i ==4?"国电投": i ==5?"长安": i ==6?"华润":"";
            groupList.add(group);
            String consumption="0.00";
            BusinessElectricTrade bet = new BusinessElectricTrade();
            bet.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
            bet.setElectricTradeUnit(i.toString());
            List<BusinessElectricTrade> list = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,bet);
            Double count = new Double(0.0);
            Double monovalentCount = new Double(0.0);
            for(BusinessElectricTrade value:list){
                if(tdSelectList.size()>0 && tdCount!=0){
                    monovalentCount += Double.parseDouble(value.getElectricTradeConsumption())*Double.parseDouble(value.getElectricTradeMonovalent());
                    tdTempCount+=monovalentCount;
                    count += Double.parseDouble(value.getElectricTradeConsumption());
                    consumption = ToolUtils.size2(100*count/tdCount);
                }else {
                    consumption="0.00";
                }
            }
            Double yearMonovalent = 0!=count?monovalentCount/count:monovalentCount;
            yearMonovalentList.add(yearMonovalent);
            consumptionList.add(consumption);
//            doubles.size()>0?doubles.get(7):new Double(0)
            Double tdVolume = doubles.size()>0?doubles.get(7):new Double(0);
            String rlfe= "0.00";
            if(0!=tdVolume){
                rlfe= 0!=doubles.get(7)?ToolUtils.size2((doubles.get(i)/doubles.get(7))*100):"0.00";
            }
            Double jrlfe = Double.parseDouble(consumption)-Double.parseDouble(rlfe);
            volumeList.add(ToolUtils.size2(jrlfe));
        }
        returnMap.put("group",groupList);
        returnMap.put("consumption",consumptionList);
        returnMap.put("volume",volumeList);
        returnMap.put("dateTime",electricTradeTime);//月份
        return returnMap;
    }

    @Override
    public List<NewElectricTradeVo> tdSelectByYearTradeTable(String electricTradeTime, List<Double> doubles) {
        List<NewElectricTradeVo> returnList = new ArrayList<>();
        if(electricTradeTime.isEmpty()){
            electricTradeTime = ToolUtils.changeTime(electricTradeTime,"1");
        }
        String currentMonth = electricTradeTime;
        String nextMonth = ToolUtils.changeTime2(currentMonth,"0");
        String january = ToolUtils.changeTime2(ToolUtils.changeTime2(currentMonth,"1"),"2");//先获取年份后默认得到1月份
        BusinessElectricTrade tdSelect = new BusinessElectricTrade();
        tdSelect.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
        tdSelect.setElectricTradeUnit("7");
        List<BusinessElectricTrade> tdSelectList = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,tdSelect);
        Double tdCount = new Double(0.0);
        BusinessElectricTrade select = new BusinessElectricTrade();
        select.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
        List<BusinessElectricTrade> selectList = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,select);
        Double tdDL = new Double(0.0);//统调电量统计(0-6)
        Double tdDJCount = new Double(0.0);//统调电量*电价统计0-6)
        for(BusinessElectricTrade where :selectList){
            int groupInt = Integer.parseInt(where.getElectricTradeUnit());
            if(groupInt<=6){
                tdDL+=Double.parseDouble(where.getElectricTradeConsumption());
                tdDJCount+= Double.parseDouble(where.getElectricTradeConsumption())*Double.parseDouble(where.getElectricTradeMonovalent());
            }
        }
        Double tdDJ = 0!=selectList.size()&&0!=tdDJCount?tdDJCount/tdDL:new Double(0.0);
        for (Integer i = 0; i < 7; i++) {
            String group = i ==0?"华能": i ==1?"大唐": i ==2?"华电": i ==3?"国能投": i ==4?"国电投": i ==5?"长安": i ==6?"华润": i ==7?"统调火电":"";
            NewElectricTradeVo returnbet = new NewElectricTradeVo();
            returnbet.setJt(group);
            returnbet.setZjrl(ToolUtils.size2(doubles.size()>0?doubles.get(i):new Double(0.0)));
            BusinessElectricTrade bet = new BusinessElectricTrade();
            bet.setElectricTradeTime(ToolUtils.toData(electricTradeTime,"1"));
            bet.setElectricTradeUnit(i.toString());
            List<BusinessElectricTrade> list = businessElectricTradeMapper.selectByTimeElectricTradeList(january,nextMonth,bet);
//            bet = list.size()>0?list.get(0):bet;
            Double dlCount = new Double(0.0);
            Double djCount = new Double(0.0);
            for(BusinessElectricTrade where:list){
                dlCount+= Double.parseDouble(where.getElectricTradeConsumption());
                djCount+= Double.parseDouble(where.getElectricTradeConsumption())*Double.parseDouble(where.getElectricTradeMonovalent());
            }
            Double dj = 0!=dlCount?djCount/dlCount:new Double(0.0);
            String consumption="0.00";
            if(tdDL!=0){
                Double value=dlCount/tdDL;
                consumption = ToolUtils.size2(value*100);
            }
            String rlfe= doubles.size()>0&&0!=doubles.get(7)?ToolUtils.size2(100*doubles.get(i)/doubles.get(7)):"0.00";
            returnbet.setRlfe(rlfe);
            returnbet.setDlzb(consumption);
            returnbet.setDl(ToolUtils.size2(dlCount));
            returnbet.setDj(ToolUtils.size2(dj));
            returnbet.setJrlfe(ToolUtils.size2(Double.parseDouble(consumption)-Double.parseDouble(rlfe)));
            returnbet.setDjjpj(tdSelectList.size()>0 ?ToolUtils.size2(dj-tdDJ):"-");
            returnList.add(returnbet);
        }
        return returnList;
    }
}
