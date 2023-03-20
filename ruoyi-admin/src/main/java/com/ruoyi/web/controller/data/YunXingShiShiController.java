//package com.ruoyi.web.controller.data;
//
//import com.alibaba.fastjson.JSONObject;
//import com.ruoyi.web.dataUtil.DataUtil;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/yxqyss")
//public class YunXingShiShiController {
//    /**
//     *岳阳全厂实时负荷
//     * @return
//     */
//    @PostMapping("/yyqcss")
//    public JSONObject yyqc(){
//        String label="HNHN.YYDC.SUM.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *岳阳1#机组实时负荷
//     * @return
//     */
//    @PostMapping("/yy1ss")
//    public JSONObject yy1ss(){
//        String label="HNHN.YYDC.001.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *岳阳2#机组实时负荷
//     * @return
//     */
//    @PostMapping("/yy2ss")
//    public JSONObject yy2ss(){
//        String label="HNHN.YYDC.002.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *岳阳3#机组实时负荷
//     * @return
//     */
//    @PostMapping("/yy3ss")
//    public JSONObject yy3ss(){
//        String label="HNHN.YYDC.003.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *岳阳4#机组实时负荷
//     * @return
//     */
//    @PostMapping("/yy4ss")
//    public JSONObject yy4ss(){
//        String label="HNHN.YYDC.004.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *岳阳5#机组实时负荷
//     * @return
//     */
//    @PostMapping("/yy5ss")
//    public JSONObject yy5ss(){
//        String label="HNHN.YYDC.005.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *岳阳6#机组实时负荷
//     * @return
//     */
//    @PostMapping("/yy6ss")
//    public JSONObject yy6ss(){
//        String label="HNHN.YYDC.006.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *光伏合计实时负荷
//     * @return
//     */
//    @PostMapping("/gfhjss")
//    public JSONObject gfhj(){
//        String label="HNHN.GFSUM.ZFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *擂台鼓光伏合计实时负荷
//     * @return
//     */
//    @PostMapping("/ltggfss")
//    public JSONObject ltggf(){
//        String label="HNHN.GFLGT.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *三灰湖光伏合计实时负荷
//     * @return
//     */
//    @PostMapping("/sfhgfss")
//    public JSONObject sfhgf(){
//        String label="HNHN.GFSHH.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *水电合计实时负荷
//     * @return
//     */
//    @PostMapping("/sdhjss")
//    public JSONObject sdhj(){
//        String label="HNHN.XQSUM.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *湘祁1#实时负荷
//     * @return
//     */
//    @PostMapping("/xq1ss")
//    public JSONObject xq1ss(){
//        String label="HNHN.XQ001.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *湘祁2#实时负荷
//     * @return
//     */
//    @PostMapping("/xq2ss")
//    public JSONObject xq2ss(){
//        String label="HNHN.XQ002.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *湘祁3#实时负荷
//     * @return
//     */
//    @PostMapping("/xq3ss")
//    public JSONObject xq3ss(){
//        String label="HNHN.XQ003.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *湘祁4#实时负荷
//     * @return
//     */
//    @PostMapping("/xq4ss")
//    public JSONObject xq4ss(){
//        String label="HNHN.XQ004.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *风电合计实时负荷
//     * @return
//     */
//    @PostMapping("/fdhjss")
//    public JSONObject fdhj(){
//        String label="HNHN.WDSUM.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *苏宝顶实时负荷
//     * @return
//     */
//    @PostMapping("/sbdss")
//    public JSONObject sbd(){
//        String label="HNHN.SBD.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *桂东实时负荷
//     * @return
//     */
//    @PostMapping("/gdss")
//    public JSONObject gdss(){
//        String label="HNHN.GD.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *连坪实时负荷
//     * @return
//     */
//    @PostMapping("/lpss")
//    public JSONObject lpss(){
//        String label="HNHN.LP.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *梅桥实时负荷
//     * @return
//     */
//    @PostMapping("/mqss")
//    public JSONObject mqss(){
//        String label="HNHN.MQ.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *北湖实时负荷
//     * @return
//     */
//    @PostMapping("/bhss")
//    public JSONObject bhss(){
//        String label="HNHN.BH.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *回龙圩实时负荷
//     * @return
//     */
//    @PostMapping("/hlxss")
//    public JSONObject hlxss(){
//        String label="HNHN.HLX.SJFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     *整个区域实时负荷
//     * @return
//     */
//    @PostMapping("/zgqyss")
//    public JSONObject zgqyss(){
//        String label="HNHN.QY.SUM.QYZFH.SKCAL";
//        List<String> list=new ArrayList<> ();
//        list.add (label);
//        return DataUtil.dataDateUtil (list);
//    }
//}
