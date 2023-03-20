package com.ruoyi.business.controller;

import java.util.List;
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
import com.ruoyi.business.domain.BusinessHeartScore;
import com.ruoyi.business.service.IBusinessHeartScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供热年度绩效Controller
 * 
 * @author ruoyi
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/supplyHeart")
public class BusinessHeartScoreController extends BaseController
{
    @Autowired
    private IBusinessHeartScoreService businessHeartScoreService;

    /**
     * 查询供热年度绩效列表
     */
    @PreAuthorize("@ss.hasPermi('business:supplyHeart:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessHeartScore businessHeartScore)
    {
        startPage();
        List<BusinessHeartScore> list = businessHeartScoreService.selectBusinessHeartScoreList(businessHeartScore);
        return getDataTable(list);
    }

    /**
     * 导出供热年度绩效列表
     */
    @PreAuthorize("@ss.hasPermi('business:supplyHeart:export')")
    @Log(title = "供热年度绩效", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessHeartScore businessHeartScore)
    {
        List<BusinessHeartScore> list = businessHeartScoreService.selectBusinessHeartScoreList(businessHeartScore);
        ExcelUtil<BusinessHeartScore> util = new ExcelUtil<BusinessHeartScore>(BusinessHeartScore.class);
        return util.exportExcel(list, "supplyHeart");
    }

    /**
     * 获取供热年度绩效详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:supplyHeart:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessHeartScoreService.selectBusinessHeartScoreById(id));
    }

    /**
     * 新增供热年度绩效
     */
    @PreAuthorize("@ss.hasPermi('business:supplyHeart:add')")
    @Log(title = "供热年度绩效", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessHeartScore businessHeartScore)
    {
        BusinessHeartScore selectBusinessHeartScore = new BusinessHeartScore();
        selectBusinessHeartScore.setYear(businessHeartScore.getYear());
        int count = businessHeartScoreService.selectBusinessHeartScoreList(selectBusinessHeartScore).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessHeartScoreService.insertBusinessHeartScore(businessHeartScore));
    }

    /**
     * 修改供热年度绩效
     */
    @PreAuthorize("@ss.hasPermi('business:supplyHeart:edit')")
    @Log(title = "供热年度绩效", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessHeartScore businessHeartScore)
    {
        return toAjax(businessHeartScoreService.updateBusinessHeartScore(businessHeartScore));
    }

    /**
     * 删除供热年度绩效
     */
    @PreAuthorize("@ss.hasPermi('business:supplyHeart:remove')")
    @Log(title = "供热年度绩效", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessHeartScoreService.deleteBusinessHeartScoreByIds(ids));
    }
}
