package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 清能公司统计指标对象 business_company_statistics
 * 
 * @author lpf
 * @date 2021-03-02
 */
@ApiModel("清能公司统计指标返回对象,除了id没有注释的字段不用管")
public class BusinessCompanyStatistics extends BaseEntity
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

    /** 期末装机容量 */
    @Excel(name = "期末装机容量")
    @ApiModelProperty(value = "期末装机容量",name = "installedCapacity",dataType = "String")
    private String installedCapacity;

    /** 发电设备平均容量 */
    @Excel(name = "发电设备平均容量")
    @ApiModelProperty(value = "发电设备平均容量",name = "avgCapacity",dataType = "String")
    private String avgCapacity;

    /** 发电量 */
    @Excel(name = "发电量")
    @ApiModelProperty(value = "发电量",name = "generateCapacity",dataType = "String")
    private String generateCapacity;

    /** 试运电量 */
    @Excel(name = "试运电量")
    @ApiModelProperty(value = "试运电量",name = "runCapacity",dataType = "String")
    private String runCapacity;

    /** 上网电量 */
    @Excel(name = "上网电量")
    @ApiModelProperty(value = "上网电量",name = "netCapacity",dataType = "String")
    private String netCapacity;

    /** 外购电量 */
    @Excel(name = "外购电量")
    @ApiModelProperty(value = "外购电量",name = "outsourcingCapacity",dataType = "String")
    private String outsourcingCapacity;

    /** 其他电量 */
    @Excel(name = "其他电量")
    @ApiModelProperty(value = "其他电量",name = "otherCapacity",dataType = "String")
    private String otherCapacity;

    /** 综合厂用电量 */
    @Excel(name = "综合厂用电量")
    @ApiModelProperty(value = "综合厂用电量",name = "totalCapacity",dataType = "String")
    private String totalCapacity;

    @Excel(name = "发电厂用电量")
    @ApiModelProperty(value = "发电厂用电量",name = "plantCapacity",dataType = "String")
    private String plantCapacity;

    /** 综合厂用电量率 */
    @Excel(name = "综合厂用电量率")
    @ApiModelProperty(value = "综合厂用电量率",name = "totalRate",dataType = "String")
    private String totalRate;

    /** 发电厂用电率 */
    @Excel(name = "发电厂用电率")
    @ApiModelProperty(value = "发电厂用电率",name = "powerRate",dataType = "String")
    private String powerRate;

    /** 等效可用系数 */
    @Excel(name = "等效可用系数")
    @ApiModelProperty(value = "等效可用系数",name = "equalCoefficient",dataType = "String")
    private String equalCoefficient;

    /** 出力系数 */
    @Excel(name = "出力系数")
    @ApiModelProperty(value = "出力系数",name = "powerCoefficient",dataType = "String")
    private String powerCoefficient;

    /** 运行小时 */
    @Excel(name = "运行小时")
    @ApiModelProperty(value = "运行小时",name = "runHour",dataType = "String")
    private String runHour;

    /** 利用小时 */
    @Excel(name = "利用小时")
    @ApiModelProperty(value = "利用小时",name = "useHour",dataType = "String")
    private String useHour;

    /** 水电耗水耗 */
    @Excel(name = "水电耗水耗")
    @ApiModelProperty(value = "水电耗水耗",name = "waterPowerRate",dataType = "String")
    private String waterPowerRate;

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
    public void setInstalledCapacity(String installedCapacity) 
    {
        this.installedCapacity = installedCapacity;
    }

    public String getInstalledCapacity() 
    {
        return installedCapacity;
    }
    public void setAvgCapacity(String avgCapacity) 
    {
        this.avgCapacity = avgCapacity;
    }

    public String getAvgCapacity() 
    {
        return avgCapacity;
    }
    public void setGenerateCapacity(String generateCapacity) 
    {
        this.generateCapacity = generateCapacity;
    }

    public String getGenerateCapacity() 
    {
        return generateCapacity;
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
    public void setTotalCapacity(String totalCapacity) 
    {
        this.totalCapacity = totalCapacity;
    }

    public String getTotalCapacity() 
    {
        return totalCapacity;
    }
    public void setTotalRate(String totalRate) 
    {
        this.totalRate = totalRate;
    }

    public String getTotalRate() 
    {
        return totalRate;
    }
    public void setPowerRate(String powerRate) 
    {
        this.powerRate = powerRate;
    }

    public String getPowerRate() 
    {
        return powerRate;
    }
    public void setEqualCoefficient(String equalCoefficient) 
    {
        this.equalCoefficient = equalCoefficient;
    }

    public String getEqualCoefficient() 
    {
        return equalCoefficient;
    }
    public void setPowerCoefficient(String powerCoefficient) 
    {
        this.powerCoefficient = powerCoefficient;
    }

    public String getPowerCoefficient() 
    {
        return powerCoefficient;
    }
    public void setRunHour(String runHour) 
    {
        this.runHour = runHour;
    }

    public String getRunHour() 
    {
        return runHour;
    }
    public void setUseHour(String useHour) 
    {
        this.useHour = useHour;
    }

    public String getUseHour() 
    {
        return useHour;
    }
    public void setWaterPowerRate(String waterPowerRate) 
    {
        this.waterPowerRate = waterPowerRate;
    }

    public String getWaterPowerRate() 
    {
        return waterPowerRate;
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

    public String getPlantCapacity() {
        return plantCapacity;
    }

    public void setPlantCapacity(String plantCapacity) {
        this.plantCapacity = plantCapacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("installedCapacity", getInstalledCapacity())
            .append("avgCapacity", getAvgCapacity())
            .append("generateCapacity", getGenerateCapacity())
            .append("runCapacity", getRunCapacity())
            .append("netCapacity", getNetCapacity())
            .append("outsourcingCapacity", getOutsourcingCapacity())
            .append("otherCapacity", getOtherCapacity())
            .append("totalCapacity", getTotalCapacity())
            .append("totalRate", getTotalRate())
            .append("powerRate", getPowerRate())
            .append("equalCoefficient", getEqualCoefficient())
            .append("powerCoefficient", getPowerCoefficient())
            .append("runHour", getRunHour())
            .append("useHour", getUseHour())
            .append("waterPowerRate", getWaterPowerRate())
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
