package com.ruoyi.business.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessElectricWaterMapper;
import com.ruoyi.business.domain.BusinessElectricWater;
import com.ruoyi.business.service.IBusinessElectricWaterService;

/**
 * 水力发电总貌Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessElectricWaterServiceImpl implements IBusinessElectricWaterService 
{
    @Autowired
    private BusinessElectricWaterMapper businessElectricWaterMapper;

    /**
     * 查询水力发电总貌
     * 
     * @param id 水力发电总貌ID
     * @return 水力发电总貌
     */
    @Override
    public BusinessElectricWater selectBusinessElectricWaterById(Long id)
    {
        return businessElectricWaterMapper.selectBusinessElectricWaterById(id);
    }

    /**
     * 查询水力发电总貌列表
     * 
     * @param businessElectricWater 水力发电总貌
     * @return 水力发电总貌
     */
    @Override
    public List<BusinessElectricWater> selectBusinessElectricWaterList(BusinessElectricWater businessElectricWater)
    {
        return businessElectricWaterMapper.selectBusinessElectricWaterList(businessElectricWater);
    }

    /**
     * 新增水力发电总貌
     * 
     * @param businessElectricWater 水力发电总貌
     * @return 结果
     */
    @Override
    public int insertBusinessElectricWater(BusinessElectricWater businessElectricWater)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricWater.setCreateBy(loginUser.getUsername());
        businessElectricWater.setCreateTime(new Date());
        businessElectricWater.setStatus("1");
        businessElectricWater.setCreateTime(DateUtils.getNowDate());
        return businessElectricWaterMapper.insertBusinessElectricWater(businessElectricWater);
    }

    /**
     * 修改水力发电总貌
     * 
     * @param businessElectricWater 水力发电总貌
     * @return 结果
     */
    @Override
    public int updateBusinessElectricWater(BusinessElectricWater businessElectricWater)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricWater.setUpdateBy(loginUser.getUsername());
        businessElectricWater.setUpdateTime(new Date());
        businessElectricWater.setUpdateTime(DateUtils.getNowDate());
        return businessElectricWaterMapper.updateBusinessElectricWater(businessElectricWater);
    }

    /**
     * 批量删除水力发电总貌
     * 
     * @param ids 需要删除的水力发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricWaterByIds(Long[] ids)
    {
        return businessElectricWaterMapper.deleteBusinessElectricWaterByIds(ids);
    }

    /**
     * 删除水力发电总貌信息
     * 
     * @param id 水力发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricWaterById(Long id)
    {
        return businessElectricWaterMapper.deleteBusinessElectricWaterById(id);
    }
}
