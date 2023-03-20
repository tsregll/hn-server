package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展对象 business_planning_develop
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public class BusinessPlanningDevelop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目编号 */
    private Long id;

    /** 规划时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "规划时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 装机容量 */
    @Excel(name = "装机容量")
    private String installedCapacity;

    /** 项目地址 */
    @Excel(name = "项目地址")
    private String projectAddress;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projectStatus;

    /** 投资开发/合作协议 */
    @Excel(name = "投资开发/合作协议")
    private String idCa;

    /** 规划地址 */
    @Excel(name = "规划地址")
    private String planningAddresses;

    /** 土地预审 */
    @Excel(name = "土地预审")
    private String landPretrial;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 林业 */
    @Excel(name = "林业")
    private String forestry;

    /** 环保 */
    @Excel(name = "环保")
    private String environmentalProtection;

    /** 水保 */
    @Excel(name = "水保")
    private String waterConservation;

    /** 接入系统 */
    @Excel(name = "接入系统")
    private String accessSystem;

    /** 其他（压矿、航空等） */
    @Excel(name = "其他", readConverterExp = "压=矿、航空等")
    private String other;

    /** 可行性研究 */
    @Excel(name = "可行性研究")
    private String feasibilityStudy;

    /** 投资决策 */
    @Excel(name = "投资决策")
    private String investmentDecisions;

    /** 项目核准 */
    @Excel(name = "项目核准")
    private String projectApproval;

    /** 建设指标 */
    @Excel(name = "建设指标")
    private String buildingIndicators;

    /** 拟开工时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拟开工时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proposedCommencementTime;

    /** 提供单位/人员 */
    @Excel(name = "提供单位/人员")
    private String personnel;

    /** 责任单位 */
    @Excel(name = "责任单位")
    private String accountabilityUnit;

    /** 存在的问题 */
    @Excel(name = "存在的问题")
    private String openQuestion;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setInstalledCapacity(String installedCapacity) 
    {
        this.installedCapacity = installedCapacity;
    }

    public String getInstalledCapacity() 
    {
        return installedCapacity;
    }
    public void setProjectAddress(String projectAddress) 
    {
        this.projectAddress = projectAddress;
    }

    public String getProjectAddress() 
    {
        return projectAddress;
    }
    public void setProjectStatus(String projectStatus) 
    {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus() 
    {
        return projectStatus;
    }
    public void setIdCa(String idCa) 
    {
        this.idCa = idCa;
    }

    public String getIdCa() 
    {
        return idCa;
    }
    public void setPlanningAddresses(String planningAddresses) 
    {
        this.planningAddresses = planningAddresses;
    }

    public String getPlanningAddresses() 
    {
        return planningAddresses;
    }
    public void setLandPretrial(String landPretrial) 
    {
        this.landPretrial = landPretrial;
    }

    public String getLandPretrial() 
    {
        return landPretrial;
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
    public void setForestry(String forestry) 
    {
        this.forestry = forestry;
    }

    public String getForestry() 
    {
        return forestry;
    }
    public void setEnvironmentalProtection(String environmentalProtection) 
    {
        this.environmentalProtection = environmentalProtection;
    }

    public String getEnvironmentalProtection() 
    {
        return environmentalProtection;
    }
    public void setWaterConservation(String waterConservation) 
    {
        this.waterConservation = waterConservation;
    }

    public String getWaterConservation() 
    {
        return waterConservation;
    }
    public void setAccessSystem(String accessSystem) 
    {
        this.accessSystem = accessSystem;
    }

    public String getAccessSystem() 
    {
        return accessSystem;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }
    public void setFeasibilityStudy(String feasibilityStudy) 
    {
        this.feasibilityStudy = feasibilityStudy;
    }

    public String getFeasibilityStudy() 
    {
        return feasibilityStudy;
    }
    public void setInvestmentDecisions(String investmentDecisions) 
    {
        this.investmentDecisions = investmentDecisions;
    }

    public String getInvestmentDecisions() 
    {
        return investmentDecisions;
    }
    public void setProjectApproval(String projectApproval) 
    {
        this.projectApproval = projectApproval;
    }

    public String getProjectApproval() 
    {
        return projectApproval;
    }
    public void setBuildingIndicators(String buildingIndicators) 
    {
        this.buildingIndicators = buildingIndicators;
    }

    public String getBuildingIndicators() 
    {
        return buildingIndicators;
    }
    public void setProposedCommencementTime(Date proposedCommencementTime) 
    {
        this.proposedCommencementTime = proposedCommencementTime;
    }

    public Date getProposedCommencementTime() 
    {
        return proposedCommencementTime;
    }
    public void setPersonnel(String personnel) 
    {
        this.personnel = personnel;
    }

    public String getPersonnel() 
    {
        return personnel;
    }
    public void setAccountabilityUnit(String accountabilityUnit) 
    {
        this.accountabilityUnit = accountabilityUnit;
    }

    public String getAccountabilityUnit() 
    {
        return accountabilityUnit;
    }
    public void setOpenQuestion(String openQuestion) 
    {
        this.openQuestion = openQuestion;
    }

    public String getOpenQuestion() 
    {
        return openQuestion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("time", getTime())
            .append("projectName", getProjectName())
            .append("projectType", getProjectType())
            .append("installedCapacity", getInstalledCapacity())
            .append("projectAddress", getProjectAddress())
            .append("projectStatus", getProjectStatus())
            .append("idCa", getIdCa())
            .append("planningAddresses", getPlanningAddresses())
            .append("landPretrial", getLandPretrial())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("forestry", getForestry())
            .append("environmentalProtection", getEnvironmentalProtection())
            .append("waterConservation", getWaterConservation())
            .append("accessSystem", getAccessSystem())
            .append("other", getOther())
            .append("feasibilityStudy", getFeasibilityStudy())
            .append("investmentDecisions", getInvestmentDecisions())
            .append("projectApproval", getProjectApproval())
            .append("buildingIndicators", getBuildingIndicators())
            .append("proposedCommencementTime", getProposedCommencementTime())
            .append("personnel", getPersonnel())
            .append("accountabilityUnit", getAccountabilityUnit())
            .append("openQuestion", getOpenQuestion())
            .toString();
    }
}
