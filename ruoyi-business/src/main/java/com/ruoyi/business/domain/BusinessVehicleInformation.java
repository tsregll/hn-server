package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 车辆字典对象 business_vehicle_information
 * 
 * @author ruoyi
 * @date 2021-04-22
 */
public class BusinessVehicleInformation extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 车辆状态（0正常 1停用） */
    @Excel(name = "车辆状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 车辆信息 */
    @Excel(name = "车辆信息")
    private String vehicleInformation;

    /** 字典类型 */
    @Excel(name = "字典类型")
    private Long vehicleTpye;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setVehicleInformation(String vehicleInformation) 
    {
        this.vehicleInformation = vehicleInformation;
    }

    public String getVehicleInformation() 
    {
        return vehicleInformation;
    }
    public void setVehicleTpye(Long vehicleTpye) 
    {
        this.vehicleTpye = vehicleTpye;
    }

    public Long getVehicleTpye() 
    {
        return vehicleTpye;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("parentId", getParentId())
            .append("vehicleInformation", getVehicleInformation())
            .append("vehicleTpye", getVehicleTpye())
            .toString();
    }
}
