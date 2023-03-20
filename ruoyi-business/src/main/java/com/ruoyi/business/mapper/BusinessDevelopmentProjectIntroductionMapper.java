package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentProjectIntroduction;

/**
 * 规划发展项目介绍后台Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
public interface BusinessDevelopmentProjectIntroductionMapper 
{
    /**
     * 查询规划发展项目介绍后台
     * 
     * @param id 规划发展项目介绍后台ID
     * @return 规划发展项目介绍后台
     */
    public BusinessDevelopmentProjectIntroduction selectBusinessDevelopmentProjectIntroductionById(Long id);

    /**
     * 查询规划发展项目介绍后台列表
     * 
     * @param businessDevelopmentProjectIntroduction 规划发展项目介绍后台
     * @return 规划发展项目介绍后台集合
     */
    public List<BusinessDevelopmentProjectIntroduction> selectBusinessDevelopmentProjectIntroductionList(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction);

    /**
     * 新增规划发展项目介绍后台
     * 
     * @param businessDevelopmentProjectIntroduction 规划发展项目介绍后台
     * @return 结果
     */
    public int insertBusinessDevelopmentProjectIntroduction(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction);

    /**
     * 修改规划发展项目介绍后台
     * 
     * @param businessDevelopmentProjectIntroduction 规划发展项目介绍后台
     * @return 结果
     */
    public int updateBusinessDevelopmentProjectIntroduction(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction);

    /**
     * 删除规划发展项目介绍后台
     * 
     * @param id 规划发展项目介绍后台ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectIntroductionById(Long id);

    /**
     * 批量删除规划发展项目介绍后台
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectIntroductionByIds(Long[] ids);

    public List<String> selectBusinessDevelopmentProjectIntroductionOperatorByGroupList(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction);
}
