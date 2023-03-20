package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 全社会用电量情况对象 business_society_consumption_electricity
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@ApiModel("全社会用电量情况对象,除了id没有注释的字段不用管")
public class BusinessSocietyConsumptionElectricity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 日期（yyyy-mm） */
    @Excel(name = "年月",isRequired = true)
    @JsonFormat(pattern = "yyyy-MM")
    @ApiModelProperty(value = "年月（yyyy-mm）",name = "enteringDate",dataType = "String")
    private String enteringDate;

    /** 用电量类型（全社会用电量、第一产业、第二产业、第三产业	城乡居民
） */
    @Excel(name = "类型",isRequired = true,readConverterExp = "0=全社会用电量,1=第一产业,2=第二产业,3=第三产业,4=城乡居民")
    @ApiModelProperty(value = "用电量类型",name = "industryType",dataType = "String")
    private String industryType;

    /** 月度用电量 */
    @Excel(name = "月度用电量",isRequired = true)
    private String monthIndustry;

    /** 同期用电量（去年同月份用电量） */
    @Excel(name = "同期用电量", type = Excel.Type.EXPORT)
    private String lastMonthIndustry;

    /** 年累计用电量（年初到当前月份用电量） */
    @Excel(name = "年累计用电量", type = Excel.Type.EXPORT)
    private String yearElectricity;

    /** 年同期累计用电量（去年初到去年当前月份用电量） */
    @Excel(name = "年同期累计用电量", type = Excel.Type.EXPORT)
    private String lastYearElectricity;

    /** 年累计同比（年初到当前月份用电量/去年初到去年当前月份用电量-1） */
    @Excel(name = "年累计同比", type = Excel.Type.EXPORT)
    private String yearContrast;

    /** 月度同比（录入总用电量/去年同月份用电量-1） */
    @Excel(name = "月度同比", type = Excel.Type.EXPORT)
    private String monthContrast;

    /** 月度环比（录入总用电量/上个月总用电量-1） */
    @Excel(name = "月度环比", type = Excel.Type.EXPORT)
    private String lastMonthContrast;

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
    public void setEnteringDate(String enteringDate) 
    {
        this.enteringDate = enteringDate;
    }

    public String getEnteringDate() 
    {
        return enteringDate;
    }
    public void setIndustryType(String industryType) 
    {
        this.industryType = industryType;
    }

    public String getIndustryType() 
    {
        return industryType;
    }
    public void setMonthIndustry(String monthIndustry) 
    {
        this.monthIndustry = monthIndustry;
    }

    public String getMonthIndustry() 
    {
        return monthIndustry;
    }
    public void setLastMonthIndustry(String lastMonthIndustry) 
    {
        this.lastMonthIndustry = lastMonthIndustry;
    }

    public String getLastMonthIndustry() 
    {
        return lastMonthIndustry;
    }
    public void setYearElectricity(String yearElectricity) 
    {
        this.yearElectricity = yearElectricity;
    }

    public String getYearElectricity() 
    {
        return yearElectricity;
    }
    public void setLastYearElectricity(String lastYearElectricity) 
    {
        this.lastYearElectricity = lastYearElectricity;
    }

    public String getLastYearElectricity() 
    {
        return lastYearElectricity;
    }
    public void setYearContrast(String yearContrast) 
    {
        this.yearContrast = yearContrast;
    }

    public String getYearContrast() 
    {
        return yearContrast;
    }
    public void setMonthContrast(String monthContrast) 
    {
        this.monthContrast = monthContrast;
    }

    public String getMonthContrast() 
    {
        return monthContrast;
    }
    public void setLastMonthContrast(String lastMonthContrast) 
    {
        this.lastMonthContrast = lastMonthContrast;
    }

    public String getLastMonthContrast() 
    {
        return lastMonthContrast;
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
            .append("enteringDate", getEnteringDate())
            .append("industryType", getIndustryType())
            .append("monthIndustry", getMonthIndustry())
            .append("lastMonthIndustry", getLastMonthIndustry())
            .append("yearElectricity", getYearElectricity())
            .append("lastYearElectricity", getLastYearElectricity())
            .append("yearContrast", getYearContrast())
            .append("monthContrast", getMonthContrast())
            .append("lastMonthContrast", getLastMonthContrast())
            .toString();
    }
}
