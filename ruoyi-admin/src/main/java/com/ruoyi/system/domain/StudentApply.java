package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人申请管理对象 student_apply
 * 
 * @author dhy
 * @date 2023-04-05
 */
public class StudentApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID */
    private Long id;

    /** 学员ID */
    @Excel(name = "学员ID")
    private Long studentId;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String checkStatus;

    /** 培训课程管理信息 */
    private List<Course> courseList;
    /** 学生资料信息*/
    private Student student;

    private List<StudentCourseRecord> studentCourseRecordList;
    /** 学生姓名*/
    private String name;
    /** 课程名*/
    private String topic;
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCheckStatus(String checkStatus) 
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus() 
    {
        return checkStatus;
    }

    public List<Course> getCourseList()
    {
        return courseList;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    public List<StudentCourseRecord> getStudentCourseRecordList() {
        return studentCourseRecordList;
    }

    public void setStudentCourseRecordList(List<StudentCourseRecord> studentCourseRecordList) {
        this.studentCourseRecordList = studentCourseRecordList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
        setName(student.getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("courseId", getCourseId())
            .append("checkStatus", getCheckStatus())
            .append("courseList", getCourseList())
            .append("student", getStudent())
            .toString();
    }
}
