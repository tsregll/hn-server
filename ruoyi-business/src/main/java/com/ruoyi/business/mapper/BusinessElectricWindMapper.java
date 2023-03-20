package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessElectricWind;

/**
 * 风能发电总貌Mapper接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface BusinessElectricWindMapper 
{
    /**
     * 查询风能发电总貌
     * 
     * @param id 风能发电总貌ID
     * @return 风能发电总貌
     */
    public BusinessElectricWind selectBusinessElectricWindById(Long id);

    /**
     * 查询风能发电总貌列表
     * 
     * @param businessElectricWind 风能发电总貌
     * @return 风能发电总貌集合
     */
    public List<BusinessElectricWind> selectBusinessElectricWindList(BusinessElectricWind businessElectricWind);

    /**
     * 新增风能发电总貌
     * 
     * @param businessElectricWind 风能发电总貌
     * @return 结果
     */
    public int insertBusinessElectricWind(BusinessElectricWind businessElectricWind);

    /**
     * 修改风能发电总貌
     * 
     * @param businessElectricWind 风能发电总貌
     * @return 结果
     */
    public int updateBusinessElectricWind(BusinessElectricWind businessElectricWind);

    /**
     * 删除风能发电总貌
     * 
     * @param id 风能发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricWindById(Long id);

    /**
     * 批量删除风能发电总貌
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessElectricWindByIds(Long[] ids);
}
