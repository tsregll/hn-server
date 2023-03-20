package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeThreeFairs;

/**
 * 三公经费Mapper接口
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public interface BusinessAdministrativeThreeFairsMapper 
{
    /**
     * 查询三公经费
     * 
     * @param id 三公经费ID
     * @return 三公经费
     */
    public BusinessAdministrativeThreeFairs selectBusinessAdministrativeThreeFairsById(Long id);

    /**
     * 查询三公经费列表
     * 
     * @param businessAdministrativeThreeFairs 三公经费
     * @return 三公经费集合
     */
    public List<BusinessAdministrativeThreeFairs> selectBusinessAdministrativeThreeFairsList(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs);

    /**
     * 新增三公经费
     * 
     * @param businessAdministrativeThreeFairs 三公经费
     * @return 结果
     */
    public int insertBusinessAdministrativeThreeFairs(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs);

    /**
     * 修改三公经费
     * 
     * @param businessAdministrativeThreeFairs 三公经费
     * @return 结果
     */
    public int updateBusinessAdministrativeThreeFairs(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs);

    /**
     * 删除三公经费
     * 
     * @param id 三公经费ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeThreeFairsById(Long id);

    /**
     * 批量删除三公经费
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeThreeFairsByIds(Long[] ids);
}
