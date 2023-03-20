package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessVehicleMileage;

/**
 * 车辆里程台账Mapper接口
 * 
 * @author xwq
 * @date 2021-03-25
 */
public interface BusinessVehicleMileageMapper 
{
    /**
     * 查询车辆里程台账
     * 
     * @param id 车辆里程台账ID
     * @return 车辆里程台账
     */
    public BusinessVehicleMileage selectBusinessVehicleMileageById(Long id);

    /**
     * 指定车辆里程台账
     *
     * @param businessVehicleMileage 车辆里程台账信息
     * @return 车辆里程台账
     */
    public BusinessVehicleMileage selectBusinessVehicleMileage(BusinessVehicleMileage businessVehicleMileage);

    /**
     * 查询车辆里程台账列表
     * 
     * @param businessVehicleMileage 车辆里程台账
     * @return 车辆里程台账集合
     */
    public List<BusinessVehicleMileage> selectBusinessVehicleMileageList(BusinessVehicleMileage businessVehicleMileage);

    /**
     * 新增车辆里程台账
     * 
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    public int insertBusinessVehicleMileage(BusinessVehicleMileage businessVehicleMileage);

    /**
     * 修改车辆里程台账
     * 
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    public int updateBusinessVehicleMileage(BusinessVehicleMileage businessVehicleMileage);

    /**
     * 删除车辆里程台账
     * 
     * @param id 车辆里程台账ID
     * @return 结果
     */
    public int deleteBusinessVehicleMileageById(Long id);

    /**
     * 批量删除车辆里程台账
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessVehicleMileageByIds(Long[] ids);
}
