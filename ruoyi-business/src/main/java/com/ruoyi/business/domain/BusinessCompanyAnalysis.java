package com.ruoyi.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 清能公司分析指标对象 business_company_analysis
 * 
 * @author lpf
 * @date 2021-03-02
 */
@ApiModel("清能公司分析指标返回对象,除了id没有注释的字段不用管")
public class BusinessCompanyAnalysis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "id",name = "id",dataType = "Long")
    private Long id;

    /** 年份 */
    @Excel(name = "年份")
    @ApiModelProperty(value = "年份",name = "year",dataType = "Long")
    private Long year;

    /** 发电机组台数 */
    @Excel(name = "发电机组台数")
    @ApiModelProperty(value = "发电机组台数",name = "generateNumber",dataType = "String")
    private String generateNumber;

    /** 发电设备容量 */
    @Excel(name = "发电设备容量")
    @ApiModelProperty(value = "发电设备容量",name = "equipmentCapacity",dataType = "String")
    private String equipmentCapacity;

    /** 发电量 */
    @Excel(name = "发电量")
    @ApiModelProperty(value = "发电量",name = "powerCapacity",dataType = "String")
    private String powerCapacity;

    /** 日历小时 */
    @Excel(name = "日历小时")
    @ApiModelProperty(value = "日历小时",name = "dayOfHour",dataType = "String")
    private String dayOfHour;

    /** 试运电量 */
    @Excel(name = "试运电量")
    @ApiModelProperty(value = "试运电量",name = "runCapacity",dataType = "String")
    private String runCapacity;

    /** 上网电量 */
    @Excel(name = "上网电量")
    @ApiModelProperty(value = "上网电量",name = "netCapacity",dataType = "String")
    private String netCapacity;

    /** 发电设备平均容量 */
    @Excel(name = "发电设备平均容量")
    @ApiModelProperty(value = "发电设备平均容量",name = "avgCapacity",dataType = "String")
    private String avgCapacity;

    /** 发电设备平均利用小时 */
    @Excel(name = "发电设备平均利用小时")
    @ApiModelProperty(value = "发电设备平均利用小时",name = "avgUseHour",dataType = "String")
    private String avgUseHour;

    /** 计算场用电率的发电量 */
    @Excel(name = "计算场用电率的发电量")
    @ApiModelProperty(value = "计算场用电率的发电量",name = "ohterRateCapacity",dataType = "String")
    private String ohterRateCapacity;

    /** 外购电量 */
    @Excel(name = "外购电量")
    @ApiModelProperty(value = "外购电量",name = "outsourcingCapacity",dataType = "String")
    private String outsourcingCapacity;

    /** 其他电量 */
    @Excel(name = "其他电量")
    @ApiModelProperty(value = "其他电量",name = "otherCapacity",dataType = "String")
    private String otherCapacity;

    /** 风电场全部耗用电量 */
    @Excel(name = "风电场全部耗用电量")
    @ApiModelProperty(value = "风电场全部耗用电量",name = "windCapacity",dataType = "String")
    private String windCapacity;

    /** 发电场用电量 */
    @Excel(name = "发电场用电量")
    @ApiModelProperty(value = "发电场用电量",name = "powerPlantCapacity",dataType = "String")
    private String powerPlantCapacity;

    /** 综合场用电率 */
    @Excel(name = "综合场用电率")
    @ApiModelProperty(value = "综合场用电率",name = "totalUseRate",dataType = "String")
    private String totalUseRate;

    /** 场用电率 */
    @Excel(name = "场用电率")
    @ApiModelProperty(value = "场用电率",name = "plantRate",dataType = "String")
    private String plantRate;

    /** 运行小时 */
    @Excel(name = "运行小时")
    @ApiModelProperty(value = "运行小时",name = "runHour",dataType = "String")
    private String runHour;

    /** 备用小时 */
    @Excel(name = "备用小时")
    @ApiModelProperty(value = "备用小时",name = "spareHour",dataType = "String")
    private String spareHour;

    /** 计划停运小时 */
    @Excel(name = "计划停运小时")
    @ApiModelProperty(value = "计划停运小时",name = "stopRunHour",dataType = "String")
    private String stopRunHour;

    /** 非计划停运小时 */
    @Excel(name = "非计划停运小时")
    @ApiModelProperty(value = "非计划停运小时",name = "unstopRunHour",dataType = "String")
    private String unstopRunHour;

    /** 等效可用小时 */
    @Excel(name = "等效可用小时")
    @ApiModelProperty(value = "等效可用小时",name = "equalUseHour",dataType = "String")
    private String equalUseHour;

    /** 等效可用系数 */
    @Excel(name = "等效可用系数")
    @ApiModelProperty(value = "等效可用系数",name = "equalUseCoefficient",dataType = "String")
    private String equalUseCoefficient;

    /** 出力系数 */
    @Excel(name = "出力系数")
    @ApiModelProperty(value = "出力系数",name = "powerCoefficient",dataType = "String")
    private String powerCoefficient;

    /** 平均利用率 */
    @Excel(name = "平均利用率")
    @ApiModelProperty(value = "平均利用率",name = "avgUseRate",dataType = "String")
    private String avgUseRate;

    /** 平均可调出力 */
    @Excel(name = "平均可调出力")
    @ApiModelProperty(value = "平均可调出力",name = "avgPower",dataType = "String")
    private String avgPower;

    /** 非计划停运次数 */
    @Excel(name = "非计划停运次数")
    @ApiModelProperty(value = "非计划停运次数",name = "unstopRunNumber",dataType = "String")
    private String unstopRunNumber;

    /** 安全运行天数 */
    @Excel(name = "安全运行天数")
    @ApiModelProperty(value = "安全运行天数",name = "safeRunDays",dataType = "String")
    private String safeRunDays;

    /** 平均风速 */
    @Excel(name = "平均风速")
    @ApiModelProperty(value = "平均风速",name = "avgWindSpeed",dataType = "String")
    private String avgWindSpeed;

    /** 最高负荷 */
    @Excel(name = "最高负荷")
    @ApiModelProperty(value = "最高负荷",name = "maxLoad",dataType = "String")
    private String maxLoad;

    /** 弃风电量 */
    @Excel(name = "弃风电量")
    @ApiModelProperty(value = "弃风电量",name = "abandonedWindPower",dataType = "String")
    private String abandonedWindPower;

    /** 网架原因 */
    @Excel(name = "网架原因")
    @ApiModelProperty(value = "网架原因",name = "gridTrussReason",dataType = "String")
    private String gridTrussReason;

    /** 机组本身故障 */
    @Excel(name = "机组本身故障")
    @ApiModelProperty(value = "机组本身故障",name = "unitFailure",dataType = "String")
    private String unitFailure;

    /** 其它原因 */
    @Excel(name = "其它原因")
    @ApiModelProperty(value = "其它原因",name = "ohterReason",dataType = "String")
    private String ohterReason;

    /** 弃风率 */
    @Excel(name = "弃风率")
    @ApiModelProperty(value = "弃风率",name = "abandonedWindRate",dataType = "String")
    private String abandonedWindRate;

    /** 状态 */
    @Excel(name = "状态")
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
    public void setGenerateNumber(String generateNumber) 
    {
        this.generateNumber = generateNumber;
    }

    public String getGenerateNumber() 
    {
        return generateNumber;
    }
    public void setEquipmentCapacity(String equipmentCapacity) 
    {
        this.equipmentCapacity = equipmentCapacity;
    }

    public String getEquipmentCapacity() 
    {
        return equipmentCapacity;
    }
    public void setPowerCapacity(String powerCapacity) 
    {
        this.powerCapacity = powerCapacity;
    }

    public String getPowerCapacity() 
    {
        return powerCapacity;
    }
    public void setDayOfHour(String dayOfHour) 
    {
        this.dayOfHour = dayOfHour;
    }

    public String getDayOfHour() 
    {
        return dayOfHour;
    }
    public void setRunCapacity(String runCapacity) 
    {
        this.runCapacity = runCapacity;
    }

    public String getRunCapacity() 
    {
        return runCapacity;
    }
    public void setNetCapacity(String netCapacity) 
    {
        this.netCapacity = netCapacity;
    }

    public String getNetCapacity() 
    {
        return netCapacity;
    }
    public void setAvgCapacity(String avgCapacity) 
    {
        this.avgCapacity = avgCapacity;
    }

    public String getAvgCapacity() 
    {
        return avgCapacity;
    }
    public void setAvgUseHour(String avgUseHour) 
    {
        this.avgUseHour = avgUseHour;
    }

    public String getAvgUseHour() 
    {
        return avgUseHour;
    }
    public void setOhterRateCapacity(String ohterRateCapacity) 
    {
        this.ohterRateCapacity = ohterRateCapacity;
    }

    public String getOhterRateCapacity() 
    {
        return ohterRateCapacity;
    }
    public void setOutsourcingCapacity(String outsourcingCapacity) 
    {
        this.outsourcingCapacity = outsourcingCapacity;
    }

    public String getOutsourcingCapacity() 
    {
        return outsourcingCapacity;
    }
    public void setOtherCapacity(String otherCapacity) 
    {
        this.otherCapacity = otherCapacity;
    }

    public String getOtherCapacity() 
    {
        return otherCapacity;
    }
    public void setWindCapacity(String windCapacity) 
    {
        this.windCapacity = windCapacity;
    }

    public String getWindCapacity() 
    {
        return windCapacity;
    }
    public void setPowerPlantCapacity(String powerPlantCapacity) 
    {
        this.powerPlantCapacity = powerPlantCapacity;
    }

    public String getPowerPlantCapacity() 
    {
        return powerPlantCapacity;
    }
    public void setTotalUseRate(String totalUseRate) 
    {
        this.totalUseRate = totalUseRate;
    }

    public String getTotalUseRate() 
    {
        return totalUseRate;
    }
    public void setPlantRate(String plantRate) 
    {
        this.plantRate = plantRate;
    }

    public String getPlantRate() 
    {
        return plantRate;
    }
    public void setRunHour(String runHour) 
    {
        this.runHour = runHour;
    }

    public String getRunHour() 
    {
        return runHour;
    }
    public void setSpareHour(String spareHour) 
    {
        this.spareHour = spareHour;
    }

    public String getSpareHour() 
    {
        return spareHour;
    }
    public void setStopRunHour(String stopRunHour) 
    {
        this.stopRunHour = stopRunHour;
    }

    public String getStopRunHour() 
    {
        return stopRunHour;
    }
    public void setUnstopRunHour(String unstopRunHour) 
    {
        this.unstopRunHour = unstopRunHour;
    }

    public String getUnstopRunHour() 
    {
        return unstopRunHour;
    }
    public void setEqualUseHour(String equalUseHour) 
    {
        this.equalUseHour = equalUseHour;
    }

    public String getEqualUseHour() 
    {
        return equalUseHour;
    }
    public void setEqualUseCoefficient(String equalUseCoefficient) 
    {
        this.equalUseCoefficient = equalUseCoefficient;
    }

    public String getEqualUseCoefficient() 
    {
        return equalUseCoefficient;
    }
    public void setPowerCoefficient(String powerCoefficient) 
    {
        this.powerCoefficient = powerCoefficient;
    }

    public String getPowerCoefficient() 
    {
        return powerCoefficient;
    }
    public void setAvgUseRate(String avgUseRate) 
    {
        this.avgUseRate = avgUseRate;
    }

    public String getAvgUseRate() 
    {
        return avgUseRate;
    }
    public void setAvgPower(String avgPower) 
    {
        this.avgPower = avgPower;
    }

    public String getAvgPower() 
    {
        return avgPower;
    }
    public void setUnstopRunNumber(String unstopRunNumber) 
    {
        this.unstopRunNumber = unstopRunNumber;
    }

    public String getUnstopRunNumber() 
    {
        return unstopRunNumber;
    }
    public void setSafeRunDays(String safeRunDays) 
    {
        this.safeRunDays = safeRunDays;
    }

    public String getSafeRunDays() 
    {
        return safeRunDays;
    }
    public void setAvgWindSpeed(String avgWindSpeed) 
    {
        this.avgWindSpeed = avgWindSpeed;
    }

    public String getAvgWindSpeed() 
    {
        return avgWindSpeed;
    }
    public void setMaxLoad(String maxLoad) 
    {
        this.maxLoad = maxLoad;
    }

    public String getMaxLoad() 
    {
        return maxLoad;
    }
    public void setAbandonedWindPower(String abandonedWindPower) 
    {
        this.abandonedWindPower = abandonedWindPower;
    }

    public String getAbandonedWindPower() 
    {
        return abandonedWindPower;
    }
    public void setGridTrussReason(String gridTrussReason) 
    {
        this.gridTrussReason = gridTrussReason;
    }

    public String getGridTrussReason() 
    {
        return gridTrussReason;
    }
    public void setUnitFailure(String unitFailure) 
    {
        this.unitFailure = unitFailure;
    }

    public String getUnitFailure() 
    {
        return unitFailure;
    }
    public void setOhterReason(String ohterReason) 
    {
        this.ohterReason = ohterReason;
    }

    public String getOhterReason() 
    {
        return ohterReason;
    }
    public void setAbandonedWindRate(String abandonedWindRate) 
    {
        this.abandonedWindRate = abandonedWindRate;
    }

    public String getAbandonedWindRate() 
    {
        return abandonedWindRate;
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
            .append("generateNumber", getGenerateNumber())
            .append("equipmentCapacity", getEquipmentCapacity())
            .append("powerCapacity", getPowerCapacity())
            .append("dayOfHour", getDayOfHour())
            .append("runCapacity", getRunCapacity())
            .append("netCapacity", getNetCapacity())
            .append("avgCapacity", getAvgCapacity())
            .append("avgUseHour", getAvgUseHour())
            .append("ohterRateCapacity", getOhterRateCapacity())
            .append("outsourcingCapacity", getOutsourcingCapacity())
            .append("otherCapacity", getOtherCapacity())
            .append("windCapacity", getWindCapacity())
            .append("powerPlantCapacity", getPowerPlantCapacity())
            .append("totalUseRate", getTotalUseRate())
            .append("plantRate", getPlantRate())
            .append("runHour", getRunHour())
            .append("spareHour", getSpareHour())
            .append("stopRunHour", getStopRunHour())
            .append("unstopRunHour", getUnstopRunHour())
            .append("equalUseHour", getEqualUseHour())
            .append("equalUseCoefficient", getEqualUseCoefficient())
            .append("powerCoefficient", getPowerCoefficient())
            .append("avgUseRate", getAvgUseRate())
            .append("avgPower", getAvgPower())
            .append("unstopRunNumber", getUnstopRunNumber())
            .append("safeRunDays", getSafeRunDays())
            .append("avgWindSpeed", getAvgWindSpeed())
            .append("maxLoad", getMaxLoad())
            .append("abandonedWindPower", getAbandonedWindPower())
            .append("gridTrussReason", getGridTrussReason())
            .append("unitFailure", getUnitFailure())
            .append("ohterReason", getOhterReason())
            .append("abandonedWindRate", getAbandonedWindRate())
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
