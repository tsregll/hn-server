package com.ruoyi.business.service.impl;

import java.util.*;

import com.ruoyi.business.vo.BusinessDevelopmentProjectConstructingNodeVo;
import com.ruoyi.business.vo.constructingNodeQianDuanVo;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentProjectConstructingNodeMapper;
import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructingNode;
import com.ruoyi.business.service.IBusinessDevelopmentProjectConstructingNodeService;

/**
 * 规划发展在建项目关键节点Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-06
 */
@Service
public class BusinessDevelopmentProjectConstructingNodeServiceImpl implements IBusinessDevelopmentProjectConstructingNodeService 
{
    @Autowired
    private BusinessDevelopmentProjectConstructingNodeMapper businessDevelopmentProjectConstructingNodeMapper;
    @Autowired
    private ISysDictTypeService dictTypeService;
    /**
     * 查询规划发展在建项目关键节点
     * 
     * @param id 规划发展在建项目关键节点ID
     * @return 规划发展在建项目关键节点
     */
    @Override
    public BusinessDevelopmentProjectConstructingNode selectBusinessDevelopmentProjectConstructingNodeById(Long id)
    {
        return businessDevelopmentProjectConstructingNodeMapper.selectBusinessDevelopmentProjectConstructingNodeById(id);
    }

    /**
     * 查询规划发展在建项目关键节点列表
     * 
     * @param businessDevelopmentProjectConstructingNode 规划发展在建项目关键节点
     * @return 规划发展在建项目关键节点
     */
    @Override
    public List<BusinessDevelopmentProjectConstructingNode> selectBusinessDevelopmentProjectConstructingNodeList(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        return businessDevelopmentProjectConstructingNodeMapper.selectBusinessDevelopmentProjectConstructingNodeList(businessDevelopmentProjectConstructingNode);
    }

