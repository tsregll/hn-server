package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展项目详情后台对象 business_planning_development_details
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
public class BusinessPlanningDevelopmentDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectNumber;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projectStatus;

    /** 详情名称 */
    @Excel(name = "详情名称")
    private String projectDetailsName;

    /** 详情状态 */
    @Excel(name = "详情状态")
    private String projectDetailsStatus;

    /** 批复项目容量 */
    @Excel(name = "批复项目容量")
    private String projectApprovalCapacity;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String projectFileName;

    /** 附件地址 */
    @Excel(name = "附件地址")
    private String projectFileAddress;

    /** 附件类型 */
    @Excel(name = "附件类型")
    private String projectFileType;

    /** 完成时间 */
    @Excel(name = "完成时间")
    private String projectFinishDate;

    /** 备用字段 */
    private String projectBackup;

    private String projectFinishTime;

    private String projectPreparationTime;

    public String getProjectFinishTime() {
        return projectFinishTime;
    }

    public void setProjectFinishTime(String projectFinishTime) {
        this.projectFinishTime = projectFinishTime;
    }

    public String getProjectPreparationTime() {
        return projectPreparationTime;
    }

    public void setProjectPreparationTime(String projectPreparationTime) {
        this.projectPreparationTime = projectPreparationTime;
    }

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
    public void setProjectStatus(String projectStatus) 
    {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus() 
    {
        return projectStatus;
    }
    public void setProjectDetailsName(String projectDetailsName) 
    {
        this.projectDetailsName = projectDetailsName;
    }

    public String getProjectDetailsName() 
    {
        return projectDetailsName;
    }
    public void setProjectDetailsStatus(String projectDetailsStatus) 
    {
        this.projectDetailsStatus = projectDetailsStatus;
    }

    public String getProjectDetailsStatus() 
    {
        return projectDetailsStatus;
    }
    public void setProjectApprovalCapacity(String projectApprovalCapacity) 
    {
        this.projectApprovalCapacity = projectApprovalCapacity;
    }

    public String getProjectApprovalCapacity() 
    {
        return projectApprovalCapacity;
    }
    public void setProjectFileName(String projectFileName) 
    {
        this.projectFileName = projectFileName;
    }

    public String getProjectFileName() 
    {
        return projectFileName;
    }
    public void setProjectFileAddress(String projectFileAddress) 
    {
        this.projectFileAddress = projectFileAddress;
    }

    public String getProjectFileAddress() 
    {
        return projectFileAddress;
    }
    public void setProjectFileType(String projectFileType) 
    {
        this.projectFileType = projectFileType;
    }

    public String getProjectFileType() 
    {
        return projectFileType;
    }
    public void setProjectFinishDate(String projectFinishDate) 
    {
        this.projectFinishDate = projectFinishDate;
    }

    public String getProjectFinishDate() 
    {
        return projectFinishDate;
    }
    public void setProjectBackup(String projectBackup) 
    {
        this.projectBackup = projectBackup;
    }

    public String getProjectBackup() 
    {
        return projectBackup;
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
            .append("projectStatus", getProjectStatus())
            .append("projectDetailsName", getProjectDetailsName())
            .append("projectDetailsStatus", getProjectDetailsStatus())
            .append("projectApprovalCapacity", getProjectApprovalCapacity())
            .append("projectFileName", getProjectFileName())
            .append("projectFileAddress", getProjectFileAddress())
            .append("projectFileType", getProjectFileType())
            .append("projectFinishDate", getProjectFinishDate())
            .append("projectBackup", getProjectBackup())
            .toString();
    }
}
