package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 执行人工作情况对象 employee_course
 * 
 * @author dhy
 * @date 2023-04-13
 */
public class EmployeeCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务记录ID */
    private Long id;

    /** 执行人用户ID */
    @Excel(name = "执行人用户ID")
    private Long employeeUserId;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 完成课程计划时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成课程计划时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeDate;

    /** 完成情况 */
    @Excel(name = "完成情况")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeeUserId(Long employeeUserId) 
    {
        this.employeeUserId = employeeUserId;
    }

    public Long getEmployeeUserId() 
    {
        return employeeUserId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCompleteDate(Date completeDate) 
    {
        this.completeDate = completeDate;
    }

    public Date getCompleteDate() 
    {
        return completeDate;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeUserId", getEmployeeUserId())
            .append("courseId", getCourseId())
            .append("completeDate", getCompleteDate())
            .append("status", getStatus())
            .toString();
    }
}
