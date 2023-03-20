package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeReception;

/**
 * 业务接待功能字段Service接口
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public interface IBusinessAdministrativeReceptionService 
{
    /**
     * 查询业务接待功能字段
     * 
     * @param id 业务接待功能字段ID
     * @return 业务接待功能字段
     */
    public BusinessAdministrativeReception selectBusinessAdministrativeReceptionById(Long id);

    /**
     * 查询业务接待功能字段列表
     * 
     * @param businessAdministrativeReception 业务接待功能字段
     * @return 业务接待功能字段集合
     */
    public List<BusinessAdministrativeReception> selectBusinessAdministrativeReceptionList(BusinessAdministrativeReception businessAdministrativeReception);

    /**
     * 新增业务接待功能字段
     * 
     * @param businessAdministrativeReception 业务接待功能字段
     * @return 结果
     */
    public int insertBusinessAdministrativeReception(BusinessAdministrativeReception businessAdministrativeReception);

    /**
     * 修改业务接待功能字段
     * 
     * @param businessAdministrativeReception 业务接待功能字段
     * @return 结果
     */
    public int updateBusinessAdministrativeReception(BusinessAdministrativeReception businessAdministrativeReception);

    /**
     * 批量删除业务接待功能字段
     * 
     * @param ids 需要删除的业务接待功能字段ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeReceptionByIds(Long[] ids);

    /**
     * 删除业务接待功能字段信息
     * 
     * @param id 业务接待功能字段ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeReceptionById(Long id);
}
