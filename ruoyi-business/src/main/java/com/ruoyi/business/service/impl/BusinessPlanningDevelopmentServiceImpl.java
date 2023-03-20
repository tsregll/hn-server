package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.BusinessPlanningDevelopmentDetails;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectFile;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentDetailsMapper;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentProjectFileMapper;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.PlanningDevelopmentDetailsVo;
import com.ruoyi.business.vo.PlanningDevelopmentHunanVo;
import com.ruoyi.business.vo.PlanningDevelopmentVo;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentMapper;
import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentService;

/**
 * 规划发展项目后台Service业务层处理
 * 
 * @author yrb
 * @date 2021-04-12
 */
@Service
public class BusinessPlanningDevelopmentServiceImpl implements IBusinessPlanningDevelopmentService 
{
    @Autowired
    private BusinessPlanningDevelopmentMapper businessPlanningDevelopmentMapper;
    @Autowired
    private BusinessPlanningDevelopmentDetailsMapper businessPlanningDevelopmentDetailsMapper;
    @Autowired
    private ISysDictTypeService dictTypeService;
    @Autowired
    private BusinessPlanningDevelopmentProjectFileMapper businessPlanningDevelopmentProjectFileMapper;

    /**
     * 查询规划发展项目后台
     * 
     * @param id 规划发展项目后台ID
     * @return 规划发展项目后台
     */
    @Override
    public BusinessPlanningDevelopment selectBusinessPlanningDevelopmentById(Long id)
    {
        return businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(id);
    }

    /**
     * 查询规划发展项目后台列表
     * 
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 规划发展项目后台
     */
    @Override
    public List<BusinessPlanningDevelopment> selectBusinessPlanningDevelopmentList(BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        return businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentList(businessPlanningDevelopment);
    }

