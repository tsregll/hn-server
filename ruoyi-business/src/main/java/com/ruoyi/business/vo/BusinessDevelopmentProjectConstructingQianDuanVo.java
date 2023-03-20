package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;

/**
 * 规划发展在建项目关键节点对象 business_development_project_constructing_node
 * 
 * @author ruoyi
 * @date 2021-08-06
 */
public class BusinessDevelopmentProjectConstructingQianDuanVo
{
    /** 序号 */
    private String key0;
    private String key1;
    private String key2;
    private String key3;


    public BusinessDevelopmentProjectConstructingQianDuanVo() {
    }

    public BusinessDevelopmentProjectConstructingQianDuanVo(String key0, String key1, String key2, String key3) {
        this.key0 = key0;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }

    public String getKey0() {
        return key0;
    }

    public void setKey0(String key0) {
        this.key0 = key0;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }
}
