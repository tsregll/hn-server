package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展在建项目对象 business_development_project_consrtucting
 * 
 * @author ruoyi
 * @date 2021-08-04
 */
public class BusinessDevelopmentProjectConstructing extends BaseEntity
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

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String projectDevelopmentModalities;

    /** 责任单位 */
    @Excel(name = "责任单位")
    private String projectResponsibilityUnit;

    /** 开工时间 */
    @Excel(name = "开工时间")
    private String projectDate;
    /** 开工时间 */
    @Excel(name = "完工时间")
    private String endProjectDate;

    /** 所在地区 */
    @Excel(name = "所在地区")
    private String projectRegionDistrict;

    /** 项目经度 */
    @Excel(name = "项目经度")
    private String projectXAxis;

    /** 项目纬度 */
    @Excel(name = "项目纬度")
    private String projectYAxis;

    /** 容量 */
    @Excel(name = "容量")
    private String projectCapacity;

    /** 主要施工单位 */
    @Excel(name = "主要施工单位")
    private String constructionUnit;

    /** 设计单位 */
    @Excel(name = "设计单位")
    private String designUnit;

    /** 监理单位 */
    @Excel(name = "监理单位")
    private String supervisionUnit;

    /** 项目概况 */
    @Excel(name = "项目概况")
    private String projectIntroduction;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projectStatus;

    /** 添加关键节点 */
    @Excel(name = "添加关键节点")
    private String projectNode;

    /** 附件 */
    private String accessory;

    //项目详情
    private String projectDetails = "项目详情";

    //实时动态
    private String projectDynamic = "实时动态";
    //前台后台判断参数（用来判断功能是前台在建项目还是在建项目后台（0为在建项目前台；1位在建项目后台）
    private String listState;
    private String projectDateTime;

    public String getProjectDateTime() {
        return projectDateTime;
    }

    public void setProjectDateTime(String projectDateTime) {
        this.projectDateTime = projectDateTime;
    }

    //前台后台判断参数（用来判断功能是前台在建项目还是在建项目后台（0为在建项目前台；1位在建项目后台）
    public String getListState() {
        return listState;
    }

    //前台后台判断参数（用来判断功能是前台在建项目还是在建项目后台（0为在建项目前台；1位在建项目后台）
    public void setListState(String listState) {
        this.listState = listState;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public String getProjectDynamic() {
        return projectDynamic;
    }

    public void setProjectDynamic(String projectDynamic) {
        this.projectDynamic = projectDynamic;
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
    public void setProjectDevelopmentModalities(String projectDevelopmentModalities) 
    {
        this.projectDevelopmentModalities = projectDevelopmentModalities;
    }

    public String getProjectDevelopmentModalities() 
    {
        return projectDevelopmentModalities;
    }
    public void setProjectResponsibilityUnit(String projectResponsibilityUnit) 
    {
        this.projectResponsibilityUnit = projectResponsibilityUnit;
    }

    public String getProjectResponsibilityUnit() 
    {
        return projectResponsibilityUnit;
    }
    public void setProjectDate(String projectDate) 
    {
        this.projectDate = projectDate;
    }

    public String getProjectDate() 
    {
        return projectDate;
    }
    public void setProjectRegionDistrict(String projectRegionDistrict) 
    {
        this.projectRegionDistrict = projectRegionDistrict;
    }

    public String getProjectRegionDistrict() 
    {
        return projectRegionDistrict;
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
    public void setProjectCapacity(String projectCapacity) 
    {
        this.projectCapacity = projectCapacity;
    }

    public String getProjectCapacity() 
    {
        return projectCapacity;
    }
    public void setConstructionUnit(String constructionUnit) 
    {
        this.constructionUnit = constructionUnit;
    }

    public String getConstructionUnit() 
    {
        return constructionUnit;
    }
    public void setDesignUnit(String designUnit) 
    {
        this.designUnit = designUnit;
    }

    public String getDesignUnit() 
    {
        return designUnit;
    }
    public void setSupervisionUnit(String supervisionUnit) 
    {
        this.supervisionUnit = supervisionUnit;
    }

    public String getSupervisionUnit() 
    {
        return supervisionUnit;
    }
    public void setProjectIntroduction(String projectIntroduction) 
    {
        this.projectIntroduction = projectIntroduction;
    }

    public String getProjectIntroduction() 
    {
        return projectIntroduction;
    }
    public void setProjectStatus(String projectStatus) 
    {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus() 
    {
        return projectStatus;
    }
    public void setProjectNode(String projectNode) 
    {
        this.projectNode = projectNode;
    }

    public String getProjectNode() 
    {
        return projectNode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEndProjectDate() {
        return endProjectDate;
    }

    public void setEndProjectDate(String endProjectDate) {
        this.endProjectDate = endProjectDate;
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
            .append("projectName", getProjectName())
            .append("projectType", getProjectType())
            .append("projectDevelopmentModalities", getProjectDevelopmentModalities())
            .append("projectResponsibilityUnit", getProjectResponsibilityUnit())
            .append("projectDate", getProjectDate())
            .append("endProjectDate", getEndProjectDate())
            .append("projectRegionDistrict", getProjectRegionDistrict())
            .append("projectXAxis", getProjectXAxis())
            .append("projectYAxis", getProjectYAxis())
            .append("projectCapacity", getProjectCapacity())
            .append("constructionUnit", getConstructionUnit())
            .append("designUnit", getDesignUnit())
            .append("supervisionUnit", getSupervisionUnit())
            .append("projectIntroduction", getProjectIntroduction())
            .append("projectStatus", getProjectStatus())
            .append("projectNode", getProjectNode())
            .append("remark", getRemark())
            .toString();
    }
}
