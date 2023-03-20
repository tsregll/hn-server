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
 * 供热年度绩效对象 business_heart_score
 *
 * @author ruoyi
 * @date 2021-03-08
 */
@ApiModel("供热年度绩效返回对象,除了id没有注释的字段不用管")
public class BusinessHeartScore extends BaseEntity
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

    /** 总供热量（原注解是发电量） */
    @Excel(name = "总供热量")
    @ApiModelProperty(value = "总供热量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 一期供热量 */
    @Excel(name = "一期供热量")
    @ApiModelProperty(value = "一期供热量",name = "generateCapacityFirst",dataType = "String")
    private String generateCapacityFirst;

    /** 二期供热量 */
    @Excel(name = "二期供热量")
    @ApiModelProperty(value = "二期供热量",name = "generateCapacitySecond",dataType = "String")
    private String generateCapacitySecond;

    /** 三期供热量 */
    @Excel(name = "三期供热量")
    @ApiModelProperty(value = "三期供热量",name = "generateCapacityThirdly",dataType = "String")
    private String generateCapacityThirdly;

    /** 供热价格 */
    @Excel(name = "供热价格")
    @ApiModelProperty(value = "供热价格",name = "price",dataType = "Long")
    private Long price;

    /** 供热收入 */
    @Excel(name = "供热收入")
    @ApiModelProperty(value = "供热收入",name = "income",dataType = "BigDecimal")
    private BigDecimal income;

    /** 利润总额 */
    @Excel(name = "利润总额")
    @ApiModelProperty(value = "利润总额",name = "totalPrice",dataType = "BigDecimal")
    private BigDecimal totalPrice;

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
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setIncome(BigDecimal income)
    {
        this.income = income;
    }

    public BigDecimal getIncome()
    {
        return income;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
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
                .append("price", getPrice())
                .append("income", getIncome())
                .append("totalPrice", getTotalPrice())
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
