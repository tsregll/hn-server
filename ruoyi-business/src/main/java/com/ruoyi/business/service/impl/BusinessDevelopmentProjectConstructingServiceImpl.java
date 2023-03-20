package com.ruoyi.business.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.business.vo.BusinessDevelopmentConstructingVo;
import com.ruoyi.business.vo.BusinessDevelopmentProjectConstructingQianDuanVo;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentProjectConstructingMapper;
import com.ruoyi.business.domain.BusinessDevelopmentProjectConstructing;
import com.ruoyi.business.service.IBusinessDevelopmentProjectConstructingService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展在建项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-04
 */
@Service
public class BusinessDevelopmentProjectConstructingServiceImpl implements IBusinessDevelopmentProjectConstructingService 
{
    @Autowired
    private BusinessDevelopmentProjectConstructingMapper businessDevelopmentProjectConstructingMapper;
    @Autowired
    private ISysDictTypeService dictTypeService;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展在建项目
     * 
     * @param id 规划发展在建项目ID
     * @return 规划发展在建项目
     */
    @Override
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingById(Long id)
    {
        BusinessDevelopmentProjectConstructing returnResult= businessDevelopmentProjectConstructingMapper.selectBusinessDevelopmentProjectConstructingById(id);
        String temp = returnResult.getProjectRegionDistrict();
        String head="";
        String end="";
        if(temp.length()>10){
            head=temp==null?"":temp.substring(0,10);
            end=temp==null?"":temp.substring(3);
        }else {
            head=temp==null?"":temp.substring(0,3);
            end=temp==null?"":temp.substring(3);
        }

        returnResult.setProjectRegionDistrict(head+"/"+end);
        return  returnResult;
    }

    //项目详情——返回字典对应中文给前端
    @Override
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingQianDuanById(Long id) {
        BusinessDevelopmentProjectConstructing returnResult= businessDevelopmentProjectConstructingMapper.selectBusinessDevelopmentProjectConstructingById(id);
        Map<String,String> type = selectDictDataByType("business_project_type");
        Map<String,String> modalities = selectDictDataByType("business_project_development_type");
        returnResult.setProjectType(type.get(returnResult.getProjectType()));
        returnResult.setProjectDevelopmentModalities(modalities.get(returnResult.getProjectDevelopmentModalities()));
        return  returnResult;
    }

    @Override
    public Map<String,Object> selectBusinessDevelopmentProjectConstructingById2(Long id) {
        Map<String,Object> returnMap = new HashMap<>();
        List<BusinessDevelopmentProjectConstructingQianDuanVo>  list = new ArrayList<>();
        Map<String,String> type = selectDictDataByType("business_project_type");
        Map<String,String> modalities = selectDictDataByType("business_project_development_type");
        BusinessDevelopmentProjectConstructing returnResult= businessDevelopmentProjectConstructingMapper.selectBusinessDevelopmentProjectConstructingById(id);
        BusinessDevelopmentProjectConstructingQianDuanVo temp1 = new BusinessDevelopmentProjectConstructingQianDuanVo("项目名称",returnResult.getProjectName(),"项目类别",type.get(returnResult.getProjectType()));
        BusinessDevelopmentProjectConstructingQianDuanVo temp2 = new BusinessDevelopmentProjectConstructingQianDuanVo("开发方式",modalities.get(returnResult.getProjectDevelopmentModalities()),"所在地区",returnResult.getProjectRegionDistrict());
        BusinessDevelopmentProjectConstructingQianDuanVo temp3 = new BusinessDevelopmentProjectConstructingQianDuanVo("容量（万千瓦）",returnResult.getProjectCapacity(),"主要施工单位",returnResult.getConstructionUnit());
        BusinessDevelopmentProjectConstructingQianDuanVo temp4 = new BusinessDevelopmentProjectConstructingQianDuanVo("设计单位",returnResult.getDesignUnit(),"监理单位",returnResult.getSupervisionUnit());
        list.add(temp1);
        list.add(temp2);
        list.add(temp3);
        list.add(temp4);
        returnMap.put("date",list);
        returnMap.put("title",returnResult.getProjectName()+"项目建设信息");
        returnMap.put("content",returnResult.getProjectIntroduction());
        return  returnMap;
    }

    @Override
    public BusinessDevelopmentProjectConstructing selectBusinessDevelopmentProjectConstructingByVoid() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentProjectConstructing returnResult= new BusinessDevelopmentProjectConstructing();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return  returnResult;
    }

    /**
     * 查询规划发展在建项目列表
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 规划发展在建项目
     */
    @Override
    public List<BusinessDevelopmentProjectConstructing> selectBusinessDevelopmentProjectConstructingList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
