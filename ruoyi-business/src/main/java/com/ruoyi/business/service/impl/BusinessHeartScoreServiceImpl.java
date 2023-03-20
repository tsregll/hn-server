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
import com.ruoyi.business.mapper.BusinessHeartScoreMapper;
import com.ruoyi.business.domain.BusinessHeartScore;
import com.ruoyi.business.service.IBusinessHeartScoreService;

/**
 * 供热年度绩效Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-02
 */
@Service
public class BusinessHeartScoreServiceImpl implements IBusinessHeartScoreService 
{
    @Autowired
    private BusinessHeartScoreMapper businessHeartScoreMapper;

    /**
     * 查询供热年度绩效
     * 
     * @param id 供热年度绩效ID
     * @return 供热年度绩效
     */
    @Override
    public BusinessHeartScore selectBusinessHeartScoreById(Long id)
    {
        return businessHeartScoreMapper.selectBusinessHeartScoreById(id);
    }

    /**
     * 查询供热年度绩效列表
     * 
     * @param businessHeartScore 供热年度绩效
     * @return 供热年度绩效
     */
    @Override
    public List<BusinessHeartScore> selectBusinessHeartScoreList(BusinessHeartScore businessHeartScore)
    {
        return businessHeartScoreMapper.selectBusinessHeartScoreList(businessHeartScore);
    }

    /**
     * 新增供热年度绩效
     * 
     * @param businessHeartScore 供热年度绩效
     * @return 结果
     */
    @Override
    public int insertBusinessHeartScore(BusinessHeartScore businessHeartScore)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessHeartScore.setCreateBy(loginUser.getUsername());
        businessHeartScore.setCreateTime(new Date());
        businessHeartScore.setStatus("1");
        businessHeartScore = statistics(businessHeartScore);
        businessHeartScore.setCreateTime(DateUtils.getNowDate());
        return businessHeartScoreMapper.insertBusinessHeartScore(businessHeartScore);
    }

    /**
     * 修改供热年度绩效
     * 
     * @param businessHeartScore 供热年度绩效
     * @return 结果
     */
    @Override
    public int updateBusinessHeartScore(BusinessHeartScore businessHeartScore)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessHeartScore.setUpdateBy(loginUser.getUsername());
        businessHeartScore.setUpdateTime(new Date());
        businessHeartScore = statistics(businessHeartScore);
        businessHeartScore.setUpdateTime(DateUtils.getNowDate());
        return businessHeartScoreMapper.updateBusinessHeartScore(businessHeartScore);
    }

    /**
     * 批量删除供热年度绩效
     * 
     * @param ids 需要删除的供热年度绩效ID
     * @return 结果
     */
    @Override
    public int deleteBusinessHeartScoreByIds(Long[] ids)
    {
        return businessHeartScoreMapper.deleteBusinessHeartScoreByIds(ids);
    }

    /**
     * 删除供热年度绩效信息
     * 
     * @param id 供热年度绩效ID
     * @return 结果
     */
    @Override
    public int deleteBusinessHeartScoreById(Long id)
    {
        return businessHeartScoreMapper.deleteBusinessHeartScoreById(id);
    }

    private BusinessHeartScore statistics(BusinessHeartScore businessHeartScore){
        BigDecimal first = null;
        BigDecimal second = null;
        BigDecimal thirdly = null;
        if(businessHeartScore.getGenerateCapacityFirst() != null)first = new BigDecimal(businessHeartScore.getGenerateCapacityFirst());
        if(businessHeartScore.getGenerateCapacitySecond() != null)second = new BigDecimal(businessHeartScore.getGenerateCapacitySecond());
        if(businessHeartScore.getGenerateCapacityThirdly() != null)thirdly = new BigDecimal(businessHeartScore.getGenerateCapacityThirdly());
        BigDecimal generateCapacity = new BigDecimal("0");
        if(first!=null)generateCapacity = generateCapacity.add(first);
        if(second!=null)generateCapacity = generateCapacity.add(second);
        if(thirdly!=null)generateCapacity = generateCapacity.add(thirdly);
        businessHeartScore.setGenerateCapacity(generateCapacity.toString());
        return businessHeartScore;
    }
}
