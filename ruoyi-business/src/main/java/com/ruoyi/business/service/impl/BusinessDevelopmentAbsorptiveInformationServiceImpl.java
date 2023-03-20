package com.ruoyi.business.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentAbsorptiveInformationMapper;
import com.ruoyi.business.domain.BusinessDevelopmentAbsorptiveInformation;
import com.ruoyi.business.service.IBusinessDevelopmentAbsorptiveInformationService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展消纳板块Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@Service
public class BusinessDevelopmentAbsorptiveInformationServiceImpl implements IBusinessDevelopmentAbsorptiveInformationService 
{
    @Autowired
    private BusinessDevelopmentAbsorptiveInformationMapper businessDevelopmentAbsorptiveInformationMapper;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询规划发展消纳板块
     * 
     * @param id 规划发展消纳板块ID
     * @return 规划发展消纳板块
     */
    @Override
    public BusinessDevelopmentAbsorptiveInformation selectBusinessDevelopmentAbsorptiveInformationById(Long id)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentAbsorptiveInformation returnResult=businessDevelopmentAbsorptiveInformationMapper.selectBusinessDevelopmentAbsorptiveInformationById(id);
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
//        return businessDevelopmentAbsorptiveInformationMapper.selectBusinessDevelopmentAbsorptiveInformationById(id);
    }

    @Override
    public BusinessDevelopmentAbsorptiveInformation selectBusinessDevelopmentAbsorptiveInformationByVoid() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentAbsorptiveInformation returnResult=new BusinessDevelopmentAbsorptiveInformation();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    /**
     * 查询规划发展消纳板块列表
     * 
     * @param businessDevelopmentAbsorptiveInformation 规划发展消纳板块
     * @return 规划发展消纳板块
     */
    @Override
    public List<BusinessDevelopmentAbsorptiveInformation> selectBusinessDevelopmentAbsorptiveInformationList(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        return businessDevelopmentAbsorptiveInformationMapper.selectBusinessDevelopmentAbsorptiveInformationList(businessDevelopmentAbsorptiveInformation);
    }

    /**
     * 新增规划发展消纳板块
     * 
     * @param businessDevelopmentAbsorptiveInformation 规划发展消纳板块
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentAbsorptiveInformation(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        businessDevelopmentAbsorptiveInformation.setCreateTime(DateUtils.getNowDate());
        return businessDevelopmentAbsorptiveInformationMapper.insertBusinessDevelopmentAbsorptiveInformation(businessDevelopmentAbsorptiveInformation);
    }

    /**
     * 修改规划发展消纳板块
     * 
     * @param businessDevelopmentAbsorptiveInformation 规划发展消纳板块
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentAbsorptiveInformation(BusinessDevelopmentAbsorptiveInformation businessDevelopmentAbsorptiveInformation)
    {
        businessDevelopmentAbsorptiveInformation.setUpdateTime(DateUtils.getNowDate());
        return businessDevelopmentAbsorptiveInformationMapper.updateBusinessDevelopmentAbsorptiveInformation(businessDevelopmentAbsorptiveInformation);
    }

    /**
     * 批量删除规划发展消纳板块
     * 
     * @param ids 需要删除的规划发展消纳板块ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentAbsorptiveInformationByIds(Long[] ids)
    {
        return businessDevelopmentAbsorptiveInformationMapper.deleteBusinessDevelopmentAbsorptiveInformationByIds(ids);
    }

    /**
     * 删除规划发展消纳板块信息
     * 
     * @param id 规划发展消纳板块ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentAbsorptiveInformationById(Long id)
    {
        return businessDevelopmentAbsorptiveInformationMapper.deleteBusinessDevelopmentAbsorptiveInformationById(id);
    }

    @Override
    public AjaxResult informationFileUpload(MultipartFile file, String type, Long id)  throws IOException {
        if (!file.isEmpty()) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            Integer rows = null;
            // 上传并返回新文件名称
//            String fileName = FileUploadUtils.upload(filePath, file);
            Object fileName = FileUploadUtils.upload(filePath, file);
            BusinessDevelopmentAbsorptiveInformation temp = new BusinessDevelopmentAbsorptiveInformation();
//            if(-1L==id){
//                return AjaxResult.success(fileName);
//            }else {
//                if("1".equals(type)){
//                    temp.setId(id);
//                    temp.setAbsorptiveMap(fileName);
//                }else{
//                    temp.setId(id);
//                    temp.setMapDiscription(fileName);
//                }
//                return AjaxResult.success(fileName);
////                return AjaxResult.success(this.updateBusinessDevelopmentAbsorptiveInformation(temp));
//            }
            if("3".equals(type)){
                temp.setId(id);
                temp.setAbsorptiveMap((String)fileName);
                return AjaxResult.success(this.updateBusinessDevelopmentAbsorptiveInformation(temp));
            }else if("4".equals(type)){
                temp.setId(id);
                temp.setMapDiscription((String)fileName);
                return AjaxResult.success(this.updateBusinessDevelopmentAbsorptiveInformation(temp));
            }
            return AjaxResult.success(fileName);
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
    
}
