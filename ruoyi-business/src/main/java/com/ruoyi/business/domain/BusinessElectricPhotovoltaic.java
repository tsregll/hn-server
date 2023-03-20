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
 * 光伏发电总貌对象 business_electric_photovoltaic
 *
 * @author ruoyi
 * @date 2021-03-08
 */
@ApiModel("煤电发电总貌返回对象,除了id没有注释的字段不用管")
public class BusinessElectricPhotovoltaic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "id",name = "id",dataType = "Long")
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 年份 */
    @Excel(name = "年份")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "年份",name = "year",dataType = "Long")
    private Long year;

    /** 发电量 */
    @Excel(name = "总发电量")
    @ApiModelProperty(value = "总发电量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 供热量 */
    @Excel(name = "供热量")
    @ApiModelProperty(value = "供热量",name = "heatSupply",dataType = "String")
    private String heatSupply;

    /** 生产厂用电率 */
    @Excel(name = "生产厂用电率")
    @ApiModelProperty(value = "生产厂用电率",name = "rate",dataType = "String")
    private String rate;

    /** 利润总额 */
    @Excel(name = "利润总额")
    @ApiModelProperty(value = "利润总额",name = "totalPrice",dataType = "BigDecimal")
    private BigDecimal totalPrice;

    /** EVA */
    @Excel(name = "EVA")
    @ApiModelProperty(value = "EVA",name = "eva",dataType = "BigDecimal")
    private BigDecimal eva;

    /** 岳阳新港光伏发电量 */
    @Excel(name = "岳阳新港光伏发电量")
    @ApiModelProperty(value = "岳阳新港光伏发电量",name = "generateCapacityXg",dataType = "String")
    private String generateCapacityXg;

    /** 岳阳擂鼓台光伏发电量 */
    @Excel(name = "岳阳擂鼓台光伏发电量")
    @ApiModelProperty(value = "岳阳擂鼓台光伏发电量",name = "generateCapacityLg",dataType = "String")
    private String generateCapacityLg;

    /** 岳阳电厂三期灰湖水面光伏发电量 */
    @Excel(name = "岳阳电厂三期灰湖水面光伏发电量")
    @ApiModelProperty(value = "岳阳电厂三期灰湖水面光伏发电量",name = "generateCapacityHs",dataType = "String")
    private String generateCapacityHs;

    /** 综合电价 */
    @Excel(name = "综合电价")
    @ApiModelProperty(value = "综合电价",name = "integratedElectricity",dataType = "String")
    private String integratedElectricity;;

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
    public void setHeatSupply(String heatSupply)
    {
        this.heatSupply = heatSupply;
    }

    public String getHeatSupply()
    {
        return heatSupply;
    }
    public void setRate(String rate)
    {
        this.rate = rate;
    }

    public String getRate()
    {
        return rate;
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
    public void setGenerateCapacityXg(String generateCapacityXg)
    {
        this.generateCapacityXg = generateCapacityXg;
    }

    public String getGenerateCapacityXg()
    {
        return generateCapacityXg;
    }
    public void setGenerateCapacityLg(String generateCapacityLg)
    {
        this.generateCapacityLg = generateCapacityLg;
    }

    public String getGenerateCapacityLg()
    {
        return generateCapacityLg;
    }
    public void setGenerateCapacityHs(String generateCapacityHs)
    {
        this.generateCapacityHs = generateCapacityHs;
    }

    public String getGenerateCapacityHs()
    {
        return generateCapacityHs;
    }
    public void setIntegratedElectricity(String integratedElectricity)
    {
        this.integratedElectricity = integratedElectricity;
    }

    public String getIntegratedElectricity()
    {
        return integratedElectricity;
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
                .append("year", getYear())
                .append("generateCapacity", getGenerateCapacity())
                .append("heatSupply", getHeatSupply())
                .append("rate", getRate())
                .append("totalPrice", getTotalPrice())
                .append("eva", getEva())
                .append("generateCapacityXg", getGenerateCapacityXg())
                .append("generateCapacityLg", getGenerateCapacityLg())
                .append("generateCapacityHs", getGenerateCapacityHs())
                .append("integratedElectricity", getIntegratedElectricity())
            .toString();
    }
}
