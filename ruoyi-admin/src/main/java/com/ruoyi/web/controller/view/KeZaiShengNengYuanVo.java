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
public class KeZaiShengNengYuanVo {
    @Excel(name = "项目")
    private String labelName;
    @Excel(name = "当月结算电量（万千瓦时）")
    private String key0;
    @Excel(name = "上网电价（元/兆瓦时）")
    private String key1;
    @Excel(name = "电网结算价（元/兆瓦时）")
    private String key2;
    @Excel(name = "国家补贴价（万元）")
    private String key3;
    @Excel(name = "当月应收补贴（万元）")
    private String key4;
    @Excel(name = "当年应收补贴（万元）")
    private String key5;
    @Excel(name = "自项目投产累计回收补贴（万元）")
    private String key6;
    @Excel(name = "应收财政补贴余额（万元）1-2年以内（含2年）（万元）")
    private String key7;
    @Excel(name = "应收财政补贴余额（万元）2-3年以内（含3年）（万元）")
    private String key8;
    @Excel(name = "应收财政补贴余额（万元）3年以上（万元）")
    private String key9;

    public void setLabelName(String labelName) {
        this.labelName = labelName;
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

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public void setKey5(String key5) {
        this.key5 = key5;
    }

    public void setKey6(String key6) {
        this.key6 = key6;
    }

    public void setKey7(String key7) {
        this.key7 = key7;
    }

    public void setKey8(String key8) {
        this.key8 = key8;
    }

    public void setKey9(String key9) {
        this.key9 = key9;
    }

    public String getLabelName() {
        return labelName;
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

    public String getKey4() {
        return key4;
    }

    public String getKey5() {
        return key5;
    }

    public String getKey6() {
        return key6;
    }

    public String getKey7() {
        return key7;
    }

    public String getKey8() {
        return key8;
    }

    public String getKey9() {
        return key9;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("labelName", getLabelName())
                .append("key0", getKey0())
                .append("key1", getKey1())
                .append("key2", getKey2())
                .append("key3", getKey3())
                .append("key3", getKey4())
                .append("key3", getKey5())
                .append("key3", getKey6())
                .append("key3", getKey7())
                .append("key3", getKey8())
                .append("key3", getKey9())
                .toString();
    }
}
