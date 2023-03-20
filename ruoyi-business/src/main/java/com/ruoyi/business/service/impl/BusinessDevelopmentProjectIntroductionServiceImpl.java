package com.ruoyi.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentProjectIntroductionMapper;
import com.ruoyi.business.domain.BusinessDevelopmentProjectIntroduction;
import com.ruoyi.business.service.IBusinessDevelopmentProjectIntroductionService;

/**
 * 规划发展项目介绍后台Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
@Service
public class BusinessDevelopmentProjectIntroductionServiceImpl implements IBusinessDevelopmentProjectIntroductionService 
{
    @Autowired
    private BusinessDevelopmentProjectIntroductionMapper businessDevelopmentProjectIntroductionMapper;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展项目介绍后台
     * 
     * @param id 规划发展项目介绍后台ID
     * @return 规划发展项目介绍后台
     */
    @Override
    public BusinessDevelopmentProjectIntroduction selectBusinessDevelopmentProjectIntroductionById(Long id)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentProjectIntroduction returnResult= businessDevelopmentProjectIntroductionMapper.selectBusinessDevelopmentProjectIntroductionById(id);
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return  returnResult;
    }

    /**
     * 查询规划发展项目介绍后台
     *
     * @return 规划发展项目介绍后台
     */
    @Override
    public BusinessDevelopmentProjectIntroduction selectBusinessDevelopmentProjectIntroductionByVoid() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentProjectIntroduction returnResult= new BusinessDevelopmentProjectIntroduction();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return  returnResult;
    }

    /**
     * 查询规划发展项目介绍后台列表
     * 
     * @param businessDevelopmentProjectIntroduction 规划发展项目介绍后台
     * @return 规划发展项目介绍后台
     */
    @Override
    public List<BusinessDevelopmentProjectIntroduction> selectBusinessDevelopmentProjectIntroductionList(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        return businessDevelopmentProjectIntroductionMapper.selectBusinessDevelopmentProjectIntroductionList(businessDevelopmentProjectIntroduction);
    }

    /**
     * 新增规划发展项目介绍后台
     * 
     * @param businessDevelopmentProjectIntroduction 规划发展项目介绍后台
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentProjectIntroduction(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        businessDevelopmentProjectIntroduction.setCreateTime(DateUtils.getNowDate());
        return businessDevelopmentProjectIntroductionMapper.insertBusinessDevelopmentProjectIntroduction(businessDevelopmentProjectIntroduction);
    }

    /**
     * 修改规划发展项目介绍后台
     * 
     * @param businessDevelopmentProjectIntroduction 规划发展项目介绍后台
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentProjectIntroduction(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction)
    {
        businessDevelopmentProjectIntroduction.setUpdateTime(DateUtils.getNowDate());
        return businessDevelopmentProjectIntroductionMapper.updateBusinessDevelopmentProjectIntroduction(businessDevelopmentProjectIntroduction);
    }

    /**
     * 批量删除规划发展项目介绍后台
     * 
     * @param ids 需要删除的规划发展项目介绍后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentProjectIntroductionByIds(Long[] ids)
    {
        return businessDevelopmentProjectIntroductionMapper.deleteBusinessDevelopmentProjectIntroductionByIds(ids);
    }

    /**
     * 删除规划发展项目介绍后台信息
     * 
     * @param id 规划发展项目介绍后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentProjectIntroductionById(Long id)
    {
        return businessDevelopmentProjectIntroductionMapper.deleteBusinessDevelopmentProjectIntroductionById(id);
    }

    @Override
    public List<String> selectBusinessDevelopmentProjectIntroductionOperatorByGroupList(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction) {
        List<String> returnList= businessDevelopmentProjectIntroductionMapper.selectBusinessDevelopmentProjectIntroductionOperatorByGroupList(businessDevelopmentProjectIntroduction);
        returnList.add(0,"请选择");
        return  returnList;
    }

    @Override
    public BusinessDevelopmentProjectIntroduction selectBusinessDevelopmentProjectIntroduction(BusinessDevelopmentProjectIntroduction businessDevelopmentProjectIntroduction) {
        List<BusinessDevelopmentProjectIntroduction> list = businessDevelopmentProjectIntroductionMapper.selectBusinessDevelopmentProjectIntroductionList(businessDevelopmentProjectIntroduction);
        if(list.size()>0){
            businessDevelopmentProjectIntroduction = list.get(0);
        }
        return businessDevelopmentProjectIntroduction;
    }
}
