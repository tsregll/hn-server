package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 规划发展施工准备项目对象 business_development_construction_preparation
 * 
 * @author ruoyi
 * @date 2021-07-28
 */
public class BusinessDevelopmentConstructionPreparation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    private Long pid;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

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

    /** 项目性质 */
    @Excel(name = "项目性质")
    private String projectNature;
    //首要项目性质
    private String firstprojectNature;

    private String firstprojectNatureNumber;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 备案容量 */
    @Excel(name = "备案容量（万千瓦）")
    private String projectCapacityRecord;

    /** 实际容量 */
    @Excel(name = "实际容量（万千瓦）")
    private String projectCapacity;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String projectDevelopmentModalities;

    /** 所在地区 */
    @Excel(name = "所在地区")
    private String projectRegionDistrict;

    /** 责任单位 */
    @Excel(name = "责任单位")
    private String projectResponsibilityUnit;

    /** 项目经度 */
    @Excel(name = "项目经度")
    private String projectXAxis;

    /** 项目纬度 */
    @Excel(name = "项目纬度")
    private String projectYAxis;
    //坐标
    private List<String> projectAxis;

//    开发协议签订_计划完成日期
    private String signingPlaningTime;
//    开发协议签订_完成日期
    private String signingTime;
    //    备案_计划完成日期
    private String recordPlaningTime;
    //    备案_完成日期
    private String recordTime;
    //    可研定稿_计划完成日期
    private String draftPlaningTime;
    //    可研定稿_完成日期
    private String draftTime;
    //    接入、环评手续_计划完成日期
    private String formalityPlaningTime;
    //    开发协议签订_完成日期
    private String formalityTime;
    //    开发协议签订_计划完成日期
    private String decisionPlaningTime;
    //    开发协议签订_完成日期
    private String decisionTime;
    //    设备招标_计划完成日期
    private String equipmentPlaningTime;
    //    设备招标_完成日期
    private String equipmentTime;
    //    主体施工招标_计划完成日期
    private String constructionPlaningTime;
    //    主体施工招标_完成日期
    private String constructionTime;
    //    开工_计划完成日期
    private String constructingPlaningTime;
    //    开工_完成日期
    private String constructingTime;

    public String getEquipmentPlaningTime() {
        return equipmentPlaningTime;
    }

    public void setEquipmentPlaningTime(String equipmentPlaningTime) {
        this.equipmentPlaningTime = equipmentPlaningTime;
    }

    public String getEquipmentTime() {
        return equipmentTime;
    }

    public void setEquipmentTime(String equipmentTime) {
        this.equipmentTime = equipmentTime;
    }

    public String getConstructionPlaningTime() {
        return constructionPlaningTime;
    }

    public void setConstructionPlaningTime(String constructionPlaningTime) {
        this.constructionPlaningTime = constructionPlaningTime;
    }

    public String getConstructionTime() {
        return constructionTime;
    }

    public void setConstructionTime(String constructionTime) {
        this.constructionTime = constructionTime;
    }

    public String getConstructingPlaningTime() {
        return constructingPlaningTime;
    }

    public void setConstructingPlaningTime(String constructingPlaningTime) {
        this.constructingPlaningTime = constructingPlaningTime;
    }

    public String getConstructingTime() {
        return constructingTime;
    }

    public void setConstructingTime(String constructingTime) {
        this.constructingTime = constructingTime;
    }

    public String getProjectCapacityRecord() {
        return projectCapacityRecord;
    }

    public void setProjectCapacityRecord(String projectCapacityRecord) {
        this.projectCapacityRecord = projectCapacityRecord;
    }

    public String getSigningPlaningTime() {
        return signingPlaningTime;
    }

    public void setSigningPlaningTime(String signingPlaningTime) {
        this.signingPlaningTime = signingPlaningTime;
    }

    public String getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime;
    }

    public String getRecordPlaningTime() {
        return recordPlaningTime;
    }

    public void setRecordPlaningTime(String recordPlaningTime) {
        this.recordPlaningTime = recordPlaningTime;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getDraftPlaningTime() {
        return draftPlaningTime;
    }

    public void setDraftPlaningTime(String draftPlaningTime) {
        this.draftPlaningTime = draftPlaningTime;
    }

    public String getDraftTime() {
        return draftTime;
    }

    public void setDraftTime(String draftTime) {
        this.draftTime = draftTime;
    }

    public String getFormalityPlaningTime() {
        return formalityPlaningTime;
    }

    public void setFormalityPlaningTime(String formalityPlaningTime) {
        this.formalityPlaningTime = formalityPlaningTime;
    }

    public String getFormalityTime() {
        return formalityTime;
    }

    public void setFormalityTime(String formalityTime) {
        this.formalityTime = formalityTime;
    }

    public String getDecisionPlaningTime() {
        return decisionPlaningTime;
    }

    public void setDecisionPlaningTime(String decisionPlaningTime) {
        this.decisionPlaningTime = decisionPlaningTime;
    }

    public String getDecisionTime() {
        return decisionTime;
    }

    public void setDecisionTime(String decisionTime) {
        this.decisionTime = decisionTime;
    }

    public List<String> getProjectAxis() {
        return projectAxis;
    }

    public void setProjectAxis(List<String> projectAxis) {
        this.projectAxis = projectAxis;
    }

    public String getFirstprojectNature() {
        return firstprojectNature;
    }

    public void setFirstprojectNature(String firstprojectNature) {
        this.firstprojectNature = firstprojectNature;
    }

    public String getFirstprojectNatureNumber() {
        return firstprojectNatureNumber;
    }

    public void setFirstprojectNatureNumber(String firstprojectNatureNumber) {
        this.firstprojectNatureNumber = firstprojectNatureNumber;
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
    public void setProjectNature(String projectNature) 
    {
        this.projectNature = projectNature;
    }

    public String getProjectNature() 
    {
        return projectNature;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectCapacity(String projectCapacity) 
    {
        this.projectCapacity = projectCapacity;
    }

    public String getProjectCapacity() 
    {
        return projectCapacity;
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
            .append("projectNature", getProjectNature())
            .append("projectName", getProjectName())
            .append("projectCapacity", getProjectCapacity())
            .append("projectType", getProjectType())
            .append("projectDevelopmentModalities", getProjectDevelopmentModalities())
            .append("projectRegionDistrict", getProjectRegionDistrict())
            .append("projectResponsibilityUnit", getProjectResponsibilityUnit())
            .append("projectXAxis", getProjectXAxis())
            .append("projectYAxis", getProjectYAxis())
            .append("remark", getRemark())
            .toString();
    }
}
