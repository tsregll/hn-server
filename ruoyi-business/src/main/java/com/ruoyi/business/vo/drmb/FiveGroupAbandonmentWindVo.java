package com.ruoyi.business.vo.drmb;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 五大发电集团月度弃风情况对象 business_five_group_abandonment_wind
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public class FiveGroupAbandonmentWindVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 日期（yyyy-mm） */
    @Excel(name = "日期",isRequired = true)
    private String abandonmentDate;

    /** 集团名称（国电投、国能投、大唐、华电、五大集团、华能） */
    @Excel(name = "集团名称",isRequired = true, readConverterExp = "0=国电投,1=国能投,2=大唐,3=华电,4=华能,5=五大集团")
    private String abandonmentGroup;

    /** 装机容量 */
    @Excel(name = "装机容量", type = Excel.Type.EXPORT)
    private String installationVolume;

    /** 发电量 */
    @Excel(name = "发电量", type = Excel.Type.EXPORT)
    private String electricityVolume;

    /** 弃风电量 */
    @Excel(name = "弃风电量",isRequired = true)
    private String abandonmentVolume;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAbandonmentDate() {
        return abandonmentDate;
    }

    public void setAbandonmentDate(String abandonmentDate) {
        this.abandonmentDate = abandonmentDate;
    }

    public String getAbandonmentGroup() {
        return abandonmentGroup;
    }

    public void setAbandonmentGroup(String abandonmentGroup) {
        this.abandonmentGroup = abandonmentGroup;
    }

    public String getInstallationVolume() {
        return installationVolume;
    }

    public void setInstallationVolume(String installationVolume) {
        this.installationVolume = installationVolume;
    }

    public String getElectricityVolume() {
        return electricityVolume;
    }

    public void setElectricityVolume(String electricityVolume) {
        this.electricityVolume = electricityVolume;
    }

    public String getAbandonmentVolume() {
        return abandonmentVolume;
    }

    public void setAbandonmentVolume(String abandonmentVolume) {
        this.abandonmentVolume = abandonmentVolume;
    }
}
