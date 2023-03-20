package com.ruoyi.web.controller.business.yykkxzb;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.BusinessElectricTrade;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.IBusinessElectricTradeService;
import com.ruoyi.business.service.impl.yykkxzb.JdbcSamples;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.NewElectricTradeVo;
import com.ruoyi.business.vo.YueYangKeKaoXingZhiBiaoQianDuanVo;
import com.ruoyi.business.vo.YueYangKeKaoXingZhiBiaoVo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.web.controller.business.BusinessFiveGroupAbandonmentWindController;
import com.ruoyi.web.dataUtil.DataUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 电量及电价市场交易Controller
 * 
 * @author ruoyi
 * @date 2021-04-27
 */
@RestController
@RequestMapping("/reliability/yykkxzb")

public class YueYangKeKaoXingZhiBiaoController extends BaseController
{
    @Autowired
    private IBusinessElectricTradeService businessElectricTradeService;
    @Autowired
    private ISkBbLabelService skBbLabelService;
    @Autowired
    private TokenService tokenService;
//    CREATE TABLE hnskdb.REPORT_KKXZB_JZZT (
//    ID 				Int default 0		COMMENT '主键',
//    StateType 		String 				COMMENT '类型，固定为：岳阳电厂',
//    MachineNo		String 				COMMENT '机组号，格式为：1#机组',
//    StateChangeBefore String 			COMMENT '机组修改前状态：运行、备用、检修、非停',
//    StateChangeAfter  String 			COMMENT '机组修改后状态：运行、备用、检修、非停',
//    StateChangeTime DateTime 			COMMENT '机组状态变更时间，格式：2021-06-06 11:12:00',
//    EditUserName 	String 				COMMENT '修改者',
//    EditUserNo 		String 				COMMENT '修改者工号',
//    EditTime		String default now() COMMENT '修改数据时间,无需传值'
//
//        )
    private static final Logger log = LoggerFactory.getLogger(BusinessFiveGroupAbandonmentWindController.class);
    /**
     * 查询列表
     */
//    @PreAuthorize("@ss.hasPermi('reliability:yykkxzb:list')")
    @GetMapping("/list")
    public TableDataInfo list(YueYangKeKaoXingZhiBiaoVo kkxzb)
    {
        startPage();
        String str1 =null==kkxzb.getStateType()||"".equals(kkxzb.getStateType())?"":"and StateType like '%"+kkxzb.getStateType()+"%'";
        String str2 =null==kkxzb.getBeginChangeTime()||"".equals(kkxzb.getBeginChangeTime())?"":"and StateChangeTime >= '"+kkxzb.getBeginChangeTime()+"'";
        String str3 =null==kkxzb.getEndChangeTime()||"".equals(kkxzb.getEndChangeTime())?"":"and StateChangeTime <= '"+kkxzb.getEndChangeTime()+"'";
        String str4 =null==kkxzb.getMachineNo()||"".equals(kkxzb.getMachineNo())?"":"and MachineNo like '%"+kkxzb.getMachineNo()+"%'";
        String sql = "select * from hnskdb.REPORT_KKXZB_JZZT  where 1=1 "
                + str1+str2+str3+str4 +"order by StateChangeTime desc";
//        String sql = "select * from hnskdb.REPORT_KKXZB_JZZT ";
//        update business_electric_trade SET electric_trade_time = ? where id = ?
//        String sql2 = "update hnskdb.REPORT_KKXZB_JZZT  SET  StateChangeTime = '2021-06-06 11:12:00' where EditUserName = '运行'";
//        int num = sql.length();
//        if(null!=kkxzb){
////            kkxzb.getId();
//            kkxzb.setStateType("岳阳电厂");
//            String sql1= null;
//            if(null!=kkxzb.getStateType()) sql=sql+"where StateType = '"+kkxzb.getStateType()+"'";
//            sql1 = sql ;
////            kkxzb.getMachineNo();
////            kkxzb.getStateChangeBefore();
////            kkxzb.getStateChangeAfter();
//
//            //kkxzb.getStateChangeTime();
//            if(null!=kkxzb.getBeginChangeTime()){
//                if (num!=sql.length()){
//                    sql = sql+"and StateChangeTime >= '"+kkxzb.getBeginChangeTime()+"'";
//                }else {
//                   sql = sql + "where StateChangeTime >= '"+kkxzb.getBeginChangeTime()+"'";
//                }
//            }
//            if(null!= kkxzb.getEndChangeTime()){
//                if(num==sql1.length()){
//                    sql = sql + "where StateChangeTime <= '"+kkxzb.getEndChangeTime()+"'";
//                }else {
//                    sql = sql+"and StateChangeTime <= '"+kkxzb.getEndChangeTime()+"'";
//                }
//            }
////            kkxzb.getEditUserName();
////            kkxzb.getEditUserNo();
//        }
        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query(sql);
        int count =1 ;
        for(YueYangKeKaoXingZhiBiaoVo temp : list){
            if(temp.getStateChangeTime().length()>16){
                temp.setId(count++);
                temp.setStateChangeTime(temp.getStateChangeTime().substring(0,16));
            }
        }
        return getDataTable(list);
    }
   // 岳阳火电可靠性指标/reliability/yykkxzb/hdList
//    @PreAuthorize("@ss.hasPermi('reliability:yykkxzb:hdlist')")
    @GetMapping("/hdList")
    public JSONObject hdList(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type)
    {
        JSONObject jsonObject=new JSONObject ();
        try{
            date = null==date ||"".equals(date)? new SimpleDateFormat("yyyy-MM-dd").format(new Date()):date;
//        Map<String,Object> returnMap = new HashMap<>();
            //若查询为当天则做特殊处理
            if(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(date)){
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.DATE, -1);//增加一个月
                date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            }
            String sql = "select * from HNHN.REPORT_KKXZB_RESULT where data_time>='"+date+" 00:00:00' and data_time<='"+date+" 01:00:00' ";
//        update business_electric_trade SET electric_trade_time = ? where id = ?
//        String sql2 = "update hnskdb.REPORT_KKXZB_JZZT  SET  StateChangeTime = '2021-06-06 11:12:00' where EditUserName = '运行'";
            List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = JdbcSamples.demo_hdquery(sql);
//        List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = new ArrayList<>();
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("机组状态","","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("日运行小时","","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("连续运行","","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("停备（计停）","小时","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("累计检修","天","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用小时","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用系数","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("出力系数","%","1","1","1","1","1","1","1"));

            jsonObject.put ("data",list);
            jsonObject.put ("date",date);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("报错"+e.getMessage());
            logger.error("报错d"+e);
        }

        return jsonObject;
    }

    @GetMapping("/hdEdit")
    public AjaxResult hdUpdate(YueYangKeKaoXingZhiBiaoVo kkxzb)
    {
        "1#机组".equals(kkxzb.getMachineNo());
        String YYDC_RJZZT = changeState(kkxzb.getStateChangeAfter());
//        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query("select * from hnskdb.REPORT_KKXZB_JZZT  ");
//        String sql2 = "update hnskdb.REPORT_KKXZB_JZZT  set StateType="+kkxzb.getStateType()+" ,MachineNo = '"+kkxzb.getMachineNo()+" ,StateChangeBefore = '"+kkxzb.getStateChangeBefore()+" ,StateChangeAfter = '"+kkxzb.getStateChangeAfter()+" ,StateChangeTime = '"+kkxzb.getStateChangeTime()+" ,EditUserName = '"+kkxzb.getEditUserName()+" ,EditUserNo = '"+kkxzb.getEditUserNo()+"' where ID =" +kkxzb.getId();
        String sql2 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT1="+YYDC_RJZZT+" where data_time =" +kkxzb.getStateChangeTime().substring(0,11)+"00:00:00";
        JdbcSamples.demo_update(sql2);
        return AjaxResult.success();
    }

    private String changeState(String stateChangeAfter) {
        stateChangeAfter="运行".equals(stateChangeAfter)?"1":"停用".equals(stateChangeAfter)?"2":"备用".equals(stateChangeAfter)?"3":"检修".equals(stateChangeAfter)?"4":"非停".equals(stateChangeAfter)?"5":"";
        return stateChangeAfter;
    }

    @GetMapping("/edit")
    public AjaxResult update(YueYangKeKaoXingZhiBiaoVo kkxzb)
    {
//        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query("select * from hnskdb.REPORT_KKXZB_JZZT  ");
        String sql2 = "update hnskdb.REPORT_KKXZB_JZZT  set StateType="+kkxzb.getStateType()+" ,MachineNo = '"+kkxzb.getMachineNo()+" ,StateChangeBefore = '"+kkxzb.getStateChangeBefore()+" ,StateChangeAfter = '"+kkxzb.getStateChangeAfter()+" ,StateChangeTime = '"+kkxzb.getStateChangeTime()+" ,EditUserName = '"+kkxzb.getEditUserName()+" ,EditUserNo = '"+kkxzb.getEditUserNo()+"' where ID =" +kkxzb.getId();
        JdbcSamples.demo_update(sql2);
        return AjaxResult.success();
    }

    /**
     * 获取用户信息
     */
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        YueYangKeKaoXingZhiBiaoVo yykkxzb = new YueYangKeKaoXingZhiBiaoVo();
        yykkxzb.setEditUserName(loginUser.getUser().getNickName());
        yykkxzb.setEditUserNo(loginUser.getUser().getUserName());
        return AjaxResult.success(yykkxzb);
    }
    
//  修改机组状态
    @PreAuthorize("@ss.hasPermi('reliability:yykkxzb:add')")
//    @Log(title = "修改机组状态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YueYangKeKaoXingZhiBiaoVo kkxzb)
    {
//        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query("select * from hnskdb.REPORT_KKXZB_JZZT  ");
        String sql2 = "insert into hnskdb.REPORT_KKXZB_JZZT(ID,StateType,MachineNo,StateChangeBefore,StateChangeAfter,StateChangeTime,EditUserName,EditUserNo)  values(2,'"+kkxzb.getStateType()+"','"+kkxzb.getMachineNo()+"','"+kkxzb.getStateChangeBefore()+"','"+kkxzb.getStateChangeAfter()+"','"+kkxzb.getStateChangeTime()+"','"+kkxzb.getEditUserName()+"','"+kkxzb.getEditUserNo()+"')" ;
//        String sql2 = "insert into hnskdb.REPORT_KKXZB_JZZT(ID,StateType,MachineNo,StateChangeBefore,StateChangeAfter,StateChangeTime,EditUserName,EditUserNo)  values(2,'岳阳电厂','1#机组','停用','运行','2021-07-06 16:08:00','若依','admin') ";
        JdbcSamples.demo_update(sql2);
//        String YYDC_RJZZT = changeState(kkxzb.getStateChangeAfter());
//        if("1#机组".equals(kkxzb.getMachineNo())){
//            String sql3 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT1="+YYDC_RJZZT+" where data_time ='" +new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00'";
//            JdbcSamples.demo_update(sql3);
//        }else if("2#机组".equals(kkxzb.getMachineNo())){
//            String sql3 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT2="+YYDC_RJZZT+" where data_time ='" +new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00'";
//            JdbcSamples.demo_update(sql3);
//        }else if("3#机组".equals(kkxzb.getMachineNo())){
//            String sql3 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT3="+YYDC_RJZZT+" where data_time ='" +new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00'";
//            JdbcSamples.demo_update(sql3);
//        }else if("4#机组".equals(kkxzb.getMachineNo())){
//            String sql3 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT4="+YYDC_RJZZT+" where data_time ='" +new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00'";
//            JdbcSamples.demo_update(sql3);
//        }else if("5#机组".equals(kkxzb.getMachineNo())){
//            String sql3 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT5="+YYDC_RJZZT+" where data_time ='" +new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00'";
//            JdbcSamples.demo_update(sql3);
//        }else if("6#机组".equals(kkxzb.getMachineNo())){
//            String sql3 = "update HNHN.REPORT_KKXZB_RESULT  set YYDC_RJZZT6="+YYDC_RJZZT+" where data_time ='" +new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00'";
//            JdbcSamples.demo_update(sql3);
//        }
        return AjaxResult.success();
    }

    @GetMapping("/getState")
    public JSONObject getState()
    {
//        String sql = "select * from HNHN.REPORT_KKXZB_RESULT order by data_time desc";
////        update business_electric_trade SET electric_trade_time = ? where id = ?
////        String sql2 = "update hnskdb.REPORT_KKXZB_JZZT  SET  StateChangeTime = '2021-06-06 11:12:00' where EditUserName = '运行'";
//        List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = JdbcSamples.demo_hdquery(sql);
//        YueYangKeKaoXingZhiBiaoQianDuanVo temp =list.get(0);
        YueYangKeKaoXingZhiBiaoQianDuanVo temp =new YueYangKeKaoXingZhiBiaoQianDuanVo();
        String sql = "select * from hnskdb.REPORT_KKXZB_JZZT  where 1=1  order by StateChangeTime desc";
        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query(sql);
        for (YueYangKeKaoXingZhiBiaoVo yueYangKeKaoXingZhiBiaoVo : list) {
            if(temp.getKey0()==null && "1#机组".equals(yueYangKeKaoXingZhiBiaoVo.getMachineNo())){
                temp.setKey0(yueYangKeKaoXingZhiBiaoVo.getStateChangeAfter());
            }
            if(temp.getKey1()==null && "2#机组".equals(yueYangKeKaoXingZhiBiaoVo.getMachineNo())){
                temp.setKey1(yueYangKeKaoXingZhiBiaoVo.getStateChangeAfter());
            }
            if(temp.getKey2()==null && "3#机组".equals(yueYangKeKaoXingZhiBiaoVo.getMachineNo())){
                temp.setKey2(yueYangKeKaoXingZhiBiaoVo.getStateChangeAfter());
            }
            if(temp.getKey3()==null && "4#机组".equals(yueYangKeKaoXingZhiBiaoVo.getMachineNo())){
                temp.setKey3(yueYangKeKaoXingZhiBiaoVo.getStateChangeAfter());
            }
            if(temp.getKey4()==null && "5#机组".equals(yueYangKeKaoXingZhiBiaoVo.getMachineNo())){
                temp.setKey4(yueYangKeKaoXingZhiBiaoVo.getStateChangeAfter());
            }
            if(temp.getKey5()==null && "6#机组".equals(yueYangKeKaoXingZhiBiaoVo.getMachineNo())){
                temp.setKey5(yueYangKeKaoXingZhiBiaoVo.getStateChangeAfter());
            }
        }
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("machineNo1",temp.getKey0());
        jsonObject.put ("machineNo2",temp.getKey1());
        jsonObject.put ("machineNo3",temp.getKey2());
        jsonObject.put ("machineNo4",temp.getKey3());
        jsonObject.put ("machineNo5",temp.getKey4());
        jsonObject.put ("machineNo6",temp.getKey5());
//        jsonObject.put ("machineNo1",temp.getKey0());
//        jsonObject.put ("machineNo2",temp.getKey1());
//        jsonObject.put ("machineNo3",temp.getKey2());
//        jsonObject.put ("machineNo4",temp.getKey3());
//        jsonObject.put ("machineNo5",temp.getKey4());
//        jsonObject.put ("machineNo6",temp.getKey5());
        return jsonObject;
    }
    /**
     * 获取发展专班详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('reliability:yykkxzb:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        String sql = "select * from hnskdb.REPORT_KKXZB_JZZT where ID= "+id;
        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query(sql);
        YueYangKeKaoXingZhiBiaoVo result = list.size()>0?list.get(0):new YueYangKeKaoXingZhiBiaoVo();
        return AjaxResult.success(result);
    }

    /**
     * 导出岳阳可靠性指标列表
     */
//    @PreAuthorize("@ss.hasPermi('reliability:yykkxzb:export')")
    @Log(title = "岳阳可靠性指标", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(YueYangKeKaoXingZhiBiaoVo kkxzb)
    {
        String sql = "select * from hnskdb.REPORT_KKXZB_JZZT  where 1=1 "
                + null==kkxzb.getStateType()||"".equals(kkxzb.getStateType())?"":"and StateType like '%"+kkxzb.getStateType()+"%'"
                + null==kkxzb.getBeginChangeTime()||"".equals(kkxzb.getBeginChangeTime())?"":"and StateChangeTime >= '"+kkxzb.getBeginChangeTime()+"'"
                + null==kkxzb.getEndChangeTime()||"".equals(kkxzb.getEndChangeTime())?"":"and StateChangeTime <= '"+kkxzb.getEndChangeTime()+"'"
                +"order by StateChangeTime desc";
        List<YueYangKeKaoXingZhiBiaoVo> list = JdbcSamples.demo_query(sql);
        ExcelUtil<YueYangKeKaoXingZhiBiaoVo> util = new ExcelUtil<YueYangKeKaoXingZhiBiaoVo>(YueYangKeKaoXingZhiBiaoVo.class);
        return util.exportExcel(list, "岳阳可靠性指标");
    }

    @GetMapping("/hdExport")
    public AjaxResult hdExport(@RequestParam(value = "date",required = false) String date)
    {
        date = null==date?new SimpleDateFormat("yyyy-MM-dd").format(new Date()):date;
//        Map<String,Object> returnMap = new HashMap<>();
        if(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(date)){
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, -1);//增加一个月
            date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        }
        String sql = "select * from HNHN.REPORT_KKXZB_RESULT where data_time>='"+date+" 00:00:00' and data_time<='"+date+" 01:00:00' ";
        List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = JdbcSamples.export_hdquery(sql);
//        List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = new ArrayList<>();
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("机组状态","","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("日运行小时","","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("连续运行","","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("停备（计停）","小时","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("累计检修","天","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用小时","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用系数","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("出力系数","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("平均利用率","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("平均可调出力","%","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("非停次数","次","1","1","1","1","1","1","1"));
//        list.add(new YueYangKeKaoXingZhiBiaoQianDuanVo("非停时间","小时","1","1","1","1","1","1","1"));
        ExcelUtil<YueYangKeKaoXingZhiBiaoQianDuanVo> util = new ExcelUtil<YueYangKeKaoXingZhiBiaoQianDuanVo>(YueYangKeKaoXingZhiBiaoQianDuanVo.class);
        return util.exportExcel(list, "岳阳可靠性指标");
    }
}
