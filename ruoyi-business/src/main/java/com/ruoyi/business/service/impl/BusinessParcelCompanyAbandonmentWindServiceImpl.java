package com.ruoyi.business.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessFiveGroupAbandonmentWind;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.mapper.BusinessFiveGroupAbandonmentWindMapper;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessParcelCompanyAbandonmentWindMapper;
import com.ruoyi.business.domain.BusinessParcelCompanyAbandonmentWind;
import com.ruoyi.business.service.IBusinessParcelCompanyAbandonmentWindService;

/**
 * 分公司各风场弃风情况月度Service业务层处理
 * 
 * @author yrb
 * @date 2021-03-22
 */
@Service
public class BusinessParcelCompanyAbandonmentWindServiceImpl implements IBusinessParcelCompanyAbandonmentWindService 
{
    @Autowired
    private BusinessParcelCompanyAbandonmentWindMapper businessParcelCompanyAbandonmentWindMapper;
    @Autowired
    private BusinessFiveGroupAbandonmentWindMapper businessFiveGroupAbandonmentWindMapper;
    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 查询分公司各风场弃风情况月度
     * 
     * @param id 分公司各风场弃风情况月度ID
     * @return 分公司各风场弃风情况月度
     */
    @Override
    public BusinessParcelCompanyAbandonmentWind selectBusinessParcelCompanyAbandonmentWindById(Long id)
    {
        return businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindById(id);
    }

    /**
     * 查询分公司各风场弃风情况月度列表
     * 
     * @param businessParcelCompanyAbandonmentWind 分公司各风场弃风情况月度
     * @return 分公司各风场弃风情况月度
     */
    @Override
    public List<BusinessParcelCompanyAbandonmentWind> selectBusinessParcelCompanyAbandonmentWindList(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind)
    {
        return businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(businessParcelCompanyAbandonmentWind);
    }

    @Override
    public List<BusinessParcelCompanyAbandonmentWind> selectByTimesParcelCompanyAbandonmentWindList(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind) {
        return businessParcelCompanyAbandonmentWindMapper.selectByTimesParcelCompanyAbandonmentWindList(businessParcelCompanyAbandonmentWind);
    }

