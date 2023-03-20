package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.business.vo.BusinessDevelopmentConstructionPreparationTimeVo;
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
import com.ruoyi.business.domain.BusinessDevelopmentConstructionPreparation;
import com.ruoyi.business.service.IBusinessDevelopmentConstructionPreparationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 拟开工项目Controller
 * 
 * @author ruoyi
 * @date 2021-07-28
 */
@RestController
@RequestMapping("/business/preparation")
public class BusinessDevelopmentConstructionPreparationController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentConstructionPreparationService businessDevelopmentConstructionPreparationService;

    /**
     * 查询规划发展拟开工项目列表
     */
//    @PreAuthorize("@ss.hasPermi('business:preparation:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("请选择".equals(businessDevelopmentConstructionPreparation.getOperator())){
            businessDevelopmentConstructionPreparation.setOperator("");
        }
        if("".equals(businessDevelopmentConstructionPreparation.getDefaultTime())||businessDevelopmentConstructionPreparation.getDefaultTime()==null){
            businessDevelopmentConstructionPreparation.setDefaultTime(date);
        }
        List<BusinessDevelopmentConstructionPreparation> list = businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentConstructionPreparation.getDefaultTime()||"".equals(businessDevelopmentConstructionPreparation.getDefaultTime())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessDevelopmentConstructionPreparation.getDefaultTime());
        }
        return returnData;
    }
    /**
     * 获取规划发展拟开工项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:groupproject:query')")
    @GetMapping(value = "/selectList")
    public AjaxResult getInfo(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("".equals(businessDevelopmentConstructionPreparation.getDefaultTime())||businessDevelopmentConstructionPreparation.getDefaultTime()==null){
            businessDevelopmentConstructionPreparation.setDefaultTime(date);
        }
        return AjaxResult.success(businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationList2(businessDevelopmentConstructionPreparation));
    }

    /**
     * 查询规划发展拟开工实时动态列表
     */
//    @PreAuthorize("@ss.hasPermi('business:preparation:list')")
    @GetMapping("/realTimeList")
    public TableDataInfo realTimeList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        String defaultTime =businessDevelopmentConstructionPreparation.getDefaultTime();
        if("".equals(defaultTime)||null==defaultTime){
            businessDevelopmentConstructionPreparation.setDefaultTime(date);
        }
        List<BusinessDevelopmentConstructionPreparation> list = businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentConstructionPreparation.getDefaultTime()||"".equals(businessDevelopmentConstructionPreparation.getDefaultTime())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessDevelopmentConstructionPreparation.getDefaultTime());
        }
        return returnData;
    }

//    /**
//     * 查询规划发展施工准备项目列表
//     */
//    @PreAuthorize("@ss.hasPermi('business:preparation:list')")
//    @GetMapping("/list2")
//    public TableDataInfo list2(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
//    {
//        startPage();
//        String date = new SimpleDateFormat("yyyy").format(new Date());
//        if("请选择".equals(businessDevelopmentConstructionPreparation.getOperator())){
//            businessDevelopmentConstructionPreparation.setOperator("");
//        }
//        List<BusinessDevelopmentConstructionPreparation> list = businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
//        TableDataInfo returnData=getDataTable(list);
//        if (null==businessDevelopmentConstructionPreparation.getDefaultTime()||"".equals(businessDevelopmentConstructionPreparation.getDefaultTime())){
//            returnData.setMsg(date);
//        }else {
//            returnData.setMsg(businessDevelopmentConstructionPreparation.getDefaultTime());
//        }
//        return returnData;
//    }

    /**
     * 导出拟开工项目列表
     */
    @PreAuthorize("@ss.hasPermi('business:preparation:export')")
    @Log(title = "拟开工项目", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        List<BusinessDevelopmentConstructionPreparation> list = businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
        ExcelUtil<BusinessDevelopmentConstructionPreparation> util = new ExcelUtil<BusinessDevelopmentConstructionPreparation>(BusinessDevelopmentConstructionPreparation.class);
        return util.exportExcel(list, "拟开工项目列表");
    }

    /**
     * 导出规划发展施工准备项目列表2——拟开工实时动态导出
     */
