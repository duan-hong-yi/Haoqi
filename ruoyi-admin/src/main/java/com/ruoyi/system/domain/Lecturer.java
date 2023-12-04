package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 讲师资料管理对象 lecturer
 * 
 * @author dhy
 * @date 2023-04-04
 */
public class Lecturer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 讲师ID */
    private Long id;

    /** 讲师姓名 */
    @Excel(name = "讲师姓名")
    private String name;

    /** 讲师职称 */
    @Excel(name = "讲师职称")
    private String title;

    /** 讲师专业领域 */
    @Excel(name = "讲师专业领域")
    private String expertise;

    /** 讲师电子邮箱 */
    @Excel(name = "讲师电子邮箱")
    private String email;

    /** 讲师电话 */
    @Excel(name = "讲师电话")
    private String phone;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setExpertise(String expertise) 
    {
        this.expertise = expertise;
    }

    public String getExpertise() 
    {
        return expertise;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("title", getTitle())
            .append("expertise", getExpertise())
            .append("email", getEmail())
            .append("phone", getPhone())
            .toString();
    }
}
