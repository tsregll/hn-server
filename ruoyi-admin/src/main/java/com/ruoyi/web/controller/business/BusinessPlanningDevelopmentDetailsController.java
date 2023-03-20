package com.ruoyi.web.controller.business;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentDetails;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentDetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 规划发展项目详情后台Controller
 *
 * @author ruoyi
 * @date 2021-04-25
 */
@RestController
@RequestMapping("/business/planningdevelopmentdetails")
public class BusinessPlanningDevelopmentDetailsController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(BusinessPlanningDevelopmentDetailsController.class);
    @Autowired
    private IBusinessPlanningDevelopmentDetailsService businessPlanningDevelopmentDetailsService;
    @Autowired
    private ServerConfig serverConfig;
    /**
     * 查询规划发展项目详情后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentdetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) {
        startPage();
        List<BusinessPlanningDevelopmentDetails> list = businessPlanningDevelopmentDetailsService.selectBusinessPlanningDevelopmentDetailsList(businessPlanningDevelopmentDetails);
        return getDataTable(list);
    }

    /**
     * 导出规划发展项目详情后台列表
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentdetails:export')")
    @Log(title = "规划发展项目详情后台", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) {
        List<BusinessPlanningDevelopmentDetails> list = businessPlanningDevelopmentDetailsService.selectBusinessPlanningDevelopmentDetailsList(businessPlanningDevelopmentDetails);
        ExcelUtil<BusinessPlanningDevelopmentDetails> util = new ExcelUtil<BusinessPlanningDevelopmentDetails>(BusinessPlanningDevelopmentDetails.class);
        return util.exportExcel(list, "planningdevelopmentdetails");
    }

    /**
     * 获取规划发展项目详情后台详细信息
     */
//    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentdetails:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessPlanningDevelopmentDetailsService.selectBusinessPlanningDevelopmentDetailsById(id));
    }

    /**
     * 新增规划发展项目详情后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentdetails:add')")
    @Log(title = "规划发展项目详情后台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) {
        return toAjax(businessPlanningDevelopmentDetailsService.insertBusinessPlanningDevelopmentDetails(businessPlanningDevelopmentDetails));
    }

    /**
     * 修改规划发展项目详情后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentdetails:edit')")
    @Log(title = "规划发展项目详情后台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) {
        return businessPlanningDevelopmentDetailsService.updateBusinessPlanningDevelopmentDetails(businessPlanningDevelopmentDetails);
    }

    /**
     * 删除规划发展项目详情后台
     */
    @PreAuthorize("@ss.hasPermi('business:planningdevelopmentdetails:remove')")
    @Log(title = "规划发展项目详情后台", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessPlanningDevelopmentDetailsService.deleteBusinessPlanningDevelopmentDetailsByIds(ids));
    }

    /**
     * 规划发展项目xlsx上传
     */
    @Log(title = "规划发展项目详情xlsx上传", businessType = BusinessType.UPDATE)
    @PutMapping("/projectFileNameSave")
    public AjaxResult projectFileNameSave(@RequestBody BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) throws IOException {
        return businessPlanningDevelopmentDetailsService.projectFileNameSave(businessPlanningDevelopmentDetails);
    }

    /**
     * 规划发展项目xlsx下载
     */
    @GetMapping("/vehicleFileDownload")
    public void fileDownload(@RequestParam("fileName") String fileName, HttpServletResponse response, HttpServletRequest request) {
        try {
            String filePath = "C:" + RuoYiConfig.getDetailXlsFilePath() + "/" + fileName;
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + fileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }
    /**
     * 本地资源通用下载
     */
    @GetMapping("/fileDownload")
    public void resourceDownload(@RequestParam("filePath") String filePath, @RequestParam("newName") String newName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 本地资源路径
        String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(filePath, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        String suffixName = StringUtils.substringAfterLast(downloadName, ".");
        String temName = newName+suffixName; //文件改名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + temName);
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
