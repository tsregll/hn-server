package com.ruoyi.web.controller.business;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessDevelopmentAbsorptiveInformation;
import com.ruoyi.business.service.IBusinessDevelopmentAbsorptiveInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展消纳板块Controller
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@RestController
@RequestMapping("/business/information")
public class BusinessDevelopmentAbsorptiveInformationController extends BaseController
{
    @Autowired
    private IBusinessDevelopmentAbsorptiveInformationService businessDevelopmentAbsorptiveInformationService;
    /**
     * 查询规划发展消纳板块列表
     */
//    @PreAuthorize("@ss.hasPermi('business:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        startPage();
        String date = new SimpleDateFormat("yyyy").format(new Date());
        String msg ="";
        String msg1 ="";
        if("".equals(businessDevelopmentAbsorptiveInformation.getEarlyWarningTime())||businessDevelopmentAbsorptiveInformation.getEarlyWarningTime()==null){
            businessDevelopmentAbsorptiveInformation.setEarlyWarningTime(date);
        }
//        msg = "湖南省"+(Integer.parseInt(date)-1)+"-"+date+"年度风电消纳预警结果";
        List<BusinessDevelopmentAbsorptiveInformation> list = businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationList(businessDevelopmentAbsorptiveInformation);
        for (BusinessDevelopmentAbsorptiveInformation temp : list) {
            String date1 = temp.getEarlyWarningTime();
            if("0".equals(temp.getProjectType())){
                msg = "湖南省"+(Integer.parseInt(date1)-1)+"-"+date1+"年度风电消纳预警结果";
                temp.setMapTitle(msg);
            }else if("1".equals(temp.getProjectType())){
                msg1 = "湖南省"+(Integer.parseInt(date1)-1)+"-"+date1+"年度光伏消纳预警结果";
                temp.setMapTitle(msg1);
            }
        }
        TableDataInfo returnData=getDataTable(list);
        if (null==businessDevelopmentAbsorptiveInformation.getEarlyWarningTime()||"".equals(businessDevelopmentAbsorptiveInformation.getEarlyWarningTime())){
            returnData.setMsg(date);
//            BusinessDevelopmentAbsorptiveInformation bdai= new BusinessDevelopmentAbsorptiveInformation();
//            bdai.setEarlyWarningTime(date);
//            List<BusinessDevelopmentAbsorptiveInformation> selectList = businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationList(bdai);
        }else {
            returnData.setMsg(businessDevelopmentAbsorptiveInformation.getEarlyWarningTime());
        }
        return returnData;
    }

    /**
     * 查询规划发展消纳板块列表
     */
    @PreAuthorize("@ss.hasPermi('business:information:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        startPage();
        List<BusinessDevelopmentAbsorptiveInformation> list = businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationList(businessDevelopmentAbsorptiveInformation);
        return getDataTable(list);
    }

    /**
     * 导出规划发展消纳板块列表
     */
    @PreAuthorize("@ss.hasPermi('business:information:export')")
    @Log(title = "规划发展消纳板块", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        List<BusinessDevelopmentAbsorptiveInformation> list = businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationList(businessDevelopmentAbsorptiveInformation);
        ExcelUtil<BusinessDevelopmentAbsorptiveInformation> util = new ExcelUtil<BusinessDevelopmentAbsorptiveInformation>(BusinessDevelopmentAbsorptiveInformation.class);
        return util.exportExcel(list, "information");
    }

    /**
     * 获取规划发展消纳板块详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationById(id));
    }

    /**
     * 获取发展专班详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:information:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo()
    {
        return AjaxResult.success(businessDevelopmentAbsorptiveInformationService.selectBusinessDevelopmentAbsorptiveInformationByVoid());
    }

    /**
     * 新增规划发展消纳板块
     */
    @PreAuthorize("@ss.hasPermi('business:information:add')")
    @Log(title = "规划发展消纳板块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        return toAjax(businessDevelopmentAbsorptiveInformationService.insertBusinessDevelopmentAbsorptiveInformation(businessDevelopmentAbsorptiveInformation));
    }

    /**
     * 修改规划发展消纳板块
     */
    @PreAuthorize("@ss.hasPermi('business:information:edit')")
    @Log(title = "规划发展消纳板块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        return toAjax(businessDevelopmentAbsorptiveInformationService.updateBusinessDevelopmentAbsorptiveInformation(businessDevelopmentAbsorptiveInformation));
    }

    /**
     * 删除规划发展消纳板块
     */
    @PreAuthorize("@ss.hasPermi('business:information:remove')")
    @Log(title = "规划发展消纳板块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessDevelopmentAbsorptiveInformationService.deleteBusinessDevelopmentAbsorptiveInformationByIds(ids));
    }

    /**
     * 图片上传
     */
    @Log(title = "图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/informationFileUpload")
    public AjaxResult vehicleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("type")String type, @RequestParam("id")Long id) throws IOException {
        return businessDevelopmentAbsorptiveInformationService.informationFileUpload(file, type, id);
    }
}
