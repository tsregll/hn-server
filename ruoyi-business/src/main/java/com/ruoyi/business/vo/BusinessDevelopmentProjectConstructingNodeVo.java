package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 规划发展在建项目关键节点对象 business_development_project_constructing_node
 * 
 * @author ruoyi
 * @date 2021-08-06
 */
public class BusinessDevelopmentProjectConstructingNodeVo
{
    /** 序号 */
    private String vid;

    private Long id;


    /** 关键节点名称 */
    @Excel(name = "关键节点名称")
    private String nodeName;

    /** 计划完成时间 */
    @Excel(name = "计划完成时间")
    private String planingTime;

    /**  */
    private String standard;

    /**  */
//    private String status;

    public BusinessDevelopmentProjectConstructingNodeVo() {
    }

    public BusinessDevelopmentProjectConstructingNodeVo(String vid, String nodeName, String planingTime, String standard) {
        this.vid = vid;
        this.nodeName = nodeName;
        this.planingTime = planingTime;
        this.standard = standard;
//        this.status = status;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getPlaningTime() {
        return planingTime;
    }

    public void setPlaningTime(String planingTime) {
        this.planingTime = planingTime;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}
