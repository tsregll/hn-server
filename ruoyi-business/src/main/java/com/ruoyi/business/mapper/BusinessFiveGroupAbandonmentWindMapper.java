package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessFiveGroupAbandonmentWind;

/**
 * 五大发电集团月度弃风情况Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public interface BusinessFiveGroupAbandonmentWindMapper 
{
    /**
     * 查询五大发电集团月度弃风情况
     * 
     * @param id 五大发电集团月度弃风情况ID
     * @return 五大发电集团月度弃风情况
     */
    public BusinessFiveGroupAbandonmentWind selectBusinessFiveGroupAbandonmentWindById(Long id);

    /**
     * 查询五大发电集团月度弃风情况列表
     * 
     * @param businessFiveGroupAbandonmentWind 五大发电集团月度弃风情况
     * @return 五大发电集团月度弃风情况集合
     */
    public List<BusinessFiveGroupAbandonmentWind> selectBusinessFiveGroupAbandonmentWindList(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind);

    /**
     * 查询五大发电集团月度弃风情况列表
     *
     * @param businessFiveGroupAbandonmentWind 五大发电集团月度弃风情况
     * @return 五大发电集团月度弃风情况集合
     */
    public List<BusinessFiveGroupAbandonmentWind> selectByTimeFiveGroupAbandonmentWindList(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind);

    /**
     * 新增五大发电集团月度弃风情况
     * 
     * @param businessFiveGroupAbandonmentWind 五大发电集团月度弃风情况
     * @return 结果
     */
    public int insertBusinessFiveGroupAbandonmentWind(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind);

    /**
     * 修改五大发电集团月度弃风情况
     * 
     * @param businessFiveGroupAbandonmentWind 五大发电集团月度弃风情况
     * @return 结果
     */
    public int updateBusinessFiveGroupAbandonmentWind(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind);

    /**
     * 删除五大发电集团月度弃风情况
     * 
     * @param id 五大发电集团月度弃风情况ID
     * @return 结果
     */
    public int deleteBusinessFiveGroupAbandonmentWindById(Long id);

    /**
     * 批量删除五大发电集团月度弃风情况
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessFiveGroupAbandonmentWindByIds(Long[] ids);
}
