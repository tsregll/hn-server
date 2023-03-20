package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电量及电价市场交易对象 business_electric_trade
 * 
 * @author ruoyi
 * @date 2021-04-27
 */
public class BusinessElectricTrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 交易年月 */
    @JsonFormat(pattern = "yyyy-MM")
    @Excel(name = "交易年月", width = 30, dateFormat = "yyyy-MM")
    private Date electricTradeTime;

    /** 市场交易单位 */
    @Excel(name = "市场交易单位",isRequired = true, readConverterExp = "0=华能,1=大唐,2=华电,3=国能投,4=国电投,5=长安,6=华润,7=统调火电,8=其他电源,9=全省电源,10=湘祁水电,11=苏宝顶风电,12=桂东风电,13=连坪风电,14=梅桥风电,15=北湖风电,16=回龙圩风电,17=清能公司")
    private String electricTradeUnit;

    /** 装机容量 */
    private String installationVolume;
    /** 电量 */
    @Excel(name = "电量")
    private String electricTradeConsumption;

    /** 电价 */
    @Excel(name = "电价")
    private String electricTradeMonovalent;

    /** $column.columnComment */
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
    public void setElectricTradeTime(Date electricTradeTime) 
    {
        this.electricTradeTime = electricTradeTime;
    }

    public Date getElectricTradeTime() 
    {
        return electricTradeTime;
    }
    public void setElectricTradeUnit(String electricTradeUnit) 
    {
        this.electricTradeUnit = electricTradeUnit;
    }

    public String getElectricTradeUnit() 
    {
        return electricTradeUnit;
    }
    public void setElectricTradeConsumption(String electricTradeConsumption) 
    {
        this.electricTradeConsumption = electricTradeConsumption;
    }
//    public void setInstallationVolume(String installationVolume)//中台读取
//    {
//        this.installationVolume = installationVolume;
//    }
    public String getInstallationVolume()
    {
        return installationVolume;
    }
    public String getElectricTradeConsumption() 
    {
        return electricTradeConsumption;
    }
    public void setElectricTradeMonovalent(String electricTradeMonovalent) 
    {
        this.electricTradeMonovalent = electricTradeMonovalent;
    }

    public String getElectricTradeMonovalent() 
    {
        return electricTradeMonovalent;
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
            .append("electricTradeTime", getElectricTradeTime())
            .append("electricTradeUnit", getElectricTradeUnit())
            .append("electricTradeConsumption", getElectricTradeConsumption())
            .append("electricTradeMonovalent", getElectricTradeMonovalent())
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
