package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发展专班详情对象 business_development_class_details
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public class BusinessDevelopmentClassDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 系统默认时间，精确到年月日时分秒 */
    private String defaultTime;

    /** 专业小组 */
    @Excel(name = "专业小组")
    private String specialityGroup;

    /** 组长 */
    @Excel(name = "组长")
    private String groupLeader;

    /** 录入/修改日期 */
    @Excel(name = "录入/修改日期")
    private String operatorTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作人员 */
    @Excel(name = "操作人工号")
    private String operatorNumber;

    /** 背景及意义 */
    private String background;

    /** 进展及实施情况 */
    private String progress;

    /** 存在问题及应对措施 */
    private String questionSolution;

    /** 项目计划及进度安排 */
    private String projectPlanningScheduling;

    /** 背景及意义 */
    private String backgroundAddress;

    /** 进展及实施情况 */
    private String progressAddress;

    /** 项目计划及进度安排 */
    private String projectPlanningSchedulingAddress;

    /** 存在问题及应对措施 */
    private String questionSolutionAddress;

//    public String getBackgroundAddress() {
//        return backgroundAddress;
//    }
//
//    public void setBackgroundAddress(String backgroundAddress) {
//        this.backgroundAddress = backgroundAddress;
//    }
    public String getBackgroundAddress() {
        return backgroundAddress;
    }

    public void setBackgroundAddress(String backgroundAddress) {
        this.backgroundAddress = backgroundAddress;
    }

    public String getProgressAddress() {
        return progressAddress;
    }

    public void setProgressAddress(String progressAddress) {
        this.progressAddress = progressAddress;
    }

    public String getQuestionSolutionAddress() {
        return questionSolutionAddress;
    }

    public void setQuestionSolutionAddress(String questionSolutionAddress) {
        this.questionSolutionAddress = questionSolutionAddress;
    }

    public String getProjectPlanningSchedulingAddress() {
        return projectPlanningSchedulingAddress;
    }

    public void setProjectPlanningSchedulingAddress(String projectPlanningSchedulingAddress) {
        this.projectPlanningSchedulingAddress = projectPlanningSchedulingAddress;
    }

//    /** 项目计划及进度安排 */
//    private String projectPlanningSchedulingAddress;


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
    public void setSpecialityGroup(String specialityGroup) 
    {
        this.specialityGroup = specialityGroup;
    }

    public String getSpecialityGroup() 
    {
        return specialityGroup;
    }
    public void setGroupLeader(String groupLeader) 
    {
        this.groupLeader = groupLeader;
    }

    public String getGroupLeader() 
    {
        return groupLeader;
    }
    public void setBackground(String background) 
    {
        this.background = background;
    }

    public String getBackground() 
    {
        return background;
    }
    public void setProgress(String progress) 
    {
        this.progress = progress;
    }

    public String getProgress() 
    {
        return progress;
    }
    public void setQuestionSolution(String questionSolution) 
    {
        this.questionSolution = questionSolution;
    }

    public String getQuestionSolution() 
    {
        return questionSolution;
    }
    public void setProjectPlanningScheduling(String projectPlanningScheduling) 
    {
        this.projectPlanningScheduling = projectPlanningScheduling;
    }

    public String getProjectPlanningScheduling() 
    {
        return projectPlanningScheduling;
    }
    public void setOperatorTime(String operatorTime) 
    {
        this.operatorTime = operatorTime;
    }

    public String getOperatorTime() 
    {
        return operatorTime;
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
            .append("defaultTime", getDefaultTime())
            .append("operator", getOperator())
            .append("operatorNumber", getOperatorNumber())
            .append("specialityGroup", getSpecialityGroup())
            .append("groupLeader", getGroupLeader())
            .append("background", getBackground())
            .append("progress", getProgress())
            .append("questionSolution", getQuestionSolution())
            .append("projectPlanningScheduling", getProjectPlanningScheduling())
            .append("operatorTime", getOperatorTime())
            .toString();
    }
}
