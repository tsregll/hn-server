package com.ruoyi.web.controller.skdata.yunxingfashi;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/yxqqy")
public class QuyuYunXingController {
    @Autowired
    private ISkBbLabelService skBbLabelService;

        /**
         * 全区域头部数据
         *
         * @return
         */
        @GetMapping("/qqytb")
        public JSONObject qqytb() {

            String name="运行区域（区域）";
            String labelName="总负荷";
            String place="区域";
            SkBbLabel byName = skBbLabelService.find (name, labelName, place);

            String labelName1="煤机总负荷";
            String place1="煤机";
            SkBbLabel byName1 = skBbLabelService.find (name, labelName1, place1);

            String labelName2="水电总负荷";
            String place2="水电";
            SkBbLabel byName2 = skBbLabelService.find (name, labelName2, place2);

            String labelName3="风电总负荷";
            String place3="风电";
            SkBbLabel byName3 = skBbLabelService.find (name, labelName3, place3);

            String labelName4="光伏总负荷";
            String place4="光伏";
            SkBbLabel byName4 = skBbLabelService.find (name, labelName4, place4);

            List<String> list = new ArrayList<> ();
            list.add (byName.getLabel ());
            list.add (byName1.getLabel ());
            list.add (byName2.getLabel ());
            list.add (byName3.getLabel ());
            list.add (byName4.getLabel ());

            return DataUtil.dataUtil (list);
        }
    /**
     * 全区域岳阳柱图数据
     *
     * @return
     */
    @GetMapping("/qqyyy")
    public JSONObject qqyyy() {
        String name="运行区域（区域）";
        String labelName="总装机容量";
        String place="岳阳煤机";
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


        String labelName1="总负荷";
        SkBbLabel byName7 = skBbLabelService.find (name, labelName1, place);

        SkBbLabel byName8 = skBbLabelService.find (name, labelName1, place1);

        SkBbLabel byName9 = skBbLabelService.find (name, labelName1, place2);

        SkBbLabel byName10 = skBbLabelService.find (name, labelName1, place3);

        SkBbLabel byName11 = skBbLabelService.find (name, labelName1, place4);

        SkBbLabel byName12 = skBbLabelService.find (name, labelName1, place5);

        SkBbLabel byName13 = skBbLabelService.find (name, labelName1, place6);
        List<String> list1 = new ArrayList<> ();
        list1.add (byName7.getLabel ());
        list1.add (byName8.getLabel ());
        list1.add (byName9.getLabel ());
        list1.add (byName10.getLabel ());
        list1.add (byName11.getLabel ());
        list1.add (byName12.getLabel ());
        list1.add (byName13.getLabel ());
//        return getJSONObject();
        return DataUtil.dataTbUtil (list,list1);
    }
    JSONObject getJSONObject(){
        List<String> list = new ArrayList<> ();
        HashMap<String, Object> map1=new HashMap<> ();
        HashMap<String, Object> map2=new HashMap<> ();
        HashMap<String, Object> map3=new HashMap<> ();
        List<HashMap<String, Object>> value=new ArrayList<> ();
        value.add (map2);
        value.add (map1);
        value.add (map3);
        List<String> list2 = new ArrayList<>();
        list.add("100");list.add("200");list.add("300");
        map1.put ("barWidth",20);
        map1.put ("barGap","-100%");
        map1.put ("data",list2);
        map1.put ("name","总负荷1");
        map1.put ("type","bar");
        map2.put ("barWidth",20);
        map2.put ("barGap","-100%");
        map2.put ("data",list2);
        map2.put ("name","总负荷2");
        map2.put ("type","bar");
        map3.put ("barWidth",20);
        map3.put ("barGap","-100%");
        map3.put ("data",list2);
        map3.put ("name","总负荷3");
        map3.put ("type","bar");
        JSONObject jsonObject=new JSONObject ();
        jsonObject.put ("data",value);
        return jsonObject;
    }
    /**
     * 全区域光伏柱图数据
     *
     * @return
     */
    @GetMapping("/qqygf")
    public JSONObject qqygf() {
        String name="运行区域（区域）";
        String labelName="总装机容量";
        String place="光伏合计";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);

        String place1="新港光伏";
        SkBbLabel byName1 = skBbLabelService.find (name, labelName, place1);

        String place2="擂鼓台光伏";
        SkBbLabel byName2 = skBbLabelService.find (name, labelName, place2);

