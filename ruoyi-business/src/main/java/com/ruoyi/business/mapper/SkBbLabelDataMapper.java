package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.SkBbLabelData;

/**
 * SkBbLabelMapper接口
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
public interface SkBbLabelDataMapper
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
     * 删除SkBbLabel
     * 
     * @param name SkBbLabelID
     * @return 结果
     */
    public int deleteSkBbLabelById(String name);

    /**
     * 批量删除SkBbLabel
     * 
     * @param names 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkBbLabelByIds(String[] names);
}
