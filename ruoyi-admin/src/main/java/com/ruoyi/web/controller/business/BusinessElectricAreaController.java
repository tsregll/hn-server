package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.BusinessElectricArea;
import com.ruoyi.business.domain.BusinessElectricCoal;
import com.ruoyi.business.service.IBusinessElectricAreaService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域发电总貌Controller
 * 
 * @author yrb
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/area")
@Api(value = "BusinessElectricAreaController", tags = "区域发电总貌的接口控制器")
public class BusinessElectricAreaController extends BaseController
{
    @Autowired
    private IBusinessElectricAreaService businessElectricAreaService;

    /**
     * 查询区域发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:area:list')")
    @GetMapping("/list")
    @ApiOperation(value = "区域发电总貌分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "查询的页数（第一页）", required = true, paramType = "header"),
            @ApiImplicitParam(name = "pageSize", value = "查询的数量（10条数据）", required = true, paramType = "header"),
            @ApiImplicitParam(name = "year", value = "查询年份", required = false, paramType = "header",dataType = "Integer"),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricArea.class)
    })
    public TableDataInfo list(BusinessElectricArea businessElectricArea)
    {
        startPage();
        List<BusinessElectricArea> list = businessElectricAreaService.selectBusinessElectricAreaList(businessElectricArea);
        return getDataTable(list);
    }

    /**
     * 导出区域发电总貌列表
     */
    @PreAuthorize("@ss.hasPermi('business:area:export')")
    @Log(title = "煤机发电总貌", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessElectricArea businessElectricArea)
    {
        List<BusinessElectricArea> list = businessElectricAreaService.selectBusinessElectricAreaList(businessElectricArea);
        ExcelUtil<BusinessElectricArea> util = new ExcelUtil<BusinessElectricArea>(BusinessElectricArea.class);
        return util.exportExcel(list, "area");
    }

    /**
     * 获取区域发电总貌详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:area:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "区域发电总貌单个数据对象查询接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = BusinessElectricArea.class)
    })
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessElectricAreaService.selectBusinessElectricAreaById(id));
    }

    /**
     * 新增区域发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:area:add')")
    @Log(title = "区域发电总貌", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation(value = "区域发电总貌新增接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "generateCapacity", value = "发电量", required = false, paramType = "query"),
            @ApiImplicitParam(name = "heatSupply", value = "供热量", required = false, paramType = "query"),
            @ApiImplicitParam(name = "price", value = "标煤采购单价", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "totalPrice", value = "利润总额", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "eva", value = "EVA", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "status", required = true, paramType = "query",defaultValue = "0"),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功")
    })
    public AjaxResult add(@RequestBody BusinessElectricArea businessElectricArea)
    {
        BusinessElectricArea selectBusinessElectricArea = new BusinessElectricArea();
        selectBusinessElectricArea.setYear(businessElectricArea.getYear());
        int count = businessElectricAreaService.selectBusinessElectricAreaList(selectBusinessElectricArea).size();
        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(businessElectricAreaService.insertBusinessElectricArea(businessElectricArea));
    }

    /**
     * 修改区域发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:area:edit')")
    @Log(title = "区域发电总貌", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation(value = "区域发电总貌修改接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = true, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "year", value = "年份", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "generateCapacity", value = "发电量", required = false, paramType = "query"),
            @ApiImplicitParam(name = "heatSupply", value = "供热量", required = false, paramType = "query"),
            @ApiImplicitParam(name = "price", value = "标煤采购单价", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "totalPrice", value = "利润总额", required = false, paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "eva", value = "EVA", required = false, paramType = "query",dataType = "Integer"),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功")
    })
    public AjaxResult edit(@RequestBody BusinessElectricArea businessElectricArea)
    {
        return toAjax(businessElectricAreaService.updateBusinessElectricArea(businessElectricArea));
    }

    /**
     * 删除区域发电总貌
     */
    @PreAuthorize("@ss.hasPermi('business:area:remove')")
    @Log(title = "区域发电总貌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation(value = "区域发电总貌单个数据对象删除接口")
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功")
    })
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessElectricAreaService.deleteBusinessElectricAreaByIds(ids));
    }
}
