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
@RequestMapping("/scglbb")
public class ShengChanController extends BaseController {
    @Autowired
    private ISkBbLabelService skBbLabelService;
    /**
     *区域日报表（日）
     * @return
     */
    @PostMapping("/quyuday")
    public JSONObject quyuday(){
        String name="区域日报表（日）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *区域日报表（周）
     * @return
     */
    @PostMapping("/quyuweek")
    public JSONObject quyuweek(){
        String name="区域周报表（周）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *区域报表（月度和年度）
     * @return
     */
    @PostMapping("/quyumonth")
    public JSONObject quyumonth(){
        String name="区域报表（月度和年度）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *岳阳电厂日报表
     * @return
     */
    @PostMapping("/yueyangday")
    public JSONObject yueyangday(){
        String name="岳阳电厂日报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *岳阳电厂报表（月度和年度）
     * @return
     */
    @PostMapping("/yueyangmonth")
    public JSONObject yueyangmonth(){
        String name="岳阳电厂报表（月度和年度）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *岳阳电厂周报表
     * @return
     */
    @PostMapping("/yueyangweek")
    public JSONObject yueyangweek(){
        String name="岳阳电厂周报表 ";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *清能日报表
     * @return
     */
    @PostMapping("/qingnengday")
    public JSONObject qingnengday(){
        String name="清能日报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *清能周报表
     * @return
     */
    @PostMapping("/qingnengweek")
    public JSONObject qingnengweek(){
        String name="清能周报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *清能报表（月度和年度）
     * @return
     */
    @PostMapping("/qingnengmonth")
    public JSONObject qingnengmonth(){
        String name="清能报表（月度和年度）";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
    /**
     *清能报表（月度和年度）
     * @return
     */
    @PostMapping("/qingneng")
    public JSONObject qingneng(){
        String name="清能公司分析报表";
        List<SkBbLabel> byName = skBbLabelService.findByName (name);
        List<String> list=new ArrayList<> ();
        for(SkBbLabel s:byName){
            list.add (s.getLabel ());
        }
        return DataUtil.dataUtil (list);
    }
}
