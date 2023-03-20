package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.NewElectricTradeVo;
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
import com.ruoyi.business.domain.BusinessElectricTrade;
import com.ruoyi.business.service.IBusinessElectricTradeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 电量及电价市场交易Controller
 * 
 * @author ruoyi
 * @date 2021-04-27
 */
@RestController
@RequestMapping("/business/electrictrade")
public class BusinessElectricTradeController extends BaseController
{
    @Autowired
    private IBusinessElectricTradeService businessElectricTradeService;
    @Autowired
    private ISkBbLabelService skBbLabelService;
    private static final Logger log = LoggerFactory.getLogger(BusinessFiveGroupAbandonmentWindController.class);
    /**
     * 查询电量及电价市场交易列表
     */
    @PreAuthorize("@ss.hasPermi('business:electrictrade:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessElectricTrade businessElectricTrade)
    {
        startPage();
        List<BusinessElectricTrade> list = businessElectricTradeService.selectBusinessElectricTradeList(businessElectricTrade);
        return getDataTable(list);
    }

    /**
     * 导入市场交易明细数据
     */
    @ApiOperation(value = "导入市场交易明细数据")
    @Log(title = "导入市场交易明细数据", businessType = BusinessType.EXPORT)
    @PostMapping("/importDatas")
    @PreAuthorize("@ss.hasPermi('business:electrictrade:import')")
    public AjaxResult importDatas(MultipartFile file) throws Exception {
        ExcelUtil<BusinessElectricTrade> util = new ExcelUtil<BusinessElectricTrade>(BusinessElectricTrade.class);
        List<BusinessElectricTrade> betcaw = util.importExcel(file.getInputStream());
        if (StringUtils.isEmpty(betcaw) || betcaw.size() < 1) {
            return AjaxResult.error("导入不能为空表格");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BusinessElectricTrade bet : betcaw) {
            Integer group = Integer.parseInt(bet.getElectricTradeUnit());
            String groupName = group==0?"华能":group==1?"大唐":group==2?"华电":group==3?"国能投":group==4?"国电投":group==5?"长安":group==6?"华润":
                                group==7?"统调火电":group==8?"其他电源":group==9?"全省电源":group==10?"湘祁水电":group==11?"苏宝顶风电":group==12?"桂东风电":
                                group==13?"连坪风电" :group==14?"梅桥风电":group==15?"北湖风电":group==16?"回龙圩风电":group==17?"清能公司":"";
            try {
                BusinessElectricTrade select = new BusinessElectricTrade();
                select.setElectricTradeTime(bet.getElectricTradeTime());
                select.setElectricTradeUnit(bet.getElectricTradeUnit());
                List<BusinessElectricTrade> countList = businessElectricTradeService.selectByTimeElectricTradeList(select);
                String se = "";
                if (countList.size() > 0) {
//                    BusinessFiveGroupAbandonmentWind bfs = countList.get(0);
                    continue;
//                    this.Update()
//                    se = "修改成功";
                } else {
                    this.Insert(bet);
                    se = "导入成功";
                }
                successNum++;
                successMsg.append("<br/>" + ToolUtils.dataToString(bet.getElectricTradeTime(),"1") + "的" + groupName + se);
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + ToolUtils.dataToString(bet.getElectricTradeTime(),"1") + "的 " + groupName + " 导入失败：";
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

    private int Insert(BusinessElectricTrade bet) {
//        String dateTime = ToolUtils.dataToString(bet.getElectricTradeTime(),"1");
//        String ac= bet.getElectricTradeUnit();
//        Map<String,Double> sjMap = this.selectqf(dateTime,ac);
        Map<String,Double> sjMap = new HashMap<>();
        return businessElectricTradeService.insertBusinessElectricTrade(bet,sjMap);
    }
    @ApiOperation(value = "市场交易数据的模板")
    @GetMapping("/exportMb")
    public AjaxResult exportMb() {
        ExcelUtil<BusinessElectricTrade> util = new ExcelUtil<BusinessElectricTrade>(BusinessElectricTrade.class);
//        return util.importTemplateExcel("市场交易数据模板");
        List<BusinessElectricTrade> list = new ArrayList<>();
        for (Integer group = 0; group <18 ; group++) {
            BusinessElectricTrade bet = new BusinessElectricTrade();
            if(group==7||group==17) continue;
            String name = group.toString();
            bet.setElectricTradeUnit(name);
            list.add(bet);
        }
        return util.exportExcel(list,"市场交易数据模板");
    }

    /**
     * 导出电量及电价市场交易列表
     */
    @PreAuthorize("@ss.hasPermi('business:electrictrade:export')")
    @Log(title = "电量及电价市场交易", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusinessElectricTrade businessElectricTrade)
    {
        List<BusinessElectricTrade> list = businessElectricTradeService.selectBusinessElectricTradeList(businessElectricTrade);
        ExcelUtil<BusinessElectricTrade> util = new ExcelUtil<BusinessElectricTrade>(BusinessElectricTrade.class);
        return util.exportExcel(list, "市场交易数据");
    }

    /**
     * 获取电量及电价市场交易详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:electrictrade:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(businessElectricTradeService.selectBusinessElectricTradeById(id));
    }

    /**
     * 新增电量及电价市场交易
     */
    @PreAuthorize("@ss.hasPermi('business:electrictrade:add')")
    @Log(title = "电量及电价市场交易", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessElectricTrade businessElectricTrade)
    {
        BusinessElectricTrade bet = new BusinessElectricTrade();
        bet.setElectricTradeTime(businessElectricTrade.getElectricTradeTime());
        bet.setElectricTradeUnit(businessElectricTrade.getElectricTradeUnit());
//        int count = businessElectricTradeService.selectByTimeElectricTradeList(bet).size();
        int count = businessElectricTradeService.selectByTimeElectricTradeList(bet).size();

        if(count>0){
            return AjaxResult.error("本年度已录入，请勿重复录入！");
        }
        return toAjax(Insert(businessElectricTrade));
    }

    /**
     * 修改电量及电价市场交易
     */
    @PreAuthorize("@ss.hasPermi('business:electrictrade:edit')")
    @Log(title = "电量及电价市场交易", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessElectricTrade businessElectricTrade)
    {
        return toAjax(businessElectricTradeService.updateBusinessElectricTrade(businessElectricTrade));
    }

    /**
     * 删除电量及电价市场交易
     */
    @PreAuthorize("@ss.hasPermi('business:electrictrade:remove')")
    @Log(title = "电量及电价市场交易", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(businessElectricTradeService.deleteBusinessElectricTradeByIds(ids));
    }
    /**
     * 查询全省市场交易月度(柱状图)
     */
    @GetMapping("/selectByMonthTradePillar")
    public AjaxResult selectByMonthTradePillar(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        Map<String,Object> list = businessElectricTradeService.selectByMonthTradePillar(electricTradeTime);
        return AjaxResult.success(list);
    }

    /**
     * 查询全省市场交易月度(列表)
     */
    @GetMapping("/selectByMonthTradeTable")
    public AjaxResult selectByMonthTradeTable(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<BusinessElectricTrade> list = businessElectricTradeService.selectByMonthTradeTable(electricTradeTime);

        return AjaxResult.success(list);
    }
    /**
     * 查询全省市场交易年度(柱状图)
     */
    @GetMapping("/selectByYearTradePillar")
    public AjaxResult selectByYearTradePillar(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        Map<String,Object> list = businessElectricTradeService.selectByYearTradePillar(electricTradeTime);
        return AjaxResult.success(list);
    }
    /**
     * 查询全省市场交易年度(列表)
     */
    @GetMapping("/selectByYearTradeTable")
    public AjaxResult selectByYearTradeTable(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<BusinessElectricTrade> list = businessElectricTradeService.selectByYearTradeTable(electricTradeTime);
//        if(null==list){
//            throw new CustomException("网络错误！数据访问失败");
//        }
        return AjaxResult.success(list);
    }
    /**
     * 查询市场交易明细
     */
    @GetMapping("/selectGroupByMonthTrade")
    public AjaxResult selectGroupByMonthTrade(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<HashMap<String,String>> list = businessElectricTradeService.selectGroupByMonthTrade(electricTradeTime);
//        if(null==list){
//            throw new CustomException("网络错误！数据访问失败");
//        }
        return AjaxResult.success(list);
    }
    /**
     * 查询全省市场交易月度(柱状图)
     */
    @GetMapping("/tdSelectByMonthTradePillar")
    public AjaxResult tdSelectByMonthTradePillar(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<Double> doubles = selectET(electricTradeTime);
        Map<String,Object> list = businessElectricTradeService.tdSelectByMonthTradePillar(electricTradeTime,doubles);
        return AjaxResult.success(list);
    }

    /**
     * 查询全省市场交易月度(列表)
     */
    @GetMapping("/tdSelectByMonthTradeTable")
    public AjaxResult tdSelectByMonthTradeTable(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<Double> doubles = selectET(electricTradeTime);
        List<NewElectricTradeVo> list = businessElectricTradeService.tdSelectByMonthTradeTable(electricTradeTime,doubles);
        return AjaxResult.success(list);
    }
    /**
     * 查询全省市场交易年度(柱状图)
     */
    @GetMapping("/tdSelectByYearTradePillar")
    public AjaxResult tdSelectByYearTradePillar(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<Double> doubles = selectET(electricTradeTime);
        Map<String,Object> list = businessElectricTradeService.tdSelectByYearTradePillar(electricTradeTime,doubles);
        return AjaxResult.success(list);
    }
    /**
     * 查询全省市场交易年度(列表)
     */
    @GetMapping("/tdSelectByYearTradeTable")
    public AjaxResult tdSelectByYearTradeTable(@RequestParam(value = "electricTradeTime",required = false)String electricTradeTime)
    {
        List<Double> doubles = selectET(electricTradeTime);
        List<NewElectricTradeVo> list = businessElectricTradeService.tdSelectByYearTradeTable(electricTradeTime,doubles);
//        if(null==list){
//            throw new CustomException("网络错误！数据访问失败");
//        }
        return AjaxResult.success(list);
    }

    /**
     * 通过用户传入的值去中台查询数据
     * @param dateTime 时间
     * @param ac 用户输入的公司下标
     * @return 中台返回的数据
     */
    private Map<String,Double> selectqf(String dateTime,String ac){
        String name = "市场交易表";
        List<String> lable = selectLable(name);
        return DataUtil.selectQfInsert(lable,dateTime);
    }
    private List<Double> selectET(String dateTime) {
        String name = "市场交易表";
        List<String> returnLable = new ArrayList<>();
        List<SkBbLabel> nameList = skBbLabelService.findByName(name);
        for (SkBbLabel label : nameList) {
            returnLable.add(label.getLabel());
        }
        List<Double> returnList = DataUtil.selectETInsert(returnLable, dateTime);
        return returnList;
    }
    /**
     * 通过用户的值去找点标签
     * @param name 报表名称
     * @return 点标签组
     */
    private List<String> selectLable(String name){
        List<String> returnLable = new ArrayList<>();
        List<SkBbLabel> nameList = skBbLabelService.findByName(name);
        for (SkBbLabel label : nameList) {
            returnLable.add(label.getLabel());
        }
        return returnLable;
    }
}
