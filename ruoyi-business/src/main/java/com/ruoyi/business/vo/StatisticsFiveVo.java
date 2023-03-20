package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 查询近5年的统计图
 */
@ApiModel("近5年装机容量分析表（月度表格）")
public class StatisticsFiveVo {

    /** 年份 */
    @Excel(name = "数值")
    @ApiModelProperty(value = "数值",name = "value",dataType = "String")
    private String[] value;
    /** 总计 */
    @Excel(name = "年份")
    @ApiModelProperty(value = "年份",name = "year",dataType = "String")
    private String[] year;

    public void setYear(String[] year) {
        this.year = year;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public String[] getYear() {
        return year;
    }

    public String[] getValue() {
        return value;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("value", getValue())
                .append("year", getYear())
                .toString();
    }
}
