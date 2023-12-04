package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Course;
import com.ruoyi.system.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentCourseRecordMapper;
import com.ruoyi.system.domain.StudentCourseRecord;
import com.ruoyi.system.service.IStudentCourseRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学员课程记录管理Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Service
public class StudentCourseRecordServiceImpl implements IStudentCourseRecordService 
{
    @Autowired
    private StudentCourseRecordMapper studentCourseRecordMapper;

    /**
     * 查询学员课程记录管理
     * 
     * @param id 学员课程记录管理主键
     * @return 学员课程记录管理
     */
    @Override
    public StudentCourseRecord selectStudentCourseRecordById(Long id)
    {
        return studentCourseRecordMapper.selectStudentCourseRecordById(id);
    }

    /**
     * 查询学员课程记录管理列表
     * 
     * @param studentCourseRecord 学员课程记录管理
     * @return 学员课程记录管理
     */
    @Override
    public List<StudentCourseRecord> selectStudentCourseRecordList(StudentCourseRecord studentCourseRecord)
    {
        return studentCourseRecordMapper.selectStudentCourseRecordList(studentCourseRecord);
    }

    /**
     * 新增学员课程记录管理
     * 
     * @param studentCourseRecord 学员课程记录管理
     * @return 结果
     */
    @Override
    public int insertStudentCourseRecord(StudentCourseRecord studentCourseRecord)
    {
        return studentCourseRecordMapper.insertStudentCourseRecord(studentCourseRecord);
    }

    /**
     * 修改学员课程记录管理
     * 
     * @param studentCourseRecord 学员课程记录管理
     * @return 结果
     */
    @Override
    public int updateStudentCourseRecord(StudentCourseRecord studentCourseRecord)
    {
        return studentCourseRecordMapper.updateStudentCourseRecord(studentCourseRecord);
    }

    /**
     * 批量删除学员课程记录管理
     * 
     * @param ids 需要删除的学员课程记录管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentCourseRecordByIds(String ids)
    {
        return studentCourseRecordMapper.deleteStudentCourseRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学员课程记录管理信息
     * 
     * @param id 学员课程记录管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentCourseRecordById(Long id)
    {
        return studentCourseRecordMapper.deleteStudentCourseRecordById(id);
    }
    public Student selectStudentById(Long id)
    {
        return studentCourseRecordMapper.selectStudentById(id);
    }
    public Course selectCourseById(Long id)
    {
        return studentCourseRecordMapper.selectCourseById(id);
    }
}
