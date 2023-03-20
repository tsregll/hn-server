package com.ruoyi.web.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nhgl")
public class NengHao1Controller extends BaseController {

    @Autowired
    private ISkBbLabelService skBbLabelService;



    /**
     *风电能耗
     * @return
     */
    @PostMapping("/fengdian")
    public JSONObject fengdian(){
        String name="风电能耗";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *光伏能耗
     * @return
     */
    @PostMapping("/guangfu")
    public JSONObject guangfu(){
        String name="光伏能耗";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *水电能耗
     * @return
     */
    @PostMapping("/shuidian")
    public JSONObject shuidian(){
        String name="水电能耗";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *煤机能耗
     * @return
     */
    @PostMapping("/meiji")
    public JSONObject meiji(){
        String name="煤机能耗";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *区域合计能耗
     * @return
     */
    @PostMapping("/heji")
    public JSONObject heji(){
        String name="区域合计能耗";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
}
