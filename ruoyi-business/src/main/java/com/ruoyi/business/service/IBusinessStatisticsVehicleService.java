package com.ruoyi.business.service;

import java.util.List;

/**
 * 车辆展示
 *
 * @author xwq
 * @date 2021-3-24
 */
public interface IBusinessStatisticsVehicleService {
    /**
     *查询车辆累计里程
     *
     * @return 所有车辆累计里程
     */
    public List<Object> BusinessStatisticsVehicleForAll();

    /**
     *查询车辆累计里程
     *
     * @return 所有车辆累计里程
     */
    public List<Object> businessStatisticsVehicleForAll();

    /**
     *查询车辆本年照片以及公里数
     *
     * @return 车辆本年照片以及公里数
     */
    public List<Object> BusinessStatisticsVehicleForOne(Long id);

    /**
     *查询本年年度里程数 以及前几年年度总数
     *
     * @return 本年年度里程数 以及前几年年度总数
     */
    public List<Object> BusinessStatisticsVehicleForYear();
    /**
     *查询本年年度里程数 以及前几年年度总数-方案2
     *
     * @return 本年年度里程数 以及前几年年度总数
     */
    public List<Object> businessStatisticsVehicleForYear();

}
