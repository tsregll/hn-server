package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessInstallationStatistics;

/**
 * 装机统计Mapper接口
 * 
 * @author yrb
 * @date 2021-03-10
 */
public interface BusinessInstallationStatisticsMapper 
{
    /**
     * 查询装机统计
     * 
     * @param id 装机统计ID
     * @return 装机统计
     */
    public BusinessInstallationStatistics selectBusinessInstallationStatisticsById(Long id);

    /**
     * 查询装机统计列表
     * 
     * @param businessInstallationStatistics 装机统计
     * @return 装机统计集合
     */
    public List<BusinessInstallationStatistics> selectBusinessInstallationStatisticsList(BusinessInstallationStatistics businessInstallationStatistics);
    /**
     * 查询装机统计列表
     *
     * @param businessInstallationStatistics 装机统计
     * @return 装机统计集合
     */
    public List<BusinessInstallationStatistics> selectBusinessInstallationStatisticsListOrderByDateTime(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 查询装机统计列表
     *
     * @param businessInstallationStatistics 装机统计
     * @return 装机统计集合
     */
    public List<BusinessInstallationStatistics> selectByTimeInstallationStatisticsList(BusinessInstallationStatistics businessInstallationStatistics);
    /**
     * 新增装机统计
     * 
     * @param businessInstallationStatistics 装机统计
     * @return 结果
     */
    public int insertBusinessInstallationStatistics(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 修改装机统计
     * 
     * @param businessInstallationStatistics 装机统计
     * @return 结果
     */
    public int updateBusinessInstallationStatistics(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 删除装机统计
     * 
     * @param id 装机统计ID
     * @return 结果
     */
    public int deleteBusinessInstallationStatisticsById(Long id);

    /**
     * 批量删除装机统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessInstallationStatisticsByIds(Long[] ids);

    /**
     * 查询近五年的装机统计
     * @param bs 查询的5年
     * @return 查询结果
     */
    public List<BusinessInstallationStatistics> selectFiveInstallationStatisticsByYear(BusinessInstallationStatistics bs);

    /**
     * 通过年or类型查询总和（饼状图）
     * @param businessInstallationStatistics 查询条件对象
     * @return 数据
     */
    public BusinessInstallationStatistics selectByYearOrType(BusinessInstallationStatistics businessInstallationStatistics);
}
