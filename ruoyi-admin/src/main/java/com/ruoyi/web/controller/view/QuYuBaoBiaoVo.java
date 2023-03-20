package com.ruoyi.web.controller.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 部门审批流程对象 business_audit_form
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public class QuYuBaoBiaoVo{
    @Excel(name = "指标名称")
    private String labelName;
    @Excel(name = "单位")
    private String unit;
    @Excel(name = "区域合计")
    private String key0;
    @Excel(name = "岳阳电厂")
    private String key1;
    @Excel(name = "清能合计")
    private String key2;
    @Excel(name = "新能源合计")
    private String key3;
    @Excel(name = "岳阳煤机")
    private String key4;
    @Excel(name = "新港光伏")
    private String key5;
    @Excel(name = "擂鼓台光伏")
    private String key6;
    @Excel(name = "三灰湖光伏")
    private String key7;
    @Excel(name = "湘祁水电")
    private String key8;
    @Excel(name = "苏宝顶风电")
    private String key9;
    @Excel(name = "桂东风电")
    private String key10;
    @Excel(name = "连坪风电")
    private String key11;
    @Excel(name = "梅桥风电")
    private String key12;
    @Excel(name = "北湖风电")
    private String key13;
    @Excel(name = "回龙圩风电")
    private String key14;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("labelName", getLabelName())
                .append("unit", getUnit())
                .append("key0", getKey0())
                .append("key1", getKey1())
                .append("key2", getKey2())
                .append("key3", getKey3())
                .append("key4", getKey4())
                .append("key5", getKey5())
                .append("key6", getKey6())
                .append("key7", getKey7())
                .append("key8", getKey8())
                .append("key9", getKey9())
                .append("key10", getKey10())
                .append("key11", getKey11())
                .append("key12", getKey12())
                .append("key13", getKey13())
                .append("key14", getKey14())
                .toString();
    }
}
