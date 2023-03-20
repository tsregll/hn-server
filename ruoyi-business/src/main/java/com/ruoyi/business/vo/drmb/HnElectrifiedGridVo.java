package com.ruoyi.business.vo.drmb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 湖南电网发电量后台对象 business_hn_electrified_grid
 * 
 * @author ruoyi
 * @date 2021-03-13
 */
public class HnElectrifiedGridVo
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

}
