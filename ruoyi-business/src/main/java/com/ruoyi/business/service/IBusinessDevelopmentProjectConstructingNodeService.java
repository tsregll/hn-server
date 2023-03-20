package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructingNode;
import com.ruoyi.business.vo.BusinessDevelopmentProjectConstructingNodeVo;
import com.ruoyi.business.vo.constructingNodeQianDuanVo;

/**
 * 规划发展在建项目关键节点Service接口
 * 
 * @author ruoyi
 * @date 2021-08-06
 */
public interface IBusinessDevelopmentProjectConstructingNodeService 
{
    /**
     * 查询规划发展在建项目关键节点
     * 
     * @param id 规划发展在建项目关键节点ID
     * @return 规划发展在建项目关键节点
     */
    public BusinessDevelopmentProjectConstructingNode selectBusinessDevelopmentProjectConstructingNodeById(Long id);

    /**
     * 查询规划发展在建项目关键节点列表
     * 
     * @param businessDevelopmentProjectConstructingNode 规划发展在建项目关键节点
     * @return 规划发展在建项目关键节点集合
     */
    public List<BusinessDevelopmentProjectConstructingNode> selectBusinessDevelopmentProjectConstructingNodeList(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode);

    /**
     * 新增规划发展在建项目关键节点
     * 
     * @param businessDevelopmentProjectConstructingNode 规划发展在建项目关键节点
     * @return 结果
     */
    public int insertBusinessDevelopmentProjectConstructingNode(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode);

    /**
     * 修改规划发展在建项目关键节点
     * 
     * @param businessDevelopmentProjectConstructingNode 规划发展在建项目关键节点
     * @return 结果
     */
    public int updateBusinessDevelopmentProjectConstructingNode(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode);

    /**
     * 批量删除规划发展在建项目关键节点
     * 
     * @param ids 需要删除的规划发展在建项目关键节点ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectConstructingNodeByIds(Long[] ids);

    /**
     * 删除规划发展在建项目关键节点信息
     * 
     * @param id 规划发展在建项目关键节点ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectConstructingNodeById(Long id);

    public List<BusinessDevelopmentProjectConstructingNodeVo> selectBusinessDevelopmentProjectConstructingNodeVoByIds(String ids);

//    public List<BusinessDevelopmentProjectConstructingNode> selectBusinessDevelopmentProjectConstructingNodeByIds(String ids);

    public List<Map<String,Object>> selectBusinessDevelopmentProjectConstructingNodeByIds(String ids);

    public Map<String,Object> selectBusinessDevelopmentProjectConstructingNodeGroupByIds(String ids);
}
