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
//@RequestMapping("/yxsdss")
//public class YunXingShuiDianController {
//    /**
//     * 水电1#实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/yysd1ss")
//    public JSONObject yysd1ss() {
//        String label = "HNHN.XQ001.SJFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 水电2#实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/yysd2ss")
//    public JSONObject yysd2ss() {
//        String label = "HNHN.XQ002.SJFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 水电3#实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/yysd3ss")
//    public JSONObject yysd3ss() {
//        String label = "HNHN.XQ003.SJFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 水电4#实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/yysd4ss")
//    public JSONObject yysd4ss() {
//        String label = "HNHN.XQ004.SJFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//}
