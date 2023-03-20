package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructing;

/**
 * 规划发展在建项目Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-04
 */
public interface BusinessDevelopmentProjectConstructingMapper 
{
    /**
     * 查询规划发展在建项目
     * 
     * @param id 规划发展在建项目ID
     * @return 规划发展在建项目
     */
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingById(Long id);

    /**
     * 查询规划发展在建项目列表
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 规划发展在建项目集合
     */
    public List<BusinessDevelopmentProjectConstructing> selectBusinessDevelopmentProjectConstructingListByqt(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);
    /**
     * 查询规划发展在建项目列表
     *
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 规划发展在建项目集合
     */
    public List<BusinessDevelopmentProjectConstructing> selectBusinessDevelopmentProjectConstructingList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);
    /**
     * 查询规划发展在建项目项目名称列表
     *
     * @param projectName 项目名称
     * @return 规划发展在建项目项目名称集合
     */
    public List<String> selectBusinessConstructingProjectNameList(String projectName);
    /**
     * 新增规划发展在建项目
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 结果
     */
    public int insertBusinessDevelopmentProjectConstructing(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);

    /**
     * 修改规划发展在建项目
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 结果
     */
    public int updateBusinessDevelopmentProjectConstructing(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);

    /**
     * 删除规划发展在建项目
     * 
     * @param id 规划发展在建项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectConstructingById(Long id);

    /**
     * 批量删除规划发展在建项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectConstructingByIds(Long[] ids);
    /**
     * 查询操作人列表
     *
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 结果
     */
    List<String> selectBusinessConstructingOperatorByGroupList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);
}
