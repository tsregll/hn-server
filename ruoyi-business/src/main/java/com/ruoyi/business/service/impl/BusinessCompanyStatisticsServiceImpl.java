package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessCompanyStatisticsMapper;
import com.ruoyi.business.domain.BusinessCompanyStatistics;
import com.ruoyi.business.service.IBusinessCompanyStatisticsService;

/**
 * 清能公司统计指标Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessCompanyStatisticsServiceImpl implements IBusinessCompanyStatisticsService 
{
    @Autowired
    private BusinessCompanyStatisticsMapper businessCompanyStatisticsMapper;

    /**
     * 查询清能公司统计指标
     * 
     * @param id 清能公司统计指标ID
     * @return 清能公司统计指标
     */
    @Override
    public BusinessCompanyStatistics selectBusinessCompanyStatisticsById(Long id)
    {
        return businessCompanyStatisticsMapper.selectBusinessCompanyStatisticsById(id);
    }

    /**
     * 查询清能公司统计指标列表
     * 
     * @param businessCompanyStatistics 清能公司统计指标
     * @return 清能公司统计指标
     */
    @Override
    public List<BusinessCompanyStatistics> selectBusinessCompanyStatisticsList(BusinessCompanyStatistics businessCompanyStatistics)
    {
        return businessCompanyStatisticsMapper.selectBusinessCompanyStatisticsList(businessCompanyStatistics);
    }

    /**
     * 新增清能公司统计指标
     * 
     * @param businessCompanyStatistics 清能公司统计指标
     * @return 结果
     */
    @Override
    public int insertBusinessCompanyStatistics(BusinessCompanyStatistics businessCompanyStatistics)
    {
        businessCompanyStatistics.setCreateTime(DateUtils.getNowDate());
        return businessCompanyStatisticsMapper.insertBusinessCompanyStatistics(businessCompanyStatistics);
    }

    /**
     * 修改清能公司统计指标
     * 
     * @param businessCompanyStatistics 清能公司统计指标
     * @return 结果
     */
    @Override
    public int updateBusinessCompanyStatistics(BusinessCompanyStatistics businessCompanyStatistics)
    {
        businessCompanyStatistics.setUpdateTime(DateUtils.getNowDate());
        return businessCompanyStatisticsMapper.updateBusinessCompanyStatistics(businessCompanyStatistics);
    }

    /**
     * 批量删除清能公司统计指标
     * 
     * @param ids 需要删除的清能公司统计指标ID
     * @return 结果
     */
    @Override
    public int deleteBusinessCompanyStatisticsByIds(Long[] ids)
    {
        return businessCompanyStatisticsMapper.deleteBusinessCompanyStatisticsByIds(ids);
    }

    /**
     * 删除清能公司统计指标信息
     * 
     * @param id 清能公司统计指标ID
     * @return 结果
     */
    @Override
    public int deleteBusinessCompanyStatisticsById(Long id)
    {
        return businessCompanyStatisticsMapper.deleteBusinessCompanyStatisticsById(id);
    }
}
