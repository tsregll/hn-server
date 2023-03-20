package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;

public class FenGongSiHuoDianHuanBaoBaoBiaoVo {

    private static final long serialVersionUID = 1L;

    @Excel(name = "指标")
    private String labelName;

    @Excel(name = "单位")
    private String unit;

    @Excel(name = "上周日均发电量环比（万千瓦时）")
    private String key0;

    @Excel(name = "上周日均发电量环比（万千瓦时）")
    private String key1;

    @Excel(name = "上周日均发电量同比（万千瓦时）")
    private String key2;

    @Excel(name = "上周有效平均风速（亿立方米）")
    private String key3;

    @Excel(name = "上周有效平均风速环比（亿立方米）")
    private String key4;

    @Excel(name = "上周等效利用小时（亿立方米）")
    private String key5;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
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

    public FenGongSiHuoDianHuanBaoBaoBiaoVo() {
    }

    public FenGongSiHuoDianHuanBaoBaoBiaoVo(String labelName, String unit, String key0, String key1, String key2, String key3, String key4, String key5) {
        this.labelName = labelName;
        this.unit = unit;
        this.key0 = key0;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key5 = key5;
    }
}
