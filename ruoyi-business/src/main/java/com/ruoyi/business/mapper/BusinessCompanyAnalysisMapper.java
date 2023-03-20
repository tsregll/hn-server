package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessCompanyAnalysis;

/**
 * 清能公司分析指标Mapper接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface BusinessCompanyAnalysisMapper 
{
    /**
     * 查询清能公司分析指标
     * 
     * @param id 清能公司分析指标ID
     * @return 清能公司分析指标
     */
    public BusinessCompanyAnalysis selectBusinessCompanyAnalysisById(Long id);

    /**
     * 查询清能公司分析指标列表
     * 
     * @param businessCompanyAnalysis 清能公司分析指标
     * @return 清能公司分析指标集合
     */
    public List<BusinessCompanyAnalysis> selectBusinessCompanyAnalysisList(BusinessCompanyAnalysis businessCompanyAnalysis);

    /**
     * 新增清能公司分析指标
     * 
     * @param businessCompanyAnalysis 清能公司分析指标
     * @return 结果
     */
    public int insertBusinessCompanyAnalysis(BusinessCompanyAnalysis businessCompanyAnalysis);

    /**
     * 修改清能公司分析指标
     * 
     * @param businessCompanyAnalysis 清能公司分析指标
     * @return 结果
     */
    public int updateBusinessCompanyAnalysis(BusinessCompanyAnalysis businessCompanyAnalysis);

    /**
     * 删除清能公司分析指标
     * 
     * @param id 清能公司分析指标ID
     * @return 结果
     */
    public int deleteBusinessCompanyAnalysisById(Long id);

    /**
     * 批量删除清能公司分析指标
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessCompanyAnalysisByIds(Long[] ids);
}
