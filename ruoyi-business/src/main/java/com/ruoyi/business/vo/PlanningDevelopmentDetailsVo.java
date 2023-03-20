package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 规划发展项目详情后台对象 business_planning_development_details
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
public class PlanningDevelopmentDetailsVo
{
    /** 详情名称 */
    private String projectDetailsName;

    /** 详情状态 */
    private String projectDetailsStatus;

    public void setProjectDetailsName(String projectDetailsName)
    {
        this.projectDetailsName = projectDetailsName;
    }

    public String getProjectDetailsName() 
    {
        return projectDetailsName;
    }
    public void setProjectDetailsStatus(String projectDetailsStatus) 
    {
        this.projectDetailsStatus = projectDetailsStatus;
    }

    public String getProjectDetailsStatus()
    {
        return projectDetailsStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectDetailsName", getProjectDetailsName())
            .append("projectDetailsStatus", getProjectDetailsStatus())
            .toString();
    }
}
