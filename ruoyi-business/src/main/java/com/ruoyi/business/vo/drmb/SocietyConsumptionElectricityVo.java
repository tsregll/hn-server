package com.ruoyi.business.vo.drmb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 全社会用电量情况对象 business_society_consumption_electricity
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@ApiModel("全社会用电量情况对象,除了id没有注释的字段不用管")
public class SocietyConsumptionElectricityVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 用电量类型（全社会用电量、第一产业、第二产业、第三产业	城乡居民
     ） */
    @Excel(name = "类型",isRequired = true,readConverterExp = "0=全社会用电量,1=第一产业,2=第二产业,3=第三产业,4=城乡居民")
    @ApiModelProperty(value = "用电量类型",name = "industryType",dataType = "String")
    private String industryType;

    /** 日期（yyyy-mm） */
    @Excel(name = "年月",isRequired = true)
    @JsonFormat(pattern = "yyyy-MM")
    @ApiModelProperty(value = "年月（yyyy-mm）",name = "enteringDate",dataType = "String")
    private String enteringDate;

    /** 月度用电量 */
    @Excel(name = "月度用电量",isRequired = true)
    private String monthIndustry;


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
