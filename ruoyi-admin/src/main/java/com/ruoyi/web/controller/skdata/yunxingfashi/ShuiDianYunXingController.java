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
@RequestMapping("/sdyx")
public class ShuiDianYunXingController {
    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     * 水电总实时负荷
     *
     * @return
     */
    @GetMapping("/sdzss")
    public AjaxResult sdzss() {
        String name="运行区域（区域）";
        String labelName="实际负荷（到当日）";
        String place="水电合计";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);
        List<String> listfdqy = new ArrayList<> ();
        listfdqy.add (byName.getLabel ());
        List<String> list1 = DataUtil.dataDateUtil (listfdqy);

        String namefd="运行方式（水电）";
        String labelNamefd="实时负荷，每个时间点（0：00-24：00）";
        String placesbd="1#机组";
        SkBbLabel byNamefdsbd = skBbLabelService.find (namefd, labelNamefd, placesbd);
        List<String> listfdsbd = new ArrayList<> ();
        listfdsbd.add (byNamefdsbd.getLabel ());
        List<String> list2 = DataUtil.dataDateUtil (listfdsbd);

        String placegd="2#机组";
        SkBbLabel byNamegd = skBbLabelService.find (namefd, labelNamefd, placegd);
        List<String> listgd = new ArrayList<> ();
        listgd.add (byNamegd.getLabel ());
        List<String> list3 = DataUtil.dataDateUtil (listgd);

        String placelp="3#机组";
        SkBbLabel byNamelp = skBbLabelService.find (namefd, labelNamefd, placelp);
        List<String> listlp = new ArrayList<> ();
        listlp.add (byNamelp.getLabel ());
        List<String> list4 = DataUtil.dataDateUtil (listlp);

        String placemq="4#机组";
        SkBbLabel byNamemq = skBbLabelService.find (namefd, labelNamefd, placemq);
        List<String> listmq = new ArrayList<> ();
        listmq.add (byNamemq.getLabel ());
        List<String> list5 = DataUtil.dataDateUtil (listmq);
        HashMap<String, Object> map1=new HashMap<> ();
        map1.put ("data", list1);
        map1.put ("name","水电合计");
        map1.put ("type","line");
        map1.put ("symbolSize",0);
        map1.put ("symbol","circle");
        HashMap<String, Object> map2=new HashMap<> ();
        map2.put ("data", list2);
        map2.put ("name","1#机组");
        map2.put ("type","line");
        map2.put ("symbolSize",0);
        map2.put ("symbol","circle");
        HashMap<String, Object> map3=new HashMap<> ();
        map3.put ("data", list3);
        map3.put ("name","2#机组");
        map3.put ("type","line");
        map3.put ("symbolSize",0);
        map3.put ("symbol","circle");
        HashMap<String, Object> map4=new HashMap<> ();
        map4.put ("data", list4);
        map4.put ("name","3#机组");
        map4.put ("type","line");
        map4.put ("symbolSize",0);
        map4.put ("symbol","circle");
        HashMap<String, Object> map5=new HashMap<> ();
        map5.put ("data", list5);
        map5.put ("name","4#机组");
        map5.put ("type","line");
        map5.put ("symbolSize",0);
        map5.put ("symbol","circle");


        List<HashMap<String,Object>> listzxt=new ArrayList<> ();
        listzxt.add (map1);
        listzxt.add (map2);
        listzxt.add (map3);
        listzxt.add (map4);
        listzxt.add (map5);
        List<String> time= DataUtil.datatimeUtil (listfdqy);
        HashMap<String,Object> timeAndData=new HashMap<> ();
        timeAndData.put ("data",listzxt);
        timeAndData.put ("time",time);


