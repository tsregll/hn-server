package com.ruoyi.web.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import com.ruoyi.web.dataUtil.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/yxfs")
public class YunXingController {
    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     *运行区域（区域）
     * @return
     */
    @PostMapping("/yxqyqy")
    public JSONObject yxqyqy(){
        String name="运行区域（区域）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *运行方式（煤机）
     * @return
     */
    @PostMapping("/yxqymj")
    public JSONObject yxqymj(){
        String name="运行方式（煤机）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *运行方式（水电）
     * @return
     */
    @PostMapping("/yxqysd")
    public JSONObject yxqysd(){
        String name="运行方式（水电）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *运行方式（风电）
     * @return
     */
    @PostMapping("/yxqyfd")
    public JSONObject yxqyfd(){
        String name="运行方式（风电）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *运行方式（光伏）
     * @return
     */
    @PostMapping("/yxqygf")
    public JSONObject yxqygf(){
        String name="运行方式（光伏）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
}
