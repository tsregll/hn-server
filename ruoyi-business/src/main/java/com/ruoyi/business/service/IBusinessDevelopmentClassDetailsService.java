package com.ruoyi.business.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessDevelopmentClassDetails;
import com.ruoyi.business.vo.BusinessDevelopmentClassDetailsVo;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 发展专班详情Service接口
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public interface IBusinessDevelopmentClassDetailsService 
{
    /**
     * 查询发展专班详情
     * 
     * @param id 发展专班详情ID
     * @return 发展专班详情
     */
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsById(Long id);
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsById(Long id,String type);
    /**
     * 查询发展专班详情列表
     * 
     * @param businessDevelopmentClassDetails 发展专班详情
     * @return 发展专班详情集合
     */
    public List<BusinessDevelopmentClassDetails> selectBusinessDevelopmentClassDetailsList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);

    public List<String> selectBusinessDevelopmentClassDetailsByGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);
    public List<String> selectBusinessDevelopmentClassOperatorDetailsByGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails);
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
     * 批量删除发展专班详情
     * 
     * @param ids 需要删除的发展专班详情ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentClassDetailsByIds(Long[] ids);

    /**
     * 删除发展专班详情信息
     * 
     * @param id 发展专班详情ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentClassDetailsById(Long id);
    public AjaxResult specialityFileUpload(MultipartFile file, String type, Long id, BusinessDevelopmentClassDetailsVo address) throws IOException;
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsByVoid();
}
