package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessVehicleInformationMapper;
import com.ruoyi.business.domain.BusinessVehicleInformation;
import com.ruoyi.business.service.IBusinessVehicleInformationService;

/**
 * 车辆字典Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-22
 */
@Service
public class BusinessVehicleInformationServiceImpl implements IBusinessVehicleInformationService 
{
    @Autowired
    private BusinessVehicleInformationMapper businessVehicleInformationMapper;

    /**
     * 查询车辆字典
     * 
     * @param id 车辆字典ID
     * @return 车辆字典
     */
    @Override
    public BusinessVehicleInformation selectBusinessVehicleInformationById(Long id)
    {
        return businessVehicleInformationMapper.selectBusinessVehicleInformationById(id);
    }

    /**
     * 查询车辆字典列表
     * 
     * @param businessVehicleInformation 车辆字典
     * @return 车辆字典
     */
    @Override
    public List<BusinessVehicleInformation> selectBusinessVehicleInformationList(BusinessVehicleInformation businessVehicleInformation)
    {
        return businessVehicleInformationMapper.selectBusinessVehicleInformationList(businessVehicleInformation);
    }
    /**
     * 新增车辆字典
     *
     * @param businessVehicleInformation 车辆字典
     * @return 结果
     */
    @Override
    public int insertBusinessVehicleInformation(BusinessVehicleInformation businessVehicleInformation)
    {
        businessVehicleInformation.setCreateTime(DateUtils.getNowDate());
        return businessVehicleInformationMapper.insertBusinessVehicleInformation(businessVehicleInformation);
    }

    /**
     * 修改车辆字典
     *
     * @param businessVehicleInformation 车辆字典
     * @return 结果
     */
    @Override
    public int updateBusinessVehicleInformation(BusinessVehicleInformation businessVehicleInformation)
    {
        businessVehicleInformation.setUpdateTime(DateUtils.getNowDate());
        return businessVehicleInformationMapper.updateBusinessVehicleInformation(businessVehicleInformation);
    }

    /**
     * 批量删除车辆字典
     *
     * @param ids 需要删除的车辆字典ID
     * @return 结果
     */
    @Override
    public int deleteBusinessVehicleInformationByIds(Long[] ids)
    {
        return businessVehicleInformationMapper.deleteBusinessVehicleInformationByIds(ids);
    }

    /**
     * 删除车辆字典信息
     *
     * @param id 车辆字典ID
     * @return 结果
     */
    @Override
    public int deleteBusinessVehicleInformationById(Long id)
    {
        return businessVehicleInformationMapper.deleteBusinessVehicleInformationById(id);
    }

    @Override
    public List<BusinessVehicleInformation> selectVehicleInformationData(BusinessVehicleInformation businessVehicleInformation)
    {
        return businessVehicleInformationMapper.selectVehicleInformationData(businessVehicleInformation);
    }
}
