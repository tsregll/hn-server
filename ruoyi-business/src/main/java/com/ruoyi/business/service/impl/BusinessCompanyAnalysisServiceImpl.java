package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessCompanyAnalysisMapper;
import com.ruoyi.business.domain.BusinessCompanyAnalysis;
import com.ruoyi.business.service.IBusinessCompanyAnalysisService;

/**
 * 清能公司分析指标Service业务层处理
 * 
 * @author lpf
 * @date 2021-03-02
 */
@Service
public class BusinessCompanyAnalysisServiceImpl implements IBusinessCompanyAnalysisService 
{
    @Autowired
    private BusinessCompanyAnalysisMapper businessCompanyAnalysisMapper;

    /**
     * 查询清能公司分析指标
     * 
     * @param id 清能公司分析指标ID
     * @return 清能公司分析指标
     */
    @Override
    public BusinessCompanyAnalysis selectBusinessCompanyAnalysisById(Long id)
    {
        return businessCompanyAnalysisMapper.selectBusinessCompanyAnalysisById(id);
    }

    /**
     * 查询清能公司分析指标列表
     * 
     * @param businessCompanyAnalysis 清能公司分析指标
     * @return 清能公司分析指标
     */
    @Override
    public List<BusinessCompanyAnalysis> selectBusinessCompanyAnalysisList(BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        return businessCompanyAnalysisMapper.selectBusinessCompanyAnalysisList(businessCompanyAnalysis);
    }

    /**
     * 新增清能公司分析指标
     * 
     * @param businessCompanyAnalysis 清能公司分析指标
     * @return 结果
     */
    @Override
    public int insertBusinessCompanyAnalysis(BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        businessCompanyAnalysis.setCreateTime(DateUtils.getNowDate());
        return businessCompanyAnalysisMapper.insertBusinessCompanyAnalysis(businessCompanyAnalysis);
    }

    /**
     * 修改清能公司分析指标
     * 
     * @param businessCompanyAnalysis 清能公司分析指标
     * @return 结果
     */
    @Override
    public int updateBusinessCompanyAnalysis(BusinessCompanyAnalysis businessCompanyAnalysis)
    {
        businessCompanyAnalysis.setUpdateTime(DateUtils.getNowDate());
        return businessCompanyAnalysisMapper.updateBusinessCompanyAnalysis(businessCompanyAnalysis);
    }

    /**
     * 批量删除清能公司分析指标
     * 
     * @param ids 需要删除的清能公司分析指标ID
     * @return 结果
     */
    @Override
    public int deleteBusinessCompanyAnalysisByIds(Long[] ids)
    {
        return businessCompanyAnalysisMapper.deleteBusinessCompanyAnalysisByIds(ids);
    }

    /**
     * 删除清能公司分析指标信息
     * 
     * @param id 清能公司分析指标ID
     * @return 结果
     */
    @Override
    public int deleteBusinessCompanyAnalysisById(Long id)
    {
        return businessCompanyAnalysisMapper.deleteBusinessCompanyAnalysisById(id);
    }
}
