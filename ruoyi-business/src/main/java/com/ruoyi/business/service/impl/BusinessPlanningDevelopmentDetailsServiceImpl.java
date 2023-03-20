package com.ruoyi.business.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.business.domain.BusinessAdministrativeVehicle;
import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentMapper;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentDetailsMapper;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentDetails;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展项目详情后台Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
@Service
public class BusinessPlanningDevelopmentDetailsServiceImpl implements IBusinessPlanningDevelopmentDetailsService 
{
    @Autowired
    private BusinessPlanningDevelopmentDetailsMapper businessPlanningDevelopmentDetailsMapper;
    @Autowired
    private BusinessPlanningDevelopmentMapper businessPlanningDevelopmentMapper;

    /**
     * 查询规划发展项目详情后台
     * 
     * @param id 规划发展项目详情后台ID
     * @return 规划发展项目详情后台
     */
    @Override
    public BusinessPlanningDevelopmentDetails selectBusinessPlanningDevelopmentDetailsById(Long id)
    {
        return businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsById(id);
    }

    /**
     * 查询规划发展项目详情后台列表
     * 
     * @param businessPlanningDevelopmentDetails 规划发展项目详情后台
     * @return 规划发展项目详情后台
     */
    @Override
    public List<BusinessPlanningDevelopmentDetails> selectBusinessPlanningDevelopmentDetailsList(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails)
    {
        return businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsList(businessPlanningDevelopmentDetails);
    }

    /**
     * 新增规划发展项目详情后台
     * 
     * @param businessPlanningDevelopmentDetails 规划发展项目详情后台
     * @return 结果
     */
    @Override
    public int insertBusinessPlanningDevelopmentDetails(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails)
    {
        businessPlanningDevelopmentDetails.setCreateTime(DateUtils.getNowDate());
        return businessPlanningDevelopmentDetailsMapper.insertBusinessPlanningDevelopmentDetails(businessPlanningDevelopmentDetails);
    }

