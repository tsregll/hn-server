package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展最新政策对象 business_development_policy
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public class BusinessDevelopmentPolicy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 系统默认时间，精确到年月日时分秒 */
    @Excel(name = "系统默认时间，精确到年月日时分秒")
    private String defaultTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operatorNumber;

    /** 标题 */
    @Excel(name = "标题")
    private String policyTitle;

    /** 政策内容 */
    @Excel(name = "政策内容")
    private String policyContent;

    /** 政策年度 */
    @Excel(name = "政策年度")
    private String policyTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setDefaultTime(String defaultTime) 
    {
        this.defaultTime = defaultTime;
    }

    public String getDefaultTime() 
    {
        return defaultTime;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setOperatorNumber(String operatorNumber) 
    {
        this.operatorNumber = operatorNumber;
    }

    public String getOperatorNumber() 
    {
        return operatorNumber;
    }
    public void setPolicyTitle(String policyTitle) 
    {
        this.policyTitle = policyTitle;
    }

    public String getPolicyTitle() 
    {
        return policyTitle;
    }
    public void setPolicyContent(String policyContent) 
    {
        this.policyContent = policyContent;
    }

    public String getPolicyContent() 
    {
        return policyContent;
    }
    public void setPolicyTime(String policyTime) 
    {
        this.policyTime = policyTime;
    }

    public String getPolicyTime() 
    {
        return policyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("defaultTime", getDefaultTime())
            .append("operator", getOperator())
            .append("operatorNumber", getOperatorNumber())
            .append("policyTitle", getPolicyTitle())
            .append("policyContent", getPolicyContent())
            .append("policyTime", getPolicyTime())
            .toString();
    }
}
