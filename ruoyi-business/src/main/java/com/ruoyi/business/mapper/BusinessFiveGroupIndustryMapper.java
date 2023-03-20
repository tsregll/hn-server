package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessFiveGroupIndustry;

/**
 * 行业对标Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-20
 */
public interface BusinessFiveGroupIndustryMapper 
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
    public List<BusinessFiveGroupIndustry> selectBusinessFiveGroupIndustryOrderByQueryTimeList(BusinessFiveGroupIndustry businessFiveGroupIndustry);


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
     * 删除行业对标
     * 
     * @param id 行业对标ID
     * @return 结果
     */
    public int deleteBusinessFiveGroupIndustryById(Long id);

    /**
     * 批量删除行业对标
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessFiveGroupIndustryByIds(Long[] ids);

    List<BusinessFiveGroupIndustry> selectBusinessFiveGroupIndustryByGroupList(BusinessFiveGroupIndustry businessFiveGroupIndustry);
}
