package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessParcelCompanyAbandonmentWind;

/**
 * 分公司各风场弃风情况月度Mapper接口
 * 
 * @author yrb
 * @date 2021-03-22
 */
public interface BusinessParcelCompanyAbandonmentWindMapper 
{
    /**
     * 查询分公司各风场弃风情况月度
     * 
     * @param id 分公司各风场弃风情况月度ID
     * @return 分公司各风场弃风情况月度
     */
    public BusinessParcelCompanyAbandonmentWind selectBusinessParcelCompanyAbandonmentWindById(Long id);

    /**
     * 查询分公司各风场弃风情况月度列表
     * 
     * @param businessParcelCompanyAbandonmentWind 分公司各风场弃风情况月度
     * @return 分公司各风场弃风情况月度集合
     */
    public List<BusinessParcelCompanyAbandonmentWind> selectBusinessParcelCompanyAbandonmentWindList(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind);

    /**
     * 查询分公司各风场弃风情况月度列表
     *
     * @param businessParcelCompanyAbandonmentWind 分公司各风场弃风情况月度
     * @return 分公司各风场弃风情况月度集合
     */
    public List<BusinessParcelCompanyAbandonmentWind> selectByTimesParcelCompanyAbandonmentWindList(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind);

    /**
     * 新增分公司各风场弃风情况月度
     * 
     * @param businessParcelCompanyAbandonmentWind 分公司各风场弃风情况月度
     * @return 结果
     */
    public int insertBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind);

    /**
     * 修改分公司各风场弃风情况月度
     * 
     * @param businessParcelCompanyAbandonmentWind 分公司各风场弃风情况月度
     * @return 结果
     */
    public int updateBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind);

    /**
     * 删除分公司各风场弃风情况月度
     * 
     * @param id 分公司各风场弃风情况月度ID
     * @return 结果
     */
    public int deleteBusinessParcelCompanyAbandonmentWindById(Long id);

    /**
     * 批量删除分公司各风场弃风情况月度
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessParcelCompanyAbandonmentWindByIds(Long[] ids);
}
