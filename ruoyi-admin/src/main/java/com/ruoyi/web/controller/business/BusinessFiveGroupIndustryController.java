package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
import com.ruoyi.business.domain.BusinessFiveGroupIndustry;
import com.ruoyi.business.service.IBusinessFiveGroupIndustryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 行业对标Controller
 * 
 * @author ruoyi
 * @date 2021-08-20
 */
@RestController
@RequestMapping("/business/industry")
public class BusinessFiveGroupIndustryController extends BaseController
{
    @Autowired
    private IBusinessFiveGroupIndustryService businessFiveGroupIndustryService;
    private static final Logger log = LoggerFactory.getLogger(BusinessFiveGroupAbandonmentWindController.class);
    /**
     * 查询行业对标列表
     */
    @PreAuthorize("@ss.hasPermi('business:industry:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        startPage();
        String beginTime = "";
        String endTime = "";
        if((!"".equals(businessFiveGroupIndustry.getQueryBeginYear()))&& null!=businessFiveGroupIndustry.getQueryBeginYear()){
            beginTime = businessFiveGroupIndustry.getQueryBeginYear()+getMonthAndDay(businessFiveGroupIndustry.getQueryBeginQuarter());
        }
        if((!"".equals(businessFiveGroupIndustry.getQueryEndYear()))&& null!=businessFiveGroupIndustry.getQueryEndYear()){
            endTime = businessFiveGroupIndustry.getQueryEndYear()+ "-12-31";
            if(!"".equals(businessFiveGroupIndustry.getQueryEndQuarter())){
                endTime = businessFiveGroupIndustry.getQueryEndYear()+getMonthAndDay(businessFiveGroupIndustry.getQueryEndQuarter());
            }
        }
        businessFiveGroupIndustry.setBeginTime(beginTime);
        businessFiveGroupIndustry.setEndTime(endTime);
        List<BusinessFiveGroupIndustry> list = businessFiveGroupIndustryService.selectBusinessFiveGroupIndustryList(businessFiveGroupIndustry);
        return getDataTable(list);
    }

    /**
     * 查询行业对标列表
     */
//    @PreAuthorize("@ss.hasPermi('business:industry:list')")
    @GetMapping("/selectlist")
    public  Map<String,Object> selectList(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        startPage();
        List<BusinessFiveGroupIndustry> list = businessFiveGroupIndustryService.selectBusinessFiveGroupIndustryList2(businessFiveGroupIndustry);
        Map<String,Object> map =businessFiveGroupIndustryService.selectByYearOrQuarter(businessFiveGroupIndustry);
        Map<String,Object> returnMap =AjaxResult.success(list);
        returnMap.put("dateYear",map.get("dateYear"));
        returnMap.put("dateQuarter",map.get("dateQuarter"));
        return returnMap;
    }

