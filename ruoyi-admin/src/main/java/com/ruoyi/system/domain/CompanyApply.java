package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业级委托管理对象 company_apply
 * 
 * @author dhy
 * @date 2023-04-04
 */
public class CompanyApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID */
    private Long id;

    /** 企业申请用户ID */
    @Excel(name = "企业申请用户ID")
    private Long companyUserId;

    /** 委托培训主题 */
    @Excel(name = "委托培训主题")
    private String topic;

    /** 委托公司ID */
    @Excel(name = "委托公司ID")
    private Long companyId;

    /** 申请审核状况 */
    @Excel(name = "申请审核状况")
    private String checkStatus;

    /** 预期学生数量 */
    @Excel(name = "预期学生数量")
    private Long studentNumPrediction;

    private Company company;
    private String companyName;

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCompanyUserId(Long companyUserId) 
    {
        this.companyUserId = companyUserId;
    }

    public Long getCompanyUserId() 
    {
        return companyUserId;
    }
    public void setTopic(String topic) 
    {
        this.topic = topic;
    }

    public String getTopic() 
    {
        return topic;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setCheckStatus(String checkStatus) 
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus() 
    {
        return checkStatus;
    }
    public void setStudentNumPrediction(Long studentNumPrediction) 
    {
        this.studentNumPrediction = studentNumPrediction;
    }

    public Long getStudentNumPrediction() 
    {
        return studentNumPrediction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyUserId", getCompanyUserId())
            .append("topic", getTopic())
            .append("companyId", getCompanyId())
            .append("checkStatus", getCheckStatus())
            .append("studentNumPrediction", getStudentNumPrediction())
            .toString();
    }
}
