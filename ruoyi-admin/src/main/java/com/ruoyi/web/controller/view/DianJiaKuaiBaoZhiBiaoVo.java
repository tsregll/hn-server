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
public class DianJiaKuaiBaoZhiBiaoVo {
    @Excel(name = "项目")
    private String labelName;
    @Excel(name = "本月上网电量（万千瓦时）")
    private String key0;
    @Excel(name = "本年累计上网电量（万千瓦时）")
    private String key1;
    @Excel(name = "本月基本电量")
    private String key2;
    @Excel(name = "本年累计基本电量")
    private String key3;
    @Excel(name = "本月交易电量")
    private String key4;
    @Excel(name = "本年累计交易电量")
    private String key5;
    @Excel(name = "本月其他电量（万千瓦时）")
    private String key6;
    @Excel(name = "本年累计其他电量（万千瓦时）")
    private String key7;
    @Excel(name = "本月基本电价（元/兆瓦时）")
    private String key8;
    @Excel(name = "本年累计基本电价（元/兆瓦时）")
    private String key9;
    @Excel(name = "本月交易电价（元/兆瓦时）")
    private String key10;
    @Excel(name = "本年累计交易电价（元/兆瓦时）")
    private String key11;
    @Excel(name = "本月其他电价（元/兆瓦时）")
    private String key12;
    @Excel(name = "本年累计其他电价（元/兆瓦时）")
    private String key13;
    @Excel(name = "本月辅助服务费用（万元）")
    private String key14;
    @Excel(name = "本年累计辅助服务费用（万元）")
    private String key15;
    @Excel(name = "本月两个细则考核（万元）")
    private String key16;
    @Excel(name = "本年累计两个细则考核（万元）")
    private String key17;
    @Excel(name = "本月综合电价（万元）")
    private String key18;
    @Excel(name = "本月同比综合电价（万元）")
    private String key19;
    @Excel(name = "本年累计综合电价（万元）")
    private String key20;
    @Excel(name = "本年累计同比综合电价（万元）")
    private String key21;

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

    public void setKey10(String key10) {
        this.key10 = key10;
    }

    public void setKey11(String key11) {
        this.key11 = key11;
    }

    public void setKey12(String key12) {
        this.key12 = key12;
    }

    public void setKey13(String key13) {
        this.key13 = key13;
    }

    public void setKey14(String key14) {
        this.key14 = key14;
    }

    public void setKey15(String key15) {
        this.key15 = key15;
    }

    public void setKey16(String key16) {
        this.key16 = key16;
    }

    public void setKey17(String key17) {
        this.key17 = key17;
    }

    public void setKey18(String key18) {
        this.key18 = key18;
    }

    public void setKey19(String key19) {
        this.key19 = key19;
    }

    public void setKey20(String key20) {
        this.key20 = key20;
    }

    public void setKey21(String key21) {
        this.key21 = key21;
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

    public String getKey10() {
        return key10;
    }

    public String getKey11() {
        return key11;
    }

    public String getKey12() {
        return key12;
    }

    public String getKey13() {
        return key13;
    }

    public String getKey14() {
        return key14;
    }

    public String getKey15() {
        return key15;
    }

    public String getKey16() {
        return key16;
    }

    public String getKey17() {
        return key17;
    }

    public String getKey18() {
        return key18;
    }

    public String getKey19() {
        return key19;
    }

    public String getKey20() {
        return key20;
    }

    public String getKey21() {
        return key21;
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
                .append("key3", getKey10())
                .append("key3", getKey11())
                .append("key3", getKey12())
                .append("key3", getKey13())
                .append("key3", getKey14())
                .append("key3", getKey15())
                .append("key3", getKey16())
                .append("key3", getKey17())
                .append("key3", getKey18())
                .append("key3", getKey19())
                .append("key3", getKey20())
                .append("key3", getKey21())
                .toString();
    }
}
