package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessElectricWater;

/**
 * 水力发电总貌Mapper接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface BusinessElectricWaterMapper 
{
    /**
     * 查询水力发电总貌
     * 
     * @param id 水力发电总貌ID
     * @return 水力发电总貌
     */
    public BusinessElectricWater selectBusinessElectricWaterById(Long id);

    /**
     * 查询水力发电总貌列表
     * 
     * @param businessElectricWater 水力发电总貌
     * @return 水力发电总貌集合
     */
    public List<BusinessElectricWater> selectBusinessElectricWaterList(BusinessElectricWater businessElectricWater);

    /**
     * 新增水力发电总貌
     * 
     * @param businessElectricWater 水力发电总貌
     * @return 结果
     */
    public int insertBusinessElectricWater(BusinessElectricWater businessElectricWater);

    /**
     * 修改水力发电总貌
     * 
     * @param businessElectricWater 水力发电总貌
     * @return 结果
     */
    public int updateBusinessElectricWater(BusinessElectricWater businessElectricWater);

    /**
     * 删除水力发电总貌
     * 
     * @param id 水力发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricWaterById(Long id);

    /**
     * 批量删除水力发电总貌
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessElectricWaterByIds(Long[] ids);
}
