package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装机统计对象 business_installation_statistics
 * 
 * @author yrb
 * @date 2021-03-10
 */
@ApiModel("装机统计对象,除了id没有注释的字段不用管")
public class BusinessInstallationStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "id",name = "id",dataType = "Long")
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 日期（yyyy-mm） */
    @Excel(name = "年月",isRequired = true)
    @JsonFormat(pattern = "yyyy-MM")
    @ApiModelProperty(value = "年月（yyyy-mm）",name = "enteringDate",dataType = "String")
    private String enteringDate;

    /** 装机类型（湖南电网，统调，非统调） */
    @Excel(name = "类型",isRequired = true,readConverterExp = "0=湖南电网,1=统调,2=非统调")
    @ApiModelProperty(value = "装机类型",name = "installationType",dataType = "String")
    private String installationType;

    /** 合计 */
    @Excel(name = "合计", type = Excel.Type.EXPORT)
    @ApiModelProperty(value = "合计",name = "installationAll",dataType = "String")
    private String installationAll;

    /** 水电 */
    @Excel(name = "水电",isRequired = true)
    @ApiModelProperty(value = "水电",name = "installationWater",dataType = "String")
    private String installationWater;

    /** 火电 */
    @Excel(name = "火电",isRequired = true)
    @ApiModelProperty(value = "火电",name = "installationFire",dataType = "String")
    private String installationFire;

    /** 风电 */
    @Excel(name = "风电",isRequired = true)
    @ApiModelProperty(value = "风电",name = "installationWind",dataType = "String")
    private String installationWind;

    /** 光伏 */
    @Excel(name = "光伏",isRequired = true)
    @ApiModelProperty(value = "太阳能",name = "installationLight",dataType = "String")
    private String installationLight;

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
    public void setInstallationType(String installationType) 
    {
        this.installationType = installationType;
    }

    public String getInstallationType() 
    {
        return installationType;
    }
    public void setInstallationAll(String installationAll) 
    {
        this.installationAll = installationAll;
    }

    public String getInstallationAll() 
    {
        return installationAll;
    }
    public void setInstallationWater(String installationWater) 
    {
        this.installationWater = installationWater;
    }

    public String getInstallationWater() 
    {
        return installationWater;
    }
    public void setInstallationFire(String installationFire) 
    {
        this.installationFire = installationFire;
    }

    public String getInstallationFire() 
    {
        return installationFire;
    }
    public void setInstallationWind(String installationWind) 
    {
        this.installationWind = installationWind;
    }

    public String getInstallationWind() 
    {
        return installationWind;
    }
    public void setInstallationLight(String installationLight) 
    {
        this.installationLight = installationLight;
    }

    public String getInstallationLight() 
    {
        return installationLight;
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
            .append("installationType", getInstallationType())
            .append("installationAll", getInstallationAll())
            .append("installationWater", getInstallationWater())
            .append("installationFire", getInstallationFire())
            .append("installationWind", getInstallationWind())
            .append("installationLight", getInstallationLight())
            .toString();
    }
}
