package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.BusinessDevelopmentConstructionPreparationVo;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentConstructionPreparationMapper;
import com.ruoyi.business.domain.BusinessDevelopmentConstructionPreparation;
import com.ruoyi.business.service.IBusinessDevelopmentConstructionPreparationService;

/**
 * 规划发展施工准备项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-28
 */
@Service
public class BusinessDevelopmentConstructionPreparationServiceImpl implements IBusinessDevelopmentConstructionPreparationService 
{
    @Autowired
    private BusinessDevelopmentConstructionPreparationMapper businessDevelopmentConstructionPreparationMapper;
    @Autowired
    private ISysDictTypeService dictTypeService;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展施工准备项目
     * 
     * @param id 规划发展施工准备项目ID
     * @return 规划发展施工准备项目
     */
    @Override
    public BusinessDevelopmentConstructionPreparation selectBusinessDevelopmentConstructionPreparationById(Long id)
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentConstructionPreparation returnResult=businessDevelopmentConstructionPreparationMapper.selectBusinessDevelopmentConstructionPreparationById(id);
//        returnResult.setOperator(loginUser.getUser().getNickName());
//        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
//        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String temp = returnResult.getProjectRegionDistrict();
        String head=temp==null?"":temp.substring(0,3);
        String end=temp==null?"":temp.substring(3);
        returnResult.setProjectRegionDistrict(head+"/"+end);
        return returnResult;
//        return businessDevelopmentConstructionPreparationMapper.selectBusinessDevelopmentConstructionPreparationById(id);
    }

    /**
     * 查询规划发展施工准备项目列表
     * 
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 规划发展施工准备项目
     */
    @Override
    public List<BusinessDevelopmentConstructionPreparation> selectBusinessDevelopmentConstructionPreparationList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        Double tcqb = new Double(0);
        Double kgqb = new Double(0);
        Double tczq = new Double(0);
        Double kgzq = new Double(0);
        Double tcqb1 = new Double(0);
        Double kgqb1 = new Double(0);
        Double tczq1 = new Double(0);
        Double kgzq1 = new Double(0);
        Long pid1 = 1L;
        Long pid2 = 1L;
        Long pid3 = 1L;
        Long pid4 = 1L;
