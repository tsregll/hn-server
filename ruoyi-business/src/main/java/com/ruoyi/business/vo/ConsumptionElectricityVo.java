package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 全社会用电量（通过类别查询的柱状图）
 */
@ApiModel("分析表")
public class ConsumptionElectricityVo {
    @Excel(name = "本期类型")
    @ApiModelProperty(value = "本期类型",name = "types",dataType = "String")
    private String types;
    @Excel(name = "本期数据组")
    @ApiModelProperty(value = "本期数据组",name = "datas",dataType = "String")
    private String[] datas;
    @Excel(name = "同期类型")
    @ApiModelProperty(value = "同期类型",name = "lastType",dataType = "String")
    private String lastType;
    @Excel(name = "同期数据组")
    @ApiModelProperty(value = "同期数据组",name = "lastDatas",dataType = "String")
    private String[] lastDatas;
    @Excel(name = "年份组（标识上方数组属于哪个年份的）")
    @ApiModelProperty(value = "年份组（标识上方数组属于哪个年份的）",name = "years",dataType = "String")
    private String[] years;

    public void setTypes(String types) {
        this.types = types;
    }
    public void setDatas(String[] datas) {
        this.datas = datas;
    }
    public void setLastType(String lastType) {
        this.lastType = lastType;
    }
    public void setLastDatas(String[] lastDatas) {
        this.lastDatas = lastDatas;
    }
    public void setYears(String[] years) {
        this.years = years;
    }

    public String getTypes() {
        return types;
    }
    public String[] getDatas() {
        return datas;
    }
    public String getLastType() {
        return lastType;
    }
    public String[] getLastDatas() {
        return lastDatas;
    }
    public String[] getYears() {
        return years;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("types", getTypes())
                .append("datas", getDatas())
                .append("lastType", getLastType())
                .append("lastDatas", getLastDatas())
                .append("years", getYears())
                .toString();
    }
}
