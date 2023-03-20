package com.ruoyi.business.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessStatisticsYueyangElectricityMapper;
import com.ruoyi.business.domain.BusinessStatisticsYueyangElectricity;
import com.ruoyi.business.service.IBusinessStatisticsYueyangElectricityService;

/**
 * 岳阳电厂计划曲线Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-13
 */
@Service
public class BusinessStatisticsYueyangElectricityServiceImpl implements IBusinessStatisticsYueyangElectricityService 
{
    @Autowired
    private BusinessStatisticsYueyangElectricityMapper businessStatisticsYueyangElectricityMapper;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询岳阳电厂计划曲线
     * 
     * @param id 岳阳电厂计划曲线ID
     * @return 岳阳电厂计划曲线
     */
    @Override
    public BusinessStatisticsYueyangElectricity selectBusinessStatisticsYueyangElectricityById(Long id)
    {
        BusinessStatisticsYueyangElectricity temp = businessStatisticsYueyangElectricityMapper.selectBusinessStatisticsYueyangElectricityById(id);
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        temp.setOperator(loginUser.getUser().getNickName());
        temp.setOperatorNumber(loginUser.getUser().getUserName());
        temp.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        temp.setKey0(ToolUtils.size2(temp.getKey0()));
        temp.setKey1(ToolUtils.size2(temp.getKey1()));
        temp.setKey2(ToolUtils.size2(temp.getKey2()));
        temp.setKey3(ToolUtils.size2(temp.getKey3()));
        temp.setKey4(ToolUtils.size2(temp.getKey4()));
        temp.setKey5(ToolUtils.size2(temp.getKey5()));
        temp.setKey6(ToolUtils.size2(temp.getKey6()));
        temp.setKey7(ToolUtils.size2(temp.getKey7()));
        temp.setKey8(ToolUtils.size2(temp.getKey8()));
        temp.setKey9(ToolUtils.size2(temp.getKey9()));
        temp.setKey10(ToolUtils.size2(temp.getKey10()));
        temp.setKey11(ToolUtils.size2(temp.getKey11()));
        temp.setKey12(ToolUtils.size2(temp.getKey12()));
        temp.setKey13(ToolUtils.size2(temp.getKey13()));
        temp.setKey14(ToolUtils.size2(temp.getKey14()));
        temp.setKey15(ToolUtils.size2(temp.getKey15()));
        temp.setKey16(ToolUtils.size2(temp.getKey16()));
        temp.setKey17(ToolUtils.size2(temp.getKey17()));
        temp.setKey18(ToolUtils.size2(temp.getKey18()));
        temp.setKey19(ToolUtils.size2(temp.getKey19()));
        temp.setKey20(ToolUtils.size2(temp.getKey20()));
        temp.setKey21(ToolUtils.size2(temp.getKey21()));
        temp.setKey22(ToolUtils.size2(temp.getKey22()));
        temp.setKey23(ToolUtils.size2(temp.getKey23()));
        temp.setKey24(ToolUtils.size2(temp.getKey24()));
        return temp;
    }

    /**
     * 查询岳阳电厂计划曲线列表
     * 
     * @param businessStatisticsYueyangElectricity 岳阳电厂计划曲线
     * @return 岳阳电厂计划曲线
     */
    @Override
    public List<BusinessStatisticsYueyangElectricity> selectBusinessStatisticsYueyangElectricityList(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        return businessStatisticsYueyangElectricityMapper.selectBusinessStatisticsYueyangElectricityList(businessStatisticsYueyangElectricity);
    }

    /**
     * 新增岳阳电厂计划曲线
     * 
     * @param businessStatisticsYueyangElectricity 岳阳电厂计划曲线
     * @return 结果
     */
    @Override
    public int insertBusinessStatisticsYueyangElectricity(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        businessStatisticsYueyangElectricity.setCreateTime(DateUtils.getNowDate());
        return businessStatisticsYueyangElectricityMapper.insertBusinessStatisticsYueyangElectricity(businessStatisticsYueyangElectricity);
    }

