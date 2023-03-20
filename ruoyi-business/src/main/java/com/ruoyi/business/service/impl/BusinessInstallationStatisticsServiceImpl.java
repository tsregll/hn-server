package com.ruoyi.business.service.impl;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.BusinessElectricArea;
import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.BusinessInstallationStatisticsVo;
import com.ruoyi.business.vo.StatisticsFiveVo;
import com.ruoyi.business.vo.StatisticsVo;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.service.impl.BaseServiceImpl;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessInstallationStatisticsMapper;
import com.ruoyi.business.domain.BusinessInstallationStatistics;
import com.ruoyi.business.service.IBusinessInstallationStatisticsService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 装机统计Service业务层处理
 *
 * @author yrb
 * @date 2021-03-10
 */
@Service
public class BusinessInstallationStatisticsServiceImpl extends BaseServiceImpl<BusinessInstallationStatistics> implements IBusinessInstallationStatisticsService {

    @Autowired
    private BusinessInstallationStatisticsMapper businessInstallationStatisticsMapper;

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    /**
     * 查询装机统计
     *
     * @param id 装机统计ID
     * @return 装机统计
     */
    @Override
    public BusinessInstallationStatistics selectBusinessInstallationStatisticsById(Long id) {
        return businessInstallationStatisticsMapper.selectBusinessInstallationStatisticsById(id);
    }

