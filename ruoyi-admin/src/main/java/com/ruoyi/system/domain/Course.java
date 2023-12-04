package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 培训课程管理对象 course
 * 
 * @author dhy
 * @date 2023-04-11
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long id;

    /** 课程主题 */
    @Excel(name = "课程主题")
    private String topic;

    /** 讲师ID */
    @Excel(name = "讲师ID")
    private Long lecturerId;

    /** 课程地点 */
    @Excel(name = "课程地点")
    private String location;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 单次课程时长 */
    @Excel(name = "单次课程时长")
    private Long singleTime;

    /** 课程数量 */
    @Excel(name = "课程数量")
    private Long courseNum;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 课程容量 */
    @Excel(name = "课程容量")
    private Long capacity;

    /** 课程状态 */
    @Excel(name = "课程状态")
    private Long courseStatus;

    private EmployeeCourse employeeCourse;
    private Date completeDate;
    private Long status;

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setEmployeeCourse(EmployeeCourse employeeCourse) {
        this.employeeCourse = employeeCourse;
    }

    public EmployeeCourse getEmployeeCourse() {
        return employeeCourse;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTopic(String topic) 
    {
        this.topic = topic;
    }

    public String getTopic() 
    {
        return topic;
    }
    public void setLecturerId(Long lecturerId) 
    {
        this.lecturerId = lecturerId;
    }

    public Long getLecturerId() 
    {
        return lecturerId;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setSingleTime(Long singleTime) 
    {
        this.singleTime = singleTime;
    }

    public Long getSingleTime() 
    {
        return singleTime;
    }
    public void setCourseNum(Long courseNum) 
    {
        this.courseNum = courseNum;
    }

    public Long getCourseNum() 
    {
        return courseNum;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }
    public void setCourseStatus(Long courseStatus) 
    {
        this.courseStatus = courseStatus;
    }

    public Long getCourseStatus() 
    {
        return courseStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("topic", getTopic())
            .append("lecturerId", getLecturerId())
            .append("location", getLocation())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("singleTime", getSingleTime())
            .append("courseNum", getCourseNum())
            .append("price", getPrice())
            .append("capacity", getCapacity())
            .append("courseStatus", getCourseStatus())
            .toString();
    }
}
