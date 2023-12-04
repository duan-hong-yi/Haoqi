package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Course;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.domain.StudentCourseRecord;

/**
 * 学员课程记录管理Service接口
 * 
 * @author dhy
 * @date 2023-04-04
 */
public interface IStudentCourseRecordService 
{
    /**
     * 查询学员课程记录管理
     * 
     * @param id 学员课程记录管理主键
     * @return 学员课程记录管理
     */
    public StudentCourseRecord selectStudentCourseRecordById(Long id);

    /**
     * 查询学员课程记录管理列表
     * 
     * @param studentCourseRecord 学员课程记录管理
     * @return 学员课程记录管理集合
     */
    public List<StudentCourseRecord> selectStudentCourseRecordList(StudentCourseRecord studentCourseRecord);

    /**
     * 新增学员课程记录管理
     * 
     * @param studentCourseRecord 学员课程记录管理
     * @return 结果
     */
    public int insertStudentCourseRecord(StudentCourseRecord studentCourseRecord);

    /**
     * 修改学员课程记录管理
     * 
     * @param studentCourseRecord 学员课程记录管理
     * @return 结果
     */
    public int updateStudentCourseRecord(StudentCourseRecord studentCourseRecord);

    /**
     * 批量删除学员课程记录管理
     * 
     * @param ids 需要删除的学员课程记录管理主键集合
     * @return 结果
     */
    public int deleteStudentCourseRecordByIds(String ids);

    /**
     * 删除学员课程记录管理信息
     * 
     * @param id 学员课程记录管理主键
     * @return 结果
     */
    public int deleteStudentCourseRecordById(Long id);
    public Student selectStudentById(Long id);
    public Course selectCourseById(Long id);
}
