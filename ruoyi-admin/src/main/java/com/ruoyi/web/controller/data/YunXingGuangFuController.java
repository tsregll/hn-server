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
//@RequestMapping("/yxgfss")
//public class YunXingGuangFuController {
//
//    /**
//     * 新港光伏实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/xggfss")
//    public JSONObject xggfss() {
//        String label = "HNHN.GFXG.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 擂鼓台光伏实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/ltggfss")
//    public JSONObject ltggfss() {
//        String label = "HNHN.GFLGT.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//    /**
//     * 三灰湖光伏实时负荷
//     *
//     * @return
//     */
//    @PostMapping("/shhgfss")
//    public JSONObject shhgfss() {
//        String label = "HNHN.GFSHH.SSFH.SKCAL";
//        List<String> list = new ArrayList<> ();
//        list.add (label);
//
//        return DataUtil.dataDateUtil (list);
//    }
//}
