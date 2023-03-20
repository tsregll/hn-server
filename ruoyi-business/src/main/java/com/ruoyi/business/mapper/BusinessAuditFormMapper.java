package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.BusinessAuditForm;
import org.apache.ibatis.annotations.Param;

/**
 * 部门审批流程Mapper接口
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public interface BusinessAuditFormMapper {
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
     * 删除部门审批流程
     *
     * @param id 部门审批流程ID
     * @return 结果
     */
    public int deleteBusinessAuditFormById(Long id);

    /**
     * 批量删除部门审批流程
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessAuditFormByIds(Long[] ids);

    List<BusinessAuditForm> myAuditingByRokeKey(@Param("userId") Long userId, @Param("roleKey") String roleKey, @Param("businessAuditForm") BusinessAuditForm businessAuditForm);

    List<BusinessAuditForm> myAuditedByRokeKey(@Param("userId") Long userId, @Param("roleKey") String roleKey, @Param("businessAuditForm") BusinessAuditForm businessAuditForm);

    BusinessAuditForm selectBusinessAuditFormByDataId(Long dataId);
}
