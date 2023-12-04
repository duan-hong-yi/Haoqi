package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.domain.EmployeeCourse;

/**
 * 培训课程管理Mapper接口
 * 
 * @author dhy
 * @date 2023-04-11
 */
public interface CourseMapper 
{
    /**
     * 查询培训课程管理
     * 
     * @param id 培训课程管理主键
     * @return 培训课程管理
     */
    public Course selectCourseById(Long id);

    /**
     * 查询培训课程管理列表
     * 
     * @param course 培训课程管理
     * @return 培训课程管理集合
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 新增培训课程管理
     * 
     * @param course 培训课程管理
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 修改培训课程管理
     * 
     * @param course 培训课程管理
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 删除培训课程管理
     * 
     * @param id 培训课程管理主键
     * @return 结果
     */
    public int deleteCourseById(Long id);

    /**
     * 批量删除培训课程管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseByIds(String[] ids);
    public EmployeeCourse selectEmployeeCourseById(Long id);
    public int updateEmployeeCourse(EmployeeCourse employeeCourse);
}
