package com.ruoyi.business.domain.sk;

import com.ruoyi.common.core.domain.BaseEntity;

public class SkBbLabel extends BaseEntity {

    //数据位置
    private String place;
    //报表名称
    private String name;
    //报表名称
    private String labelName;
    //单位
    private String unit;
    //标签
    private String label;


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}
