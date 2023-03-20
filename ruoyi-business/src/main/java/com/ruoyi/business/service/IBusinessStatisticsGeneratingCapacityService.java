package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;
import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;

/**
 * 统调发电量Service接口
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
public interface IBusinessStatisticsGeneratingCapacityService 
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
     * 批量删除统调发电量
     * 
     * @param ids 需要删除的统调发电量ID
     * @return 结果
     */
    public int deleteBusinessStatisticsGeneratingCapacityByIds(Long[] ids);

    /**
     * 删除统调发电量信息
     * 
     * @param id 统调发电量ID
     * @return 结果
     */
    public int deleteBusinessStatisticsGeneratingCapacityById(Long id);

    public Map<String,Object> selectByFive(BusinessStatisticsGeneratingCapacity bsgc);
    public Map<String,Object> selectByYearOrType(BusinessStatisticsGeneratingCapacity bsgc);
    public Map<String, Object> selectByMonth(BusinessStatisticsGeneratingCapacity bsgc);
    public String importDatas(List<BusinessStatisticsGeneratingCapacity> bsgc);
}
