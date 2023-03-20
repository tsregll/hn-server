package com.ruoyi.web.controller.business;

import java.util.List;

import com.ruoyi.business.domain.BusinessMarketingDaily;
import com.ruoyi.business.domain.BusinessStatisticsGeneratingCapacity;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.SkBbLabelData;
import com.ruoyi.business.service.BusinessMarketingDailyService;
import com.ruoyi.business.service.ISkBbLabelDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dw
 */
@RestController
@RequestMapping("/business")
public class BusinessMarketingDailyController {
    /**
     * 导入
     */
    @PostMapping("/importStudent")
    @ResponseBody
    public AjaxResult businessMarketingDaily(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BusinessMarketingDaily> util = new ExcelUtil<BusinessMarketingDaily>(BusinessMarketingDaily.class);
        List<BusinessMarketingDaily> BusinessMarketingDaily = util.importExcel(file.getInputStream());
        //String operName = ShiroUtils.getSysUser().getLoginName();
        String message = BusinessMarketingDailyService.importData(BusinessMarketingDaily, updateSupport);
        return AjaxResult.success(message);
    }

}