    /**
     * 新增规划发展项目后台
     * 
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 结果
     */
    @Override
    public int insertBusinessPlanningDevelopment(BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessPlanningDevelopment.setProjectStatus("0");
        businessPlanningDevelopment.setProjectEarlyStatus("0");
        businessPlanningDevelopment.setProjectFinish("7");
        businessPlanningDevelopment.setStatus("1");
        businessPlanningDevelopment.setCreateBy(loginUser.getUsername());
        businessPlanningDevelopment.setCreateTime(DateUtils.getNowDate());
        businessPlanningDevelopment.setProjectStartDate(new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.getNowDate()));
        businessPlanningDevelopment.setProjectEarlyStatus((!businessPlanningDevelopment.getProjectStatus().equals("0"))?null:businessPlanningDevelopment.getProjectEarlyStatus());
        Integer count = businessPlanningDevelopmentMapper.insertBusinessPlanningDevelopment(businessPlanningDevelopment);
        if(count>0){
            businessPlanningDevelopment = this.selectBusinessPlanningDevelopmentList(businessPlanningDevelopment).get(0);
            String projectType = businessPlanningDevelopment.getProjectDevelopmentType();
            BusinessPlanningDevelopmentDetails details = new BusinessPlanningDevelopmentDetails();
            details.setProjectNumber(businessPlanningDevelopment.getId().toString());
            details.setProjectStatus("0");
            details.setProjectDetailsName(projectType.equals("0")?"0":"1");
            details.setProjectDetailsStatus("0");
            details.setStatus("1");
            details.setCreateBy(loginUser.getUsername());
            details.setCreateTime(DateUtils.getNowDate());
            businessPlanningDevelopmentDetailsMapper.insertBusinessPlanningDevelopmentDetails(details);
            for(Integer i = 2;i<15;i++){
                details = new BusinessPlanningDevelopmentDetails();
                details.setProjectNumber(businessPlanningDevelopment.getId().toString());
                details.setProjectStatus("0");
                details.setProjectDetailsName(i.toString());
                details.setProjectDetailsStatus("0");
                details.setStatus("1");
                details.setCreateBy(loginUser.getUsername());
                details.setCreateTime(DateUtils.getNowDate());
                businessPlanningDevelopmentDetailsMapper.insertBusinessPlanningDevelopmentDetails(details);
            }
            return 1;
        }
        return 0;
    }

    /**
     * 修改规划发展项目后台
     * 
     * @param businessPlanningDevelopment 规划发展项目后台
     * @return 结果
     */
    @Override
    public int updateBusinessPlanningDevelopment(BusinessPlanningDevelopment businessPlanningDevelopment)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        businessPlanningDevelopment.setUpdateBy(loginUser.getUsername());
        businessPlanningDevelopment.setUpdateTime(DateUtils.getNowDate());
        businessPlanningDevelopment.setProjectEarlyStatus((!businessPlanningDevelopment.getProjectStatus().equals("0"))?null:businessPlanningDevelopment.getProjectEarlyStatus());
        return businessPlanningDevelopmentMapper.updateBusinessPlanningDevelopment(businessPlanningDevelopment);
    }

    /**
     * 批量删除规划发展项目后台
     * 
     * @param ids 需要删除的规划发展项目后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentByIds(Long[] ids)
    {
        Integer row = 0;
        for(Long id : ids){
            Integer rows = businessPlanningDevelopmentMapper.deleteBusinessPlanningDevelopmentById(id);
            if(rows>0){
                BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
                select.setProjectNumber(id+"");
                List<BusinessPlanningDevelopmentDetails> details = businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsList(select);
                Long[] projectNumber = new Long[details.size()];
                for(int i = 0;i<details.size();i++){
                    projectNumber[i] = details.get(i).getId();
                }
                businessPlanningDevelopmentDetailsMapper.deleteBusinessPlanningDevelopmentDetailsByIds(projectNumber);
            }
            row++;
        }
        return row>0?1:0;
    }

    /**
     * 删除规划发展项目后台信息
     * 
     * @param id 规划发展项目后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentById(Long id)
    {
        Integer rows = businessPlanningDevelopmentMapper.deleteBusinessPlanningDevelopmentById(id);
        if(rows>0){
            BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
            select.setProjectNumber(id+"");
            List<BusinessPlanningDevelopmentDetails> details = businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsList(select);
            Long[] ids = new Long[details.size()];
            for(int i = 0;i<details.size();i++){
                ids[i] = details.get(i).getId();
            }
            businessPlanningDevelopmentDetailsMapper.deleteBusinessPlanningDevelopmentDetailsByIds(ids);
        }
        return rows;
    }


    /**
     * 查询湖南省规划发展的柱状图
     * @param projectType 项目类型
     * @return 柱状图数据
     */
    @Override
    public Map<String, Object> selectHnHistogram(String projectType) {
        Map<String,Object> textStyle = new HashMap<>();
        textStyle.put("fontSize",12);
        textStyle.put("color","white");
        //返回对象
        Map<String, Object> returnMap = new HashMap<>();
        //数量的对象集合
        List<String> countList = new ArrayList<>();
        countList.add("0");
        //容量的对象集合
        List<String> sumList = new ArrayList<>();
        sumList.add("0");
        //名称的对象集合
        List<Map<String,Object>> nameList = new ArrayList<>();
        Map<String,Object> allMap = new HashMap<>();
        allMap.put("value","项目合计");
        allMap.put("textStyle",textStyle);
        nameList.add(allMap);
        //查询对象
        BusinessPlanningDevelopment selectWh = new BusinessPlanningDevelopment();
        //获取传入的类型
        Integer type = StringUtils.isEmpty(projectType)?new Integer(0):Integer.parseInt(projectType.trim());
        if(type == null || type == 0){
            //如果是0则查询所有
            returnMap.put("projectType","0");
        }else{
            //非0则减少1来查询正确数据
            returnMap.put("projectType",type);
            selectWh.setProjectType((type-1)+"");
        }
        //总数量
        Integer allCount = new Integer(0);
        Float sumCount = new Float(0);
        //循环count，从而做完状态
        for(Integer count = 0;count<3;count++){
            Float sum = new Float(0);
            //把状态填入查询对象
            selectWh.setProjectStatus(count.toString());
            //查询数据
            List<BusinessPlanningDevelopment> selectList = businessPlanningDevelopmentMapper.selectListOrderByProjectType(selectWh);
            for(BusinessPlanningDevelopment bpd:selectList){
                sum += StringUtils.isNotEmpty(bpd.getProjectInstalledCapacity())?Float.parseFloat(bpd.getProjectInstalledCapacity()):new Float(0);
            }
            //添加返回集合的size来作为数量
            countList.add(selectList.size()+"");
            //通过count来判断是哪一个类型的中文
            Map<String,Object> map = new HashMap<>();
            map.put("value",count==0?"前期开发":count==1?"已（拟）开工":count==2?"已投产":"");
            map.put("textStyle",textStyle);
            nameList.add(map);
            sumList.add(sum.toString());
            //累加数量计算总计
            allCount+=selectList.size();
            sumCount+=sum;
        }
        //把总计填入数据的第一个下标
        countList.set(0,allCount.toString());
        sumList.set(0,sumCount.toString());
        //数量
        returnMap.put("dataList",countList);
        returnMap.put("sumList",sumList);
        //名称
        returnMap.put("dataName",nameList);
        return returnMap;
    }

    /**
     * 查询湖南省规划发展的表格
     * @return 数据集合
     */
    @Override
    public List<PlanningDevelopmentVo> selectHnTable() {
        //vo对象集合
        List<PlanningDevelopmentVo> returnList = new ArrayList<>();
        //查询对象
        BusinessPlanningDevelopment selectWh = new BusinessPlanningDevelopment();
        //项目数
        List<PlanningDevelopmentVo> countList = new ArrayList<>();
        //装机容量
        List<PlanningDevelopmentVo> capacityList = new ArrayList<>();
        //循环状态
        for(Integer status = 0;status<3;status++){
            //定义单个数量对象
            PlanningDevelopmentVo count = new PlanningDevelopmentVo();
            count.setName(status==0?"前期开发项目数量":status==1?"已（拟）开工项目数量":"已投产项目数量");
            count.setUnit("个");
            //定义单个容量对象
            PlanningDevelopmentVo capacity = new PlanningDevelopmentVo();
            capacity.setName(status==0?"前期开发项目容量":status==1?"已（拟）开工项目容量":"已投产项目容量");
            capacity.setUnit("万千瓦");
            //填充查询条件状态
            selectWh.setProjectStatus(status.toString());
            //循环类型
            for(Integer type = 0;type<5;type++){
                //填充查询条件类型
                selectWh.setProjectType(type.toString());
                //查询数据返回集合
                List<BusinessPlanningDevelopment> selectList = businessPlanningDevelopmentMapper.selectListOrderByProjectType(selectWh);
                //判断类型是哪一种，因为不同的类型填入不同的字段里面
                if(type == 0){
                    count.setFd(selectList.size()+"");
                    capacity.setFd(ToolUtils.size2(capacitySum(selectList).toString()));
                }else if(type == 1){
                    count.setSd(selectList.size()+"");
                    capacity.setSd(ToolUtils.size2(capacitySum(selectList).toString()));
                }else if(type == 2){
                    count.setGf(selectList.size()+"");
                    capacity.setGf(ToolUtils.size2(capacitySum(selectList).toString()));
                }else if(type == 3){
                    count.setMj(selectList.size()+"");
                    capacity.setMj(ToolUtils.size2(capacitySum(selectList).toString()));
                }else if(type == 4){
                    count.setRj(selectList.size()+"");
                    capacity.setRj(ToolUtils.size2(capacitySum(selectList).toString()));
                }
            }
            //计算总数
            count.setAll(countAll(count).toString());
            //计算总容量
            capacity.setAll(ToolUtils.size2(capacityAll(capacity).toString()));
            //添加进集合
            countList.add(count);
            capacityList.add(capacity);
        }
        //添加一条合计
        countList = capacitySum(countList,"0");
        capacityList = capacitySum(capacityList,"1");
        //整个list添加到返回的集合中
        returnList.addAll(countList);
        returnList.addAll(capacityList);
        return returnList;
    }

    /**
     * 查询市级规划发展的柱状图
     * @param projectType 项目类型
     * @param projectRegionDistrict 市级地区
     * @return
     */
    @Override
    public Map<String, Object> selectDistrictHistogram(String projectType, String projectRegionDistrict) {
        Map<String,Object> textStyle = new HashMap<>();
        textStyle.put("fontSize",12);
        textStyle.put("color","white");
        //获取类型
        Integer type = StringUtils.isEmpty(projectType)?new Integer(0):Integer.parseInt(projectType.trim());
        //定义返回参数
        Map<String, Object> returnMap = new HashMap<>();
        //数量
        List<String> dataList = new ArrayList<>();
        dataList.add("0");
        //容量
        List<String> data2List = new ArrayList<>();
        data2List.add("0");
        //名称
        List<Map<String,Object>> nameList = new ArrayList<>();
        Map<String,Object> allMap = new HashMap<>();
        allMap.put("value","项目合计");
        allMap.put("textStyle",textStyle);
        nameList.add(allMap);
        //查询对象
        BusinessPlanningDevelopment select = new BusinessPlanningDevelopment();
        select.setProjectRegionDistrict(district(projectRegionDistrict));
        //如果查询条件是全部则不输入类型
        if(type > 0){
            select.setProjectType((type-1)+"");
        }
        //定义计算对象
        Integer allCount = new Integer(0);
        Float allSum = new Float(0);
        //循环count来代表状态
        for(Integer count = 0;count<3;count++){
            //填入状态
            select.setProjectStatus(count.toString());
            //查询并且返回结果
            List<BusinessPlanningDevelopment> selectList = businessPlanningDevelopmentMapper.selectListOrderByProjectType(select);
            //计算总数
            Float sum = new Float(0);
            //填入数据进集合
            dataList.add(selectList.size()+"");
            Map<String,Object> map = new HashMap<>();
            map.put("value",count==0?"前期开发":count==1?"已（拟）开工":count==2?"已投产":"");
            map.put("textStyle",textStyle);
            nameList.add(map);
            //循环计算容量
            for(BusinessPlanningDevelopment bpd : selectList){
                sum += StringUtils.isNotEmpty(bpd.getProjectInstalledCapacity())?Float.parseFloat(bpd.getProjectInstalledCapacity()):new Float(0);
            }
            //填入容量
            data2List.add(sum.toString());
            //计算总数
            allCount +=selectList.size();
            allSum +=sum;
        }
        //把总计放入第一个位置
        dataList.set(0,allCount.toString());
        data2List.set(0,allSum.toString());
        //填入返回对象
        returnMap.put("dataList",dataList);
        returnMap.put("dataCapacity",data2List);
        returnMap.put("dataName",nameList);
        returnMap.put("type",type.toString());
        returnMap.put("titleName",projectRegionDistrict+"规划发展建设概览");
        return returnMap;
    }

    /**
     * 查询市级规划发展的表格
     * @param projectType
     * @param projectRegionDistrict 市级地区
     * @return
     */
    @Override
    public List<Map<String,Object>> selectDistrictTable(String projectType,String projectRegionDistrict) {
        //定义返回集合
        List<Map<String,Object>> returnList = new ArrayList<>();
        //获取类型
        Integer type = StringUtils.isEmpty(projectType)?new Integer(0):Integer.parseInt(projectType.trim());
        //查询对象
        BusinessPlanningDevelopment select = new BusinessPlanningDevelopment();
        select.setProjectRegionDistrict(district(projectRegionDistrict));
        //如果输入的是全部就不填入条件
        if(type > 0){
            select.setProjectType((type-1)+"");
        }
        //循环count来作为状态
        for(Integer count = 0;count<3;count++){
            //定义一个模拟对象
            Map<String,Object> map = new HashMap<>();
            //填入状态名称
            map.put("name",(count==0?"前期开发项目":count==1?"已（拟）开工项目":count==2?"已投产项目":""));
            //定义容量总和对象
            Float allSum = new Float(0);
            //填入状态条件
            select.setProjectStatus(count.toString());
            //查询数据返回集合
            List<BusinessPlanningDevelopment> selectList = businessPlanningDevelopmentMapper.selectListOrderByProjectType(select);
            //填入项目数量
            map.put("count",selectList.size()+"");
            //循环累加容量
            for(BusinessPlanningDevelopment bpd : selectList){
                allSum += StringUtils.isNotEmpty(bpd.getProjectInstalledCapacity())?Float.parseFloat(bpd.getProjectInstalledCapacity()):new Float(0);
            }
            //填入容量
            map.put("capacity",allSum.toString());
            //填入项目状态
            map.put("projectStatus",count.toString());
            returnList.add(map);
        }
        return returnList;
    }

    /**
     * 三级规划发展详细表格
     * @param projectStatus 项目状态
     * @param projectRegionDistrict 市级地区
     * @return 组装数据
     */
    @Override
    public Map<String, Object> selectTableDetails(String projectStatus, String projectRegionDistrict) {
        String statusName = projectStatus.equals("0")?"前期开发项目":projectStatus.equals("1")?"已（拟）开工项目":"已投产项目";
        //返回用对象
        Map<String,Object> returnMap = new HashMap<>();
        //数据对象
        List<Map<String,Object>> dataList = new ArrayList<>();
        //查询对象
        BusinessPlanningDevelopment select = new BusinessPlanningDevelopment();
        //填入地区
        select.setProjectRegionDistrict(district(projectRegionDistrict));
        //填入状态
        select.setProjectStatus(projectStatus);
        //总计
        Integer jsAll = new Integer(0);
        Float rlAll = new Float(0);
        //循环类型值
        for(Integer count =0;count<5;count++){
            Integer js = new Integer(0);
            Float rl = new Float(0);
            String typeName = count == 0?"风电项目":count == 1?"水电项目":count == 2?"光伏项目":count == 3?"煤机项目":"燃机项目";
            //填入类型
            select.setProjectType(count.toString());
            //查询数据
            List<BusinessPlanningDevelopment> selectList = businessPlanningDevelopmentMapper.selectListOrderByProjectType(select);
            //如果无数据则跳过下面代码
            if(selectList.size()<1)continue;
            //获取数据条数
            js = selectList.size();
            //循环查询集合
            for(BusinessPlanningDevelopment bpd : selectList){
                //定义单个数据对象
                Map<String,Object> data = new HashMap<>();
                //填入数据
                data.put("projectName",bpd.getProjectName());
                data.put("projectType",typeName);
                data.put("projectInstalledCapacity",bpd.getProjectInstalledCapacity());
                //累加总和容量
                rl += StringUtils.isNotEmpty(bpd.getProjectInstalledCapacity())?Float.parseFloat(bpd.getProjectInstalledCapacity()):new Float(0);
                //填入list集合
                dataList.add(data);
            }
            //小计对象
            Map<String,Object> dataAll = new HashMap<>();
            dataAll.put("projectName","小计");
            dataAll.put("projectType",js.toString());
            dataAll.put("projectInstalledCapacity",rl.toString());
            dataList.add(dataAll);
            jsAll += js;
            rlAll += rl;
        }
        Map<String,Object> dataAll = new HashMap<>();
        dataAll.put("projectName","总计");
        dataAll.put("projectType",jsAll.toString());
        dataAll.put("projectInstalledCapacity",rlAll.toString());
        dataList.add(dataAll);
        //填入返回的map里面
        returnMap.put("data",dataList);
        //定义表头
        returnMap.put("titleName",projectRegionDistrict+statusName+"统计表");
        return returnMap;
    }

    @Override
    public List<Map<String,Object>> selectHnProjects() {
        List<Map<String,Object>> returnList = new ArrayList<>();
        List<BusinessPlanningDevelopment> businessPlanningDevelopments = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentList(new BusinessPlanningDevelopment());
        for(BusinessPlanningDevelopment bpd : businessPlanningDevelopments){
            Map<String,Object> map = new HashMap<>();
            double[] axis = new double[2];
            double x = Double.parseDouble(bpd.getProjectXAxis());
            double y = Double.parseDouble(bpd.getProjectYAxis());
            axis[0] = y;
            axis[1] = x;
            map.put("projectNumber",bpd.getId());
            map.put("name",bpd.getProjectName());
            map.put("value",bpd.getProjectName());
            map.put("projectStatus",bpd.getProjectStatus());
            map.put("coord",axis);
            //获得项目容量、开工日期/投产日期
            Map<String,Object> map2 =selectProjectDetailByStatus(bpd.getId(),bpd.getProjectStatus());
            map.put("projectStatus2",map2.get("projectStatus"));
            map.put("projectDate",map2.get("projectDate"));
            map.put("projectBackup",map2.get("projectBackup"));
            map.put("title",map2.get("title"));
            map.put("projectProductionAllCapacity",map2.get("projectProductionAllCapacity"));
            returnList.add(map);
        }
        return returnList;
    }

    @Override
    public Map<String,Object> selectProjectByStatus(Long projectNumber, String projectStatus) {
        //返回对象
        Map<String,Object> returnMap = new HashMap<>();
        //字典数据集合
        //详情名称字典
        Map<String,String> detailName = selectDictDataByType("business_project_detail_name");
        //项目开发类型字典
        Map<String,String> developmentType = selectDictDataByType("business_project_development_type");
        //项目状态字典
        Map<String,String> status = selectDictDataByType("business_project_status");
        //查询项目信息
        BusinessPlanningDevelopment porject = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(projectNumber);
        //装入标题
        returnMap.put("title",status.get(projectStatus)+"-"+porject.getProjectName());
        //装入开发类型
        returnMap.put("developmentType",developmentType.get(porject.getProjectDevelopmentType()));
        //定义查询对象并且填充参数
        BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
        select.setProjectNumber(projectNumber.toString());
        select.setProjectStatus(projectStatus);
        //查询详情集合
        List<BusinessPlanningDevelopmentDetails> details = businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsList(select);
        //定义规划发展详情集合
        List<Map<String,Object>> detailsList = new ArrayList<>();
        //循环添加
        for(BusinessPlanningDevelopmentDetails bpd:details){
            Map<String,Object> vo = new HashMap<>();
            vo.put("projectDetailsName",detailName.get(bpd.getProjectDetailsName()));
            vo.put("projectDetailsStatus",bpd.getProjectDetailsStatus());
            vo.put("projectFileAddress",bpd.getProjectFileAddress());
            vo.put("projectId",bpd.getId());
            vo.put("projectPreparationTime",bpd.getProjectPreparationTime());
            vo.put("projectFinishTime",bpd.getProjectFinishTime());
            vo.put("projectBackup",bpd.getProjectBackup());
            detailsList.add(vo);
        }
        returnMap.put("detailsList",detailsList);
        return returnMap;
    }

    @Override
    public Map<String, Object> selectProjectDetailByStatus(Long projectNumber, String projectStatus) {
        //返回对象
        Map<String,Object> returnMap = new HashMap<>();
        //正式开工日期
        String projectBackup = null;
        //投产日期
        String projectDate = null;
        //字典数据集合
//        //详情名称字典
//        Map<String,String> detailName = selectDictDataByType("business_project_detail_name");
//        //项目开发类型字典
//        Map<String,String> developmentType = selectDictDataByType("business_project_development_type");
        //项目状态字典
        Map<String,String> status = selectDictDataByType("business_project_status");
        //查询项目信息
        BusinessPlanningDevelopment porject = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(projectNumber);
        //装入标题
        returnMap.put("title",porject.getProjectName());
        //装入开发类型
        returnMap.put("projectStatus",status.get(projectStatus));
        //定义查询对象并且填充参数
        BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
        select.setProjectNumber(projectNumber.toString());
//        select.setProjectStatus(projectStatus);
        //查询详情集合
        List<BusinessPlanningDevelopmentDetails> details = businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsList(select);
        //定义规划发展详情集合
        List<Map<String,Object>> detailsList = new ArrayList<>();
        if(details.size()>0&&details.size()<15){
            returnMap.put("projectProductionAllCapacity",porject.getProjectInstalledCapacity());
        } else if(details.size()>15 && "1".equals(projectStatus)){
            for(BusinessPlanningDevelopmentDetails bpd:details){
                if("8".equals(bpd.getProjectDetailsName())){
                    if(null==bpd.getProjectApprovalCapacity()){
                        returnMap.put("projectProductionAllCapacity",porject.getProjectInstalledCapacity());
                    }else {
                        returnMap.put("projectProductionAllCapacity",bpd.getProjectApprovalCapacity());
                    }
                }
                if("15".equals(bpd.getProjectDetailsName())){
                    projectBackup = bpd.getProjectBackup();
                }
            }
        }else if(details.size()>15 && "2".equals(projectStatus)){
            for(BusinessPlanningDevelopmentDetails bpd:details){
                if("8".equals(bpd.getProjectDetailsName())){
                    returnMap.put("projectProductionAllCapacity",bpd.getProjectApprovalCapacity());
                }
            }
            BusinessPlanningDevelopmentProjectFile temp = new BusinessPlanningDevelopmentProjectFile();
            temp.setProjectNumber(projectNumber.toString());
            List<BusinessPlanningDevelopmentProjectFile> selectTemp = businessPlanningDevelopmentProjectFileMapper.selectBusinessPlanningDevelopmentProjectFileList(temp);
            if(selectTemp.size()>0){
                projectDate = selectTemp.get(0).getProjectDate();
            }
        }else {
            returnMap.put("projectProductionAllCapacity","");
        }
//        //循环添加
//        for(BusinessPlanningDevelopmentDetails bpd:details){
//            Map<String,Object> vo = new HashMap<>();
//            vo.put("projectDetailsName",detailName.get(bpd.getProjectDetailsName()));
//            vo.put("projectDetailsStatus",bpd.getProjectDetailsStatus());
//            vo.put("projectFileAddress",bpd.getProjectFileAddress());
//            vo.put("projectId",bpd.getId());
//            detailsList.add(vo);
//        }

//        returnMap.put("projectBackup",null==projectBackup?"":("开工日期："+projectBackup));
//        returnMap.put("projectDate",null==projectDate?"":("投产日期："+projectDate));
        returnMap.put("projectBackup",null==projectBackup?"":(projectBackup));
        returnMap.put("projectDate",null==projectDate?"":(projectDate));
        return returnMap;
    }

    @Override
    public Map<String,Object> selectImgFileByProjectNumber(Long projectNumber) {
        //返回对象
        Map<String,Object> returnMap = new HashMap<>();
        //图片文件集合
        List<Map<String,Object>> imgMapList = new ArrayList<>();
        //项目类型转译对象
        Map<String,String> projectType = selectDictDataByType("business_project_type");
        //开发方式转译对象
        Map<String,String> projectDevelopmentType = selectDictDataByType("business_project_development_type");
        //开发类型转译对象
        Map<String,String> projectDevelopmentModalities = selectDictDataByType("business_project_development_modalities");
        //查询项目并且填充信息
        BusinessPlanningDevelopment porject = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(projectNumber);
        returnMap.put("projectName","已投产项目-"+porject.getProjectName());
        returnMap.put("projectType",projectType.get(porject.getProjectType()));
        returnMap.put("projectDevelopmentType",projectDevelopmentType.get(porject.getProjectDevelopmentType()));
        returnMap.put("projectDevelopmentModalities",projectDevelopmentModalities.get(porject.getProjectDevelopmentModalities()));
        returnMap.put("projectResponsiblePerson",porject.getProjectResponsiblePerson());
        returnMap.put("projectIntroduce",porject.getProjectIntroduce());
        //查询对象，填充查询项目编号
        BusinessPlanningDevelopmentProjectFile select = new BusinessPlanningDevelopmentProjectFile();
        select.setProjectNumber(projectNumber.toString());
        //查询图片文件集合
        List<BusinessPlanningDevelopmentProjectFile> imgList = businessPlanningDevelopmentProjectFileMapper.selectBusinessPlanningDevelopmentProjectFileList(select);
        //循环
        for(BusinessPlanningDevelopmentProjectFile file : imgList){
            Map<String,Object> imgMap = new HashMap<>();
            imgMap.put("projectFileAddress",file.getProjectFileAddress());
            imgMap.put("projectFileIllustration",file.getProjectFileIllustration());
            imgMapList.add(imgMap);
        }
        returnMap.put("imgList",imgMapList);
        return returnMap;
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
    /**
     * 计算湖南规划发展项目容量
     * @param selectList 获取的List
     * @return List所有的容量之和
     */
    private Float capacitySum(List<BusinessPlanningDevelopment> selectList){
        Float capacitySum = new Float(0);
        for(BusinessPlanningDevelopment bp : selectList){
            capacitySum+=StringUtils.isEmpty(bp.getProjectInstalledCapacity())?new Float(0): Float.parseFloat(bp.getProjectInstalledCapacity());
        }
        return capacitySum;
    }
    /**
     * 计算合计
     * @param selectList
     * @param type
     * @return
     */
    private List<PlanningDevelopmentVo> capacitySum(List<PlanningDevelopmentVo> selectList,String type){
        PlanningDevelopmentVo voSum = new PlanningDevelopmentVo();
        Float sum1 = new Float(0);
        Float sum2 = new Float(0);
        Float sum3 = new Float(0);
        Float sum4 = new Float(0);
        Float sum5 = new Float(0);
        Integer isum1 = new Integer(0);
        Integer isum2 = new Integer(0);
        Integer isum3 = new Integer(0);
        Integer isum4 = new Integer(0);
        Integer isum5 = new Integer(0);
        for(PlanningDevelopmentVo vo : selectList){
            if(type.equals("0")){
                if(StringUtils.isNotEmpty(vo.getFd()))isum1+=Integer.parseInt(vo.getFd());
                if(StringUtils.isNotEmpty(vo.getSd()))isum2+=Integer.parseInt(vo.getSd());
                if(StringUtils.isNotEmpty(vo.getGf()))isum3+=Integer.parseInt(vo.getGf());
                if(StringUtils.isNotEmpty(vo.getMj()))isum4+=Integer.parseInt(vo.getMj());
                if(StringUtils.isNotEmpty(vo.getRj()))isum5+=Integer.parseInt(vo.getRj());
            }else{
                if(StringUtils.isNotEmpty(vo.getFd()))sum1+=Float.parseFloat(vo.getFd());
                if(StringUtils.isNotEmpty(vo.getSd()))sum2+=Float.parseFloat(vo.getSd());
                if(StringUtils.isNotEmpty(vo.getGf()))sum3+=Float.parseFloat(vo.getGf());
                if(StringUtils.isNotEmpty(vo.getMj()))sum4+=Float.parseFloat(vo.getMj());
                if(StringUtils.isNotEmpty(vo.getRj()))sum5+=Float.parseFloat(vo.getRj());
            }
        }
        voSum.setName(type.equals("0")?"项目合计数量":"项目合计容量");
        voSum.setUnit(type.equals("0")?"个":"万千瓦");
        voSum.setFd(type.equals("0")?isum1.toString():ToolUtils.size2(sum1.toString()));
        voSum.setSd(type.equals("0")?isum2.toString():ToolUtils.size2(sum2.toString()));
        voSum.setGf(type.equals("0")?isum3.toString():ToolUtils.size2(sum3.toString()));
        voSum.setMj(type.equals("0")?isum4.toString():ToolUtils.size2(sum4.toString()));
        voSum.setRj(type.equals("0")?isum5.toString():ToolUtils.size2(sum5.toString()));
        voSum.setAll(type.equals("0")?countAll(voSum).toString():ToolUtils.size2(capacityAll(voSum).toString()));
        selectList.add(voSum);
        return selectList;
    }
    /**
     * 计算Vo中capacity的总计
     * @param bpd 需要计算的vo
     * @return 返回计算结果
     */
    private Float capacityAll(PlanningDevelopmentVo bpd){
        Float all = new Float(0);
        if(StringUtils.isNotEmpty(bpd.getFd()))all+=Float.parseFloat(bpd.getFd());
        if(StringUtils.isNotEmpty(bpd.getSd()))all+=Float.parseFloat(bpd.getSd());
        if(StringUtils.isNotEmpty(bpd.getGf()))all+=Float.parseFloat(bpd.getGf());
        if(StringUtils.isNotEmpty(bpd.getMj()))all+=Float.parseFloat(bpd.getMj());
        if(StringUtils.isNotEmpty(bpd.getRj()))all+=Float.parseFloat(bpd.getRj());
        return all;
    }
    /**
     * 计算Vo中数量的总计
     * @param bpd 需要计算的vo
     * @return 返回计算结果
     */
    private Integer countAll(PlanningDevelopmentVo bpd){
        Integer all = new Integer(0);
        if(StringUtils.isNotEmpty(bpd.getFd()))all+=Integer.parseInt(bpd.getFd());
        if(StringUtils.isNotEmpty(bpd.getSd()))all+=Integer.parseInt(bpd.getSd());
        if(StringUtils.isNotEmpty(bpd.getGf()))all+=Integer.parseInt(bpd.getGf());
        if(StringUtils.isNotEmpty(bpd.getMj()))all+=Integer.parseInt(bpd.getMj());
        if(StringUtils.isNotEmpty(bpd.getRj()))all+=Integer.parseInt(bpd.getRj());
        return all;
    }

    /**
     * 通过中文获得对应字典的数据
     * @param projectRegionDistrict 中文地址
     * @return 对应数据字典的结果
     */
    private String district(String projectRegionDistrict){
        String returnDistrict = "";
        if(projectRegionDistrict.trim().equals("长沙市")){
            returnDistrict = "0";
        }else if(projectRegionDistrict.trim().equals("岳阳市")){
            returnDistrict = "1";
        }else if(projectRegionDistrict.trim().equals("永州市")){
            returnDistrict = "2";
        }else if(projectRegionDistrict.trim().equals("郴州市")){
            returnDistrict = "3";
        }else if(projectRegionDistrict.trim().equals("常德市")){
            returnDistrict = "4";
        }else if(projectRegionDistrict.trim().equals("邵阳市")){
            returnDistrict = "5";
        }else if(projectRegionDistrict.trim().equals("怀化市")){
            returnDistrict = "6";
        }else if(projectRegionDistrict.trim().equals("湘潭市")){
            returnDistrict = "7";
        }else if(projectRegionDistrict.trim().equals("株洲市")){
            returnDistrict = "8";
        }else if(projectRegionDistrict.trim().equals("衡阳市")){
            returnDistrict = "9";
        }else if(projectRegionDistrict.trim().equals("娄底市")){
            returnDistrict = "10";
        }else if(projectRegionDistrict.trim().equals("益阳市")){
            returnDistrict = "11";
        }else if(projectRegionDistrict.trim().equals("张家界市")){
            returnDistrict = "12";
        }else if(projectRegionDistrict.trim().equals("湘西土家族苗族自治州")){
            returnDistrict = "13";
        }
        return returnDistrict;
    }
}
