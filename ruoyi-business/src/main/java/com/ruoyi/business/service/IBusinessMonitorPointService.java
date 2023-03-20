package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessMonitorPoint;

/**
 * 监控探头配置Service接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface IBusinessMonitorPointService 
{
    /**
     * 查询监控探头配置
     * 
     * @param id 监控探头配置ID
     * @return 监控探头配置
     */
    public BusinessMonitorPoint selectBusinessMonitorPointById(Long id);

    /**
     * 查询监控探头配置列表
     * 
     * @param businessMonitorPoint 监控探头配置
     * @return 监控探头配置集合
     */
    public List<BusinessMonitorPoint> selectBusinessMonitorPointList(BusinessMonitorPoint businessMonitorPoint);

    /**
     * 新增监控探头配置
     * 
     * @param businessMonitorPoint 监控探头配置
     * @return 结果
     */
    public int insertBusinessMonitorPoint(BusinessMonitorPoint businessMonitorPoint);

    /**
     * 修改监控探头配置
     * 
     * @param businessMonitorPoint 监控探头配置
     * @return 结果
     */
    public int updateBusinessMonitorPoint(BusinessMonitorPoint businessMonitorPoint);

    /**
     * 批量删除监控探头配置
     * 
     * @param ids 需要删除的监控探头配置ID
     * @return 结果
     */
    public int deleteBusinessMonitorPointByIds(Long[] ids);

    /**
     * 删除监控探头配置信息
     * 
     * @param id 监控探头配置ID
     * @return 结果
     */
    public int deleteBusinessMonitorPointById(Long id);
}
