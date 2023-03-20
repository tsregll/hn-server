package com.ruoyi.web.controller.view;

public class ChangeUserPasswordVo {
    private String userName;
    private String oldPasswordCode;
    private String newPasswordCode;
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setOldPasswordCode(String oldPasswordCode) {
        this.oldPasswordCode = oldPasswordCode;
    }

    public void setNewPasswordCode(String newPasswordCode) {
        this.newPasswordCode = newPasswordCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getOldPasswordCode() {
        return oldPasswordCode;
    }

    public String getNewPasswordCode() {
        return newPasswordCode;
    }
}
