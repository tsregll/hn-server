package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展项目后台对象 business_planning_development
 * 
 * @author yrb
 * @date 2021-04-25
 */
public class BusinessPlanningDevelopment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projectStatus;

    /** 前期开发状态 */
    @Excel(name = "前期开发状态")
    private String projectEarlyStatus;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 项目计划容量 */
    @Excel(name = "项目计划容量")
    private String projectInstalledCapacity;

    /** 地区 */
    @Excel(name = "地区")
    private String projectRegionDistrict;

    /** 责任单位 */
    @Excel(name = "责任单位")
    private String projectResponsibilityUnit;

    /** 开发类型 */
    @Excel(name = "开发类型")
    private String projectDevelopmentType;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String projectDevelopmentModalities;

    /** 负责人 */
    @Excel(name = "负责人")
    private String projectResponsiblePerson;

    /** 启动日期（前期开发） */
    @Excel(name = "启动日期（前期开发）")
    private String projectStartDate;

    /** 拟开工日期（已开工） */
    @Excel(name = "拟开工日期（已开工）")
    private String projectProposedStartDate;

    /** 首次并网时间（已投产） */
    @Excel(name = "首次并网时间（已投产）")
    private String projectFirstConnectionDate;

    /** 投产总装机容量 */
    @Excel(name = "投产总装机容量")
    private String projectProductionAllCapacity;

    /** 项目介绍 */
    @Excel(name = "项目介绍")
    private String projectIntroduce;

    /** 项目地图所在位置X轴 */
    @Excel(name = "项目地图所在位置X轴")
    private String projectXAxis;

    /** 项目地图所在位置Y轴 */
    @Excel(name = "项目地图所在位置Y轴")
    private String projectYAxis;

    /** 全投产时间（已投产） */
    @Excel(name = "全投产时间（已投产）")
    private String projectFullCommissioningDate;

    /** 达标投产时间（已投产） */
    @Excel(name = "达标投产时间（已投产）")
    private String projectReachTheStandardDate;

    /** 竣工验收时间（已投产） */
    @Excel(name = "竣工验收时间（已投产）")
    private String projectFinalAcceptanceDate;

    /** 是否竣工 */
    @Excel(name = "是否竣工")
    private String projectFinish;

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
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectStatus(String projectStatus) 
    {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus() 
    {
        return projectStatus;
    }
    public void setProjectEarlyStatus(String projectEarlyStatus) 
    {
        this.projectEarlyStatus = projectEarlyStatus;
    }

    public String getProjectEarlyStatus() 
    {
        return projectEarlyStatus;
    }
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setProjectInstalledCapacity(String projectInstalledCapacity) 
    {
        this.projectInstalledCapacity = projectInstalledCapacity;
    }

    public String getProjectInstalledCapacity() 
    {
        return projectInstalledCapacity;
    }
    public void setProjectRegionDistrict(String projectRegionDistrict) 
    {
        this.projectRegionDistrict = projectRegionDistrict;
    }

    public String getProjectRegionDistrict() 
    {
        return projectRegionDistrict;
    }
    public void setProjectResponsibilityUnit(String projectResponsibilityUnit) 
    {
        this.projectResponsibilityUnit = projectResponsibilityUnit;
    }

    public String getProjectResponsibilityUnit() 
    {
        return projectResponsibilityUnit;
    }
    public void setProjectDevelopmentType(String projectDevelopmentType) 
    {
        this.projectDevelopmentType = projectDevelopmentType;
    }

    public String getProjectDevelopmentType() 
    {
        return projectDevelopmentType;
    }
    public void setProjectDevelopmentModalities(String projectDevelopmentModalities) 
    {
        this.projectDevelopmentModalities = projectDevelopmentModalities;
    }

    public String getProjectDevelopmentModalities() 
    {
        return projectDevelopmentModalities;
    }
    public void setProjectResponsiblePerson(String projectResponsiblePerson) 
    {
        this.projectResponsiblePerson = projectResponsiblePerson;
    }

    public String getProjectResponsiblePerson() 
    {
        return projectResponsiblePerson;
    }
    public void setProjectStartDate(String projectStartDate) 
    {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectStartDate() 
    {
        return projectStartDate;
    }
    public void setProjectProposedStartDate(String projectProposedStartDate) 
    {
        this.projectProposedStartDate = projectProposedStartDate;
    }

    public String getProjectProposedStartDate() 
    {
        return projectProposedStartDate;
    }
    public void setProjectFirstConnectionDate(String projectFirstConnectionDate) 
    {
        this.projectFirstConnectionDate = projectFirstConnectionDate;
    }

    public String getProjectFirstConnectionDate() 
    {
        return projectFirstConnectionDate;
    }
    public void setProjectProductionAllCapacity(String projectProductionAllCapacity) 
    {
        this.projectProductionAllCapacity = projectProductionAllCapacity;
    }

    public String getProjectProductionAllCapacity() 
    {
        return projectProductionAllCapacity;
    }
    public void setProjectIntroduce(String projectIntroduce) 
    {
        this.projectIntroduce = projectIntroduce;
    }

    public String getProjectIntroduce() 
    {
        return projectIntroduce;
    }
    public void setProjectXAxis(String projectXAxis) 
    {
        this.projectXAxis = projectXAxis;
    }

    public String getProjectXAxis() 
    {
        return projectXAxis;
    }
    public void setProjectYAxis(String projectYAxis) 
    {
        this.projectYAxis = projectYAxis;
    }

    public String getProjectYAxis() 
    {
        return projectYAxis;
    }
    public void setProjectFullCommissioningDate(String projectFullCommissioningDate) 
    {
        this.projectFullCommissioningDate = projectFullCommissioningDate;
    }

    public String getProjectFullCommissioningDate() 
    {
        return projectFullCommissioningDate;
    }
    public void setProjectReachTheStandardDate(String projectReachTheStandardDate) 
    {
        this.projectReachTheStandardDate = projectReachTheStandardDate;
    }

    public String getProjectReachTheStandardDate() 
    {
        return projectReachTheStandardDate;
    }
    public void setProjectFinalAcceptanceDate(String projectFinalAcceptanceDate) 
    {
        this.projectFinalAcceptanceDate = projectFinalAcceptanceDate;
    }

    public String getProjectFinalAcceptanceDate() 
    {
        return projectFinalAcceptanceDate;
    }
    public void setProjectFinish(String projectFinish) 
    {
        this.projectFinish = projectFinish;
    }

    public String getProjectFinish() 
    {
        return projectFinish;
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
            .append("projectName", getProjectName())
            .append("projectStatus", getProjectStatus())
            .append("projectEarlyStatus", getProjectEarlyStatus())
            .append("projectType", getProjectType())
            .append("projectInstalledCapacity", getProjectInstalledCapacity())
            .append("projectRegionDistrict", getProjectRegionDistrict())
            .append("projectResponsibilityUnit", getProjectResponsibilityUnit())
            .append("projectDevelopmentType", getProjectDevelopmentType())
            .append("projectDevelopmentModalities", getProjectDevelopmentModalities())
            .append("projectResponsiblePerson", getProjectResponsiblePerson())
            .append("projectStartDate", getProjectStartDate())
            .append("projectProposedStartDate", getProjectProposedStartDate())
            .append("projectFirstConnectionDate", getProjectFirstConnectionDate())
            .append("projectProductionAllCapacity", getProjectProductionAllCapacity())
            .append("projectIntroduce", getProjectIntroduce())
            .append("projectXAxis", getProjectXAxis())
            .append("projectYAxis", getProjectYAxis())
            .append("projectFullCommissioningDate", getProjectFullCommissioningDate())
            .append("projectReachTheStandardDate", getProjectReachTheStandardDate())
            .append("projectFinalAcceptanceDate", getProjectFinalAcceptanceDate())
            .append("projectFinish", getProjectFinish())
            .toString();
    }
}