//    @PreAuthorize("@ss.hasPermi('business:preparation:export')")
    @Log(title = "拟开工项目", businessType = BusinessType.EXPORT)
    @GetMapping("/export2")
    public AjaxResult export2(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        List<BusinessDevelopmentConstructionPreparationTimeVo> list = new ArrayList<>();
        List<BusinessDevelopmentConstructionPreparation> selectList = businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
        for (BusinessDevelopmentConstructionPreparation temp : selectList) {
            BusinessDevelopmentConstructionPreparationTimeVo pt = new BusinessDevelopmentConstructionPreparationTimeVo();
            pt.setPid(temp.getPid());
            pt.setProjectName(temp.getProjectName());
            pt.setSigningPlaningTime(temp.getSigningPlaningTime());
            pt.setSigningTime(temp.getSigningTime());
            pt.setRecordPlaningTime(temp.getRecordPlaningTime());
            pt.setRecordTime(temp.getRecordTime());
            pt.setDecisionPlaningTime(temp.getDecisionPlaningTime());
            pt.setDecisionTime(temp.getDecisionTime());
            pt.setDraftPlaningTime(temp.getDraftPlaningTime());
            pt.setDraftTime(temp.getDraftTime());
            pt.setFormalityPlaningTime(temp.getFormalityPlaningTime());
            pt.setFormalityTime(temp.getFormalityTime());
            pt.setEquipmentPlaningTime(temp.getEquipmentPlaningTime());
            pt.setEquipmentTime(temp.getEquipmentTime());
            pt.setConstructionPlaningTime(temp.getConstructionPlaningTime());
            pt.setConstructionTime(temp.getConstructionTime());
            pt.setConstructingPlaningTime(temp.getConstructingPlaningTime());
            pt.setConstructingTime(temp.getConstructingTime());
            pt.setRemark(temp.getRemark());
            list.add(pt);
        }
        ExcelUtil<BusinessDevelopmentConstructionPreparationTimeVo> util = new ExcelUtil<BusinessDevelopmentConstructionPreparationTimeVo>(BusinessDevelopmentConstructionPreparationTimeVo.class);
        return util.exportExcel(list, "拟开工实时动态列表");
    }

    /**
     * 获取拟开工项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:preparation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationById(id));
    }

    /**
     * 获得操作人列表
     */
    @GetMapping("/operatorList")
    public TableDataInfo operatorList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<String> list = businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationOperatorByGroupList(businessDevelopmentConstructionPreparation);
        TableDataInfo returnData= getDataTable(list);
        returnData.setMsg(date);
        return returnData;
    }
    /**
     * 获取规划发展基建专业组项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:groupproject:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo()
    {
        return AjaxResult.success(businessDevelopmentConstructionPreparationService.selectBusinessDevelopmentConstructionPreparationByVoid());
    }

    /**
     * 新增拟开工项目
     */
    @PreAuthorize("@ss.hasPermi('business:preparation:add')")
    @Log(title = "拟开工项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        return toAjax(businessDevelopmentConstructionPreparationService.insertBusinessDevelopmentConstructionPreparation(businessDevelopmentConstructionPreparation));
    }

    /**
     * 修改拟开工项目
     */
    @PreAuthorize("@ss.hasPermi('business:preparation:edit')")
    @Log(title = "拟开工项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        return toAjax(businessDevelopmentConstructionPreparationService.updateBusinessDevelopmentConstructionPreparation(businessDevelopmentConstructionPreparation));
    }

    /**
     * 删除拟开工项目
     */
    @PreAuthorize("@ss.hasPermi('business:preparation:remove')")
    @Log(title = "拟开工项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentConstructionPreparationService.deleteBusinessDevelopmentConstructionPreparationByIds(ids));
    }
}
