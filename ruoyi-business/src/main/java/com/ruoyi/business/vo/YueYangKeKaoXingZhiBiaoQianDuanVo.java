package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;

public class YueYangKeKaoXingZhiBiaoQianDuanVo {
    @Excel(name = "指标项")
    private String labelname;
    @Excel(name = "单位")
    private String unit;
    @Excel(name = "1#机组")
    private String key0;
    @Excel(name = "2#机组")
    private String key1;
    @Excel(name = "3#机组")
    private String key2;
    @Excel(name = "4#机组")
    private String key3;
    @Excel(name = "5#机组")
    private String key4;
    @Excel(name = "6#机组")
    private String key5;
    @Excel(name = "全厂合计")
    private String key6;

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKey0() {
        return key0;
    }

    public void setKey0(String key0) {
        this.key0 = key0;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getKey5() {
        return key5;
    }

    public void setKey5(String key5) {
        this.key5 = key5;
    }

    public String getKey6() {
        return key6;
    }

    public void setKey6(String key6) {
        this.key6 = key6;
    }

    public YueYangKeKaoXingZhiBiaoQianDuanVo() {
    }

    public YueYangKeKaoXingZhiBiaoQianDuanVo(String labelname, String unit, String key0, String key1, String key2, String key3, String key4, String key5, String key6) {
        this.labelname = labelname;
        this.unit = unit;
        this.key0 = key0;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key5 = key5;
        this.key6 = key6;
    }

    @Override
    public String toString() {
        return "YueYangKeKaoXingZhiBiaoQianDuanVo{" +
                "labelname='" + labelname + '\'' +
                ", unit='" + unit + '\'' +
                ", key0='" + key0 + '\'' +
                ", key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                ", key3='" + key3 + '\'' +
                ", key4='" + key4 + '\'' +
                ", key5='" + key5 + '\'' +
                ", key6='" + key6 + '\'' +
                '}';
    }
}
