package com.ruoyi.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessElectricTrade;
import com.ruoyi.business.vo.NewElectricTradeVo;

/**
 * 电量及电价市场交易Service接口
 * 
 * @author ruoyi
 * @date 2021-04-27
 */
public interface IBusinessElectricTradeService 
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

    public List<BusinessElectricTrade> selectByTimeElectricTradeList(BusinessElectricTrade businessElectricTrade);

    /**
     * 新增电量及电价市场交易
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    public int insertBusinessElectricTrade(BusinessElectricTrade businessElectricTrade,Map<String,Double> sjMap);

    /**
     * 修改电量及电价市场交易
     * 
     * @param businessElectricTrade 电量及电价市场交易
     * @return 结果
     */
    public int updateBusinessElectricTrade(BusinessElectricTrade businessElectricTrade);

    /**
     * 批量删除电量及电价市场交易
     * 
     * @param ids 需要删除的电量及电价市场交易ID
     * @return 结果
     */
    public int deleteBusinessElectricTradeByIds(Long[] ids);

    /**
     * 删除电量及电价市场交易信息
     * 
     * @param id 电量及电价市场交易ID
     * @return 结果
     */
    public int deleteBusinessElectricTradeById(Long id);
    /**
     * 查询全省月度市场交易情况柱状图
     *
     * @param electricTradeTime
     * @return 结果
     */
    public Map<String, Object> selectByMonthTradePillar(String electricTradeTime);
//  表格
    List<BusinessElectricTrade> selectByMonthTradeTable(String electricTradeTime);
    /**
     * 查询全省月度市场交易情况柱状图
     *
     * @param electricTradeTime
     * @return 结果
     */
    public Map<String, Object> selectByYearTradePillar(String electricTradeTime);

    List<BusinessElectricTrade> selectByYearTradeTable(String electricTradeTime);
    /**
     * 查市场交易情况明细
     *
     * @param electricTradeTime
     * @return 结果
     */
    List<HashMap<String,String>> selectGroupByMonthTrade(String electricTradeTime);
    /**
     * 查询统调对标月度市场交易情况柱状图
     *
     * @param electricTradeTime
     * @return 结果
     */
    Map<String, Object> tdSelectByMonthTradePillar(String electricTradeTime,List<Double> doubles);

    List<NewElectricTradeVo> tdSelectByMonthTradeTable(String electricTradeTime, List<Double> doubles);

    Map<String, Object> tdSelectByYearTradePillar(String electricTradeTime, List<Double> doubles);

    List<NewElectricTradeVo> tdSelectByYearTradeTable(String electricTradeTime, List<Double> doubles);
}
