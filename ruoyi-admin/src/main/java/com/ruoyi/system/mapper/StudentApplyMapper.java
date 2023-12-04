package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.Student;
import com.ruoyi.system.domain.StudentApply;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.domain.StudentCourseRecord;

/**
 * 个人申请管理Mapper接口
 * 
 * @author dhy
 * @date 2023-04-05
 */
public interface StudentApplyMapper 
{
    /**
     * 查询个人申请管理
     * 
     * @param id 个人申请管理主键
     * @return 个人申请管理
     */
    public StudentApply selectStudentApplyById(Long id);

    /**
     * 查询个人申请管理列表
     * 
     * @param studentApply 个人申请管理
     * @return 个人申请管理集合
     */
    public List<StudentApply> selectStudentApplyList(StudentApply studentApply);

    /**
     * 新增个人申请管理
     * 
     * @param studentApply 个人申请管理
     * @return 结果
     */
    public int insertStudentApply(StudentApply studentApply);

    /**
     * 修改个人申请管理
     * 
     * @param studentApply 个人申请管理
     * @return 结果
     */
    public int updateStudentApply(StudentApply studentApply);

    /**
     * 删除个人申请管理
     * 
     * @param id 个人申请管理主键
     * @return 结果
     */
    public int deleteStudentApplyById(Long id);

    /**
     * 批量删除个人申请管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentApplyByIds(String[] ids);

    /**
     * 批量删除培训课程管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseByIds(String[] ids);
    
    /**
     * 批量新增培训课程管理
     * 
     * @param courseList 培训课程管理列表
     * @return 结果
     */
    public int batchCourse(List<Course> courseList);
    

    /**
     * 通过个人申请管理主键删除培训课程管理信息
     * 
     * @param id 个人申请管理ID
     * @return 结果
     */
    public int deleteCourseById(Long id);
    /**
     * 插入选课记录
     *
     * @param studentCourseRecord 学生课程记录表
     */
    public int insertStudentCourseRecord(StudentCourseRecord studentCourseRecord);

    public Student selectStudentById(Long id);
}
