package com.ruoyi.web.controller.business;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessDevelopmentConstructionPreparation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructing;
import com.ruoyi.business.service.IBusinessDevelopmentProjectConstructingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展在建项目Controller
 * 
 * @author ruoyi
 * @date 2021-08-04
 */
@RestController
@RequestMapping("/business/constructing")
public class BusinessDevelopmentProjectConstructingController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentProjectConstructingService businessDevelopmentProjectConstructingService;

    /**
     * 查询规划发展在建项目列表
     */
//    @PreAuthorize("@ss.hasPermi('business:constructing:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("请选择".equals(businessDevelopmentProjectConstructing.getOperator())){
            businessDevelopmentProjectConstructing.setOperator("");
        }
        String listState = businessDevelopmentProjectConstructing.getListState();
        if("0".equals(listState)){
            if("".equals(businessDevelopmentProjectConstructing.getProjectDate())||businessDevelopmentProjectConstructing.getProjectDate()==null){
                businessDevelopmentProjectConstructing.setProjectDate(date);
                businessDevelopmentProjectConstructing.setProjectDateTime(date+"-12-31");
            }else{
                businessDevelopmentProjectConstructing.setProjectDateTime(businessDevelopmentProjectConstructing.getProjectDate()+"-12-31");
            }
        }else{
            if(businessDevelopmentProjectConstructing.getDefaultTime()!=null && !"".equals(businessDevelopmentProjectConstructing.getDefaultTime())){
                businessDevelopmentProjectConstructing.setProjectDate(businessDevelopmentProjectConstructing.getDefaultTime());
                businessDevelopmentProjectConstructing.setProjectDateTime(businessDevelopmentProjectConstructing.getDefaultTime()+"-12-31");
            }
        }
        List<BusinessDevelopmentProjectConstructing> list = businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingList(businessDevelopmentProjectConstructing);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentProjectConstructing.getDefaultTime()||"".equals(businessDevelopmentProjectConstructing.getDefaultTime())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessDevelopmentProjectConstructing.getDefaultTime());
        }
        return returnData;
    }

//    /**
//     * 查询规划发展在建项目列表
//     */
////    @PreAuthorize("@ss.hasPermi('business:constructing:list')")
//    @GetMapping("/list2")
//    public TableDataInfo list2( BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
//    {
//        startPage();
//        String date = new SimpleDateFormat("yyyy").format(new Date());
//        if("请选择".equals(businessDevelopmentProjectConstructing.getOperator())){
//            businessDevelopmentProjectConstructing.setOperator("");
//        }
//        List<BusinessDevelopmentProjectConstructing> list = businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingList(businessDevelopmentProjectConstructing);
//        TableDataInfo returnData=getDataTable(list);
//        if (null==businessDevelopmentProjectConstructing.getDefaultTime()||"".equals(businessDevelopmentProjectConstructing.getDefaultTime())){
//            returnData.setMsg(date);
//        }else {
//            returnData.setMsg(businessDevelopmentProjectConstructing.getDefaultTime());
//        }
//        return returnData;
//    }
    /**
     * 规划发展在建项目地图坐标列表
     */
    @GetMapping(value = "/selectList")
    public Map<String, Object> getInfo(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("".equals(businessDevelopmentProjectConstructing.getDefaultTime())||businessDevelopmentProjectConstructing.getDefaultTime()==null){
            businessDevelopmentProjectConstructing.setDefaultTime(date);
            businessDevelopmentProjectConstructing.setProjectDate(date);
            businessDevelopmentProjectConstructing.setProjectDateTime(date+"-12-31");
        }else{
            businessDevelopmentProjectConstructing.setProjectDate(businessDevelopmentProjectConstructing.getDefaultTime());
            businessDevelopmentProjectConstructing.setProjectDateTime(businessDevelopmentProjectConstructing.getDefaultTime()+"-12-31");
        }
        Map<String, Object> returnMap= AjaxResult.success(businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingList2(businessDevelopmentProjectConstructing));
        returnMap.put("projectDate",businessDevelopmentProjectConstructing.getDefaultTime());
        return returnMap;
    }

    /**
     * 获得操作人列表
     */
    @GetMapping("/operatorList")
    public TableDataInfo operatorList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        startPage();
        List<String> list = businessDevelopmentProjectConstructingService.selectBusinessConstructingOperatorByGroupList(businessDevelopmentProjectConstructing);
        return getDataTable(list);
    }
    /**
     * 规划发展在建项目项目名称列表
     */
    @GetMapping("/projectNameList")
    public AjaxResult selectBusinessConstructingProjectNameList(String projectName)
    {
        List<String> list = businessDevelopmentProjectConstructingService.selectBusinessConstructingProjectNameList(projectName);
        list.add(0,"请选择");
        return AjaxResult.success(list);
    }


    /**
     * 导出规划发展在建项目列表
     */
    @PreAuthorize("@ss.hasPermi('business:constructing:export')")
    @Log(title = "规划发展在建项目", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        List<BusinessDevelopmentProjectConstructing> list = businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingList(businessDevelopmentProjectConstructing);
        ExcelUtil<BusinessDevelopmentProjectConstructing> util = new ExcelUtil<BusinessDevelopmentProjectConstructing>(BusinessDevelopmentProjectConstructing.class);
        return util.exportExcel(list, "constructing");
    }

    /**
     * 获取规划发展在建项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:constructing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingById(id));
    }

    /**
     * 获取规划发展在建项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:constructing:query')")
    @GetMapping(value = "/getproject")
    public AjaxResult getInfo2(@RequestParam(value = "id",required = false) Long id)
    {
        return AjaxResult.success(businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingQianDuanById(id));
    }

    /**
     * 获取规划发展在建项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:constructing:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo2()
    {
        return AjaxResult.success(businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingByVoid());
    }

    /**
     * 新增规划发展在建项目
     */
    @PreAuthorize("@ss.hasPermi('business:constructing:add')")
    @Log(title = "规划发展在建项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        return toAjax(businessDevelopmentProjectConstructingService.insertBusinessDevelopmentProjectConstructing(businessDevelopmentProjectConstructing));
    }

    /**
     * 修改规划发展在建项目
     */
    @PreAuthorize("@ss.hasPermi('business:constructing:edit')")
    @Log(title = "规划发展在建项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        String endProjectDate = businessDevelopmentProjectConstructing.getEndProjectDate();
        if(endProjectDate == null||"".equals(endProjectDate)){
            businessDevelopmentProjectConstructing.setEndProjectDate("");
        }
        return toAjax(businessDevelopmentProjectConstructingService.updateBusinessDevelopmentProjectConstructing(businessDevelopmentProjectConstructing));
    }

    /**
     * 删除规划发展在建项目
     */
    @PreAuthorize("@ss.hasPermi('business:constructing:remove')")
    @Log(title = "规划发展在建项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentProjectConstructingService.deleteBusinessDevelopmentProjectConstructingByIds(ids));
    }

    /**
     * 删除规划发展在建项目节点变更
     */
//    @PreAuthorize("@ss.hasPermi('business:constructing:query')")
    @GetMapping(value = "/getnewnode")
    public Map<String, Object> getNewNode(@RequestParam(value = "projectNode",required = false) String projectNode, @RequestParam(value = "id",required = false) Long id)
    {
        return businessDevelopmentProjectConstructingService.deleteBusinessDevelopmentProjectConstructingNodeByIdToChang(projectNode,id);
    }

    /**
     * 附件上传
     */
    @Log(title = "附件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/constructingFileUpload")
    public AjaxResult constructingFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return businessDevelopmentProjectConstructingService.constructingFileUpload(file);
    }
}
