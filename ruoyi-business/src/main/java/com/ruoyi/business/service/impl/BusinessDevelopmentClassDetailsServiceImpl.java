package com.ruoyi.business.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.vo.BusinessDevelopmentClassDetailsVo;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessDevelopmentClassDetailsMapper;
import com.ruoyi.business.domain.BusinessDevelopmentClassDetails;
import com.ruoyi.business.service.IBusinessDevelopmentClassDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 发展专班详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
@Service
public class BusinessDevelopmentClassDetailsServiceImpl implements IBusinessDevelopmentClassDetailsService 
{
    @Autowired
    private BusinessDevelopmentClassDetailsMapper businessDevelopmentClassDetailsMapper;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询发展专班详情
     * 
     * @param id 发展专班详情ID
     * @return 发展专班详情
     */
    @Override
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsById(Long id)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentClassDetails returnResult=businessDevelopmentClassDetailsMapper.selectBusinessDevelopmentClassDetailsById(id);
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    @Override
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsById(Long id,String type)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        BusinessDevelopmentClassDetails returnResult=businessDevelopmentClassDetailsMapper.selectBusinessDevelopmentClassDetailsById(id);
        if(!"1".equals(type)){
            returnResult.setOperator(loginUser.getUser().getNickName());
            returnResult.setOperatorNumber(loginUser.getUser().getUserName());
            returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        return returnResult;
    }

    /**
     * 查询发展专班详情列表
     * 
     * @param businessDevelopmentClassDetails 发展专班详情
     * @return 发展专班详情
     */
    @Override
    public List<BusinessDevelopmentClassDetails> selectBusinessDevelopmentClassDetailsList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        if("请选择".equals(businessDevelopmentClassDetails.getGroupLeader())){
            businessDevelopmentClassDetails.setGroupLeader("");
        }
        if("请选择".equals(businessDevelopmentClassDetails.getOperator())){
            businessDevelopmentClassDetails.setOperator("");
        }
        return businessDevelopmentClassDetailsMapper.selectBusinessDevelopmentClassDetailsList(businessDevelopmentClassDetails);
    }

    @Override
    public List<String> selectBusinessDevelopmentClassDetailsByGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails) {
        List<String> returnList= businessDevelopmentClassDetailsMapper.selectBusinessDevelopmentClassDetailsByGroupList(businessDevelopmentClassDetails);
        returnList.add(0,"请选择");
        return  returnList;
    }

    @Override
    public List<String> selectBusinessDevelopmentClassOperatorDetailsByGroupList(BusinessDevelopmentClassDetails businessDevelopmentClassDetails) {
        List<String> returnList= businessDevelopmentClassDetailsMapper.selectBusinessDevelopmentClassOperatorDetailsByGroupList(businessDevelopmentClassDetails);
        returnList.add(0,"请选择");
        return  returnList;
    }

    /**
     * 新增发展专班详情
     * 
     * @param bdcd 发展专班详情
     * @return 结果
     */
    @Override
    public int insertBusinessDevelopmentClassDetails(BusinessDevelopmentClassDetails bdcd)
    {
        bdcd.setCreateTime(DateUtils.getNowDate());
//        if(null!=bdcd.getBackground()&& bdcd.getBackground().length()>1800){
//            bdcd.getBackground().substring(3);
//            String[] getPick = bdcd.getBackground().split("</p>");
//            if(0!=getPick.length){
//                for (int i = 0; i < getPick.length; i++) {
//                    String value=getPick[i].substring(3);
//                    if(value.contentEquals("img src")){
//                        String img = value.substring(9,value.length()-1);
//                    }
//                }
//            }
//            bdcd.setBackground("<p><img src=\"D:\\ftp\\filedata\\huaneng\\upload\\2021\\05\\27\"></p>");
//        }
//        bdcd.getProgress().length();
//        bdcd.getProjectPlanningScheduling().length();
//        bdcd.getQuestionSolution().length();
        bdcd.setOperatorTime(bdcd.getDefaultTime());
        return businessDevelopmentClassDetailsMapper.insertBusinessDevelopmentClassDetails(bdcd);
    }

    /**
     * 修改发展专班详情
     * 
     * @param businessDevelopmentClassDetails 发展专班详情
     * @return 结果
     */
    @Override
    public int updateBusinessDevelopmentClassDetails(BusinessDevelopmentClassDetails businessDevelopmentClassDetails)
    {
        businessDevelopmentClassDetails.setUpdateTime(DateUtils.getNowDate());
        businessDevelopmentClassDetails.setOperatorTime(businessDevelopmentClassDetails.getDefaultTime());
        return businessDevelopmentClassDetailsMapper.updateBusinessDevelopmentClassDetails(businessDevelopmentClassDetails);
    }

    /**
     * 批量删除发展专班详情
     * 
     * @param ids 需要删除的发展专班详情ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentClassDetailsByIds(Long[] ids)
    {
        return businessDevelopmentClassDetailsMapper.deleteBusinessDevelopmentClassDetailsByIds(ids);
    }

    /**
     * 删除发展专班详情信息
     * 
     * @param id 发展专班详情ID
     * @return 结果
     */
    @Override
    public int deleteBusinessDevelopmentClassDetailsById(Long id)
    {
        return businessDevelopmentClassDetailsMapper.deleteBusinessDevelopmentClassDetailsById(id);
    }

    @Override
    public BusinessDevelopmentClassDetails selectBusinessDevelopmentClassDetailsByVoid() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        loginUser.getUsername();
//        loginUser.getUser().getUserId();
        BusinessDevelopmentClassDetails returnResult=new BusinessDevelopmentClassDetails();
        returnResult.setOperator(loginUser.getUser().getNickName());
        returnResult.setOperatorNumber(loginUser.getUser().getUserName());
        returnResult.setDefaultTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return returnResult;
    }

    @Override
    public AjaxResult specialityFileUpload(MultipartFile file, String type, Long id, BusinessDevelopmentClassDetailsVo address) throws IOException {
        if (!file.isEmpty()) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            Integer rows = null;
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            BusinessDevelopmentClassDetails temp = new BusinessDevelopmentClassDetails();
            if(-1==id){
                if("1".equals(type)){
                    temp.setBackgroundAddress(fileName);
                    if(null==address.getBackgroundAddress()){
//                        temp.setBackgroundAddress(filePath+",");
//                        temp.setBackgroundAddress(fileName);
                    }else {
//                        temp.setBackgroundAddress(address.getBackgroundAddress()+fileName+",");
                    }

                }else if("2".equals(type)){
                    temp.setProgressAddress(fileName);
                }else if("3".equals(type)){
                    temp.setProjectPlanningSchedulingAddress(fileName);
                }else if("4".equals(type)){
                    temp.setQuestionSolutionAddress(fileName);
                }
//                temp.setRemark(fileName);
                return AjaxResult.success(temp);
            }
//            temp.setVehicleImage(fileName);
//            if(null==id){
//                return AjaxResult.success(temp);
//            }
            temp.setId(id);
            return AjaxResult.success(this.updateBusinessDevelopmentClassDetails(temp));
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
