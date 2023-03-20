package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;

/**
 * 全社会用电量情况Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
public interface BusinessSocietyConsumptionElectricityMapper 
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
     * 查询全社会用电量情况列表
     *
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 全社会用电量情况集合
     */
    public List<BusinessSocietyConsumptionElectricity> selectBusinessSocietyConsumptionElectricityListOrderByDateTime(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);
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
     * 删除全社会用电量情况
     *
     * @param id 全社会用电量情况ID
     * @return 结果
     */
    public int deleteBusinessSocietyConsumptionElectricityById(Long id);

    /**
     * 批量删除全社会用电量情况
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessSocietyConsumptionElectricityByIds(Long[] ids);

    /**
     * 查询用电量与同比用电量（传入年数or传入类型）
     * @param businessSocietyConsumptionElectricity
     * @return
     */
    public List<BusinessSocietyConsumptionElectricity> selectFiveByType(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);

    /**
     * 查询全社会用电量情况列表
     *
     * @param businessSocietyConsumptionElectricity 全社会用电量情况
     * @return 全社会用电量情况集合
     */
    public List<BusinessSocietyConsumptionElectricity> selectElectricityList(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);
//
//    /**
//     * 查询用电量与同比用电量（传入年数or传入类型）
//     * @param businessSocietyConsumptionElectricity
//     * @return
//     */
//    public List<BusinessSocietyConsumptionElectricity> selectFive(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity);
}
