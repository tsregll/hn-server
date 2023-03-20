package com.ruoyi.business.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessElectricDataMapper;
import com.ruoyi.business.domain.BusinessElectricData;
import com.ruoyi.business.service.IBusinessElectricDataService;

/**
 * 用电数据Service业务层处理
 *
 * @author ruoyi
 * @date 2021-02-26
 */
@Service
public class BusinessElectricDataServiceImpl implements IBusinessElectricDataService {
    @Autowired
    private BusinessElectricDataMapper businessElectricDataMapper;

    /**
     * 查询用电数据
     *
     * @param id 用电数据ID
     * @return 用电数据
     */
    @Override
    public BusinessElectricData selectBusinessElectricDataById(Long id) {
        return businessElectricDataMapper.selectBusinessElectricDataById(id);
    }

    /**
     * 查询用电数据列表
     *
     * @param businessElectricData 用电数据
     * @return 用电数据
     */
    @Override
    public List<BusinessElectricData> selectBusinessElectricDataList(BusinessElectricData businessElectricData) {
        return businessElectricDataMapper.selectBusinessElectricDataList(businessElectricData);
    }

    /**
     * 新增用电数据
     *
     * @param businessElectricData 用电数据
     * @return 结果
     */
    @Override
    public int insertBusinessElectricData(BusinessElectricData businessElectricData) {
        businessElectricData.setCreateTime(DateUtils.getNowDate());
        return businessElectricDataMapper.insertBusinessElectricData(businessElectricData);
    }

    /**
     * 修改用电数据
     *
     * @param businessElectricData 用电数据
     * @return 结果
     */
    @Override
    public int updateBusinessElectricData(BusinessElectricData businessElectricData) {
        businessElectricData.setUpdateTime(DateUtils.getNowDate());
        return businessElectricDataMapper.updateBusinessElectricData(businessElectricData);
    }

    /**
     * 批量删除用电数据
     *
     * @param ids 需要删除的用电数据ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricDataByIds(Long[] ids) {
        return businessElectricDataMapper.deleteBusinessElectricDataByIds(ids);
    }

    /**
     * 删除用电数据信息
     *
     * @param id 用电数据ID
     * @return 结果
     */
    @Override
    public int deleteBusinessElectricDataById(Long id) {
        return businessElectricDataMapper.deleteBusinessElectricDataById(id);
    }
}
