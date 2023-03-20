package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 三公经费对象 business_administrative_three_fairs
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public class BusinessAdministrativeThreeFairs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 三公经费金额（万元） */
    @Excel(name = "三公经费金额", readConverterExp = "万=元")
    private String threeFundsMoney;

    /** 三公经费内容 */
    @Excel(name = "三公经费内容")
    private String threeFundsContent;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

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
    public void setThreeFundsMoney(String threeFundsMoney) 
    {
        this.threeFundsMoney = threeFundsMoney;
    }

    public String getThreeFundsMoney() 
    {
        return threeFundsMoney;
    }
    public void setThreeFundsContent(String threeFundsContent) 
    {
        this.threeFundsContent = threeFundsContent;
    }

    public String getThreeFundsContent() 
    {
        return threeFundsContent;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
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
            .append("threeFundsMoney", getThreeFundsMoney())
            .append("threeFundsContent", getThreeFundsContent())
            .append("time", getTime())
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
