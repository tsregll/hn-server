package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.BusinessElectricData;

/**
 * 用电数据Service接口
 *
 * @author ruoyi
 * @date 2021-02-26
 */
public interface IBusinessElectricDataService {
    /**
     * 查询用电数据
     *
     * @param id 用电数据ID
     * @return 用电数据
     */
    public BusinessElectricData selectBusinessElectricDataById(Long id);

    /**
     * 查询用电数据列表
     *
     * @param businessElectricData 用电数据
     * @return 用电数据集合
     */
    public List<BusinessElectricData> selectBusinessElectricDataList(BusinessElectricData businessElectricData);

    /**
     * 新增用电数据
     *
     * @param businessElectricData 用电数据
     * @return 结果
     */
    public int insertBusinessElectricData(BusinessElectricData businessElectricData);

    /**
     * 修改用电数据
     *
     * @param businessElectricData 用电数据
     * @return 结果
     */
    public int updateBusinessElectricData(BusinessElectricData businessElectricData);

    /**
     * 批量删除用电数据
     *
     * @param ids 需要删除的用电数据ID
     * @return 结果
     */
    public int deleteBusinessElectricDataByIds(Long[] ids);

    /**
     * 删除用电数据信息
     *
     * @param id 用电数据ID
     * @return 结果
     */
    public int deleteBusinessElectricDataById(Long id);
}