    /**
     * 新增分公司各风场弃风情况月度
     * 
     * @param bpc 分公司各风场弃风情况月度
     * @param sum 通过中台查询到的数据
     * @return 结果
     */
    @Override
    public int insertBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind bpc, Map<String,Double> sum)
    {
        //基础新增信息
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bpc.setCreateBy(loginUser.getUsername());
        bpc.setStatus("1");
        bpc.setCreateTime(DateUtils.getNowDate());
        //获取用户选择的场站下标
        String ac = bpc.getAbandonmentCompany();
        //通过下标选择对应的数据
        String electricity  = SelectLabel(ac,"月发电量");
        String installation = SelectLabel(ac,"年装机量");
        String fgsInstallation = SelectLabel("6","年装机量");
        //HNHN.WDSUM.WZJRL.SKCAL
        //labelNameList.add("月发电量");
        //labelNameList.add("年装机量");
        //保存当前新增数据的装机与发电量
        bpc.setElectricityVolume(sum.get(electricity).toString());
        bpc.setInstallationVolume(sum.get(installation).toString());
        //计算弃风率
        Double calSum = new Double(0);
        if(sum.get(electricity)>0)calSum = new Double(bpc.getAbandonmentVolume())/(new Double(bpc.getAbandonmentVolume())+sum.get(electricity));
        calSum  = calSum*100;
        bpc.setAbandonmentRate(ToolUtils.size2(calSum));
        //查询所准备的对象
        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        //当前用户所选的天数
        select.setAbandonmentDate(bpc.getAbandonmentDate());
        //下标6的分公司数据
        select.setAbandonmentCompany("6");
        //调用查询查找
        List<BusinessParcelCompanyAbandonmentWind> selectList = this.selectBusinessParcelCompanyAbandonmentWindList(select);
        //获取分公司需要的参数
        String sumElectricity = sum.get(electricity).toString();
        String sumAbandonmentVolume = bpc.getAbandonmentVolume();
        String sumAbandonmentDate = bpc.getAbandonmentDate();
        String sumFgsInstallation = sum.get(fgsInstallation).toString();
        BusinessParcelCompanyAbandonmentWind fgs = null;
        if(selectList !=null && selectList.size()>0){
            //存在
            //获取分公司风电数据
            fgs = selectList.get(0);
            fgs = this.zhFgs(sumElectricity,sumAbandonmentVolume ,sumAbandonmentDate , sumFgsInstallation, fgs);
            this.updateBusinessParcelCompanyAbandonmentWind(fgs);
        }else{
            //不存在
            //新增分公司风电数据
            fgs = new BusinessParcelCompanyAbandonmentWind();
            fgs.setAbandonmentDate(bpc.getAbandonmentDate());
            fgs.setAbandonmentCompany("6");
            fgs = this.zhFgs(sumElectricity,sumAbandonmentVolume ,sumAbandonmentDate , sumFgsInstallation, fgs);
            fgs.setCreateBy(loginUser.getUsername());
            fgs.setStatus("1");
            fgs.setCreateTime(DateUtils.getNowDate());
            businessParcelCompanyAbandonmentWindMapper.insertBusinessParcelCompanyAbandonmentWind(fgs);
        }
        //五大集团弃风——新增or修改华能
        BusinessFiveGroupAbandonmentWind selectBf = new BusinessFiveGroupAbandonmentWind();
        selectBf.setAbandonmentGroup("4");
        selectBf.setAbandonmentDate(sumAbandonmentDate);
        List<BusinessFiveGroupAbandonmentWind> bf  = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(selectBf);
        Double electricityVolume = sum.get(SelectLabel("6","月发电量"));
        Double rate = Double.parseDouble(fgs.getAbandonmentRate());
        if(bf.size()>0) selectBf = bf.get(0);
        selectBf.setElectricityVolume(electricityVolume.toString());
        selectBf.setAbandonmentVolume(fgs.getAbandonmentVolume());
        selectBf.setAbandonmentRate(ToolUtils.size2(rate));
        if(bf.size()>0){
            selectBf.setUpdateBy(loginUser.getUsername());
            selectBf.setUpdateTime(DateUtils.getNowDate());
            businessFiveGroupAbandonmentWindMapper.updateBusinessFiveGroupAbandonmentWind(selectBf);
        }else{
            selectBf.setCreateBy(loginUser.getUsername());
            selectBf.setCreateTime(DateUtils.getNowDate());
            selectBf.setStatus("1");
            selectBf.setInstallationVolume(sumFgsInstallation);
            businessFiveGroupAbandonmentWindMapper.insertBusinessFiveGroupAbandonmentWind(selectBf);
        }
        //五大集团弃风——新增or修改五大集团
        //获取五大集团数据or定义新数据
        selectBf.setAbandonmentGroup("5");
        selectBf.setAbandonmentDate(sumAbandonmentDate);
        bf  = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(selectBf);
        BusinessFiveGroupAbandonmentWind fiveBf = null;
        if(bf!=null&&bf.size()>0){
            fiveBf = bf.get(0);
        }else{
            fiveBf =  new BusinessFiveGroupAbandonmentWind();
            fiveBf.setAbandonmentGroup("5");
            fiveBf.setAbandonmentDate(sumAbandonmentDate);
        }
        //查询输入月份的全部数据
        selectBf.setAbandonmentGroup(null);
        selectBf.setAbandonmentDate(sumAbandonmentDate);
        bf  = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(selectBf);
        //组装五大集团数据
        fiveBf = BusinessFiveGroupAbandonmentWindServiceImpl.sum5(bf,fiveBf,null);
        //如果有id代表是修改，无id则是新增
        if(fiveBf.getId()==null){
            fiveBf.setCreateBy(loginUser.getUsername());
            fiveBf.setCreateTime(DateUtils.getNowDate());
            fiveBf.setStatus("1");
            businessFiveGroupAbandonmentWindMapper.insertBusinessFiveGroupAbandonmentWind(fiveBf);
        }else{
            fiveBf.setUpdateBy(loginUser.getUsername());
            fiveBf.setUpdateTime(DateUtils.getNowDate());
            fiveBf.setStatus("1");
            businessFiveGroupAbandonmentWindMapper.updateBusinessFiveGroupAbandonmentWind(fiveBf);
        }
        return businessParcelCompanyAbandonmentWindMapper.insertBusinessParcelCompanyAbandonmentWind(bpc);
    }

    private String SelectLabel(String ac,String type){
        String name = "弃风情况统计表";
        List<String> placeList =new ArrayList<> ();
        String place =
                ac.equals("0")?"苏宝顶风电":
                        ac.equals("1")?"桂东风电":
                                ac.equals("2")?"连坪风电":
                                        ac.equals("3")?"梅桥风电":
                                                ac.equals("4")?"北湖风电":
                                                        ac.equals("5")?"回龙圩风电":
                                                        ac.equals("7")?"江口风电":"分公司风电";
        SkBbLabel byName = skBbLabelService.find(name,type,place);
        return  byName.getLabel ();
    }
    /**
     * 复写的修改方法
     * @param bpc 需要修改的分公司
     * @return
     */
    @Override
    public int updateBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind bpc) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bpc.setUpdateBy(loginUser.getUsername());
        bpc.setUpdateTime(DateUtils.getNowDate());
        return businessParcelCompanyAbandonmentWindMapper.updateBusinessParcelCompanyAbandonmentWind(bpc);
    }

    /**
     * 修改分公司各风场弃风情况月度
     * 
     * @param bpc 分公司各风场弃风情况月度
     * @return 结果
     */
    @Override
    public int updateBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind bpc,Map<String,Double> sum)
    {
        String ac = bpc.getAbandonmentCompany();
        //通过下标选择对应的数据
        String electricity  = SelectLabel(ac,"月发电量");
//        String installation = SelectLabel(ac,"年装机量");
        String fgsInstallation = SelectLabel("6","年装机量");
        LoginUser loginUser = SecurityUtils.getLoginUser();
        bpc.setUpdateBy(loginUser.getUsername());
        bpc.setUpdateTime(DateUtils.getNowDate());
        Double calSum = new Double(0);
        if(sum.get(electricity)>0)calSum = new Double(bpc.getAbandonmentVolume())/(new Double(bpc.getAbandonmentVolume())+sum.get(electricity));
        calSum  = calSum*100;
        bpc.setAbandonmentRate(ToolUtils.size2(calSum));
        //查询所准备的对象
        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        //当前用户所选的天数and下标6的分公司数据
        select.setAbandonmentDate(bpc.getAbandonmentDate());
        select.setAbandonmentCompany("6");
        //调用查询查找
        List<BusinessParcelCompanyAbandonmentWind> selectList = this.selectBusinessParcelCompanyAbandonmentWindList(select);
        //获取分公司风电数据
        BusinessParcelCompanyAbandonmentWind fgs = selectList.get(0);
        String sumElectricity = sum.get(electricity).toString();
        String sumAbandonmentVolume = bpc.getAbandonmentVolume();
        String sumAbandonmentDate = bpc.getAbandonmentDate();
        String sumFgsInstallation = sum.get(fgsInstallation).toString();
        fgs = this.zhFgs(sumElectricity,sumAbandonmentVolume ,sumAbandonmentDate , sumFgsInstallation, fgs);
        this.updateBusinessParcelCompanyAbandonmentWind(fgs);
        BusinessFiveGroupAbandonmentWind selectBf = new BusinessFiveGroupAbandonmentWind();
        selectBf.setAbandonmentGroup("4");
        selectBf.setAbandonmentDate(sumAbandonmentDate);
        List<BusinessFiveGroupAbandonmentWind> bf  = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(selectBf);
        Double electricityVolume = sum.get("HNHN.WDSUM.MFDL.SKCAL");
        Double rate = Double.parseDouble(fgs.getAbandonmentRate());
        rate = rate*100;
        selectBf = bf.get(0);
        selectBf.setElectricityVolume(electricityVolume.toString());
        selectBf.setAbandonmentVolume(fgs.getAbandonmentVolume());
        selectBf.setAbandonmentRate(ToolUtils.size2(rate));
        selectBf.setUpdateBy(loginUser.getUsername());
        selectBf.setUpdateTime(DateUtils.getNowDate());
        businessFiveGroupAbandonmentWindMapper.updateBusinessFiveGroupAbandonmentWind(selectBf);

        selectBf.setAbandonmentGroup("5");
        selectBf.setAbandonmentDate(sumAbandonmentDate);
        bf  = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(selectBf);
        BusinessFiveGroupAbandonmentWind fiveBf = bf.get(0);
        //查询输入月份的全部数据
        selectBf.setAbandonmentGroup(null);
        selectBf.setAbandonmentDate(sumAbandonmentDate);
        bf  = businessFiveGroupAbandonmentWindMapper.selectBusinessFiveGroupAbandonmentWindList(selectBf);
        //组装五大集团数据
        fiveBf = BusinessFiveGroupAbandonmentWindServiceImpl.sum5(bf,fiveBf,null);
        //如果有id代表是修改，无id则是新增
        fiveBf.setUpdateBy(loginUser.getUsername());
        fiveBf.setUpdateTime(DateUtils.getNowDate());
        fiveBf.setStatus("1");
        businessFiveGroupAbandonmentWindMapper.updateBusinessFiveGroupAbandonmentWind(fiveBf);
        return businessParcelCompanyAbandonmentWindMapper.updateBusinessParcelCompanyAbandonmentWind(bpc);
    }

    /**
     * 批量删除分公司各风场弃风情况月度
     * 
     * @param ids 需要删除的分公司各风场弃风情况月度ID
     * @return 结果
     */
    @Override
    public int deleteBusinessParcelCompanyAbandonmentWindByIds(Long[] ids)
    {
        return businessParcelCompanyAbandonmentWindMapper.deleteBusinessParcelCompanyAbandonmentWindByIds(ids);
    }

    /**
     * 删除分公司各风场弃风情况月度信息
     * 
     * @param id 分公司各风场弃风情况月度ID
     * @return 结果
     */
    @Override
    public int deleteBusinessParcelCompanyAbandonmentWindById(Long id)
    {
        return businessParcelCompanyAbandonmentWindMapper.deleteBusinessParcelCompanyAbandonmentWindById(id);
    }

    @Override
    public Map<String, Object> selectByMonthOutPillar(String abandonmentDate) {
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        Map<String, Object> returnMap = new HashMap<>();
        List<String> abandonmentRateList = new ArrayList<>();
        List<String> abandonmentCompanyList = new ArrayList<>();
        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        select.setAbandonmentDate(abandonmentDate);
        List<BusinessParcelCompanyAbandonmentWind> selectList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
        List<Integer> companyCount = new ArrayList<>();
        for(BusinessParcelCompanyAbandonmentWind bpc : selectList){
            String ac = bpc.getAbandonmentCompany();
            companyCount.add(Integer.parseInt(ac));
            String abandonmentCompany = ac.equals("0")?"苏宝顶风电":ac.equals("1")?"桂东风电":ac.equals("2")?"连坪风电":ac.equals("3")?"梅桥风电":ac.equals("4")?"北湖风电":ac.equals("5")?"回龙圩风电":ac.equals("7")?"江口风电":"分公司风电";
            abandonmentRateList.add(ToolUtils.size2(bpc.getAbandonmentRate()));
            abandonmentCompanyList.add(abandonmentCompany);
        }
        for(Integer i =0;i<7;i++){
            Boolean bl = new Boolean(true);
            String companyName = i==0?"苏宝顶风电":i==1?"桂东风电":i==2?"连坪风电":i==3?"梅桥风电":i==4?"北湖风电":i==5?"回龙圩风电":i==6?"分公司风电":i==7?"江口风电":"";
            for (Integer count : companyCount) {
                if(i==count){
                    bl = false;
                }
            }
            if(bl){
                abandonmentRateList.add(ToolUtils.size2("0.00"));
                abandonmentCompanyList.add(companyName);
            }
        }
        returnMap.put("data",abandonmentRateList);
        returnMap.put("companydata",abandonmentCompanyList);
        returnMap.put("dateTime",abandonmentDate);
        return returnMap;
    }

    @Override
    public List<Map<String,String>> selectByMonthOutTable(String abandonmentDate) {
        List<Map<String,String>> returnList = new ArrayList<>();
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");

        Integer year = Integer.parseInt(abandonmentDate.substring(0,4));
        String yesteryearDate = (year-1)+"-"+abandonmentDate.substring(5,7);

        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        //去年
        select.setAbandonmentDate(yesteryearDate);
        List<BusinessParcelCompanyAbandonmentWind> selectLastList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
        Map<String,String> lastMap = new HashMap<>();
        for(BusinessParcelCompanyAbandonmentWind bpc :selectLastList){
            lastMap.put(bpc.getAbandonmentCompany(),bpc.getAbandonmentVolume());
        }
        //当前
        select.setAbandonmentDate(abandonmentDate);
        List<BusinessParcelCompanyAbandonmentWind> selectList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
        for(BusinessParcelCompanyAbandonmentWind bpc :selectList){
            Map<String,String> objMap = new HashMap<>();
            objMap.put("abandonmentDate",bpc.getAbandonmentDate());
            objMap.put("installationVolume",ToolUtils.size2(bpc.getInstallationVolume()));
            objMap.put("electricityVolume",ToolUtils.size2(bpc.getElectricityVolume()));
            objMap.put("abandonmentVolume",ToolUtils.size2(bpc.getAbandonmentVolume()));
            objMap.put("abandonmentRate",ToolUtils.size2(bpc.getAbandonmentRate()));
            Integer i = Integer.parseInt(bpc.getAbandonmentCompany());
            String companyName = i==0?"苏宝顶风电":i==1?"桂东风电":i==2?"连坪风电":i==3?"梅桥风电":i==4?"北湖风电":i==5?"回龙圩风电":i==6?"分公司风电":i==7?"江口风电":"";
            objMap.put("abandonmentCompany",companyName);
            String lastVolumeString = StringUtils.isEmpty(lastMap.get(bpc.getAbandonmentCompany()))?"0":lastMap.get(bpc.getAbandonmentCompany());
            Double lastVolume = new Double(lastVolumeString);
            Double volume = new Double(bpc.getAbandonmentVolume());
            Double lastRate = new Double(0);
            if(lastVolume>0)lastRate = ((volume/lastVolume)-1)*100;
            objMap.put("lastRate",ToolUtils.size2(lastRate.toString()));
            returnList.add(objMap);
        }
        return returnList;
    }

    @Override
    public Map<String, Object> selectByYearOutPillar(String abandonmentDate) {
        //定义返回对象
        Map<String, Object> returnMap = new HashMap<>();
        List<String> abandonmentRateList = new ArrayList<>();
        List<String> abandonmentCompanyList = new ArrayList<>();
        //获得日期
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        Integer year = Integer.parseInt(abandonmentDate.substring(0,4));
        Integer month = Integer.parseInt(abandonmentDate.substring(5,7));
        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        select.setAbandonmentDate(year+"-"+(month.toString().length()<2?"0"+month:month.toString()));
        List<BusinessParcelCompanyAbandonmentWind> countList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
        if(countList!=null&&countList.size()>6){
            for(Integer i =6;i>=0;i--){
                select.setAbandonmentCompany(i.toString());
                String ac = i.toString();
                String abandonmentCompany = ac.equals("0")?"苏宝顶风电":ac.equals("1")?"桂东风电":ac.equals("2")?"连坪风电":ac.equals("3")?"梅桥风电":ac.equals("4")?"北湖风电":ac.equals("5")?"回龙圩风电":ac.equals("7")?"江口风电":"分公司风电";
                abandonmentCompanyList.add(abandonmentCompany);
                Double electricityVolume = new Double(0);
                Double abandonmentVolume = new Double(0);

                for(Integer dateTime =1;dateTime<=month;dateTime++){
                    select.setAbandonmentDate(year.toString()+"-"+(dateTime.toString().length()<2?"0"+dateTime:dateTime.toString()));
                    //查询
                    List<BusinessParcelCompanyAbandonmentWind> selectList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
                    for(BusinessParcelCompanyAbandonmentWind bpc : selectList){
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
        //转译
        returnMap.put("data",abandonmentRateList);
        returnMap.put("companydata",abandonmentCompanyList);
        returnMap.put("dateTime",abandonmentDate);
        return returnMap;
    }

    @Override
    public List<Map<String,String>> selectByYearOutTable(String abandonmentDate) {
        //返回对象
        List<Map<String,String>> returnList = new ArrayList<>();
        //获得日期
        abandonmentDate = ToolUtils.defaultLastMonth(abandonmentDate,"3");
        //查询现在
        List<BusinessParcelCompanyAbandonmentWind> nowList = ByYearOutTable(abandonmentDate);
        //计算去年
        Integer year = Integer.parseInt(abandonmentDate.substring(0,4))-1;
        abandonmentDate = year.toString()+"-"+abandonmentDate.substring(5,7);
        //获取去年数据
        List<BusinessParcelCompanyAbandonmentWind> lastList = ByYearOutTable(abandonmentDate);
        //map集合
        Map<String,String> lastMap = new HashMap<>();
        for(BusinessParcelCompanyAbandonmentWind bpa : lastList){
            lastMap.put(bpa.getAbandonmentCompany(),bpa.getAbandonmentVolume());
        }
        for(BusinessParcelCompanyAbandonmentWind bpa : nowList){
            Map<String,String> map = new HashMap<>();
            map.put("abandonmentCompany",bpa.getAbandonmentCompany());
            map.put("installationVolume",bpa.getInstallationVolume());
            map.put("electricityVolume",bpa.getElectricityVolume());
            map.put("abandonmentVolume",ToolUtils.size2(bpa.getAbandonmentVolume()));
            map.put("abandonmentRate",bpa.getAbandonmentRate());

            Double nowVolume = new Double(bpa.getAbandonmentVolume());
            String lastVolumeString = StringUtils.isEmpty(lastMap.get(bpa.getAbandonmentCompany()))?"0":lastMap.get(bpa.getAbandonmentCompany());
            Double lastVolume = new Double(lastVolumeString);
            Double lastRate = new Double(0);
            if(lastVolume>0){
                lastRate = ((nowVolume/lastVolume)-1)*100;
            }
            map.put("lastRate",ToolUtils.size2(lastRate.toString()));
            returnList.add(map);
        }
        return returnList;
    }
    private List<BusinessParcelCompanyAbandonmentWind> ByYearOutTable(String abandonmentDate) {
        //返回对象
        List<BusinessParcelCompanyAbandonmentWind> returnList = new ArrayList<>();
        Integer year = Integer.parseInt(abandonmentDate.substring(0,4));
        Integer month = Integer.parseInt(abandonmentDate.substring(5,7));
        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        select.setAbandonmentDate(year+"-"+(month.toString().length()<2?"0"+month:month.toString()));
        List<BusinessParcelCompanyAbandonmentWind> countList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
        if(countList!=null&&countList.size()>6){
            for(Integer i =6;i>=0;i--){
                BusinessParcelCompanyAbandonmentWind listAdd = new BusinessParcelCompanyAbandonmentWind();
                String companyName = i==0?"苏宝顶风电":i==1?"桂东风电":i==2?"连坪风电":i==3?"梅桥风电":i==4?"北湖风电":i==5?"回龙圩风电":i==6?"分公司风电":i==7?"江口风电":"";
                listAdd.setAbandonmentCompany(companyName);
                Double electricityVolume = new Double(0);
                Double abandonmentVolume = new Double(0);
                Double abandonmentRate = new Double(0);
                //查询对象
                select.setAbandonmentCompany(i.toString());
                for(Integer dateTime =1;dateTime<=month;dateTime++) {
                    //日期条件
                    select.setAbandonmentDate(year.toString() + "-" + (dateTime.toString().length() < 2 ? "0" + dateTime : dateTime.toString()));
                    List<BusinessParcelCompanyAbandonmentWind> selectList = businessParcelCompanyAbandonmentWindMapper.selectBusinessParcelCompanyAbandonmentWindList(select);
                    //查询
                    for(BusinessParcelCompanyAbandonmentWind bpc : selectList){
                        electricityVolume += new Double(bpc.getElectricityVolume());
                        abandonmentVolume += new Double(bpc.getAbandonmentVolume());
                        if(bpc.getAbandonmentCompany().equals(i.toString())){
                            listAdd.setInstallationVolume(ToolUtils.size2(bpc.getInstallationVolume()));
                        }
                    }
                }
                listAdd.setElectricityVolume(ToolUtils.size2(electricityVolume.toString()));
                listAdd.setAbandonmentVolume(abandonmentVolume.toString());
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


    /**
     * 分公司数据装填
     * @param electricityVolume 通过用户选择日期中台查询的发电量
     * @param abandonmentVolume 用户输入的弃风电量
     * @param abandonmentDate 用户输入的日期
     * @param finstallationVolume 查询到的分公司装机
     * @param fgs 需要统计的分公司数据
     * @return 组装好的分公司数据
     */
    private BusinessParcelCompanyAbandonmentWind zhFgs(String electricityVolume,String abandonmentVolume,String abandonmentDate,String finstallationVolume,BusinessParcelCompanyAbandonmentWind fgs){
        BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
        //查询同年月的其他几条数据
        select.setAbandonmentDate(abandonmentDate);
        List<BusinessParcelCompanyAbandonmentWind> selectList = this.selectBusinessParcelCompanyAbandonmentWindList(select);
        //定义总和的参数
        Double fdsum = new Double(0);
        Double qfsum = new Double(0);
        //循环累加数据
        for(BusinessParcelCompanyAbandonmentWind bp:selectList){
            if(bp.getAbandonmentCompany().equals("6"))continue;
            fdsum +=new Double(bp.getElectricityVolume());
            qfsum +=new Double(bp.getAbandonmentVolume());
        }
        //加上新增的条
        fdsum +=new Double(electricityVolume);
        qfsum +=new Double(abandonmentVolume);
        //添加到分公司弃风中
        fgs.setElectricityVolume(ToolUtils.size2(fdsum.toString()));
        fgs.setAbandonmentVolume(ToolUtils.size2(qfsum.toString()));
        //计算弃风率
        Double abandonmentRate = new Double(0);
        if(fdsum>0)abandonmentRate = qfsum/(qfsum+fdsum);
        abandonmentRate = abandonmentRate*100;
        //添加到分公司弃风率中
        fgs.setAbandonmentRate(ToolUtils.size2(abandonmentRate));
        fgs.setInstallationVolume(finstallationVolume);
        return fgs;
    }
}
