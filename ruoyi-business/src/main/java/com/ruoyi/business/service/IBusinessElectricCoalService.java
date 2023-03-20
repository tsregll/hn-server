package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessElectricCoal;

/**
 * 煤机发电总貌Service接口
 * 
 * @author lpf
 * @date 2021-03-02
 */
public interface IBusinessElectricCoalService 
{
    /**
     * 查询煤机发电总貌
     * 
     * @param id 煤机发电总貌ID
     * @return 煤机发电总貌
     */
    public BusinessElectricCoal selectBusinessElectricCoalById(Long id);

    /**
     * 查询煤机发电总貌列表
     * 
     * @param businessElectricCoal 煤机发电总貌
     * @return 煤机发电总貌集合
     */
    public List<BusinessElectricCoal> selectBusinessElectricCoalList(BusinessElectricCoal businessElectricCoal);

    /**
     * 新增煤机发电总貌
     * 
     * @param businessElectricCoal 煤机发电总貌
     * @return 结果
     */
    public int insertBusinessElectricCoal(BusinessElectricCoal businessElectricCoal);

    /**
     * 修改煤机发电总貌
     * 
     * @param businessElectricCoal 煤机发电总貌
     * @return 结果
     */
    public int updateBusinessElectricCoal(BusinessElectricCoal businessElectricCoal);

    /**
     * 批量删除煤机发电总貌
     * 
     * @param ids 需要删除的煤机发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricCoalByIds(Long[] ids);

    /**
     * 删除煤机发电总貌信息
     * 
     * @param id 煤机发电总貌ID
     * @return 结果
     */
    public int deleteBusinessElectricCoalById(Long id);
}
