package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessAdministrativeDecision;
import com.ruoyi.business.domain.BusinessInstallationStatistics;
import com.ruoyi.business.vo.BusinessInstallationStatisticsVo;
import com.ruoyi.business.vo.StatisticsFiveVo;
import com.ruoyi.business.vo.StatisticsVo;
import com.ruoyi.common.core.service.IBaseService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 装机统计Service接口
 *
 * @author yrb
 * @date 2021-03-10
 */
public interface IBusinessInstallationStatisticsService extends IBaseService<BusinessInstallationStatistics> {
    /**
     * 查询装机统计
     *
     * @param id 装机统计ID
     * @return 装机统计
     */
    public BusinessInstallationStatistics selectBusinessInstallationStatisticsById(Long id);
    /**
     * 导入装机统计
     *
     * @param list 导入的对象组
     * @return 结果
     */
    public String importDatas(List<BusinessInstallationStatistics> list);

    /**
     * 查询装机统计列表
     *
     * @param businessInstallationStatistics 装机统计
     * @return 装机统计集合
     */
    public List<BusinessInstallationStatistics> selectBusinessInstallationStatisticsList(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 查询装机统计列表
     *
     * @param businessInstallationStatistics 装机统计
     * @return 装机统计集合
     */
    public List<BusinessInstallationStatistics> selectByTimeInstallationStatisticsList(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 新增装机统计
     *
     * @param businessInstallationStatistics 装机统计
     * @return 结果
     */
    public int insertBusinessInstallationStatistics(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 修改装机统计
     *
     * @param businessInstallationStatistics 装机统计
     * @return 结果
     */
    public int updateBusinessInstallationStatistics(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 批量删除装机统计
     *
     * @param ids 需要删除的装机统计ID
     * @return 结果
     */
    public int deleteBusinessInstallationStatisticsByIds(Long[] ids);

    /**
     * 删除装机统计信息
     *
     * @param id 装机统计ID
     * @return 结果
     */
    public int deleteBusinessInstallationStatisticsById(Long id);

    /**
     * 查询统调装机统计
     *
     * @param businessInstallationStatistics 装机统计
     * @return 统调装机统计Vo
     */
    public Map<String,Object> selectStatistics(BusinessInstallationStatistics businessInstallationStatistics);


    /**
     * 查询近五年的装机统计
     *
     * @return 查询结果
     */
    public Map<String,Object> selectFiveInstallationStatisticsByYear(BusinessInstallationStatistics businessInstallationStatistics);

    /**
     * 通过年or类型查询总和（饼状图）
     *
     * @param businessInstallationStatistics 查询条件对象
     * @return 数据
     */
    public Map<String,Object> selectByYearOrType(BusinessInstallationStatistics businessInstallationStatistics);
}