        String place3="三灰湖光伏";
        SkBbLabel byName3 = skBbLabelService.find (name, labelName, place3);

        String place4="白羊田";
        SkBbLabel byName4_1 = skBbLabelService.find (name, labelName, place4);


        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());
        list.add (byName1.getLabel ());
        list.add (byName2.getLabel ());
        list.add (byName3.getLabel ());
        list.add (byName4_1.getLabel ());

        String labelName1="总负荷";
        SkBbLabel byName4 = skBbLabelService.find (name, labelName1, place);

        SkBbLabel byName5 = skBbLabelService.find (name, labelName1, place1);

        SkBbLabel byName6 = skBbLabelService.find (name, labelName1, place2);

        SkBbLabel byName7 = skBbLabelService.find (name, labelName1, place3);

        SkBbLabel byName4_2 = skBbLabelService.find (name, labelName1, place4);


        List<String> list1 = new ArrayList<> ();

        list1.add (byName4.getLabel ());
        list1.add (byName5.getLabel ());
        list1.add (byName6.getLabel ());
        list1.add (byName7.getLabel ());
        list1.add (byName4_2.getLabel ());

        return DataUtil.dataTbUtil (list,list1);
//        return getJSONObject();
    }
    /**
     * 全区域水电柱图数据
     *
     * @return
     */
    @GetMapping("/qqysd")
    public JSONObject qqysd() {
        String name="运行区域（区域）";
        String labelName="总装机容量";
        String place="水电合计";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);

        String place1="湘祁1#";
        SkBbLabel byName1 = skBbLabelService.find (name, labelName, place1);

        String place2="湘祁2#";
        SkBbLabel byName2 = skBbLabelService.find (name, labelName, place2);

        String place3="湘祁3#";
        SkBbLabel byName3 = skBbLabelService.find (name, labelName, place3);

        String place4="湘祁4#";
        SkBbLabel byName4 = skBbLabelService.find (name, labelName, place4);

//        String place5="江口";
//        SkBbLabel byName5_1 = skBbLabelService.find (name, labelName, place5);
        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());
        list.add (byName1.getLabel ());
        list.add (byName2.getLabel ());
        list.add (byName3.getLabel ());
        list.add (byName4.getLabel ());
//        list.add (byName5_1.getLabel ());

        List<String> list1 = new ArrayList<> ();

        String labelName1="总负荷";
        SkBbLabel byName5 = skBbLabelService.find (name, labelName1, place);

        SkBbLabel byName6 = skBbLabelService.find (name, labelName1, place1);

        SkBbLabel byName7 = skBbLabelService.find (name, labelName1, place2);

        SkBbLabel byName8 = skBbLabelService.find (name, labelName1, place3);

        SkBbLabel byName9 = skBbLabelService.find (name, labelName1, place4);

//        SkBbLabel byName5_2 = skBbLabelService.find (name, labelName1, place5);


        list1.add (byName5.getLabel ());
        list1.add (byName6.getLabel ());
        list1.add (byName7.getLabel ());
        list1.add (byName8.getLabel ());
        list1.add (byName9.getLabel ());
//        list1.add (byName5_2.getLabel ());
        return DataUtil.dataTbUtil (list,list1);
