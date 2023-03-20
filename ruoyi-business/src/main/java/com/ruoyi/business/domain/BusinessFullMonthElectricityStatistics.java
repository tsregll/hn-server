package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 全月日电量统计对象 business_full_month_electricity_statistics
 * 
 * @author yrb
 * @date 2021-03-13
 */
public class BusinessFullMonthElectricityStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 年月日（yyyy-mm-dd） */
//    @Excel(name = "日期",isRequired = true,dateFormat = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期")
    private String enteringDate;

    /** 统调用电量 */
    @Excel(name = "统调用电量",isRequired = true)
    private String consumptionElectricityAll;

    /** 统调发电量 */
    @Excel(name = "统调发电量",isRequired = true)
    private String generatingElectricityAll;

    /** 统调最大日负荷 */
    @Excel(name = "统调最大日负荷",isRequired = true)
    private String burthenMax;

    /** 统调最小日负荷 */
    @Excel(name = "统调最小日负荷",isRequired = true)
    private String burthenMin;

    /** 统调平均日负荷 */
    @Excel(name = "统调平均日负荷",isRequired = true)
    private String burthenAverage;

    /** 统调火电 */
    @Excel(name = "统调火电",isRequired = true)
    private String burthenFire;

    /** 统调20万千瓦及以上煤机 */
    @Excel(name = "统调公用火电",isRequired = true)
    private String burthenCoal;

    /** 统调水电 */
    @Excel(name = "统调水电",isRequired = true)
    private String burthenWater;

    /** 风电 */
    @Excel(name = "风电",isRequired = true)
    private String burthenWind;

    /** 生物质 */
    @Excel(name = "生物质",isRequired = true)
    private String burthenBiomass;

    /** 光伏 */
    @Excel(name = "光伏",isRequired = true)
    private String burthenLight;

    /** 外购（祁韶直流） */
    @Excel(name = "外购(祁韶直流)",isRequired = true)
    private String outsourcingQszl;

    /** 外购（三峡、葛洲坝） */
    @Excel(name = "外购(湘鄂联络线南送)",isRequired = true)
    private String outsourcingSxgzb;

    /** 送出（联络线北送） */
    @Excel(name = "送出（联络线北送）",isRequired = true)
    private String launchLinkLine;

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
    public void setConsumptionElectricityAll(String consumptionElectricityAll) 
    {
        this.consumptionElectricityAll = consumptionElectricityAll;
    }

    public String getConsumptionElectricityAll() 
    {
        return consumptionElectricityAll;
    }
    public void setGeneratingElectricityAll(String generatingElectricityAll) 
    {
        this.generatingElectricityAll = generatingElectricityAll;
    }

    public String getGeneratingElectricityAll() 
    {
        return generatingElectricityAll;
    }
    public void setBurthenMax(String burthenMax) 
    {
        this.burthenMax = burthenMax;
    }

    public String getBurthenMax() 
    {
        return burthenMax;
    }
    public void setBurthenMin(String burthenMin) 
    {
        this.burthenMin = burthenMin;
    }

    public String getBurthenMin() 
    {
        return burthenMin;
    }
    public void setBurthenAverage(String burthenAverage) 
    {
        this.burthenAverage = burthenAverage;
    }

    public String getBurthenAverage() 
    {
        return burthenAverage;
    }
    public void setBurthenFire(String burthenFire) 
    {
        this.burthenFire = burthenFire;
    }

    public String getBurthenFire() 
    {
        return burthenFire;
    }
    public void setBurthenCoal(String burthenCoal) 
    {
        this.burthenCoal = burthenCoal;
    }

    public String getBurthenCoal() 
    {
        return burthenCoal;
    }
    public void setBurthenWater(String burthenWater) 
    {
        this.burthenWater = burthenWater;
    }

    public String getBurthenWater() 
    {
        return burthenWater;
    }
    public void setBurthenWind(String burthenWind) 
    {
        this.burthenWind = burthenWind;
    }

    public String getBurthenWind() 
    {
        return burthenWind;
    }
    public void setBurthenBiomass(String burthenBiomass) 
    {
        this.burthenBiomass = burthenBiomass;
    }

    public String getBurthenBiomass() 
    {
        return burthenBiomass;
    }
    public void setBurthenLight(String burthenLight) 
    {
        this.burthenLight = burthenLight;
    }

    public String getBurthenLight() 
    {
        return burthenLight;
    }
    public void setOutsourcingQszl(String outsourcingQszl) 
    {
        this.outsourcingQszl = outsourcingQszl;
    }

    public String getOutsourcingQszl() 
    {
        return outsourcingQszl;
    }
    public void setOutsourcingSxgzb(String outsourcingSxgzb) 
    {
        this.outsourcingSxgzb = outsourcingSxgzb;
    }

    public String getOutsourcingSxgzb() 
    {
        return outsourcingSxgzb;
    }
    public void setLaunchLinkLine(String launchLinkLine) 
    {
        this.launchLinkLine = launchLinkLine;
    }

    public String getLaunchLinkLine() 
    {
        return launchLinkLine;
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
            .append("consumptionElectricityAll", getConsumptionElectricityAll())
            .append("generatingElectricityAll", getGeneratingElectricityAll())
            .append("burthenMax", getBurthenMax())
            .append("burthenMin", getBurthenMin())
            .append("burthenAverage", getBurthenAverage())
            .append("burthenFire", getBurthenFire())
            .append("burthenCoal", getBurthenCoal())
            .append("burthenWater", getBurthenWater())
            .append("burthenWind", getBurthenWind())
            .append("burthenBiomass", getBurthenBiomass())
            .append("burthenLight", getBurthenLight())
            .append("outsourcingQszl", getOutsourcingQszl())
            .append("outsourcingSxgzb", getOutsourcingSxgzb())
            .append("launchLinkLine", getLaunchLinkLine())
            .toString();
    }
}
