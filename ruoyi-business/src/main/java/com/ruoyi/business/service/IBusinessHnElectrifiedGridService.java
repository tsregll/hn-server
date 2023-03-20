package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessHnElectrifiedGrid;
import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;

/**
 * 湖南电网发电量后台Service接口
 * 
 * @author ruoyi
 * @date 2021-03-13
 */
public interface IBusinessHnElectrifiedGridService 
{
    /**
     * 查询湖南电网发电量后台
     * 
     * @param id 湖南电网发电量后台ID
     * @return 湖南电网发电量后台
     */
    public BusinessHnElectrifiedGrid selectBusinessHnElectrifiedGridById(Long id);

    /**
     * 查询湖南电网发电量后台列表
     * 
     * @param businessHnElectrifiedGrid 湖南电网发电量后台
     * @return 湖南电网发电量后台集合
     */
    public List<BusinessHnElectrifiedGrid> selectBusinessHnElectrifiedGridList(BusinessHnElectrifiedGrid businessHnElectrifiedGrid);

    /**
     * 查询湖南电网发电量后台列表
     *
     * @param businessHnElectrifiedGrid 湖南电网发电量后台
     * @return 湖南电网发电量后台集合
     */
    public List<BusinessHnElectrifiedGrid> selectByTimeHnElectrifiedGridList(BusinessHnElectrifiedGrid businessHnElectrifiedGrid);

    /**
     * 新增湖南电网发电量后台
     * 
     * @param businessHnElectrifiedGrid 湖南电网发电量后台
     * @return 结果
     */
    public int insertBusinessHnElectrifiedGrid(BusinessHnElectrifiedGrid businessHnElectrifiedGrid);

    /**
     * 修改湖南电网发电量后台
     * 
     * @param businessHnElectrifiedGrid 湖南电网发电量后台
     * @return 结果
     */
    public int updateBusinessHnElectrifiedGrid(BusinessHnElectrifiedGrid businessHnElectrifiedGrid);

    /**
     * 批量删除湖南电网发电量后台
     * 
     * @param ids 需要删除的湖南电网发电量后台ID
     * @return 结果
     */
    public int deleteBusinessHnElectrifiedGridByIds(Long[] ids);

    /**
     * 删除湖南电网发电量后台信息
     * 
     * @param bsgc 湖南电网发电量后台ID
     * @return 结果
     */
    public String importDatas(List<BusinessHnElectrifiedGrid> bsgc);
    public int deleteBusinessHnElectrifiedGridById(Long id);
    public Map<String,Object> selectFive(BusinessHnElectrifiedGrid bheg);
    public Map<String,Object> selectOneYear(BusinessHnElectrifiedGrid bheg);
    public Map<String,Object> selectByTable(BusinessHnElectrifiedGrid bheg);
}
