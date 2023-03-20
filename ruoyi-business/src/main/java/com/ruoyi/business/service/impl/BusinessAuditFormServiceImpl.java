package com.ruoyi.business.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAuditFormMapper;
import com.ruoyi.business.domain.BusinessAuditForm;
import com.ruoyi.business.service.IBusinessAuditFormService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门审批流程Service业务层处理
 *
 * @author ruoyi
 * @date 2021-02-26
 */
@Service
public class BusinessAuditFormServiceImpl implements IBusinessAuditFormService {
    @Autowired
    private BusinessAuditFormMapper businessAuditFormMapper;

    /**
     * 查询部门审批流程
     *
     * @param id 部门审批流程ID
     * @return 部门审批流程
     */
    @Override
    public BusinessAuditForm selectBusinessAuditFormById(Long id) {
        return businessAuditFormMapper.selectBusinessAuditFormById(id);
    }

    /**
     * 查询部门审批流程列表
     *
     * @param businessAuditForm 部门审批流程
     * @return 部门审批流程
     */
    @Override
    public List<BusinessAuditForm> selectBusinessAuditFormList(BusinessAuditForm businessAuditForm) {
        return businessAuditFormMapper.selectBusinessAuditFormList(businessAuditForm);
    }

    /**
     * 新增部门审批流程
     *
     * @param businessAuditForm 部门审批流程
     * @return 结果
     */
    @Override
    public int insertBusinessAuditForm(BusinessAuditForm businessAuditForm) {
        businessAuditForm.setCreateTime(DateUtils.getNowDate());
        return businessAuditFormMapper.insertBusinessAuditForm(businessAuditForm);
    }

    /**
     * 修改部门审批流程
     *
     * @param businessAuditForm 部门审批流程
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBusinessAuditForm(BusinessAuditForm businessAuditForm) {
        businessAuditForm.setUpdateTime(DateUtils.getNowDate());
        return businessAuditFormMapper.updateBusinessAuditForm(businessAuditForm);
    }

    /**
     * 批量删除部门审批流程
     *
     * @param ids 需要删除的部门审批流程ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAuditFormByIds(Long[] ids) {
        return businessAuditFormMapper.deleteBusinessAuditFormByIds(ids);
    }

    /**
     * 删除部门审批流程信息
     *
     * @param id 部门审批流程ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAuditFormById(Long id) {
        return businessAuditFormMapper.deleteBusinessAuditFormById(id);
    }

    @Override
    public List<BusinessAuditForm> myAuditingByRokeKey(Long userId, String roleKey, BusinessAuditForm businessAuditForm) {
        return businessAuditFormMapper.myAuditingByRokeKey(userId, roleKey, businessAuditForm);
    }

    @Override
    public List<BusinessAuditForm> myAuditedByRokeKey(Long userId, String roleKey, BusinessAuditForm businessAuditForm) {
        return businessAuditFormMapper.myAuditedByRokeKey(userId, roleKey, businessAuditForm);
    }

    @Override
    public BusinessAuditForm selectBusinessAuditFormByDataId(Long dataId) {
        return businessAuditFormMapper.selectBusinessAuditFormByDataId(dataId);
    }
}
