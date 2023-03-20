package com.ruoyi.business.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 发展专班详情对象 business_development_class_details
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public class BusinessDevelopmentClassDetailsVo
{

    /** 背景及意义 */
    private String backgroundAddress;

    /** 进展及实施情况 */
    private String progressAddress;

    /** 项目计划及进度安排 */
    private String projectPlanningSchedulingAddress;


    /** 存在问题及应对措施 */
    private String questionSolutionAddress;

    public String getBackgroundAddress() {
        return backgroundAddress;
    }

    public void setBackgroundAddress(String backgroundAddress) {
        this.backgroundAddress = backgroundAddress;
    }

    public String getProgressAddress() {
        return progressAddress;
    }

    public void setProgressAddress(String progressAddress) {
        this.progressAddress = progressAddress;
    }

    public String getQuestionSolutionAddress() {
        return questionSolutionAddress;
    }

    public void setQuestionSolutionAddress(String questionSolutionAddress) {
        this.questionSolutionAddress = questionSolutionAddress;
    }

    public String getProjectPlanningSchedulingAddress() {
        return projectPlanningSchedulingAddress;
    }

    public void setProjectPlanningSchedulingAddress(String projectPlanningSchedulingAddress) {
        this.projectPlanningSchedulingAddress = projectPlanningSchedulingAddress;
    }

    public BusinessDevelopmentClassDetailsVo() {
    }

    public BusinessDevelopmentClassDetailsVo(String backgroundAddress, String progressAddress, String projectPlanningSchedulingAddress, String questionSolutionAddress) {
        this.backgroundAddress = backgroundAddress;
        this.progressAddress = progressAddress;
        this.projectPlanningSchedulingAddress = projectPlanningSchedulingAddress;
        this.questionSolutionAddress = questionSolutionAddress;
    }
}
