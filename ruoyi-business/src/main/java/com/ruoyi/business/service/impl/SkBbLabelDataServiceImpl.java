package com.ruoyi.business.service.impl;

import java.util.List;

import com.ruoyi.business.mapper.SkBbLabelDataMapper;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.domain.SkBbLabelData;
import com.ruoyi.business.service.ISkBbLabelDataService;

/**
 * SkBbLabelDataService业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
@Service
public class SkBbLabelDataServiceImpl implements ISkBbLabelDataService
{
    @Autowired
    private SkBbLabelDataMapper skBbLabelDataMapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 查询SkBbLabel
     * 
     * @param name SkBbLabelID
     * @return SkBbLabel
     */
    @Override
    public SkBbLabelData selectSkBbLabelById(String name)
    {
        return skBbLabelDataMapper.selectSkBbLabelById(name);
    }

    /**
     * 查询SkBbLabel列表
     * 
     * @param skBbLabel SkBbLabel
     * @return SkBbLabel
     */
    @Override
    public List<SkBbLabelData> selectSkBbLabelList(SkBbLabelData skBbLabel)
    {
        return skBbLabelDataMapper.selectSkBbLabelList(skBbLabel);
    }

    /**
     * 新增SkBbLabel
     * 
     * @param skBbLabel SkBbLabel
     * @return 结果
     */
    @Override
    public int insertSkBbLabel(SkBbLabelData skBbLabel)
    {
        return skBbLabelDataMapper.insertSkBbLabel(skBbLabel);
    }

    /**
     * 修改SkBbLabel
     * 
     * @param skBbLabel SkBbLabel
     * @return 结果
     */
    @Override
    public int updateSkBbLabel(SkBbLabelData skBbLabel)
    {
        return skBbLabelDataMapper.updateSkBbLabel(skBbLabel);
    }

    /**
     * 批量删除SkBbLabel
     * 
     * @param names 需要删除的SkBbLabelID
     * @return 结果
     */
    @Override
    public int deleteSkBbLabelByIds(String[] names)
    {
        return skBbLabelDataMapper.deleteSkBbLabelByIds(names);
    }

    /**
     * 删除SkBbLabel信息
     * 
     * @param name SkBbLabelID
     * @return 结果
     */
    @Override
    public int deleteSkBbLabelById(String name)
    {
        return skBbLabelDataMapper.deleteSkBbLabelById(name);
    }

    @Override
    public String importData(List<SkBbLabelData> skBbLabel) {
        if(StringUtils.isEmpty(skBbLabel)||skBbLabel.size()<1){
            return "导入不能为空表格";
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SkBbLabelData sb:skBbLabel) {
            try {
                SkBbLabelData select = new SkBbLabelData();
                select.setName(sb.getName());
                select.setPlace(sb.getPlace());
                select.setLabelname(sb.getLabelname());
                List<SkBbLabelData> list = this.skBbLabelDataMapper.selectSkBbLabelList(select);
                if(list!=null && list.size()>0){
                    select.setUnit(sb.getUnit());
                    select.setLabel(sb.getLabel());
                    this.updateSkBbLabel(sb);
                    successMsg.append("<br/>" + sb.getName()+"的"+sb.getPlace()+"的"+sb.getLabelname() + " 标签修改成功");
                }else{
                    this.insertSkBbLabel(sb);
                    successMsg.append("<br/>" + sb.getName()+"的"+sb.getPlace()+"的"+sb.getLabelname() + " 标签导入成功");
                }
                successNum++;
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + sb.getName()+"的"+sb.getPlace()+"的"+sb.getLabelname() + " 标签导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
