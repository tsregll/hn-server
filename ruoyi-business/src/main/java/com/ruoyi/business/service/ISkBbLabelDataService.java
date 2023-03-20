package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;
import com.ruoyi.business.domain.SkBbLabelData;

/**
 * SkBbLabelService接口
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
public interface ISkBbLabelDataService
{
    /**
     * 查询SkBbLabel
     * 
     * @param name SkBbLabelID
     * @return SkBbLabel
     */
    public SkBbLabelData selectSkBbLabelById(String name);

    /**
     * 查询SkBbLabel列表
     * 
     * @param skBbLabel SkBbLabel
     * @return SkBbLabel集合
     */
    public List<SkBbLabelData> selectSkBbLabelList(SkBbLabelData skBbLabel);

    /**
     * 新增SkBbLabel
     * 
     * @param skBbLabel SkBbLabel
     * @return 结果
     */
    public int insertSkBbLabel(SkBbLabelData skBbLabel);

    /**
     * 修改SkBbLabel
     * 
     * @param skBbLabel SkBbLabel
     * @return 结果
     */
    public int updateSkBbLabel(SkBbLabelData skBbLabel);

    /**
     * 批量删除SkBbLabel
     * 
     * @param names 需要删除的SkBbLabelID
     * @return 结果
     */
    public int deleteSkBbLabelByIds(String[] names);

    /**
     * 删除SkBbLabel信息
     * 
     * @param name SkBbLabelID
     * @return 结果
     */
    public int deleteSkBbLabelById(String name);
    public String importData(List<SkBbLabelData> skBbLabel);
}
