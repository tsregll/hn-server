package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentGroupProjectMapper;
import com.ruoyi.business.domain.BusinessDevelopmentGroupProject;
import com.ruoyi.business.service.IBusinessDevelopmentGroupProjectService;

/**
 * 规划发展基建专业组项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
@Service
public class BusinessDevelopmentGroupProjectServiceImpl implements IBusinessDevelopmentGroupProjectService 
{
    @Autowired
    private BusinessDevelopmentGroupProjectMapper businessDevelopmentGroupProjectMapper;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展基建专业组项目
     * 
     * @param id 规划发展基建专业组项目ID
     * @return 规划发展基建专业组项目
     */
    @Override
    public BusinessDevelopmentGroupProject selectBusinessDevelopmentGroupProjectById(Long id)
    {
        BusinessDevelopmentGroupProject returnResult = businessDevelopmentGroupProjectMapper.selectBusinessDevelopmentGroupProjectById(id);
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    @Override
    public BusinessDevelopmentGroupProject selectBusinessDevelopmentGroupProjectByVoid() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentGroupProject returnResult=new BusinessDevelopmentGroupProject();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    /**
     * 查询规划发展基建专业组项目列表
     * 
     * @param businessDevelopmentGroupProject 规划发展基建专业组项目
     * @return 规划发展基建专业组项目
     */
    @Override
    public List<BusinessDevelopmentGroupProject> selectBusinessDevelopmentGroupProjectList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        return businessDevelopmentGroupProjectMapper.selectBusinessDevelopmentGroupProjectList(businessDevelopmentGroupProject);
    }

    /**
     * 新增规划发展基建专业组项目
     * 
     * @param businessDevelopmentGroupProject 规划发展基建专业组项目
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentGroupProject(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        businessDevelopmentGroupProject.setCreateTime(DateUtils.getNowDate());
        String groupLeader = businessDevelopmentGroupProject.getGroupLeaders();
        String groupMember = businessDevelopmentGroupProject.getGroupMembers();
        if(groupLeader.contains(" ")){
            businessDevelopmentGroupProject.setGroupLeaders(groupLeader.replaceAll(" ",""));
        }
        if(groupMember.contains(" ")){
            businessDevelopmentGroupProject.setGroupMembers(groupMember.replaceAll(" ",""));
        }
        return businessDevelopmentGroupProjectMapper.insertBusinessDevelopmentGroupProject(businessDevelopmentGroupProject);
    }

    /**
     * 修改规划发展基建专业组项目
     * 
     * @param businessDevelopmentGroupProject 规划发展基建专业组项目
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentGroupProject(BusinessDevelopmentGroupProject businessDevelopmentGroupProject)
    {
        businessDevelopmentGroupProject.setUpdateTime(DateUtils.getNowDate());
        String groupLeader = businessDevelopmentGroupProject.getGroupLeaders();
        String groupMember = businessDevelopmentGroupProject.getGroupMembers();
        if(groupLeader.contains(" ")){
            businessDevelopmentGroupProject.setGroupLeaders(groupLeader.replaceAll(" ",""));
        }
        if(groupMember.contains(" ")){
            businessDevelopmentGroupProject.setGroupMembers(groupMember.replaceAll(" ",""));
        }
        return businessDevelopmentGroupProjectMapper.updateBusinessDevelopmentGroupProject(businessDevelopmentGroupProject);
    }

    /**
     * 批量删除规划发展基建专业组项目
     * 
     * @param ids 需要删除的规划发展基建专业组项目ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentGroupProjectByIds(Long[] ids)
    {
        return businessDevelopmentGroupProjectMapper.deleteBusinessDevelopmentGroupProjectByIds(ids);
    }

    /**
     * 删除规划发展基建专业组项目信息
     * 
     * @param id 规划发展基建专业组项目ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentGroupProjectById(Long id)
    {
        return businessDevelopmentGroupProjectMapper.deleteBusinessDevelopmentGroupProjectById(id);
    }

    @Override
    public List<String> selectBusinessDevelopmentGroupProjectOperatorList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject) {
        return businessDevelopmentGroupProjectMapper.selectBusinessDevelopmentGroupProjectByGroupList(businessDevelopmentGroupProject);
    }

    @Override
    public List<String> selectBusinessDevelopmentGroupProjectGroupMemberList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject) {
        List<String> returnList = new ArrayList<>();
        //获得基建专业组项目列表
        List<BusinessDevelopmentGroupProject> tempList = businessDevelopmentGroupProjectMapper.selectBusinessDevelopmentGroupProjectList(businessDevelopmentGroupProject);
        for(BusinessDevelopmentGroupProject temp:tempList){
            String groupMember=temp.getGroupMembers();
            //判断是否含有'，'或','
            if (groupMember.contains("、")){
                String[] groupMembers = groupMember.split("、");
                //去重
                for (int i = 0; i <groupMembers.length ; i++) {
                    if(!returnList.contains(groupMembers[i])){
                        returnList.add(groupMembers[i]);
                    }
                }
            }else {
                if(!returnList.contains(groupMember)){
                    returnList.add(groupMember);
                }
            }
        }
        return returnList;
    }

    @Override
    public List<String> selectBusinessDevelopmentGroupProjectGroupLeaderList(BusinessDevelopmentGroupProject businessDevelopmentGroupProject) {
        List<String> returnList = new ArrayList<>();
        //获得基建专业组项目列表
        List<BusinessDevelopmentGroupProject> tempList = businessDevelopmentGroupProjectMapper.selectBusinessDevelopmentGroupProjectList(businessDevelopmentGroupProject);
        for(BusinessDevelopmentGroupProject temp:tempList){
            String groupLeader=temp.getGroupLeaders();
            //判断是否含有'、'
            if (groupLeader.contains("、")){
//                if(groupLeader.contains(",")){
//                    groupLeader.replace(',','，');
//                }
                String[] groupLeaders = groupLeader.split("、");
                //去重
                for (int i = 0; i <groupLeaders.length ; i++) {
                    if(!returnList.contains(groupLeaders[i])){
                        returnList.add(groupLeaders[i]);
                    }
                }
            }else {
                if(!returnList.contains(groupLeader)){
                    if(groupLeader.contains(" ")){
                        groupLeader = groupLeader.replaceAll(" ","");
                    }
                    returnList.add(groupLeader);
                }
            }
        }
        return returnList;
    }
}
