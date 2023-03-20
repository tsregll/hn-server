package com.ruoyi.business.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.business.domain.BusinessElectricPhotovoltaic;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessElectricWindMapper;
import com.ruoyi.business.domain.BusinessElectricWind;
import com.ruoyi.business.service.IBusinessElectricWindService;

/**
 * 风能发电总貌Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessElectricWindServiceImpl implements IBusinessElectricWindService 
{
    @Autowired
    private BusinessElectricWindMapper businessElectricWindMapper;

    /**
     * 查询风能发电总貌
     * 
     * @param id 风能发电总貌ID
     * @return 风能发电总貌
     */
    @Override
    public BusinessElectricWind selectBusinessElectricWindById(Long id)
    {
        return businessElectricWindMapper.selectBusinessElectricWindById(id);
    }

    /**
     * 查询风能发电总貌列表
     * 
     * @param businessElectricWind 风能发电总貌
     * @return 风能发电总貌
     */
    @Override
    public List<BusinessElectricWind> selectBusinessElectricWindList(BusinessElectricWind businessElectricWind)
    {
        return businessElectricWindMapper.selectBusinessElectricWindList(businessElectricWind);
    }

    /**
     * 新增风能发电总貌
     * 
     * @param businessElectricWind 风能发电总貌
     * @return 结果
     */
    @Override
    public int insertBusinessElectricWind(BusinessElectricWind businessElectricWind)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricWind.setCreateBy(loginUser.getUsername());
        businessElectricWind.setCreateTime(new Date());
        businessElectricWind.setStatus("1");
        businessElectricWind = statistics(businessElectricWind);
        businessElectricWind.setCreateTime(DateUtils.getNowDate());
        return businessElectricWindMapper.insertBusinessElectricWind(businessElectricWind);
    }

    /**
     * 修改风能发电总貌
     * 
     * @param businessElectricWind 风能发电总貌
     * @return 结果
     */
    @Override
    public int updateBusinessElectricWind(BusinessElectricWind businessElectricWind)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessElectricWind.setUpdateBy(loginUser.getUsername());
        businessElectricWind.setUpdateTime(new Date());
        businessElectricWind = statistics(businessElectricWind);
        businessElectricWind.setUpdateTime(DateUtils.getNowDate());
        return businessElectricWindMapper.updateBusinessElectricWind(businessElectricWind);
    }

    /**
     * 批量删除风能发电总貌
     * 
     * @param ids 需要删除的风能发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricWindByIds(Long[] ids)
    {
        return businessElectricWindMapper.deleteBusinessElectricWindByIds(ids);
    }

    /**
     * 删除风能发电总貌信息
     * 
     * @param id 风能发电总貌ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricWindById(Long id)
    {
        return businessElectricWindMapper.deleteBusinessElectricWindById(id);
    }

    private BusinessElectricWind statistics(BusinessElectricWind businessElectricWind){

        BigDecimal sbd = null;
        BigDecimal gd = null;
        BigDecimal lp = null;
        BigDecimal mq = null;
        BigDecimal bh = null;
        BigDecimal hly = null;
        if(businessElectricWind.getGenerateCapacitySbd()!=null)sbd =new BigDecimal(businessElectricWind.getGenerateCapacitySbd());
        if(businessElectricWind.getGenerateCapacityGd()!=null)gd =new BigDecimal(businessElectricWind.getGenerateCapacityGd());
        if(businessElectricWind.getGenerateCapacityLp()!=null)lp =new BigDecimal(businessElectricWind.getGenerateCapacityLp());
        if(businessElectricWind.getGenerateCapacityMq()!=null)mq =new BigDecimal(businessElectricWind.getGenerateCapacityMq());
        if(businessElectricWind.getGenerateCapacityBh()!=null)bh =new BigDecimal(businessElectricWind.getGenerateCapacityBh());
        if(businessElectricWind.getGenerateCapacityHly()!=null)hly =new BigDecimal(businessElectricWind.getGenerateCapacityHly());
        BigDecimal generateCapacity = new BigDecimal("0");
        if(sbd!=null)generateCapacity = generateCapacity.add(sbd);
        if(gd!=null)generateCapacity = generateCapacity.add(gd);
        if(lp!=null)generateCapacity = generateCapacity.add(lp);
        if(mq!=null)generateCapacity = generateCapacity.add(mq);
        if(bh!=null)generateCapacity = generateCapacity.add(bh);
        if(hly!=null)generateCapacity = generateCapacity.add(hly);
        businessElectricWind.setGenerateCapacity(generateCapacity.toString());
        BigDecimal totalPrice = new BigDecimal("0");
        if(businessElectricWind.getTotalPriceSbd()!=null)totalPrice = totalPrice.add(businessElectricWind.getTotalPriceSbd());
        if(businessElectricWind.getTotalPriceGd()!=null)totalPrice = totalPrice.add(businessElectricWind.getTotalPriceGd());
        if(businessElectricWind.getTotalPriceLp()!=null)totalPrice = totalPrice.add(businessElectricWind.getTotalPriceLp());
        if(businessElectricWind.getTotalPriceMq()!=null)totalPrice = totalPrice.add(businessElectricWind.getTotalPriceMq());
        if(businessElectricWind.getTotalPriceBh()!=null)totalPrice = totalPrice.add(businessElectricWind.getTotalPriceBh());
        if(businessElectricWind.getTotalPriceHly()!=null)totalPrice = totalPrice.add(businessElectricWind.getTotalPriceHly());
        businessElectricWind.setTotalPrice(totalPrice);
        BigDecimal eva = new BigDecimal("0");
        if(businessElectricWind.getEvaSbd()!=null)eva = eva.add(businessElectricWind.getEvaSbd());
        if(businessElectricWind.getEvaGd()!=null)eva = eva.add(businessElectricWind.getEvaGd());
        if(businessElectricWind.getEvaLp()!=null)eva = eva.add(businessElectricWind.getEvaLp());
        if(businessElectricWind.getEvaMq()!=null)eva = eva.add(businessElectricWind.getEvaMq());
        if(businessElectricWind.getEvaBh()!=null)eva = eva.add(businessElectricWind.getEvaBh());
        if(businessElectricWind.getEvaHly()!=null)eva = eva.add(businessElectricWind.getEvaHly());
        businessElectricWind.setEva(eva);
        return businessElectricWind;
    }
}
