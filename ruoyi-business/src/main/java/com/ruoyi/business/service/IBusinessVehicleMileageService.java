package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessVehicleMileage;


/**
 * 车辆里程台账Service接口
 * 
 * @author xwq
 * @date 2021-03-25
 */
public interface IBusinessVehicleMileageService 
{
    /**
     * 查询车辆里程台账
     * 
     * @param id 车辆里程台账ID
     * @return 车辆里程台账
     */
    public BusinessVehicleMileage selectBusinessVehicleMileageById(Long id);

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
     * 新增车辆里程台账
     *
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    public int insertVehicleMileage(BusinessVehicleMileage businessVehicleMileage);
    /**
     * 修改车辆里程台账
     * 
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    public int updateBusinessVehicleMileage(BusinessVehicleMileage businessVehicleMileage);

    /**
     * 批量删除车辆里程台账
     * 
     * @param ids 需要删除的车辆里程台账ID
     * @return 结果
     */
    public int deleteBusinessVehicleMileageByIds(Long[] ids);

    /**
     * 删除车辆里程台账信息
     * 
     * @param id 车辆里程台账ID
     * @return 结果
     */
    public int deleteBusinessVehicleMileageById(Long id);

    /**
     * 导入车辆台账数据
     *
     * @param vehicleMileageList        车辆台账数据列表
     * @param operName        操作用户
     * @return 结果
     */
    public String importData(List<BusinessVehicleMileage> vehicleMileageList,String operName);
}
