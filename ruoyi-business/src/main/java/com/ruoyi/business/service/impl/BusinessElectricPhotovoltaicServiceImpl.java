package com.ruoyi.business.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessElectricPhotovoltaicMapper;
import com.ruoyi.business.domain.BusinessElectricPhotovoltaic;
import com.ruoyi.business.service.IBusinessElectricPhotovoltaicService;

/**
 * 光伏发电总貌Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessElectricPhotovoltaicServiceImpl implements IBusinessElectricPhotovoltaicService 
{
    @Autowired
    private BusinessElectricPhotovoltaicMapper businessElectricPhotovoltaicMapper;

    /**
     * 查询光伏发电总貌
     * 
     * @param id 光伏发电总貌ID
     * @return 光伏发电总貌
     */
    @Override
    public BusinessElectricPhotovoltaic selectBusinessElectricPhotovoltaicById(Long id)
    {
        return businessElectricPhotovoltaicMapper.selectBusinessElectricPhotovoltaicById(id);
    }

    /**
     * 查询光伏发电总貌列表
     * 
     * @param businessElectricPhotovoltaic 光伏发电总貌
     * @return 光伏发电总貌
     */
    @Override
    public List<BusinessElectricPhotovoltaic> selectBusinessElectricPhotovoltaicList(BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        return businessElectricPhotovoltaicMapper.selectBusinessElectricPhotovoltaicList(businessElectricPhotovoltaic);
    }

    /**
     * 新增光伏发电总貌
     * 
     * @param businessElectricPhotovoltaic 光伏发电总貌
     * @return 结果
     */
    @Override
    public int insertBusinessElectricPhotovoltaic(BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricPhotovoltaic.setCreateBy(loginUser.getUsername());
        businessElectricPhotovoltaic.setCreateTime(new Date());
        businessElectricPhotovoltaic.setStatus("1");
        businessElectricPhotovoltaic = statistics(businessElectricPhotovoltaic);
        businessElectricPhotovoltaic.setCreateTime(DateUtils.getNowDate());
        return businessElectricPhotovoltaicMapper.insertBusinessElectricPhotovoltaic(businessElectricPhotovoltaic);
    }

    /**
     * 修改光伏发电总貌
     * 
     * @param businessElectricPhotovoltaic 光伏发电总貌
     * @return 结果
     */
    @Override
    public int updateBusinessElectricPhotovoltaic(BusinessElectricPhotovoltaic businessElectricPhotovoltaic)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricPhotovoltaic.setUpdateBy(loginUser.getUsername());
        businessElectricPhotovoltaic.setUpdateTime(new Date());
        businessElectricPhotovoltaic = statistics(businessElectricPhotovoltaic);
        businessElectricPhotovoltaic.setUpdateTime(DateUtils.getNowDate());
        return businessElectricPhotovoltaicMapper.updateBusinessElectricPhotovoltaic(businessElectricPhotovoltaic);
    }

    /**
     * 批量删除光伏发电总貌
     * 
     * @param ids 需要删除的光伏发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricPhotovoltaicByIds(Long[] ids)
    {
        return businessElectricPhotovoltaicMapper.deleteBusinessElectricPhotovoltaicByIds(ids);
    }

    /**
     * 删除光伏发电总貌信息
     * 
     * @param id 光伏发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricPhotovoltaicById(Long id)
    {
        return businessElectricPhotovoltaicMapper.deleteBusinessElectricPhotovoltaicById(id);
    }

    private BusinessElectricPhotovoltaic statistics(BusinessElectricPhotovoltaic businessElectricPhotovoltaic){
        BigDecimal hs = null;
        BigDecimal lg = null;
        BigDecimal xg = null;
        if(businessElectricPhotovoltaic.getGenerateCapacityHs() != null)hs = new BigDecimal(businessElectricPhotovoltaic.getGenerateCapacityHs());
        if(businessElectricPhotovoltaic.getGenerateCapacityLg() != null)lg = new BigDecimal(businessElectricPhotovoltaic.getGenerateCapacityLg());
        if(businessElectricPhotovoltaic.getGenerateCapacityXg() != null)xg = new BigDecimal(businessElectricPhotovoltaic.getGenerateCapacityXg());
        BigDecimal generateCapacity = new BigDecimal("0");
        if(hs!=null)generateCapacity = generateCapacity.add(hs);
        if(lg!=null)generateCapacity = generateCapacity.add(lg);
        if(xg!=null)generateCapacity = generateCapacity.add(xg);
        businessElectricPhotovoltaic.setGenerateCapacity(generateCapacity.toString());
        return businessElectricPhotovoltaic;
    }
}