        return  AjaxResult.success (timeAndData);
    }

    /**
     * 水电头部数据
     *
     * @return
     */
    @GetMapping("/sdtb")
    public JSONObject sdtb() {
        String name="运行方式（水电）";
        String labelName="上游水位";
        String place="湘祁水电";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);

        String labelName1="下游水位";
        SkBbLabel byName1 = skBbLabelService.find (name, labelName1, place);

        String labelName2="入库流量";
        SkBbLabel byName2 = skBbLabelService.find (name, labelName2, place);

        String labelName3="弧门总开度";
        SkBbLabel byName3 = skBbLabelService.find (name, labelName3, place);

        String labelName4="总负荷";
        SkBbLabel byName4 = skBbLabelService.find (name, labelName4, place);

        String place5="1#机组";
        SkBbLabel byName5 = skBbLabelService.find (name, labelName4, place5);

        String place6="2#机组";
        SkBbLabel byName6 = skBbLabelService.find (name, labelName4, place6);

        String place7="3#机组";
        SkBbLabel byName7 = skBbLabelService.find (name, labelName4, place7);

        String place8="4#机组";
        SkBbLabel byName8 = skBbLabelService.find (name, labelName4, place8);

        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());
        list.add (byName1.getLabel ());
        list.add (byName2.getLabel ());
        list.add (byName3.getLabel ());
        list.add (byName4.getLabel ());
        list.add (byName5.getLabel ());
        list.add (byName6.getLabel ());
        list.add (byName7.getLabel ());
        list.add (byName8.getLabel ());
        return DataUtil.dataUtil (list);
    }
    /**
     * 水电参数
     */
    @GetMapping("sdcs")
    public JSONObject qingnengfenxianbaobiao(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="运行方式（水电）";
        String label="有功";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="无功";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="机端电流A";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="机端电流B";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="机端电流C";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label5="机端电压A";
        List<SkBbLabel> byLabelName5 = skBbLabelService.findByLabelName (name, label5);
        HashMap<String, String> map5 = DataUtil.dataListY (byLabelName5,date,type);

        String label6="机端电压B";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="机端电压C";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="导叶开度";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);

        String label9="桨叶开度";
        List<SkBbLabel> byLabelName9 = skBbLabelService.findByLabelName (name, label9);
        HashMap<String, String> map9 = DataUtil.dataListY (byLabelName9,date,type);

        String label10="励磁电流";
        List<SkBbLabel> byLabelName10 = skBbLabelService.findByLabelName (name, label10);
        HashMap<String, String> map10 = DataUtil.dataListY (byLabelName10,date,type);

        String label11="励磁电压";
        List<SkBbLabel> byLabelName11 = skBbLabelService.findByLabelName (name, label11);
        HashMap<String, String> map11 = DataUtil.dataListY (byLabelName11,date,type);

        String label12="励磁变温度";
        List<SkBbLabel> byLabelName12 = skBbLabelService.findByLabelName (name, label12);
        HashMap<String, String> map12 = DataUtil.dataListY (byLabelName12,date,type);

        String label13="正推瓦温1#";
        List<SkBbLabel> byLabelName13 = skBbLabelService.findByLabelName (name, label13);
        HashMap<String, String> map13 = DataUtil.dataListY (byLabelName13,date,type);

        String label14="正推瓦温2#";
        List<SkBbLabel> byLabelName14 = skBbLabelService.findByLabelName (name, label14);
        HashMap<String, String> map14 = DataUtil.dataListY (byLabelName14,date,type);

        String label15="反推瓦温1#";
        List<SkBbLabel> byLabelName15 = skBbLabelService.findByLabelName (name, label15);
        HashMap<String, String> map15 = DataUtil.dataListY (byLabelName15,date,type);

        String label16="反推瓦温2#";
        List<SkBbLabel> byLabelName16 = skBbLabelService.findByLabelName (name, label16);
        HashMap<String, String> map16 = DataUtil.dataListY (byLabelName16,date,type);

        String label17="空冷机冷风1#";
        List<SkBbLabel> byLabelName17 = skBbLabelService.findByLabelName (name, label17);
        HashMap<String, String> map17 = DataUtil.dataListY (byLabelName17,date,type);

        String label18="空冷机冷风2#";
        List<SkBbLabel> byLabelName18 = skBbLabelService.findByLabelName (name, label18);
        HashMap<String, String> map18 = DataUtil.dataListY (byLabelName18,date,type);

        String label19="空冷机热风1#";
        List<SkBbLabel> byLabelName19 = skBbLabelService.findByLabelName (name, label19);
        HashMap<String, String> map19 = DataUtil.dataListY (byLabelName19,date,type);

        String label20="空冷机热风2#";
        List<SkBbLabel> byLabelName20 = skBbLabelService.findByLabelName (name, label20);
        HashMap<String, String> map20 = DataUtil.dataListY (byLabelName20,date,type);

        String label21="进气口压力";
        List<SkBbLabel> byLabelName21 = skBbLabelService.findByLabelName (name, label21);
        HashMap<String, String> map21 = DataUtil.dataListY (byLabelName21,date,type);

        String label22="漏油箱油位";
        List<SkBbLabel> byLabelName22 = skBbLabelService.findByLabelName (name, label22);
        HashMap<String, String> map22 = DataUtil.dataListY (byLabelName22,date,type);

        String label23="轴承油箱油位";
        List<SkBbLabel> byLabelName23 = skBbLabelService.findByLabelName (name, label23);
        HashMap<String, String> map23 = DataUtil.dataListY (byLabelName23,date,type);

        String label24="压油罐压力";
        List<SkBbLabel> byLabelName24 = skBbLabelService.findByLabelName (name, label24);
        HashMap<String, String> map24 = DataUtil.dataListY (byLabelName24,date,type);

        String label25="压油罐油位";
        List<SkBbLabel> byLabelName25 = skBbLabelService.findByLabelName (name, label25);
        HashMap<String, String> map25 = DataUtil.dataListY (byLabelName25,date,type);
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
        list.add (map11);
        list.add (map12);
        list.add (map13);
        list.add (map14);
        list.add (map15);
        list.add (map16);
        list.add (map17);
        list.add (map18);
        list.add (map19);
        list.add (map20);
        list.add (map21);
        list.add (map22);
        list.add (map23);
        list.add (map24);
        list.add (map25);

        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }
}
