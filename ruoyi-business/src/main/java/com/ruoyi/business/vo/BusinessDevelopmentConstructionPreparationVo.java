package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 规划发展施工准备项目对象 business_development_construction_preparation
 * 
 * @author ruoyi
 * @date 2021-07-28
 */
public class BusinessDevelopmentConstructionPreparationVo
{

    /** 序号 */
    private Long id;

    /** 项目性质 */
//    @Excel(name = "项目性质")
    private String projectNature;
    //首要项目性质
    private String projectStatus;

    private String firstprojectNatureNumber;

    /** 项目名称 */
    private String name;

    private String value;

    /** 容量 */
//    @Excel(name = "容量")
    private String projectCapacity;

    private String projectCapacityRecord;

    /** 项目类型 */
//    @Excel(name = "项目类型")
    private String projectType;

    /** 开发方式 */
//    @Excel(name = "开发方式")
    private String projectDevelopmentModalities;

    /** 所在地区 */
//    @Excel(name = "所在地区")
    private String projectRegionDistrict;

    //坐标
    private List<String> coord;

    public BusinessDevelopmentConstructionPreparationVo() {
    }

    public BusinessDevelopmentConstructionPreparationVo(Long id, String projectNature, String firstprojectNature, String firstprojectNatureNumber, String name, String value, String projectCapacity, String projectType, String projectDevelopmentModalities, String projectRegionDistrict, List<String> coord) {
        this.id = id;
        this.projectNature = projectNature;
        this.projectStatus = firstprojectNature;
        this.firstprojectNatureNumber = firstprojectNatureNumber;
        this.name = name;
        this.value = value;
        this.projectCapacity = projectCapacity;
        this.projectType = projectType;
        this.projectDevelopmentModalities = projectDevelopmentModalities;
        this.projectRegionDistrict = projectRegionDistrict;
        this.coord = coord;
    }

    public String getProjectCapacityRecord() {
        return projectCapacityRecord;
    }

    public void setProjectCapacityRecord(String projectCapacityRecord) {
        this.projectCapacityRecord = projectCapacityRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getFirstprojectNatureNumber() {
        return firstprojectNatureNumber;
    }

    public void setFirstprojectNatureNumber(String firstprojectNatureNumber) {
        this.firstprojectNatureNumber = firstprojectNatureNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProjectCapacity() {
        return projectCapacity;
    }

    public void setProjectCapacity(String projectCapacity) {
        this.projectCapacity = projectCapacity;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectDevelopmentModalities() {
        return projectDevelopmentModalities;
    }

    public void setProjectDevelopmentModalities(String projectDevelopmentModalities) {
        this.projectDevelopmentModalities = projectDevelopmentModalities;
    }

    public String getProjectRegionDistrict() {
        return projectRegionDistrict;
    }

    public void setProjectRegionDistrict(String projectRegionDistrict) {
        this.projectRegionDistrict = projectRegionDistrict;
    }

    public List<String> getCoord() {
        return coord;
    }

    public void setCoord(List<String> coord) {
        this.coord = coord;
    }
}
