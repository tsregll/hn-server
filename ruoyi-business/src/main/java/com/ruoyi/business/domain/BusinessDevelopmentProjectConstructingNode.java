package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展在建项目关键节点对象 business_development_project_constructing_node
 * 
 * @author ruoyi
 * @date 2021-08-06
 */
public class BusinessDevelopmentProjectConstructingNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 关键节点名称 */
    @Excel(name = "关键节点名称")
    private String nodeName;

    /** 计划完成时间 */
    @Excel(name = "计划完成时间")
    private String planingTime;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardOne;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusOne;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardTwo;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusTwo;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardThree;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusThree;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardFour;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusFour;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardFive;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusFive;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardSix;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusSix;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardSeven;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusSeven;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardEight;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusEight;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardNine;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusNine;

    /** 开发方式 */
    @Excel(name = "开发方式")
    private String standardTen;

    /** 1、标准 */
    @Excel(name = "1、标准")
    private String statusTen;

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
    public void setNodeName(String nodeName) 
    {
        this.nodeName = nodeName;
    }

    public String getNodeName() 
    {
        return nodeName;
    }
    public void setPlaningTime(String planingTime) 
    {
        this.planingTime = planingTime;
    }

    public String getPlaningTime() 
    {
        return planingTime;
    }
    public void setStandardOne(String standardOne) 
    {
        this.standardOne = standardOne;
    }

    public String getStandardOne() 
    {
        return standardOne;
    }
    public void setStatusOne(String statusOne) 
    {
        this.statusOne = statusOne;
    }

    public String getStatusOne() 
    {
        return statusOne;
    }
    public void setStandardTwo(String standardTwo) 
    {
        this.standardTwo = standardTwo;
    }

    public String getStandardTwo() 
    {
        return standardTwo;
    }
    public void setStatusTwo(String statusTwo) 
    {
        this.statusTwo = statusTwo;
    }

    public String getStatusTwo() 
    {
        return statusTwo;
    }
    public void setStandardThree(String standardThree) 
    {
        this.standardThree = standardThree;
    }

    public String getStandardThree() 
    {
        return standardThree;
    }
    public void setStatusThree(String statusThree) 
    {
        this.statusThree = statusThree;
    }

    public String getStatusThree() 
    {
        return statusThree;
    }
    public void setStandardFour(String standardFour) 
    {
        this.standardFour = standardFour;
    }

    public String getStandardFour() 
    {
        return standardFour;
    }
    public void setStatusFour(String statusFour) 
    {
        this.statusFour = statusFour;
    }

    public String getStatusFour() 
    {
        return statusFour;
    }
    public void setStandardFive(String standardFive) 
    {
        this.standardFive = standardFive;
    }

    public String getStandardFive() 
    {
        return standardFive;
    }
    public void setStatusFive(String statusFive) 
    {
        this.statusFive = statusFive;
    }

    public String getStatusFive() 
    {
        return statusFive;
    }
    public void setStandardSix(String standardSix) 
    {
        this.standardSix = standardSix;
    }

    public String getStandardSix() 
    {
        return standardSix;
    }
    public void setStatusSix(String statusSix) 
    {
        this.statusSix = statusSix;
    }

    public String getStatusSix() 
    {
        return statusSix;
    }
    public void setStandardSeven(String standardSeven) 
    {
        this.standardSeven = standardSeven;
    }

    public String getStandardSeven() 
    {
        return standardSeven;
    }
    public void setStatusSeven(String statusSeven) 
    {
        this.statusSeven = statusSeven;
    }

    public String getStatusSeven() 
    {
        return statusSeven;
    }
    public void setStandardEight(String standardEight) 
    {
        this.standardEight = standardEight;
    }

    public String getStandardEight() 
    {
        return standardEight;
    }
    public void setStatusEight(String statusEight) 
    {
        this.statusEight = statusEight;
    }

    public String getStatusEight() 
    {
        return statusEight;
    }
    public void setStandardNine(String standardNine) 
    {
        this.standardNine = standardNine;
    }

    public String getStandardNine() 
    {
        return standardNine;
    }
    public void setStatusNine(String statusNine) 
    {
        this.statusNine = statusNine;
    }

    public String getStatusNine() 
    {
        return statusNine;
    }
    public void setStandardTen(String standardTen) 
    {
        this.standardTen = standardTen;
    }

    public String getStandardTen() 
    {
        return standardTen;
    }
    public void setStatusTen(String statusTen) 
    {
        this.statusTen = statusTen;
    }

    public String getStatusTen() 
    {
        return statusTen;
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
            .append("nodeName", getNodeName())
            .append("planingTime", getPlaningTime())
            .append("standardOne", getStandardOne())
            .append("statusOne", getStatusOne())
            .append("standardTwo", getStandardTwo())
            .append("statusTwo", getStatusTwo())
            .append("standardThree", getStandardThree())
            .append("statusThree", getStatusThree())
            .append("standardFour", getStandardFour())
            .append("statusFour", getStatusFour())
            .append("standardFive", getStandardFive())
            .append("statusFive", getStatusFive())
            .append("standardSix", getStandardSix())
            .append("statusSix", getStatusSix())
            .append("standardSeven", getStandardSeven())
            .append("statusSeven", getStatusSeven())
            .append("standardEight", getStandardEight())
            .append("statusEight", getStatusEight())
            .append("standardNine", getStandardNine())
            .append("statusNine", getStatusNine())
            .append("standardTen", getStandardTen())
            .append("statusTen", getStatusTen())
            .append("remark", getRemark())
            .toString();
    }
}
