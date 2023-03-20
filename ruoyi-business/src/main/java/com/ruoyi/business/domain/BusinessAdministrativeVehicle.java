package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆管理
对象 business_administrative_vehicle
 * 
 * @author gwsh
 * @date 2021-03-03
 */
public class BusinessAdministrativeVehicle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 购车日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购车日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlateNumber;

    /** 车辆品牌 */
    @Excel(name = "车辆品牌")
    private String vehicleBrand;

    /** 车辆型号 */
    @Excel(name = "车辆型号")
    private String vehicleType;

    /** 车辆排量 */
    @Excel(name = "车辆排量")
    private String vehicleEmissions;

    /** 车辆图片 */
    @Excel(name = "车辆图片")
    private String vehicleImage;

    /** 加油卡号 */
    @Excel(name = "加油卡号")
    private String refuelCardNumber;

    /** etc卡号 */
    @Excel(name = "etc卡号")
    private String etcCardNumber;

    /** 车辆里程数 */
    @Excel(name = "车辆里程数")
    private String vehicleMileage;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchaseDate(Date purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() 
    {
        return purchaseDate;
    }
    public void setLicensePlateNumber(String licensePlateNumber) 
    {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() 
    {
        return licensePlateNumber;
    }
    public void setVehicleBrand(String vehicleBrand) 
    {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleBrand() 
    {
        return vehicleBrand;
    }
    public void setVehicleType(String vehicleType) 
    {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() 
    {
        return vehicleType;
    }
    public void setVehicleEmissions(String vehicleEmissions) 
    {
        this.vehicleEmissions = vehicleEmissions;
    }

    public String getVehicleEmissions() 
    {
        return vehicleEmissions;
    }
    public void setVehicleImage(String vehicleImage) 
    {
        this.vehicleImage = vehicleImage;
    }

    public String getVehicleImage() 
    {
        return vehicleImage;
    }
    public void setRefuelCardNumber(String refuelCardNumber) 
    {
        this.refuelCardNumber = refuelCardNumber;
    }

    public String getRefuelCardNumber() 
    {
        return refuelCardNumber;
    }
    public void setEtcCardNumber(String etcCardNumber) 
    {
        this.etcCardNumber = etcCardNumber;
    }

    public String getEtcCardNumber() 
    {
        return etcCardNumber;
    }
    public void setVehicleMileage(String vehicleMileage) 
    {
        this.vehicleMileage = vehicleMileage;
    }

    public String getVehicleMileage() 
    {
        return vehicleMileage;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseDate", getPurchaseDate())
            .append("licensePlateNumber", getLicensePlateNumber())
            .append("vehicleBrand", getVehicleBrand())
            .append("vehicleType", getVehicleType())
            .append("vehicleEmissions", getVehicleEmissions())
            .append("vehicleImage", getVehicleImage())
            .append("refuelCardNumber", getRefuelCardNumber())
            .append("etcCardNumber", getEtcCardNumber())
            .append("vehicleMileage", getVehicleMileage())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
