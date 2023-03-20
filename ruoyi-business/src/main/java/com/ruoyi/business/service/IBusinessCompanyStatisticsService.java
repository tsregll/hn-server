package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessCompanyStatistics;

/**
 * 清能公司统计指标Service接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface IBusinessCompanyStatisticsService 
{
    /**
     * 查询清能公司统计指标
     * 
     * @param id 清能公司统计指标ID
     * @return 清能公司统计指标
     */
    public BusinessCompanyStatistics selectBusinessCompanyStatisticsById(Long id);

    /**
     * 查询清能公司统计指标列表
     * 
     * @param businessCompanyStatistics 清能公司统计指标
     * @return 清能公司统计指标集合
     */
    public List<BusinessCompanyStatistics> selectBusinessCompanyStatisticsList(BusinessCompanyStatistics businessCompanyStatistics);

    /**
     * 新增清能公司统计指标
     * 
     * @param businessCompanyStatistics 清能公司统计指标
     * @return 结果
     */
    public int insertBusinessCompanyStatistics(BusinessCompanyStatistics businessCompanyStatistics);

    /**
     * 修改清能公司统计指标
     * 
     * @param businessCompanyStatistics 清能公司统计指标
     * @return 结果
     */
    public int updateBusinessCompanyStatistics(BusinessCompanyStatistics businessCompanyStatistics);

    /**
     * 批量删除清能公司统计指标
     * 
     * @param ids 需要删除的清能公司统计指标ID
     * @return 结果
     */
    public int deleteBusinessCompanyStatisticsByIds(Long[] ids);

    /**
     * 删除清能公司统计指标信息
     * 
     * @param id 清能公司统计指标ID
     * @return 结果
     */
    public int deleteBusinessCompanyStatisticsById(Long id);
}
