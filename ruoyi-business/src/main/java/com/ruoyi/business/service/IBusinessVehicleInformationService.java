package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessVehicleInformation;

/**
 * 车辆字典Service接口
 * 
 * @author ruoyi
 * @date 2021-04-22
 */
public interface IBusinessVehicleInformationService 
{
    /**
     * 查询车辆字典
     * 
     * @param id 车辆字典ID
     * @return 车辆字典
     */
    public BusinessVehicleInformation selectBusinessVehicleInformationById(Long id);

    /**
     * 查询车辆字典列表
     * 
     * @param businessVehicleInformation 车辆字典
     * @return 车辆字典集合
     */
    public List<BusinessVehicleInformation> selectBusinessVehicleInformationList(BusinessVehicleInformation businessVehicleInformation);
    /**
     * 新增车辆字典
     *
     * @param businessVehicleInformation 车辆字典
     * @return 结果
     */
    public int insertBusinessVehicleInformation(BusinessVehicleInformation businessVehicleInformation);

    /**
     * 修改车辆字典
     *
     * @param businessVehicleInformation 车辆字典
     * @return 结果
     */
    public int updateBusinessVehicleInformation(BusinessVehicleInformation businessVehicleInformation);

    /**
     * 批量删除车辆字典
     *
     * @param ids 需要删除的车辆字典ID
     * @return 结果
     */
    public int deleteBusinessVehicleInformationByIds(Long[] ids);

    /**
     * 删除车辆字典信息
     *
     * @param id 车辆字典ID
     * @return 结果
     */
    public int deleteBusinessVehicleInformationById(Long id);

    public List<BusinessVehicleInformation> selectVehicleInformationData(BusinessVehicleInformation businessVehicleInformation);
}
