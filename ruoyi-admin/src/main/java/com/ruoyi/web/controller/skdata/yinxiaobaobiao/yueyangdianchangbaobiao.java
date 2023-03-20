package com.ruoyi.web.controller.skdata.yinxiaobaobiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.YeYangQuanChangVo;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/business/yydc")
public class yueyangdianchangbaobiao {

    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     * 岳阳全厂报表
     */
    @PreAuthorize("@ss.hasPermi('business:yueyangquanchangexport:export')")
    @Log(title = "岳阳全厂报表导出", businessType = BusinessType.EXPORT)
    @GetMapping("/yueyangquanchangexport")
    public AjaxResult yueyangquanchangexport(@RequestParam(value = "date",required = false) String date){
        ExcelUtil<YeYangQuanChangVo> util = new ExcelUtil<YeYangQuanChangVo>(YeYangQuanChangVo.class);
        List<HashMap<String,String>> list = selectYyqcbb(date);;
        if(StringUtils.isEmpty(date)){
            Integer year = LocalDate.now().getYear();
            Integer month = LocalDate.now().getMonthValue();
            Integer day = LocalDate.now().getDayOfMonth();
            date = year.toString()+"-"+(month<10?"0"+month:month.toString())+"-"+(day<10?"0"+day:day.toString());
        }
        String name = "岳阳全厂报表";
        List<YeYangQuanChangVo> listt = new ArrayList<>();
        for(HashMap<String,String> map :list){
            YeYangQuanChangVo q = new YeYangQuanChangVo();
            q.setLabelName(map.get("industry_type"));
            q.setUnit(map.get("unit"));
            q.setKey0(map.get("key3"));
            q.setKey1(map.get("key0"));
            q.setKey2(map.get("key2"));
            q.setKey3(map.get("key1"));
            listt.add(q);
        }
        return util.exportExcelRewrite(listt,name,date);
    }
    /**
     * 岳阳全厂报表
     *
     * @return
     */
    @GetMapping("/yyqcbb")
    public JSONObject yyqcbb(@RequestParam(value = "date",required = false) String date) {
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",selectYyqcbb(date));
        return jsonObject;
    }
    private List<HashMap<String,String>> selectYyqcbb(String date){
        String type = "1";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type = null;
        }
        String name="岳阳全厂报表";
        List<String> placeList = new ArrayList<>();
        List<HashMap<String,String>> list=new ArrayList<> ();
        placeList.add("本日上网电量");
        placeList.add("本日利用小时");
        placeList.add("本日利用小时同比");
        placeList.add("本日厂用电率");
        placeList.add("本日发电量");
        placeList.add("本日发电量占比");
        placeList.add("本日发电量同比");
        placeList.add("本日同期发电量");
        placeList.add("本日负荷率");
        placeList.add("本周上网电量");
        placeList.add("本周利用小时");
        placeList.add("本周利用小时同比");
        placeList.add("本周厂用电率");
        placeList.add("本周发电量");
        placeList.add("本周发电量占比");
        placeList.add("本周发电量同比");
        placeList.add("本周同期发电量");
        placeList.add("本周负荷率");
        placeList.add("本月上网电量");
        placeList.add("本月利用小时");
        placeList.add("本月利用小时同比");
        placeList.add("本月厂用电率");
        placeList.add("本月发电量");
        placeList.add("本月发电量占比");
        placeList.add("本月发电量同比");
        placeList.add("本月同期发电量");
        placeList.add("本月负荷率");
        placeList.add("本年上网电量");
        placeList.add("本年利用小时");
        placeList.add("本年利用小时同比");
        placeList.add("本年厂用电率");
        placeList.add("本年发电量");
        placeList.add("本年发电量占比");
        placeList.add("本年发电量同比");
        placeList.add("本年同期发电量");
        placeList.add("本年负荷率");
        Integer count = new Integer(0);
        for(String place:placeList){
            List<SkBbLabel> byLabelName = skBbLabelService.findByLabelNameOrder(name,place);
            List<String> labelNames = new ArrayList<>();
            for(SkBbLabel s :byLabelName){
                labelNames.add(s.getPlace());
            }
//            HashMap<String, String> map = test();//DataUtil.dataListY(byLabelName,date,type);
            HashMap<String, String> map = DataUtil.dataListY(byLabelName,date,type);
            if(count<9){
                map.put("industry_menu","本日");
            }else if(count<18){
                map.put("industry_menu","本周");
            }else if(count<27){
                map.put("industry_menu","本月");
            }else if(count<36){
                map.put("industry_menu","本年");

            }
            if(byLabelName!=null && byLabelName.size()>0)map.put("unit",byLabelName.get(0).getUnit());
            map.put("industry_type",place);
            list.add (map);
            count++;
        }
        return list;
    }
//    private HashMap test(){
//        HashMap<String, String> map = new HashMap<>();
//        map.put("key0","0.00");
//        map.put("key1","0.00");
//        map.put("key2","0.00");
//        map.put("key3","0.00");
//        map.put("key4","0.00");
//        map.put("key5","0.00");
//        map.put("key6","0.00");
//        map.put("key7","0.00");
//        map.put("key8","0.00");
//        map.put("key9","0.00");
//        map.put("key10","0.00");
//        map.put("key11","0.00");
//        map.put("key12","0.00");
//        map.put("key13","0.00");
//        map.put("key14","0.00");
//        map.put("key15","0.00");
//        map.put("key16","0.00");
//        map.put("key17","0.00");
//        map.put("key18","0.00");
//        map.put("key19","0.00");
//        map.put("key20","0.00");
//        map.put("key21","0.00");
//        return map;
//    }
}
