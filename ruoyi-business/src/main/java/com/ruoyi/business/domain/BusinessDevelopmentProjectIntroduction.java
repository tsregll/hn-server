package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展项目介绍后台对象 business_development_project_introduction
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
public class BusinessDevelopmentProjectIntroduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 日期 */
    @Excel(name = "日期")
    private String defaultTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作工号 */
    @Excel(name = "操作工号")
    private String operatorNumber;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 标题 */
    @Excel(name = "标题")
    private String projectTitle;

    /** 内容 */
    @Excel(name = "内容")
    private String projectContent;

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
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setProjectTitle(String projectTitle) 
    {
        this.projectTitle = projectTitle;
    }

    public String getProjectTitle() 
    {
        return projectTitle;
    }
    public void setProjectContent(String projectContent) 
    {
        this.projectContent = projectContent;
    }

    public String getProjectContent() 
    {
        return projectContent;
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
            .append("defaultTime", getDefaultTime())
            .append("operator", getOperator())
            .append("operatorNumber", getOperatorNumber())
            .append("projectType", getProjectType())
            .append("projectTitle", getProjectTitle())
            .append("projectContent", getProjectContent())
            .append("remark", getRemark())
            .toString();
    }
}
