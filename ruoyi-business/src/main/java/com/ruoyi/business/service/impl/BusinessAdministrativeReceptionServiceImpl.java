package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAdministrativeReceptionMapper;
import com.ruoyi.business.domain.BusinessAdministrativeReception;
import com.ruoyi.business.service.IBusinessAdministrativeReceptionService;

/**
 * 业务接待功能字段Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-02
 */
@Service
public class BusinessAdministrativeReceptionServiceImpl implements IBusinessAdministrativeReceptionService 
{
    @Autowired
    private BusinessAdministrativeReceptionMapper businessAdministrativeReceptionMapper;

    /**
     * 查询业务接待功能字段
     * 
     * @param id 业务接待功能字段ID
     * @return 业务接待功能字段
     */
    @Override
    public BusinessAdministrativeReception selectBusinessAdministrativeReceptionById(Long id)
    {
        return businessAdministrativeReceptionMapper.selectBusinessAdministrativeReceptionById(id);
    }

    /**
     * 查询业务接待功能字段列表
     * 
     * @param businessAdministrativeReception 业务接待功能字段
     * @return 业务接待功能字段
     */
    @Override
    public List<BusinessAdministrativeReception> selectBusinessAdministrativeReceptionList(BusinessAdministrativeReception businessAdministrativeReception)
    {
        return businessAdministrativeReceptionMapper.selectBusinessAdministrativeReceptionList(businessAdministrativeReception);
    }

    /**
     * 新增业务接待功能字段
     * 
     * @param businessAdministrativeReception 业务接待功能字段
     * @return 结果
     */
    @Override
    public int insertBusinessAdministrativeReception(BusinessAdministrativeReception businessAdministrativeReception)
    {
        businessAdministrativeReception.setCreateTime(DateUtils.getNowDate());
        return businessAdministrativeReceptionMapper.insertBusinessAdministrativeReception(businessAdministrativeReception);
    }

    /**
     * 修改业务接待功能字段
     * 
     * @param businessAdministrativeReception 业务接待功能字段
     * @return 结果
     */
    @Override
    public int updateBusinessAdministrativeReception(BusinessAdministrativeReception businessAdministrativeReception)
    {
        businessAdministrativeReception.setUpdateTime(DateUtils.getNowDate());
        return businessAdministrativeReceptionMapper.updateBusinessAdministrativeReception(businessAdministrativeReception);
    }

    /**
     * 批量删除业务接待功能字段
     * 
     * @param ids 需要删除的业务接待功能字段ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeReceptionByIds(Long[] ids)
    {
        return businessAdministrativeReceptionMapper.deleteBusinessAdministrativeReceptionByIds(ids);
    }

    /**
     * 删除业务接待功能字段信息
     * 
     * @param id 业务接待功能字段ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeReceptionById(Long id)
    {
        return businessAdministrativeReceptionMapper.deleteBusinessAdministrativeReceptionById(id);
    }
}
