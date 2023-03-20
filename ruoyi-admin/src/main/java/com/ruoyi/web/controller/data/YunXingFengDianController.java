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
//@RequestMapping("/yxfdss")
//public class YunXingFengDianController {
//    /**
//     * 苏宝顶风电实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/sbdfdss")
//    public JSONObject sbdfdss() {
//        String label = "HNHN.SBD.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 挂东风电实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/gdfdss")
//    public JSONObject gdfdss() {
//        String label = "HNHN.GD.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 连坪风电实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/lpfdss")
//    public JSONObject lpfdss() {
//        String label = "HNHN.LP.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 梅桥风电实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/mqfdss")
//    public JSONObject mqfdss() {
//        String label = "HNHN.MQ.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 北湖风电实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/bhfdss")
//    public JSONObject bhfdss() {
//        String label = "HNHN.BH.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 回龙圩风电实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/hlxfdss")
//    public JSONObject hlxfdss() {
//        String label = "HNHN.HLX.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//}
