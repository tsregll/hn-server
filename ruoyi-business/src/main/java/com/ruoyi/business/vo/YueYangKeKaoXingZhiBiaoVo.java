package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

public class YueYangKeKaoXingZhiBiaoVo {

    @Excel(name = "序号")
    private Integer id;

    @Excel(name = "类型")
    private String stateType;

    @Excel(name = "机组号")
    private String machineNo;

    @Excel(name = "机组修改前状态")
    private String stateChangeBefore;

    @Excel(name = "机组修改后状态")
    private String stateChangeAfter;

    @Excel(name = "修改时间")
    private String stateChangeTime;
    //修改时间
    private String beginChangeTime;
    //修改时间
    private String endChangeTime;

    @Excel(name = "修改人")
    private String editUserName;

    @Excel(name = "修改人工号")
    private String editUserNo;

    //修改数据时间,无需传值
    private String editTime;

    public YueYangKeKaoXingZhiBiaoVo() {
    }

    public YueYangKeKaoXingZhiBiaoVo(Integer id, String stateType, String machineNo, String stateChangeBefore, String stateChangeAfter, String stateChangeTime, String editUserName, String editUserNo) {
        this.id = id;
        this.stateType = stateType;
        this.machineNo = machineNo;
        this.stateChangeBefore = stateChangeBefore;
        this.stateChangeAfter = stateChangeAfter;
        this.stateChangeTime = stateChangeTime;
        this.editUserName = editUserName;
        this.editUserNo = editUserNo;
    }

    public String getBeginChangeTime() {
        return beginChangeTime;
    }

    public void setBeginChangeTime(String beginChangeTime) {
        this.beginChangeTime = beginChangeTime;
    }

    public String getEndChangeTime() {
        return endChangeTime;
    }

    public void setEndChangeTime(String endChangeTime) {
        this.endChangeTime = endChangeTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getStateChangeBefore() {
        return stateChangeBefore;
    }

    public void setStateChangeBefore(String stateChangeBefore) {
        this.stateChangeBefore = stateChangeBefore;
    }

    public String getStateChangeAfter() {
        return stateChangeAfter;
    }

    public void setStateChangeAfter(String stateChangeAfter) {
        this.stateChangeAfter = stateChangeAfter;
    }

    public String getStateChangeTime() {
        return stateChangeTime;
    }

    public void setStateChangeTime(String stateChangeTime) {
        this.stateChangeTime = stateChangeTime;
    }

    public String getEditUserName() {
        return editUserName;
    }

    public void setEditUserName(String editUserName) {
        this.editUserName = editUserName;
    }

    public String getEditUserNo() {
        return editUserNo;
    }

    public void setEditUserNo(String editUserNo) {
        this.editUserNo = editUserNo;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    @Override
    public String toString() {
        return "YueYangKeKaoXingZhiBiaoVo{" +
                "id=" + id +
                ", stateType='" + stateType + '\'' +
                ", machineNo='" + machineNo + '\'' +
                ", stateChangeBefore='" + stateChangeBefore + '\'' +
                ", stateChangeAfter='" + stateChangeAfter + '\'' +
                ", stateChangeTime=" + stateChangeTime +
                ", editUserName='" + editUserName + '\'' +
                ", editUserNo='" + editUserNo + '\'' +
                ", editTime='" + editTime + '\'' +
                '}';
    }
}
