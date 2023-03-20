package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用电数据对象 business_electric_data
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public class BusinessElectricData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 年份
     */
    @Excel(name = "年份")
    private Long year;

    /**
     * 月份
     */
    @Excel(name = "月份")
    private Long month;

    /**
     * 用电总量
     */
    @Excel(name = "用电总量")
    private Long total;

    /**
     * 负载
     */
    @Excel(name = "负载")
    private Long loads;

    /**
     * 电费
     */
    @Excel(name = "电费")
    private Long fees;

    /**
     * 状态（0未提交 1一级审核 2二级审核 3三级审核 6已生效/审核通过 9审核退回）
     */
    @Excel(name = "状态", readConverterExp = "0=未提交,1=一级审核,2=二级审核,3=三级审核,6=已生效/审核通过,9=审核退回")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public BusinessElectricData() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getYear() {
        return year;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getMonth() {
        return month;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setLoads(Long loads) {
        this.loads = loads;
    }

    public Long getLoads() {
        return loads;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }

    public Long getFees() {
        return fees;
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
                .append("year", getYear())
                .append("month", getMonth())
                .append("total", getTotal())
                .append("load", getLoads())
                .append("fees", getFees())
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
