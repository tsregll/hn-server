package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 部门审批流程对象 business_audit_form
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public class NengHaoGuanLiGuangFuVo {
    @Excel(name = "指标名称")
    private String labelName;
    @Excel(name = "单位")
    private String unit;
    @Excel(name = "新港")
    private String key0;
    @Excel(name = "擂鼓台")
    private String key1;
    @Excel(name = "三灰湖")
    private String key2;
    @Excel(name = "全站合计")
    private String key3;

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public void setKey0(String key0) {
        this.key0 = key0;
    }
    public void setKey1(String key1) {
        this.key1 = key1;
    }
    public void setKey2(String key2) {
        this.key2 = key2;
    }
    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getLabelName() {
        return labelName;
    }
    public String getUnit() {
        return unit;
    }
    public String getKey0() {
        return key0;
    }
    public String getKey1() {
        return key1;
    }
    public String getKey2() {
        return key2;
    }
    public String getKey3() {
        return key3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("labelName", getLabelName())
                .append("unit", getUnit())
                .append("key0", getKey0())
                .append("key1", getKey1())
                .append("key2", getKey2())
                .append("key3", getKey3())
                .toString();
    }
}
