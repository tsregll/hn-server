package com.ruoyi.web.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zmqy")
public class ZongMaoController {
    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     *总貌区域（年累计）
     * @return
     */
    @GetMapping("/zmqybb")
    public JSONObject zmqybb(){
        String name="总貌区域报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *总貌煤机报表
     * @return
     */
    @GetMapping("/zmmjbb")
    public JSONObject zmmjbb(){
        String name="总貌煤机报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *总貌风电报表（年累计）
     * @return
     */
    @GetMapping("/zmfgbb")
    public JSONObject zmfgbb(){
        String name="总貌风电报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *总貌水电报表（年累计）
     * @return
     */
    @GetMapping("/zmsdbb")
    public JSONObject zmsdbb(){
        String name="总貌水电报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *总貌供热报表（年累计）
     * @return
     */
    @GetMapping("/zmgrbb")
    public JSONObject zmgrbb(){
        String name="总貌供热报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *总貌光伏报表（年累计）
     * @return
     */
    @GetMapping("/zmgfbb")
    public JSONObject zmgfbb(){
        String name="总貌光伏报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
}
