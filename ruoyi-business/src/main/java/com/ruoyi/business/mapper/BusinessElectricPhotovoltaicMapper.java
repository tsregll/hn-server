package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessElectricPhotovoltaic;

/**
 * 光伏发电总貌Mapper接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface BusinessElectricPhotovoltaicMapper 
{
    /**
     * 查询光伏发电总貌
     * 
     * @param id 光伏发电总貌ID
     * @return 光伏发电总貌
     */
    public BusinessElectricPhotovoltaic selectBusinessElectricPhotovoltaicById(Long id);

    /**
     * 查询光伏发电总貌列表
     * 
     * @param businessElectricPhotovoltaic 光伏发电总貌
     * @return 光伏发电总貌集合
     */
    public List<BusinessElectricPhotovoltaic> selectBusinessElectricPhotovoltaicList(BusinessElectricPhotovoltaic businessElectricPhotovoltaic);

    /**
     * 新增光伏发电总貌
     * 
     * @param businessElectricPhotovoltaic 光伏发电总貌
     * @return 结果
     */
    public int insertBusinessElectricPhotovoltaic(BusinessElectricPhotovoltaic businessElectricPhotovoltaic);

    /**
     * 修改光伏发电总貌
     * 
     * @param businessElectricPhotovoltaic 光伏发电总貌
     * @return 结果
     */
    public int updateBusinessElectricPhotovoltaic(BusinessElectricPhotovoltaic businessElectricPhotovoltaic);

    /**
     * 删除光伏发电总貌
     * 
     * @param id 光伏发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricPhotovoltaicById(Long id);

    /**
     * 批量删除光伏发电总貌
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessElectricPhotovoltaicByIds(Long[] ids);
}
