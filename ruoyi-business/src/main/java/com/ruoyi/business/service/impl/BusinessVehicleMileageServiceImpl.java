package com.ruoyi.business.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.business.domain.BusinessAdministrativeVehicle;
import com.ruoyi.business.service.IBusinessAdministrativeVehicleService;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessVehicleMileageMapper;
import com.ruoyi.business.domain.BusinessVehicleMileage;
import com.ruoyi.business.service.IBusinessVehicleMileageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 车辆里程台账Service业务层处理
 * 
 * @author xwq
 * @date 2021-03-25
 */
@Service
public class BusinessVehicleMileageServiceImpl implements IBusinessVehicleMileageService 
{
    private static final Logger log = LoggerFactory.getLogger(BusinessVehicleMileageServiceImpl.class);
    @Autowired
    private IBusinessAdministrativeVehicleService businessAdministrativeVehicleService;
    @Resource
    private BusinessVehicleMileageMapper businessVehicleMileageMapper;

    /**
     * 查询车辆里程台账
     * 
     * @param id 车辆里程台账ID
     * @return 车辆里程台账
     */
    @Override
    public BusinessVehicleMileage selectBusinessVehicleMileageById(Long id)
    {
        return businessVehicleMileageMapper.selectBusinessVehicleMileageById(id);
    }

    /**
     * 查询车辆里程台账列表
     * 
     * @param businessVehicleMileage 车辆里程台账
     * @return 车辆里程台账
     */
    @Override
    public List<BusinessVehicleMileage> selectBusinessVehicleMileageList(BusinessVehicleMileage businessVehicleMileage)
    {
        return businessVehicleMileageMapper.selectBusinessVehicleMileageList(businessVehicleMileage);
    }

    /**
     * 新增车辆里程台账
     *
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    @Override
    public int insertBusinessVehicleMileage(BusinessVehicleMileage businessVehicleMileage)
    {
        businessVehicleMileage.setCreateTime(DateUtils.getNowDate());
        return businessVehicleMileageMapper.insertBusinessVehicleMileage(businessVehicleMileage);
    }

    /**
     * 新增车辆里程台账
     *
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    @Override
    public int insertVehicleMileage(BusinessVehicleMileage businessVehicleMileage)
    {
        businessVehicleMileage.setCreateTime(DateUtils.getNowDate());
        int returnResult = businessVehicleMileageMapper.insertBusinessVehicleMileage(businessVehicleMileage);
        String mileage=businessVehicleMileage.getVehicleMileage();
        Integer mileageD=null!=mileage?Integer.parseInt(mileage):new Integer(0);
        String cph = businessVehicleMileage.getLicensePlateNumber();
        if(null!=cph ){
            BusinessAdministrativeVehicle bav= new BusinessAdministrativeVehicle();
            bav.setLicensePlateNumber(cph);
            List<BusinessAdministrativeVehicle> list = businessAdministrativeVehicleService.selectBusinessAdministrativeVehicleList(bav);
            if(list.size()>0){
                String oldMileage = list.get(0).getVehicleMileage();
                Integer oldMileageD=null!=oldMileage?Integer.parseInt(oldMileage):new Integer(0);
                Integer newMileageD = oldMileageD+mileageD;
                list.get(0).setVehicleMileage(newMileageD.toString());
                businessAdministrativeVehicleService.updateBusinessAdministrativeVehicle(list.get(0));
            }
        }

        return returnResult;
    }

    /**
     * 修改车辆里程台账
     * 
     * @param businessVehicleMileage 车辆里程台账
     * @return 结果
     */
    @Override
    public int updateBusinessVehicleMileage(BusinessVehicleMileage businessVehicleMileage)
    {
        businessVehicleMileage.setUpdateTime(DateUtils.getNowDate());
        return businessVehicleMileageMapper.updateBusinessVehicleMileage(businessVehicleMileage);
    }

    /**
     * 批量删除车辆里程台账
     * 
     * @param ids 需要删除的车辆里程台账ID
     * @return 结果
     */
    @Override
    public int deleteBusinessVehicleMileageByIds(Long[] ids)
    {
        return businessVehicleMileageMapper.deleteBusinessVehicleMileageByIds(ids);
    }

    /**
     * 删除车辆里程台账信息
     * 
     * @param id 车辆里程台账ID
     * @return 结果
     */
    @Override
    public int deleteBusinessVehicleMileageById(Long id)
    {
        return businessVehicleMileageMapper.deleteBusinessVehicleMileageById(id);
    }


    /**
     * 导入车辆台账数据
     *
     * @param vehicleMileageList        车辆台账数据列表
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    public String importData(List<BusinessVehicleMileage> vehicleMileageList, String operName) {
        if (StringUtils.isNull(vehicleMileageList) || vehicleMileageList.size() == 0) {
            throw new CustomException("导入车辆台账数据列表不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for(BusinessVehicleMileage vehicleMileage: vehicleMileageList){
            try {
                    BusinessVehicleMileage vResult=businessVehicleMileageMapper.selectBusinessVehicleMileage(vehicleMileage);
                    if(StringUtils.isNull(vResult)){
                        vehicleMileage.setCreateBy(operName);
                        vehicleMileage.setCreateTime(new Date());
                        this.insertBusinessVehicleMileage(vehicleMileage);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "条车辆台账数据导入成功");
                    }else if(!vResult.getKmEndindOfMonth().equals(vehicleMileage.getKmEndindOfMonth())){
                        vehicleMileage.setUpdateBy(operName);
                        vehicleMileage.setUpdateTime(new Date());
                        businessVehicleMileageMapper.updateBusinessVehicleMileage(vehicleMileage);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "条车辆台账数据更新成功");
                    }else{
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "条车辆台账数据 已存在");
                    }

            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + failureNum + "条车辆台账数据  导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
