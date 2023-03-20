package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessHnElectrifiedGrid;

/**
 * 湖南电网发电量后台Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-13
 */
public interface BusinessHnElectrifiedGridMapper 
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
    public List<BusinessHnElectrifiedGrid> selectBusinessHnElectrifiedGridListOrderByDateTime(BusinessHnElectrifiedGrid businessHnElectrifiedGrid);

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
     * 删除湖南电网发电量后台
     * 
     * @param id 湖南电网发电量后台ID
     * @return 结果
     */
    public int deleteBusinessHnElectrifiedGridById(Long id);

    /**
     * 批量删除湖南电网发电量后台
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessHnElectrifiedGridByIds(Long[] ids);
}
