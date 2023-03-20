package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAdministrativeOfficialDocumentMapper;
import com.ruoyi.business.domain.BusinessAdministrativeOfficialDocument;
import com.ruoyi.business.service.IBusinessAdministrativeOfficialDocumentService;

/**
 * 公文发文功能Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-03
 */
@Service
public class BusinessAdministrativeOfficialDocumentServiceImpl implements IBusinessAdministrativeOfficialDocumentService 
{
    @Autowired
    private BusinessAdministrativeOfficialDocumentMapper businessAdministrativeOfficialDocumentMapper;

    /**
     * 查询公文发文功能
     * 
     * @param id 公文发文功能ID
     * @return 公文发文功能
     */
    @Override
    public BusinessAdministrativeOfficialDocument selectBusinessAdministrativeOfficialDocumentById(Long id)
    {
        return businessAdministrativeOfficialDocumentMapper.selectBusinessAdministrativeOfficialDocumentById(id);
    }

    /**
     * 查询公文发文功能列表
     * 
     * @param businessAdministrativeOfficialDocument 公文发文功能
     * @return 公文发文功能
     */
    @Override
    public List<BusinessAdministrativeOfficialDocument> selectBusinessAdministrativeOfficialDocumentList(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument)
    {
        return businessAdministrativeOfficialDocumentMapper.selectBusinessAdministrativeOfficialDocumentList(businessAdministrativeOfficialDocument);
    }

    /**
     * 新增公文发文功能
     * 
     * @param businessAdministrativeOfficialDocument 公文发文功能
     * @return 结果
     */
    @Override
    public int insertBusinessAdministrativeOfficialDocument(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument)
    {
        businessAdministrativeOfficialDocument.setCreateTime(DateUtils.getNowDate());
        return businessAdministrativeOfficialDocumentMapper.insertBusinessAdministrativeOfficialDocument(businessAdministrativeOfficialDocument);
    }

    /**
     * 修改公文发文功能
     * 
     * @param businessAdministrativeOfficialDocument 公文发文功能
     * @return 结果
     */
    @Override
    public int updateBusinessAdministrativeOfficialDocument(BusinessAdministrativeOfficialDocument businessAdministrativeOfficialDocument)
    {
        businessAdministrativeOfficialDocument.setUpdateTime(DateUtils.getNowDate());
        return businessAdministrativeOfficialDocumentMapper.updateBusinessAdministrativeOfficialDocument(businessAdministrativeOfficialDocument);
    }

    /**
     * 批量删除公文发文功能
     * 
     * @param ids 需要删除的公文发文功能ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeOfficialDocumentByIds(Long[] ids)
    {
        return businessAdministrativeOfficialDocumentMapper.deleteBusinessAdministrativeOfficialDocumentByIds(ids);
    }

    /**
     * 删除公文发文功能信息
     * 
     * @param id 公文发文功能ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeOfficialDocumentById(Long id)
    {
        return businessAdministrativeOfficialDocumentMapper.deleteBusinessAdministrativeOfficialDocumentById(id);
    }
}