//        return getJSONObject();
    }
    /**
     * 全区域风电柱图数据
     *
     * @return
     */
    @GetMapping("/qqyfd")
    public JSONObject qqyfd() {
        String name="运行区域（区域）";
        String labelName="总装机容量";
        String place="风电合计";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);

        String place1="苏宝顶";
        SkBbLabel byName1 = skBbLabelService.find (name, labelName, place1);

        String place2="桂东";
        SkBbLabel byName2 = skBbLabelService.find (name, labelName, place2);

        String place3="连坪";
        SkBbLabel byName3 = skBbLabelService.find (name, labelName, place3);

        String place4="梅桥";
        SkBbLabel byName4 = skBbLabelService.find (name, labelName, place4);

        String place5="北湖";
        SkBbLabel byName5 = skBbLabelService.find (name, labelName, place5);

        String place6="回龙圩";
        SkBbLabel byName6 = skBbLabelService.find (name, labelName, place6);

        String place7="江口";
        SkBbLabel byName7 = skBbLabelService.find (name, labelName, place7);

        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());
        list.add (byName1.getLabel ());
        list.add (byName2.getLabel ());
        list.add (byName3.getLabel ());
        list.add (byName4.getLabel ());
        list.add (byName5.getLabel ());
        list.add (byName6.getLabel ());
        list.add (byName7.getLabel ());
        List<String> list1 = new ArrayList<> ();
        String labelName1="总负荷";
        SkBbLabel byNamesj = skBbLabelService.find (name, labelName1, place);

        SkBbLabel byName1sj = skBbLabelService.find (name, labelName1, place1);

        SkBbLabel byName2sj= skBbLabelService.find (name, labelName1, place2);

        SkBbLabel byName3sj = skBbLabelService.find (name, labelName1, place3);

        SkBbLabel byName4sj = skBbLabelService.find (name, labelName1, place4);

        SkBbLabel byName5sj = skBbLabelService.find (name, labelName1, place5);

        SkBbLabel byName6sj = skBbLabelService.find (name, labelName1, place6);

        SkBbLabel byName7sj = skBbLabelService.find (name, labelName1, place7);


        list1.add (byNamesj.getLabel ());
        list1.add (byName1sj.getLabel ());
        list1.add (byName2sj.getLabel ());
        list1.add (byName3sj.getLabel ());
        list1.add (byName4sj.getLabel ());
        list1.add (byName5sj.getLabel ());
        list1.add (byName6sj.getLabel ());
        list1.add (byName7sj.getLabel ());
        return DataUtil.dataTbUtil (list,list1);
//        return getJSONObject();
    }
    /**
     * 全区域折线图数据
     *
     * @return
     */
    @GetMapping("/qqyzxt")
    public AjaxResult qqyzxt() {
        String name="运行区域（区域）";
        String labelName="实时负荷，每个时间点（0：00-24：00）";
        String place="整个区域";
        SkBbLabel byName = skBbLabelService.find (name, labelName, place);
        List<String> list = new ArrayList<> ();
        list.add (byName.getLabel ());

        List<String> list1 = DataUtil.dataDateUtil (list);
//        List<String> list1 = new ArrayList<>();
        HashMap<String, Object> map1=new HashMap<> ();

        map1.put ("data", list1);
        map1.put ("name","实际负荷");
        map1.put ("type","line");
        map1.put ("symbolSize",0);
        map1.put ("symbol","circle");
        List<HashMap<String,Object>> listzxt=new ArrayList<> ();
        listzxt.add (map1);
        List<String> time= DataUtil.datatimeUtil (list);
        HashMap<String,Object> timeAndData=new HashMap<> ();
        JSONObject  jo1 = qqyyy();
        JSONObject  jo2 = qqygf();
        JSONObject  jo3 = qqyfd();
        JSONObject  jo4 = qqysd();
        List<String>  tempList1= (List)((Map) jo1.get("data2")).get("data")  ;
        List<String>  tempList2= (List)((Map) jo2.get("data2")).get("data")  ;
        List<String>  tempList3= (List)((Map) jo3.get("data2")).get("data")  ;
        List<String>  tempList4= (List)((Map) jo4.get("data2")).get("data")  ;
        Object[]  temp1= tempList1.toArray();
        Object[]  temp2= tempList2.toArray();
        Object[]  temp3= tempList3.toArray();
        Object[]  temp4= tempList4.toArray();
        String str1 = "                          负荷率    "+temp1[0]+"%    "+temp1[1]+ "%      "+temp1[2]+"%      "+temp1[3]+ "%      "+temp1[4]+ "%      "+temp1[5]+ "%      "+temp1[6]+"%";
        String str2 ="            负荷率         "+temp2[0]+"%                     "+temp2[1]+"%                    "+temp2[2]+"%                    "+temp2[3]+"%";;
        String str3 ="            负荷率       "+temp3[0]+"%      "+temp3[1]+"%       "+temp3[2]+"%      "+temp3[3]+"%      "+temp3[4]+"%       "+temp3[5]+"%        "+temp3[6]+"%                                  ";;
        String str4 ="              负荷率        "+temp4[0]+"%              "+temp4[1]+"%              "+temp4[2]+"%              "+temp4[3]+"%              "+temp4[4]+"%";;
        String title = str1+str2+str4+str3;
        timeAndData.put ("data",listzxt);
        timeAndData.put ("time",time);
        timeAndData.put ("title",title);
//        timeAndData.put ("time",list1);


        return  AjaxResult.success (timeAndData);
    }
}
