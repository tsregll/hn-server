package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 通过年or类型查询总和（饼状图）
 */
@ApiModel("条件查询统计（饼状图）")
public class StatisticsVo {
    /** 年份 */
    @Excel(name = "数值")
    @ApiModelProperty(value = "数值",name = "value",dataType = "String")
    private String value;
    /** 总计 */
    @Excel(name = "类型")
    @ApiModelProperty(value = "类型",name = "name",dataType = "String")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("value", getValue())
                .append("name", getName())
                .toString();
    }
}
