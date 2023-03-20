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
@RequestMapping("/gfyx")
public class GuangFuYunXingController {
    @Autowired
    private ISkBbLabelService skBbLabelService;

    /**
     * 光伏总实时负荷
     *
     * @return
     */
    @GetMapping("/gfzss")
    public AjaxResult gfzss() {
        String name="运行区域（区域）";
        String labelName="实际负荷（到当日）";
        String place="光伏合计";
        SkBbLabel byNameqy = skBbLabelService.find (name, labelName, place);
        List<String> listqy = new ArrayList<> ();
        listqy.add (byNameqy.getLabel ());
        List<String> list1 = DataUtil.dataDateUtil (listqy);

        String namegf="运行方式（光伏）";
        String labelNamegf="实时负荷 每个时间点（0：00-24：00）";
        String placegf="新港光伏";
        SkBbLabel byNamexg = skBbLabelService.find (namegf, labelNamegf, placegf);
        List<String> listxg = new ArrayList<> ();
        listxg.add (byNamexg.getLabel ());
        List<String> list2 = DataUtil.dataDateUtil (listxg);

        String placelgt="擂鼓台光伏";
        SkBbLabel byNamelgt = skBbLabelService.find (namegf, labelNamegf, placelgt);
        List<String> listlgt = new ArrayList<> ();
        listlgt.add (byNamelgt.getLabel ());
        List<String> list3 = DataUtil.dataDateUtil (listlgt);

        String placesfh="三灰湖光伏";
        SkBbLabel byNamesfh = skBbLabelService.find (namegf, labelNamegf, placesfh);
        List<String> listsfh = new ArrayList<> ();
        listsfh.add (byNamesfh.getLabel ());
        List<String> list4 = DataUtil.dataDateUtil (listsfh);

        String placebyt="白羊田光伏";
        SkBbLabel byNamebyt = skBbLabelService.find (namegf, labelNamegf, placebyt);
        List<String> listbyt = new ArrayList<> ();
        listbyt.add (byNamebyt.getLabel ());
        List<String> list5 = DataUtil.dataDateUtil (listbyt);

        HashMap<String, Object> map1=new HashMap<> ();
        map1.put ("data", list1);
        map1.put ("name","光伏合计");
        map1.put ("type","line");
        map1.put ("symbolSize",0);
        map1.put ("symbol","circle");
        HashMap<String, Object> map2=new HashMap<> ();
        map2.put ("data", list2);
        map2.put ("name","新港光伏");
        map2.put ("type","line");
        map2.put ("symbolSize",0);
        map2.put ("symbol","circle");
        HashMap<String, Object> map3=new HashMap<> ();
        map3.put ("data", list3);
        map3.put ("name","擂鼓台光伏");
        map3.put ("type","line");
        map3.put ("symbolSize",0);
        map3.put ("symbol","circle");
        HashMap<String, Object> map4=new HashMap<> ();
        map4.put ("data", list4);
        map4.put ("name","三灰湖光伏");
        map4.put ("type","line");
        map4.put ("symbolSize",0);
        map4.put ("symbol","circle");
        HashMap<String, Object> map5=new HashMap<> ();
        map5.put ("data", list5);
        map5.put ("name","白羊田光伏");
        map5.put ("type","line");
        map5.put ("symbolSize",0);
        map5.put ("symbol","circle");
        List<HashMap<String,Object>> listzxt=new ArrayList<> ();
        listzxt.add (map1);
        listzxt.add (map2);
        listzxt.add (map3);
        listzxt.add (map4);
        listzxt.add (map5);
        List<String> time= DataUtil.datatimeUtil (listqy);
        HashMap<String,Object> timeAndData=new HashMap<> ();
        timeAndData.put ("data",listzxt);
        timeAndData.put ("time",time);


        return  AjaxResult.success (timeAndData);
    }


    /**
     * 光伏头部数据
     *
     * @return
     */
    @GetMapping("/gftb")
    public JSONObject gftb() {

        String name="运行方式（光伏）";
        String labelName="总负荷";
        String place="光伏总站";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);

        String place1="新港光伏";
        SkBbLabel byName1 = skBbLabelService.find (name, labelName, place1);

        String place2="擂鼓台光伏";
        SkBbLabel byName2 = skBbLabelService.find (name, labelName, place2);

        String place3="三灰湖光伏";
        SkBbLabel byName3 = skBbLabelService.find (name, labelName, place3);

        String place4="白羊田光伏";
        SkBbLabel byName4 = skBbLabelService.find (name, labelName, place4);

        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());
        list.add (byName1.getLabel ());
        list.add (byName2.getLabel ());
        list.add (byName3.getLabel ());
        list.add (byName4.getLabel ());

        return DataUtil.dataUtil (list);
    }
    /**
     * 运行方式（风电）情况
     */
    @GetMapping("gfyxqk")
    public JSONObject gfyxqk(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "type",required = false) String type){
        String name="运行方式（光伏）";
        String label="风向";
        List<SkBbLabel> byLabelName = skBbLabelService.findByLabelName (name, label);
        HashMap<String, String> map = DataUtil.dataListY (byLabelName,date,type);

        String label1="风速";
        List<SkBbLabel> byLabelName1 = skBbLabelService.findByLabelName (name, label1);
        HashMap<String, String> map1 = DataUtil.dataListY (byLabelName1,date,type);

        String label2="风速";
        List<SkBbLabel> byLabelName2 = skBbLabelService.findByLabelName (name, label2);
        HashMap<String, String> map2 = DataUtil.dataListY (byLabelName2,date,type);

        String label3="环境湿度";
        List<SkBbLabel> byLabelName3 = skBbLabelService.findByLabelName (name, label3);
        HashMap<String, String> map3 = DataUtil.dataListY (byLabelName3,date,type);

        String label4="气压";
        List<SkBbLabel> byLabelName4 = skBbLabelService.findByLabelName (name, label4);
        HashMap<String, String> map4 = DataUtil.dataListY (byLabelName4,date,type);

        String label6="总辐射";
        List<SkBbLabel> byLabelName6 = skBbLabelService.findByLabelName (name, label6);
        HashMap<String, String> map6 = DataUtil.dataListY (byLabelName6,date,type);

        String label7="直辐射";
        List<SkBbLabel> byLabelName7 = skBbLabelService.findByLabelName (name, label7);
        HashMap<String, String> map7 = DataUtil.dataListY (byLabelName7,date,type);

        String label8="散辐射";
        List<SkBbLabel> byLabelName8 = skBbLabelService.findByLabelName (name, label8);
        HashMap<String, String> map8 = DataUtil.dataListY (byLabelName8,date,type);


        List<HashMap<String,String>> list=new ArrayList<> ();
        list.add (map);
        list.add (map1);
        list.add (map2);
        list.add (map3);
        list.add (map4);
        list.add (map6);
        list.add (map7);
        list.add (map8);
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",list);
        return jsonObject;
    }
}
