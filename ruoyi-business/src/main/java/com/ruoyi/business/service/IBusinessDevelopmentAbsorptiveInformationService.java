package com.ruoyi.business.service;

import java.io.IOException;
import java.util.List;
import com.ruoyi.business.domain.BusinessDevelopmentAbsorptiveInformation;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展消纳板块Service接口
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public interface IBusinessDevelopmentAbsorptiveInformationService 
{
    /**
     * 查询规划发展消纳板块
     * 
     * @param id 规划发展消纳板块ID
     * @return 规划发展消纳板块
     */
    public BusinessDevelopmentAbsorptiveInformation selectBusinessDevelopmentAbsorptiveInformationById(Long id);
    public BusinessDevelopmentAbsorptiveInformation selectBusinessDevelopmentAbsorptiveInformationByVoid();
    /**
     * 查询规划发展消纳板块列表
     * 
     * @param businessDevelopmentAbsorptiveInformation 规划发展消纳板块
     * @return 规划发展消纳板块集合
     */
    public List<BusinessDevelopmentAbsorptiveInformation> selectBusinessDevelopmentAbsorptiveInformationList(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation);

    /**
     * 新增规划发展消纳板块
     * 
     * @param businessDevelopmentAbsorptiveInformation 规划发展消纳板块
     * @return 结果
     */
    public int insertBusinessDevelopmentAbsorptiveInformation(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation);

    /**
     * 修改规划发展消纳板块
     * 
     * @param businessDevelopmentAbsorptiveInformation 规划发展消纳板块
     * @return 结果
     */
    public int updateBusinessDevelopmentAbsorptiveInformation(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation);

    /**
     * 批量删除规划发展消纳板块
     * 
     * @param ids 需要删除的规划发展消纳板块ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentAbsorptiveInformationByIds(Long[] ids);

    /**
     * 删除规划发展消纳板块信息
     * 
     * @param id 规划发展消纳板块ID
     * @return 结果
     */
    public int deleteBusinessDevelopmentAbsorptiveInformationById(Long id);

    public AjaxResult informationFileUpload(MultipartFile file, String type, Long id) throws IOException;

}
