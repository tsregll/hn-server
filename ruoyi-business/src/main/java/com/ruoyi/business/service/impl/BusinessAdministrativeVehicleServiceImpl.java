package com.ruoyi.business.service.impl;

import java.io.IOException;
import java.util.List;

import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectFile;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAdministrativeVehicleMapper;
import com.ruoyi.business.domain.BusinessAdministrativeVehicle;
import com.ruoyi.business.service.IBusinessAdministrativeVehicleService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车辆管理
Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-03
 */
@Service
public class BusinessAdministrativeVehicleServiceImpl implements IBusinessAdministrativeVehicleService 
{
    @Autowired
    private BusinessAdministrativeVehicleMapper businessAdministrativeVehicleMapper;

    /**
     * 查询车辆管理

     * 
     * @param id 车辆管理
ID
     * @return 车辆管理

     */
    @Override
    public BusinessAdministrativeVehicle selectBusinessAdministrativeVehicleById(Long id)
    {
        return businessAdministrativeVehicleMapper.selectBusinessAdministrativeVehicleById(id);
    }

    /**
     * 查询车辆管理
列表
     * 
     * @param businessAdministrativeVehicle 车辆管理

     * @return 车辆管理

     */
    @Override
    public List<BusinessAdministrativeVehicle> selectBusinessAdministrativeVehicleList(BusinessAdministrativeVehicle businessAdministrativeVehicle)
    {
        return businessAdministrativeVehicleMapper.selectBusinessAdministrativeVehicleList(businessAdministrativeVehicle);
    }

    /**
     * 查询里程排行前5车辆管理
     列表
     *
     * @param businessAdministrativeVehicle 车辆管理

     * @return 车辆管理

     */
    @Override
    public List<BusinessAdministrativeVehicle> selectOrderByMileageAdministrativeVehicleList(BusinessAdministrativeVehicle businessAdministrativeVehicle)
    {
        return businessAdministrativeVehicleMapper.selectOrderByMileageAdministrativeVehicleList(businessAdministrativeVehicle);
    }

    /**
     * 新增车辆管理

     * 
     * @param businessAdministrativeVehicle 车辆管理

     * @return 结果
     */
    @Override
    public int insertBusinessAdministrativeVehicle(BusinessAdministrativeVehicle businessAdministrativeVehicle)
    {
        businessAdministrativeVehicle.setCreateTime(DateUtils.getNowDate());
        return businessAdministrativeVehicleMapper.insertBusinessAdministrativeVehicle(businessAdministrativeVehicle);
    }

    /**
     * 修改车辆管理

     * 
     * @param businessAdministrativeVehicle 车辆管理

     * @return 结果
     */
    @Override
    public int updateBusinessAdministrativeVehicle(BusinessAdministrativeVehicle businessAdministrativeVehicle)
    {
        businessAdministrativeVehicle.setUpdateTime(DateUtils.getNowDate());
        return businessAdministrativeVehicleMapper.updateBusinessAdministrativeVehicle(businessAdministrativeVehicle);
    }

    /**
     * 批量删除车辆管理

     * 
     * @param ids 需要删除的车辆管理
ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeVehicleByIds(Long[] ids)
    {
        return businessAdministrativeVehicleMapper.deleteBusinessAdministrativeVehicleByIds(ids);
    }

    /**
     * 删除车辆管理
信息
     * 
     * @param id 车辆管理
ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeVehicleById(Long id)
    {
        return businessAdministrativeVehicleMapper.deleteBusinessAdministrativeVehicleById(id);
    }

    @Override
    public AjaxResult vehicleFileUpload(MultipartFile file, String licensePlateNumber, Long id)  throws IOException{
        if (!file.isEmpty()) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            Integer rows = null;
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            BusinessAdministrativeVehicle businessAdministrativeVehicle = new BusinessAdministrativeVehicle();
            businessAdministrativeVehicle.setId(id);
            businessAdministrativeVehicle.setVehicleImage(fileName);
            return AjaxResult.success(this.updateBusinessAdministrativeVehicle(businessAdministrativeVehicle));
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
