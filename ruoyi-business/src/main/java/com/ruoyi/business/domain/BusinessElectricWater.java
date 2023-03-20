package com.ruoyi.business.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水力发电总貌对象 business_electric_water
 * 
 * @author lpf
 * @date 2021-03-02
 */
@ApiModel("水力发电总貌返回对象,除了id没有注释的字段不用管")
public class BusinessElectricWater extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "id",name = "id",dataType = "Long")
    private Long id;

    /** 年份 */
    @Excel(name = "年份")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "年份",name = "year",dataType = "Long")
    private Long year;

    /** 发电量 */
    @Excel(name = "发电量")
    @ApiModelProperty(value = "发电量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 生产厂用电率 */
    @Excel(name = "生产厂用电率")
    @ApiModelProperty(value = "生产厂用电率",name = "rate",dataType = "String")
    private String rate;

    /** 综合电价 */
    @Excel(name = "综合电价")
    @ApiModelProperty(value = "综合电价",name = "integratedelectricity",dataType = "String")
    private String integratedelectricity;

    /** 利润总额 */
    @Excel(name = "利润总额")
    @ApiModelProperty(value = "利润总额",name = "totalPrice",dataType = "BigDecimal")
    private BigDecimal totalPrice;

    /** EVA */
    @Excel(name = "EVA")
    @ApiModelProperty(value = "EVA",name = "eva",dataType = "BigDecimal")
    private BigDecimal eva;

    /** 状态 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setGenerateCapacity(String generateCapacity) 
    {
        this.generateCapacity = generateCapacity;
    }

    public String getGenerateCapacity() 
    {
        return generateCapacity;
    }
    public void setRate(String rate) 
    {
        this.rate = rate;
    }

    public String getRate() 
    {
        return rate;
    }
    public void setIntegratedelectricity(String integratedelectricity)
    {
        this.integratedelectricity = integratedelectricity;
    }

    public String getIntegratedelectricity()
    {
        return integratedelectricity;
    }

    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setEva(BigDecimal eva) 
    {
        this.eva = eva;
    }

    public BigDecimal getEva() 
    {
        return eva;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("generateCapacity", getGenerateCapacity())
            .append("rate", getRate())
            .append("integratedelectricity", getIntegratedelectricity())
            .append("totalPrice", getTotalPrice())
            .append("eva", getEva())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