    @Override
    public String importDatas(List<BusinessInstallationStatistics> list) {
        if(StringUtils.isEmpty(list)||list.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessInstallationStatistics bis:list) {
            String installationType = bis.getInstallationType();
            installationType = installationType.equals("0")?"湖南电网":installationType.equals("1")?"统调":"非统调";
            try {
                String date = bis.getEnteringDate();
                if(date.length()>7) {
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
                    date = year + "-" + (month.length() < 2 ? "0" + month : month);
                    bis.setEnteringDate(date);
                }
                BusinessInstallationStatistics select = new BusinessInstallationStatistics();
                select.setEnteringDate(date);
                select.setInstallationType(bis.getInstallationType());
                int count = this.selectBusinessInstallationStatisticsList(select).size();
                if(count>0){
                    continue;
                }

                this.insertBusinessInstallationStatistics(bis);
                successNum++;
                successMsg.append("<br/>" + bis.getEnteringDate()+"的"+installationType + " 导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + bis.getEnteringDate() + "的 " + installationType + " 导入失败：";
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
     * 查询装机统计列表
     *
     * @param businessInstallationStatistics 装机统计
     * @return 装机统计
     */
    @Override
    public List<BusinessInstallationStatistics> selectBusinessInstallationStatisticsList(BusinessInstallationStatistics businessInstallationStatistics) {
        List<BusinessInstallationStatistics> selectList = businessInstallationStatisticsMapper.selectBusinessInstallationStatisticsListOrderByDateTime(businessInstallationStatistics);
        for(BusinessInstallationStatistics bi : selectList){
            bi.setInstallationAll(ToolUtils.size4(bi.getInstallationAll()));
            bi.setInstallationWater(ToolUtils.size4(bi.getInstallationWater()));
            bi.setInstallationFire(ToolUtils.size4(bi.getInstallationFire()));
            bi.setInstallationWind(ToolUtils.size4(bi.getInstallationWind()));
            bi.setInstallationLight(ToolUtils.size4(bi.getInstallationLight()));
        }
        return selectList;
    }

    @Override
    public List<BusinessInstallationStatistics> selectByTimeInstallationStatisticsList(BusinessInstallationStatistics businessInstallationStatistics) {
        List<BusinessInstallationStatistics> selectList = businessInstallationStatisticsMapper.selectByTimeInstallationStatisticsList(businessInstallationStatistics);
        for(BusinessInstallationStatistics bi : selectList){
            bi.setInstallationAll(ToolUtils.size4(bi.getInstallationAll()));
            bi.setInstallationWater(ToolUtils.size4(bi.getInstallationWater()));
            bi.setInstallationFire(ToolUtils.size4(bi.getInstallationFire()));
            bi.setInstallationWind(ToolUtils.size4(bi.getInstallationWind()));
            bi.setInstallationLight(ToolUtils.size4(bi.getInstallationLight()));
        }
        return selectList;
    }

    /**
     * 新增装机统计
     *
     * @param businessInstallationStatistics 装机统计
     * @return 结果
     */
    @Override
    public int insertBusinessInstallationStatistics(BusinessInstallationStatistics businessInstallationStatistics) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessInstallationStatistics.setCreateBy(loginUser.getUsername());
        businessInstallationStatistics.setStatus("1");
        businessInstallationStatistics.setCreateTime(DateUtils.getNowDate());
        Double all = new Double("0");
        if(businessInstallationStatistics.getInstallationFire()!=null)all += Double.parseDouble(businessInstallationStatistics.getInstallationFire());
        if(businessInstallationStatistics.getInstallationWind()!=null)all += Double.parseDouble(businessInstallationStatistics.getInstallationWind());
        if(businessInstallationStatistics.getInstallationWater()!=null)all += Double.parseDouble(businessInstallationStatistics.getInstallationWater());
        if(businessInstallationStatistics.getInstallationLight()!=null)all += Double.parseDouble(businessInstallationStatistics.getInstallationLight());
        businessInstallationStatistics.setInstallationAll(all + "");
        return businessInstallationStatisticsMapper.insertBusinessInstallationStatistics(businessInstallationStatistics);
    }

    /**
     * 修改装机统计
     *
     * @param businessInstallationStatistics 装机统计
     * @return 结果
     */
    @Override
    public int updateBusinessInstallationStatistics(BusinessInstallationStatistics businessInstallationStatistics) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessInstallationStatistics.setUpdateBy(loginUser.getUsername());
        businessInstallationStatistics.setUpdateTime(DateUtils.getNowDate());
        Double all = new Double("0");
        all += Double.parseDouble(businessInstallationStatistics.getInstallationFire());
        all += Double.parseDouble(businessInstallationStatistics.getInstallationWind());
        all += Double.parseDouble(businessInstallationStatistics.getInstallationWater());
        all += Double.parseDouble(businessInstallationStatistics.getInstallationLight());
        businessInstallationStatistics.setInstallationAll(all + "");
        return businessInstallationStatisticsMapper.updateBusinessInstallationStatistics(businessInstallationStatistics);
    }

    /**
     * 批量删除装机统计
     *
     * @param ids 需要删除的装机统计ID
     * @return 结果
     */
    @Override
    public int deleteBusinessInstallationStatisticsByIds(Long[] ids) {
        return businessInstallationStatisticsMapper.deleteBusinessInstallationStatisticsByIds(ids);
    }

    /**
     * 删除装机统计信息
     *
     * @param id 装机统计ID
     * @return 结果
     */
    @Override
    public int deleteBusinessInstallationStatisticsById(Long id) {
        return businessInstallationStatisticsMapper.deleteBusinessInstallationStatisticsById(id);
    }

    /**
     * 装机统计表（月度表格）
     *
     * @param businessInstallationStatistics 装机统计
     * @return 统调装机统计Vo
     */
    @Override
    public Map<String,Object> selectStatistics(BusinessInstallationStatistics businessInstallationStatistics) {
        //获取用户输入的年月（未输入自动选择当月）
        String enteringDate = businessInstallationStatistics.getEnteringDate();
        if (enteringDate == null||enteringDate.trim().equals("")) {
            if(LocalDate.now().getMonthValue()<2){
                enteringDate = (LocalDate.now().getYear()-1) + "-12";
            }else{
                String month = (LocalDate.now().getMonthValue()-1) + "";
                month = month.length() < 2 ? "0" + month : month;
                enteringDate = LocalDate.now().getYear() + "-" + month;
            }
        }
//        LocalDate.parse("2019-5-10",DateTimeFormatter.ofPattern("yyyy-M-d"))
        businessInstallationStatistics.setEnteringDate(enteringDate);
        String returnDate = enteringDate;
        //查询当前年月数据
        List<BusinessInstallationStatistics> selectList = businessInstallationStatisticsMapper.selectBusinessInstallationStatisticsList(businessInstallationStatistics);
        //格式一下年月(yyyy-MM-dd)
        //计算去年的月份(yyyy-MM)
        enteringDate = (Integer.parseInt(enteringDate.substring(0, 4)) - 1) + "-" + enteringDate.substring(5, 7);
        //填入参数
        businessInstallationStatistics.setEnteringDate(enteringDate);
        //查询去年同月结果
        List<BusinessInstallationStatistics> selectLastList = businessInstallationStatisticsMapper.selectBusinessInstallationStatisticsList(businessInstallationStatistics);

        //-----------------
        //定义返回层vo
        BusinessInstallationStatisticsVo vo1 = new BusinessInstallationStatisticsVo();
        vo1.setDataType("光伏");
        BusinessInstallationStatisticsVo vo2 = new BusinessInstallationStatisticsVo();
        vo2.setDataType("风电");
        BusinessInstallationStatisticsVo vo3 = new BusinessInstallationStatisticsVo();
        vo3.setDataType("火电");
        BusinessInstallationStatisticsVo vo4 = new BusinessInstallationStatisticsVo();
        vo4.setDataType("水电");
        BusinessInstallationStatisticsVo vo5 = new BusinessInstallationStatisticsVo();
        vo5.setDataType("合计");
        //-----------------
        for (BusinessInstallationStatistics i : selectList) {
            if (i.getInstallationType().equals("0")) {
                vo1.setInstallationTypeHndw(ToolUtils.size4(i.getInstallationLight()));
                vo2.setInstallationTypeHndw(ToolUtils.size4(i.getInstallationWind()));
                vo3.setInstallationTypeHndw(ToolUtils.size4(i.getInstallationFire()));
                vo4.setInstallationTypeHndw(ToolUtils.size4(i.getInstallationWater()));
                vo5.setInstallationTypeHndw(ToolUtils.size4(i.getInstallationAll()));
            } else if (i.getInstallationType().equals("2")) {
                vo1.setInstallationTypeFtd(ToolUtils.size4(i.getInstallationLight()));
                vo2.setInstallationTypeFtd(ToolUtils.size4(i.getInstallationWind()));
                vo3.setInstallationTypeFtd(ToolUtils.size4(i.getInstallationFire()));
                vo4.setInstallationTypeFtd(ToolUtils.size4(i.getInstallationWater()));
                vo5.setInstallationTypeFtd(ToolUtils.size4(i.getInstallationAll()));
            } else {
                vo1.setInstallationTypeTd(ToolUtils.size4(i.getInstallationLight()));
                vo2.setInstallationTypeTd(ToolUtils.size4(i.getInstallationWind()));
                vo3.setInstallationTypeTd(ToolUtils.size4(i.getInstallationFire()));
                vo4.setInstallationTypeTd(ToolUtils.size4(i.getInstallationWater()));
                vo5.setInstallationTypeTd(ToolUtils.size4(i.getInstallationAll()));
            }
        }
        for (BusinessInstallationStatistics last : selectLastList) {
            if (last.getInstallationType().equals("0")) {
                vo1.setLastInstallationTypeHndw(ToolUtils.size4(last.getInstallationLight()));
                vo2.setLastInstallationTypeHndw(ToolUtils.size4(last.getInstallationWind()));
                vo3.setLastInstallationTypeHndw(ToolUtils.size4(last.getInstallationFire()));
                vo4.setLastInstallationTypeHndw(ToolUtils.size4(last.getInstallationWater()));
                vo5.setLastInstallationTypeHndw(ToolUtils.size4(last.getInstallationAll()));
            } else if (last.getInstallationType().equals("2")) {
                vo1.setLastInstallationTypeFtd(ToolUtils.size4(last.getInstallationLight()));
                vo2.setLastInstallationTypeFtd(ToolUtils.size4(last.getInstallationWind()));
                vo3.setLastInstallationTypeFtd(ToolUtils.size4(last.getInstallationFire()));
                vo4.setLastInstallationTypeFtd(ToolUtils.size4(last.getInstallationWater()));
                vo5.setLastInstallationTypeFtd(ToolUtils.size4(last.getInstallationAll()));
            } else {
                vo1.setLastInstallationTypeTd(ToolUtils.size4(last.getInstallationLight()));
                vo2.setLastInstallationTypeTd(ToolUtils.size4(last.getInstallationWind()));
                vo3.setLastInstallationTypeTd(ToolUtils.size4(last.getInstallationFire()));
                vo4.setLastInstallationTypeTd(ToolUtils.size4(last.getInstallationWater()));
                vo5.setLastInstallationTypeTd(ToolUtils.size4(last.getInstallationAll()));
            }
        }

        List<BusinessInstallationStatisticsVo> list = new ArrayList<BusinessInstallationStatisticsVo>();
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        list.add(vo5);
        Map<String,Object>returnMap = new HashMap<>();
        returnMap.put("dateTime",returnDate);
        returnMap.put("data",list);
        return returnMap;
    }

    /**
     * 查询近5年的统计图
     *
     * @return 近五年的统计图数据
     */
    @Override
    public Map<String,Object> selectFiveInstallationStatisticsByYear(BusinessInstallationStatistics bs) {
        String type = bs.getInstallationType();
        if(type == null || type.trim().equals("")){
            type = "0";
            bs.setInstallationType(type);
        }
        Map<String,Object> returnMap = new HashMap<>();
        List<Map<String,Object>> returnList = new ArrayList<>();
        List<String> returnListYear = new ArrayList<>();
        String year = "";
        int ld = LocalDate.now().getYear() - 4;
        Map<String,Object> mapWater = new HashMap<>();
        mapWater.put("name","水电");
        mapWater.put("type","bar");
        mapWater.put("stack","总量");
        Map<String,Object> mapFire = new HashMap<>();
        mapFire.put("name","火电");
        mapFire.put("type","bar");
        mapFire.put("stack","总量");
        Map<String,Object> mapWind = new HashMap<>();
        mapWind.put("name","风电");
        mapWind.put("type","bar");
        mapWind.put("stack","总量");
        Map<String,Object> mapLight = new HashMap<>();
        mapLight.put("name","太阳能");
        mapLight.put("type","bar");
        mapLight.put("stack","总量");
        List<String> installationWater = new ArrayList<>();
        List<String> installationFire = new ArrayList<>();
        List<String> installationWind = new ArrayList<>();
        List<String> installationLight = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            year = (ld + i) + "";
            returnListYear.add(year);
            bs.setEnteringDate(year+"-12");
            List<BusinessInstallationStatistics> object = businessInstallationStatisticsMapper.selectFiveInstallationStatisticsByYear(bs);
            Double Water = new Double("0");
            Double Fire = new Double("0");
            Double Wind = new Double("0");
            Double Light = new Double("0");
            for (BusinessInstallationStatistics obj : object) {
                Water += obj.getInstallationWater() != null ? Double.parseDouble(obj.getInstallationWater()) : new Double("0");
                Fire += obj.getInstallationFire() != null ? Double.parseDouble(obj.getInstallationFire()) : new Double("0");
                Wind += obj.getInstallationWind() != null ? Double.parseDouble(obj.getInstallationWind()) : new Double("0");
                Light += obj.getInstallationLight() != null ? Double.parseDouble(obj.getInstallationLight()) : new Double("0");
            }
            installationWater.add(ToolUtils.size4(Water.toString()));
            installationFire.add(ToolUtils.size4(Fire.toString()));
            installationWind.add(ToolUtils.size4(Wind.toString()));
            installationLight.add(ToolUtils.size4(Light.toString()));
        }
        mapWater.put("data",installationWater);
        mapFire.put("data",installationFire);
        mapWind.put("data",installationWind);
        mapLight.put("data",installationLight);
        returnList.add(mapWater);
        returnList.add(mapFire);
        returnList.add(mapWind);
        returnList.add(mapLight);
        returnMap.put("datas",returnList);
        returnMap.put("years",returnListYear);
        return returnMap;
    }

    /**
     * 通过年or类型查询总和（饼状图）
     *
     * @param businessInstallationStatistics 查询条件对象
     * @return 数据
     */
    @Override
    public Map<String,Object> selectByYearOrType(BusinessInstallationStatistics businessInstallationStatistics) {
        String enteringDate = businessInstallationStatistics.getEnteringDate();
        if(enteringDate == null || enteringDate.trim().equals("")){
            enteringDate = (LocalDate.now().getYear()-1)+"";
        }
        String year = enteringDate;
        businessInstallationStatistics.setEnteringDate(year);
        businessInstallationStatistics = businessInstallationStatisticsMapper.selectByYearOrType(businessInstallationStatistics);
        List<StatisticsVo> returnVo = new ArrayList<>();
        StatisticsVo installationWater = new StatisticsVo();
        installationWater.setName("水电");
        StatisticsVo installationFire = new StatisticsVo();
        installationFire.setName("火电");
        StatisticsVo installationWind = new StatisticsVo();
        installationWind.setName("风电");
        StatisticsVo installationLight = new StatisticsVo();
        installationLight.setName("光伏");
        if(businessInstallationStatistics!=null){
            installationWater.setValue(ToolUtils.size4(businessInstallationStatistics.getInstallationWater()));
            installationFire.setValue(ToolUtils.size4(businessInstallationStatistics.getInstallationFire()));
            installationWind.setValue(ToolUtils.size4(businessInstallationStatistics.getInstallationWind()));
            installationLight.setValue(ToolUtils.size4(businessInstallationStatistics.getInstallationLight()));
        }else{
            installationWater.setValue("0");
            installationFire.setValue("0");
            installationWind.setValue("0");
            installationLight.setValue("0");
        }
        returnVo.add(installationWater);
        returnVo.add(installationFire);
        returnVo.add(installationWind);
        returnVo.add(installationLight);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("dateTime",year);
        returnMap.put("data",returnVo);
        return returnMap;
    }

    @Override
    public BusinessInstallationStatistics insertObject(BusinessInstallationStatistics entity) {
        this.insertBusinessInstallationStatistics(entity);
        return entity;
    }
}
