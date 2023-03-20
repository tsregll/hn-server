package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分公司各风场弃风情况月度对象 business_parcel_company_abandonment_wind
 * 
 * @author yrb
 * @date 2021-03-22
 */
public class BusinessParcelCompanyAbandonmentWind extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 日期（yyyy-mm） */
    @Excel(name = "日期",isRequired = true)
    private String abandonmentDate;

    /** 集团名称（苏宝顶、桂东、连坪、梅桥、北湖风电、回龙圩风电） */
    @Excel(name = "公司名称",isRequired = true, readConverterExp = "0=苏宝顶,1=桂东,2=连坪,3=梅桥,4=北湖,5=回龙圩,6=分公司,7=江口风电")
    private String abandonmentCompany;

    /** 装机容量 */
    @Excel(name = "装机容量", type = Excel.Type.EXPORT)
    private String installationVolume;

    /** 发电量 */
    @Excel(name = "发电量", type = Excel.Type.EXPORT)
    private String electricityVolume;

    /** 弃风电量 */
    @Excel(name = "弃风电量",isRequired = true)
    private String abandonmentVolume;

    /** 弃风率 */
    @Excel(name = "弃风率", type = Excel.Type.EXPORT)
    private String abandonmentRate;

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
    public void setAbandonmentDate(String abandonmentDate) 
    {
        this.abandonmentDate = abandonmentDate;
    }

    public String getAbandonmentDate() 
    {
        return abandonmentDate;
    }
    public void setAbandonmentCompany(String abandonmentCompany) 
    {
        this.abandonmentCompany = abandonmentCompany;
    }

    public String getAbandonmentCompany() 
    {
        return abandonmentCompany;
    }
    public void setInstallationVolume(String installationVolume) 
    {
        this.installationVolume = installationVolume;
    }

    public String getInstallationVolume() 
    {
        return installationVolume;
    }
    public void setElectricityVolume(String electricityVolume) 
    {
        this.electricityVolume = electricityVolume;
    }

    public String getElectricityVolume() 
    {
        return electricityVolume;
    }
    public void setAbandonmentVolume(String abandonmentVolume) 
    {
        this.abandonmentVolume = abandonmentVolume;
    }

    public String getAbandonmentVolume() 
    {
        return abandonmentVolume;
    }
    public void setAbandonmentRate(String abandonmentRate) 
    {
        this.abandonmentRate = abandonmentRate;
    }

    public String getAbandonmentRate() 
    {
        return abandonmentRate;
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
            .append("abandonmentDate", getAbandonmentDate())
            .append("abandonmentCompany", getAbandonmentCompany())
            .append("installationVolume", getInstallationVolume())
            .append("electricityVolume", getElectricityVolume())
            .append("abandonmentVolume", getAbandonmentVolume())
            .append("abandonmentRate", getAbandonmentRate())
            .toString();
    }
}
