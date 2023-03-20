package com.ruoyi.web.controller.skdata.yunxingfashi;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mjyx")
public class MeiJiYunXingController {
    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     * 煤机总实时负荷
     *
     * @return
     */
    @GetMapping("/mjzss")
    public AjaxResult mjzss() {

        String name="运行区域（区域）";
        String labelName="实际负荷（到当日）";
        String place="岳阳全厂";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);
        List<String> listfdqy = new ArrayList<> ();
        listfdqy.add (byName.getLabel ());
        List<String> list1 = DataUtil.dataDateUtil (listfdqy);

        String namefd="运行方式（煤机）";
        String labelNamefd="实时负荷，每个时间点（0：00-24：00）";
        String placesbd="岳阳1#";
        SkBbLabel byNamefdsbd = skBbLabelService.find (namefd, labelNamefd, placesbd);
        List<String> listfdsbd = new ArrayList<> ();
        listfdsbd.add (byNamefdsbd.getLabel ());
        List<String> list2 = DataUtil.dataDateUtil (listfdsbd);

        String placegd="岳阳2#";
        SkBbLabel byNamegd = skBbLabelService.find (namefd, labelNamefd, placegd);
        List<String> listgd = new ArrayList<> ();
        listgd.add (byNamegd.getLabel ());
        List<String> list3 = DataUtil.dataDateUtil (listgd);

        String placelp="岳阳3#";
        SkBbLabel byNamelp = skBbLabelService.find (namefd, labelNamefd, placelp);
        List<String> listlp = new ArrayList<> ();
        listlp.add (byNamelp.getLabel ());
        List<String> list4 = DataUtil.dataDateUtil (listlp);

        String placemq="岳阳4#";
        SkBbLabel byNamemq = skBbLabelService.find (namefd, labelNamefd, placemq);
        List<String> listmq = new ArrayList<> ();
        listmq.add (byNamemq.getLabel ());
        List<String> list5 = DataUtil.dataDateUtil (listmq);

        String placebh="岳阳5#";
        SkBbLabel byNamebh = skBbLabelService.find (namefd, labelNamefd, placebh);
        List<String> listbh = new ArrayList<> ();
        listbh.add (byNamebh.getLabel ());
        List<String> list6 = DataUtil.dataDateUtil (listbh);

        String placehlx="岳阳6#";
        SkBbLabel byNamehlx = skBbLabelService.find (namefd, labelNamefd, placehlx);
        List<String> listhlx = new ArrayList<> ();
        listhlx.add (byNamehlx.getLabel ());
        List<String> list7 = DataUtil.dataDateUtil (listhlx);

        HashMap<String, Object> map1=new HashMap<> ();
        map1.put ("data", list1);
        map1.put ("name","岳阳全厂");
        map1.put ("type","line");
        map1.put ("symbolSize",0);
        map1.put ("symbol","circle");
        HashMap<String, Object> map2=new HashMap<> ();
        map2.put ("data", list2);
        map2.put ("name","岳阳1#");
        map2.put ("type","line");
        map2.put ("symbolSize",0);
        map2.put ("symbol","circle");
        HashMap<String, Object> map3=new HashMap<> ();
        map3.put ("data", list3);
        map3.put ("name","岳阳2#");
        map3.put ("type","line");
        map3.put ("symbolSize",0);
        map3.put ("symbol","circle");
        HashMap<String, Object> map4=new HashMap<> ();
        map4.put ("data", list4);
        map4.put ("name","岳阳3#");
        map4.put ("type","line");
        map4.put ("symbolSize",0);
        map4.put ("symbol","circle");
        HashMap<String, Object> map5=new HashMap<> ();
        map5.put ("data", list5);
        map5.put ("name","岳阳4#");
        map5.put ("type","line");
        map5.put ("symbolSize",0);
        map5.put ("symbol","circle");
        HashMap<String, Object> map6=new HashMap<> ();
        map6.put ("data", list6);
        map6.put ("name","岳阳5#");
        map6.put ("type","line");
        map6.put ("symbolSize",0);
        map6.put ("symbol","circle");
        HashMap<String, Object> map7=new HashMap<> ();
        map7.put ("data", list7);
        map7.put ("name","岳阳6#");
        map7.put ("type","line");
        map7.put ("symbolSize",0);
        map7.put ("symbol","circle");
        List<HashMap<String,Object>> listzxt=new ArrayList<> ();
        listzxt.add (map1);
        listzxt.add (map2);
        listzxt.add (map3);
        listzxt.add (map4);
        listzxt.add (map5);
        listzxt.add (map6);
        listzxt.add (map7);
        List<String> time= DataUtil.datatimeUtil (listfdqy);
        HashMap<String,Object> timeAndData=new HashMap<> ();
        timeAndData.put ("data",listzxt);
        timeAndData.put ("time",time);


        return  AjaxResult.success (timeAndData);
    }

    /**
     * 煤机头部数据
     *
     * @return
     */
    @GetMapping("/mjtb")
    public JSONObject qqytb() {
        String name="运行方式（煤机）";
        String labelName="总负荷";
        String place="岳阳全厂";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);

        String place1="岳阳1#";
        SkBbLabel byName1 = skBbLabelService.find (name, labelName, place1);

        String place2="岳阳2#";
        SkBbLabel byName2 = skBbLabelService.find (name, labelName, place2);

        String place3="岳阳3#";
        SkBbLabel byName3 = skBbLabelService.find (name, labelName, place3);

        String place4="岳阳4#";
        SkBbLabel byName4 = skBbLabelService.find (name, labelName, place4);

        String place5="岳阳5#";
        SkBbLabel byName5 = skBbLabelService.find (name, labelName, place5);

        String place6="岳阳6#";
        SkBbLabel byName6 = skBbLabelService.find (name, labelName, place6);

        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());
        list.add (byName1.getLabel ());
        list.add (byName2.getLabel ());
        list.add (byName3.getLabel ());
        list.add (byName4.getLabel ());
        list.add (byName5.getLabel ());
        list.add (byName6.getLabel ());
        return DataUtil.dataUtil (list);
    }
    /**
     * 煤机运行参数
     */
    @GetMapping("mjyxcs")
    public JSONObject mjhbzb(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="运行方式（煤机）";
        String label="主汽压力";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="主汽温度";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="再热汽温";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="凝汽器压力";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="NOX浓度 A侧入口";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="NOX浓度 B侧入口";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="NOX浓度 CEMS";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="SO2浓度 原烟气";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="SO2浓度 CEMS";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String name9="运行方式（煤机）";
        String label9="粉尘浓度";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name9, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String name10="运行方式（煤机）";
        String label10="负荷率";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name10, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
        list.add (map5);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        list.add (map9);
        list.add (map10);
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }
}
