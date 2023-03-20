package com.ruoyi.business.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.business.domain.BusinessPlanningDevelopment;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentMapper;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessPlanningDevelopmentProjectFileMapper;
import com.ruoyi.business.domain.BusinessPlanningDevelopmentProjectFile;
import com.ruoyi.business.service.IBusinessPlanningDevelopmentProjectFileService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规划发展项目文件后台Service业务层处理
 * 
 * @author yrb
 * @date 2021-04-28
 */
@Service
public class BusinessPlanningDevelopmentProjectFileServiceImpl implements IBusinessPlanningDevelopmentProjectFileService 
{
    @Autowired
    private BusinessPlanningDevelopmentProjectFileMapper businessPlanningDevelopmentProjectFileMapper;
    @Autowired
    private BusinessPlanningDevelopmentMapper businessPlanningDevelopmentMapper;

    /**
     * 查询规划发展项目文件后台
     * 
     * @param id 规划发展项目文件后台ID
     * @return 规划发展项目文件后台
     */
    @Override
    public BusinessPlanningDevelopmentProjectFile selectBusinessPlanningDevelopmentProjectFileById(Long id)
    {
        return businessPlanningDevelopmentProjectFileMapper.selectBusinessPlanningDevelopmentProjectFileById(id);
    }

    /**
     * 查询规划发展项目文件后台列表
     * 
     * @param businessPlanningDevelopmentProjectFile 规划发展项目文件后台
     * @return 规划发展项目文件后台
     */
    @Override
    public List<BusinessPlanningDevelopmentProjectFile> selectBusinessPlanningDevelopmentProjectFileList(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        return businessPlanningDevelopmentProjectFileMapper.selectBusinessPlanningDevelopmentProjectFileList(businessPlanningDevelopmentProjectFile);
    }

    /**
     * 新增规划发展项目文件后台
     * 
     * @param businessPlanningDevelopmentProjectFile 规划发展项目文件后台
     * @return 结果
     */
    @Override
    public int insertBusinessPlanningDevelopmentProjectFile(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        businessPlanningDevelopmentProjectFile.setCreateTime(DateUtils.getNowDate());
        return businessPlanningDevelopmentProjectFileMapper.insertBusinessPlanningDevelopmentProjectFile(businessPlanningDevelopmentProjectFile);
    }

    /**
     * 修改规划发展项目文件后台
     * 
     * @param businessPlanningDevelopmentProjectFile 规划发展项目文件后台
     * @return 结果
     */
    @Override
    public int updateBusinessPlanningDevelopmentProjectFile(BusinessPlanningDevelopmentProjectFile businessPlanningDevelopmentProjectFile)
    {
        businessPlanningDevelopmentProjectFile.setUpdateTime(DateUtils.getNowDate());
        return businessPlanningDevelopmentProjectFileMapper.updateBusinessPlanningDevelopmentProjectFile(businessPlanningDevelopmentProjectFile);
    }

    /**
     * 批量删除规划发展项目文件后台
     * 
     * @param ids 需要删除的规划发展项目文件后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentProjectFileByIds(Long[] ids)
    {
        return businessPlanningDevelopmentProjectFileMapper.deleteBusinessPlanningDevelopmentProjectFileByIds(ids);
    }

    /**
     * 删除规划发展项目文件后台信息
     * 
     * @param id 规划发展项目文件后台ID
     * @return 结果
     */
    @Override
    public int deleteBusinessPlanningDevelopmentProjectFileById(Long id)
    {
        return businessPlanningDevelopmentProjectFileMapper.deleteBusinessPlanningDevelopmentProjectFileById(id);
    }

    @Override
    public List<BusinessPlanningDevelopment> selectFinalProjectList() {
        BusinessPlanningDevelopment select = new BusinessPlanningDevelopment();
        select.setProjectStatus("2");
        return businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentList(select);
    }
    @Override
    public List<BusinessPlanningDevelopment> selectFileInsProjectList() {
        List<BusinessPlanningDevelopment> returnList = new ArrayList<>();
        BusinessPlanningDevelopment select = new BusinessPlanningDevelopment();
        select.setProjectStatus("2");
        List<BusinessPlanningDevelopment> selectList = businessPlanningDevelopmentMapper.selectBusinessPlanningDevelopmentList(select);
        for(BusinessPlanningDevelopment bpd: selectList){
            BusinessPlanningDevelopmentProjectFile selectFile = new BusinessPlanningDevelopmentProjectFile();
            selectFile.setProjectNumber(bpd.getId().toString());
            List<BusinessPlanningDevelopmentProjectFile> selectFileList = businessPlanningDevelopmentProjectFileMapper.selectBusinessPlanningDevelopmentProjectFileList(selectFile);
            if(selectFileList.size()>4)continue;
            returnList.add(bpd);
        }
        return returnList;
    }

    @Override
    public AjaxResult finalProjectFileUpload(MultipartFile file, String projectDate,String projectNumber, String projectFileIllustration) {
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        Integer rows = null;
        // 上传并返回新文件名称
        try {
            String fileName = FileUploadUtils.upload(filePath, file);
            BusinessPlanningDevelopmentProjectFile insert = new BusinessPlanningDevelopmentProjectFile();
            insert.setProjectDate(projectDate);
            insert.setProjectNumber(projectNumber);
            insert.setProjectFileName(fileName.substring((fileName.lastIndexOf("/") + 1)));
            insert.setProjectFileType(fileName.substring((fileName.lastIndexOf(".") + 1)));
            insert.setProjectFileAddress(fileName);
            insert.setProjectFileIllustration(projectFileIllustration);
            rows = this.insertBusinessPlanningDevelopmentProjectFile(insert);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows>0?AjaxResult.success():AjaxResult.error();
    }
}
