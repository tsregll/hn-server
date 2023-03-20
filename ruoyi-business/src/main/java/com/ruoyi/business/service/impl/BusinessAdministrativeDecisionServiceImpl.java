package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAdministrativeDecisionMapper;
import com.ruoyi.business.domain.BusinessAdministrativeDecision;
import com.ruoyi.business.service.IBusinessAdministrativeDecisionService;

/**
 * 决策事项Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-02
 */
@Service
public class BusinessAdministrativeDecisionServiceImpl implements IBusinessAdministrativeDecisionService 
{
    @Autowired
    private BusinessAdministrativeDecisionMapper businessAdministrativeDecisionMapper;

    /**
     * 查询决策事项
     * 
     * @param id 决策事项ID
     * @return 决策事项
     */
    @Override
    public BusinessAdministrativeDecision selectBusinessAdministrativeDecisionById(Long id)
    {
        return businessAdministrativeDecisionMapper.selectBusinessAdministrativeDecisionById(id);
    }

    /**
     * 查询决策事项列表
     * 
     * @param businessAdministrativeDecision 决策事项
     * @return 决策事项
     */
    @Override
    public List<BusinessAdministrativeDecision> selectBusinessAdministrativeDecisionList(BusinessAdministrativeDecision businessAdministrativeDecision)
    {
        return businessAdministrativeDecisionMapper.selectBusinessAdministrativeDecisionList(businessAdministrativeDecision);
    }

    /**
     * 新增决策事项
     * 
     * @param businessAdministrativeDecision 决策事项
     * @return 结果
     */
    @Override
    public int insertBusinessAdministrativeDecision(BusinessAdministrativeDecision businessAdministrativeDecision)
    {
        businessAdministrativeDecision.setCreateTime(DateUtils.getNowDate());
        return businessAdministrativeDecisionMapper.insertBusinessAdministrativeDecision(businessAdministrativeDecision);
    }

    /**
     * 修改决策事项
     * 
     * @param businessAdministrativeDecision 决策事项
     * @return 结果
     */
    @Override
    public int updateBusinessAdministrativeDecision(BusinessAdministrativeDecision businessAdministrativeDecision)
    {
        businessAdministrativeDecision.setUpdateTime(DateUtils.getNowDate());
        return businessAdministrativeDecisionMapper.updateBusinessAdministrativeDecision(businessAdministrativeDecision);
    }

    /**
     * 批量删除决策事项
     * 
     * @param ids 需要删除的决策事项ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeDecisionByIds(Long[] ids)
    {
        return businessAdministrativeDecisionMapper.deleteBusinessAdministrativeDecisionByIds(ids);
    }

    /**
     * 删除决策事项信息
     * 
     * @param id 决策事项ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeDecisionById(Long id)
    {
        return businessAdministrativeDecisionMapper.deleteBusinessAdministrativeDecisionById(id);
    }
}
