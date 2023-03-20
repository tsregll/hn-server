package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentProjectConfirmationMapper;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectConfirmation;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentProjectConfirmationService;

/**
 * 规划发展项目详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-15
 */
@Service
public class BusinessPlanningDevelopmentProjectConfirmationServiceImpl implements IBusinessPlanningDevelopmentProjectConfirmationService 
{
    @Autowired
    private BusinessPlanningDevelopmentProjectConfirmationMapper businessPlanningDevelopmentProjectConfirmationMapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展项目详情
     * 
     * @param id 规划发展项目详情ID
     * @return 规划发展项目详情
     */
    @Override
    public BusinessPlanningDevelopmentProjectConfirmation selectBusinessPlanningDevelopmentProjectConfirmationById(Long id)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        loginUser.getUsername();
//        loginUser.getUser().getUserId();
        BusinessPlanningDevelopmentProjectConfirmation returnResult=businessPlanningDevelopmentProjectConfirmationMapper.selectBusinessPlanningDevelopmentProjectConfirmationById(id);
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String temp = returnResult.getArea();
        String head=temp==null?"":temp.substring(0,3);
        String end=temp==null?"":temp.substring(3);
        returnResult.setArea(head+"/"+end);
        return returnResult;
//        return businessPlanningDevelopmentProjectConfirmationMapper.selectBusinessPlanningDevelopmentProjectConfirmationById(id);
    }

    /**
     * 查询规划发展项目详情
     *

     * @return 规划发展项目详情
     */
    @Override
    public BusinessPlanningDevelopmentProjectConfirmation selectBusinessPlanningDevelopmentProjectConfirmationByVoid()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        loginUser.getUsername();
//        loginUser.getUser().getUserId();
        BusinessPlanningDevelopmentProjectConfirmation returnResult=new BusinessPlanningDevelopmentProjectConfirmation();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
