package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公文发文功能对象 business_administrative_official_document
 * 
 * @author gwsh
 * @date 2021-03-03
 */
public class BusinessAdministrativeOfficialDocument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 公文发文状态 */
    @Excel(name = "公文发文状态")
    private Long officialDocumentStatus;

    /** 内容公文 */
    @Excel(name = "内容公文")
    private String officialDocumentContent;

    /** $column.columnComment */
    @Excel(name = "内容公文")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOfficialDocumentStatus(Long officialDocumentStatus) 
    {
        this.officialDocumentStatus = officialDocumentStatus;
    }

    public Long getOfficialDocumentStatus() 
    {
        return officialDocumentStatus;
    }
    public void setOfficialDocumentContent(String officialDocumentContent) 
    {
        this.officialDocumentContent = officialDocumentContent;
    }

    public String getOfficialDocumentContent() 
    {
        return officialDocumentContent;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("officialDocumentStatus", getOfficialDocumentStatus())
            .append("officialDocumentContent", getOfficialDocumentContent())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
