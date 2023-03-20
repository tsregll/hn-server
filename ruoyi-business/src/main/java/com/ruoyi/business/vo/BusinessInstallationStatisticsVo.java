package com.ruoyi.business.vo;

import com.ruoyi.business.domain.BusinessInstallationStatistics;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 装机统计对象 business_installation_statistics
 * 
 * @author yrb
 * @date 2021-03-10
 */
@ApiModel("装机统计表Vo（月度表格）")
public class BusinessInstallationStatisticsVo
{
    public BusinessInstallationStatisticsVo(){
        this.dataType = "-";
        this.installationTypeHndw = "-";
        this.lastInstallationTypeHndw = "-";
        this.installationTypeTd = "-";
        this.lastInstallationTypeTd = "-";
        this.installationTypeFtd = "-";
        this.lastInstallationTypeFtd = "-";
        this.instType = "万千瓦时";
    }
    /** 装机类型（湖南电网，统调，非统调） */
    @Excel(name = "装机类型")
    @ApiModelProperty(value = "装机类型",name = "dataType",dataType = "String")
    private String dataType;
    @Excel(name = "装机统计（湖南统调）")
    @ApiModelProperty(value = "装机统计（湖南统调）",name = "installationTypeHndw",dataType = "String")
    private String installationTypeHndw;
    @Excel(name = "同期装机统计（湖南统调）")
    @ApiModelProperty(value = "同期装机统计（湖南统调）",name = "lastInstallationTypeHndw",dataType = "String")
    private String lastInstallationTypeHndw;
    @Excel(name = "装机统计（统调）")
    @ApiModelProperty(value = "装机统计（统调）",name = "installationTypeTd",dataType = "String")
    private String installationTypeTd;
    @Excel(name = "同期装机统计（统调）")
    @ApiModelProperty(value = "同期装机统计（统调）",name = "lastInstallationTypeTd",dataType = "String")
    private String lastInstallationTypeTd;
    @Excel(name = "装机统计（非统调）")
    @ApiModelProperty(value = "装机统计（非统调）",name = "installationTypeFtd",dataType = "String")
    private String installationTypeFtd;
    @Excel(name = "同期装机统计（非统调）")
    @ApiModelProperty(value = "同期装机统计（非统调）",name = "lastInstallationTypeFtd",dataType = "String")
    private String lastInstallationTypeFtd;
    private String instType;

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getInstType() {
        return instType;
    }

    //set
    public void setInstallationTypeHndw(String installationTypeHndw) {
        this.installationTypeHndw = installationTypeHndw;
    }
    public void setInstallationTypeTd(String installationTypeTd) {
        this.installationTypeTd = installationTypeTd;
    }
    public void setInstallationTypeFtd(String installationTypeFtd) {
        this.installationTypeFtd = installationTypeFtd;
    }
    public void setLastInstallationTypeHndw(String lastInstallationTypeHndw) {
        this.lastInstallationTypeHndw = lastInstallationTypeHndw;
    }
    public void setLastInstallationTypeTd(String lastInstallationTypeTd) {
        this.lastInstallationTypeTd = lastInstallationTypeTd;
    }
    public void setLastInstallationTypeFtd(String lastInstallationTypeFtd) {
        this.lastInstallationTypeFtd = lastInstallationTypeFtd;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    //get
    public String getInstallationTypeHndw() {
        return installationTypeHndw;
    }
    public String getInstallationTypeFtd() {
        return installationTypeFtd;
    }
    public String getInstallationTypeTd() {
        return installationTypeTd;
    }
    public String getLastInstallationTypeHndw() {
        return lastInstallationTypeHndw;
    }
    public String getLastInstallationTypeTd() {
        return lastInstallationTypeTd;
    }
    public String getLastInstallationTypeFtd() {
        return lastInstallationTypeFtd;
    }
    public String getDataType() {
        return dataType;
    }

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("installationTypeHndw", getInstallationTypeHndw())
            .append("installationTypeTd", getInstallationTypeFtd())
            .append("installationTypeFtd", getInstallationTypeTd())
            .append("lastInstallationTypeHndw", getLastInstallationTypeHndw())
            .append("lastInstallationTypeTd", getLastInstallationTypeTd())
            .append("lastInstallationTypeFtd", getLastInstallationTypeFtd())
            .toString();
    }
}
