package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 区域年度指标录入对象 business_area_index
 * 
 * @author lpf
 * @date 2021-03-02
 */
@ApiModel("区域年度指标返回对象,除了id没有注释的字段不用管")
public class BusinessAreaIndex extends BaseEntity
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

    /** 供热厂用电量 */
    @Excel(name = "供热厂用电量")
    @ApiModelProperty(value = "供热厂用电量",name = "heartCapacity",dataType = "String")
    private String heartCapacity;

    /** 综合厂用电量率 */
    @Excel(name = "综合厂用电量率")
    @ApiModelProperty(value = "综合厂用电量率",name = "totalRate",dataType = "String")
    private String totalRate;

    /** 发电厂用电率 */
    @Excel(name = "发电厂用电率")
    @ApiModelProperty(value = "发电厂用电率",name = "powerRate",dataType = "String")
    private String powerRate;

    /** 工业抽汽量 */
    @Excel(name = "工业抽汽量")
    @ApiModelProperty(value = "工业抽汽量",name = "industryCapacity",dataType = "String")
    private String industryCapacity;

    /** 发电煤耗 */
    @Excel(name = "发电煤耗")
    @ApiModelProperty(value = "发电煤耗",name = "powerCoal",dataType = "String")
    private String powerCoal;

    /** 供电煤耗 */
    @Excel(name = "供电煤耗")
    @ApiModelProperty(value = "供电煤耗",name = "supplyCoal",dataType = "String")
    private String supplyCoal;

    /** 综合供电煤耗 */
    @Excel(name = "综合供电煤耗")
    @ApiModelProperty(value = "综合供电煤耗",name = "totalCoal",dataType = "String")
    private String totalCoal;

    /** 原煤耗用量 */
    @Excel(name = "原煤耗用量")
    @ApiModelProperty(value = "原煤耗用量",name = "rawCoal",dataType = "String")
    private String rawCoal;

    /** 发电原煤耗用量 */
    @Excel(name = "发电原煤耗用量")
    @ApiModelProperty(value = "发电原煤耗用量",name = "powerRawCoal",dataType = "String")
    private String powerRawCoal;

    /** 供热耗用原煤量 */
    @Excel(name = "供热耗用原煤量")
    @ApiModelProperty(value = "供热耗用原煤量",name = "supplyRawCoal",dataType = "String")
    private String supplyRawCoal;

    /** 燃油量 */
    @Excel(name = "燃油量")
    @ApiModelProperty(value = "燃油量",name = "oilCapacity",dataType = "String")
    private String oilCapacity;

    /** 入炉煤低位发热值 */
    @Excel(name = "入炉煤低位发热值")
    @ApiModelProperty(value = "入炉煤低位发热值",name = "lowFever",dataType = "String")
    private String lowFever;

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

    /** 供热比 */
    @Excel(name = "供热比")
    @ApiModelProperty(value = "供热比",name = "supplyHeartRate",dataType = "String")
    private String supplyHeartRate;

    /** NOX排放浓度（CEMS） */
    @Excel(name = "NOX排放浓度", readConverterExp = "C=EMS")
    @ApiModelProperty(value = "NOX排放浓度",name = "nox",dataType = "String")
    private String nox;

    /** SO2排放浓度（CEMS） */
    @ApiModelProperty(value = "SO2排放浓度",name = "so",dataType = "String")
    @Excel(name = "SO2排放浓度", readConverterExp = "C=EMS")
    private String so;

    /** 粉尘排放浓度（CEMS) */
    @ApiModelProperty(value = "粉尘排放浓度",name = "powderLayer",dataType = "String")
    @Excel(name = "粉尘排放浓度", readConverterExp = "粉尘排放浓度（CEMS)")
    private String powderLayer;

    /** 火电发电补水率 */
    @Excel(name = "火电发电补水率")
    @ApiModelProperty(value = "火电发电补水率",name = "fireWaterRate",dataType = "String")
    private String fireWaterRate;

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
    public void setHeartCapacity(String heartCapacity) 
    {
        this.heartCapacity = heartCapacity;
    }

    public String getHeartCapacity() 
    {
        return heartCapacity;
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
    public void setIndustryCapacity(String industryCapacity) 
    {
        this.industryCapacity = industryCapacity;
    }

    public String getIndustryCapacity() 
    {
        return industryCapacity;
    }
    public void setPowerCoal(String powerCoal) 
    {
        this.powerCoal = powerCoal;
    }

    public String getPowerCoal() 
    {
        return powerCoal;
    }
    public void setSupplyCoal(String supplyCoal) 
    {
        this.supplyCoal = supplyCoal;
    }

    public String getSupplyCoal() 
    {
        return supplyCoal;
    }
    public void setTotalCoal(String totalCoal) 
    {
        this.totalCoal = totalCoal;
    }

    public String getTotalCoal() 
    {
        return totalCoal;
    }
    public void setRawCoal(String rawCoal) 
    {
        this.rawCoal = rawCoal;
    }

    public String getRawCoal() 
    {
        return rawCoal;
    }
    public void setPowerRawCoal(String powerRawCoal) 
    {
        this.powerRawCoal = powerRawCoal;
    }

    public String getPowerRawCoal() 
    {
        return powerRawCoal;
    }
    public void setSupplyRawCoal(String supplyRawCoal) 
    {
        this.supplyRawCoal = supplyRawCoal;
    }

    public String getSupplyRawCoal() 
    {
        return supplyRawCoal;
    }
    public void setOilCapacity(String oilCapacity) 
    {
        this.oilCapacity = oilCapacity;
    }

    public String getOilCapacity() 
    {
        return oilCapacity;
    }
    public void setLowFever(String lowFever) 
    {
        this.lowFever = lowFever;
    }

    public String getLowFever() 
    {
        return lowFever;
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
    public void setSupplyHeartRate(String supplyHeartRate) 
    {
        this.supplyHeartRate = supplyHeartRate;
    }

    public String getSupplyHeartRate() 
    {
        return supplyHeartRate;
    }
    public void setNox(String nox) 
    {
        this.nox = nox;
    }

    public String getNox() 
    {
        return nox;
    }
    public void setSo(String so) 
    {
        this.so = so;
    }

    public String getSo() 
    {
        return so;
    }
    public void setPowderLayer(String powderLayer) 
    {
        this.powderLayer = powderLayer;
    }

    public String getPowderLayer() 
    {
        return powderLayer;
    }
    public void setFireWaterRate(String fireWaterRate) 
    {
        this.fireWaterRate = fireWaterRate;
    }

    public String getFireWaterRate() 
    {
        return fireWaterRate;
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
            .append("heartCapacity", getHeartCapacity())
            .append("totalRate", getTotalRate())
            .append("powerRate", getPowerRate())
            .append("industryCapacity", getIndustryCapacity())
            .append("powerCoal", getPowerCoal())
            .append("supplyCoal", getSupplyCoal())
            .append("totalCoal", getTotalCoal())
            .append("rawCoal", getRawCoal())
            .append("powerRawCoal", getPowerRawCoal())
            .append("supplyRawCoal", getSupplyRawCoal())
            .append("oilCapacity", getOilCapacity())
            .append("lowFever", getLowFever())
            .append("equalCoefficient", getEqualCoefficient())
            .append("powerCoefficient", getPowerCoefficient())
            .append("runHour", getRunHour())
            .append("useHour", getUseHour())
            .append("supplyHeartRate", getSupplyHeartRate())
            .append("nox", getNox())
            .append("so", getSo())
            .append("powderLayer", getPowderLayer())
            .append("fireWaterRate", getFireWaterRate())
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
