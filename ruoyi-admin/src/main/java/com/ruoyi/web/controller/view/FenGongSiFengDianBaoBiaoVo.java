package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;

public class FenGongSiFengDianBaoBiaoVo {

    private static final long serialVersionUID = 1L;

    @Excel(name = "单位")
    private String place;

    @Excel(name = "上周日均发电量（万千瓦时）")
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

    @Excel(name = "上周等效利用小时环比（亿立方米）")
    private String key6;

    @Excel(name = "上周厂用电率（%）")
    private String key7;

    @Excel(name = "上周厂用电率环比（%）")
    private String key8;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public String getKey7() {
        return key7;
    }

    public void setKey7(String key7) {
        this.key7 = key7;
    }

    public String getKey8() {
        return key8;
    }

    public void setKey8(String key8) {
        this.key8 = key8;
    }


    public FenGongSiFengDianBaoBiaoVo() {
    }

    public FenGongSiFengDianBaoBiaoVo(String place, String key0, String key1, String key2, String key3, String key4, String key5, String key6, String key7, String key8, String key9, String key10) {
        this.place = place;
        this.key0 = key0;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key5 = key5;
        this.key6 = key6;
        this.key7 = key7;
        this.key8 = key8;
    }
}
