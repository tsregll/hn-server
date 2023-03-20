package com.ruoyi.web.controller.view;

import com.ruoyi.common.annotation.Excel;


public class ElectricDataVo {

    /**
     * 年份
     */
    private Long year;

    /**
     * 月份
     */
    private Long month;

    /**
     * 用电总量
     */
    private Long total;

    /**
     * 负载
     */
    private Long loads;

    /**
     * 电费
     */
    private Long fees;

    /**
     * 部门领导id
     */
    private Long deptUserId;

    /**
     * 部门领导名称
     */
    private String deptUserName;

    /**
     * 分管领导id
     */
    private Long chargeUserId;

    /**
     * 分管领导名称
     */
    private String chargeUserName;

    /**
     * 主要领导id
     */
    private Long keyUserId;

    private String keyUserName;

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getLoads() {
        return loads;
    }

    public void setLoads(Long loads) {
        this.loads = loads;
    }

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }

    public Long getDeptUserId() {
        return deptUserId;
    }

    public void setDeptUserId(Long deptUserId) {
        this.deptUserId = deptUserId;
    }

    public String getDeptUserName() {
        return deptUserName;
    }

    public void setDeptUserName(String deptUserName) {
        this.deptUserName = deptUserName;
    }

    public Long getChargeUserId() {
        return chargeUserId;
    }

    public void setChargeUserId(Long chargeUserId) {
        this.chargeUserId = chargeUserId;
    }

    public String getChargeUserName() {
        return chargeUserName;
    }

    public void setChargeUserName(String chargeUserName) {
        this.chargeUserName = chargeUserName;
    }

    public Long getKeyUserId() {
        return keyUserId;
    }

    public void setKeyUserId(Long keyUserId) {
        this.keyUserId = keyUserId;
    }

    public String getKeyUserName() {
        return keyUserName;
    }

    public void setKeyUserName(String keyUserName) {
        this.keyUserName = keyUserName;
    }
}
