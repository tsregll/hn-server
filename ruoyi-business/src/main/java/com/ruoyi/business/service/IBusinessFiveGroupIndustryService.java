package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessFiveGroupIndustry;

/**
 * 行业对标Service接口
 * 
 * @author ruoyi
 * @date 2021-08-20
 */
public interface IBusinessFiveGroupIndustryService 
{
    /**
     * 查询行业对标
     * 
     * @param id 行业对标ID
     * @return 行业对标
     */
    public BusinessFiveGroupIndustry selectBusinessFiveGroupIndustryById(Long id);

    /**
     * 查询行业对标列表
     * 
     * @param businessFiveGroupIndustry 行业对标
     * @return 行业对标集合
     */
    public List<BusinessFiveGroupIndustry> selectBusinessFiveGroupIndustryList(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    /**
     * 新增行业对标
     * 
     * @param businessFiveGroupIndustry 行业对标
     * @return 结果
     */
    public int insertBusinessFiveGroupIndustry(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    /**
     * 修改行业对标
     * 
     * @param businessFiveGroupIndustry 行业对标
     * @return 结果
     */
    public int updateBusinessFiveGroupIndustry(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    /**
     * 批量删除行业对标
     * 
     * @param ids 需要删除的行业对标ID
     * @return 结果
     */
    public int deleteBusinessFiveGroupIndustryByIds(Long[] ids);

    /**
     * 删除行业对标信息
     * 
     * @param id 行业对标ID
     * @return 结果
     */
    public int deleteBusinessFiveGroupIndustryById(Long id);

    String updateBusinessFiveGroupIndustryHj(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    Map<String, Object> selectByYearOrQuarter(BusinessFiveGroupIndustry businessFiveGroupIndustry);
//    Map<String, Object> selectMd(BusinessFiveGroupIndustry businessFiveGroupIndustry);
//    Map<String, Object> selectSd(BusinessFiveGroupIndustry businessFiveGroupIndustry);
//    Map<String, Object> selectFd(BusinessFiveGroupIndustry businessFiveGroupIndustry);
//    Map<String, Object> selectGf(BusinessFiveGroupIndustry businessFiveGroupIndustry);
//    Map<String, Object> selectQt(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    Map<String, Object> selectChart(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    List<Map<String,Object>> selectBar(BusinessFiveGroupIndustry businessFiveGroupIndustry);

    List<BusinessFiveGroupIndustry> selectBusinessFiveGroupIndustryList2(BusinessFiveGroupIndustry businessFiveGroupIndustry);
}