    /**
     * 新增规划发展在建项目关键节点
     * 
     * @param businessDevelopmentProjectConstructingNode 规划发展在建项目关键节点
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentProjectConstructingNode(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        businessDevelopmentProjectConstructingNode.setCreateTime(DateUtils.getNowDate());
        return businessDevelopmentProjectConstructingNodeMapper.insertBusinessDevelopmentProjectConstructingNode(businessDevelopmentProjectConstructingNode);
    }

    /**
     * 修改规划发展在建项目关键节点
     * 
     * @param businessDevelopmentProjectConstructingNode 规划发展在建项目关键节点
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentProjectConstructingNode(BusinessDevelopmentProjectConstructingNode businessDevelopmentProjectConstructingNode)
    {
        businessDevelopmentProjectConstructingNode.setUpdateTime(DateUtils.getNowDate());
        return businessDevelopmentProjectConstructingNodeMapper.updateBusinessDevelopmentProjectConstructingNode(businessDevelopmentProjectConstructingNode);
    }

    /**
     * 批量删除规划发展在建项目关键节点
     * 
     * @param ids 需要删除的规划发展在建项目关键节点ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentProjectConstructingNodeByIds(Long[] ids)
    {
        return businessDevelopmentProjectConstructingNodeMapper.deleteBusinessDevelopmentProjectConstructingNodeByIds(ids);
    }

    /**
     * 删除规划发展在建项目关键节点信息
     * 
     * @param id 规划发展在建项目关键节点ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentProjectConstructingNodeById(Long id)
    {
        return businessDevelopmentProjectConstructingNodeMapper.deleteBusinessDevelopmentProjectConstructingNodeById(id);
    }

    @Override
    public List<BusinessDevelopmentProjectConstructingNodeVo> selectBusinessDevelopmentProjectConstructingNodeVoByIds(String ids) {
        List<BusinessDevelopmentProjectConstructingNodeVo> returnList = new ArrayList<>();
        if(ids==null||"".equals(ids)){

        }else {
            String[] splitId = ids.split(",");
            Map<String,String> nodeStatus = selectDictDataByType("business_project_constructing_node_status");
            for (int i = 0; i <splitId.length ; i++) {
                Long id = Long.parseLong(splitId[i]);
                BusinessDevelopmentProjectConstructingNode bdpcn = businessDevelopmentProjectConstructingNodeMapper.selectBusinessDevelopmentProjectConstructingNodeById(id);
                String str1 = null==bdpcn.getStandardOne()||"".equals(bdpcn.getStandardOne())?"":("<P>1."+bdpcn.getStandardOne()+" ——"+nodeStatus.get(bdpcn.getStatusOne())+"</P>\r");
                String str2 = null==bdpcn.getStandardTwo()||"".equals(bdpcn.getStandardTwo())?"":("<P>2."+bdpcn.getStandardTwo()+" ——"+nodeStatus.get(bdpcn.getStatusTwo())+"</P>\r");
                String str3 = null==bdpcn.getStandardThree()||"".equals(bdpcn.getStandardThree())?"":("<P>3."+bdpcn.getStandardThree()+" ——"+nodeStatus.get(bdpcn.getStatusThree())+"</P>\r");
                String str4 = null==bdpcn.getStandardFour()||"".equals(bdpcn.getStandardFour())?"":("<P>4."+bdpcn.getStandardFour()+" ——"+nodeStatus.get(bdpcn.getStatusFour())+"</P>\r");
                String str5 = null==bdpcn.getStandardFive()||"".equals(bdpcn.getStandardFive())?"":("<P>5."+bdpcn.getStandardFive()+" ——"+nodeStatus.get(bdpcn.getStatusFive())+"</P>\r");
                String str6 = null==bdpcn.getStandardSix()||"".equals(bdpcn.getStandardSix())?"":("<P>6."+bdpcn.getStandardSix()+" ——"+nodeStatus.get(bdpcn.getStatusSix())+"</P>\r");
                String str7 = null==bdpcn.getStandardSeven()||"".equals(bdpcn.getStandardSeven())?"":("<P>7."+bdpcn.getStandardSeven()+" ——"+nodeStatus.get(bdpcn.getStatusSeven())+"</P>\r");
                String str8 = null==bdpcn.getStandardEight()||"".equals(bdpcn.getStandardEight())?"":("<P>8."+bdpcn.getStandardEight()+" ——"+nodeStatus.get(bdpcn.getStatusEight())+"</P>\r");
                String str9 = null==bdpcn.getStandardNine()||"".equals(bdpcn.getStandardNine())?"":("<P>9."+bdpcn.getStandardNine()+" ——"+nodeStatus.get(bdpcn.getStatusNine())+"</P>\r");
                String str10 = null==bdpcn.getStandardTen()||"".equals(bdpcn.getStandardTen())?"":("<P>10."+bdpcn.getStandardTen()+" ——"+nodeStatus.get(bdpcn.getStatusTen())+"</P>\r");
                String status = str1 +str2+str3+str4+str5+str6+str7+str8+str9+str10;
//            String Vid = VidToString(1L+i);
                BusinessDevelopmentProjectConstructingNodeVo temp = new BusinessDevelopmentProjectConstructingNodeVo(VidToString(1L+i),bdpcn.getNodeName(),bdpcn.getPlaningTime(),status);
                temp.setId(id);
                returnList.add(temp);
            }
        }
        return returnList;
    }

    @Override
    public List<Map<String,Object>> selectBusinessDevelopmentProjectConstructingNodeByIds(String ids) {
        List<List<constructingNodeQianDuanVo>> returnList = new ArrayList<>();
        List<Map<String,Object>> returnList2 = new ArrayList<>();
        if(ids==null||"".equals(ids)){

        }else {
            String[] splitId = ids.split(",");
            Map<String,String> nodeStatus = selectDictDataByType("business_project_constructing_node_status");
            for (int i = 0; i <splitId.length ; i++) {
                Long id = Long.parseLong(splitId[i]);
                BusinessDevelopmentProjectConstructingNode bdpcn = businessDevelopmentProjectConstructingNodeMapper.selectBusinessDevelopmentProjectConstructingNodeById(id);
                String str1 = null==bdpcn.getStandardOne()||"".equals(bdpcn.getStandardOne())?"":("<P>1."+bdpcn.getStandardOne()+" ——"+nodeStatus.get(bdpcn.getStatusOne())+"</P>\r");
                String str2 = null==bdpcn.getStandardTwo()||"".equals(bdpcn.getStandardTwo())?"":("<P>2."+bdpcn.getStandardTwo()+" ——"+nodeStatus.get(bdpcn.getStatusTwo())+"</P>\r");
                String str3 = null==bdpcn.getStandardThree()||"".equals(bdpcn.getStandardThree())?"":("<P>3."+bdpcn.getStandardThree()+" ——"+nodeStatus.get(bdpcn.getStatusThree())+"</P>\r");
                String str4 = null==bdpcn.getStandardFour()||"".equals(bdpcn.getStandardFour())?"":("<P>4."+bdpcn.getStandardFour()+" ——"+nodeStatus.get(bdpcn.getStatusFour())+"</P>\r");
                String str5 = null==bdpcn.getStandardFive()||"".equals(bdpcn.getStandardFive())?"":("<P>5."+bdpcn.getStandardFive()+" ——"+nodeStatus.get(bdpcn.getStatusFive())+"</P>\r");
                String str6 = null==bdpcn.getStandardSix()||"".equals(bdpcn.getStandardSix())?"":("<P>6."+bdpcn.getStandardSix()+" ——"+nodeStatus.get(bdpcn.getStatusSix())+"</P>\r");
                String str7 = null==bdpcn.getStandardSeven()||"".equals(bdpcn.getStandardSeven())?"":("<P>7."+bdpcn.getStandardSeven()+" ——"+nodeStatus.get(bdpcn.getStatusSeven())+"</P>\r");
                String str8 = null==bdpcn.getStandardEight()||"".equals(bdpcn.getStandardEight())?"":("<P>8."+bdpcn.getStandardEight()+" ——"+nodeStatus.get(bdpcn.getStatusEight())+"</P>\r");
                String str9 = null==bdpcn.getStandardNine()||"".equals(bdpcn.getStandardNine())?"":("<P>9."+bdpcn.getStandardNine()+" ——"+nodeStatus.get(bdpcn.getStatusNine())+"</P>\r");
                String str10 = null==bdpcn.getStandardTen()||"".equals(bdpcn.getStandardTen())?"":("<P>10."+bdpcn.getStandardTen()+" ——"+nodeStatus.get(bdpcn.getStatusTen())+"</P>\r");
//            String Vid = VidToString(1L+i);
//                bdpcn.setNodeName(VidToString(1L+i)+"、"+bdpcn.getNodeName());
//                bdpcn.setPlaningTime("计划完成日期："+bdpcn.getPlaningTime());
//                bdpcn.setStandardOne(str1);
//                bdpcn.setStandardTwo(str2);
//                bdpcn.setStandardThree(str3);
//                bdpcn.setStandardFour(str4);
//                bdpcn.setStandardFive(str5);
//                bdpcn.setStandardSix(str6);
//                bdpcn.setStandardSeven(str7);
//                bdpcn.setStandardEight(str8);
//                bdpcn.setStandardNine(str9);
//                bdpcn.setStandardTen(str10);
                List<constructingNodeQianDuanVo> list = new ArrayList<>();
//                list.add(new constructingNodeQianDuanVo(VidToString(1L+i)+"、"+bdpcn.getNodeName(),"0"));
//                list.add(new constructingNodeQianDuanVo("计划完成日期："+bdpcn.getPlaningTime(),"0"));
                if(!(null==bdpcn.getStandardOne()||"".equals(bdpcn.getStandardOne()))){
                    list.add(new constructingNodeQianDuanVo(str1,bdpcn.getStatusOne()));
                }
                if(!(null==bdpcn.getStandardTwo()||"".equals(bdpcn.getStandardTwo()))){
                    list.add(new constructingNodeQianDuanVo(str2,bdpcn.getStatusTwo()));
                }
                if(!(null==bdpcn.getStandardThree()||"".equals(bdpcn.getStandardThree()))){
                    list.add(new constructingNodeQianDuanVo(str3,bdpcn.getStatusThree()));
                }
                if(!(null==bdpcn.getStandardFour()||"".equals(bdpcn.getStandardFour()))){
                    list.add(new constructingNodeQianDuanVo(str4,bdpcn.getStatusFour()));
                }
                if(!(null==bdpcn.getStandardFive()||"".equals(bdpcn.getStandardFive()))){
                    list.add(new constructingNodeQianDuanVo(str5,bdpcn.getStatusFive()));
                }
                if(!(null==bdpcn.getStandardSix()||"".equals(bdpcn.getStandardSix()))){
                    list.add(new constructingNodeQianDuanVo(str6,bdpcn.getStatusSix()));
                }
                if(!(null==bdpcn.getStandardSeven()||"".equals(bdpcn.getStandardSeven()))){
                    list.add(new constructingNodeQianDuanVo(str7,bdpcn.getStatusSeven()));
                }
                if(!(null==bdpcn.getStandardEight()||"".equals(bdpcn.getStandardEight()))){
                    list.add(new constructingNodeQianDuanVo(str8,bdpcn.getStatusEight()));
                }
                if(!(null==bdpcn.getStandardNine()||"".equals(bdpcn.getStandardNine()))){
                    list.add(new constructingNodeQianDuanVo(str9,bdpcn.getStatusNine()));
                }
                if(!(null==bdpcn.getStandardTen()||"".equals(bdpcn.getStandardTen()))){
                    list.add(new constructingNodeQianDuanVo(str10,bdpcn.getStatusTen()));
                }
//                returnList.add(list);
                Map<String,Object> map = new HashMap<>();
                map.put("data",list);
                map.put("title",VidToString(1L+i)+"、"+bdpcn.getNodeName());
                if(bdpcn.getPlaningTime()==null || "".equals(bdpcn.getPlaningTime())){
                    map.put("planingTime","");
                }else{
                    map.put("planingTime",bdpcn.getPlaningTime());
                }
                returnList2.add(map);
//                returnList.add(bdpcn);
            }
        }
        return returnList2;
    }

    @Override
    public Map<String, Object> selectBusinessDevelopmentProjectConstructingNodeGroupByIds(String ids) {
        Map<String, Object> returnMap = new HashMap<>();
        int count = 1;
        List<Map<String, Object>> list1 = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();
        if(!"".equals(ids)){
            List<Map<String, Object>> list =selectBusinessDevelopmentProjectConstructingNodeByIds(ids);
//            if(list.size()<=8){
//                for (int i = list.size(); i <8 ; i++) {
//                    Map<String, Object>  map = new HashMap<>();
//                    list.add(map);
//                }
//                for (Map<String, Object> temp : list) {
//                    if(count<=4){
//                        list1.add(temp);
//                        count++;
//                    }else {
//                        list2.add(temp);
//                        count++;
//                    }
//
//                }
//            }
//            if(list.size()>8){
                //判断列表长度时候为偶数
                boolean isEven = list.size()%2==0;
                //列表对半的长度
                int length = list.size()/2 ;
                for (Map<String, Object> temp : list) {
                    if(isEven){
                        if(count<=length){
                            list1.add(temp);
                            count++;
                        }else {
                            list2.add(temp);
                            count++;
                        }
                    }else {
                        //list为奇数时多的加在list1上
                        if(count<=length+1){
                            list1.add(temp);
                            count++;
                        }else {
                            list2.add(temp);
                            count++;
                        }
                    }
                }
            }

//        }
        Collections.reverse(list2);
//        Map<String,Object> map1 = new HashMap<>();
//        map1.put("title","数组一");
//        map1.put("data",list1);
//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("title","数组二");
//        map2.put("data",list2);
        returnMap.put("list1",list1);
        returnMap.put("list2",list2);
        return returnMap;
    }

    private String VidToString(Long id) {
        String returnResult = id==1?"一":id==2?"二":id==3?"三":id==4?"四":id==5?"五":id==6?"六":id==7?"七":id==8?"八"
                :id==9?"九":id==10?"十":id==11?"十一":id==12?"十二":id==13?"十三":id==14?"十四":id.toString();
        return  returnResult;
    }

    private String getColor(String status) {
        String color = "black";
        if("1".equals(status)){
            color = "blue";
        }
        if("2".equals(status)){
            color = "green";
        }
        return color;
    }

    //-----------------------------------------------当前类使用的工具方法-----------------------------------------
    private Map<String,String> selectDictDataByType(String dictType){
        Map<String,String> returnMap = new HashMap<>();
        List<SysDictData> sysDictData = dictTypeService.selectDictDataByType(dictType);
        for(SysDictData dictData:sysDictData){
            returnMap.put(dictData.getDictValue(),dictData.getDictLabel());
        }
        return returnMap;
    }
}