    /**
     * 修改岳阳电厂计划曲线
     * 
     * @param businessStatisticsYueyangElectricity 岳阳电厂计划曲线
     * @return 结果
     */
    @Override
    public int updateBusinessStatisticsYueyangElectricity(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        businessStatisticsYueyangElectricity.setUpdateTime(DateUtils.getNowDate());
        return businessStatisticsYueyangElectricityMapper.updateBusinessStatisticsYueyangElectricity(businessStatisticsYueyangElectricity);
    }

    /**
     * 批量删除岳阳电厂计划曲线
     * 
     * @param ids 需要删除的岳阳电厂计划曲线ID
     * @return 结果
     */
    @Override
    public int deleteBusinessStatisticsYueyangElectricityByIds(Long[] ids)
    {
        return businessStatisticsYueyangElectricityMapper.deleteBusinessStatisticsYueyangElectricityByIds(ids);
    }

    /**
     * 删除岳阳电厂计划曲线信息
     * 
     * @param id 岳阳电厂计划曲线ID
     * @return 结果
     */
    @Override
    public int deleteBusinessStatisticsYueyangElectricityById(Long id)
    {
        return businessStatisticsYueyangElectricityMapper.deleteBusinessStatisticsYueyangElectricityById(id);
    }

    @Override
    public List<BusinessStatisticsYueyangElectricity> changeOperatorToList(List<BusinessStatisticsYueyangElectricity> betcaw) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String preparationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String operatorNumber = loginUser.getUser().getUserName();
        String operator = loginUser.getUser().getNickName();
        List<BusinessStatisticsYueyangElectricity> returnList = betcaw;
        for (BusinessStatisticsYueyangElectricity temp : betcaw) {
            String dateTime = temp.getPreparationDate();
            if (dateTime.length() > 7) {
                Date dates = null;
                try {
                    dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(dateTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
                String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
                String day = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getDayOfMonth()+ "";
                dateTime = year + "-" + (month.length() < 2 ? "0" + month : month)+"-" + (day.length() < 2 ? "0" + day : day);
            }
            temp.setPreparationDate(dateTime);
            temp.setOperator(operator);
            temp.setOperatorNumber(operatorNumber);
            temp.setDefaultTime(preparationDate);
            temp.setKey0(ToolUtils.size2(temp.getKey0()));
            temp.setKey1(ToolUtils.size2(temp.getKey1()));
            temp.setKey2(ToolUtils.size2(temp.getKey2()));
            temp.setKey3(ToolUtils.size2(temp.getKey3()));
            temp.setKey4(ToolUtils.size2(temp.getKey4()));
            temp.setKey5(ToolUtils.size2(temp.getKey5()));
            temp.setKey6(ToolUtils.size2(temp.getKey6()));
            temp.setKey7(ToolUtils.size2(temp.getKey7()));
            temp.setKey8(ToolUtils.size2(temp.getKey8()));
            temp.setKey9(ToolUtils.size2(temp.getKey9()));
            temp.setKey10(ToolUtils.size2(temp.getKey10()));
            temp.setKey11(ToolUtils.size2(temp.getKey11()));
            temp.setKey12(ToolUtils.size2(temp.getKey12()));
            temp.setKey13(ToolUtils.size2(temp.getKey13()));
            temp.setKey14(ToolUtils.size2(temp.getKey14()));
            temp.setKey15(ToolUtils.size2(temp.getKey15()));
            temp.setKey16(ToolUtils.size2(temp.getKey16()));
            temp.setKey17(ToolUtils.size2(temp.getKey17()));
            temp.setKey18(ToolUtils.size2(temp.getKey18()));
            temp.setKey19(ToolUtils.size2(temp.getKey19()));
            temp.setKey20(ToolUtils.size2(temp.getKey20()));
            temp.setKey21(ToolUtils.size2(temp.getKey21()));
            temp.setKey22(ToolUtils.size2(temp.getKey22()));
            temp.setKey23(ToolUtils.size2(temp.getKey23()));
            temp.setKey24(ToolUtils.size2(temp.getKey24()));
        }
        return returnList;
    }
}
