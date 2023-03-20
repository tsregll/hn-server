package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 岳阳电厂计划曲线对象 business_statistics_yueyang_electricity
 * 
 * @author ruoyi
 * @date 2021-08-13
 */
public class BusinessStatisticsYueyangElectricity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 日期 */
    private String defaultTime;

    /** 操作人 */
    private String operator;

    /** 操作工号 */
    private String operatorNumber;

    /** 计划日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", dateFormat = "yyyy-MM-dd")
    private String preparationDate;

    /** 00 */
    @Excel(name = "00")
    private String key0;

    /** 01 */
    @Excel(name = "01")
    private String key1;

    /** 02 */
    @Excel(name = "02")
    private String key2;

    /** 03 */
    @Excel(name = "03")
    private String key3;

    /** 04 */
    @Excel(name = "04")
    private String key4;

    /** 05 */
    @Excel(name = "05")
    private String key5;

    /** 06 */
    @Excel(name = "06")
    private String key6;

    /** 07 */
    @Excel(name = "07")
    private String key7;

    /** 08 */
    @Excel(name = "08")
    private String key8;

    /** 09 */
    @Excel(name = "09")
    private String key9;

    /** 10 */
    @Excel(name = "10")
    private String key10;

    /** 11 */
    @Excel(name = "11")
    private String key11;

    /** 12 */
    @Excel(name = "12")
    private String key12;

    /** 13 */
    @Excel(name = "13")
    private String key13;

    /** 14 */
    @Excel(name = "14")
    private String key14;

    /** 15 */
    @Excel(name = "15")
    private String key15;

    /** 16 */
    @Excel(name = "16")
    private String key16;

    /** 17 */
    @Excel(name = "17")
    private String key17;

    /** 18 */
    @Excel(name = "18")
    private String key18;

    /** 19 */
    @Excel(name = "19")
    private String key19;

    /** 20 */
    @Excel(name = "20")
    private String key20;

    /** 21 */
    @Excel(name = "21")
    private String key21;

    /** 22 */
    @Excel(name = "22")
    private String key22;

    /** 23 */
    @Excel(name = "23")
    private String key23;

    /** 24 */
    @Excel(name = "24")
    private String key24;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setDefaultTime(String defaultTime) 
    {
        this.defaultTime = defaultTime;
    }

    public String getDefaultTime() 
    {
        return defaultTime;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setOperatorNumber(String operatorNumber) 
    {
        this.operatorNumber = operatorNumber;
    }

    public String getOperatorNumber() 
    {
        return operatorNumber;
    }
    public void setPreparationDate(String preparationDate) 
    {
        this.preparationDate = preparationDate;
    }

    public String getPreparationDate() 
    {
        return preparationDate;
    }
    public void setKey0(String key0) 
    {
        this.key0 = key0;
    }

    public String getKey0() 
    {
        return key0;
    }
    public void setKey1(String key1) 
    {
        this.key1 = key1;
    }

    public String getKey1() 
    {
        return key1;
    }
    public void setKey2(String key2) 
    {
        this.key2 = key2;
    }

    public String getKey2() 
    {
        return key2;
    }
    public void setKey3(String key3) 
    {
        this.key3 = key3;
    }

    public String getKey3() 
    {
        return key3;
    }
    public void setKey4(String key4) 
    {
        this.key4 = key4;
    }

    public String getKey4() 
    {
        return key4;
    }
    public void setKey5(String key5) 
    {
        this.key5 = key5;
    }

    public String getKey5() 
    {
        return key5;
    }
    public void setKey6(String key6) 
    {
        this.key6 = key6;
    }

    public String getKey6() 
    {
        return key6;
    }
    public void setKey7(String key7) 
    {
        this.key7 = key7;
    }

    public String getKey7() 
    {
        return key7;
    }
    public void setKey8(String key8) 
    {
        this.key8 = key8;
    }

    public String getKey8() 
    {
        return key8;
    }
    public void setKey9(String key9) 
    {
        this.key9 = key9;
    }

    public String getKey9() 
    {
        return key9;
    }
    public void setKey10(String key10) 
    {
        this.key10 = key10;
    }

    public String getKey10() 
    {
        return key10;
    }
    public void setKey11(String key11) 
    {
        this.key11 = key11;
    }

    public String getKey11() 
    {
        return key11;
    }
    public void setKey12(String key12) 
    {
        this.key12 = key12;
    }

    public String getKey12() 
    {
        return key12;
    }
    public void setKey13(String key13) 
    {
        this.key13 = key13;
    }

    public String getKey13() 
    {
        return key13;
    }
    public void setKey14(String key14) 
    {
        this.key14 = key14;
    }

    public String getKey14() 
    {
        return key14;
    }
    public void setKey15(String key15) 
    {
        this.key15 = key15;
    }

    public String getKey15() 
    {
        return key15;
    }
    public void setKey16(String key16) 
    {
        this.key16 = key16;
    }

    public String getKey16() 
    {
        return key16;
    }
    public void setKey17(String key17) 
    {
        this.key17 = key17;
    }

    public String getKey17() 
    {
        return key17;
    }
    public void setKey18(String key18) 
    {
        this.key18 = key18;
    }

    public String getKey18() 
    {
        return key18;
    }
    public void setKey19(String key19) 
    {
        this.key19 = key19;
    }

    public String getKey19() 
    {
        return key19;
    }
    public void setKey20(String key20) 
    {
        this.key20 = key20;
    }

    public String getKey20() 
    {
        return key20;
    }
    public void setKey21(String key21) 
    {
        this.key21 = key21;
    }

    public String getKey21() 
    {
        return key21;
    }
    public void setKey22(String key22) 
    {
        this.key22 = key22;
    }

    public String getKey22() 
    {
        return key22;
    }
    public void setKey23(String key23) 
    {
        this.key23 = key23;
    }

    public String getKey23() 
    {
        return key23;
    }
    public void setKey24(String key24) 
    {
        this.key24 = key24;
    }

    public String getKey24() 
    {
        return key24;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("defaultTime", getDefaultTime())
            .append("operator", getOperator())
            .append("operatorNumber", getOperatorNumber())
            .append("preparationDate", getPreparationDate())
            .append("key0", getKey0())
            .append("key1", getKey1())
            .append("key2", getKey2())
            .append("key3", getKey3())
            .append("key4", getKey4())
            .append("key5", getKey5())
            .append("key6", getKey6())
            .append("key7", getKey7())
            .append("key8", getKey8())
            .append("key9", getKey9())
            .append("key10", getKey10())
            .append("key11", getKey11())
            .append("key12", getKey12())
            .append("key13", getKey13())
            .append("key14", getKey14())
            .append("key15", getKey15())
            .append("key16", getKey16())
            .append("key17", getKey17())
            .append("key18", getKey18())
            .append("key19", getKey19())
            .append("key20", getKey20())
            .append("key21", getKey21())
            .append("key22", getKey22())
            .append("key23", getKey23())
            .append("key24", getKey24())
            .append("remark", getRemark())
            .toString();
    }
}
