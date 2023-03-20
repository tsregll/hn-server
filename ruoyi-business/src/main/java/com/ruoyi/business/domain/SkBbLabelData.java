package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * SkBbLabel对象 sk_bb_label
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
public class SkBbLabelData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报表名称 */
    @Excel(name = "报表名称")
    private String name;

    /** 场站 */
    @Excel(name = "场站")
    private String place;

    /** 点名称 */
    @Excel(name = "点名称")
    private String labelname;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 点标签 */
    @Excel(name = "点标签")
    private String label;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setLabelname(String labelname) 
    {
        this.labelname = labelname;
    }

    public String getLabelname() 
    {
        return labelname;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setLabel(String label) 
    {
        this.label = label;
    }

    public String getLabel() 
    {
        return label;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("place", getPlace())
            .append("labelname", getLabelname())
            .append("unit", getUnit())
            .append("label", getLabel())
            .toString();
    }
}
