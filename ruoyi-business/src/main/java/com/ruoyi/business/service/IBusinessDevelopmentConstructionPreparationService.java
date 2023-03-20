package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentConstructionPreparation;
import com.ruoyi.business.vo.BusinessDevelopmentConstructionPreparationVo;

/**
 * 规划发展施工准备项目Service接口
 * 
 * @author ruoyi
 * @date 2021-07-28
 */
public interface IBusinessDevelopmentConstructionPreparationService 
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
     * 批量删除规划发展施工准备项目
     * 
     * @param ids 需要删除的规划发展施工准备项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentConstructionPreparationByIds(Long[] ids);

    /**
     * 删除规划发展施工准备项目信息
     * 
     * @param id 规划发展施工准备项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentConstructionPreparationById(Long id);

    public BusinessDevelopmentConstructionPreparation selectBusinessDevelopmentConstructionPreparationByVoid();

    List<String> selectBusinessDevelopmentConstructionPreparationOperatorByGroupList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation);

    List<BusinessDevelopmentConstructionPreparationVo> selectBusinessDevelopmentConstructionPreparationList2(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation);
}
