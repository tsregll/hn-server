package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessParcelCompanyAbandonmentWind;

/**
 * 分公司各风场弃风情况月度Service接口
 * 
 * @author yrb
 * @date 2021-03-22
 */
public interface IBusinessParcelCompanyAbandonmentWindService 
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
     * @param bpc 分公司各风场弃风情况月度
     * @param sum 中台查询的数据
     * @return 结果
     */
    public int insertBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind bpc, Map<String,Double> sum);
    /**
     * 修改分公司各风场弃风情况月度
     *
     * @param businessParcelCompanyAbandonmentWind 分公司各风场弃风情况月度
     * @return 结果
     */
    public int updateBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind);

    /**
     * 修改分公司各风场弃风情况月度
     *
     * @param bpc 分公司各风场弃风情况月度
     * @param sum 中台查询的数据
     * @return 结果
     */
    public int updateBusinessParcelCompanyAbandonmentWind(BusinessParcelCompanyAbandonmentWind bpc,Map<String,Double> sum);

    /**
     * 批量删除分公司各风场弃风情况月度
     *
     * @param ids 需要删除的分公司各风场弃风情况月度ID
     * @return 结果
     */
    public int deleteBusinessParcelCompanyAbandonmentWindByIds(Long[] ids);

    /**
     * 删除分公司各风场弃风情况月度信息
     *
     * @param id 分公司各风场弃风情况月度ID
     * @return 结果
     */
    public int deleteBusinessParcelCompanyAbandonmentWindById(Long id);
    /**
     * 查询分公司弃风月度柱状图
     * @param abandonmentDate 查询月份
     * @return 返回结果
     */
    public Map<String,Object> selectByMonthOutPillar(String abandonmentDate);

    /**
     * 查询分公司弃风月度表格
     * @param abandonmentDate 查询月份
     * @return 返回结果
     */
    public List<Map<String,String>> selectByMonthOutTable(String abandonmentDate);

    /**
     * 查询分公司弃风年度柱状图
     * @param abandonmentDate 查询年份
     * @return 返回结果
     */
    public Map<String,Object> selectByYearOutPillar(String abandonmentDate);

    /**
     * 查询分公司弃风年度表格
     * @param abandonmentDate 查询年份
     * @return 返回结果对象集
     */
    public List<Map<String,String>>  selectByYearOutTable(String abandonmentDate);
}
