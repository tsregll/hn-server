package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;

/**
 * 统调发电量Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
public interface BusinessStatisticsGeneratingCapacityMapper 
{
    /**
     * 查询统调发电量
     * 
     * @param id 统调发电量ID
     * @return 统调发电量
     */
    public BusinessStatisticsGeneratingCapacity selectBusinessStatisticsGeneratingCapacityById(Long id);

    /**
     * 查询统调发电量列表
     * 
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 统调发电量集合
     */
    public List<BusinessStatisticsGeneratingCapacity> selectBusinessStatisticsGeneratingCapacityList(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);


    /**
     * 查询统调发电量列表
     *
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 统调发电量集合
     */
    public List<BusinessStatisticsGeneratingCapacity> selectByTimeStatisticsGeneratingCapacityList(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);
    /**
     * 查询统调发电量列表
     *
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 统调发电量集合
     */
    public List<BusinessStatisticsGeneratingCapacity> selectBusinessStatisticsGeneratingCapacityListOrderByDateTime(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);
    /**
     * 新增统调发电量
     *
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 结果
     */
    public int insertBusinessStatisticsGeneratingCapacity(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);
    /**
     * 修改统调发电量
     *
     * @param businessStatisticsGeneratingCapacity 统调发电量
     * @return 结果
     */
    public int updateBusinessStatisticsGeneratingCapacity(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);

    /**
     * 删除统调发电量
     *
     * @param id 统调发电量ID
     * @return 结果
     */
    public int deleteBusinessStatisticsGeneratingCapacityById(Long id);

    /**
     * 批量删除统调发电量
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessStatisticsGeneratingCapacityByIds(Long[] ids);

    public List<BusinessStatisticsGeneratingCapacity> selectByYearOrType(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);

    public List<BusinessStatisticsGeneratingCapacity> selectByMonth(BusinessStatisticsGeneratingCapacity businessStatisticsGeneratingCapacity);
}
