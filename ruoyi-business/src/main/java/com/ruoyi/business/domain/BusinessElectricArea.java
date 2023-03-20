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
 * 区域发电总貌对象 business_electric_area
 *
 * @author ruoyi
 * @date 2021-03-08
 */
@ApiModel("区域发电总貌返回对象,除了id没有注释的字段不用管")
public class BusinessElectricArea extends BaseEntity
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

    /** 发电量（总） */
    @Excel(name = "总发电量")
    @ApiModelProperty(value = "总发电量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 发电量(火) */
    @Excel(name = "火电发电量")
    @ApiModelProperty(value = "火电发电量",name = "generateCapacityFire",dataType = "String")
    private String generateCapacityFire;

    /** 发电量(风) */
    @Excel(name = "风电发电量")
    @ApiModelProperty(value = "风电发电量",name = "generateCapacityWind",dataType = "String")
    private String generateCapacityWind;

    /** 发电量(水) */
    @Excel(name = "水电发电量")
    @ApiModelProperty(value = "水电发电量",name = "generateCapacityWater",dataType = "String")
    private String generateCapacityWater;

    /** 发电量(光) */
    @Excel(name = "光伏发电量")
    @ApiModelProperty(value = "光伏发电量",name = "generateCapacityLight",dataType = "String")
    private String generateCapacityLight;

    /** 供热量 */
    @Excel(name = "供热量")
    @ApiModelProperty(value = "供热量",name = "heatSupply",dataType = "String")
    private String heatSupply;

    /** 标煤采购单价 */
    @Excel(name = "标煤采购单价")
    @ApiModelProperty(value = "标煤采购单价",name = "price",dataType = "BigDecimal")
    private BigDecimal price;

    /** 利润总额 */
    @Excel(name = "利润总额")
    @ApiModelProperty(value = "利润总额",name = "totalPrice",dataType = "BigDecimal")
    private BigDecimal totalPrice;

    /** EVA */
    @Excel(name = "EVA")
    @ApiModelProperty(value = "EVA",name = "eva",dataType = "BigDecimal")
    private BigDecimal eva;

    /** $column.columnComment */
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
    public void setGenerateCapacityFire(String generateCapacityFire)
    {
        this.generateCapacityFire = generateCapacityFire;
    }

    public String getGenerateCapacityFire()
    {
        return generateCapacityFire;
    }
    public void setGenerateCapacityWind(String generateCapacityWind)
    {
        this.generateCapacityWind = generateCapacityWind;
    }

    public String getGenerateCapacityWind()
    {
        return generateCapacityWind;
    }
    public void setGenerateCapacityWater(String generateCapacityWater)
    {
        this.generateCapacityWater = generateCapacityWater;
    }

    public String getGenerateCapacityWater()
    {
        return generateCapacityWater;
    }
    public void setGenerateCapacityLight(String generateCapacityLight)
    {
        this.generateCapacityLight = generateCapacityLight;
    }

    public String getGenerateCapacityLight()
    {
        return generateCapacityLight;
    }
    public void setHeatSupply(String heatSupply)
    {
        this.heatSupply = heatSupply;
    }

    public String getHeatSupply()
    {
        return heatSupply;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
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
                .append("generateCapacityFire", getGenerateCapacityFire())
                .append("generateCapacityWind", getGenerateCapacityWind())
                .append("generateCapacityWater", getGenerateCapacityWater())
                .append("generateCapacityLight", getGenerateCapacityLight())
                .append("heatSupply", getHeatSupply())
                .append("price", getPrice())
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
