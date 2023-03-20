package com.ruoyi.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class constructingNodeQianDuanVo {
    private String labelname;
    private String status;

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public constructingNodeQianDuanVo() {
    }

    public constructingNodeQianDuanVo(String labelname, String status) {
        this.labelname = labelname;
        this.status = status;
    }
}
