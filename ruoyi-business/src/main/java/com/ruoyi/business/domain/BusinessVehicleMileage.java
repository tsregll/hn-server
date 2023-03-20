package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆里程台账对象 business_vehicle_mileage
 * 
 * @author xwq
 * @date 2021-03-25
 */
public class BusinessVehicleMileage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增序号 */
    private Long id;

    /** 车辆id */
    @Excel(name = "车辆id")
    private Long vehicleid;

    /** 年份 */
    @Excel(name = "年份")
    private String vehicleyear;

    /** 月份 */
    @Excel(name = "月份")
    private String vehiclemonth;

    /** 里程 */
    @Excel(name = "里程")
    private String vehicleMileage;

    /** 车牌号码 */
    @Excel(name = "车牌号码")
    private String licensePlateNumber;

    /** 月初公里数 */
    @Excel(name = "月初公里数")
    private String kmBeginningOfMonth;

    /** 月末公里数 */
    @Excel(name = "月末公里数")
    private String kmEndindOfMonth;

    /** 加油量 */
    @Excel(name = "加油量")
    private String fuelVolume;

    /** 加油金额 */
    @Excel(name = "加油金额")
    private String refuelingAmount;

    /** 实际油耗 */
    @Excel(name = "实际油耗")
    private String actualFuelConsumption;

    /** 维保费 */
    @Excel(name = "维保费")
    private Long maintenancePremium;

    /** 保险费 */
    @Excel(name = "保险费")
    private Long insurancePremium;

    /** 通行费 */
    @Excel(name = "通行费")
    private Long toll;

    /** 停车费 */
    @Excel(name = "停车费")
    private Long parkingRate;

    /** 车位费 */
    @Excel(name = "车位费")
    private Long parkingFee;

    /** 洗车费 */
    @Excel(name = "洗车费")
    private Long carWashFee;

    /** 其它费用 */
    @Excel(name = "其它费用")
    private Long otherExpenses;

    /** 小计 */
    @Excel(name = "小计")
    private Long subtotal;

    /** 总费用 */
    @Excel(name = "总费用")
    private Long totalCost;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVehicleid(Long vehicleid) 
    {
        this.vehicleid = vehicleid;
    }

    public Long getVehicleid() 
    {
        return vehicleid;
    }
    public void setVehicleyear(String vehicleyear) 
    {
        this.vehicleyear = vehicleyear;
    }

    public String getVehicleyear() 
    {
        return vehicleyear;
    }
    public void setVehiclemonth(String vehiclemonth) 
    {
        this.vehiclemonth = vehiclemonth;
    }

    public String getVehiclemonth() 
    {
        return vehiclemonth;
    }
    public void setVehicleMileage(String vehicleMileage) 
    {
        this.vehicleMileage = vehicleMileage;
    }

    public String getVehicleMileage() 
    {
        return vehicleMileage;
    }
    public void setLicensePlateNumber(String licensePlateNumber) 
    {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() 
    {
        return licensePlateNumber;
    }
    public void setKmBeginningOfMonth(String kmBeginningOfMonth) 
    {
        this.kmBeginningOfMonth = kmBeginningOfMonth;
    }

    public String getKmBeginningOfMonth() 
    {
        return kmBeginningOfMonth;
    }
    public void setKmEndindOfMonth(String kmEndindOfMonth) 
    {
        this.kmEndindOfMonth = kmEndindOfMonth;
    }

    public String getKmEndindOfMonth() 
    {
        return kmEndindOfMonth;
    }
    public void setFuelVolume(String fuelVolume) 
    {
        this.fuelVolume = fuelVolume;
    }

    public String getFuelVolume() 
    {
        return fuelVolume;
    }
    public void setRefuelingAmount(String refuelingAmount) 
    {
        this.refuelingAmount = refuelingAmount;
    }

    public String getRefuelingAmount() 
    {
        return refuelingAmount;
    }
    public void setActualFuelConsumption(String actualFuelConsumption) 
    {
        this.actualFuelConsumption = actualFuelConsumption;
    }

    public String getActualFuelConsumption() 
    {
        return actualFuelConsumption;
    }
    public void setMaintenancePremium(Long maintenancePremium) 
    {
        this.maintenancePremium = maintenancePremium;
    }

    public Long getMaintenancePremium() 
    {
        return maintenancePremium;
    }
    public void setInsurancePremium(Long insurancePremium) 
    {
        this.insurancePremium = insurancePremium;
    }

    public Long getInsurancePremium() 
    {
        return insurancePremium;
    }
    public void setToll(Long toll) 
    {
        this.toll = toll;
    }

    public Long getToll() 
    {
        return toll;
    }
    public void setParkingRate(Long parkingRate) 
    {
        this.parkingRate = parkingRate;
    }

    public Long getParkingRate() 
    {
        return parkingRate;
    }
    public void setParkingFee(Long parkingFee) 
    {
        this.parkingFee = parkingFee;
    }

    public Long getParkingFee() 
    {
        return parkingFee;
    }
    public void setCarWashFee(Long carWashFee) 
    {
        this.carWashFee = carWashFee;
    }

    public Long getCarWashFee() 
    {
        return carWashFee;
    }
    public void setOtherExpenses(Long otherExpenses) 
    {
        this.otherExpenses = otherExpenses;
    }

    public Long getOtherExpenses() 
    {
        return otherExpenses;
    }
    public void setSubtotal(Long subtotal) 
    {
        this.subtotal = subtotal;
    }

    public Long getSubtotal() 
    {
        return subtotal;
    }
    public void setTotalCost(Long totalCost) 
    {
        this.totalCost = totalCost;
    }

    public Long getTotalCost() 
    {
        return totalCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vehicleid", getVehicleid())
            .append("vehicleyear", getVehicleyear())
            .append("vehiclemonth", getVehiclemonth())
            .append("vehicleMileage", getVehicleMileage())
            .append("licensePlateNumber", getLicensePlateNumber())
            .append("kmBeginningOfMonth", getKmBeginningOfMonth())
            .append("kmEndindOfMonth", getKmEndindOfMonth())
            .append("fuelVolume", getFuelVolume())
            .append("refuelingAmount", getRefuelingAmount())
            .append("actualFuelConsumption", getActualFuelConsumption())
            .append("maintenancePremium", getMaintenancePremium())
            .append("insurancePremium", getInsurancePremium())
            .append("toll", getToll())
            .append("parkingRate", getParkingRate())
            .append("parkingFee", getParkingFee())
            .append("carWashFee", getCarWashFee())
            .append("otherExpenses", getOtherExpenses())
            .append("subtotal", getSubtotal())
            .append("totalCost", getTotalCost())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
