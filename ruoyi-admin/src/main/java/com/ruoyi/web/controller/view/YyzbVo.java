package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class YyzbVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "指标项")
    private String indexName;

    @Excel(name = "单位")
    private String company;

    @Excel(name = "1#机组")
    private String Crew1;

    @Excel(name = "2#机组")
    private String Crew2;

    @Excel(name = "3#机组")
    private String Crew3;

    @Excel(name = "4#机组")
    private String Crew4;

    @Excel(name = "5#机组")
    private String Crew5;

    @Excel(name = "6#机组")
    private String Crew6;

    @Excel(name = "全厂合计")
    private String total;

    public YyzbVo() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCrew1() {
        return Crew1;
    }

    public void setCrew1(String crew1) {
        Crew1 = crew1;
    }

    public String getCrew2() {
        return Crew2;
    }

    public void setCrew2(String crew2) {
        Crew2 = crew2;
    }

    public String getCrew3() {
        return Crew3;
    }

    public void setCrew3(String crew3) {
        Crew3 = crew3;
    }

    public String getCrew4() {
        return Crew4;
    }

    public void setCrew4(String crew4) {
        Crew4 = crew4;
    }

    public String getCrew5() {
        return Crew5;
    }

    public void setCrew5(String crew5) {
        Crew5 = crew5;
    }

    public String getCrew6() {
        return Crew6;
    }

    public void setCrew6(String crew6) {
        Crew6 = crew6;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "YyzbVo{" +
                "indexName='" + indexName + '\'' +
                ", company='" + company + '\'' +
                ", Crew1='" + Crew1 + '\'' +
                ", Crew2='" + Crew2 + '\'' +
                ", Crew3='" + Crew3 + '\'' +
                ", Crew4='" + Crew4 + '\'' +
                ", Crew5='" + Crew5 + '\'' +
                ", Crew6='" + Crew6 + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
