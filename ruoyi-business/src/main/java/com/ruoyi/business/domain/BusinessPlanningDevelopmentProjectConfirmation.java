package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规划发展项目详情对象 business_planning_development_project_confirmation
 * 
 * @author ruoyi
 * @date 2021-06-15
 */
public class BusinessPlanningDevelopmentProjectConfirmation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 系统默认时间，精确到年月日时分秒 */

    private String defaultTime;

    /** 操作人 */

    private String operator;

    /** 操作人员 */

    private String operatorNumber;

    /** 项目类别（风电、光伏） */
    @Excel(name = "项目类别",isRequired = true, readConverterExp = "0=风电,1=光伏")
    private String projectType;

    /** 开发方式（自主开发、合作收购） */
//    @Excel(name = "开发方式")
    @Excel(name = "开发方式",isRequired = true, readConverterExp = "0=自主开发,1=合作收购")
    private String projectDevelopmentWay;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 容量（单位（万千瓦），保留两位小数） */
    @Excel(name = "容量")
    private String capacity;

    /** 所在地区 */
    @Excel(name = "所在地区")
    private String area;

    /** 责任单位 */
    @Excel(name = "责任单位",isRequired = true, readConverterExp = "0=清能公司,1=岳阳电厂,2=分公司")
    private String projectDepartment;

    /** 消纳情况(红色、黄色、绿色、橙色) */
    @Excel(name = "消纳情况",isRequired = true, readConverterExp = "0=红色,1=黄色,2=绿色,3=橙色")
    private String projectAbsorptiveDetails;

    /** 是/否开展可研 */
//    @Excel(name = "是/否开展可研")
    @Excel(name = "是/否开展可研",isRequired = true, readConverterExp = "0=是,1=/")
    private String isResearch;

    /** 是/否核准（备案）项目 */
//    @Excel(name = "是/否核准")
    @Excel(name = "是/否核准",isRequired = true, readConverterExp = "0=是,1=/")
    private String projectIsCheck;

    /** 核准日期 */
    @Excel(name = "核准日期")
    private String checkTime;

    /** 是/否开工项目 */
//    @Excel(name = "是/否开工项目")
    @Excel(name = "是/否开工项目",isRequired = true, readConverterExp = "0=是,1=/")
    private String projectIsEnablement;

    /** 开工日期 */
    @Excel(name = "开工日期")
    private String enablementTime;

    /** 是/否投产项目 */
//    @Excel(name = "是/否投产项目")
    @Excel(name = "是/否投产项目",isRequired = true, readConverterExp = "0=是,1=/")
    private String projectIsInvestment;

    /** 投产日期 */
    @Excel(name = "投产日期")
    private String investmentTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setDefaultTime(String defaultTime) 
    {
        this.defaultTime = defaultTime;
    }

    public String getDefaultTime() 
    {
        return defaultTime;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setOperatorNumber(String operatorNumber) 
    {
        this.operatorNumber = operatorNumber;
    }

    public String getOperatorNumber() 
    {
        return operatorNumber;
    }
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setProjectDevelopmentWay(String projectDevelopmentWay) 
    {
        this.projectDevelopmentWay = projectDevelopmentWay;
    }

    public String getProjectDevelopmentWay() 
    {
        return projectDevelopmentWay;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setCapacity(String capacity) 
    {
        this.capacity = capacity;
    }

    public String getCapacity() 
    {
        return capacity;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setProjectDepartment(String projectDepartment) 
    {
        this.projectDepartment = projectDepartment;
    }

    public String getProjectDepartment() 
    {
        return projectDepartment;
    }
    public void setProjectAbsorptiveDetails(String projectAbsorptiveDetails) 
    {
        this.projectAbsorptiveDetails = projectAbsorptiveDetails;
    }

    public String getProjectAbsorptiveDetails() 
    {
        return projectAbsorptiveDetails;
    }
    public void setIsResearch(String isResearch) 
    {
        this.isResearch = isResearch;
    }

    public String getIsResearch() 
    {
        return isResearch;
    }
    public void setProjectIsCheck(String projectIsCheck) 
    {
        this.projectIsCheck = projectIsCheck;
    }

    public String getProjectIsCheck() 
    {
        return projectIsCheck;
    }
    public void setCheckTime(String checkTime) 
    {
        this.checkTime = checkTime;
    }

    public String getCheckTime() 
    {
        return checkTime;
    }
    public void setProjectIsEnablement(String projectIsEnablement) 
    {
        this.projectIsEnablement = projectIsEnablement;
    }

    public String getProjectIsEnablement() 
    {
        return projectIsEnablement;
    }
    public void setEnablementTime(String enablementTime) 
    {
        this.enablementTime = enablementTime;
    }

    public String getEnablementTime() 
    {
        return enablementTime;
    }
    public void setProjectIsInvestment(String projectIsInvestment) 
    {
        this.projectIsInvestment = projectIsInvestment;
    }

    public String getProjectIsInvestment() 
    {
        return projectIsInvestment;
    }
    public void setInvestmentTime(String investmentTime) 
    {
        this.investmentTime = investmentTime;
    }

    public String getInvestmentTime() 
    {
        return investmentTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("defaultTime", getDefaultTime())
            .append("operator", getOperator())
            .append("operatorNumber", getOperatorNumber())
            .append("projectType", getProjectType())
            .append("projectDevelopmentWay", getProjectDevelopmentWay())
            .append("projectName", getProjectName())
            .append("capacity", getCapacity())
            .append("area", getArea())
            .append("projectDepartment", getProjectDepartment())
            .append("projectAbsorptiveDetails", getProjectAbsorptiveDetails())
            .append("isResearch", getIsResearch())
            .append("projectIsCheck", getProjectIsCheck())
            .append("checkTime", getCheckTime())
            .append("projectIsEnablement", getProjectIsEnablement())
            .append("enablementTime", getEnablementTime())
            .append("projectIsInvestment", getProjectIsInvestment())
            .append("investmentTime", getInvestmentTime())
            .toString();
    }
}
