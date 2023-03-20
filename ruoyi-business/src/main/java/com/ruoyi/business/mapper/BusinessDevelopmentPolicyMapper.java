package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentPolicy;

/**
 * 规划发展最新政策Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public interface BusinessDevelopmentPolicyMapper 
{
    /**
     * 查询规划发展最新政策
     * 
     * @param id 规划发展最新政策ID
     * @return 规划发展最新政策
     */
    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyById(Long id);

    /**
     * 查询规划发展最新政策列表
     * 
     * @param businessDevelopmentPolicy 规划发展最新政策
     * @return 规划发展最新政策集合
     */
    public List<BusinessDevelopmentPolicy> selectBusinessDevelopmentPolicyList(BusinessDevelopmentPolicy businessDevelopmentPolicy);

    /**
     * 新增规划发展最新政策
     * 
     * @param businessDevelopmentPolicy 规划发展最新政策
     * @return 结果
     */
    public int insertBusinessDevelopmentPolicy(BusinessDevelopmentPolicy businessDevelopmentPolicy);

    /**
     * 修改规划发展最新政策
     * 
     * @param businessDevelopmentPolicy 规划发展最新政策
     * @return 结果
     */
    public int updateBusinessDevelopmentPolicy(BusinessDevelopmentPolicy businessDevelopmentPolicy);

    /**
     * 删除规划发展最新政策
     * 
     * @param id 规划发展最新政策ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentPolicyById(Long id);

    /**
     * 批量删除规划发展最新政策
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentPolicyByIds(Long[] ids);
}
