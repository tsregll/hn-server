package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 全社会用电量（最近五年全国电力消费构成0：全社会用电量、1：第一产业、2：第二产业、3：第三产业、4：城乡居民）
 */
@ApiModel("全社会近5年用电量（柱状图VO）")
public class ConsumptionElectricityFiveVo {
    @ApiModelProperty(value = "类型",name = "name",dataType = "String")
    private String name;
    private String type;
    private String stack;
    @ApiModelProperty(value = "数据组",name = "data",dataType = "String")
    private String[] data;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStack() {
        return stack;
    }

    public String[] getData() {
        return data;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("name", getName())
                .append("type", getType())
                .append("stack", getStack())
                .append("data", getData())
                .toString();
    }
}
