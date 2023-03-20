package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeOfficialDocument;

/**
 * 公文发文功能Mapper接口
 * 
 * @author gwsh
 * @date 2021-03-03
 */
public interface BusinessAdministrativeOfficialDocumentMapper 
{
    /**
     * 查询公文发文功能
     * 
     * @param id 公文发文功能ID
     * @return 公文发文功能
     */
    public BusinessAdministrativeOfficialDocument selectBusinessAdministrativeOfficialDocumentById(Long id);

    /**
     * 查询公文发文功能列表
     * 
     * @param businessAdministrativeOfficialDocument 公文发文功能
     * @return 公文发文功能集合
     */
    public List<BusinessAdministrativeOfficialDocument> selectBusinessAdministrativeOfficialDocumentList(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument);

    /**
     * 新增公文发文功能
     * 
     * @param businessAdministrativeOfficialDocument 公文发文功能
     * @return 结果
     */
    public int insertBusinessAdministrativeOfficialDocument(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument);

    /**
     * 修改公文发文功能
     * 
     * @param businessAdministrativeOfficialDocument 公文发文功能
     * @return 结果
     */
    public int updateBusinessAdministrativeOfficialDocument(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument);

    /**
     * 删除公文发文功能
     * 
     * @param id 公文发文功能ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeOfficialDocumentById(Long id);

    /**
     * 批量删除公文发文功能
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeOfficialDocumentByIds(Long[] ids);
}
