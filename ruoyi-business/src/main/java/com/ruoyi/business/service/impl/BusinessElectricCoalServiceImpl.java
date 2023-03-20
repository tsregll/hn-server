package com.ruoyi.business.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.business.domain.BusinessElectricArea;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessElectricCoalMapper;
import com.ruoyi.business.domain.BusinessElectricCoal;
import com.ruoyi.business.service.IBusinessElectricCoalService;

/**
 * 煤机发电总貌Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessElectricCoalServiceImpl implements IBusinessElectricCoalService 
{
    @Autowired
    private BusinessElectricCoalMapper businessElectricCoalMapper;

    /**
     * 查询煤机发电总貌
     * 
     * @param id 煤机发电总貌ID
     * @return 煤机发电总貌
     */
    @Override
    public BusinessElectricCoal selectBusinessElectricCoalById(Long id)
    {
        return businessElectricCoalMapper.selectBusinessElectricCoalById(id);
    }

    /**
     * 查询煤机发电总貌列表
     * 
     * @param businessElectricCoal 煤机发电总貌
     * @return 煤机发电总貌
     */
    @Override
    public List<BusinessElectricCoal> selectBusinessElectricCoalList(BusinessElectricCoal businessElectricCoal)
    {
        return businessElectricCoalMapper.selectBusinessElectricCoalList(businessElectricCoal);
    }

    /**
     * 新增煤机发电总貌
     * 
     * @param businessElectricCoal 煤机发电总貌
     * @return 结果
     */
    @Override
    public int insertBusinessElectricCoal(BusinessElectricCoal businessElectricCoal)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricCoal.setCreateBy(loginUser.getUsername());
        businessElectricCoal.setCreateTime(new Date());
        businessElectricCoal.setStatus("1");
        businessElectricCoal = statistics(businessElectricCoal);
        businessElectricCoal.setCreateTime(DateUtils.getNowDate());
        return businessElectricCoalMapper.insertBusinessElectricCoal(businessElectricCoal);
    }

    /**
     * 修改煤机发电总貌
     * 
     * @param businessElectricCoal 煤机发电总貌
     * @return 结果
     */
    @Override
    public int updateBusinessElectricCoal(BusinessElectricCoal businessElectricCoal)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricCoal.setUpdateBy(loginUser.getUsername());
        businessElectricCoal.setUpdateTime(new Date());
        businessElectricCoal = statistics(businessElectricCoal);
        businessElectricCoal.setUpdateTime(DateUtils.getNowDate());
        return businessElectricCoalMapper.updateBusinessElectricCoal(businessElectricCoal);
    }

    /**
     * 批量删除煤机发电总貌
     * 
     * @param ids 需要删除的煤机发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricCoalByIds(Long[] ids)
    {
        return businessElectricCoalMapper.deleteBusinessElectricCoalByIds(ids);
    }

    /**
     * 删除煤机发电总貌信息
     * 
     * @param id 煤机发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricCoalById(Long id)
    {
        return businessElectricCoalMapper.deleteBusinessElectricCoalById(id);
    }

    private BusinessElectricCoal statistics(BusinessElectricCoal businessElectricCoal){
        BigDecimal first = null;
        BigDecimal second = null;
        BigDecimal thirdly = null;
        if(businessElectricCoal.getGenerateCapacityFirst() != null)first = new BigDecimal(businessElectricCoal.getGenerateCapacityFirst());
        if(businessElectricCoal.getGenerateCapacitySecond() != null)second = new BigDecimal(businessElectricCoal.getGenerateCapacitySecond());
        if(businessElectricCoal.getGenerateCapacityThirdly() != null)thirdly = new BigDecimal(businessElectricCoal.getGenerateCapacityThirdly());
        BigDecimal generateCapacity = new BigDecimal("0");
        if(first!=null)generateCapacity = generateCapacity.add(first);
        if(second!=null)generateCapacity = generateCapacity.add(second);
        if(thirdly!=null)generateCapacity = generateCapacity.add(thirdly);
        businessElectricCoal.setGenerateCapacity(generateCapacity.toString());
        return businessElectricCoal;
    }
}
