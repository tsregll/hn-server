package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.BusinessFiveGroupAbandonmentWind;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.drmb.ParcelCompanyAbandonmentWindVo;
import com.ruoyi.common.annotation.Excel;
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
import com.ruoyi.business.domain.BusinessParcelCompanyAbandonmentWind;
import com.ruoyi.business.service.IBusinessParcelCompanyAbandonmentWindService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 分公司各风场弃风情况月度Controller
 * 
 * @author yrb
 * @date 2021-03-22
 */
@RestController
@RequestMapping("/business/abandonmentwind")
public class BusinessParcelCompanyAbandonmentWindController extends BaseController
{
    @Autowired
    private IBusinessParcelCompanyAbandonmentWindService businessParcelCompanyAbandonmentWindService;
    @Autowired
    private ISkBbLabelService skBbLabelService;
    private static final Logger log = LoggerFactory.getLogger(BusinessFiveGroupAbandonmentWindController.class);

    /**
     * 查询分公司各风场弃风情况月度列表
     */
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind)
    {
        startPage();
//        List<BusinessParcelCompanyAbandonmentWind> list = businessParcelCompanyAbandonmentWindService.selectBusinessParcelCompanyAbandonmentWindList(businessParcelCompanyAbandonmentWind);
        List<BusinessParcelCompanyAbandonmentWind> list = businessParcelCompanyAbandonmentWindService.selectByTimesParcelCompanyAbandonmentWindList(businessParcelCompanyAbandonmentWind);
        for(BusinessParcelCompanyAbandonmentWind bp:list){
            bp.setInstallationVolume(ToolUtils.size2(bp.getInstallationVolume()));
            bp.setElectricityVolume(ToolUtils.size2(bp.getElectricityVolume()));
            bp.setAbandonmentVolume(ToolUtils.size2(bp.getAbandonmentVolume()));
            bp.setAbandonmentRate(ToolUtils.size2(bp.getAbandonmentRate()));
        }
        return getDataTable(list);
    }

    /**
     * 导出分公司各风场弃风情况月度列表
     */
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:export')")
    @Log(title = "分公司各风场弃风情况月度", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind)
    {
        List<BusinessParcelCompanyAbandonmentWind> list = businessParcelCompanyAbandonmentWindService.selectByTimesParcelCompanyAbandonmentWindList(businessParcelCompanyAbandonmentWind);
        ExcelUtil<BusinessParcelCompanyAbandonmentWind> util = new ExcelUtil<BusinessParcelCompanyAbandonmentWind>(BusinessParcelCompanyAbandonmentWind.class);
        return util.exportExcel(list, "abandonmentwind");
    }

    /**
     * 获取分公司各风场弃风情况月度详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessParcelCompanyAbandonmentWindService.selectBusinessParcelCompanyAbandonmentWindById(id));
    }

    /**
     * 新增分公司各风场弃风情况月度
     */
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:add')")
    @Log(title = "分公司各风场弃风情况月度", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind)
    {
        BusinessParcelCompanyAbandonmentWind bpc = new BusinessParcelCompanyAbandonmentWind();
        bpc.setAbandonmentDate(businessParcelCompanyAbandonmentWind.getAbandonmentDate());
        bpc.setAbandonmentCompany(businessParcelCompanyAbandonmentWind.getAbandonmentCompany());
        int count = businessParcelCompanyAbandonmentWindService.selectBusinessParcelCompanyAbandonmentWindList(bpc).size();
        if(count>0){
            return AjaxResult.error("当前数据本月的已录入，请勿重复录入！");
        }
        return toAjax(Insert(businessParcelCompanyAbandonmentWind));
    }

    /**
     * 提取出新增功能.
     * @param businessParcelCompanyAbandonmentWind
     * @return
     */
    private int Insert(BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind){
        String dateTime = businessParcelCompanyAbandonmentWind.getAbandonmentDate();
        String ac = businessParcelCompanyAbandonmentWind.getAbandonmentCompany();
        Map<String,Double> sjMap = this.selectqf(dateTime,ac);
        return businessParcelCompanyAbandonmentWindService.insertBusinessParcelCompanyAbandonmentWind(businessParcelCompanyAbandonmentWind,sjMap);
    }
    /**
     * 导入分公司弃风数据
     */
    @ApiOperation(value = "导入分公司弃风数据")
    @Log(title = "导入分公司弃风数据", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:import')")
    public AjaxResult importDatas(MultipartFile file) throws Exception {
        ExcelUtil<BusinessParcelCompanyAbandonmentWind> util = new ExcelUtil<BusinessParcelCompanyAbandonmentWind>(BusinessParcelCompanyAbandonmentWind.class);
        List<BusinessParcelCompanyAbandonmentWind> bpcaw = util.importExcel(file.getInputStream());
        if (StringUtils.isEmpty(bpcaw) || bpcaw.size() < 1) {
            return AjaxResult.error("导入不能为空表格");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessParcelCompanyAbandonmentWind bp : bpcaw) {
            Integer group = Integer.parseInt(bp.getAbandonmentCompany());
            String groupName = group == 0 ? "苏宝顶" : group == 1 ? "桂东" : group == 2 ? "连坪" : group == 3 ? "梅桥" : group == 4 ? "北湖风电" : group == 5 ? "回龙圩风电" : "分公司风电";
            try {
                String dateTime = bp.getAbandonmentDate();
                if (dateTime.length() > 7) {
                    Date dates = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(dateTime);
                    String year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getYear() + "";
                    String month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dates)).getMonthValue() + "";
                    dateTime = year + "-" + (month.length() < 2 ? "0" + month : month);
                }
                bp.setAbandonmentDate(dateTime);
                BusinessParcelCompanyAbandonmentWind select = new BusinessParcelCompanyAbandonmentWind();
                select.setAbandonmentDate(dateTime);
                select.setAbandonmentCompany(bp.getAbandonmentCompany());
                List<BusinessParcelCompanyAbandonmentWind> countList = businessParcelCompanyAbandonmentWindService.selectBusinessParcelCompanyAbandonmentWindList(select);
                String se = "";
                if (countList.size() > 0) {
//                    BusinessFiveGroupAbandonmentWind bfs = countList.get(0);
                    continue;
//                    this.Update()
//                    se = "修改成功";
                } else {
                    this.Insert(bp);
                    se = "导入成功";
                }
                successNum++;
                successMsg.append("<br/>" + bp.getAbandonmentDate() + "的" + groupName + se);
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + bp.getAbandonmentDate() + "的 " + groupName + " 导入失败：";
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

/*//下载模板-无集团版本
    @ApiOperation(value = "分公司弃风数据的模板")
    @GetMapping("/exportBpca")
    public AjaxResult exportBpca() {
        ExcelUtil<BusinessParcelCompanyAbandonmentWind> util = new ExcelUtil<BusinessParcelCompanyAbandonmentWind>(BusinessParcelCompanyAbandonmentWind.class);
        return util.importTemplateExcel("分公司弃风数据模板");
    }
*/
@ApiOperation(value = "分公司弃风数据的模板")
@GetMapping("/exportBpca")
public AjaxResult exportBpca() {
    ExcelUtil<ParcelCompanyAbandonmentWindVo> util = new ExcelUtil<ParcelCompanyAbandonmentWindVo>(ParcelCompanyAbandonmentWindVo.class);
    List<ParcelCompanyAbandonmentWindVo> list =new ArrayList<>();
    for (Integer group = 0; group <6 ; group++) {
        ParcelCompanyAbandonmentWindVo bet = new ParcelCompanyAbandonmentWindVo();
        String name = group.toString();
        bet.setAbandonmentCompany(name);
        list.add(bet);
    }
    ParcelCompanyAbandonmentWindVo bet = new ParcelCompanyAbandonmentWindVo();
    bet.setAbandonmentCompany("7");
    list.add(bet);
    return util.exportExcel(list,"分公司弃风数据模板");
}

    /**
     * 修改分公司各风场弃风情况月度
     */
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:edit')")
    @Log(title = "分公司各风场弃风情况月度", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessParcelCompanyAbandonmentWind businessParcelCompanyAbandonmentWind)
    {
        String dateTime = businessParcelCompanyAbandonmentWind.getAbandonmentDate();
        String ac = businessParcelCompanyAbandonmentWind.getAbandonmentCompany();
        Map<String,Double> sjMap = this.selectqf(dateTime,ac);
        return toAjax(businessParcelCompanyAbandonmentWindService.updateBusinessParcelCompanyAbandonmentWind(businessParcelCompanyAbandonmentWind,sjMap));
    }

    /**
     * 删除分公司各风场弃风情况月度
     */
    @PreAuthorize("@ss.hasPermi('business:abandonmentwind:remove')")
    @Log(title = "分公司各风场弃风情况月度", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessParcelCompanyAbandonmentWindService.deleteBusinessParcelCompanyAbandonmentWindByIds(ids));
    }

    /**
     * 查询分公司各风场弃风情况月度(柱状图)
     */
    @GetMapping("/selectByMonthOutPillar")
    public AjaxResult selectByMonthOutPillar(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        Map<String,Object> list = businessParcelCompanyAbandonmentWindService.selectByMonthOutPillar(abandonmentDate);
        return AjaxResult.success(list);
    }

    /**
     * 查询分公司各风场弃风情况月度(表格)
     */
    @GetMapping("/selectByMonthOutTable")
    public TableDataInfo selectByMonthOutTable(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        List<Map<String,String>> list = businessParcelCompanyAbandonmentWindService.selectByMonthOutTable(abandonmentDate);
        return getDataTable(list);
    }

    /**
     * 查询分公司风场弃风情况年度(柱状图)
     */
    @GetMapping("/selectByYearOutPillar")
    public AjaxResult selectByYearOutPillar(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        Map<String,Object> list = businessParcelCompanyAbandonmentWindService.selectByYearOutPillar(abandonmentDate);
        return AjaxResult.success(list);
    }

    /**
     * 查询分公司风场弃风情况年度(表格)
     */
    @GetMapping("/selectByYearOutTable")
    public TableDataInfo selectByYearOutTable(@RequestParam(value = "abandonmentDate",required = false)String abandonmentDate)
    {
        List<Map<String,String>> list = businessParcelCompanyAbandonmentWindService.selectByYearOutTable(abandonmentDate);
        return getDataTable(list);
    }

    /**
     * 通过用户传入的值去中台查询数据
     * @param dateTime 时间
     * @param ac 用户输入的公司下标
     * @return 中台返回的数据
     */
    private Map<String,Double> selectqf(String dateTime,String ac){
        String name = "弃风情况统计表";
        List<String> placeList =new ArrayList<> ();
        placeList.add(ac.equals("0")?"苏宝顶风电":ac.equals("1")?"桂东风电":ac.equals("2")?"连坪风电":ac.equals("3")?"梅桥风电":ac.equals("4")?"北湖风电":ac.equals("5")?"回龙圩风电":ac.equals("7")?"江口风电":"");
        placeList.add("分公司风电");
        List<String> labelNameList =new ArrayList<> ();
        labelNameList.add("月发电量");
        labelNameList.add("年装机量");
        List<String> lable = selectLable(name,placeList,labelNameList);
        return DataUtil.selectQfInsert(lable,dateTime);
    }

    /**
     * 通过用户的值去找点标签
     * @param name 报表名称
     * @param placeList 场站名
     * @param lableNameList 标签名
     * @return 点标签组
     */
    private List<String> selectLable(String name,List<String> placeList,List<String> lableNameList){
        List<String> returnLable = new ArrayList<>();
        for(String place:placeList){
            for(String labelName :lableNameList){
                SkBbLabel byName = skBbLabelService.find(name,labelName,place);
                if(byName!=null)returnLable.add (byName.getLabel ());
            }
        }
        return returnLable;
    }

}