//        return businessPlanningDevelopmentProjectConfirmationMapper.selectBusinessPlanningDevelopmentProjectConfirmationById(id);
    }
    /**
     * 查询规划发展项目详情列表
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 规划发展项目详情
     */
    @Override
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessPlanningDevelopmentProjectConfirmationList(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        List<BusinessPlanningDevelopmentProjectConfirmation> returnList = businessPlanningDevelopmentProjectConfirmationMapper.selectBusinessPlanningDevelopmentProjectConfirmationList(businessPlanningDevelopmentProjectConfirmation);
        if(returnList.size()>0){
            List<BusinessPlanningDevelopmentProjectConfirmation> totalList = selectBusinessProjectConfirmationTotalList(businessPlanningDevelopmentProjectConfirmation);
            BusinessPlanningDevelopmentProjectConfirmation parameter = totalList.get(0);
            parameter.setProjectName("合计：");
            returnList.add(parameter);
        }
        if(returnList.size()>0 &&returnList.size()<1000){
            Integer id = 1;
            for(BusinessPlanningDevelopmentProjectConfirmation p:returnList){
                p.setStatus(id.toString());
                id++;
            }
        }
        return returnList;
    }
    @Override
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessPlanningDevelopmentProjectConfirmationList2(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        List<BusinessPlanningDevelopmentProjectConfirmation> returnList = businessPlanningDevelopmentProjectConfirmationMapper.selectBusinessPlanningDevelopmentProjectConfirmationList(businessPlanningDevelopmentProjectConfirmation);
        if(returnList.size()>0){
            BusinessPlanningDevelopmentProjectConfirmation parameter = new BusinessPlanningDevelopmentProjectConfirmation();
            String temp = "0";
            Double tempInt = new Double(0);
            for(BusinessPlanningDevelopmentProjectConfirmation p:returnList){
                tempInt=Double.parseDouble(p.getCapacity())+tempInt;
            }
            parameter.setCapacity(tempInt.toString());
            parameter.setProjectName("合计：");
            returnList.add(parameter);
        }
        if(returnList.size()>0){
            Integer id = 1;
            for(BusinessPlanningDevelopmentProjectConfirmation p:returnList){
                p.setStatus(id.toString());
                id++;
            }
        }
        return returnList;
    }

    @Override
    public List<BusinessPlanningDevelopmentProjectConfirmation> selectBusinessProjectConfirmationTotalList(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation) {
        return businessPlanningDevelopmentProjectConfirmationMapper.selectBusinessProjectConfirmationTotalList(businessPlanningDevelopmentProjectConfirmation);
    }

    /**
     * 新增规划发展项目详情
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 结果
     */
    @Override
    public int insertBusinessPlanningDevelopmentProjectConfirmation(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        businessPlanningDevelopmentProjectConfirmation.setCreateTime(DateUtils.getNowDate());
        if(null==businessPlanningDevelopmentProjectConfirmation.getInvestmentTime()||"".equals(businessPlanningDevelopmentProjectConfirmation.getInvestmentTime())) businessPlanningDevelopmentProjectConfirmation.setInvestmentTime("/");
        if(null==businessPlanningDevelopmentProjectConfirmation.getCheckTime()||"".equals(businessPlanningDevelopmentProjectConfirmation.getCheckTime())) businessPlanningDevelopmentProjectConfirmation.setInvestmentTime("/");
        if(null==businessPlanningDevelopmentProjectConfirmation.getEnablementTime()||"".equals(businessPlanningDevelopmentProjectConfirmation.getEnablementTime())) businessPlanningDevelopmentProjectConfirmation.setInvestmentTime("/");
        return businessPlanningDevelopmentProjectConfirmationMapper.insertBusinessPlanningDevelopmentProjectConfirmation(businessPlanningDevelopmentProjectConfirmation);
    }

    /**
     * 修改规划发展项目详情
     * 
     * @param businessPlanningDevelopmentProjectConfirmation 规划发展项目详情
     * @return 结果
     */
    @Override
    public int updateBusinessPlanningDevelopmentProjectConfirmation(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        businessPlanningDevelopmentProjectConfirmation.setUpdateTime(DateUtils.getNowDate());
        return businessPlanningDevelopmentProjectConfirmationMapper.updateBusinessPlanningDevelopmentProjectConfirmation(businessPlanningDevelopmentProjectConfirmation);
    }

    /**
     * 批量删除规划发展项目详情
     * 
     * @param ids 需要删除的规划发展项目详情ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentProjectConfirmationByIds(Long[] ids)
    {
        return businessPlanningDevelopmentProjectConfirmationMapper.deleteBusinessPlanningDevelopmentProjectConfirmationByIds(ids);
    }

    /**
     * 删除规划发展项目详情信息
     * 
     * @param id 规划发展项目详情ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentProjectConfirmationById(Long id)
    {
        return businessPlanningDevelopmentProjectConfirmationMapper.deleteBusinessPlanningDevelopmentProjectConfirmationById(id);
    }

    @Override
    public String importDatas(List<BusinessPlanningDevelopmentProjectConfirmation> bsce) {
        if(StringUtils.isEmpty(bsce)||bsce.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        Date time = new Date();
        for (BusinessPlanningDevelopmentProjectConfirmation bsc:bsce) {
            String industryType = bsc.getProjectType();
            industryType = industryType.equals("0")?"风电":"光伏";
            String remark = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(time);
            try {
                String date = bsc.getEnablementTime();
                String date1 = bsc.getInvestmentTime();
                String date2 = bsc.getCheckTime();
                if(date.length()>7) {
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
//                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
//                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
//                    date = year + "-" + (month.length() < 2 ? "0" + month : month);
                    date = new SimpleDateFormat("yyyy-MM-dd").format(dates);
                    bsc.setEnablementTime(date);
                }
                if(date1.length()>7) {
                    Date dates1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date1);
//                    String year1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
//                    String month1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
//                    date1 = year1 + "-" + (month1.length() < 2 ? "0" + month1 : month1);
                    date1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates1))+"";
                    bsc.setEnablementTime(date1);
                }
                if(date2.length()>7) {
                    Date dates2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date2);
//                    String year2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
//                    String month2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
//                    date2 = year2 + "-" + (month2.length() < 2 ? "0" + month2 : month2);
                    date2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates2))+"";
                    bsc.setEnablementTime(date2);
                }
                // 录入时间
                bsc.setRemark(remark);
//                BusinessPlanningDevelopmentProjectConfirmation select = new BusinessPlanningDevelopmentProjectConfirmation();
//                select.setEnablementTime(date);
//                select.setIndustryType(bsc.getIndustryType());
                int count = this.selectBusinessPlanningDevelopmentProjectConfirmationList(bsc).size();
                if(count>0){
                    continue;
                }
                bsc.setOperator(loginUser.getUser().getNickName());
                bsc.setOperatorNumber(loginUser.getUser().getUserName());

                this.insertBusinessPlanningDevelopmentProjectConfirmation(bsc);
                successNum++;
                successMsg.append("<br/>" + remark+"的"+industryType + " 导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + remark + "的" + industryType + " 导入失败：";
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
