package com.ruoyi.web.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/grgw")
public class GongReGuanWangController extends BaseController {



    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     *各场站供汽指标
     * @return
     */
    @PostMapping("/gongre")
    public JSONObject yxqyqy(){
        String name="各场站供汽指标";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }

    @GetMapping("/selectgrgwt")
    public JSONObject selectgrgwt(){
        String name= "供热管网图信息实时展示表";
        List<String> lists = selectLable(name);
//        JSONObject jsob =  test(lists);
        JSONObject jsob =  DataUtil.dataUtil (lists);
        return jsob;
    }

    private List<String> selectLable(String name){
        List<String> returnLable = new ArrayList<>();
        List<SkBbLabel> byName = skBbLabelService.findByName(name);
        for(SkBbLabel labelName :byName){
            if(labelName!=null)returnLable.add (labelName.getLabel ());
        }
        return returnLable;
    }


//    private JSONObject test(List<String> lists){
//        HashMap<String, Object> map1=new HashMap<> ();
//        NumberFormat tfNumberFormat=NumberFormat.getNumberInstance ();
//        tfNumberFormat.setMaximumFractionDigits (0);
//        for(int i=0;i<lists.size();i++){
//            map1.put (lists.get (i).replace (".","_"),tfNumberFormat.format (new Double(i)).replace (",",""));
//        }
//        JSONObject jsonObject=new JSONObject ();
//        jsonObject.put ("data",map1);
//        return jsonObject;
//    }
}
