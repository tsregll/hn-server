package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 纪检管理对象 business_disciplinary_manage
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public class BusinessDisciplinaryManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 年月日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "年月日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 分公司单位 */
    @Excel(name = "分公司单位")
    private String branchUnit;

    /** 谈话种类 */
    @Excel(name = "谈话种类")
    private String conversationType;

    /** 谈话形式 */
    @Excel(name = "谈话形式")
    private String conversationForms;

    /** 员工职位 */
    @Excel(name = "员工职位")
    private String position;

    /** 谈话Id */
    @Excel(name = "谈话Id")
    private String conversationId;

    /** 职工工号 */
    @Excel(name = "职工工号")
    private String workerNumber;

    /** 职工姓名 */
    @Excel(name = "职工姓名")
    private String workerName;

    /** 职工性别 */
    @Excel(name = "职工性别")
    private String workerGender;

    /** 谈话主题 */
    @Excel(name = "谈话主题")
    private String conversationTopics;

    /** 谈话内容 */
    @Excel(name = "谈话内容")
    private String conversation;

    /** 问题类型 */
    @Excel(name = "问题类型")
    private Integer problemType;

    /** 整改问题类型 */
    @Excel(name = "整改问题类型")
    private Long rectificationProblemType;

    /** 是否整改 */
    @Excel(name = "是否整改")
    private Long isRectification;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 状态（0未审核 1一级审核 2二级审核 3三级审核 6已生效/审核通过 9审核退回） */
    private String status;

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
    public void setBranchUnit(String branchUnit) 
    {
        this.branchUnit = branchUnit;
    }

    public String getBranchUnit() 
    {
        return branchUnit;
    }
    public void setConversationType(String conversationType) 
    {
        this.conversationType = conversationType;
    }

    public String getConversationType() 
    {
        return conversationType;
    }
    public void setConversationForms(String conversationForms) 
    {
        this.conversationForms = conversationForms;
    }

    public String getConversationForms() 
    {
        return conversationForms;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setConversationId(String conversationId) 
    {
        this.conversationId = conversationId;
    }

    public String getConversationId() 
    {
        return conversationId;
    }
    public void setWorkerNumber(String workerNumber) 
    {
        this.workerNumber = workerNumber;
    }

    public String getWorkerNumber() 
    {
        return workerNumber;
    }
    public void setWorkerName(String workerName) 
    {
        this.workerName = workerName;
    }

    public String getWorkerName() 
    {
        return workerName;
    }
    public void setWorkerGender(String workerGender) 
    {
        this.workerGender = workerGender;
    }

    public String getWorkerGender() 
    {
        return workerGender;
    }
    public void setConversationTopics(String conversationTopics) 
    {
        this.conversationTopics = conversationTopics;
    }

    public String getConversationTopics() 
    {
        return conversationTopics;
    }
    public void setConversation(String conversation) 
    {
        this.conversation = conversation;
    }

    public String getConversation() 
    {
        return conversation;
    }
    public void setProblemType(Integer problemType) 
    {
        this.problemType = problemType;
    }

    public Integer getProblemType() 
    {
        return problemType;
    }
    public void setRectificationProblemType(Long rectificationProblemType) 
    {
        this.rectificationProblemType = rectificationProblemType;
    }

    public Long getRectificationProblemType() 
    {
        return rectificationProblemType;
    }
    public void setIsRectification(Long isRectification) 
    {
        this.isRectification = isRectification;
    }

    public Long getIsRectification() 
    {
        return isRectification;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("time", getTime())
            .append("branchUnit", getBranchUnit())
            .append("conversationType", getConversationType())
            .append("conversationForms", getConversationForms())
            .append("position", getPosition())
            .append("conversationId", getConversationId())
            .append("workerNumber", getWorkerNumber())
            .append("workerName", getWorkerName())
            .append("workerGender", getWorkerGender())
            .append("conversationTopics", getConversationTopics())
            .append("conversation", getConversation())
            .append("problemType", getProblemType())
            .append("rectificationProblemType", getRectificationProblemType())
            .append("isRectification", getIsRectification())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
