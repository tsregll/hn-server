package com.ruoyi.business.vo.drmb;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分公司各风场弃风情况月度对象 business_parcel_company_abandonment_wind
 * 
 * @author yrb
 * @date 2021-03-22
 */
public class ParcelCompanyAbandonmentWindVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日期（yyyy-mm） */
    @Excel(name = "日期",isRequired = true)
    private String abandonmentDate;

    /** 集团名称（苏宝顶、桂东、连坪、梅桥、北湖风电、回龙圩风电） */
    @Excel(name = "公司名称",isRequired = true, readConverterExp = "0=苏宝顶,1=桂东,2=连坪,3=梅桥,4=北湖,5=回龙圩,6=分公司,7=江口风电")
    private String abandonmentCompany;

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

    public String getAbandonmentCompany() {
        return abandonmentCompany;
    }

    public void setAbandonmentCompany(String abandonmentCompany) {
        this.abandonmentCompany = abandonmentCompany;
    }

    public String getAbandonmentVolume() {
        return abandonmentVolume;
    }

    public void setAbandonmentVolume(String abandonmentVolume) {
        this.abandonmentVolume = abandonmentVolume;
    }
}
