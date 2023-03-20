package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDisciplinaryManageMapper;
import com.ruoyi.business.domain.BusinessDisciplinaryManage;
import com.ruoyi.business.service.IBusinessDisciplinaryManageService;

/**
 * 纪检管理Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-02
 */
@Service
public class BusinessDisciplinaryManageServiceImpl implements IBusinessDisciplinaryManageService 
{
    @Autowired
    private BusinessDisciplinaryManageMapper businessDisciplinaryManageMapper;

    /**
     * 查询纪检管理
     * 
     * @param id 纪检管理ID
     * @return 纪检管理
     */
    @Override
    public BusinessDisciplinaryManage selectBusinessDisciplinaryManageById(Long id)
    {
        return businessDisciplinaryManageMapper.selectBusinessDisciplinaryManageById(id);
    }

    /**
     * 查询纪检管理列表
     * 
     * @param businessDisciplinaryManage 纪检管理
     * @return 纪检管理
     */
    @Override
    public List<BusinessDisciplinaryManage> selectBusinessDisciplinaryManageList(BusinessDisciplinaryManage businessDisciplinaryManage)
    {
        return businessDisciplinaryManageMapper.selectBusinessDisciplinaryManageList(businessDisciplinaryManage);
    }

    /**
     * 新增纪检管理
     * 
     * @param businessDisciplinaryManage 纪检管理
     * @return 结果
     */
    @Override
    public int insertBusinessDisciplinaryManage(BusinessDisciplinaryManage businessDisciplinaryManage)
    {
        businessDisciplinaryManage.setCreateTime(DateUtils.getNowDate());
        return businessDisciplinaryManageMapper.insertBusinessDisciplinaryManage(businessDisciplinaryManage);
    }

    /**
     * 修改纪检管理
     * 
     * @param businessDisciplinaryManage 纪检管理
     * @return 结果
     */
    @Override
    public int updateBusinessDisciplinaryManage(BusinessDisciplinaryManage businessDisciplinaryManage)
    {
        businessDisciplinaryManage.setUpdateTime(DateUtils.getNowDate());
        return businessDisciplinaryManageMapper.updateBusinessDisciplinaryManage(businessDisciplinaryManage);
    }

    /**
     * 批量删除纪检管理
     * 
     * @param ids 需要删除的纪检管理ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDisciplinaryManageByIds(Long[] ids)
    {
        return businessDisciplinaryManageMapper.deleteBusinessDisciplinaryManageByIds(ids);
    }

    /**
     * 删除纪检管理信息
     * 
     * @param id 纪检管理ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDisciplinaryManageById(Long id)
    {
        return businessDisciplinaryManageMapper.deleteBusinessDisciplinaryManageById(id);
    }
}
