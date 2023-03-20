package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessFullMonthElectricityStatistics;

/**
 * 全月日电量统计Mapper接口
 * 
 * @author yrb
 * @date 2021-03-13
 */
public interface BusinessFullMonthElectricityStatisticsMapper 
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
    public List<BusinessFullMonthElectricityStatistics> selectBusinessFullMonthElectricityStatisticsList(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);
    /**
     * 查询全月日电量统计列表
     *
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 全月日电量统计集合
     */
    public List<BusinessFullMonthElectricityStatistics> selectBusinessFullMonthElectricityStatisticsListOrderByDateTime(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);

    /**
     * 查询全月日电量统计列表
     *
     * @param businessFullMonthElectricityStatistics 全月日电量统计
     * @return 全月日电量统计集合
     */
    public List<BusinessFullMonthElectricityStatistics> selectByTimeFullMonthElectricityStatisticsList(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);
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
     * 删除全月日电量统计
     *
     * @param id 全月日电量统计ID
     * @return 结果
     */
    public int deleteBusinessFullMonthElectricityStatisticsById(Long id);

    /**
     * 批量删除全月日电量统计
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessFullMonthElectricityStatisticsByIds(Long[] ids);

    public List<BusinessFullMonthElectricityStatistics> selectByMonth(BusinessFullMonthElectricityStatistics businessFullMonthElectricityStatistics);
}
