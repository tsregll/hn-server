package com.ruoyi.web.controller.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("人资职称描述")
public class HRWorkerType {
    @ApiModelProperty(value = "高级职称数量", name = "senior", dataType = "String")
    private String senior;
    @ApiModelProperty(value = "中级职称数量", name = "intermediate", dataType = "String")
    private String intermediate;
    @ApiModelProperty(value = "初级职称数量", name = "primary", dataType = "String")
    private String primary;


    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(String intermediate) {
        this.intermediate = intermediate;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }
}
