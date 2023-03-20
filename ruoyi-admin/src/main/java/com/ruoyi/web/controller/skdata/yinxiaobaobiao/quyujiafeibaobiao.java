package com.ruoyi.web.controller.skdata.yinxiaobaobiao;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.view.DianJiaKuaiBaoZhiBiaoVo;
import com.ruoyi.web.controller.view.KeZaiShengNengYuanVo;
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
@RequestMapping("/business/qyjf")
public class quyujiafeibaobiao {

    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     * 区域价费导出
     */
    @PreAuthorize("@ss.hasPermi('business:quyujiafeiexport:export')")
    @Log(title = "区域价费导出", businessType = BusinessType.EXPORT)
    @GetMapping("/quyujiafeiexport")
    public AjaxResult quyujiafeiexport(@RequestParam(value = "date",required = false) String date,@RequestParam(value = "type",required = false) String type){
        if(type.trim().equals("0")){
            ExcelUtil<DianJiaKuaiBaoZhiBiaoVo> util = new ExcelUtil<DianJiaKuaiBaoZhiBiaoVo>(DianJiaKuaiBaoZhiBiaoVo.class);
            List<HashMap<String,String>> list = selectDjkbzb(date);
            if(StringUtils.isEmpty(date)){
                Integer year = LocalDate.now().getYear();
                Integer month = LocalDate.now().getMonthValue();
                Integer day = LocalDate.now().getDayOfMonth();
                date = year.toString()+"-"+(month<10?"0"+month:month.toString())+"-"+(day<10?"0"+day:day.toString());
            }
            String name = "电价快报指标统计表";
            List<DianJiaKuaiBaoZhiBiaoVo> listt = new ArrayList<>();
            for(HashMap<String,String> map :list){
                DianJiaKuaiBaoZhiBiaoVo q = new DianJiaKuaiBaoZhiBiaoVo();
                q.setLabelName(map.get("industry_type"));
                q.setKey0(map.get("key10"));
                q.setKey1(map.get("key21"));
                q.setKey2(map.get("key3"));
                q.setKey3(map.get("key14"));
                q.setKey4(map.get("key7"));
                q.setKey5(map.get("key18"));
                q.setKey6(map.get("key5"));
                q.setKey7(map.get("key16"));
                q.setKey8(map.get("key4"));
                q.setKey9(map.get("key15"));
                q.setKey10(map.get("key8"));
                q.setKey11(map.get("key19"));
                q.setKey12(map.get("key6"));
                q.setKey13(map.get("key17"));
                q.setKey14(map.get("key0"));
                q.setKey15(map.get("key11"));
                q.setKey16(map.get("key9"));
                q.setKey17(map.get("key20"));
                q.setKey18(map.get("key2"));
                q.setKey19(map.get("key1"));
                q.setKey20(map.get("key13"));
                q.setKey21(map.get("key12"));
                listt.add(q);
            }
            return util.exportExcelRewrite(listt,name,date);
        }else{
            ExcelUtil<KeZaiShengNengYuanVo> util = new ExcelUtil<KeZaiShengNengYuanVo>(KeZaiShengNengYuanVo.class);
            List<HashMap<String,String>> list = selectKzsnybtzb(date);;
            if(StringUtils.isEmpty(date)){
                Integer year = LocalDate.now().getYear();
                Integer month = LocalDate.now().getMonthValue();
                Integer day = LocalDate.now().getDayOfMonth();
                date = year.toString()+"-"+(month<10?"0"+month:month.toString())+"-"+(day<10?"0"+day:day.toString());
            }
            String name = "可再生能源补贴指标统计表";
            List<KeZaiShengNengYuanVo> listt = new ArrayList<>();
            for(HashMap<String,String> map :list){
                KeZaiShengNengYuanVo q = new KeZaiShengNengYuanVo();
                q.setLabelName(map.get("industry_type"));
                q.setKey0(map.get("key2"));
                q.setKey1(map.get("key9"));
                q.setKey2(map.get("key1"));
                q.setKey3(map.get("key8"));
                q.setKey4(map.get("key3"));
                q.setKey5(map.get("key4"));
                q.setKey6(map.get("key0"));
                q.setKey7(map.get("key7"));
                q.setKey8(map.get("key6"));
                q.setKey9(map.get("key5"));
                listt.add(q);
            }
            return util.exportExcelRewrite(listt,name,date);
        }
    }

    /**
     * 电价快报指标统计表
     *
     * @return
     */
    @GetMapping("/djkbzb")
    public JSONObject djkbzb(@RequestParam(value = "date",required = false) String date) {
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",selectDjkbzb(date));
        return jsonObject;
    }
    private List<HashMap<String,String>> selectDjkbzb(String date){

        String type = "3";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type = null;
        }
        if(date != null)date = date+"-01";
        String name="电价快报指标统计表";
        List<String> placeList = new ArrayList<>();
        List<HashMap<String,String>> list=new ArrayList<> ();
        placeList.add("分公司");
        placeList.add("火电");
        placeList.add("水电");
        placeList.add("风电");
        placeList.add("光伏");
        placeList.add("岳阳电厂");
        placeList.add("湘祁水电站");
        placeList.add("湖南苏宝顶风电");
        placeList.add("桂东风电");
        placeList.add("连坪风电");
        placeList.add("梅桥镇风电");
        placeList.add("岳阳新港光伏");
        placeList.add("岳阳擂鼓台光伏");
        placeList.add("岳阳三灰湖光伏");
        placeList.add("北湖风电");
        placeList.add("回龙圩风电");
        for(String place:placeList){
            List<SkBbLabel> byLabelName = skBbLabelService.findByPlaceOrder(name,place);
//            HashMap<String, String> map = test(byLabelName);
            HashMap<String, String> map = DataUtil.dataListY(byLabelName,date,type);
            map.put("industry_type",place);
            list.add (map);
        }
        return list;
    }

    /**
     * 风电头部数据
     *
     * @return
     */
    @GetMapping("/kzsnybtzb")
    public JSONObject kzsnybtzb(@RequestParam(value = "date",required = false) String date) {
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",selectKzsnybtzb(date));
        return jsonObject;
    }

    private List<HashMap<String,String>> selectKzsnybtzb(String date){
        String type = "3";
        if(date == null ||date.trim().equals("")||DataUtil.dateTimeToNowDay(date)){
            date =null;
            type = null;
        }
        if(date != null)date = date+"-01";
        String name="可再生能源补贴指标统计表";
        List<String> placeList = new ArrayList<>();
        List<HashMap<String,String>> list=new ArrayList<> ();
        placeList.add("分公司");
        placeList.add("湖南苏宝顶风电");
        placeList.add("桂东风电");
        placeList.add("岳阳新港光伏");
        placeList.add("连坪风电");
        placeList.add("岳阳擂鼓台光伏");
        placeList.add("梅桥镇风电");
        placeList.add("岳阳三灰湖光伏");
        placeList.add("北湖风电");
        placeList.add("回龙圩风电");
        for(String place:placeList){
            List<SkBbLabel> byLabelName = skBbLabelService.findByPlaceOrder(name,place);
//            HashMap<String, String> map = test(byLabelName);
            HashMap<String, String> map = DataUtil.dataListY(byLabelName,date,type);
            map.put("industry_type",place);
            list.add (map);
        }
        return list;
    }


//    private HashMap test(List<SkBbLabel> byLabelName){
//        HashMap<String, String> map = new HashMap<>();
//        for(Integer count =0;count<byLabelName.size();count++){
//            map.put("key"+count,count.toString()+"."+(count+1));
//        }
//        return map;
//    }
}
