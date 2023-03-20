package com.ruoyi.web.controller.business;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.vo.BusinessDevelopmentClassDetailsVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessDevelopmentClassDetails;
import com.ruoyi.business.service.IBusinessDevelopmentClassDetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 发展专班详情Controller
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
@RestController
@RequestMapping("/business/speciality")
public class BusinessDevelopmentClassDetailsController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentClassDetailsService businessDevelopmentClassDetailsService;

    /**
     * 查询发展专班详情列表
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        if("".equals(businessDevelopmentClassDetails.getOperatorTime())||businessDevelopmentClassDetails.getOperatorTime()==null){
            businessDevelopmentClassDetails.setOperatorTime(date);
        }
        List<BusinessDevelopmentClassDetails> list = businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassDetailsList(businessDevelopmentClassDetails);
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentClassDetails.getOperatorTime()||"".equals(businessDevelopmentClassDetails.getOperatorTime())){
            returnData.setMsg(date);
        }else {
            returnData.setMsg(businessDevelopmentClassDetails.getOperatorTime());
        }
        return returnData;
    }

    /**
     * 查询发展专班详情列表
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:list')")
    @GetMapping("/groupLeaderList")
    public TableDataInfo byGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        startPage();
        List<String> list = businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassDetailsByGroupList(businessDevelopmentClassDetails);
        return getDataTable(list);
    }

    /**
     * 查询发展专班详情列表
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:list')")
    @GetMapping("/operatorList")
    public TableDataInfo operatorList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        startPage();
        List<String> list = businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassOperatorDetailsByGroupList(businessDevelopmentClassDetails);
        return getDataTable(list);
    }

    /**
     * 导出发展专班详情列表
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:export')")
    @Log(title = "发展专班详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        List<BusinessDevelopmentClassDetails> list = businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassDetailsList(businessDevelopmentClassDetails);
        ExcelUtil<BusinessDevelopmentClassDetails> util = new ExcelUtil<BusinessDevelopmentClassDetails>(BusinessDevelopmentClassDetails.class);
        return util.exportExcel(list, "speciality");
    }

    /**
     * 获取发展专班详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassDetailsById(id));
    }

    /**
     * 获取发展专班详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:query')")
    @GetMapping(value = "/getInfo2")
    public AjaxResult getInfo(@RequestParam("id") Long id,@RequestParam("type")String type)
    {
        return AjaxResult.success(businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassDetailsById(id,type));
    }

    /**
     * 获取发展专班详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo()
    {
        return AjaxResult.success(businessDevelopmentClassDetailsService.selectBusinessDevelopmentClassDetailsByVoid());
    }

    /**
     * 新增发展专班详情
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:add')")
    @Log(title = "发展专班详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        return toAjax(businessDevelopmentClassDetailsService.insertBusinessDevelopmentClassDetails(businessDevelopmentClassDetails));
    }

    /**
     * 修改发展专班详情
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:edit')")
    @Log(title = "发展专班详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        return toAjax(businessDevelopmentClassDetailsService.updateBusinessDevelopmentClassDetails(businessDevelopmentClassDetails));
    }

    /**
     * 删除发展专班详情
     */
    @PreAuthorize("@ss.hasPermi('business:speciality:remove')")
    @Log(title = "发展专班详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentClassDetailsService.deleteBusinessDevelopmentClassDetailsByIds(ids));
    }

    /**
     * 车辆图片上传
     */
    @Log(title = "图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/specialityFileUpload")
    public AjaxResult specialityFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("type")String type, @RequestParam("id")Long id, BusinessDevelopmentClassDetailsVo address) throws IOException {
        return businessDevelopmentClassDetailsService.specialityFileUpload(file, type,id,address);
    }
}
