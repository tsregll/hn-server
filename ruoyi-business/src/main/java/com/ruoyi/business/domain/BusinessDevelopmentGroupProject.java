package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展基建专业组项目对象 business_development_group_project
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
public class BusinessDevelopmentGroupProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 日期 */
    @Excel(name = "日期")
    private String defaultTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作工号 */
    @Excel(name = "操作工号")
    private String operatorNumber;

    /** 基建专业小组 */
    @Excel(name = "基建专业小组")
    private String groupName;

    /** 组长 */
    @Excel(name = "组长")
    private String groupLeaders;

    /** 成员 */
    @Excel(name = "成员")
    private String groupMembers;

    /** 动态信息 */
    @Excel(name = "动态信息")
    private String groupInformation;

    /** 职责 */
    @Excel(name = "职责")
    private String groupDuty;

    /** 标准 */
    @Excel(name = "标准")
    private String groupStandard;

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
    public void setDefaultTime(String defaultTime) 
    {
        this.defaultTime = defaultTime;
    }

    public String getDefaultTime() 
    {
        return defaultTime;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setOperatorNumber(String operatorNumber) 
    {
        this.operatorNumber = operatorNumber;
    }

    public String getOperatorNumber() 
    {
        return operatorNumber;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }
    public void setGroupLeaders(String groupLeaders) 
    {
        this.groupLeaders = groupLeaders;
    }

    public String getGroupLeaders() 
    {
        return groupLeaders;
    }
    public void setGroupMembers(String groupMembers) 
    {
        this.groupMembers = groupMembers;
    }

    public String getGroupMembers() 
    {
        return groupMembers;
    }
    public void setGroupInformation(String groupInformation) 
    {
        this.groupInformation = groupInformation;
    }

    public String getGroupInformation() 
    {
        return groupInformation;
    }
    public void setGroupDuty(String groupDuty) 
    {
        this.groupDuty = groupDuty;
    }

    public String getGroupDuty() 
    {
        return groupDuty;
    }
    public void setGroupStandard(String groupStandard) 
    {
        this.groupStandard = groupStandard;
    }

    public String getGroupStandard() 
    {
        return groupStandard;
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
            .append("defaultTime", getDefaultTime())
            .append("operator", getOperator())
            .append("operatorNumber", getOperatorNumber())
            .append("groupName", getGroupName())
            .append("groupLeaders", getGroupLeaders())
            .append("groupMembers", getGroupMembers())
            .append("groupInformation", getGroupInformation())
            .append("groupDuty", getGroupDuty())
            .append("groupStandard", getGroupStandard())
            .append("remark", getRemark())
            .toString();
    }
}
