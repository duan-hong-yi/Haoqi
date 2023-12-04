package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.EmployeeCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CourseMapper;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.service.ICourseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 培训课程管理Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-11
 */
@Service
public class CourseServiceImpl implements ICourseService 
{
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询培训课程管理
     * 
     * @param id 培训课程管理主键
     * @return 培训课程管理
     */
    @Override
    public Course selectCourseById(Long id)
    {
        Course course = courseMapper.selectCourseById(id);
        EmployeeCourse employeeCourse = courseMapper.selectEmployeeCourseById(course.getId());//是课程ID，懒得改了
        course.setEmployeeCourse(employeeCourse);
        return course;
    }

    /**
     * 查询培训课程管理列表
     * 
     * @param course 培训课程管理
     * @return 培训课程管理
     */
    @Override
    public List<Course> selectCourseList(Course course)
    {
        List<Course>courseList = courseMapper.selectCourseList(course);
        for (Course c:courseList
             ) {
            EmployeeCourse employeeCourse = courseMapper.selectEmployeeCourseById(c.getId());
            c.setEmployeeCourse(employeeCourse);
        }
        return courseList;
    }

    /**
     * 新增培训课程管理
     * 
     * @param course 培训课程管理
     * @return 结果
     */
    @Override
    public int insertCourse(Course course)
    {
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改培训课程管理
     * 
     * @param course 培训课程管理
     * @return 结果
     */
    @Override
    public int updateCourse(Course course)
    {
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除培训课程管理
     * 
     * @param ids 需要删除的培训课程管理主键
     * @return 结果
     */
    @Override
    public int deleteCourseByIds(String ids)
    {
        return courseMapper.deleteCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除培训课程管理信息
     * 
     * @param id 培训课程管理主键
     * @return 结果
     */
    @Override
    public int deleteCourseById(Long id)
    {
        return courseMapper.deleteCourseById(id);
    }
    public EmployeeCourse selectEmployeeCourseById(Long id)
    {
        return courseMapper.selectEmployeeCourseById(id);
    }
    public int updateEmployeeCourse(EmployeeCourse employeeCourse)
    {
        return courseMapper.updateEmployeeCourse(employeeCourse);
    }
}
