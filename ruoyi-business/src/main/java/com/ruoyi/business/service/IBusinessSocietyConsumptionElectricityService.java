package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;
import com.ruoyi.business.vo.ConsumptionElectricityFiveVo;
import com.ruoyi.business.vo.ConsumptionElectricityVo;
import com.ruoyi.business.vo.StatisticsOneYearVo;

/**
 * 全社会用电量情况Service接口
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
public interface IBusinessSocietyConsumptionElectricityService 
{
    /**
     * 查询全社会用电量情况
     * 
     * @param id 全社会用电量情况ID
     * @return 全社会用电量情况
     */
    public BusinessSocietyConsumptionElectricity selectBusinessSocietyConsumptionElectricityById(Long id);

    /**
     * 查询全社会用电量情况列表
     * 
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 全社会用电量情况集合
     */
    public List<BusinessSocietyConsumptionElectricity> selectBusinessSocietyConsumptionElectricityList(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 查询全社会用电量情况列表
     *
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 全社会用电量情况集合
     */
    public List<BusinessSocietyConsumptionElectricity> selectByTimeSocietyConsumptionElectricityList(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 新增全社会用电量情况
     * 
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 结果
     */
    public int insertBusinessSocietyConsumptionElectricity(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 修改全社会用电量情况
     * 
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 结果
     */
    public int updateBusinessSocietyConsumptionElectricity(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 批量删除全社会用电量情况
     * 
     * @param ids 需要删除的全社会用电量情况ID
     * @return 结果
     */
    public int deleteBusinessSocietyConsumptionElectricityByIds(Long[] ids);

    /**
     * 删除全社会用电量情况信息
     * 
     * @param id 全社会用电量情况ID
     * @return 结果
     */
    public int deleteBusinessSocietyConsumptionElectricityById(Long id);

    /**
     * 查询用电量与同比用电量（传入年数or传入类型）
     * @param businessSocietyConsumptionElectricity
     * @return
     */
    public ConsumptionElectricityVo selectFiveByType(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 查询近五年用电量
     * @return
     */
    public List<ConsumptionElectricityFiveVo> selectFive();
    /**
     * 查询一年内用电量
     * @return
     */
    public Map<String,Object> selectOneYear(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 导入
     * @param bsce 导入的数据集
     * @return 结果
     */
    public String importDatas(List<BusinessSocietyConsumptionElectricity> bsce);
    /**
     * 通过月份查询图表
     * @param bsce 查询条件
     * @return 结果Vo
     */
    public Map<String,Object> selectByTable(BusinessSocietyConsumptionElectricity bsce);
}
