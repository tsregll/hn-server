package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class ElectricTradeVo {
    @ApiModelProperty(value = "市场交易单位",name = "Units",dataType = "String")
    private String[] units;
    @ApiModelProperty(value = "市场交易电量",name = "electricConsumption",dataType = "String")
    private String electricConsumption;
    @ApiModelProperty(value = "电量数据组",name = "consumptionData",dataType = "String")
    private String[] consumptionData;
    @ApiModelProperty(value = "市场交易电价",name = "electricMonovalent",dataType = "String")
    private String electricMonovalent;
    @ApiModelProperty(value = "电价数据组",name = "monovalentData",dataType = "String")
    private String[] monovalentData;
    @ApiModelProperty(value = "市场交易月度选择",name = "month",dataType = "Date")
    private Date month;
    public void setUnits(String[] units) {
        this.units = units;
    }
    public void setElectricConsumption(String electricConsumption) {
        this.electricConsumption = electricConsumption;
    }
    public void setConsumptionData(String[] consumptionData) {
        this.consumptionData = consumptionData;
    }
    public void setElectricMonovalent(String electricMonovalent) {
        this.electricMonovalent = electricMonovalent;
    }
    public void setMonovalentData(String[] monovalentData) {
        this.monovalentData = monovalentData;
    }
    public void setMonth(Date month) {
        this.month = month;
    }

    public String[] getUnits() {
        return units;
    }
    public String getElectricConsumption() {
        return electricConsumption;
    }
    public String[] getConsumptionData() {
        return consumptionData;
    }
    public String getElectricMonovalent() {
        return electricMonovalent;
    }
    public String[] getMonovalentData() {
        return monovalentData;
    }
    public Date getMonth() {
        return month;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("units", getUnits())
                .append("electricConsumption", getElectricConsumption())
                .append("consumptionData", getConsumptionData())
                .append("electricMonovalent", getElectricMonovalent())
                .append("monovalentData", getMonovalentData())
                .append("month", getMonth())
                .toString();
    }
}
