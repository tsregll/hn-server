package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.business.domain.BusinessDevelopmentGroupProject;
import com.ruoyi.business.service.IBusinessDevelopmentGroupProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规划发展基建专业组项目Controller
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
@RestController
@RequestMapping("/business/groupproject")
public class BusinessDevelopmentGroupProjectController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentGroupProjectService businessDevelopmentGroupProjectService;

    /**
     * 查询规划发展基建专业组项目列表
     */
//    @PreAuthorize("@ss.hasPermi('business:group_project:list')")
    @GetMapping("/list")
    public Map<String,Object> list(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("请选择".equals(businessDevelopmentGroupProject.getGroupMembers())){
            businessDevelopmentGroupProject.setGroupMembers("");
        }
        if("请选择".equals(businessDevelopmentGroupProject.getGroupLeaders())){
            businessDevelopmentGroupProject.setGroupLeaders("");
        }
        if("请选择".equals(businessDevelopmentGroupProject.getOperator())){
            businessDevelopmentGroupProject.setOperator("");
        }
        if("".equals(businessDevelopmentGroupProject.getDefaultTime())||businessDevelopmentGroupProject.getDefaultTime()==null){
            businessDevelopmentGroupProject.setDefaultTime(date);
        }
        List<BusinessDevelopmentGroupProject> list = businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectList(businessDevelopmentGroupProject);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentGroupProject.getDefaultTime()||"".equals(businessDevelopmentGroupProject.getDefaultTime())){
            returnData.setMsg(date);
//            BusinessDevelopmentAbsorptiveInformation bdai= new BusinessDevelopmentAbsorptiveInformation();
//            bdai.setEarlyWarningTime(date);
//            List<BusinessDevelopmentAbsorptiveInformation> selectList = businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationList(bdai);
        }else {
            returnData.setMsg(businessDevelopmentGroupProject.getDefaultTime());
        }
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("total",returnData.getTotal());
        returnMap.put("rows",returnData.getRows());
        returnMap.put("code",returnData.getCode());
        returnMap.put("msg",returnData.getMsg());
        returnMap.put("name",list.size()>0?list.get(0).getGroupName():"");
        returnMap.put("duty",list.size()>0?list.get(0).getGroupDuty():"");
        returnMap.put("standard",list.size()>0?list.get(0).getGroupStandard():"");
        return returnMap;
    }

    /**
     * 查询基建专业组项目组长列表
     */
    @GetMapping("/groupLeaderList")
    public TableDataInfo groupLeaderList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        startPage();
        List<String> list = businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectGroupLeaderList(businessDevelopmentGroupProject);
        list.add(0,"请选择");
        return getDataTable(list);
    }

    /**
     * 查询基建专业组项目组员列表
     */
    @GetMapping("/groupMemberList")
    public TableDataInfo groupMemberList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        startPage();
        List<String> list = businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectGroupMemberList(businessDevelopmentGroupProject);
        list.add(0,"请选择");
        return getDataTable(list);
    }

    /**
     * 查询基建专业组项目操作人列表
     */
    @GetMapping("/operatorList")
    public TableDataInfo operatorList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        startPage();
        List<String> list = businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectOperatorList(businessDevelopmentGroupProject);
        list.add(0,"请选择");
        return getDataTable(list);
    }

    /**
     * 导出规划发展基建专业组项目列表
     */
    @PreAuthorize("@ss.hasPermi('business:group_project:export')")
    @Log(title = "规划发展基建专业组项目", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        List<BusinessDevelopmentGroupProject> list = businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectList(businessDevelopmentGroupProject);
        ExcelUtil<BusinessDevelopmentGroupProject> util = new ExcelUtil<BusinessDevelopmentGroupProject>(BusinessDevelopmentGroupProject.class);
        return util.exportExcel(list, "groupproject");
    }

    /**
     * 获取规划发展基建专业组项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:group_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectById(id));
    }

    /**
     * 获取规划发展基建专业组项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:group_project:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo()
    {
        return AjaxResult.success(businessDevelopmentGroupProjectService.selectBusinessDevelopmentGroupProjectByVoid());
    }

    /**
     * 新增规划发展基建专业组项目
     */
    @PreAuthorize("@ss.hasPermi('business:group_project:add')")
    @Log(title = "规划发展基建专业组项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        return toAjax(businessDevelopmentGroupProjectService.insertBusinessDevelopmentGroupProject(businessDevelopmentGroupProject));
    }

    /**
     * 修改规划发展基建专业组项目
     */
    @PreAuthorize("@ss.hasPermi('business:group_project:edit')")
    @Log(title = "规划发展基建专业组项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        return toAjax(businessDevelopmentGroupProjectService.updateBusinessDevelopmentGroupProject(businessDevelopmentGroupProject));
    }

    /**
     * 删除规划发展基建专业组项目
     */
    @PreAuthorize("@ss.hasPermi('business:group_project:remove')")
    @Log(title = "规划发展基建专业组项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentGroupProjectService.deleteBusinessDevelopmentGroupProjectByIds(ids));
    }
}
