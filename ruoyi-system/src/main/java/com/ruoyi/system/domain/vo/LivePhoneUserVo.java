package com.ruoyi.system.domain.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 指挥调度——直拨通话
 *
 * @author yrb
 */
public class LivePhoneUserVo {
    private String userName;
    private String nickName;
    private String livePhoneCode;
    private String ipAddress;
    private String deptName1;
    private String deptName2;
    private String deptType;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setLivePhoneCode(String livePhoneCode) {
        this.livePhoneCode = livePhoneCode;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setDeptName1(String deptName1) {
        this.deptName1 = deptName1;
    }

    public void setDeptName2(String deptName2) {
        this.deptName2 = deptName2;
    }
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getLivePhoneCode() {
        return livePhoneCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getDeptName1() {
        return deptName1;
    }

    public String getDeptName2() {
        return deptName2;
    }
    public String getDeptType() {
        return deptType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("livePhoneCode", getLivePhoneCode())
                .append("ipAddress", getIpAddress())
                .append("deptName1", getDeptName1())
                .append("deptName2", getDeptName2())
                .append("deptType", getDeptType())
                .toString();
    }
}
