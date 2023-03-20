package com.ruoyi.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门审批流程对象 business_audit_form
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public class BusinessAuditForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 部门领导id
     */
    @Excel(name = "部门领导id")
    private Long deptUserId;

    /**
     * 部门领导名称
     */
    @Excel(name = "部门领导名称")
    private String deptUserName;

    /**
     * 部门领导审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "部门领导审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deptAuditTime;

    /**
     * 分管领导id
     */
    @Excel(name = "分管领导id")
    private Long chargeUserId;

    /**
     * 分管领导名称
     */
    @Excel(name = "分管领导名称")
    private String chargeUserName;

    /**
     * 分管领导审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分管领导审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chargeAuditTime;

    /**
     * 主要领导id
     */
    @Excel(name = "主要领导id")
    private Long keyUserId;

    /**
     * 主要领导姓名
     */
    @Excel(name = "主要领导姓名")
    private String keyUserName;

    /**
     * 主要领导审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "主要领导审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date keyAuditTime;

    /**
     * 退回意见
     */
    @Excel(name = "退回意见")
    private String msg;

    /**
     * 数据提交人
     */
    @Excel(name = "数据提交人")
    private Long submitUserId;

    /**
     * 数据提交人姓名
     */
    @Excel(name = "数据提交人姓名")
    private String submitUserName;

    /**
     * 关联业务id
     */
    @Excel(name = "关联业务id")
    private Long dataId;

    /**
     * 数据分类
     */
    @Excel(name = "数据分类")
    private String dataType;

    /**
     * 状态（0未提交 1一级审核 2二级审核 3三级审核 6已生效/审核通过 9审核退回）
     */
    @Excel(name = "状态", readConverterExp = "0=未提交,1=一级审核,2=二级审核,3=三级审核,6=已生效/审核通过,9=审核退回")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDeptUserId(Long deptUserId) {
        this.deptUserId = deptUserId;
    }

    public Long getDeptUserId() {
        return deptUserId;
    }

    public void setDeptUserName(String deptUserName) {
        this.deptUserName = deptUserName;
    }

    public String getDeptUserName() {
        return deptUserName;
    }

    public void setDeptAuditTime(Date deptAuditTime) {
        this.deptAuditTime = deptAuditTime;
    }

    public Date getDeptAuditTime() {
        return deptAuditTime;
    }

    public void setChargeUserId(Long chargeUserId) {
        this.chargeUserId = chargeUserId;
    }

    public Long getChargeUserId() {
        return chargeUserId;
    }

    public void setChargeUserName(String chargeUserName) {
        this.chargeUserName = chargeUserName;
    }

    public String getChargeUserName() {
        return chargeUserName;
    }

    public void setChargeAuditTime(Date chargeAuditTime) {
        this.chargeAuditTime = chargeAuditTime;
    }

    public Date getChargeAuditTime() {
        return chargeAuditTime;
    }

    public void setKeyUserId(Long keyUserId) {
        this.keyUserId = keyUserId;
    }

    public Long getKeyUserId() {
        return keyUserId;
    }

    public void setKeyUserName(String keyUserName) {
        this.keyUserName = keyUserName;
    }

    public String getKeyUserName() {
        return keyUserName;
    }

    public void setKeyAuditTime(Date keyAuditTime) {
        this.keyAuditTime = keyAuditTime;
    }

    public Date getKeyAuditTime() {
        return keyAuditTime;
    }

    public void setMsg(String returnMsg) {
        this.msg = returnMsg;
    }

    public String getMsg() {
        return msg;
    }

    public void setSubmitUserId(Long submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Long getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    public String getSubmitUserName() {
        return submitUserName;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("deptUserId", getDeptUserId())
                .append("deptUserName", getDeptUserName())
                .append("deptAuditTime", getDeptAuditTime())
                .append("chargeUserId", getChargeUserId())
                .append("chargeUserName", getChargeUserName())
                .append("chargeAuditTime", getChargeAuditTime())
                .append("keyUserId", getKeyUserId())
                .append("keyUserName", getKeyUserName())
                .append("keyAuditTime", getKeyAuditTime())
                .append("msg", getMsg())
                .append("submitUserId", getSubmitUserId())
                .append("submitUserName", getSubmitUserName())
                .append("dataId", getDataId())
                .append("dataType", getDataType())
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
