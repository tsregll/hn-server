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
 * 风能发电总貌对象 business_electric_wind
 *
 * @author lpf
 * @date 2021-03-02
 */
@ApiModel("风能发电总貌返回对象,除了id没有注释的字段不用管")
public class BusinessElectricWind extends BaseEntity
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
    @Excel(name = "总发电量")
    @ApiModelProperty(value = "总发电量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 生产厂用电率 */
    @Excel(name = "生产厂用电率")
    @ApiModelProperty(value = "生产厂用电率",name = "rate",dataType = "String")
    private String rate;

    /** 利润总额 */
    @Excel(name = "统计利润总额")
    @ApiModelProperty(value = "统计利润总额",name = "totalPrice",dataType = "BigDecimal")
    private BigDecimal totalPrice;

    /** EVA */
    @Excel(name = "统计EVA")
    @ApiModelProperty(value = "统计EVA",name = "eva",dataType = "BigDecimal")
    private BigDecimal eva;

    /** 状态 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 苏宝顶发电量 */
    @Excel(name = "苏宝顶发电量")
    @ApiModelProperty(value = "苏宝顶发电量",name = "generateCapacitySbd",dataType = "String")
    private String generateCapacitySbd;

    /** 桂东发电量 */
    @Excel(name = "桂东发电量")
    @ApiModelProperty(value = "桂东发电量",name = "generateCapacityGd",dataType = "String")
    private String generateCapacityGd;

    /** 连坪发电量 */
    @Excel(name = "连坪发电量")
    @ApiModelProperty(value = "连坪发电量",name = "generateCapacityLp",dataType = "String")
    private String generateCapacityLp;

    /** 梅桥发电量 */
    @Excel(name = "梅桥发电量")
    @ApiModelProperty(value = "梅桥发电量",name = "generateCapacityMq",dataType = "String")
    private String generateCapacityMq;

    /** 北湖发电量 */
    @Excel(name = "北湖发电量")
    @ApiModelProperty(value = "北湖发电量",name = "generateCapacityBh",dataType = "String")
    private String generateCapacityBh;

    /** 回龙圩发电量 */
    @Excel(name = "回龙圩发电量")
    @ApiModelProperty(value = "回龙圩发电量",name = "generateCapacityHly",dataType = "String")
    private String generateCapacityHly;

    /** 苏宝顶利润总额 */
    @Excel(name = "苏宝顶利润总额")
    @ApiModelProperty(value = "苏宝顶利润总额",name = "totalPriceSbd",dataType = "BigDecimal")
    private BigDecimal totalPriceSbd;

    /** 桂东利润总额 */
    @Excel(name = "桂东利润总额")
    @ApiModelProperty(value = "桂东利润总额",name = "totalPriceGd",dataType = "BigDecimal")
    private BigDecimal totalPriceGd;

    /** 连坪利润总额 */
    @Excel(name = "连坪利润总额")
    @ApiModelProperty(value = "连坪利润总额",name = "totalPriceLp",dataType = "BigDecimal")
    private BigDecimal totalPriceLp;

    /** 梅桥利润总额 */
    @Excel(name = "梅桥利润总额")
    @ApiModelProperty(value = "梅桥利润总额",name = "totalPriceMq",dataType = "BigDecimal")
    private BigDecimal totalPriceMq;

    /** 北湖利润总额 */
    @Excel(name = "北湖利润总额")
    @ApiModelProperty(value = "北湖利润总额",name = "totalPriceBh",dataType = "BigDecimal")
    private BigDecimal totalPriceBh;

    /** 回龙圩利润总额 */
    @Excel(name = "回龙圩利润总额")
    @ApiModelProperty(value = "回龙圩利润总额",name = "totalPriceHly",dataType = "BigDecimal")
    private BigDecimal totalPriceHly;

    /** 苏宝顶EVA */
    @Excel(name = "苏宝顶EVA")
    @ApiModelProperty(value = "苏宝顶EVA",name = "evaSbd",dataType = "BigDecimal")
    private BigDecimal evaSbd;

    /** 桂东EVA */
    @Excel(name = "桂东EVA")
    @ApiModelProperty(value = "桂东EVA",name = "evaGd",dataType = "BigDecimal")
    private BigDecimal evaGd;

    /** 连坪EVA */
    @Excel(name = "连坪EVA")
    @ApiModelProperty(value = "连坪EVA",name = "evaLp",dataType = "BigDecimal")
    private BigDecimal evaLp;

    /** 梅桥EVA */
    @Excel(name = "梅桥EVA")
    @ApiModelProperty(value = "梅桥EVA",name = "evaMq",dataType = "BigDecimal")
    private BigDecimal evaMq;

    /** 北湖EVA */
    @Excel(name = "北湖EVA")
    @ApiModelProperty(value = "北湖EVA",name = "evaBh",dataType = "BigDecimal")
    private BigDecimal evaBh;

    /** 回龙圩EVA */
    @Excel(name = "回龙圩EVA")
    @ApiModelProperty(value = "回龙圩EVA",name = "evaHly",dataType = "BigDecimal")
    private BigDecimal evaHly;

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
    public void setRate(String rate)
    {
        this.rate = rate;
    }

    public String getRate()
    {
        return rate;
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
    public void setGenerateCapacity(String generateCapacity)
    {
        this.generateCapacity = generateCapacity;
    }

    public String getGenerateCapacity()
    {
        return generateCapacity;
    }
    public void setGenerateCapacitySbd(String generateCapacitySbd)
    {
        this.generateCapacitySbd = generateCapacitySbd;
    }

    public String getGenerateCapacitySbd()
    {
        return generateCapacitySbd;
    }
    public void setGenerateCapacityGd(String generateCapacityGd)
    {
        this.generateCapacityGd = generateCapacityGd;
    }

    public String getGenerateCapacityGd()
    {
        return generateCapacityGd;
    }
    public void setGenerateCapacityLp(String generateCapacityLp)
    {
        this.generateCapacityLp = generateCapacityLp;
    }

    public String getGenerateCapacityLp()
    {
        return generateCapacityLp;
    }
    public void setGenerateCapacityMq(String generateCapacityMq)
    {
        this.generateCapacityMq = generateCapacityMq;
    }

    public String getGenerateCapacityMq()
    {
        return generateCapacityMq;
    }
    public void setGenerateCapacityBh(String generateCapacityBh)
    {
        this.generateCapacityBh = generateCapacityBh;
    }

    public String getGenerateCapacityBh()
    {
        return generateCapacityBh;
    }
    public void setGenerateCapacityHly(String generateCapacityHly)
    {
        this.generateCapacityHly = generateCapacityHly;
    }

    public String getGenerateCapacityHly()
    {
        return generateCapacityHly;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }
    public void setTotalPriceSbd(BigDecimal totalPriceSbd)
    {
        this.totalPriceSbd = totalPriceSbd;
    }

    public BigDecimal getTotalPriceSbd()
    {
        return totalPriceSbd;
    }
    public void setTotalPriceGd(BigDecimal totalPriceGd)
    {
        this.totalPriceGd = totalPriceGd;
    }

    public BigDecimal getTotalPriceGd()
    {
        return totalPriceGd;
    }
    public void setTotalPriceLp(BigDecimal totalPriceLp)
    {
        this.totalPriceLp = totalPriceLp;
    }

    public BigDecimal getTotalPriceLp()
    {
        return totalPriceLp;
    }
    public void setTotalPriceMq(BigDecimal totalPriceMq)
    {
        this.totalPriceMq = totalPriceMq;
    }

    public BigDecimal getTotalPriceMq()
    {
        return totalPriceMq;
    }
    public void setTotalPriceBh(BigDecimal totalPriceBh)
    {
        this.totalPriceBh = totalPriceBh;
    }

    public BigDecimal getTotalPriceBh()
    {
        return totalPriceBh;
    }
    public void setTotalPriceHly(BigDecimal totalPriceHly)
    {
        this.totalPriceHly = totalPriceHly;
    }

    public BigDecimal getTotalPriceHly()
    {
        return totalPriceHly;
    }
    public void setEva(BigDecimal eva)
    {
        this.eva = eva;
    }

    public BigDecimal getEva()
    {
        return eva;
    }
    public void setEvaSbd(BigDecimal evaSbd)
    {
        this.evaSbd = evaSbd;
    }

    public BigDecimal getEvaSbd()
    {
        return evaSbd;
    }
    public void setEvaGd(BigDecimal evaGd)
    {
        this.evaGd = evaGd;
    }

    public BigDecimal getEvaGd()
    {
        return evaGd;
    }
    public void setEvaLp(BigDecimal evaLp)
    {
        this.evaLp = evaLp;
    }

    public BigDecimal getEvaLp()
    {
        return evaLp;
    }
    public void setEvaMq(BigDecimal evaMq)
    {
        this.evaMq = evaMq;
    }

    public BigDecimal getEvaMq()
    {
        return evaMq;
    }
    public void setEvaBh(BigDecimal evaBh)
    {
        this.evaBh = evaBh;
    }

    public BigDecimal getEvaBh()
    {
        return evaBh;
    }
    public void setEvaHly(BigDecimal evaHly)
    {
        this.evaHly = evaHly;
    }

    public BigDecimal getEvaHly()
    {
        return evaHly;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("rate", getRate())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("generateCapacity", getGenerateCapacity())
            .append("generateCapacitySbd", getGenerateCapacitySbd())
            .append("generateCapacityGd", getGenerateCapacityGd())
            .append("generateCapacityLp", getGenerateCapacityLp())
            .append("generateCapacityMq", getGenerateCapacityMq())
            .append("generateCapacityBh", getGenerateCapacityBh())
            .append("generateCapacityHly", getGenerateCapacityHly())
            .append("totalPrice", getTotalPrice())
            .append("totalPriceSbd", getTotalPriceSbd())
            .append("totalPriceGd", getTotalPriceGd())
            .append("totalPriceLp", getTotalPriceLp())
            .append("totalPriceMq", getTotalPriceMq())
            .append("totalPriceBh", getTotalPriceBh())
            .append("totalPriceHly", getTotalPriceHly())
            .append("eva", getEva())
            .append("evaSbd", getEvaSbd())
            .append("evaGd", getEvaGd())
            .append("evaLp", getEvaLp())
            .append("evaMq", getEvaMq())
            .append("evaBh", getEvaBh())
            .append("evaHly", getEvaHly())
            .toString();
    }
}
