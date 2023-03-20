package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import com.ruoyi.business.domain.BusinessDevelopmentProjectIntroduction;
import com.ruoyi.business.service.IBusinessDevelopmentProjectIntroductionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规划发展项目介绍后台Controller
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
@RestController
@RequestMapping("/business/introduction")
public class BusinessDevelopmentProjectIntroductionController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentProjectIntroductionService businessDevelopmentProjectIntroductionService;

    /**
     * 查询规划发展项目介绍后台列表
     */
//    @PreAuthorize("@ss.hasPermi('business:introduction:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        startPage();
        if("请选择".equals(businessDevelopmentProjectIntroduction.getOperator())){
            businessDevelopmentProjectIntroduction.setOperator("");
        }
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("".equals(businessDevelopmentProjectIntroduction.getDefaultTime())||businessDevelopmentProjectIntroduction.getDefaultTime()==null){
            businessDevelopmentProjectIntroduction.setDefaultTime(date);
        }
        List<BusinessDevelopmentProjectIntroduction> list = businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionList(businessDevelopmentProjectIntroduction);
        TableDataInfo dataTable = getDataTable(list);
        dataTable.setMsg(businessDevelopmentProjectIntroduction.getDefaultTime());
        return dataTable;
    }

    /**
     * 查询规划发展项目介绍后台列表
     */
//    @PreAuthorize("@ss.hasPermi('business:introduction:list')")
    @GetMapping("/select")
    public AjaxResult select(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        if("请选择".equals(businessDevelopmentProjectIntroduction.getOperator())){
            businessDevelopmentProjectIntroduction.setOperator("");
        }
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("".equals(businessDevelopmentProjectIntroduction.getDefaultTime())||businessDevelopmentProjectIntroduction.getDefaultTime()==null){
            businessDevelopmentProjectIntroduction.setDefaultTime(date);
        }
        BusinessDevelopmentProjectIntroduction selectBusinessDevelopmentProjectIntroduction = businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroduction(businessDevelopmentProjectIntroduction);
        return AjaxResult.success(selectBusinessDevelopmentProjectIntroduction);
    }

    /**
     * 导出规划发展项目介绍后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:introduction:export')")
    @Log(title = "规划发展项目介绍后台", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        List<BusinessDevelopmentProjectIntroduction> list = businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionList(businessDevelopmentProjectIntroduction);
        ExcelUtil<BusinessDevelopmentProjectIntroduction> util = new ExcelUtil<BusinessDevelopmentProjectIntroduction>(BusinessDevelopmentProjectIntroduction.class);
        return util.exportExcel(list, "introduction");
    }

    /**
     * 获取规划发展项目介绍后台详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:introduction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionById(id));
    }

    /**
     * 获取规划发展项目介绍后台详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:introduction:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo2()
    {
        return AjaxResult.success(businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionByVoid());
    }

    /**
     * 获得操作人列表
     */
    @GetMapping("/operatorList")
    public TableDataInfo operatorList(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        startPage();
        List<String> list = businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionOperatorByGroupList(businessDevelopmentProjectIntroduction);
        return getDataTable(list);
    }

    /**
     * 新增规划发展项目介绍后台
     */
    @PreAuthorize("@ss.hasPermi('business:introduction:add')")
    @Log(title = "规划发展项目介绍后台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        BusinessDevelopmentProjectIntroduction temp = new BusinessDevelopmentProjectIntroduction();
        temp.setDefaultTime(businessDevelopmentProjectIntroduction.getDefaultTime().substring(0,4));
        temp.setProjectType(businessDevelopmentProjectIntroduction.getProjectType());
        List<BusinessDevelopmentProjectIntroduction> list = businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionList(temp);
        if(list.size()>0){
            return AjaxResult.error("当前数据本年的已录入，请勿重复录入！");
        }
        return toAjax(businessDevelopmentProjectIntroductionService.insertBusinessDevelopmentProjectIntroduction(businessDevelopmentProjectIntroduction));
    }

    /**
     * 修改规划发展项目介绍后台
     */
    @PreAuthorize("@ss.hasPermi('business:introduction:edit')")
    @Log(title = "规划发展项目介绍后台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        BusinessDevelopmentProjectIntroduction temp = new BusinessDevelopmentProjectIntroduction();
        temp.setDefaultTime(businessDevelopmentProjectIntroduction.getDefaultTime().substring(0,4));
        temp.setProjectType(businessDevelopmentProjectIntroduction.getProjectType());
        List<BusinessDevelopmentProjectIntroduction> list = businessDevelopmentProjectIntroductionService.selectBusinessDevelopmentProjectIntroductionList(temp);
        if(list.size()>0){
            if(list.get(0).getId()!=businessDevelopmentProjectIntroduction.getId()){
                return AjaxResult.error("当前数据本年的已录入，请勿重复录入！");
            }
        }
        return toAjax(businessDevelopmentProjectIntroductionService.updateBusinessDevelopmentProjectIntroduction(businessDevelopmentProjectIntroduction));
    }

    /**
     * 删除规划发展项目介绍后台
     */
    @PreAuthorize("@ss.hasPermi('business:introduction:remove')")
    @Log(title = "规划发展项目介绍后台", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentProjectIntroductionService.deleteBusinessDevelopmentProjectIntroductionByIds(ids));
    }
}
