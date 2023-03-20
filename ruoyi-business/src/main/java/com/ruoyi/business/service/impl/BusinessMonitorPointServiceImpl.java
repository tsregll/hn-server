package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessMonitorPointMapper;
import com.ruoyi.business.domain.BusinessMonitorPoint;
import com.ruoyi.business.service.IBusinessMonitorPointService;

/**
 * 监控探头配置Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessMonitorPointServiceImpl implements IBusinessMonitorPointService 
{
    @Autowired
    private BusinessMonitorPointMapper businessMonitorPointMapper;

    /**
     * 查询监控探头配置
     * 
     * @param id 监控探头配置ID
     * @return 监控探头配置
     */
    @Override
    public BusinessMonitorPoint selectBusinessMonitorPointById(Long id)
    {
        return businessMonitorPointMapper.selectBusinessMonitorPointById(id);
    }

    /**
     * 查询监控探头配置列表
     * 
     * @param businessMonitorPoint 监控探头配置
     * @return 监控探头配置
     */
    @Override
    public List<BusinessMonitorPoint> selectBusinessMonitorPointList(BusinessMonitorPoint businessMonitorPoint)
    {
        return businessMonitorPointMapper.selectBusinessMonitorPointList(businessMonitorPoint);
    }

    /**
     * 新增监控探头配置
     * 
     * @param businessMonitorPoint 监控探头配置
     * @return 结果
     */
    @Override
    public int insertBusinessMonitorPoint(BusinessMonitorPoint businessMonitorPoint)
    {
        businessMonitorPoint.setCreateTime(DateUtils.getNowDate());
        return businessMonitorPointMapper.insertBusinessMonitorPoint(businessMonitorPoint);
    }

    /**
     * 修改监控探头配置
     * 
     * @param businessMonitorPoint 监控探头配置
     * @return 结果
     */
    @Override
    public int updateBusinessMonitorPoint(BusinessMonitorPoint businessMonitorPoint)
    {
        businessMonitorPoint.setUpdateTime(DateUtils.getNowDate());
        return businessMonitorPointMapper.updateBusinessMonitorPoint(businessMonitorPoint);
    }

    /**
     * 批量删除监控探头配置
     * 
     * @param ids 需要删除的监控探头配置ID
     * @return 结果
     */
    @Override
    public int deleteBusinessMonitorPointByIds(Long[] ids)
    {
        return businessMonitorPointMapper.deleteBusinessMonitorPointByIds(ids);
    }

    /**
     * 删除监控探头配置信息
     * 
     * @param id 监控探头配置ID
     * @return 结果
     */
    @Override
    public int deleteBusinessMonitorPointById(Long id)
    {
        return businessMonitorPointMapper.deleteBusinessMonitorPointById(id);
    }
}
