package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class FenGongSiBaoBiaoVo{

    private static final long serialVersionUID = 1L;

    @Excel(name = "周分公司日均发电量（万千瓦时）")
    private String rjfdl;

    @Excel(name = "电量环比（%）")
    private String dlhb;

    @Excel(name = "电量同比（%）")
    private String dltb;

    @Excel(name = "完成生产厂用电率（%）")
    private String wcsccydl;

    @Excel(name = "厂用电率环比（%）")
    private String cydlhb;

    @Excel(name = "完成供电煤耗（克/千瓦时）")
    private String gdmh;

    @Excel(name = "供电煤耗环比（%）")
    private String mhhb;

    @Excel(name = "三期日均发电占比（%）")
    private String fdzb;

    @Excel(name = "三期日均发电占比环比（%）")
    private String fdzbhb;

    @Excel(name = "三期日均发电占比（%）")
    private String zjfdzb;
    


    public String getRjfdl() {
        return rjfdl;
    }

    public void setRjfdl(String rjfdl) {
        this.rjfdl = rjfdl;
    }

    public String getDlhb() {
        return dlhb;
    }

    public void setDlhb(String dlhb) {
        this.dlhb = dlhb;
    }

    public String getDltb() {
        return dltb;
    }

    public void setDltb(String dltb) {
        this.dltb = dltb;
    }

    public String getWcsccydl() {
        return wcsccydl;
    }

    public void setWcsccydl(String wcsccydl) {
        this.wcsccydl = wcsccydl;
    }

    public String getCydlhb() {
        return cydlhb;
    }

    public void setCydlhb(String cydlhb) {
        this.cydlhb = cydlhb;
    }

    public String getGdmh() {
        return gdmh;
    }

    public void setGdmh(String gdmh) {
        this.gdmh = gdmh;
    }

    public String getMhhb() {
        return mhhb;
    }

    public void setMhhb(String mhhb) {
        this.mhhb = mhhb;
    }

    public String getFdzb() {
        return fdzb;
    }

    public void setFdzb(String fdzb) {
        this.fdzb = fdzb;
    }

    public String getFdzbhb() {
        return fdzbhb;
    }

    public void setFdzbhb(String fdzbhb) {
        this.fdzbhb = fdzbhb;
    }

    public String getZjfdzb() {
        return zjfdzb;
    }

    public void setZjfdzb(String zjfdzb) {
        this.zjfdzb = zjfdzb;
    }
    


    public FenGongSiBaoBiaoVo() {

    }

    public FenGongSiBaoBiaoVo(String rjfdl, String dlhb, String dltb, String wcsccydl, String cydlhb, String gdmh, String mhhb, String fdzb, String fdzbhb, String zjfdzb) {
        this.rjfdl = rjfdl;
        this.dlhb = dlhb;
        this.dltb = dltb;
        this.wcsccydl = wcsccydl;
        this.cydlhb = cydlhb;
        this.gdmh = gdmh;
        this.mhhb = mhhb;
        this.fdzb = fdzb;
        this.fdzbhb = fdzbhb;
        this.zjfdzb = zjfdzb;
    }
}
