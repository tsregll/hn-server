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
 * 煤机发电总貌对象 business_electric_coal
 *
 * @author ruoyi
 * @date 2021-03-08
 */
@ApiModel("煤电发电总貌返回对象,除了id没有注释的字段不用管")
public class BusinessElectricCoal extends BaseEntity
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

    /** 总发电量 */
    @Excel(name = "总发电量")
    @ApiModelProperty(value = "总发电量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 第一期发电量 */
    @Excel(name = "第一期发电量")
    @ApiModelProperty(value = "第一期发电量",name = "generateCapacityFirst",dataType = "String")
    private String generateCapacityFirst;

    /** 第二期发电量 */
    @Excel(name = "第二期发电量")
    @ApiModelProperty(value = "第二期发电量",name = "generateCapacitySecond",dataType = "String")
    private String generateCapacitySecond;

    /** 第三期发电量 */
    @Excel(name = "第三期发电量")
    @ApiModelProperty(value = "第三期发电量",name = "generateCapacityThirdly",dataType = "String")
    private String generateCapacityThirdly;

    /** 供热量 */
    @Excel(name = "供热量")
    @ApiModelProperty(value = "供热量",name = "heatSupply",dataType = "String")
    private String heatSupply;

    /** 煤耗 */
    @Excel(name = "供电煤耗")
    @ApiModelProperty(value = "煤耗",name = "coalComsumer",dataType = "String")
    private String coalComsumer;

    /** 生产厂用电率 */
    @Excel(name = "生产厂用电率")
    @ApiModelProperty(value = "生产厂用电率",name = "rate",dataType = "String")
    private String rate;

    /** 综合电价 */
    @Excel(name = "综合电价")
    @ApiModelProperty(value = "综合电价",name = "integratedElectricity",dataType = "String")
    private String integratedElectricity;

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
    public void setGenerateCapacityFirst(String generateCapacityFirst)
    {
        this.generateCapacityFirst = generateCapacityFirst;
    }

    public String getGenerateCapacityFirst()
    {
        return generateCapacityFirst;
    }
    public void setGenerateCapacitySecond(String generateCapacitySecond)
    {
        this.generateCapacitySecond = generateCapacitySecond;
    }

    public String getGenerateCapacitySecond()
    {
        return generateCapacitySecond;
    }
    public void setGenerateCapacityThirdly(String generateCapacityThirdly)
    {
        this.generateCapacityThirdly = generateCapacityThirdly;
    }

    public String getGenerateCapacityThirdly()
    {
        return generateCapacityThirdly;
    }
    public void setHeatSupply(String heatSupply)
    {
        this.heatSupply = heatSupply;
    }

    public String getHeatSupply()
    {
        return heatSupply;
    }
    public void setCoalComsumer(String coalComsumer)
    {
        this.coalComsumer = coalComsumer;
    }

    public String getCoalComsumer()
    {
        return coalComsumer;
    }
    public void setRate(String rate)
    {
        this.rate = rate;
    }

    public String getRate()
    {
        return rate;
    }
    public void setIntegratedElectricity(String integratedElectricity)
    {
        this.integratedElectricity = integratedElectricity;
    }

    public String getIntegratedElectricity()
    {
        return integratedElectricity;
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
                .append("generateCapacityFirst", getGenerateCapacityFirst())
                .append("generateCapacitySecond", getGenerateCapacitySecond())
                .append("generateCapacityThirdly", getGenerateCapacityThirdly())
                .append("heatSupply", getHeatSupply())
                .append("coalComsumer", getCoalComsumer())
                .append("rate", getRate())
                .append("integratedElectricity", getIntegratedElectricity())
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
