package com.ruoyi.business.service;

import com.ruoyi.business.domain.BusinessElectricArea;

import java.util.List;

/**
 * 区域发电总貌Service接口
 *
 * @author yrb
 * @date 2021-03-02
 */
public interface IBusinessElectricAreaService {
    /**
     * 查询单个区域发电总貌信息
     *
     * @param id 区域发电总貌ID
     * @return 区域发电总貌
     */
    public BusinessElectricArea selectBusinessElectricAreaById(Long id);

    /**
     * 查询区域发电总貌列表
     *
     * @param businessElectricArea 区域发电总貌
     * @return 区域发电总貌集合
     */
    public List<BusinessElectricArea> selectBusinessElectricAreaList(BusinessElectricArea businessElectricArea);

    /**
     * 新增区域发电总貌
     *
     * @param businessElectricArea 区域发电总貌
     * @return 结果
     */
    public int insertBusinessElectricArea(BusinessElectricArea businessElectricArea);

    /**
     * 修改区域发电总貌
     *
     * @param businessElectricArea 区域发电总貌
     * @return 结果
     */
    public int updateBusinessElectricArea(BusinessElectricArea businessElectricArea);

    /**
     * 批量删除区域发电总貌
     *
     * @param ids 需要删除的区域发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricAreaByIds(Long[] ids);

    /**
     * 删除区域发电总貌信息
     *
     * @param id 区域域发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricAreaById(Long id);
}
