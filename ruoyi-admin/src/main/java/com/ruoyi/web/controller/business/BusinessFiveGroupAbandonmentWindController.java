package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.drmb.FiveGroupAbandonmentWindVo;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.dataUtil.DataUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessFiveGroupAbandonmentWind;
import com.ruoyi.business.service.IBusinessFiveGroupAbandonmentWindService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 五大发电集团月度弃风情况Controller
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@RestController
@RequestMapping("/business/fivegroupabandonmentwind")
public class BusinessFiveGroupAbandonmentWindController extends BaseController {
    @Autowired
    private IBusinessFiveGroupAbandonmentWindService businessFiveGroupAbandonmentWindService;
    @Autowired
    private ISkBbLabelService skBbLabelService;
    private static final Logger log = LoggerFactory.getLogger(BusinessFiveGroupAbandonmentWindController.class);

    /**
     * 查询五大发电集团月度弃风情况列表
     */
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind) {
        startPage();
//        List<BusinessFiveGroupAbandonmentWind> list = businessFiveGroupAbandonmentWindService.selectBusinessFiveGroupAbandonmentWindList(businessFiveGroupAbandonmentWind);
        List<BusinessFiveGroupAbandonmentWind> list = businessFiveGroupAbandonmentWindService.selectByTimeFiveGroupAbandonmentWindList(businessFiveGroupAbandonmentWind);
        for (BusinessFiveGroupAbandonmentWind bf:list) {
            bf.setInstallationVolume(ToolUtils.size2(bf.getInstallationVolume()));
            bf.setElectricityVolume(ToolUtils.size2(bf.getElectricityVolume()));
            bf.setAbandonmentVolume(ToolUtils.size2(bf.getAbandonmentVolume()));
            bf.setAbandonmentRate(ToolUtils.size2(bf.getAbandonmentRate()));
        }
        return getDataTable(list);
    }

    /**
     * 导出五大发电集团月度弃风情况列表
     */
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:export')")
    @Log(title = "五大发电集团月度弃风情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind) {
        List<BusinessFiveGroupAbandonmentWind> list = businessFiveGroupAbandonmentWindService.selectByTimeFiveGroupAbandonmentWindList(businessFiveGroupAbandonmentWind);
        ExcelUtil<BusinessFiveGroupAbandonmentWind> util = new ExcelUtil<BusinessFiveGroupAbandonmentWind>(BusinessFiveGroupAbandonmentWind.class);
        return util.exportExcel(list, "fivegroupabandonmentwind");
    }

    /**
     * 获取五大发电集团月度弃风情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(businessFiveGroupAbandonmentWindService.selectBusinessFiveGroupAbandonmentWindById(id));
    }

    /**
     * 新增五大发电集团月度弃风情况
     */
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:add')")
    @Log(title = "五大发电集团月度弃风情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessFiveGroupAbandonmentWind bfg) {
        BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
        select.setAbandonmentDate(bfg.getAbandonmentDate());
        select.setAbandonmentGroup(bfg.getAbandonmentGroup());
        int count = businessFiveGroupAbandonmentWindService.selectBusinessFiveGroupAbandonmentWindList(select).size();
        if (count > 0) {
            return AjaxResult.error("当前数据本月的已录入，请勿重复录入！");
        }
        return toAjax(Insert(bfg));
    }

    private int Insert(BusinessFiveGroupAbandonmentWind bfg) {
        String dateTime = bfg.getAbandonmentDate();
        Map<String, Double> sjMap = this.selectqf(dateTime);
        return businessFiveGroupAbandonmentWindService.insertBusinessFiveGroupAbandonmentWind(bfg, sjMap);
    }

    /**
     * 导入统调发电量
     */
    @ApiOperation(value = "导入五大集团弃风数据")
    @Log(title = "导入五大集团弃风数据", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:import')")
    public AjaxResult importDatas(MultipartFile file) throws Exception {
        ExcelUtil<BusinessFiveGroupAbandonmentWind> util = new ExcelUtil<BusinessFiveGroupAbandonmentWind>(BusinessFiveGroupAbandonmentWind.class);
        List<BusinessFiveGroupAbandonmentWind> bfgaw = util.importExcel(file.getInputStream());
        if (StringUtils.isEmpty(bfgaw) || bfgaw.size() < 1) {
            return AjaxResult.error("导入不能为空表格");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessFiveGroupAbandonmentWind bf : bfgaw) {
            Integer group = Integer.parseInt(bf.getAbandonmentGroup());
            String groupName = group == 0 ? "国电投" : group == 1 ? "国能投" : group == 2 ? "大唐" : group == 3 ? "华电" : group == 4 ? "华能" : "五大集团";
            if(bf.getInstallationVolume() == null || bf.getInstallationVolume().trim().equals("")){
                String installationVolume = group == 0 ? "67.34" : group == 1 ? "39.58" : group == 2 ? "31.65" : group == 3 ? "63.16" : group == 4 ? "50.07" : "251.8";
                bf.setInstallationVolume(installationVolume);
            }
            try {
                String dateTime = bf.getAbandonmentDate();
                if (dateTime.length() > 7) {
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(dateTime);
                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
                    dateTime = year + "-" + (month.length() < 2 ? "0" + month : month);
                }
                bf.setAbandonmentDate(dateTime);

                BusinessFiveGroupAbandonmentWind select = new BusinessFiveGroupAbandonmentWind();
                select.setAbandonmentDate(dateTime);
                select.setAbandonmentGroup(bf.getAbandonmentGroup());
                List<BusinessFiveGroupAbandonmentWind> countList = businessFiveGroupAbandonmentWindService.selectBusinessFiveGroupAbandonmentWindList(select);
                String se = "";
                if (countList.size() > 0) {
//                    BusinessFiveGroupAbandonmentWind bfs = countList.get(0);
                    continue;
//                    this.Update()
//                    se = "修改成功";
                } else {
                    this.Insert(bf);
                    se = "导入成功";
                }
                successNum++;
                successMsg.append("<br/>" + bf.getAbandonmentDate() + "的" + groupName + se);
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + bf.getAbandonmentDate() + "的 " + groupName + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return AjaxResult.success(successMsg.toString());
    }

/* //下载模板-无集团版本
   @ApiOperation(value = "五大集团弃风数据的模板")
    @GetMapping("/exportMb")
    public AjaxResult exportMb() {
        ExcelUtil<BusinessFiveGroupAbandonmentWind> util = new ExcelUtil<BusinessFiveGroupAbandonmentWind>(BusinessFiveGroupAbandonmentWind.class);
        return util.importTemplateExcel("五大集团弃风数据模板");
    }*/

    @ApiOperation(value = "五大集团弃风数据的模板")
    @GetMapping("/exportMb")
    public AjaxResult exportMb() {
        ExcelUtil<FiveGroupAbandonmentWindVo> util = new ExcelUtil<FiveGroupAbandonmentWindVo>(FiveGroupAbandonmentWindVo.class);
        List<FiveGroupAbandonmentWindVo> list =new ArrayList<>();
        for (Integer group = 0; group <4 ; group++) {
            FiveGroupAbandonmentWindVo bet = new FiveGroupAbandonmentWindVo();
            String name = group.toString();
            bet.setAbandonmentGroup(name);
            list.add(bet);
        }
        return util.exportExcel(list,"五大集团弃风数据模板");
    }


    /**
     * 修改五大发电集团月度弃风情况
     */
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:edit')")
    @Log(title = "五大发电集团月度弃风情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessFiveGroupAbandonmentWind businessFiveGroupAbandonmentWind) {
        return toAjax(businessFiveGroupAbandonmentWindService.updateBusinessFiveGroupAbandonmentWind(businessFiveGroupAbandonmentWind));
    }

    private int Update(BusinessFiveGroupAbandonmentWind bfg) {
        String dateTime = bfg.getAbandonmentDate();
        Map<String, Double> sjMap = this.selectqf(dateTime);
        return businessFiveGroupAbandonmentWindService.updateBusinessFiveGroupAbandonmentWind(bfg);
    }

    /**
     * 删除五大发电集团月度弃风情况
     */
    @PreAuthorize("@ss.hasPermi('business:fivegroupabandonmentwind:remove')")
    @Log(title = "五大发电集团月度弃风情况", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(businessFiveGroupAbandonmentWindService.deleteBusinessFiveGroupAbandonmentWindByIds(ids));
    }




    /**
     * 查询五大发电集团月度弃风月度(柱状图)
     */
    @GetMapping("/selectByMonthOutPillar")
    public AjaxResult selectByMonthOutPillar(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        Map<String,Object> list = businessFiveGroupAbandonmentWindService.selectByMonthOutPillar(abandonmentDate);
        return AjaxResult.success(list);
    }


    /**
     * 查询五大发电集团月度弃风月度(表格)
     */
    @GetMapping("/selectByMonthOutTable")
    public TableDataInfo selectByMonthOutTable(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        List<BusinessFiveGroupAbandonmentWind> list = businessFiveGroupAbandonmentWindService.selectByMonthOutTable(abandonmentDate);
        return getDataTable(list);
    }



    /**
     * 查询五大发电集团月度弃风年度(柱状图)
     */
    @GetMapping("/selectByYearOutPillar")
    public AjaxResult selectByYearOutPillar(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        Map<String,Object> list = businessFiveGroupAbandonmentWindService.selectByYearOutPillar(abandonmentDate);
        return AjaxResult.success(list);
    }


    /**
     * 查询五大发电集团月度弃风年度(表格)
     */
    @GetMapping("/selectByYearOutTable")
    public TableDataInfo selectByYearOutTable(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        List<BusinessFiveGroupAbandonmentWind> list = businessFiveGroupAbandonmentWindService.selectByYearOutTable(abandonmentDate);
        return getDataTable(list);
    }





    /**
     * 通过用户传入的值去中台查询数据
     *
     * @param dateTime 时间
     * @return 中台返回的数据
     */
    private Map<String, Double> selectqf(String dateTime) {
        String name = "弃风情况统计表";
        List<String> placeList = new ArrayList<>();
        placeList.add("华能");
        List<String> labelNameList = new ArrayList<>();
        labelNameList.add("月发电量");
        List<String> lable = selectLable(name, placeList, labelNameList);
        return DataUtil.selectQfInsert(lable, dateTime);
    }

    /**
     * 通过用户的值去找点标签
     *
     * @param name          报表名称
     * @param placeList     场站名
     * @param lableNameList 标签名
     * @return 点标签组
     */
    private List<String> selectLable(String name, List<String> placeList, List<String> lableNameList) {
        List<String> returnLable = new ArrayList<>();
        for (String place : placeList) {
            for (String labelName : lableNameList) {
                SkBbLabel byName = skBbLabelService.find(name, labelName, place);
                if (byName != null) returnLable.add(byName.getLabel());
            }
        }
        return returnLable;
    }
}
