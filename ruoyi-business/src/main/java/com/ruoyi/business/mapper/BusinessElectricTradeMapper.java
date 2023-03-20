package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessElectricTrade;
import org.apache.ibatis.annotations.Param;

/**
 * 电量及电价市场交易Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-27
 */
public interface BusinessElectricTradeMapper 
{
    /**
     * 查询电量及电价市场交易
     * 
     * @param id 电量及电价市场交易ID
     * @return 电量及电价市场交易
     */
    public BusinessElectricTrade selectBusinessElectricTradeById(Long id);

    /**
     * 查询电量及电价市场交易列表
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 电量及电价市场交易集合
     */
    public List<BusinessElectricTrade> selectBusinessElectricTradeList(BusinessElectricTrade businessElectricTrade);
    /**
     * 按时间区域查询市场交易明细列表
     *
     * @param businessElectricTrade 电量及电价市场交易
     * @return 电量及电价市场交易集合
     */
    public List<BusinessElectricTrade> selectByTimeElectricTradeList(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("bet")BusinessElectricTrade businessElectricTrade);
    /**
     * 按时间区域查询集团电量累加交易列表
     *
     * @param businessElectricTrade 电量及电价市场交易
     * @return 电量及电价市场交易集合
     */
    public List<BusinessElectricTrade> selectByTimeTradeConsumptionList(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("bet")BusinessElectricTrade businessElectricTrade);

    /**
     * 新增电量及电价市场交易
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    public int insertBusinessElectricTrade(BusinessElectricTrade businessElectricTrade);

    /**
     * 修改电量及电价市场交易
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    public int updateBusinessElectricTrade(BusinessElectricTrade businessElectricTrade);

    /**
     * 删除电量及电价市场交易
     * 
     * @param id 电量及电价市场交易ID
     * @return 结果
     */
    public int deleteBusinessElectricTradeById(Long id);

    /**
     * 批量删除电量及电价市场交易
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessElectricTradeByIds(Long[] ids);
}
