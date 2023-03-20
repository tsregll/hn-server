package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ruoyi.business.domain.BusinessStatisticsYueyangElectricity;
import com.ruoyi.business.service.IBusinessStatisticsYueyangElectricityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 岳阳电厂计划曲线Controller
 * 
 * @author ruoyi
 * @date 2021-08-13
 */
@RestController
@RequestMapping("/business/electricity")
public class BusinessStatisticsYueyangElectricityController extends BaseController
{
    @Autowired
    private IBusinessStatisticsYueyangElectricityService businessStatisticsYueyangElectricityService;
    private static final Logger log = LoggerFactory.getLogger(BusinessFiveGroupAbandonmentWindController.class);
    /**
     * 查询岳阳电厂计划曲线列表
     */
    @PreAuthorize("@ss.hasPermi('business:electricity:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        startPage();
        List<BusinessStatisticsYueyangElectricity> list = businessStatisticsYueyangElectricityService.selectBusinessStatisticsYueyangElectricityList(businessStatisticsYueyangElectricity);
        return getDataTable(list);
    }

    @GetMapping("/list2")
    public JSONObject list2()
    {
        startPage();
        BusinessStatisticsYueyangElectricity returnData = new BusinessStatisticsYueyangElectricity();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        returnData.setPreparationDate(date);
        List<BusinessStatisticsYueyangElectricity> list = businessStatisticsYueyangElectricityService.selectBusinessStatisticsYueyangElectricityList(returnData);
        if(list.size()>0){
            returnData=list.get(0);
        }
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",returnData);
        return jsonObject;
    }

    /**
     * 导出岳阳电厂计划曲线列表
     */
    @PreAuthorize("@ss.hasPermi('business:electricity:export')")
    @Log(title = "岳阳电厂计划曲线", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        List<BusinessStatisticsYueyangElectricity> list = businessStatisticsYueyangElectricityService.selectBusinessStatisticsYueyangElectricityList(businessStatisticsYueyangElectricity);
        ExcelUtil<BusinessStatisticsYueyangElectricity> util = new ExcelUtil<BusinessStatisticsYueyangElectricity>(BusinessStatisticsYueyangElectricity.class);
        return util.exportExcel(list, "electricity");
    }

    /**
     * 获取岳阳电厂计划曲线详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:electricity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessStatisticsYueyangElectricityService.selectBusinessStatisticsYueyangElectricityById(id));
    }

    /**
     * 新增岳阳电厂计划曲线
     */
    @PreAuthorize("@ss.hasPermi('business:electricity:add')")
    @Log(title = "岳阳电厂计划曲线", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        return toAjax(businessStatisticsYueyangElectricityService.insertBusinessStatisticsYueyangElectricity(businessStatisticsYueyangElectricity));
    }

    /**
     * 修改岳阳电厂计划曲线
     */
    @PreAuthorize("@ss.hasPermi('business:electricity:edit')")
    @Log(title = "岳阳电厂计划曲线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessStatisticsYueyangElectricity businessStatisticsYueyangElectricity)
    {
        return toAjax(businessStatisticsYueyangElectricityService.updateBusinessStatisticsYueyangElectricity(businessStatisticsYueyangElectricity));
    }

    /**
     * 删除岳阳电厂计划曲线
     */
    @PreAuthorize("@ss.hasPermi('business:electricity:remove')")
    @Log(title = "岳阳电厂计划曲线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessStatisticsYueyangElectricityService.deleteBusinessStatisticsYueyangElectricityByIds(ids));
    }

    /**
     * 导入市场交易明细数据
     */
    @ApiOperation(value = "导入岳阳电厂计划曲线")
    @Log(title = "导入岳阳电厂计划曲线", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:electricity:import')")
    public AjaxResult importDatas(MultipartFile file) throws Exception {
        ExcelUtil<BusinessStatisticsYueyangElectricity> util = new ExcelUtil<BusinessStatisticsYueyangElectricity>(BusinessStatisticsYueyangElectricity.class);
        List<BusinessStatisticsYueyangElectricity> betcaw = util.importExcel(file.getInputStream());
        if (StringUtils.isEmpty(betcaw) || betcaw.size() < 1) {
            return AjaxResult.error("导入不能为空表格");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        betcaw = businessStatisticsYueyangElectricityService.changeOperatorToList(betcaw);
        for (BusinessStatisticsYueyangElectricity bet : betcaw) {
            try {
                BusinessStatisticsYueyangElectricity select = new BusinessStatisticsYueyangElectricity();
                select.setPreparationDate(bet.getPreparationDate());
                List<BusinessStatisticsYueyangElectricity> countList = businessStatisticsYueyangElectricityService.selectBusinessStatisticsYueyangElectricityList(select);
                String se = "";
                if (countList.size() > 0) {
//                    BusinessFiveGroupAbandonmentWind bfs = countList.get(0);
                    successMsg.append("<br/>" + bet.getPreparationDate() + " 时间重复——导入失败");
                    failureMsg.append("<br/>" + bet.getPreparationDate() + " 时间重复——导入失败");
                    failureNum++;
                    continue;
//                    this.Update()
//                    se = "修改成功";
                } else {
                    businessStatisticsYueyangElectricityService.insertBusinessStatisticsYueyangElectricity(bet);
                    se = "导入成功";
                }
                successNum++;
                successMsg.append("<br/>" + bet.getPreparationDate() + se);
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + bet.getPreparationDate() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已导入成功！共 " + successNum + " 条 "+(failureNum>0?"，导入失败共 " + failureNum + "条":"")+"，数据如下：");
        }
        return AjaxResult.success(successMsg.toString());
    }

    @ApiOperation(value = "岳阳电厂计划曲线的模板")
    @GetMapping("/exportMb")
    public AjaxResult exportMb() {
        ExcelUtil<BusinessStatisticsYueyangElectricity> util = new ExcelUtil<BusinessStatisticsYueyangElectricity>(BusinessStatisticsYueyangElectricity.class);
//        return util.importTemplateExcel("市场交易数据模板");
        List<BusinessStatisticsYueyangElectricity> list = new ArrayList<>();
        return util.exportExcel(list,"岳阳电厂计划曲线表");
    }
}
