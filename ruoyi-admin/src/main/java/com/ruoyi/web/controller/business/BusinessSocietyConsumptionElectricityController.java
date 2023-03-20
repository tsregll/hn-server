package com.ruoyi.web.controller.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.vo.ConsumptionElectricityFiveVo;
import com.ruoyi.business.vo.ConsumptionElectricityVo;
import com.ruoyi.business.vo.drmb.SocietyConsumptionElectricityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessSocietyConsumptionElectricity;
import com.ruoyi.business.service.IBusinessSocietyConsumptionElectricityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 全社会用电量情况Controller
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@Api(value = "BusinessSocietyConsumptionElectricityController", tags = "全社会用电量接口")
@RestController
@RequestMapping("/business/businesssocietyelectricity")
public class BusinessSocietyConsumptionElectricityController extends BaseController
{
    @Autowired
    private IBusinessSocietyConsumptionElectricityService businessSocietyConsumptionElectricityService;

    /**
     * 查询全社会用电量情况列表
     */
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        startPage();
//        List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityService.selectBusinessSocietyConsumptionElectricityList(businessSocietyConsumptionElectricity);
        List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityService.selectByTimeSocietyConsumptionElectricityList(businessSocietyConsumptionElectricity);
        return getDataTable(list);
    }

    /**
     * 导出全社会用电量情况列表
     */
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:export')")
    @Log(title = "全社会用电量情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        List<BusinessSocietyConsumptionElectricity> list = businessSocietyConsumptionElectricityService.selectByTimeSocietyConsumptionElectricityList(businessSocietyConsumptionElectricity);
        ExcelUtil<BusinessSocietyConsumptionElectricity> util = new ExcelUtil<BusinessSocietyConsumptionElectricity>(BusinessSocietyConsumptionElectricity.class);
        return util.exportExcel(list, "electricity");
    }

    /**
     * 获取全社会用电量情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessSocietyConsumptionElectricityService.selectBusinessSocietyConsumptionElectricityById(id));
    }

    /**
     * 新增全社会用电量情况
     */
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:add')")
    @Log(title = "全社会用电量情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        BusinessSocietyConsumptionElectricity be = new BusinessSocietyConsumptionElectricity();
        be.setEnteringDate(businessSocietyConsumptionElectricity.getEnteringDate());
        be.setIndustryType(businessSocietyConsumptionElectricity.getIndustryType());
        int count = businessSocietyConsumptionElectricityService.selectBusinessSocietyConsumptionElectricityList(be).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessSocietyConsumptionElectricityService.insertBusinessSocietyConsumptionElectricity(businessSocietyConsumptionElectricity));
    }

    /**
     * 修改全社会用电量情况
     */
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:edit')")
    @Log(title = "全社会用电量情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        return toAjax(businessSocietyConsumptionElectricityService.updateBusinessSocietyConsumptionElectricity(businessSocietyConsumptionElectricity));
    }

    /**
     * 删除全社会用电量情况
     */
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:remove')")
    @Log(title = "全社会用电量情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessSocietyConsumptionElectricityService.deleteBusinessSocietyConsumptionElectricityByIds(ids));
    }

    /**
     * 查询全社会用电量情况列表
     */
    @ApiOperation(value = "全社会用电量接口（通过类别查询的柱状图）")
    @GetMapping("/selectFiveByType")
    public AjaxResult selectFiveByType(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        ConsumptionElectricityVo list = businessSocietyConsumptionElectricityService.selectFiveByType(businessSocietyConsumptionElectricity);
        return AjaxResult.success(list);
    }

    /**
     * 查询全社会用电量情况列表
     */
    @ApiOperation(value = "全社会用电量接口（最近五年全国电力消费构成0：全社会用电量、1：第一产业、2：第二产业、3：第三产业、4：城乡居民）")
    @GetMapping("/selectFive")
    public AjaxResult selectFive()
    {
        List<ConsumptionElectricityFiveVo> list = businessSocietyConsumptionElectricityService.selectFive();
        Map<String,Object> map = new HashMap<>();
        String[] year = new String[5];
        int y = LocalDate.now().getYear()-4;
        for (int i=0;i<5;i++){
            year[i] = (y+i)+"";
        }
        map.put("datas",list);
        map.put("year",year);
        return AjaxResult.success(map);
    }

    /**
     * 查询全社会用电量情况列表
     */
    @ApiOperation(value = "全社会一年用电量接口")
    @GetMapping("/selectByTypeOrYear")
    public AjaxResult selectByTypeOrYear(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        Map<String,Object> list = businessSocietyConsumptionElectricityService.selectOneYear(businessSocietyConsumptionElectricity);
        return AjaxResult.success(list);
    }

    /**
     * 查询全社会用电量情况列表
     */
    @ApiOperation(value = "全社会用电量情况统计（表格）")
    @GetMapping("/selectByTable")
    public AjaxResult selectByTable(BusinessSocietyConsumptionElectricity businessSocietyConsumptionElectricity)
    {
        Map<String,Object> list = businessSocietyConsumptionElectricityService.selectByTable(businessSocietyConsumptionElectricity);
        return AjaxResult.success(list);
    }

    /**
     * 导入社会用电量
     */
    @ApiOperation(value = "导入社会用电量")
    @Log(title = "导入社会用电量", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:businesssocietyelectricity:import')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<BusinessSocietyConsumptionElectricity> util = new ExcelUtil<BusinessSocietyConsumptionElectricity>(BusinessSocietyConsumptionElectricity.class);
        List<BusinessSocietyConsumptionElectricity> bsce = util.importExcel(file.getInputStream());
        String message = businessSocietyConsumptionElectricityService.importDatas(bsce);
        return AjaxResult.success(message);
    }

/*    @ApiOperation(value = "导入社会用电量的模板")
    @GetMapping("/importbusinesssocietyelectricity")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessSocietyConsumptionElectricity> util = new ExcelUtil<BusinessSocietyConsumptionElectricity>(BusinessSocietyConsumptionElectricity.class);
        return util.importTemplateExcel("社会用电量数据");
    }*/

    @ApiOperation(value = "导入社会用电量的模板")
    @GetMapping("/importbusinesssocietyelectricity")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<SocietyConsumptionElectricityVo> util = new ExcelUtil<SocietyConsumptionElectricityVo>(SocietyConsumptionElectricityVo.class);
        List<SocietyConsumptionElectricityVo> list =new ArrayList<>();
        for (Integer group = 0; group <5 ; group++) {
            SocietyConsumptionElectricityVo bet = new SocietyConsumptionElectricityVo();
            String name = group.toString();
            bet.setIndustryType(name);
            list.add(bet);
        }
        return util.exportExcel(list,"社会用电量数据");
    }
}
