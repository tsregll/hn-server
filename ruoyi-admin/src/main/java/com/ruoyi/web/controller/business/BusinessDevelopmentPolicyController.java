package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessDevelopmentPolicy;
import com.ruoyi.business.service.IBusinessDevelopmentPolicyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规划发展最新政策Controller
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@RestController
@RequestMapping("/business/policy")
public class BusinessDevelopmentPolicyController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentPolicyService businessDevelopmentPolicyService;

    /**
     * 查询规划发展最新政策列表
     */
//    @PreAuthorize("@ss.hasPermi('business:policy:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        String msg ="";
        int i = 1;
//        湖南省2020-2021年度风电消纳预警结果
        if("".equals(businessDevelopmentPolicy.getPolicyTime())||businessDevelopmentPolicy.getPolicyTime()==null){
            businessDevelopmentPolicy.setPolicyTime(date);
        }
        List<BusinessDevelopmentPolicy> list = businessDevelopmentPolicyService.selectBusinessDevelopmentPolicyList(businessDevelopmentPolicy);
        List<BusinessDevelopmentPolicy> list1 = new ArrayList<>();
        if(list.size()>0){
            if(list.size()>4){
                for (int j = 0; j <4; j++) {
                    list1.add(list.get(j));
                }
            }
            if(list.size()<=4){
                list1=list;
            }

        }
        for (BusinessDevelopmentPolicy developmentPolicy : list1) {
            developmentPolicy.setPolicyTitle(i+"、"+developmentPolicy.getPolicyTitle());
            i++;
        }
        TableDataInfo returnData=getDataTable(list1);
        if (null==businessDevelopmentPolicy.getPolicyTime()||"".equals(businessDevelopmentPolicy.getPolicyTime())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessDevelopmentPolicy.getPolicyTime());
        }
        return returnData;
    }

    /**
     * 查询规划发展最新政策列表
     */
//    @PreAuthorize("@ss.hasPermi('business:policy:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        String msg ="";
//        湖南省2020-2021年度风电消纳预警结果
        List<BusinessDevelopmentPolicy> list = businessDevelopmentPolicyService.selectBusinessDevelopmentPolicyList(businessDevelopmentPolicy);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentPolicy.getPolicyTime()||"".equals(businessDevelopmentPolicy.getPolicyTime())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessDevelopmentPolicy.getPolicyTime());
        }
        return returnData;
    }

    /**
     * 导出规划发展最新政策列表
     */
    @PreAuthorize("@ss.hasPermi('business:policy:export')")
    @Log(title = "规划发展最新政策", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        List<BusinessDevelopmentPolicy> list = businessDevelopmentPolicyService.selectBusinessDevelopmentPolicyList(businessDevelopmentPolicy);
        ExcelUtil<BusinessDevelopmentPolicy> util = new ExcelUtil<BusinessDevelopmentPolicy>(BusinessDevelopmentPolicy.class);
        return util.exportExcel(list, "policy");
    }

    /**
     * 获取规划发展最新政策详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:policy:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentPolicyService.selectBusinessDevelopmentPolicyById(id));
    }

    /**
     * 获取规划发展最新政策详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:policy:query')")
    @GetMapping(value = "/getInfo2")
    public AjaxResult getInfo2(@RequestParam("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentPolicyService.selectBusinessDevelopmentPolicyById2(id));
    }

    /**
     * 获取发展专班详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:policy:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo()
    {
        return AjaxResult.success(businessDevelopmentPolicyService.selectBusinessDevelopmentPolicyByVoid());
    }

    /**
     * 新增规划发展最新政策
     */
    @PreAuthorize("@ss.hasPermi('business:policy:add')")
    @Log(title = "规划发展最新政策", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        return toAjax(businessDevelopmentPolicyService.insertBusinessDevelopmentPolicy(businessDevelopmentPolicy));
    }

    /**
     * 修改规划发展最新政策
     */
    @PreAuthorize("@ss.hasPermi('business:policy:edit')")
    @Log(title = "规划发展最新政策", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        return toAjax(businessDevelopmentPolicyService.updateBusinessDevelopmentPolicy(businessDevelopmentPolicy));
    }

    /**
     * 删除规划发展最新政策
     */
    @PreAuthorize("@ss.hasPermi('business:policy:remove')")
    @Log(title = "规划发展最新政策", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentPolicyService.deleteBusinessDevelopmentPolicyByIds(ids));
    }
}
