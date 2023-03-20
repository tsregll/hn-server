package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessStatisticsYueyangElectricity;

/**
 * 岳阳电厂计划曲线Service接口
 * 
 * @author ruoyi
 * @date 2021-08-13
 */
public interface IBusinessStatisticsYueyangElectricityService 
{
    /**
     * 查询岳阳电厂计划曲线
     * 
     * @param id 岳阳电厂计划曲线ID
     * @return 岳阳电厂计划曲线
     */
    public BusinessStatisticsYueyangElectricity selectBusinessStatisticsYueyangElectricityById(Long id);

    /**
     * 查询岳阳电厂计划曲线列表
     * 
     * @param businessStatisticsYueyangElectricity 岳阳电厂计划曲线
     * @return 岳阳电厂计划曲线集合
     */
    public List<BusinessStatisticsYueyangElectricity> selectBusinessStatisticsYueyangElectricityList(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity);

    /**
     * 新增岳阳电厂计划曲线
     * 
     * @param businessStatisticsYueyangElectricity 岳阳电厂计划曲线
     * @return 结果
     */
    public int insertBusinessStatisticsYueyangElectricity(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity);

    /**
     * 修改岳阳电厂计划曲线
     * 
     * @param businessStatisticsYueyangElectricity 岳阳电厂计划曲线
     * @return 结果
     */
    public int updateBusinessStatisticsYueyangElectricity(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity);

    /**
     * 批量删除岳阳电厂计划曲线
     * 
     * @param ids 需要删除的岳阳电厂计划曲线ID
     * @return 结果
     */
    public int deleteBusinessStatisticsYueyangElectricityByIds(Long[] ids);

    /**
     * 删除岳阳电厂计划曲线信息
     * 
     * @param id 岳阳电厂计划曲线ID
     * @return 结果
     */
    public int deleteBusinessStatisticsYueyangElectricityById(Long id);

    List<BusinessStatisticsYueyangElectricity> changeOperatorToList(List<BusinessStatisticsYueyangElectricity> betcaw);
}
