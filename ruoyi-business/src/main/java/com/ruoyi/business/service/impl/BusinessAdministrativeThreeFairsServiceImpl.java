package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessAdministrativeThreeFairsMapper;
import com.ruoyi.business.domain.BusinessAdministrativeThreeFairs;
import com.ruoyi.business.service.IBusinessAdministrativeThreeFairsService;

/**
 * 三公经费Service业务层处理
 * 
 * @author gwsh
 * @date 2021-03-02
 */
@Service
public class BusinessAdministrativeThreeFairsServiceImpl implements IBusinessAdministrativeThreeFairsService 
{
    @Autowired
    private BusinessAdministrativeThreeFairsMapper businessAdministrativeThreeFairsMapper;

    /**
     * 查询三公经费
     * 
     * @param id 三公经费ID
     * @return 三公经费
     */
    @Override
    public BusinessAdministrativeThreeFairs selectBusinessAdministrativeThreeFairsById(Long id)
    {
        return businessAdministrativeThreeFairsMapper.selectBusinessAdministrativeThreeFairsById(id);
    }

    /**
     * 查询三公经费列表
     * 
     * @param businessAdministrativeThreeFairs 三公经费
     * @return 三公经费
     */
    @Override
    public List<BusinessAdministrativeThreeFairs> selectBusinessAdministrativeThreeFairsList(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs)
    {
        return businessAdministrativeThreeFairsMapper.selectBusinessAdministrativeThreeFairsList(businessAdministrativeThreeFairs);
    }

    /**
     * 新增三公经费
     * 
     * @param businessAdministrativeThreeFairs 三公经费
     * @return 结果
     */
    @Override
    public int insertBusinessAdministrativeThreeFairs(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs)
    {
        businessAdministrativeThreeFairs.setCreateTime(DateUtils.getNowDate());
        return businessAdministrativeThreeFairsMapper.insertBusinessAdministrativeThreeFairs(businessAdministrativeThreeFairs);
    }

    /**
     * 修改三公经费
     * 
     * @param businessAdministrativeThreeFairs 三公经费
     * @return 结果
     */
    @Override
    public int updateBusinessAdministrativeThreeFairs(BusinessAdministrativeThreeFairs businessAdministrativeThreeFairs)
    {
        businessAdministrativeThreeFairs.setUpdateTime(DateUtils.getNowDate());
        return businessAdministrativeThreeFairsMapper.updateBusinessAdministrativeThreeFairs(businessAdministrativeThreeFairs);
    }

    /**
     * 批量删除三公经费
     * 
     * @param ids 需要删除的三公经费ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeThreeFairsByIds(Long[] ids)
    {
        return businessAdministrativeThreeFairsMapper.deleteBusinessAdministrativeThreeFairsByIds(ids);
    }

    /**
     * 删除三公经费信息
     * 
     * @param id 三公经费ID
     * @return 结果
     */
    @Override
    public int deleteBusinessAdministrativeThreeFairsById(Long id)
    {
        return businessAdministrativeThreeFairsMapper.deleteBusinessAdministrativeThreeFairsById(id);
    }
}
