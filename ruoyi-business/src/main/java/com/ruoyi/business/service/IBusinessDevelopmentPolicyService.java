package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentPolicy;

/**
 * 规划发展最新政策Service接口
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public interface IBusinessDevelopmentPolicyService 
{
    /**
     * 查询规划发展最新政策
     * 
     * @param id 规划发展最新政策ID
     * @return 规划发展最新政策
     */
    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyById(Long id);

    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyById2(Long id);

    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyByVoid();

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
     * 批量删除规划发展最新政策
     * 
     * @param ids 需要删除的规划发展最新政策ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentPolicyByIds(Long[] ids);

    /**
     * 删除规划发展最新政策信息
     * 
     * @param id 规划发展最新政策ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentPolicyById(Long id);
}
