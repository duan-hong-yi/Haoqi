package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管理学员资料对象 student
 * 
 * @author dhy
 * @date 2023-04-04
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学员ID */
    private Long id;

    /** 学员姓名 */
    @Excel(name = "学员姓名")
    private String name;

    /** 学员性别 */
    @Excel(name = "学员性别")
    private String sex;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 岗位 */
    @Excel(name = "岗位")
    private String duty;

    /** 技术水平 */
    @Excel(name = "技术水平")
    private String level;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Long companyId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setDuty(String duty) 
    {
        this.duty = duty;
    }

    public String getDuty() 
    {
        return duty;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("companyName", getCompanyName())
            .append("duty", getDuty())
            .append("level", getLevel())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("companyId", getCompanyId())
            .toString();
    }
}
