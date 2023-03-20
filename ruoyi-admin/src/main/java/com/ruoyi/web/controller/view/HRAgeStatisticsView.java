package com.ruoyi.web.controller.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("人资年龄统计")
public class HRAgeStatisticsView {
    @ApiModelProperty(value = "小于等于三十岁的数量", name = "lt30", dataType = "String")
    // 小于等于三十岁的数量
    private String lt30;
    @ApiModelProperty(value = "小于等于40的数量", name = "lt40", dataType = "String")
    // 小于等于40的数量
    private String lt40;
    @ApiModelProperty(value = "小于等于50的数量", name = "lt50", dataType = "String")
    // 小于等于50的数量
    private String lt50;
    @ApiModelProperty(value = "小于等于54的数量", name = "lt54", dataType = "String")
    // 小于等于54的数量
    private String lt54;
    @ApiModelProperty(value = "大于54的数量", name = "gt54", dataType = "String")
    // 大于54的数量
    private String gt54;

    public String getLt30() {
        return lt30;
    }

    public void setLt30(String lt30) {
        this.lt30 = lt30;
    }

    public String getLt40() {
        return lt40;
    }

    public void setLt40(String lt40) {
        this.lt40 = lt40;
    }

    public String getLt50() {
        return lt50;
    }

    public void setLt50(String lt50) {
        this.lt50 = lt50;
    }

    public String getLt54() {
        return lt54;
    }

    public void setLt54(String lt54) {
        this.lt54 = lt54;
    }

    public String getGt54() {
        return gt54;
    }

    public void setGt54(String gt54) {
        this.gt54 = gt54;
    }
}
