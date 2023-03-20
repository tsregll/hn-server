package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;

public class GfkkxzbVo {
    private static final long serialVersionUID = 1L;

    @Excel(name = "指标项")
    private String indexName;

    @Excel(name = "单位")
    private String company;

    @Excel(name = "新港光伏")
    private String Crew1;

    @Excel(name = "擂鼓台光伏")
    private String Crew2;

    @Excel(name = "三来湖光伏")
    private String Crew3;

    @Excel(name = "全站合计")
    private String Crew4;

    public GfkkxzbVo() {

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

    @Override
    public String toString() {
        return "GfkkxzbVo{" +
                "indexName='" + indexName + '\'' +
                ", company='" + company + '\'' +
                ", Crew1='" + Crew1 + '\'' +
                ", Crew2='" + Crew2 + '\'' +
                ", Crew3='" + Crew3 + '\'' +
                ", Crew4='" + Crew4 + '\'' +
                '}';
    }
}
