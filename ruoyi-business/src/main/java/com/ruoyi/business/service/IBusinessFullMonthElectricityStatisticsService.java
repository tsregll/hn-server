package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;
import com.ruoyi.business.domain.BusinessInstallationStatistics;

/**
 * 全月日电量统计Service接口
 * 
 * @author yrb
 * @date 2021-03-13
 */
public interface IBusinessFullMonthElectricityStatisticsService 
{
    /**
     * 查询全月日电量统计
     * 
     * @param id 全月日电量统计ID
     * @return 全月日电量统计
     */
    public BusinessFullMonthElectricityStatistics selectBusinessFullMonthElectricityStatisticsById(Long id);

    /**
     * 查询全月日电量统计列表
     * 
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 全月日电量统计集合
     */
    public List<BusinessFullMonthElectricityStatistics> selectByTimeFullMonthElectricityStatisticsList(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);

    /**
     * 查询全月日电量统计列表
     *
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 全月日电量统计集合
     */
    public List<BusinessFullMonthElectricityStatistics> selectBusinessFullMonthElectricityStatisticsList(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);
    /**
     * 新增全月日电量统计
     *
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 结果
     */
    public int insertBusinessFullMonthElectricityStatistics(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);

    /**
     * 修改全月日电量统计
     *
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 结果
     */
    public int updateBusinessFullMonthElectricityStatistics(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);

    /**
     * 批量删除全月日电量统计
     *
     * @param ids 需要删除的全月日电量统计ID
     * @return 结果
     */
    public int deleteBusinessFullMonthElectricityStatisticsByIds(Long[] ids);

    /**
     * 删除全月日电量统计信息
     *
     * @param id 全月日电量统计ID
     * @return 结果
     */
    public int deleteBusinessFullMonthElectricityStatisticsById(Long id);

    public String importDatas(List<BusinessFullMonthElectricityStatistics> list);
    public Map<String, Object> selectByMonth(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);
    public Map<String, Object> selectByTable(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);
}
