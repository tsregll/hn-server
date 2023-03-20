package com.ruoyi.business.domain;

import java.math.BigDecimal;

import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class BusinessMarketingDaily {
    @Excel(name = "group")
    private String group;

    @Excel(name = "plant")
    private String plant;

    @Excel(name = "unit")
    private String unit;

    @Excel(name = "capcity")
    private String capcity;

    @Excel(name = "power_day")
    private String powerDay;

    /** 导出部门单个对象 */
    @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT)
    private SysDept dept;

}
