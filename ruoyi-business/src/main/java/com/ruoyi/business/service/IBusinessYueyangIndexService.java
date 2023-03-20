package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessYueyangIndex;

/**
 * 岳阳电厂年度指标录入Service接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface IBusinessYueyangIndexService 
{
    /**
     * 查询岳阳电厂年度指标录入
     * 
     * @param id 岳阳电厂年度指标录入ID
     * @return 岳阳电厂年度指标录入
     */
    public BusinessYueyangIndex selectBusinessYueyangIndexById(Long id);

    /**
     * 查询岳阳电厂年度指标录入列表
     * 
     * @param businessYueyangIndex 岳阳电厂年度指标录入
     * @return 岳阳电厂年度指标录入集合
     */
    public List<BusinessYueyangIndex> selectBusinessYueyangIndexList(BusinessYueyangIndex businessYueyangIndex);

    /**
     * 新增岳阳电厂年度指标录入
     * 
     * @param businessYueyangIndex 岳阳电厂年度指标录入
     * @return 结果
     */
    public int insertBusinessYueyangIndex(BusinessYueyangIndex businessYueyangIndex);

    /**
     * 修改岳阳电厂年度指标录入
     * 
     * @param businessYueyangIndex 岳阳电厂年度指标录入
     * @return 结果
     */
    public int updateBusinessYueyangIndex(BusinessYueyangIndex businessYueyangIndex);

    /**
     * 批量删除岳阳电厂年度指标录入
     * 
     * @param ids 需要删除的岳阳电厂年度指标录入ID
     * @return 结果
     */
    public int deleteBusinessYueyangIndexByIds(Long[] ids);

    /**
     * 删除岳阳电厂年度指标录入信息
     * 
     * @param id 岳阳电厂年度指标录入ID
     * @return 结果
     */
    public int deleteBusinessYueyangIndexById(Long id);
}
