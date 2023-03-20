package com.ruoyi.business.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 规划发展项目Vo
 * 
 * @author yrb
 * @date 2021-04-25
 */
public class PlanningDevelopmentHunanVo
{
    private Long projectNumber;
    private String name;
    private String value;
    private String projectStatus;
    private double[] coord;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setProjectNumber(Long projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Long getProjectNumber() {
        return projectNumber;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(double[] coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public double[] getCoord() {
        return coord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectNumber", getProjectNumber())
            .append("name", getName())
            .append("value", getValue())
            .append("projectStatus", getProjectStatus())
            .append("coord", getCoord())
            .toString();
    }
}
