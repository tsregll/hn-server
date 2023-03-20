package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行业对标对象 business_five_group_industry
 * 
 * @author ruoyi
 * @date 2021-08-20
 */
public class BusinessFiveGroupIndustry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** $column.columnComment */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 年度 */
    @Excel(name = "年度")
    private String industryYear;

    /** 季度 */
    @Excel(name = "季度")
    private String industryQuarter;

    /** 集团 */
    @Excel(name = "集团",isRequired = true, readConverterExp = "0=大唐,1=国电投,2=华能,3=华电,4=国能投,5=五大合计,6=全省")
    private String industryGroup;

    /** 煤电 */
    @Excel(name = "煤电")
    private String industryMd;

    /** 水电 */
    @Excel(name = "水电")
    private String industrySd;

    /** 风电 */
    @Excel(name = "风电")
    private String industryFd;

    /** 光伏 */
    @Excel(name = "光伏")
    private String industryGf;

    /** 其他 */
    @Excel(name = "其他")
    private String industryQt;

    /** 合计 */
    @Excel(name = "合计")
    private String industryHj;

    /** 查询时间 */
//    @Excel(name = "查询时间")
    private String queryTime;
    private String queryBeginYear;
    private String queryBeginQuarter;
    private String queryEndYear;
    private String queryEndQuarter;

    public String getQueryBeginYear() {
        return queryBeginYear;
    }

    public void setQueryBeginYear(String queryBeginYear) {
        this.queryBeginYear = queryBeginYear;
    }

    public String getQueryBeginQuarter() {
        return queryBeginQuarter;
    }

    public void setQueryBeginQuarter(String queryBeginQuarter) {
        this.queryBeginQuarter = queryBeginQuarter;
    }

    public String getQueryEndYear() {
        return queryEndYear;
    }

    public void setQueryEndYear(String queryEndYear) {
        this.queryEndYear = queryEndYear;
    }

    public String getQueryEndQuarter() {
        return queryEndQuarter;
    }

    public void setQueryEndQuarter(String queryEndQuarter) {
        this.queryEndQuarter = queryEndQuarter;
    }

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
    public void setIndustryYear(String industryYear) 
    {
        this.industryYear = industryYear;
    }

    public String getIndustryYear() 
    {
        return industryYear;
    }
    public void setIndustryQuarter(String industryQuarter) 
    {
        this.industryQuarter = industryQuarter;
    }

    public String getIndustryQuarter() 
    {
        return industryQuarter;
    }
    public void setIndustryGroup(String industryGroup) 
    {
        this.industryGroup = industryGroup;
    }

    public String getIndustryGroup() 
    {
        return industryGroup;
    }
    public void setIndustryMd(String industryMd) 
    {
        this.industryMd = industryMd;
    }

    public String getIndustryMd() 
    {
        return industryMd;
    }
    public void setIndustrySd(String industrySd) 
    {
        this.industrySd = industrySd;
    }

    public String getIndustrySd() 
    {
        return industrySd;
    }
    public void setIndustryFd(String industryFd) 
    {
        this.industryFd = industryFd;
    }

    public String getIndustryFd() 
    {
        return industryFd;
    }
    public void setIndustryGf(String industryGf) 
    {
        this.industryGf = industryGf;
    }

    public String getIndustryGf() 
    {
        return industryGf;
    }
    public void setIndustryQt(String industryQt) 
    {
        this.industryQt = industryQt;
    }

    public String getIndustryQt() 
    {
        return industryQt;
    }
    public void setIndustryHj(String industryHj) 
    {
        this.industryHj = industryHj;
    }

    public String getIndustryHj() 
    {
        return industryHj;
    }
    public void setQueryTime(String queryTime) 
    {
        this.queryTime = queryTime;
    }

    public String getQueryTime() 
    {
        return queryTime;
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
            .append("industryYear", getIndustryYear())
            .append("industryQuarter", getIndustryQuarter())
            .append("industryGroup", getIndustryGroup())
            .append("industryMd", getIndustryMd())
            .append("industrySd", getIndustrySd())
            .append("industryFd", getIndustryFd())
            .append("industryGf", getIndustryGf())
            .append("industryQt", getIndustryQt())
            .append("industryHj", getIndustryHj())
            .append("queryTime", getQueryTime())
            .append("remark", getRemark())
            .toString();
    }
}
