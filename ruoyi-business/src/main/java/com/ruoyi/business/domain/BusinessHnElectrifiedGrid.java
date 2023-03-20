package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 湖南电网发电量后台对象 business_hn_electrified_grid
 * 
 * @author ruoyi
 * @date 2021-03-13
 */
public class BusinessHnElectrifiedGrid extends BaseEntity
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
    private String enteringDate;

    /** 用电量类型 */
    @Excel(name = "类型",isRequired = true,readConverterExp = "0=水电,1=火电,2=风电,3=太阳能")
    private String industryType;

    /** 月度电量 */
    @Excel(name = "月度电量",isRequired = true)
    private String monthIndustry;

    /** 月度同期电量 */
    @Excel(name = "月度同期电量", type = Excel.Type.EXPORT)
    private String lastMonthIndustry;

    /** 月度同比 */
    @Excel(name = "月度同比", type = Excel.Type.EXPORT)
    private String lastMonthContrast;

    /** 月度环比 */
    @Excel(name = "月度环比", type = Excel.Type.EXPORT)
    private String monthElectricity;

    /** 年累计电量 */
    @Excel(name = "年累计电量", type = Excel.Type.EXPORT)
    private String yearAllElectricity;

    /** 年度同期电量 */
    @Excel(name = "年度同期电量", type = Excel.Type.EXPORT)
    private String lastYearAllContrast;

    /** 年累计同比 */
    @Excel(name = "年累计同比", type = Excel.Type.EXPORT)
    private String yearContrast;

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
    public void setLastMonthContrast(String lastMonthContrast) 
    {
        this.lastMonthContrast = lastMonthContrast;
    }

    public String getLastMonthContrast() 
    {
        return lastMonthContrast;
    }
    public void setMonthElectricity(String monthElectricity) 
    {
        this.monthElectricity = monthElectricity;
    }

    public String getMonthElectricity() 
    {
        return monthElectricity;
    }
    public void setYearAllElectricity(String yearAllElectricity) 
    {
        this.yearAllElectricity = yearAllElectricity;
    }

    public String getYearAllElectricity() 
    {
        return yearAllElectricity;
    }
    public void setLastYearAllContrast(String lastYearAllContrast) 
    {
        this.lastYearAllContrast = lastYearAllContrast;
    }

    public String getLastYearAllContrast() 
    {
        return lastYearAllContrast;
    }
    public void setYearContrast(String yearContrast) 
    {
        this.yearContrast = yearContrast;
    }

    public String getYearContrast() 
    {
        return yearContrast;
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
            .append("lastMonthContrast", getLastMonthContrast())
            .append("monthElectricity", getMonthElectricity())
            .append("yearAllElectricity", getYearAllElectricity())
            .append("lastYearAllContrast", getLastYearAllContrast())
            .append("yearContrast", getYearContrast())
            .toString();
    }
}
