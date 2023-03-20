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
import com.ruoyi.business.mapper.BusinessDevelopmentPolicyMapper;
import com.ruoyi.business.domain.BusinessDevelopmentPolicy;
import com.ruoyi.business.service.IBusinessDevelopmentPolicyService;

/**
 * 规划发展最新政策Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@Service
public class BusinessDevelopmentPolicyServiceImpl implements IBusinessDevelopmentPolicyService 
{
    @Autowired
    private BusinessDevelopmentPolicyMapper businessDevelopmentPolicyMapper;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展最新政策
     * 
     * @param id 规划发展最新政策ID
     * @return 规划发展最新政策
     */
    @Override
    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyById(Long id)
    {
        BusinessDevelopmentPolicy returnResult=businessDevelopmentPolicyMapper.selectBusinessDevelopmentPolicyById(id);
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    /**
     * 查询规划发展最新政策
     *
     * @param id 规划发展最新政策ID
     * @return 规划发展最新政策
     */
    @Override
    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyById2(Long id)
    {
        BusinessDevelopmentPolicy returnResult=businessDevelopmentPolicyMapper.selectBusinessDevelopmentPolicyById(id);
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }
    
    @Override
    public BusinessDevelopmentPolicy selectBusinessDevelopmentPolicyByVoid()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        loginUser.getUsername();
//        loginUser.getUser().getUserId();
        BusinessDevelopmentPolicy returnResult=new BusinessDevelopmentPolicy();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }
    /**
     * 查询规划发展最新政策列表
     * 
     * @param businessDevelopmentPolicy 规划发展最新政策
     * @return 规划发展最新政策
     */
    @Override
    public List<BusinessDevelopmentPolicy> selectBusinessDevelopmentPolicyList(BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        return businessDevelopmentPolicyMapper.selectBusinessDevelopmentPolicyList(businessDevelopmentPolicy);
    }

    /**
     * 新增规划发展最新政策
     * 
     * @param businessDevelopmentPolicy 规划发展最新政策
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentPolicy(BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        businessDevelopmentPolicy.setCreateTime(DateUtils.getNowDate());
        return businessDevelopmentPolicyMapper.insertBusinessDevelopmentPolicy(businessDevelopmentPolicy);
    }

    /**
     * 修改规划发展最新政策
     * 
     * @param businessDevelopmentPolicy 规划发展最新政策
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentPolicy(BusinessDevelopmentPolicy businessDevelopmentPolicy)
    {
        businessDevelopmentPolicy.setUpdateTime(DateUtils.getNowDate());
        return businessDevelopmentPolicyMapper.updateBusinessDevelopmentPolicy(businessDevelopmentPolicy);
    }

    /**
     * 批量删除规划发展最新政策
     * 
     * @param ids 需要删除的规划发展最新政策ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentPolicyByIds(Long[] ids)
    {
        return businessDevelopmentPolicyMapper.deleteBusinessDevelopmentPolicyByIds(ids);
    }

    /**
     * 删除规划发展最新政策信息
     * 
     * @param id 规划发展最新政策ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentPolicyById(Long id)
    {
        return businessDevelopmentPolicyMapper.deleteBusinessDevelopmentPolicyById(id);
    }
}
