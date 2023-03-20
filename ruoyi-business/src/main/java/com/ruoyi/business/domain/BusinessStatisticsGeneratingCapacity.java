package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 统调发电量对象 business_statistics_generating_capacity
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
public class BusinessStatisticsGeneratingCapacity extends BaseEntity
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

    /** 发电量类型 */
    @Excel(name = "类型",isRequired = true,readConverterExp = "0=水电,1=火电,2=风电,3=太阳能")
    private String statisticsType;

    /** 发电量 */
    @Excel(name = "月度发电量",isRequired = true)
    private String statisticsAll;

    /** 月度同期电量 */
    @Excel(name = "月度同期电量", type = Excel.Type.EXPORT)
    private String statisticsLastMonth;

    /** 年累计电量（年初到当前月份用电量） */
    @Excel(name = "年累计电量", type = Excel.Type.EXPORT)
    private String statisticsYear;

    /** 年累计同期电量 */
    @Excel(name = "年累计同期电量", type = Excel.Type.EXPORT)
    private String statisticsLastYear;

    /** 月度同比 */
    @Excel(name = "月度同比", type = Excel.Type.EXPORT)
    private String contrastMonth;

    /** 月度环比 */
    @Excel(name = "月度环比", type = Excel.Type.EXPORT)
    private String contrastLastMonth;

    /** 年累计同比 */
    @Excel(name = "年累计同比", type = Excel.Type.EXPORT)
    private String contrastYear;

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
    public void setStatisticsType(String statisticsType) 
    {
        this.statisticsType = statisticsType;
    }

    public String getStatisticsType() 
    {
        return statisticsType;
    }
    public void setStatisticsAll(String statisticsAll) 
    {
        this.statisticsAll = statisticsAll;
    }

    public String getStatisticsAll() 
    {
        return statisticsAll;
    }
    public void setStatisticsLastMonth(String statisticsLastMonth) 
    {
        this.statisticsLastMonth = statisticsLastMonth;
    }

    public String getStatisticsLastMonth() 
    {
        return statisticsLastMonth;
    }
    public void setStatisticsYear(String statisticsYear) 
    {
        this.statisticsYear = statisticsYear;
    }

    public String getStatisticsYear() 
    {
        return statisticsYear;
    }
    public void setStatisticsLastYear(String statisticsLastYear) 
    {
        this.statisticsLastYear = statisticsLastYear;
    }

    public String getStatisticsLastYear() 
    {
        return statisticsLastYear;
    }
    public void setContrastMonth(String contrastMonth) 
    {
        this.contrastMonth = contrastMonth;
    }

    public String getContrastMonth() 
    {
        return contrastMonth;
    }
    public void setContrastLastMonth(String contrastLastMonth) 
    {
        this.contrastLastMonth = contrastLastMonth;
    }

    public String getContrastLastMonth() 
    {
        return contrastLastMonth;
    }
    public void setContrastYear(String contrastYear) 
    {
        this.contrastYear = contrastYear;
    }

    public String getContrastYear() 
    {
        return contrastYear;
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
            .append("statisticsType", getStatisticsType())
            .append("statisticsAll", getStatisticsAll())
            .append("statisticsLastMonth", getStatisticsLastMonth())
            .append("statisticsYear", getStatisticsYear())
            .append("statisticsLastYear", getStatisticsLastYear())
            .append("contrastMonth", getContrastMonth())
            .append("contrastLastMonth", getContrastLastMonth())
            .append("contrastYear", getContrastYear())
            .toString();
    }
}
