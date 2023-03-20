package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessDisciplinaryManage;

/**
 * 纪检管理Mapper接口
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public interface BusinessDisciplinaryManageMapper 
{
    /**
     * 查询纪检管理
     * 
     * @param id 纪检管理ID
     * @return 纪检管理
     */
    public BusinessDisciplinaryManage selectBusinessDisciplinaryManageById(Long id);

    /**
     * 查询纪检管理列表
     * 
     * @param businessDisciplinaryManage 纪检管理
     * @return 纪检管理集合
     */
    public List<BusinessDisciplinaryManage> selectBusinessDisciplinaryManageList(BusinessDisciplinaryManage businessDisciplinaryManage);

    /**
     * 新增纪检管理
     * 
     * @param businessDisciplinaryManage 纪检管理
     * @return 结果
     */
    public int insertBusinessDisciplinaryManage(BusinessDisciplinaryManage businessDisciplinaryManage);

    /**
     * 修改纪检管理
     * 
     * @param businessDisciplinaryManage 纪检管理
     * @return 结果
     */
    public int updateBusinessDisciplinaryManage(BusinessDisciplinaryManage businessDisciplinaryManage);

    /**
     * 删除纪检管理
     * 
     * @param id 纪检管理ID
     * @return 结果
     */
    public int deleteBusinessDisciplinaryManageById(Long id);

    /**
     * 批量删除纪检管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessDisciplinaryManageByIds(Long[] ids);
}
