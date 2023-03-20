package com.ruoyi.business.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructing;
import com.ruoyi.business.vo.BusinessDevelopmentConstructingVo;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展在建项目Service接口
 * 
 * @author ruoyi
 * @date 2021-08-04
 */
public interface IBusinessDevelopmentProjectConstructingService 
{
    /**
     * 查询规划发展在建项目
     * 
     * @param id 规划发展在建项目ID
     * @return 规划发展在建项目
     */
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingById(Long id);
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingQianDuanById(Long id);
    public Map<String,Object> selectBusinessDevelopmentProjectConstructingById2(Long id);
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingByVoid();

    /**
     * 查询规划发展在建项目列表
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 规划发展在建项目集合
     */
    public List<BusinessDevelopmentProjectConstructing> selectBusinessDevelopmentProjectConstructingList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);
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
     * 批量删除规划发展在建项目
     * 
     * @param ids 需要删除的规划发展在建项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectConstructingByIds(Long[] ids);

    /**
     * 删除规划发展在建项目信息
     * 
     * @param id 规划发展在建项目ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentProjectConstructingById(Long id);

    List<String> selectBusinessConstructingProjectNameList(String projectName);

    List<String> selectBusinessConstructingOperatorByGroupList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);

    List<BusinessDevelopmentConstructingVo> selectBusinessDevelopmentProjectConstructingList2(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing);

    Map<String, Object> deleteBusinessDevelopmentProjectConstructingNodeByIdToChang(String projectNode,Long id);

    AjaxResult constructingFileUpload(MultipartFile file) throws IOException;
}
