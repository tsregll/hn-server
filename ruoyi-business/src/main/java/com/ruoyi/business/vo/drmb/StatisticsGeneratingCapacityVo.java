package com.ruoyi.business.vo.drmb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 统调发电量对象 business_statistics_generating_capacity
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
public class StatisticsGeneratingCapacityVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 发电量类型 */
    @Excel(name = "类型",isRequired = true,readConverterExp = "0=水电,1=火电,2=风电,3=太阳能")
    private String statisticsType;

    /** 日期（yyyy-mm） */
    @Excel(name = "年月",isRequired = true)
    @JsonFormat(pattern = "yyyy-MM")
    private String enteringDate;

    /** 发电量 */
    @Excel(name = "月度发电量",isRequired = true)
    private String statisticsAll;

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

}