    /**
     * 修改规划发展项目详情后台
     * 
     * @param businessPlanningDevelopmentDetails 规划发展项目详情后台
     * @return 结果
     */
    @Override
    public AjaxResult updateBusinessPlanningDevelopmentDetails(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails)
    {
        //获取登录的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //获取用户修改的详情的状态
        Integer updStatus = Integer.parseInt(businessPlanningDevelopmentDetails.getProjectDetailsStatus());
        //获取项目详情名称
        Integer detailsName = Integer.parseInt(businessPlanningDevelopmentDetails.getProjectDetailsName());
        //定义判断用变量
        Boolean bool = new Boolean(false);
        //如果状态不为'进行中'或者不为'否'则进入if
        if(updStatus != 0 && updStatus != 7){
            //添加修改人与修改时间
            businessPlanningDevelopmentDetails.setUpdateBy(loginUser.getUsername());
            businessPlanningDevelopmentDetails.setUpdateTime(DateUtils.getNowDate());
            businessPlanningDevelopmentDetails.setProjectFinishDate(new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.getNowDate()));
            //详情如果为最开始的0~1则不进行判断
            if(detailsName>1){
                //获取所属项目的编号与项目状态
                String projectId = businessPlanningDevelopmentDetails.getProjectNumber();
                String projectStatus = businessPlanningDevelopmentDetails.getProjectStatus();
                //查询同项目同项目状态的数据
                BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
                //填入项目编号与项目状态
                select.setProjectNumber(projectId);
                select.setProjectStatus(projectStatus);
                //查询数据
                List<BusinessPlanningDevelopmentDetails> detailsList = this.selectBusinessPlanningDevelopmentDetailsList(select);
                if(detailsName == 7) {
                    for (BusinessPlanningDevelopmentDetails details:detailsList) {
                        Integer tgDetailsName = Integer.parseInt(details.getProjectDetailsName());
                        if(tgDetailsName<2||tgDetailsName>6)continue;
                        Integer status = Integer.parseInt(details.getProjectDetailsStatus());
                        if(status == 0){
                            bool = true;
                            break;
                        }
                    }
                }else if(detailsName == 14){
                    for (BusinessPlanningDevelopmentDetails details:detailsList) {
                        Integer tgDetailsName = Integer.parseInt(details.getProjectDetailsName());
                        if(tgDetailsName<9||tgDetailsName>13)continue;
                        Integer status = Integer.parseInt(details.getProjectDetailsStatus());
                        if(status == 0){
                            bool = true;
                            break;
                        }
                    }
                }else{
                    if(detailsName>8&&detailsName<14){
                        for (BusinessPlanningDevelopmentDetails details:detailsList) {
                            Integer tgDetailsName = Integer.parseInt(details.getProjectDetailsName());
                            if(tgDetailsName != 8)continue;
                            Integer status = Integer.parseInt(details.getProjectDetailsStatus());
                            if(status == 0){
                                bool = true;
                                break;
                            }
                        }
                    }else if(detailsName>1&&detailsName<7){
                        for (BusinessPlanningDevelopmentDetails details:detailsList) {
                            Integer tgDetailsName = Integer.parseInt(details.getProjectDetailsName());
                            if(tgDetailsName > 1)continue;
                            Integer status = Integer.parseInt(details.getProjectDetailsStatus());
                            if(status == 0){
                                bool = true;
                                break;
                            }
                        }
                    }else{
                        for (BusinessPlanningDevelopmentDetails details:detailsList) {
                            //获取查询的每一个详情名称id
                            Integer tgDetailsName = Integer.parseInt(details.getProjectDetailsName());
                            //循环的详情大过修改的详情的时候直接忽视
                            if(tgDetailsName>detailsName)continue;
                            //22的详情是文件，无须加入判断
                            if(tgDetailsName==23)continue;
                            //除去上方两个同步功能，其他为线性
                            if(tgDetailsName<detailsName){
                                Integer status = Integer.parseInt(details.getProjectDetailsStatus());
                                if(status == 0){
                                    bool = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if(bool)return AjaxResult.error("未完成上一步详情。");
            }
        }
        //修改功能
        Integer rows = businessPlanningDevelopmentDetailsMapper.updateBusinessPlanningDevelopmentDetails(businessPlanningDevelopmentDetails);
        //获取项目id
        Long projectId = Long.parseLong(businessPlanningDevelopmentDetails.getProjectNumber());
        //查询项目
        BusinessPlanningDevelopment businessPlanningDevelopment = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(projectId);
        String projectStatus = businessPlanningDevelopment.getProjectStatus();
        if(rows>0&&detailsName==14 && updStatus ==2 && projectStatus.equals("0")){
            rows = updatePlanningDevelopmentStatus(projectId,1);
        }
        if(rows>0&&detailsName==24 && updStatus ==6 && projectStatus.equals("1")){
            rows = updatePlanningDevelopmentStatus(projectId,2);
        }
        if(rows == -3){
            return AjaxResult.error("下一步已生成，请勿重复操作。");
        }else{
            return rows > 0 ? AjaxResult.success() : AjaxResult.error();
        }
    }
    private Integer updatePlanningDevelopmentStatus(Long projectId,Integer projectStatus){
        //查询同项目同项目状态的数据
        BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
        //填入项目编号与项目状态
        select.setProjectNumber(projectId.toString());
        select.setProjectStatus(projectStatus.toString());
        List<BusinessPlanningDevelopmentDetails> dls = businessPlanningDevelopmentDetailsMapper.selectBusinessPlanningDevelopmentDetailsList(select);
        if(dls.size()>0){
            return -3;
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        BusinessPlanningDevelopment planningDevelopment = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(projectId);
        planningDevelopment.setProjectStatus(projectStatus.toString());
        if(projectStatus == 2){
            planningDevelopment.setProjectFinish("6");
        }
        Integer rows = businessPlanningDevelopmentMapper.updateBusinessPlanningDevelopment(planningDevelopment);
        if(rows>0){
            if(projectStatus==1){
                for(Integer i = 15;i<24;i++){
                    BusinessPlanningDevelopmentDetails details = new BusinessPlanningDevelopmentDetails();
                    details.setProjectNumber(projectId.toString());
                    details.setProjectStatus(planningDevelopment.getProjectStatus());
                    details.setProjectDetailsName(i.toString());
                    details.setProjectDetailsStatus("0");
                    details.setStatus("1");
                    details.setCreateBy(loginUser.getUsername());
                    details.setCreateTime(DateUtils.getNowDate());
                    businessPlanningDevelopmentDetailsMapper.insertBusinessPlanningDevelopmentDetails(details);
                }
                BusinessPlanningDevelopmentDetails details = new BusinessPlanningDevelopmentDetails();
                details.setProjectNumber(projectId.toString());
                details.setProjectStatus(planningDevelopment.getProjectStatus());
                details.setProjectDetailsName("24");
                details.setProjectDetailsStatus("7");
                details.setStatus("1");
                details.setCreateBy(loginUser.getUsername());
                details.setCreateTime(DateUtils.getNowDate());
                businessPlanningDevelopmentDetailsMapper.insertBusinessPlanningDevelopmentDetails(details);
            }else if(projectStatus==2){
                BusinessPlanningDevelopmentDetails details = new BusinessPlanningDevelopmentDetails();
                details.setProjectNumber(projectId.toString());
                details.setProjectDetailsName("23");
                details.setProjectStatus("1");
                details = this.selectBusinessPlanningDevelopmentDetailsList(details).get(0);
                details.setProjectFinishDate(new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.getNowDate()));
                details.setProjectDetailsStatus("2");
                businessPlanningDevelopmentDetailsMapper.updateBusinessPlanningDevelopmentDetails(details);


            }

        }
        return rows;
    }

    /**
     * 批量删除规划发展项目详情后台
     * 
     * @param ids 需要删除的规划发展项目详情后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentDetailsByIds(Long[] ids)
    {
        return businessPlanningDevelopmentDetailsMapper.deleteBusinessPlanningDevelopmentDetailsByIds(ids);
    }

    /**
     * 删除规划发展项目详情后台信息
     * 
     * @param id 规划发展项目详情后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentDetailsById(Long id)
    {
        return businessPlanningDevelopmentDetailsMapper.deleteBusinessPlanningDevelopmentDetailsById(id);
    }

    @Override
    public AjaxResult projectFileNameSave(BusinessPlanningDevelopmentDetails businessPlanningDevelopmentDetails) throws IOException {
        Long projectNumber = Long.parseLong(businessPlanningDevelopmentDetails.getProjectNumber());
        BusinessPlanningDevelopment planningDevelopment = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentById(projectNumber);
        BusinessPlanningDevelopmentDetails select = new BusinessPlanningDevelopmentDetails();
        select.setProjectNumber(projectNumber.toString());
        select.setProjectDetailsName("23");
        select = this.selectBusinessPlanningDevelopmentDetailsList(select).get(0);
        select.setProjectFileName(businessPlanningDevelopmentDetails.getProjectFileName().substring((businessPlanningDevelopmentDetails.getProjectFileName().lastIndexOf("/") + 1)));
        select.setProjectFileType(businessPlanningDevelopmentDetails.getProjectFileType().substring((businessPlanningDevelopmentDetails.getProjectFileType().lastIndexOf(".") + 1)));
        select.setProjectFileAddress(businessPlanningDevelopmentDetails.getProjectFileAddress());
        Integer row = businessPlanningDevelopmentDetailsMapper.updateBusinessPlanningDevelopmentDetails(select);
        return row > 0 ? AjaxResult.success("上传文件成功") : AjaxResult.error("上传文件失败，请联系管理员");
    }
}
