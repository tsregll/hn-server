package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.ServletUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
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
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectConfirmation;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentProjectConfirmationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划部取得开发权项目需求确认Controller
 * 
 * @author ruoyi
 * @date 2021-06-15
 */
//@Api(tags = "取得开发权项目需求确认接口")
@RestController
@RequestMapping("/business/confirmation")
public class BusinessPlanningDevelopmentProjectConfirmationController extends BaseController
{
    @Autowired
    private IBusinessPlanningDevelopmentProjectConfirmationService businessPlanningDevelopmentProjectConfirmationService;
    /**
     * 查询项目需求确认列表
     */
//    @ApiOperation(value = "获取项目需求确认列表", notes = "获取项目需求确认列表接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "父区域id，为空查询顶级", name = "parentId", required = false, dataType = "String"),
//            @ApiImplicitParam(value = "区域类型", name = "type", required = false, dataType = "String"),
//            @ApiImplicitParam(value = "风险等级", name = "riskLevel", required = false, dataType = "String"),
//            @ApiImplicitParam(value = "企业行业监管类型", name = "classificationIds", required = false, dataType = "String"),
//            @ApiImplicitParam(value = "关键字，按企业名称模糊查询", name = "keyword", required = false, dataType = "String"),
//            @ApiImplicitParam(value = "是否查询所有子集：0、否【默认值 】；1、是。", name = "all", required = false, dataType = "String")
//    })
    @PreAuthorize("@ss.hasPermi('business:confirmation:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("".equals(businessPlanningDevelopmentProjectConfirmation.getRemark())||businessPlanningDevelopmentProjectConfirmation.getRemark()==null){
            businessPlanningDevelopmentProjectConfirmation.setRemark(date);
        }
        List<BusinessPlanningDevelopmentProjectConfirmation> list = businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationList(businessPlanningDevelopmentProjectConfirmation);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessPlanningDevelopmentProjectConfirmation.getRemark()||"".equals(businessPlanningDevelopmentProjectConfirmation.getRemark())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessPlanningDevelopmentProjectConfirmation.getRemark());
        }
        return returnData;
    }

    /**
     * 查询项目需求确认列表v2(后台用)
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:list')")
    @GetMapping("/list2")
    public TableDataInfo list2(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        List<BusinessPlanningDevelopmentProjectConfirmation> list = businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationList2(businessPlanningDevelopmentProjectConfirmation);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessPlanningDevelopmentProjectConfirmation.getRemark()||"".equals(businessPlanningDevelopmentProjectConfirmation.getRemark())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessPlanningDevelopmentProjectConfirmation.getRemark());
        }
        return returnData;
    }

    /**
     * 导出项目需求确认列表
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:export')")
    @Log(title = "规划发展项目详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        List<BusinessPlanningDevelopmentProjectConfirmation> list = businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationList(businessPlanningDevelopmentProjectConfirmation);
        ExcelUtil<BusinessPlanningDevelopmentProjectConfirmation> util = new ExcelUtil<BusinessPlanningDevelopmentProjectConfirmation>(BusinessPlanningDevelopmentProjectConfirmation.class);
        return util.exportExcel(list, "confirmation");
    }

    /**
     * 获取项目需求确认详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:query')")
    @GetMapping("/getInfo")
    public AjaxResult getInfo()
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        loginUser.getUsername();
//        loginUser.getUser().getUserId();
//        BusinessPlanningDevelopmentProjectConfirmation returnResult=businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationById(id);
//        returnResult.setOperator(loginUser.getUsername());
//        returnResult.setOperatorNumber(loginUser.getUser().getUserId().toString());
//        returnResult.setDefaultTime();
//        "".split();
        return AjaxResult.success(businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationByVoid());
    }

    /**
     * 获取项目需求确认详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        loginUser.getUsername();
//        loginUser.getUser().getUserId();
//        BusinessPlanningDevelopmentProjectConfirmation returnResult=businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationById(id);
//        returnResult.setOperator(loginUser.getUsername());
//        returnResult.setOperatorNumber(loginUser.getUser().getUserId().toString());
//        returnResult.setDefaultTime();
        return AjaxResult.success(businessPlanningDevelopmentProjectConfirmationService.selectBusinessPlanningDevelopmentProjectConfirmationById(id));
    }

    /**
     * 新增规划发展项目详情
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:add')")
    @Log(title = "规划发展项目详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        return toAjax(businessPlanningDevelopmentProjectConfirmationService.insertBusinessPlanningDevelopmentProjectConfirmation(businessPlanningDevelopmentProjectConfirmation));
    }

    /**
     * 修改项目需求确认
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:edit')")
    @Log(title = "规划发展项目详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessPlanningDevelopmentProjectConfirmation businessPlanningDevelopmentProjectConfirmation)
    {
        return toAjax(businessPlanningDevelopmentProjectConfirmationService.updateBusinessPlanningDevelopmentProjectConfirmation(businessPlanningDevelopmentProjectConfirmation));
    }

    /**
     * 删除项目需求确认
     */
    @PreAuthorize("@ss.hasPermi('business:confirmation:remove')")
    @Log(title = "规划发展项目详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessPlanningDevelopmentProjectConfirmationService.deleteBusinessPlanningDevelopmentProjectConfirmationByIds(ids));
    }

    /**
     * 导入社会用电量
     */
    @ApiOperation(value = "导入规划发展开发权项目")
    @Log(title = "导入规划发展开发权项目", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:confirmation:import')")
    public AjaxResult importDatas(MultipartFile file)  throws Exception {
        ExcelUtil<BusinessPlanningDevelopmentProjectConfirmation> util = new ExcelUtil<BusinessPlanningDevelopmentProjectConfirmation>(BusinessPlanningDevelopmentProjectConfirmation.class);
        List<BusinessPlanningDevelopmentProjectConfirmation> bsce = util.importExcel(file.getInputStream());
        String message = businessPlanningDevelopmentProjectConfirmationService.importDatas(bsce);
        return AjaxResult.success(message);
    }

/*    @ApiOperation(value = "导入社会用电量的模板")
    @GetMapping("/importbusinesssocietyelectricity")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessSocietyConsumptionElectricity> util = new ExcelUtil<BusinessSocietyConsumptionElectricity>(BusinessSocietyConsumptionElectricity.class);
        return util.importTemplateExcel("社会用电量数据");
    }*/

    @ApiOperation(value = "导入社会用电量的模板")
    @GetMapping("/importbusinessProjectConfirmation")
    public AjaxResult importBusinessInstallationStatistics() {
        ExcelUtil<BusinessPlanningDevelopmentProjectConfirmation> util = new ExcelUtil<BusinessPlanningDevelopmentProjectConfirmation>(BusinessPlanningDevelopmentProjectConfirmation.class);
        List<BusinessPlanningDevelopmentProjectConfirmation> list =new ArrayList<>();
//        for (Integer group = 0; group <5 ; group++) {
//            BusinessPlanningDevelopmentProjectConfirmation bet = new BusinessPlanningDevelopmentProjectConfirmation();
//            String name = group.toString();
//            bet.setIndustryType(name);
//            list.add(bet);
//        }
        return util.exportExcel(list,"指标申报数据");
    }
}
