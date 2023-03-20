package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展项目文件后台对象 business_planning_development_project_file
 * 
 * @author yrb
 * @date 2021-04-28
 */
public class BusinessPlanningDevelopmentProjectFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 已投产日期 */
    private String projectDate;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectNumber;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String projectFileName;

    /** 文件类型 */
    private String projectFileType;

    /** 文件地址 */
    private String projectFileAddress;

    /** 文件说明 */
    @Excel(name = "文件说明")
    private String projectFileIllustration;

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
    public void setProjectNumber(String projectNumber) 
    {
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber() 
    {
        return projectNumber;
    }
    public void setProjectFileName(String projectFileName) 
    {
        this.projectFileName = projectFileName;
    }

    public String getProjectFileName() 
    {
        return projectFileName;
    }
    public void setProjectFileType(String projectFileType) 
    {
        this.projectFileType = projectFileType;
    }

    public String getProjectFileType() 
    {
        return projectFileType;
    }
    public void setProjectFileAddress(String projectFileAddress) 
    {
        this.projectFileAddress = projectFileAddress;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }

    public String getProjectFileAddress()
    {
        return projectFileAddress;
    }
    public void setProjectFileIllustration(String projectFileIllustration) 
    {
        this.projectFileIllustration = projectFileIllustration;
    }

    public String getProjectFileIllustration() 
    {
        return projectFileIllustration;
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
            .append("projectNumber", getProjectNumber())
            .append("projectFileName", getProjectFileName())
            .append("projectFileType", getProjectFileType())
            .append("projectFileAddress", getProjectFileAddress())
            .append("projectFileIllustration", getProjectFileIllustration())
            .toString();
    }
}
