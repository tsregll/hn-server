package com.ruoyi.web.controller.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructing;
import com.ruoyi.business.service.IBusinessDevelopmentProjectConstructingService;
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
import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructingNode;
import com.ruoyi.business.service.IBusinessDevelopmentProjectConstructingNodeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规划发展在建项目关键节点Controller
 * 
 * @author ruoyi
 * @date 2021-08-06
 */
@RestController
@RequestMapping("/business/constructingnode")
public class BusinessDevelopmentProjectConstructingNodeController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentProjectConstructingNodeService businessDevelopmentProjectConstructingNodeService;
    @Autowired
    private IBusinessDevelopmentProjectConstructingService businessDevelopmentProjectConstructingService;
    /**
     * 查询规划发展在建项目关键节点列表
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        startPage();
        List<BusinessDevelopmentProjectConstructingNode> list = businessDevelopmentProjectConstructingNodeService.selectBusinessDevelopmentProjectConstructingNodeList(businessDevelopmentProjectConstructingNode);
        return getDataTable(list);
    }

    /**
     * 导出规划发展在建项目关键节点列表
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:export')")
    @Log(title = "规划发展在建项目关键节点", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        List<BusinessDevelopmentProjectConstructingNode> list = businessDevelopmentProjectConstructingNodeService.selectBusinessDevelopmentProjectConstructingNodeList(businessDevelopmentProjectConstructingNode);
        ExcelUtil<BusinessDevelopmentProjectConstructingNode> util = new ExcelUtil<BusinessDevelopmentProjectConstructingNode>(BusinessDevelopmentProjectConstructingNode.class);
        return util.exportExcel(list, "constructingnode");
    }

    /**
     * 获取规划发展在建项目关键节点详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentProjectConstructingNodeService.selectBusinessDevelopmentProjectConstructingNodeById(id));
    }

    /**
     * 获取规划发展在建项目关键节点详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:query')")
    @GetMapping(value = "/getInfo2")
    public AjaxResult getInfo2(String ids)
    {
        return AjaxResult.success(businessDevelopmentProjectConstructingNodeService.selectBusinessDevelopmentProjectConstructingNodeVoByIds(ids));
    }

    /**
     * 获取规划发展在建项目关键节点详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:query')")
    @GetMapping(value = "/selectNode")
    public AjaxResult selectNode(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
//        List<BusinessDevelopmentProjectConstructing> list = null;
//        if(("请选择".equals(businessDevelopmentProjectConstructing.getProjectDate())||"".equals(businessDevelopmentProjectConstructing.getProjectDate())||null==businessDevelopmentProjectConstructing.getProjectDate())&& null==businessDevelopmentProjectConstructing.getProjectName()){
//            list = new ArrayList<>();
//        }else {
//            list = businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingList(businessDevelopmentProjectConstructing);
//        }
//        businessDevelopmentProjectConstructing = list.size()>0?list.get(0):businessDevelopmentProjectConstructing;
        businessDevelopmentProjectConstructing =businessDevelopmentProjectConstructingService.selectBusinessDevelopmentProjectConstructingById(businessDevelopmentProjectConstructing.getId());
        String ids = null==businessDevelopmentProjectConstructing.getProjectNode()?"":businessDevelopmentProjectConstructing.getProjectNode();
        Map<String,Object> map =businessDevelopmentProjectConstructingNodeService.selectBusinessDevelopmentProjectConstructingNodeGroupByIds(ids);
        String name = businessDevelopmentProjectConstructing.getProjectName();
        map.put("accessory",businessDevelopmentProjectConstructing.getAccessory());
        map.put("projectName",name);
        map.put("name1",name);
        //开工时间
        map.put("projectDate",businessDevelopmentProjectConstructing.getProjectDate());
        //完工时间
        map.put("endProjectDate",businessDevelopmentProjectConstructing.getEndProjectDate());
        map.put("name2",name+"实时动态");
        return AjaxResult.success(map);
    }

    /**
     * 新增规划发展在建项目关键节点
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:add')")
    @Log(title = "规划发展在建项目关键节点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        return toAjax(businessDevelopmentProjectConstructingNodeService.insertBusinessDevelopmentProjectConstructingNode(businessDevelopmentProjectConstructingNode));
    }

    /**
     * 修改规划发展在建项目关键节点
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:edit')")
    @Log(title = "规划发展在建项目关键节点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        String planingTime = businessDevelopmentProjectConstructingNode.getPlaningTime();
        if(planingTime == null||"".equals(planingTime)){
            businessDevelopmentProjectConstructingNode.setPlaningTime("");
        }
        return toAjax(businessDevelopmentProjectConstructingNodeService.updateBusinessDevelopmentProjectConstructingNode(businessDevelopmentProjectConstructingNode));
    }

    /**
     * 删除规划发展在建项目关键节点
     */
//    @PreAuthorize("@ss.hasPermi('business:constructingnode:remove')")
    @Log(title = "规划发展在建项目关键节点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentProjectConstructingNodeService.deleteBusinessDevelopmentProjectConstructingNodeByIds(ids));
    }
}
