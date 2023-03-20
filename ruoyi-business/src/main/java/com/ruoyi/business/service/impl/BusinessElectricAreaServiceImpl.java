package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.BusinessElectricArea;
import com.ruoyi.business.mapper.BusinessElectricAreaMapper;
import com.ruoyi.business.service.IBusinessElectricAreaService;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 区域发电总貌Service业务处理层
 * 
 * @author yrb
 * @date 2021-03-02
 */
@Service
public class BusinessElectricAreaServiceImpl implements IBusinessElectricAreaService
{
    @Autowired
    private BusinessElectricAreaMapper businessElectricAreaMapper;

    /**
     * 查询区域发电总貌
     * 
     * @param id 区域发电总貌ID
     * @return 区域发电总貌
     */
    @Override
    public BusinessElectricArea selectBusinessElectricAreaById(Long id)
    {
        return businessElectricAreaMapper.selectBusinessElectricAreaById(id);
    }

    /**
     * 查询区域发电总貌列表
     * 
     * @param businessElectricArea 区域发电总貌
     * @return 区域发电总貌
     */
    @Override
    public List<BusinessElectricArea> selectBusinessElectricAreaList(BusinessElectricArea businessElectricArea)
    {
        return businessElectricAreaMapper.selectBusinessElectricAreaList(businessElectricArea);
    }

    /**
     * 新增区域发电总貌
     * 
     * @param businessElectricArea 区域发电总貌
     * @return 结果
     */
    @Override
    public int insertBusinessElectricArea(BusinessElectricArea businessElectricArea)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricArea.setCreateBy(loginUser.getUsername());
        businessElectricArea.setCreateTime(new Date());
        businessElectricArea.setStatus("1");
        businessElectricArea.setCreateTime(DateUtils.getNowDate());
        businessElectricArea = statistics(businessElectricArea);
        return businessElectricAreaMapper.insertBusinessElectricArea(businessElectricArea);
    }

    /**
     * 修改区域发电总貌
     * 
     * @param businessElectricArea 区域发电总貌
     * @return 结果
     */
    @Override
    public int updateBusinessElectricArea(BusinessElectricArea businessElectricArea)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricArea.setUpdateBy(loginUser.getUsername());
        businessElectricArea.setUpdateTime(new Date());
        businessElectricArea = statistics(businessElectricArea);
        businessElectricArea.setUpdateTime(DateUtils.getNowDate());
        return businessElectricAreaMapper.updateBusinessElectricArea(businessElectricArea);
    }

    /**
     * 批量删除区域发电总貌
     * 
     * @param ids 需要删除的区域发电总貌ID集合
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricAreaByIds(Long[] ids)
    {
        return businessElectricAreaMapper.deleteBusinessElectricAreaByIds(ids);
    }

    /**
     * 删除区域发电总貌信息
     * 
     * @param id 区域发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricAreaById(Long id)
    {
        return businessElectricAreaMapper.deleteBusinessElectricAreaById(id);
    }

    private BusinessElectricArea statistics(BusinessElectricArea businessElectricArea){
        BigDecimal fire  = null;
        BigDecimal water = null;
        BigDecimal wind = null;
        BigDecimal light = null;
        if(businessElectricArea.getGenerateCapacityFire()!= null)fire = new BigDecimal(businessElectricArea.getGenerateCapacityFire());
        if(businessElectricArea.getGenerateCapacityWater()!= null)water = new BigDecimal(businessElectricArea.getGenerateCapacityWater());
        if(businessElectricArea.getGenerateCapacityWind()!= null)wind = new BigDecimal(businessElectricArea.getGenerateCapacityWind());
        if(businessElectricArea.getGenerateCapacityLight()!= null)light = new BigDecimal(businessElectricArea.getGenerateCapacityLight());
        BigDecimal generateCapacity = new BigDecimal("0");
        if(fire!=null)generateCapacity = generateCapacity.add(fire);
        if(water!=null)generateCapacity = generateCapacity.add(water);
        if(wind!=null)generateCapacity = generateCapacity.add(wind);
        if(light!=null)generateCapacity = generateCapacity.add(light);
        businessElectricArea.setGenerateCapacity(generateCapacity.toString());
        return businessElectricArea;
    }
}
