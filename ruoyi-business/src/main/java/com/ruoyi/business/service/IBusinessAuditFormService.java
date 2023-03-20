package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.BusinessAuditForm;

/**
 * 部门审批流程Service接口
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public interface IBusinessAuditFormService {
    /**
     * 查询部门审批流程
     *
     * @param id 部门审批流程ID
     * @return 部门审批流程
     */
    public BusinessAuditForm selectBusinessAuditFormById(Long id);

    /**
     * 查询部门审批流程列表
     *
     * @param businessAuditForm 部门审批流程
     * @return 部门审批流程集合
     */
    public List<BusinessAuditForm> selectBusinessAuditFormList(BusinessAuditForm businessAuditForm);

    /**
     * 新增部门审批流程
     *
     * @param businessAuditForm 部门审批流程
     * @return 结果
     */
    public int insertBusinessAuditForm(BusinessAuditForm businessAuditForm);

    /**
     * 修改部门审批流程
     *
     * @param businessAuditForm 部门审批流程
     * @return 结果
     */
    public int updateBusinessAuditForm(BusinessAuditForm businessAuditForm);

    /**
     * 批量删除部门审批流程
     *
     * @param ids 需要删除的部门审批流程ID
     * @return 结果
     */
    public int deleteBusinessAuditFormByIds(Long[] ids);

    /**
     * 删除部门审批流程信息
     *
     * @param id 部门审批流程ID
     * @return 结果
     */
    public int deleteBusinessAuditFormById(Long id);

    /**
     * 查询我的待审批列表
     *
     * @param userId
     * @param roleKey
     * @param businessAuditForm
     * @return
     */
    List<BusinessAuditForm> myAuditingByRokeKey(Long userId, String roleKey, BusinessAuditForm businessAuditForm);

    /**
     * 查询我的已审批列表
     *
     * @param userId
     * @param roleKey
     * @param businessAuditForm
     * @return
     */
    List<BusinessAuditForm> myAuditedByRokeKey(Long userId, String roleKey, BusinessAuditForm businessAuditForm);

    BusinessAuditForm selectBusinessAuditFormByDataId(Long dataId);
}
