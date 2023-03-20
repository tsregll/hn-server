package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessHeartScore;

/**
 * 供热年度绩效Service接口
 * 
 * @author ruoyi
 * @date 2021-03-02
 */
public interface IBusinessHeartScoreService 
{
    /**
     * 查询供热年度绩效
     * 
     * @param id 供热年度绩效ID
     * @return 供热年度绩效
     */
    public BusinessHeartScore selectBusinessHeartScoreById(Long id);

    /**
     * 查询供热年度绩效列表
     * 
     * @param businessHeartScore 供热年度绩效
     * @return 供热年度绩效集合
     */
    public List<BusinessHeartScore> selectBusinessHeartScoreList(BusinessHeartScore businessHeartScore);

    /**
     * 新增供热年度绩效
     * 
     * @param businessHeartScore 供热年度绩效
     * @return 结果
     */
    public int insertBusinessHeartScore(BusinessHeartScore businessHeartScore);

    /**
     * 修改供热年度绩效
     * 
     * @param businessHeartScore 供热年度绩效
     * @return 结果
     */
    public int updateBusinessHeartScore(BusinessHeartScore businessHeartScore);

    /**
     * 批量删除供热年度绩效
     * 
     * @param ids 需要删除的供热年度绩效ID
     * @return 结果
     */
    public int deleteBusinessHeartScoreByIds(Long[] ids);

    /**
     * 删除供热年度绩效信息
     * 
     * @param id 供热年度绩效ID
     * @return 结果
     */
    public int deleteBusinessHeartScoreById(Long id);
}
