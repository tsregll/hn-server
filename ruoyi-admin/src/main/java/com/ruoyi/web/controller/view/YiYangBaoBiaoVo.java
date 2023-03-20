package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class YiYangBaoBiaoVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "指标名称")
    private String indexName;

    @Excel(name = "单位")
    private String company;

    @Excel(name = "全场合计")
    private String total;

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

    @Excel(name = "新港光伏")
    private String xggf;

    @Excel(name = "擂鼓台光伏")
    private String lgtgf;

    @Excel(name = "三灰湖光伏")
    private String shhgf;


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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public String getXggf() {
        return xggf;
    }

    public void setXggf(String xggf) {
        this.xggf = xggf;
    }

    public String getLgtgf() {
        return lgtgf;
    }

    public void setLgtgf(String lgtgf) {
        this.lgtgf = lgtgf;
    }

    public String getShhgf() {
        return shhgf;
    }

    public void setShhgf(String shhgf) {
        this.shhgf = shhgf;
    }


    public YiYangBaoBiaoVo() {

    }
    public YiYangBaoBiaoVo(String indexName, String company, String total, String crew1, String crew2, String crew3, String crew4, String crew5, String crew6, String xggf, String lgtgf, String shhgf) {
        this.indexName = indexName;
        this.company = company;
        this.total = total;
        Crew1 = crew1;
        Crew2 = crew2;
        Crew3 = crew3;
        Crew4 = crew4;
        Crew5 = crew5;
        Crew6 = crew6;
        this.xggf = xggf;
        this.lgtgf = lgtgf;
        this.shhgf = shhgf;
    }

    @Override
    public String toString() {
        return "YiYangBaoBiaoVo{" +
                "indexName='" + indexName + '\'' +
                ", company='" + company + '\'' +
                ", total='" + total + '\'' +
                ", Crew1='" + Crew1 + '\'' +
                ", Crew2='" + Crew2 + '\'' +
                ", Crew3='" + Crew3 + '\'' +
                ", Crew4='" + Crew4 + '\'' +
                ", Crew5='" + Crew5 + '\'' +
                ", Crew6='" + Crew6 + '\'' +
                ", xggf='" + xggf + '\'' +
                ", lgtgf='" + lgtgf + '\'' +
                ", shhgf='" + shhgf + '\'' +
                '}';
    }
}
