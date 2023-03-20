package com.ruoyi.business.service;

import java.io.IOException;
import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeVehicle;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车辆管理
Service接口
 * 
 * @author gwsh
 * @date 2021-03-03
 */
public interface IBusinessAdministrativeVehicleService 
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
     * 批量删除车辆管理

     * 
     * @param ids 需要删除的车辆管理
ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeVehicleByIds(Long[] ids);

    /**
     * 删除车辆管理
信息
     * 
     * @param id 车辆管理
ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeVehicleById(Long id);

    /**
     * 上传图片
     * @param file 需要上传的图片
     * @param licensePlateNumber 车牌号
     * @param id 车辆管理ID
     * @return 结果
     */
    public AjaxResult vehicleFileUpload(MultipartFile file, String licensePlateNumber, Long id) throws IOException;
}
