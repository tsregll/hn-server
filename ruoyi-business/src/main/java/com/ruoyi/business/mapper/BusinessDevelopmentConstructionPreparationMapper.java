package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentConstructionPreparation;

/**
 * 规划发展施工准备项目Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-28
 */
public interface BusinessDevelopmentConstructionPreparationMapper 
{
    /**
     * 查询规划发展施工准备项目
     * 
     * @param id 规划发展施工准备项目ID
     * @return 规划发展施工准备项目
     */
    public BusinessDevelopmentConstructionPreparation selectBusinessDevelopmentConstructionPreparationById(Long id);

    /**
     * 查询规划发展施工准备项目列表
     * 
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 规划发展施工准备项目集合
     */
    public List<BusinessDevelopmentConstructionPreparation> selectBusinessDevelopmentConstructionPreparationList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation);

    /**
     * 新增规划发展施工准备项目
     * 
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 结果
     */
    public int insertBusinessDevelopmentConstructionPreparation(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation);

    /**
     * 修改规划发展施工准备项目
     * 
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 结果
     */
    public int updateBusinessDevelopmentConstructionPreparation(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation);

    /**
     * 删除规划发展施工准备项目
     * 
     * @param id 规划发展施工准备项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentConstructionPreparationById(Long id);

    /**
     * 批量删除规划发展施工准备项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentConstructionPreparationByIds(Long[] ids);

    /**
     * 规划发展施工准备项目操作人列表
     *
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 结果
     */
    public List<String> selectBusinessDevelopmentConstructionPreparationOperatorByGroupList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation);
}
