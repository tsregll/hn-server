package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 规划发展消纳板块对象 business_development_absorptive_information
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public class BusinessDevelopmentAbsorptiveInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 系统默认时间，精确到年月日时分秒 */
    @Excel(name = "录入/修改日期")
    private String defaultTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operatorNumber;

    /** 标题 */
    @Excel(name = "标题")
    private String absorptiveTitle;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 预警年度 */
    @Excel(name = "预警年度")
    private String earlyWarningTime;

    /** 消纳地图 */
    @Excel(name = "消纳地图")
    private String absorptiveMap;

    /** 消纳地图说明 */
    @Excel(name = "消纳地图说明")
    private String mapDiscription;

    /** 政策消纳板块前端地图标题 */
    private String mapTitle;

    public String getMapTitle() {
        return mapTitle;
    }

    public void setMapTitle(String mapTitle) {
        this.mapTitle = mapTitle;
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
    public void setAbsorptiveTitle(String absorptiveTitle) 
    {
        this.absorptiveTitle = absorptiveTitle;
    }

    public String getAbsorptiveTitle() 
    {
        return absorptiveTitle;
    }
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setEarlyWarningTime(String earlyWarningTime) 
    {
        this.earlyWarningTime = earlyWarningTime;
    }

    public String getEarlyWarningTime() 
    {
        return earlyWarningTime;
    }
    public void setAbsorptiveMap(String absorptiveMap) 
    {
        this.absorptiveMap = absorptiveMap;
    }

    public String getAbsorptiveMap() 
    {
        return absorptiveMap;
    }
    public void setMapDiscription(String mapDiscription) 
    {
        this.mapDiscription = mapDiscription;
    }

    public String getMapDiscription() 
    {
        return mapDiscription;
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
            .append("absorptiveTitle", getAbsorptiveTitle())
            .append("projectType", getProjectType())
            .append("earlyWarningTime", getEarlyWarningTime())
            .append("absorptiveMap", getAbsorptiveMap())
            .append("mapDiscription", getMapDiscription())
            .append("remark", getRemark())
            .toString();
    }
}
