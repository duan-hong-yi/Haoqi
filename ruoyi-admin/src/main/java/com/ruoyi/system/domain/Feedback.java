package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程调查管理对象 feedback
 * 
 * @author dhy
 * @date 2023-04-04
 */
public class Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程调查ID */
    private Long id;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 课程打分 */
    @Excel(name = "课程打分")
    private Long score;

    /** 课程建议 */
    @Excel(name = "课程建议")
    private String advice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setAdvice(String advice) 
    {
        this.advice = advice;
    }

    public String getAdvice() 
    {
        return advice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseId", getCourseId())
            .append("score", getScore())
            .append("advice", getAdvice())
            .toString();
    }
}
