package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeDecision;

/**
 * 决策事项Mapper接口
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public interface BusinessAdministrativeDecisionMapper 
{
    /**
     * 查询决策事项
     * 
     * @param id 决策事项ID
     * @return 决策事项
     */
    public BusinessAdministrativeDecision selectBusinessAdministrativeDecisionById(Long id);

    /**
     * 查询决策事项列表
     * 
     * @param businessAdministrativeDecision 决策事项
     * @return 决策事项集合
     */
    public List<BusinessAdministrativeDecision> selectBusinessAdministrativeDecisionList(BusinessAdministrativeDecision businessAdministrativeDecision);

    /**
     * 新增决策事项
     * 
     * @param businessAdministrativeDecision 决策事项
     * @return 结果
     */
    public int insertBusinessAdministrativeDecision(BusinessAdministrativeDecision businessAdministrativeDecision);

    /**
     * 修改决策事项
     * 
     * @param businessAdministrativeDecision 决策事项
     * @return 结果
     */
    public int updateBusinessAdministrativeDecision(BusinessAdministrativeDecision businessAdministrativeDecision);

    /**
     * 删除决策事项
     * 
     * @param id 决策事项ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeDecisionById(Long id);

    /**
     * 批量删除决策事项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeDecisionByIds(Long[] ids);
}