//        String listState = businessDevelopmentProjectConstructing.getListState();
//        if("0".equals(listState)){
//            return businessDevelopmentProjectConstructingMapper.selectBusinessDevelopmentProjectConstructingListByqt(businessDevelopmentProjectConstructing);
//        }else{
            return businessDevelopmentProjectConstructingMapper.selectBusinessDevelopmentProjectConstructingListByqt(businessDevelopmentProjectConstructing);
//        }
    }

    /**
     * 新增规划发展在建项目
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentProjectConstructing(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        businessDevelopmentProjectConstructing.setCreateTime(DateUtils.getNowDate());
        return businessDevelopmentProjectConstructingMapper.insertBusinessDevelopmentProjectConstructing(businessDevelopmentProjectConstructing);
    }

    /**
     * 修改规划发展在建项目
     * 
     * @param businessDevelopmentProjectConstructing 规划发展在建项目
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentProjectConstructing(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing)
    {
        businessDevelopmentProjectConstructing.setUpdateTime(DateUtils.getNowDate());
        return businessDevelopmentProjectConstructingMapper.updateBusinessDevelopmentProjectConstructing(businessDevelopmentProjectConstructing);
    }

    /**
     * 批量删除规划发展在建项目
     * 
     * @param ids 需要删除的规划发展在建项目ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentProjectConstructingByIds(Long[] ids)
    {
        return businessDevelopmentProjectConstructingMapper.deleteBusinessDevelopmentProjectConstructingByIds(ids);
    }

    /**
     * 删除规划发展在建项目信息
     * 
     * @param id 规划发展在建项目ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentProjectConstructingById(Long id)
    {
        return businessDevelopmentProjectConstructingMapper.deleteBusinessDevelopmentProjectConstructingById(id);
    }

    @Override
    public List<String> selectBusinessConstructingProjectNameList(String projectName) {
        return businessDevelopmentProjectConstructingMapper.selectBusinessConstructingProjectNameList(projectName);
    }

    @Override
    public List<String> selectBusinessConstructingOperatorByGroupList(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing) {
        List<String> returnList= businessDevelopmentProjectConstructingMapper.selectBusinessConstructingOperatorByGroupList(businessDevelopmentProjectConstructing);
        returnList.add(0,"请选择");
        return returnList;
    }

    @Override
    public List<BusinessDevelopmentConstructingVo> selectBusinessDevelopmentProjectConstructingList2(BusinessDevelopmentProjectConstructing businessDevelopmentProjectConstructing) {
        List<BusinessDevelopmentConstructingVo> returnList = new ArrayList<>();
        List<BusinessDevelopmentProjectConstructing> list = businessDevelopmentProjectConstructingMapper.selectBusinessDevelopmentProjectConstructingListByqt(businessDevelopmentProjectConstructing);
        for (BusinessDevelopmentProjectConstructing temp : list) {
            BusinessDevelopmentConstructingVo bdcv = new BusinessDevelopmentConstructingVo();
            bdcv.setId(temp.getId());
            //容量
            bdcv.setProjectCapacity(temp.getProjectCapacity());
            //开工日期
            bdcv.setProjectDate(temp.getProjectDate());
            //地区
            bdcv.setProjectRegionDistrict(temp.getProjectRegionDistrict());
            //项目名
            bdcv.setName(temp.getProjectName());
            bdcv.setValue(temp.getProjectName());
            List<String> axisList = new ArrayList<>();
            axisList.add(temp.getProjectXAxis());
            axisList.add(temp.getProjectYAxis());
            //坐标
            bdcv.setCoord(axisList);
            //类型标志默认为第一个
            bdcv.setFirstprojectNatureNumber("0");
            returnList.add(bdcv);
        }
        return  returnList;
    }

    //模拟删除对应id的节点
    @Override
    public Map<String, Object> deleteBusinessDevelopmentProjectConstructingNodeByIdToChang(String projectNode,Long id) {
        String vid = id.toString();
        Map<String, Object> returnMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        String[] splitId = projectNode.split(",");
        for (int i = 0; i < splitId.length; i++) {
            if(!vid.equals(splitId[i])){
                list.add(splitId[i]);
            }
        }
        projectNode="";
        for (String s : list) {
            projectNode += s+",";
        }
        returnMap.put("projectNode",projectNode);
        return returnMap;
    }

    @Override
    public AjaxResult constructingFileUpload(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
//            String fileName = FileUploadUtils.upload(filePath, file);
            Object fileName = FileUploadUtils.upload(filePath, file);
            return AjaxResult.success(fileName);
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
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
