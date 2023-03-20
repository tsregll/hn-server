package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 决策事项对象 business_administrative_decision
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public class BusinessAdministrativeDecision extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 决策事项状态 */
    @Excel(name = "决策事项状态")
    private Integer decisionStatus;

    /** 决策事项内容 */
    @Excel(name = "决策事项内容")
    private String decisionContent;

    /** $column.columnComment */
    @Excel(name = "决策事项内容")
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
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setDecisionStatus(Integer decisionStatus) 
    {
        this.decisionStatus = decisionStatus;
    }

    public Integer getDecisionStatus() 
    {
        return decisionStatus;
    }
    public void setDecisionContent(String decisionContent) 
    {
        this.decisionContent = decisionContent;
    }

    public String getDecisionContent() 
    {
        return decisionContent;
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
            .append("time", getTime())
            .append("decisionStatus", getDecisionStatus())
            .append("decisionContent", getDecisionContent())
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
