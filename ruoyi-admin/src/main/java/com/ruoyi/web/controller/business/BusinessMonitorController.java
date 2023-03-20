package com.ruoyi.web.controller.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.monitorUtil.ArtemisPostService;
import com.ruoyi.business.monitorUtil.mapper.CameraRequest;
import com.ruoyi.business.monitorUtil.mapper.CamerasRequest;
import com.ruoyi.business.monitorUtil.mapper.PreviewURLsRequest;
import com.ruoyi.business.monitorUtil.mapper.SearchRequest;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 决策事项Controller
 *
 * @author gwsh
 * @date 2021-03-02
 */
@RestController
@RequestMapping("/business/businessmonitorcontroller")
public class BusinessMonitorController extends BaseController {
    /**
     * 查询决策事项列表
     */
    @GetMapping("/list")
    public AjaxResult list(CamerasRequest cr) {
        String search = ArtemisPostService.cameras(cr);
        Map jsonToMap = JSONObject.parseObject(search);
        return AjaxResult.success(jsonToMap);
    }
    /**
     * 查询各企业列表
     */
    @GetMapping("/treeList")
    public AjaxResult treeList(CamerasRequest cr) {
        String search = ArtemisPostService.cameras2(cr);
        Map jsonToMap = JSONObject.parseObject(search);
//        List<String> list = new ArrayList<>();
//        List<String> tempList = JSON.parseObject(JSON.toJSONString(jsonToMap.get("data")),List.class);
//        List<Object> list = new ArrayList<>();
        Map map =(Map)jsonToMap.get("data");
        Object obj1 = map.get("list");
        List<Map<String,String>> result = new ArrayList<>();
        for(Object o : (List<Map<String,String>>) obj1){
            result.add(Map.class.cast(o));
        }
        List<Map<String,String>> resultList = new ArrayList<>();
        String indexCode = "";
        for(Map<String,String> m:result){
            if("华能湖南分公司".equals(m.get("name"))) resultList.add(m);
            if("岳阳电厂".equals(m.get("name"))) indexCode = m.get("indexCode");
            //岳阳电厂在数组索引1
            if(indexCode.equals(m.get("parentIndexCode"))) resultList.add(m);
        }
        for(Map<String,String> m:result){
            if(!indexCode.equals(m.get("parentIndexCode")) && !"华能湖南分公司".equals(m.get("name"))&& !"岳阳电厂".equals(m.get("name"))) {
                resultList.add(m);
            }
        }
        map.replace("list",map.get("list"),resultList);
        jsonToMap.replace("data",jsonToMap.get("data"),map);
        return AjaxResult.success(jsonToMap);
    }

    /**
     * 查询决策事项列表
     */
    @GetMapping("/byRegionIndexList")
    public AjaxResult byRegionIndexList(SearchRequest sr) {
//        ArrayList<String> list = new ArrayList<>();
//        list.add("1bae3093-cd98-480d-bbe3-b28e2d16344a");
//        sr.setRegionIndexCodes(list);
        String search = ArtemisPostService.search(sr);
        Map jsonToMap = JSONObject.parseObject(search);
        return AjaxResult.success(jsonToMap);
    }

    /**
     * 根据区域标识获取视频资源
     */
    @GetMapping("/byRegionIndexCodeList")
    public AjaxResult byRegionIndexCodeList(CameraRequest cr) {
//        cr.setRegionIndexCode("1bae3093-cd98-480d-bbe3-b28e2d16344a");
        cr.setPageNo(1);
        cr.setPageSize(300);
        String search = ArtemisPostService.search2(cr);
        Map jsonToMap = JSONObject.parseObject(search);
//        if(null!=jsonToMap){
//            Map tempMap = (Map) jsonToMap.get("data");
//            Integer value=(Integer)tempMap.get("total");
//            if(value==0){
//                return AjaxResult.error("暂无数据");
//            }
//        }
        return AjaxResult.success(jsonToMap);
    }

    @GetMapping("/previewURLs")
    public AjaxResult previewURLs(PreviewURLsRequest pr) {
        String search = ArtemisPostService.previewURLs(pr);
        Map jsonToMap = JSONObject.parseObject(search);
        return AjaxResult.success(jsonToMap);
    }


    @GetMapping("/returnUrlList")
    public AjaxResult returnUrlList(PreviewURLsRequest pr) {
        List<Map> returnMapList = new ArrayList<>();
        List<String> selectList = new ArrayList<>();
        selectList.add("hik");
        selectList.add("rtsp");
        selectList.add("rtmp");
        selectList.add("hls");
        for(Integer count = 0;count<selectList.size();count++){
            pr.setProtocol(selectList.get(count));
            String search = ArtemisPostService.previewURLs(pr);
            returnMapList.add(JSONObject.parseObject(search));
        }
        return AjaxResult.success(returnMapList);
    }
}