//        Map<String,String> projectNatrue = selectDictDataByType("business_development_construction_natrue");
        List<BusinessDevelopmentConstructionPreparation>  returnList = businessDevelopmentConstructionPreparationMapper.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
        List<BusinessDevelopmentConstructionPreparation> list1 = new ArrayList<>();
        List<BusinessDevelopmentConstructionPreparation> list2 = new ArrayList<>();
        List<BusinessDevelopmentConstructionPreparation> list3 = new ArrayList<>();
        List<BusinessDevelopmentConstructionPreparation> list4 = new ArrayList<>();
        //项目性质
        BusinessDevelopmentConstructionPreparation temp1 = new BusinessDevelopmentConstructionPreparation();
        BusinessDevelopmentConstructionPreparation temp2 = new BusinessDevelopmentConstructionPreparation();
        BusinessDevelopmentConstructionPreparation temp3 = new BusinessDevelopmentConstructionPreparation();
        BusinessDevelopmentConstructionPreparation temp4 = new BusinessDevelopmentConstructionPreparation();
        //按项目性质分类
        Map<String,String> natrue = selectDictDataByType("business_development_construction_natrue");
        for (BusinessDevelopmentConstructionPreparation temp : returnList) {
            if("-".equals(temp.getProjectCapacity())||"/".equals(temp.getProjectCapacity())){
                temp.setProjectCapacity("0.000");
            }
            //建设容量为不必填
            if("/".equals(temp.getProjectCapacityRecord())||"-".equals(temp.getProjectCapacityRecord())|| null==temp.getProjectCapacityRecord()){
                temp.setProjectCapacityRecord("0.000");
            }
            if(null!=temp.getProjectNature()){
                String[] projectNatures = temp.getProjectNature().split(",");
                for (int i = 0; i < projectNatures.length; i++) {
                    if(null==temp.getFirstprojectNatureNumber()){
                        temp.setFirstprojectNatureNumber(projectNatures[i]);
                    }else {
                        if(Integer.parseInt(projectNatures[i])<Integer.parseInt(temp.getFirstprojectNatureNumber())){
                            temp.setFirstprojectNatureNumber(projectNatures[i]);
                        }
                    }
                }
                temp.setFirstprojectNature(natrue.get(temp.getFirstprojectNatureNumber()));
            }
            if(null!=temp.getProjectNature()){
                if(temp.getProjectNature().contains(",")){
                    String[] str = temp.getProjectNature().split(",");
                    //判断各项目性质是否为空，为空时不计入列表
                    for (int i = 0; i <str.length ; i++) {
                        if("0".equals(str[i])){
                            temp.setPid(pid1);
                            pid1++;
                            tcqb += Double.parseDouble(temp.getProjectCapacity());
                            if(null!=temp.getProjectCapacityRecord()){
                                tcqb1 += Double.parseDouble(temp.getProjectCapacityRecord());
                            }
//                            ToolUtils.size3();
                            if(null==temp1.getProjectCapacity()){
                                temp1.setProjectName("投产确保项目");
                                temp1.setProjectCapacity(ToolUtils.size3(tcqb));
                                temp1.setProjectCapacityRecord(ToolUtils.size3(tcqb1));
                                list1.add(temp1);
                            }else {
                                temp1.setProjectCapacity(ToolUtils.size3(tcqb));
                                temp1.setProjectCapacityRecord(ToolUtils.size3(tcqb1));
                            }
                            list1.add(temp);
                        }
                        if("1".equals(str[i])){
                            temp.setPid(pid2);
                            pid2++;
                            kgqb += Double.parseDouble(temp.getProjectCapacity());
                            if(null!=temp.getProjectCapacityRecord()){
                                kgqb1 += Double.parseDouble(temp.getProjectCapacityRecord());
                            }
                            if(null==temp2.getProjectCapacity()){
                                temp2.setProjectName("开工确保项目");
                                temp2.setProjectCapacity(ToolUtils.size3(kgqb));
                                temp2.setProjectCapacityRecord(ToolUtils.size3(kgqb1));
                                list2.add(temp2);
                            }else {
                                temp2.setProjectCapacity(ToolUtils.size3(kgqb));
                                temp2.setProjectCapacityRecord(ToolUtils.size3(kgqb1));
                            }
                            list2.add(temp);
                        }
                        if("2".equals(str[i])){
                            temp.setPid(pid3);
                            pid3++;
                            tczq += Double.parseDouble(temp.getProjectCapacity());
                            if(null!=temp.getProjectCapacityRecord()){
                                tczq1 += Double.parseDouble(temp.getProjectCapacityRecord());
                            }
                            if(null==temp3.getProjectCapacity()){
                                temp3.setProjectName("投产争取项目");
                                temp3.setProjectCapacity(ToolUtils.size3(tczq));
                                temp3.setProjectCapacityRecord(ToolUtils.size3(tczq1));
                                list3.add(temp3);
                            }else {
                                temp3.setProjectCapacity(ToolUtils.size3(tczq));
                                temp3.setProjectCapacityRecord(ToolUtils.size3(tczq1));
                            }
                            list3.add(temp);
                        }
                        if("3".equals(str[i])){
                            temp.setPid(pid4);
                            pid4++;
                            kgzq += Double.parseDouble(temp.getProjectCapacity());
                            if(null!=temp.getProjectCapacityRecord()){
                                kgzq1 += Double.parseDouble(temp.getProjectCapacityRecord());
                            }
                            if(null==temp4.getProjectCapacity()){
                                temp4.setProjectName("开工争取项目");
                                temp4.setProjectCapacity(ToolUtils.size3(kgzq));
                                temp4.setProjectCapacityRecord(ToolUtils.size3(kgzq1));
                                list4.add(temp4);
                            }else {
                                temp4.setProjectCapacity(ToolUtils.size3(kgzq));
                                temp4.setProjectCapacityRecord(ToolUtils.size3(kgzq1));
                            }
                            list4.add(temp);
                        }
                    }
                }else {
//                    if("0".equals(temp.getProjectNature())){
//                        temp.setPid(pid1);
//                        pid1++;
//                        tcqb += Double.parseDouble(temp.getProjectCapacity());
//                        if(null==temp1.getProjectCapacity()){
//                            temp1.setProjectName("投产确保项目");
//                            temp1.setProjectCapacity(ToolUtils.size3(tcqb));
//                            list1.add(temp1);
//                        }else {
//                            temp1.setProjectCapacity(ToolUtils.size3(tcqb));
//                        }
//                        list1.add(temp);
//                    }
                    if("0".equals(temp.getProjectNature())){
                        temp.setPid(pid1);
                        pid1++;
                        tcqb += Double.parseDouble(temp.getProjectCapacity());
                        if(null!=temp.getProjectCapacityRecord()){
                            tcqb1 += Double.parseDouble(temp.getProjectCapacityRecord());
                        }
//                            ToolUtils.size3();
                        if(null==temp1.getProjectCapacity()){
                            temp1.setProjectName("投产确保项目");
                            temp1.setProjectCapacity(ToolUtils.size3(tcqb));
                            temp1.setProjectCapacityRecord(ToolUtils.size3(tcqb1));
                            list1.add(temp1);
                        }else {
                            temp1.setProjectCapacity(ToolUtils.size3(tcqb));
                            temp1.setProjectCapacityRecord(ToolUtils.size3(tcqb1));
                        }
                        list1.add(temp);
                    }
                    if("1".equals(temp.getProjectNature())){
                        temp.setPid(pid2);
                        pid2++;
                        kgqb += Double.parseDouble(temp.getProjectCapacity());
                        if(null!=temp.getProjectCapacityRecord()){
                            kgqb1 += Double.parseDouble(temp.getProjectCapacityRecord());
                        }
                        if(null==temp2.getProjectCapacity()){
                            temp2.setProjectName("开工确保项目");
                            temp2.setProjectCapacity(ToolUtils.size3(kgqb));
                            temp2.setProjectCapacityRecord(ToolUtils.size3(kgqb1));
                            list2.add(temp2);
                        }else {
                            temp2.setProjectCapacity(ToolUtils.size3(kgqb));
                            temp2.setProjectCapacityRecord(ToolUtils.size3(kgqb1));
                        }
                        list2.add(temp);
                    }
                    if("2".equals(temp.getProjectNature())){
                        temp.setPid(pid3);
                        pid3++;
                        tczq += Double.parseDouble(temp.getProjectCapacity());
                        if(null!=temp.getProjectCapacityRecord()){
                            tczq1 += Double.parseDouble(temp.getProjectCapacityRecord());
                        }
                        if(null==temp3.getProjectCapacity()){
                            temp3.setProjectName("投产争取项目");
                            temp3.setProjectCapacity(ToolUtils.size3(tczq));
                            temp3.setProjectCapacityRecord(ToolUtils.size3(tczq1));
                            list3.add(temp3);
                        }else {
                            temp3.setProjectCapacity(ToolUtils.size3(tczq));
                            temp3.setProjectCapacityRecord(ToolUtils.size3(tczq1));
                        }
                        list3.add(temp);
                    }
                    if("3".equals(temp.getProjectNature())){
                        temp.setPid(pid4);
                        pid4++;
                        kgzq += Double.parseDouble(temp.getProjectCapacity());
                        if(null!=temp.getProjectCapacityRecord()){
                            kgzq1 += Double.parseDouble(temp.getProjectCapacityRecord());
                        }
                        if(null==temp4.getProjectCapacity()){
                            temp4.setProjectName("开工争取项目");
                            temp4.setProjectCapacity(ToolUtils.size3(kgzq));
                            temp4.setProjectCapacityRecord(ToolUtils.size3(kgzq1));
                            list4.add(temp4);
                        }else {
                            temp4.setProjectCapacity(ToolUtils.size3(kgzq));
                            temp4.setProjectCapacityRecord(ToolUtils.size3(kgzq1));
                        }
                        list4.add(temp);
                    }
                }
            }
        }
        //重置返回列表
        returnList = new ArrayList<>();
        if(list1.size()>0 &&
                ("".equals(businessDevelopmentConstructionPreparation.getProjectNature())||"0".equals(businessDevelopmentConstructionPreparation.getProjectNature())|| null==businessDevelopmentConstructionPreparation.getProjectNature())
        ){
            returnList = list1;
        }
        if(list2.size()>0 &&
                ("".equals(businessDevelopmentConstructionPreparation.getProjectNature())||"1".equals(businessDevelopmentConstructionPreparation.getProjectNature())|| null==businessDevelopmentConstructionPreparation.getProjectNature())
        ){
            if(returnList.size()>0){
                for (BusinessDevelopmentConstructionPreparation temp : list2) {
                    returnList.add(temp);
                }
            }else {
                returnList = list2;
            }
        }
        if(list3.size()>0 &&
                ("".equals(businessDevelopmentConstructionPreparation.getProjectNature())||"2".equals(businessDevelopmentConstructionPreparation.getProjectNature())|| null==businessDevelopmentConstructionPreparation.getProjectNature())
        ){
            if(returnList.size()>0){
                for (BusinessDevelopmentConstructionPreparation temp : list3) {
                    returnList.add(temp);
                }
            }else {
                returnList = list3;
            }
        }
        if(list4.size()>0 &&
                ("".equals(businessDevelopmentConstructionPreparation.getProjectNature())||"3".equals(businessDevelopmentConstructionPreparation.getProjectNature())|| null==businessDevelopmentConstructionPreparation.getProjectNature())
        ){
            if(returnList.size()>0){
                for (BusinessDevelopmentConstructionPreparation temp : list4) {
                    returnList.add(temp);
                }
            }else {
                returnList = list4;
            }
        }
        return returnList;
    }

    /**
     * 新增规划发展施工准备项目
     * 
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentConstructionPreparation(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        businessDevelopmentConstructionPreparation.setCreateTime(DateUtils.getNowDate());
        businessDevelopmentConstructionPreparation.setProjectCapacity(ToolUtils.size3(businessDevelopmentConstructionPreparation.getProjectCapacity()));
        businessDevelopmentConstructionPreparation.setProjectCapacityRecord(ToolUtils.size3(businessDevelopmentConstructionPreparation.getProjectCapacityRecord()));
        return businessDevelopmentConstructionPreparationMapper.insertBusinessDevelopmentConstructionPreparation(businessDevelopmentConstructionPreparation);
    }

    /**
     * 修改规划发展施工准备项目
     * 
     * @param businessDevelopmentConstructionPreparation 规划发展施工准备项目
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentConstructionPreparation(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation)
    {
        businessDevelopmentConstructionPreparation.setUpdateTime(DateUtils.getNowDate());
        businessDevelopmentConstructionPreparation.setProjectCapacity(ToolUtils.size3(businessDevelopmentConstructionPreparation.getProjectCapacity()));
        businessDevelopmentConstructionPreparation.setProjectCapacityRecord(ToolUtils.size3(businessDevelopmentConstructionPreparation.getProjectCapacityRecord()));
        return businessDevelopmentConstructionPreparationMapper.updateBusinessDevelopmentConstructionPreparation(businessDevelopmentConstructionPreparation);
    }

    /**
     * 批量删除规划发展施工准备项目
     * 
     * @param ids 需要删除的规划发展施工准备项目ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentConstructionPreparationByIds(Long[] ids)
    {
        return businessDevelopmentConstructionPreparationMapper.deleteBusinessDevelopmentConstructionPreparationByIds(ids);
    }

    /**
     * 删除规划发展施工准备项目信息
     * 
     * @param id 规划发展施工准备项目ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentConstructionPreparationById(Long id)
    {
        return businessDevelopmentConstructionPreparationMapper.deleteBusinessDevelopmentConstructionPreparationById(id);
    }

    @Override
    public BusinessDevelopmentConstructionPreparation selectBusinessDevelopmentConstructionPreparationByVoid() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentConstructionPreparation returnResult=new BusinessDevelopmentConstructionPreparation();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    @Override
    public List<String> selectBusinessDevelopmentConstructionPreparationOperatorByGroupList(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation) {
        List<String> returnList= businessDevelopmentConstructionPreparationMapper.selectBusinessDevelopmentConstructionPreparationOperatorByGroupList(businessDevelopmentConstructionPreparation);
        returnList.add(0,"请选择");
        return  returnList;
    }

    @Override
    public List<BusinessDevelopmentConstructionPreparationVo> selectBusinessDevelopmentConstructionPreparationList2(BusinessDevelopmentConstructionPreparation businessDevelopmentConstructionPreparation) {
        List<BusinessDevelopmentConstructionPreparationVo>  returnList = new ArrayList<>();
        Map<String,String> natrue = selectDictDataByType("business_development_construction_natrue");
        List<BusinessDevelopmentConstructionPreparation>  selectList =businessDevelopmentConstructionPreparationMapper.selectBusinessDevelopmentConstructionPreparationList(businessDevelopmentConstructionPreparation);
        for (BusinessDevelopmentConstructionPreparation temp : selectList) {
            if(null!=temp.getProjectNature()){
                String[] projectNatures = temp.getProjectNature().split(",");
                for (int i = 0; i < projectNatures.length; i++) {
                    if(null==temp.getFirstprojectNatureNumber()){
                        temp.setFirstprojectNatureNumber(projectNatures[i]);
                    }else {
                        if(Integer.parseInt(projectNatures[i])<Integer.parseInt(temp.getFirstprojectNatureNumber())){
                            temp.setFirstprojectNatureNumber(projectNatures[i]);
                        }
                    }
                }
                temp.setFirstprojectNature(natrue.get(temp.getFirstprojectNatureNumber()));
            }
            List<String> list = new ArrayList<>();
            list.add(temp.getProjectXAxis());
            list.add(temp.getProjectYAxis());
            BusinessDevelopmentConstructionPreparationVo bdcpv = new BusinessDevelopmentConstructionPreparationVo(temp.getId(),temp.getProjectNature(),temp.getFirstprojectNature(),temp.getFirstprojectNatureNumber(),temp.getProjectName(),temp.getProjectName(),temp.getProjectCapacity(),temp.getProjectType(),temp.getProjectDevelopmentModalities(),temp.getProjectRegionDistrict(),list);
//            temp.setProjectAxis(list);
            bdcpv.setProjectCapacityRecord(temp.getProjectCapacityRecord());
            returnList.add(bdcpv);
        }
        return  returnList;
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
