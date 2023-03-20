package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeVehicle;

/**
 * 车辆管理
Mapper接口
 * 
 * @author gwsh
 * @date 2021-03-03
 */
public interface BusinessAdministrativeVehicleMapper 
{
    /**
     * 查询车辆管理

     * 
     * @param id 车辆管理
ID
     * @return 车辆管理

     */
    public BusinessAdministrativeVehicle selectBusinessAdministrativeVehicleById(Long id);

    /**
     * 查询车辆管理
列表
     * 
     * @param businessAdministrativeVehicle 车辆管理

     * @return 车辆管理
集合
     */
    public List<BusinessAdministrativeVehicle> selectBusinessAdministrativeVehicleList(BusinessAdministrativeVehicle businessAdministrativeVehicle);

    /**
     * 查询车辆管理
     列表
     *
     * @param businessAdministrativeVehicle 车辆管理

     * @return 车辆管理
    集合
     */
    public List<BusinessAdministrativeVehicle> selectOrderByMileageAdministrativeVehicleList(BusinessAdministrativeVehicle businessAdministrativeVehicle);

    /**
     * 新增车辆管理

     * 
     * @param businessAdministrativeVehicle 车辆管理

     * @return 结果
     */
    public int insertBusinessAdministrativeVehicle(BusinessAdministrativeVehicle businessAdministrativeVehicle);

    /**
     * 修改车辆管理

     * 
     * @param businessAdministrativeVehicle 车辆管理

     * @return 结果
     */
    public int updateBusinessAdministrativeVehicle(BusinessAdministrativeVehicle businessAdministrativeVehicle);

    /**
     * 删除车辆管理

     * 
     * @param id 车辆管理
ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeVehicleById(Long id);

    /**
     * 批量删除车辆管理

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeVehicleByIds(Long[] ids);
}
