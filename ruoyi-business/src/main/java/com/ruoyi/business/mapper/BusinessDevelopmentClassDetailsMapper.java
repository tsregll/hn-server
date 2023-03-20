package com.ruoyi.business.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessDevelopmentClassDetails;

/**
 * 发展专班详情Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public interface BusinessDevelopmentClassDetailsMapper 
{
    /**
     * 查询发展专班详情
     * 
     * @param id 发展专班详情ID
     * @return 发展专班详情
     */
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsById(Long id);

    /**
     * 查询发展专班详情列表
     * 
     * @param businessDevelopmentClassDetails 发展专班详情
     * @return 发展专班详情集合
     */
    public List<BusinessDevelopmentClassDetails> selectBusinessDevelopmentClassDetailsList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);

    /**
     * 新增发展专班详情
     * 
     * @param businessDevelopmentClassDetails 发展专班详情
     * @return 结果
     */
    public int insertBusinessDevelopmentClassDetails(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);

    /**
     * 修改发展专班详情
     * 
     * @param businessDevelopmentClassDetails 发展专班详情
     * @return 结果
     */
    public int updateBusinessDevelopmentClassDetails(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);

    /**
     * 删除发展专班详情
     * 
     * @param id 发展专班详情ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentClassDetailsById(Long id);

    /**
     * 批量删除发展专班详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentClassDetailsByIds(Long[] ids);

    List<String> selectBusinessDevelopmentClassDetailsByGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);

    List<String> selectBusinessDevelopmentClassOperatorDetailsByGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);
}
