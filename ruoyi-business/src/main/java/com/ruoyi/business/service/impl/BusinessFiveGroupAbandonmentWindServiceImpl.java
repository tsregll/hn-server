package com.ruoyi.business.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessParcelCompanyAbandonmentWind;
import com.ruoyi.business.service.IBusinessParcelCompanyAbandonmentWindService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessFiveGroupAbandonmentWindMapper;
import com.ruoyi.business.domain.BusinessFiveGroupAbandonmentWind;
import com.ruoyi.business.service.IBusinessFiveGroupAbandonmentWindService;

/**
 * 五大发电集团月度弃风情况Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
@Service
public class BusinessFiveGroupAbandonmentWindServiceImpl implements IBusinessFiveGroupAbandonmentWindService 
{
    @Autowired
    private BusinessFiveGroupAbandonmentWindMapper businessFiveGroupAbandonmentWindMapper;
    @Autowired
    private IBusinessParcelCompanyAbandonmentWindService businessParcelCompanyAbandonmentWindService;

    /**
     * 查询五大发电集团月度弃风情况
     * 
     * @param id 五大发电集团月度弃风情况ID
     * @return 五大发电集团月度弃风情况
     */
    @Override
    public BusinessFiveGroupAbandonmentWind selectBusinessFiveGroupAbandonmentWindById(Long id)
    {
        return businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindById(id);
    }

    /**
     * 查询五大发电集团月度弃风情况列表
     * 
     * @param businessFiveGroupAbandonmentWind 五大发电集团月度弃风情况
     * @return 五大发电集团月度弃风情况
     */
    @Override
    public List<BusinessFiveGroupAbandonmentWind> selectBusinessFiveGroupAbandonmentWindList(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind)
    {
        return businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(businessFiveGroupAbandonmentWind);
    }

    @Override
    public List<BusinessFiveGroupAbandonmentWind> selectByTimeFiveGroupAbandonmentWindList(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind)
    {
        return businessFiveGroupAbandonmentWindMapper.selectByTimeFiveGroupAbandonmentWindList(businessFiveGroupAbandonmentWind);
    }

    /**
     * 新增五大发电集团月度弃风情况
     * select_abandonment_five_group
     * @param bf 五大发电集团月度弃风情况
     * @return 结果
     */
    @Override
    public int insertBusinessFiveGroupAbandonmentWind(BusinessFiveGroupAbandonmentWind bf, Map<String,Double> sjMap)
    {
        //填入基础参数
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bf.setCreateBy(loginUser.getUsername());
        bf.setStatus("1");
        bf.setCreateTime(DateUtils.getNowDate());
        //获取年月
        String dateTime = bf.getAbandonmentDate();
        //定义查询对象
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        //传入基础的查询时间
        select.setAbandonmentDate(dateTime);
        //定义查询返回集合
        List<BusinessFiveGroupAbandonmentWind> selectList = null;
        Double electricityVolume = new Double(0);
        Double abandonmentVolume = new Double(0);
        Double sum = new Double(0);
        //不属于五大集团与分公司，直接计算弃风率填入对象
        electricityVolume = Double.parseDouble(bf.getElectricityVolume());
        abandonmentVolume = Double.parseDouble(bf.getAbandonmentVolume());
        if(electricityVolume>0){
            sum = (abandonmentVolume/(abandonmentVolume+electricityVolume))*100;
        }
        bf.setAbandonmentRate(ToolUtils.size2(sum));
        //定义五大集团所用的对象
        BusinessFiveGroupAbandonmentWind bf5 = new BusinessFiveGroupAbandonmentWind();
        //查询当月数据，备用
        List<BusinessFiveGroupAbandonmentWind> selectAllList = this.selectBusinessFiveGroupAbandonmentWindList(select);
        //查询当月是否存在五大集团数据
        select.setAbandonmentGroup("5");
        selectList = this.selectBusinessFiveGroupAbandonmentWindList(select);
        //如果有五大集团则修改，没有则新增
        if(selectList.size()>0){
            bf5 = selectList.get(0);
            bf5 = sum5(selectAllList,bf5,bf);
            update(bf5);
        }else{
            bf5 = sum5(selectAllList,bf5,bf);
            bf5.setAbandonmentGroup("5");
            bf5.setAbandonmentDate(dateTime);
            bf5.setCreateBy(loginUser.getUsername());
            bf5.setStatus("1");
            bf5.setCreateTime(DateUtils.getNowDate());
            businessFiveGroupAbandonmentWindMapper.insertBusinessFiveGroupAbandonmentWind(bf5);
        }
        return businessFiveGroupAbandonmentWindMapper.insertBusinessFiveGroupAbandonmentWind(bf);
    }

    public static BusinessFiveGroupAbandonmentWind sum5(List<BusinessFiveGroupAbandonmentWind>selectList,BusinessFiveGroupAbandonmentWind insBf,BusinessFiveGroupAbandonmentWind nowBf){
        Double electricityVolume = new Double(0);
        Double abandonmentVolume = new Double(0);
        Double installationVolume = new Double(0);
        Double sum = new Double(0);
        //循环累加总和
        for(BusinessFiveGroupAbandonmentWind sbf:selectList){
            if(sbf.getAbandonmentGroup().equals("5"))continue;
            electricityVolume +=
                    Double.parseDouble(sbf.getElectricityVolume());
            abandonmentVolume +=
                    Double.parseDouble(sbf.getAbandonmentVolume());
            installationVolume +=
                    Double.parseDouble(sbf.getInstallationVolume());
        }
        if(nowBf!=null){
            electricityVolume +=
                    Double.parseDouble(nowBf.getElectricityVolume());
            abandonmentVolume +=
                    Double.parseDouble(nowBf.getAbandonmentVolume());
            installationVolume +=
                    Double.parseDouble(nowBf.getInstallationVolume());
        }
        //总和填入新增对象
        insBf.setElectricityVolume(ToolUtils.size2(electricityVolume));
        insBf.setAbandonmentVolume(ToolUtils.size2(abandonmentVolume));
        insBf.setInstallationVolume(ToolUtils.size2(installationVolume));
        //计算弃风率并且保存进新增对象
        if(electricityVolume>0){
            sum = (abandonmentVolume/(abandonmentVolume+electricityVolume))*100;
        }
        insBf.setAbandonmentRate(ToolUtils.size2(sum));

        return insBf;
    }

    /**
     * 修改五大发电集团月度弃风情况
     * 
     * @param bf 五大发电集团月度弃风情况
     * @return 结果
     */
    @Override
    public int updateBusinessFiveGroupAbandonmentWind(BusinessFiveGroupAbandonmentWind bf)
    {
        //获取年月
        String dateTime = bf.getAbandonmentDate();
        //定义查询对象
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        //传入基础的查询时间
        select.setAbandonmentDate(dateTime);
        //定义查询返回集合
        List<BusinessFiveGroupAbandonmentWind> selectList = null;
        //不属于五大集团，需要先更新数据库数据
        int result =0 ;
        //判断是否为五大集团，5为五大集团
        if(bf.getAbandonmentGroup().equals("5")){
            //查询当前年月的其他数据
            selectList = this.selectBusinessFiveGroupAbandonmentWindList(select);
            //进行五大集团的计算
            bf = sum5(selectList,bf,null);
            result = update(bf);
        }else{
            //判断是否为华能，4为华能，
            if(bf.getAbandonmentGroup().equals("4")){
                //查找分公司数据，条件为当前年月
                BusinessParcelCompanyAbandonmentWind bp = new BusinessParcelCompanyAbandonmentWind();
                bp.setAbandonmentCompany("6");
                bp.setAbandonmentDate(dateTime);
                List<BusinessParcelCompanyAbandonmentWind> bpList = businessParcelCompanyAbandonmentWindService.selectBusinessParcelCompanyAbandonmentWindList(bp);
                //如果有分公司数据则直接取值，如果没有则填入空
                if(bpList.size()>0){
                    bf.setAbandonmentVolume(bpList.get(0).getAbandonmentVolume());
                    bf.setAbandonmentRate  (bpList.get(0).getAbandonmentRate());
                }else{
                    bf.setAbandonmentVolume(ToolUtils.size2(Double.parseDouble("0")));
                    bf.setAbandonmentRate  (ToolUtils.size2(Double.parseDouble("0")));
                }
                result = update(bf);
            }else{
                Double electricityVolume = new Double(0);
                Double abandonmentVolume = new Double(0);
                Double sum = new Double(0);
                //不属于五大集团与分公司，直接计算弃风率填入对象
                electricityVolume = Double.parseDouble(bf.getElectricityVolume());
                abandonmentVolume = Double.parseDouble(bf.getAbandonmentVolume());
                if(electricityVolume>0){
                    sum = (abandonmentVolume/(abandonmentVolume+electricityVolume))*100;
                }
                bf.setAbandonmentRate(ToolUtils.size2(sum));
                result = update(bf);
            }
            //定义五大集团所用的对象
            BusinessFiveGroupAbandonmentWind bf5 = new BusinessFiveGroupAbandonmentWind();
            //查询当月数据，备用
            List<BusinessFiveGroupAbandonmentWind> selectAllList = this.selectBusinessFiveGroupAbandonmentWindList(select);
            //查询当月是否存在五大集团数据
            select.setAbandonmentGroup("5");
            selectList = this.selectBusinessFiveGroupAbandonmentWindList(select);
            //如果有五大集团则修改，没有则新增
            bf5 = selectList.get(0);
            bf5 = sum5(selectAllList,bf5,null);
            update(bf5);
        }
        return result;
    }

    private int update(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind){
            LoginUser loginUser = SecurityUtils.getLoginUser();
            businessFiveGroupAbandonmentWind.setUpdateBy(loginUser.getUsername());
            businessFiveGroupAbandonmentWind.setUpdateTime(DateUtils.getNowDate());
            return businessFiveGroupAbandonmentWindMapper.updateBusinessFiveGroupAbandonmentWind(businessFiveGroupAbandonmentWind);
    }
    /**
     * 批量删除五大发电集团月度弃风情况
     * 
     * @param ids 需要删除的五大发电集团月度弃风情况ID
     * @return 结果
     */
    @Override
    public int deleteBusinessFiveGroupAbandonmentWindByIds(Long[] ids)
    {
        return businessFiveGroupAbandonmentWindMapper.deleteBusinessFiveGroupAbandonmentWindByIds(ids);
    }

    /**
     * 删除五大发电集团月度弃风情况信息
     * 
     * @param id 五大发电集团月度弃风情况ID
     * @return 结果
     */
    @Override
    public int deleteBusinessFiveGroupAbandonmentWindById(Long id)
    {
        return businessFiveGroupAbandonmentWindMapper.deleteBusinessFiveGroupAbandonmentWindById(id);
    }

    @Override
    public Map<String, Object> selectByMonthOutPillar(String abandonmentDate) {
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        Map<String, Object> returnMap = new HashMap<>();
        List<String> abandonmentRateList = new ArrayList<>();
        List<String> abandonmentCompanyList = new ArrayList<>();
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        select.setAbandonmentDate(abandonmentDate);
        List<BusinessFiveGroupAbandonmentWind> selectList = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(select);
        List<Integer> companyCount = new ArrayList<>();
        for(BusinessFiveGroupAbandonmentWind bpc : selectList){
            String ac = bpc.getAbandonmentGroup();
            companyCount.add(Integer.parseInt(ac));
            String group = ac.equals("0")?"国电投":ac.equals("1")?"国能投":ac.equals("2")?"大唐":ac.equals("3")?"华电":ac.equals("4")?"华能":"五大集团";
            Double abandonmentRate = new Double(bpc.getAbandonmentRate());
            abandonmentRate = abandonmentRate;
            abandonmentRateList.add(ToolUtils.size2(abandonmentRate.toString()));
            abandonmentCompanyList.add(group);
        }
        for(Integer i =0;i<6;i++){
            Boolean bl = new Boolean(true);
            String group = i==0?"国电投":i==1?"国能投":i==2?"大唐":i==3?"华电":i==4?"华能":"五大集团";
            for (Integer count : companyCount) {
                if(i==count){
                    bl = false;
                }
            }
            if(bl){
                abandonmentRateList.add(ToolUtils.size2("0.00"));
                abandonmentCompanyList.add(group);
            }
        }
        returnMap.put("data",abandonmentRateList);
        returnMap.put("companydata",abandonmentCompanyList);
        returnMap.put("dateTime",abandonmentDate);
        return returnMap;
    }

    @Override
    public List<BusinessFiveGroupAbandonmentWind> selectByMonthOutTable(String abandonmentDate) {
        List<BusinessFiveGroupAbandonmentWind> returnList = new ArrayList<>();
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        select.setAbandonmentDate(abandonmentDate);
        List<BusinessFiveGroupAbandonmentWind> selectList = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(select);
        for(BusinessFiveGroupAbandonmentWind bpc :selectList){
            Integer i = Integer.parseInt(bpc.getAbandonmentGroup());
            String group = i==0?"国电投":i==1?"国能投":i==2?"大唐":i==3?"华电":i==4?"华能":"五大集团";
            bpc.setAbandonmentGroup(group);
            bpc.setInstallationVolume(ToolUtils.size2(bpc.getInstallationVolume()));
            bpc.setElectricityVolume(ToolUtils.size2(bpc.getElectricityVolume()));
            bpc.setAbandonmentVolume(ToolUtils.size2(bpc.getAbandonmentVolume()));
            bpc.setAbandonmentRate(ToolUtils.size2(bpc.getAbandonmentRate()));
            returnList.add(bpc);
        }
        return returnList;
    }

    @Override
    public Map<String, Object> selectByYearOutPillar(String abandonmentDate) {
        //获得日期
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        Integer year = Integer.parseInt(abandonmentDate.substring(0,4));
        Integer month = Integer.parseInt(abandonmentDate.substring(5,7));
        //定义返回对象
        Map<String, Object> returnMap = new HashMap<>();
        List<String> abandonmentRateList = new ArrayList<>();
        List<String> abandonmentCompanyList = new ArrayList<>();
        //定义查询对象
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        select.setAbandonmentDate(year+"-"+(month.toString().length()<2?"0"+month:month.toString()));
        List<BusinessFiveGroupAbandonmentWind> countList = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(select);
        if(countList!=null&&countList.size()>5){
            for(Integer i =5;i>=0;i--){
                String ac = i.toString();
                String group = ac.equals("0")?"国电投":ac.equals("1")?"国能投":ac.equals("2")?"大唐":ac.equals("3")?"华电":ac.equals("4")?"华能":"五大集团";
                abandonmentCompanyList.add(group);
                //公司下标
                select.setAbandonmentGroup(i.toString());

                Double electricityVolume = new Double(0);
                Double abandonmentVolume = new Double(0);
                for(Integer dateTime =1;dateTime<=month;dateTime++){
                    //日期条件
                    select.setAbandonmentDate(year.toString()+"-"+(dateTime.toString().length()<2?"0"+dateTime:dateTime.toString()));
                    //查询
                    List<BusinessFiveGroupAbandonmentWind> selectList = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(select);
                    //转译
                    for(BusinessFiveGroupAbandonmentWind bpc : selectList){
                        electricityVolume += new Double(bpc.getElectricityVolume());
                        abandonmentVolume += new Double(bpc.getAbandonmentVolume());
                    }
                }
                Double sum = new Double(0);
                if(electricityVolume>0){
                    sum = (abandonmentVolume/(abandonmentVolume+electricityVolume))*100;
                }
                abandonmentRateList.add(ToolUtils.size2(sum.toString()));
            }
        }
        returnMap.put("data",abandonmentRateList);
        returnMap.put("companydata",abandonmentCompanyList);
        returnMap.put("dateTime",abandonmentDate);
        return returnMap;
    }

    @Override
    public List<BusinessFiveGroupAbandonmentWind> selectByYearOutTable(String abandonmentDate) {
        //返回对象
        List<BusinessFiveGroupAbandonmentWind> returnList = new ArrayList<>();
        //年份获取
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        Integer year = Integer.parseInt(abandonmentDate.substring(0,4));
        Integer month = Integer.parseInt(abandonmentDate.substring(5,7));
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        select.setAbandonmentDate(year+"-"+(month.toString().length()<2?"0"+month:month.toString()));
        List<BusinessFiveGroupAbandonmentWind> countList = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(select);
        if(countList!=null&&countList.size()>5){
            for(Integer groupCount =5;groupCount>=0;groupCount--){
                //查询对象
                select.setAbandonmentGroup(groupCount.toString());
                //各项数据的统计对象
                Double electricityVolume = new Double(0);
                Double abandonmentVolume = new Double(0);
                Double abandonmentRate = new Double(0);
                //保存对象
                BusinessFiveGroupAbandonmentWind listAdd = new BusinessFiveGroupAbandonmentWind();
                //保存对象返回的集团名称转换
                String group = groupCount==0?"国电投":groupCount==1?"国能投":groupCount==2?"大唐":groupCount==3?"华电":groupCount==4?"华能":"五大集团";
                listAdd.setAbandonmentGroup(group);
                //循环每一个月
                for(Integer i =1;i<=month;i++){
                    select.setAbandonmentDate(year.toString()+"-"+(i.toString().length()<2?"0"+i:i.toString()));
                    List<BusinessFiveGroupAbandonmentWind> selectList = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(select);
                    for(BusinessFiveGroupAbandonmentWind bf:selectList){
                        electricityVolume += new Double(bf.getElectricityVolume());
                        abandonmentVolume += new Double(bf.getAbandonmentVolume());
                        if(bf.getAbandonmentGroup().equals(groupCount.toString())){
                            listAdd.setInstallationVolume(ToolUtils.size2(bf.getInstallationVolume()));
                        }
                    }
                }
                listAdd.setElectricityVolume(ToolUtils.size2(electricityVolume.toString()));
                listAdd.setAbandonmentVolume(ToolUtils.size2(abandonmentVolume.toString()));
                if(electricityVolume>0){
                    abandonmentRate = abandonmentVolume/(abandonmentVolume+electricityVolume);
                }
                abandonmentRate = abandonmentRate*100;
                listAdd.setAbandonmentRate(ToolUtils.size2(abandonmentRate.toString()));
                returnList.add(listAdd);
            }
        }
        return returnList;
    }
}
