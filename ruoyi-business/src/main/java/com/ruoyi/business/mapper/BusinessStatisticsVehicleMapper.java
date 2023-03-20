package com.ruoyi.business.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 车辆展示
 * Controller
 *
 * @author xwq
 * @date 2021-3-24
 */
public interface BusinessStatisticsVehicleMapper {
    /**
     *查询车辆累计里程
     *
     * @return 所有车辆累计里程
     */
   public List<Map<String,Object>> BusinessStatisticsVehicleForAll();

    /**
     *查询车辆本年照片以及公里数
     *
     * @return 车辆本年照片以及公里数
     */
    public List<Map<String,Object>> BusinessStatisticsVehicleForOne(@Param("id")Long id, @Param("year")int year);

    public List<Map<String,Object>> businessStatisticsVehicleForOne(@Param("id")Long id, @Param("year")int year);

    /**
     *查询本年年度里程数 以及前几年年度总数
     *
     * @return 本年年度里程数 以及前几年年度总数
     */
    public List<Map<String,Object>> BusinessStatisticsVehicleForYear(@Param("year")int year);
    public List<Map<String,Object>> selectVid();
    public List<Map<String,Object>> selectVnumber();
    public List<Map<String,Object>> selectForYear(@Param("vid")Long vid, @Param("year")int year);
    public List<Map<String,Object>> selectForYear2(@Param("vnumber")String vNumber, @Param("year")int year);
}
