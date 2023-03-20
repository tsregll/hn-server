package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessAreaIndex;

/**
 * 区域年度指标录入Mapper接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface BusinessAreaIndexMapper 
{
    /**
     * 查询区域年度指标录入
     * 
     * @param id 区域年度指标录入ID
     * @return 区域年度指标录入
     */
    public BusinessAreaIndex selectBusinessAreaIndexById(Long id);

    /**
     * 查询区域年度指标录入列表
     * 
     * @param businessAreaIndex 区域年度指标录入
     * @return 区域年度指标录入集合
     */
    public List<BusinessAreaIndex> selectBusinessAreaIndexList(BusinessAreaIndex businessAreaIndex);

    /**
     * 新增区域年度指标录入
     * 
     * @param businessAreaIndex 区域年度指标录入
     * @return 结果
     */
    public int insertBusinessAreaIndex(BusinessAreaIndex businessAreaIndex);

    /**
     * 修改区域年度指标录入
     * 
     * @param businessAreaIndex 区域年度指标录入
     * @return 结果
     */
    public int updateBusinessAreaIndex(BusinessAreaIndex businessAreaIndex);

    /**
     * 删除区域年度指标录入
     * 
     * @param id 区域年度指标录入ID
     * @return 结果
     */
    public int deleteBusinessAreaIndexById(Long id);

    /**
     * 批量删除区域年度指标录入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessAreaIndexByIds(Long[] ids);
}