    /**
     * 导入统调发电量
     */
    @ApiOperation(value = "导入五大集团弃风数据")
    @Log(title = "导入五大集团弃风数据", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
//    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:import')")
    public AjaxResult importDatas(MultipartFile file) throws Exception {
        ExcelUtil<BusinessFiveGroupIndustry> util = new ExcelUtil<BusinessFiveGroupIndustry>(BusinessFiveGroupIndustry.class);
        List<BusinessFiveGroupIndustry> bfgaw = util.importExcel(file.getInputStream());
        if (StringUtils.isEmpty(bfgaw) || bfgaw.size() < 1) {
            return AjaxResult.error("导入不能为空表格");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String fiveTotalTime = "1";
        String provinceTime = "2";
        /** 煤电 */
         String industryMd="";
        /** 水电 */
         String industrySd="";
        /** 风电 */
         String industryFd="";
        /** 光伏 */
         String industryGf="";
        /** 其他 */
         String industryQt="";
        /** 合计 */
        String industryHj="";
        //其他的数据
        BusinessFiveGroupIndustry other =  new BusinessFiveGroupIndustry();
        other.setIndustryGroup("7");
        for (BusinessFiveGroupIndustry bf : bfgaw) {
            if(bf.getIndustryYear().length()>4){
                continue;
            }else {
                Integer group = Integer.parseInt(bf.getIndustryGroup());
    //            0=大唐,1=国电投,2=华能,3=华电,4=国能投,5=五大合计,6=全省
                String groupName = group == 1 ? "国电投" : group == 4 ? "国能投" : group == 0 ? "大唐" : group == 3 ? "华电" : group == 2 ? "华能" : group == 5 ? "五大合计" :group == 6 ? "全省" :"错误的集团名";
                try {
                    String dateTime = bf.getIndustryYear()+getMonthAndDay(bf.getIndustryQuarter());
                    bf.setQueryTime(dateTime);

                    BusinessFiveGroupIndustry select = new BusinessFiveGroupIndustry();
                    select.setQueryTime(dateTime);
                    select.setIndustryGroup(bf.getIndustryGroup());
                    List<BusinessFiveGroupIndustry> countList = businessFiveGroupIndustryService.selectBusinessFiveGroupIndustryList(select);
                    String se = "";
                    if (countList.size() > 0) {
                        successMsg.append("<br/>" + bf.getIndustryYear()+ bf.getIndustryQuarter() + "的" + groupName + " 时间重复——导入失败");
                        failureMsg.append("<br/>" + bf.getIndustryYear()+ bf.getIndustryQuarter() + "的" + groupName + " 时间重复——导入失败");
                        failureNum++;
                        continue;
                    } else {
    //                    this.Insert(bf);
                        other.setQueryTime(dateTime);
    //                    List<BusinessFiveGroupIndustry> otherList = businessFiveGroupIndustryService.selectBusinessFiveGroupIndustryList(other);
    //                    if (otherList.size() == 0) {
    //                        other.setIndustryYear(bf.getIndustryYear());
    //                        other.setIndustryQuarter(bf.getIndustryQuarter());
    //                        businessFiveGroupIndustryService.insertBusinessFiveGroupIndustry(other);
    //                    }
                        if(group == 5){
                            fiveTotalTime = dateTime;
                            industryMd = bf.getIndustryMd();
                            industrySd = bf.getIndustrySd();
                            industryFd = bf.getIndustryFd();
                            industryGf = bf.getIndustryGf();
                            industryQt = bf.getIndustryQt();
                            industryHj = bf.getIndustryHj();
                        }
                        if(group == 6){
                            provinceTime = dateTime;
                        }
                        if(fiveTotalTime.equals(provinceTime)){
    //                        other.setId(otherList.get(0).getId());
                            other.setIndustryYear(bf.getIndustryYear());
                            other.setIndustryQuarter(bf.getIndustryQuarter());
                            other.setIndustryMd(ToolUtils.size2(Double.parseDouble(bf.getIndustryMd())-Double.parseDouble(industryMd)));
                            other.setIndustrySd(ToolUtils.size2(Double.parseDouble(bf.getIndustrySd())-Double.parseDouble(industrySd)));
                            other.setIndustryFd(ToolUtils.size2(Double.parseDouble(bf.getIndustryFd())-Double.parseDouble(industryFd)));
                            other.setIndustryGf(ToolUtils.size2(Double.parseDouble(bf.getIndustryGf())-Double.parseDouble(industryGf)));
                            other.setIndustryQt(ToolUtils.size2(Double.parseDouble(bf.getIndustryQt())-Double.parseDouble(industryQt)));
                            other.setIndustryHj(ToolUtils.size2(Double.parseDouble(bf.getIndustryHj())-Double.parseDouble(industryHj)));
                            businessFiveGroupIndustryService.insertBusinessFiveGroupIndustry(other);
                            //重置
                            provinceTime = "2";
    //                        other.setId(null);
                        }
                        businessFiveGroupIndustryService.insertBusinessFiveGroupIndustry(bf);
                        se = "导入成功";
                    }
                    successNum++;
                    successMsg.append("<br/>" + bf.getIndustryYear()+ bf.getIndustryQuarter() + "的" + groupName + se);
                } catch (Exception e) {
                    failureNum++;
                    String msg = "<br/>" + bf.getIndustryYear()+ bf.getIndustryQuarter() + "的 " + groupName + " 导入失败：";
                    failureMsg.append(msg + e.getMessage());
                    log.error(msg, e);
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
                throw new CustomException(failureMsg.toString());
            } else {
    //            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
                successMsg.insert(0, "恭喜您，数据已导入成功！共 " + successNum + " 条 "+(failureNum>0?"，导入失败共 " + failureNum + "条":"")+"，数据如下：");
            }
        }
        return AjaxResult.success(successMsg.toString());
    }

    private String getMonthAndDay(String industryQuarter) {
        String temp = "-01-01";
        if("第一季度".equals(industryQuarter)){
            temp = "-03-31";
        }
        if("第二季度".equals(industryQuarter)){
            temp = "-06-30";
        }
        if("第三季度".equals(industryQuarter)){
            temp = "-09-30";
        }
        if("第四季度".equals(industryQuarter)){
            temp = "-12-31";
        }
        return temp;
    }


    @ApiOperation(value = "行业对标数据的模板")
    @GetMapping("/exportMb")
    public AjaxResult exportMb() {
        ExcelUtil<BusinessFiveGroupIndustry> util = new ExcelUtil<BusinessFiveGroupIndustry>(BusinessFiveGroupIndustry.class);
        List<BusinessFiveGroupIndustry> list =new ArrayList<>();
        for (Integer group = 0; group <7 ; group++) {
            BusinessFiveGroupIndustry bet = new BusinessFiveGroupIndustry();
            String name = group.toString();
            bet.setIndustryGroup(name);
            list.add(bet);
        }
        return util.exportExcel(list,"行业对标数据模板");
    }

    /**
     * 条件查询统计（饼状图）
     */
    @GetMapping("/selectMd")
    @ApiOperation(value = "条件查询统计（饼状图）")
    public AjaxResult selectMd(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        //控制台通过设置备注进行类别区分
        businessFiveGroupIndustry.setRemark("md");
        Map<String,Object> statisticsVo = businessFiveGroupIndustryService.selectChart(businessFiveGroupIndustry);
        return AjaxResult.success(statisticsVo);
    }
    /**
     * 条件查询统计（饼状图）
     */
    @GetMapping("/selectSd")
    @ApiOperation(value = "条件查询统计（饼状图）")
    public AjaxResult selectSd(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        //控制台通过设置备注进行类别区分
        businessFiveGroupIndustry.setRemark("sd");
        Map<String,Object> statisticsVo = businessFiveGroupIndustryService.selectChart(businessFiveGroupIndustry);
        return AjaxResult.success(statisticsVo);
    }
    /**
     * 条件查询统计（饼状图）
     */
    @GetMapping("/selectFd")
    @ApiOperation(value = "条件查询统计（饼状图）")
    public AjaxResult selectFd(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        //控制台通过设置备注进行类别区分
        businessFiveGroupIndustry.setRemark("fd");
        Map<String,Object> statisticsVo = businessFiveGroupIndustryService.selectChart(businessFiveGroupIndustry);
        return AjaxResult.success(statisticsVo);
    }
    /**
     * 条件查询统计（饼状图）
     */
    @GetMapping("/selectGf")
    @ApiOperation(value = "条件查询统计（饼状图）")
    public AjaxResult selectGf(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        //控制台通过设置备注进行类别区分
        businessFiveGroupIndustry.setRemark("gf");
        Map<String,Object> statisticsVo = businessFiveGroupIndustryService.selectChart(businessFiveGroupIndustry);
        return AjaxResult.success(statisticsVo);
    }
    /**
     * 条件查询统计（饼状图）
     */
    @GetMapping("/selectQt")
    @ApiOperation(value = "条件查询统计（饼状图）")
    public AjaxResult selectQt(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        //控制台通过设置备注进行类别区分
        businessFiveGroupIndustry.setRemark("qt");
        Map<String,Object> statisticsVo = businessFiveGroupIndustryService.selectChart(businessFiveGroupIndustry);
        return AjaxResult.success(statisticsVo);
    }

    /**
     * 条件查询统计（柱状图）
     */
    @GetMapping("/selectBar")
    @ApiOperation(value = "条件查询统计（柱状图）")
    public AjaxResult selectBar(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        List<Map<String,Object>> bar = businessFiveGroupIndustryService.selectBar(businessFiveGroupIndustry);
//        List<Map<String,Object>> list = new ArrayList<>();
//        for (Object o : bar) {
//            Map<String,Object> map = new HashMap<>();
//            map.put()
//        }
        if (!bar.isEmpty()) {
            return AjaxResult.success(bar);
        }else{
            return null;
        }
    }
    /**
     * 导出行业对标列表
     */
    @PreAuthorize("@ss.hasPermi('business:industry:export')")
    @Log(title = "行业对标", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        List<BusinessFiveGroupIndustry> list = businessFiveGroupIndustryService.selectBusinessFiveGroupIndustryList(businessFiveGroupIndustry);
        ExcelUtil<BusinessFiveGroupIndustry> util = new ExcelUtil<BusinessFiveGroupIndustry>(BusinessFiveGroupIndustry.class);
        return util.exportExcel(list, "industry");
    }

    /**
     * 获取行业对标详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:industry:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessFiveGroupIndustryService.selectBusinessFiveGroupIndustryById(id));
    }

    //刷新合计
    @GetMapping("/getHj")
    public AjaxResult getHj(BusinessFiveGroupIndustry businessFiveGroupIndustry) {
        return AjaxResult.success(businessFiveGroupIndustryService.updateBusinessFiveGroupIndustryHj(businessFiveGroupIndustry));
    }

    /**
     * 新增行业对标
     */
    @PreAuthorize("@ss.hasPermi('business:industry:add')")
    @Log(title = "行业对标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        Integer test = businessFiveGroupIndustryService.insertBusinessFiveGroupIndustry(businessFiveGroupIndustry);
        return toAjax(test);
    }

    /**
     * 修改行业对标
     */
    @PreAuthorize("@ss.hasPermi('business:industry:edit')")
    @Log(title = "行业对标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        return toAjax(businessFiveGroupIndustryService.updateBusinessFiveGroupIndustry(businessFiveGroupIndustry));
    }

    /**
     * 删除行业对标
     */
    @PreAuthorize("@ss.hasPermi('business:industry:remove')")
    @Log(title = "行业对标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessFiveGroupIndustryService.deleteBusinessFiveGroupIndustryByIds(ids));
    }
}
