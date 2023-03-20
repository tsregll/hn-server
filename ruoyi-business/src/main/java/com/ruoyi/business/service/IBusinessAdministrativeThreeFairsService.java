package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessAdministrativeThreeFairs;

/**
 * 三公经费Service接口
 * 
 * @author gwsh
 * @date 2021-03-02
 */
public interface IBusinessAdministrativeThreeFairsService 
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
     * 批量删除三公经费
     * 
     * @param ids 需要删除的三公经费ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeThreeFairsByIds(Long[] ids);

    /**
     * 删除三公经费信息
     * 
     * @param id 三公经费ID
     * @return 结果
     */
    public int deleteBusinessAdministrativeThreeFairsById(Long id);
}
