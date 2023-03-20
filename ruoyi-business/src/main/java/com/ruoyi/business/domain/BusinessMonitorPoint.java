package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 监控探头配置对象 business_monitor_point
 * 
 * @author lpf
 * @date 2021-03-02
 */
public class BusinessMonitorPoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** IP */
    @Excel(name = "IP")
    private String ip;

    /** 端口 */
    @Excel(name = "端口")
    private String port;

    /** 帐号 */
    private String userName;

    /** 密码 */
    private String password;

    /** 位置经度 */
    private BigDecimal pointLng;

    /** 位置纬度 */
    private BigDecimal pointLat;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

    /** 所属区域id */
    private String orgId;

    /** 所属区域名称 */
    private String orgName;

    /** 通道id */
    @Excel(name = "通道id")
    private String channelId;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialNumber;

    /** mac地址 */
    @Excel(name = "mac地址")
    private String macAddr;

    /** 排序 */
    @Excel(name = "排序")
    private Long orderNum;

    /** 删除标志（0代表存在 1代表删除） */
    private Integer delFlag;

    /** 状态（0正常 1停用） */
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPointLng(BigDecimal pointLng) 
    {
        this.pointLng = pointLng;
    }

    public BigDecimal getPointLng() 
    {
        return pointLng;
    }
    public void setPointLat(BigDecimal pointLat) 
    {
        this.pointLat = pointLat;
    }

    public BigDecimal getPointLat() 
    {
        return pointLat;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setOrgId(String orgId) 
    {
        this.orgId = orgId;
    }

    public String getOrgId() 
    {
        return orgId;
    }
    public void setOrgName(String orgName) 
    {
        this.orgName = orgName;
    }

    public String getOrgName() 
    {
        return orgName;
    }
    public void setChannelId(String channelId) 
    {
        this.channelId = channelId;
    }

    public String getChannelId() 
    {
        return channelId;
    }
    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() 
    {
        return serialNumber;
    }
    public void setMacAddr(String macAddr) 
    {
        this.macAddr = macAddr;
    }

    public String getMacAddr() 
    {
        return macAddr;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("ip", getIp())
            .append("port", getPort())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("pointLng", getPointLng())
            .append("pointLat", getPointLat())
            .append("addr", getAddr())
            .append("orgId", getOrgId())
            .append("orgName", getOrgName())
            .append("channelId", getChannelId())
            .append("serialNumber", getSerialNumber())
            .append("macAddr", getMacAddr())
            .append("orderNum", getOrderNum())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
