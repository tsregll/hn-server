package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 五大发电集团月度弃风情况对象 business_five_group_abandonment_wind
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public class BusinessFiveGroupAbandonmentWind extends BaseEntity
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

    /** 集团名称（国电投、国能投、大唐、华电、五大集团、华能） */
    @Excel(name = "集团名称",isRequired = true, readConverterExp = "0=国电投,1=国能投,2=大唐,3=华电,4=华能,5=五大集团")
    private String abandonmentGroup;

    /** 装机容量 */
    @Excel(name = "装机容量",isRequired = true)
    private String installationVolume;

    /** 发电量 */
    @Excel(name = "发电量",isRequired = true)
    private String electricityVolume;

    /** 弃风电量 */
    @Excel(name = "弃风电量",isRequired = true)
    private String abandonmentVolume;

    /** 弃风率 */
    @Excel(name = "弃风率",type = Excel.Type.EXPORT)
    private String abandonmentRate;

    public void setId(Long id) 
    {
        this.id = id;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }
    public void setAbandonmentDate(String abandonmentDate)
    {
        this.abandonmentDate = abandonmentDate;
    }
    public void setAbandonmentGroup(String abandonmentGroup)
    {
        this.abandonmentGroup = abandonmentGroup;
    }
    public void setInstallationVolume(String installationVolume)
    {
        this.installationVolume = installationVolume;
    }
    public void setElectricityVolume(String electricityVolume)
    {
        this.electricityVolume = electricityVolume;
    }
    public void setAbandonmentVolume(String abandonmentVolume)
    {
        this.abandonmentVolume = abandonmentVolume;
    }
    public void setAbandonmentRate(String abandonmentRate)
    {
        this.abandonmentRate = abandonmentRate;
    }
    public Long   getId()
    {
        return id;
    }
    public String getStatus()
    {
        return status;
    }
    public String getDelFlag()
    {
        return delFlag;
    }
    public String getAbandonmentDate()
    {
        return abandonmentDate;
    }
    public String getAbandonmentGroup()
    {
        return abandonmentGroup;
    }
    public String getInstallationVolume()
    {
        return installationVolume;
    }
    public String getElectricityVolume()
    {
        return electricityVolume;
    }
    public String getAbandonmentVolume()
    {
        return abandonmentVolume;
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
            .append("abandonmentGroup", getAbandonmentGroup())
            .append("installationVolume", getInstallationVolume())
            .append("electricityVolume", getElectricityVolume())
            .append("abandonmentVolume", getAbandonmentVolume())
            .append("abandonmentRate", getAbandonmentRate())
            .toString();
    }
}
