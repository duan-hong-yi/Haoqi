package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员课程记录管理对象 student_course_record
 *
 * @author dhy
 * @date 2023-04-04
 */
public class StudentCourseRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学员课程记录ID
     */
    private Long id;

    /**
     * 学员ID
     */
    @Excel(name = "学员ID")
    private Long studentId;

    /**
     * 课程ID
     */
    @Excel(name = "课程ID")
    private Long courseId;

    /**
     * 支付情况
     */
    @Excel(name = "支付情况")
    private String payStatus;

    /**
     * 签到情况
     */
    @Excel(name = "签到情况")
    private String signInStatus;
    private String name;
    private String topic;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setSignInStatus(String signInStatus) {
        this.signInStatus = signInStatus;
    }

    public String getSignInStatus() {
        return signInStatus;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("studentId", getStudentId())
                .append("courseId", getCourseId())
                .append("payStatus", getPayStatus())
                .append("signInStatus", getSignInStatus())
                .append("name", getName())
                .append("topic", getTopic())
                .toString();
    }
}
