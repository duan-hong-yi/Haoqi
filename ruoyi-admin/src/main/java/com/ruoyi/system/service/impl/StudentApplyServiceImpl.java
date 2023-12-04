package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.domain.StudentCourseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.mapper.StudentApplyMapper;
import com.ruoyi.system.domain.StudentApply;
import com.ruoyi.system.service.IStudentApplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 个人申请管理Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-05
 */
@Service
public class StudentApplyServiceImpl implements IStudentApplyService 
{
    @Autowired
    private StudentApplyMapper studentApplyMapper;

    /**
     * 查询个人申请管理
     * 
     * @param id 个人申请管理主键
     * @return 个人申请管理
     */
    @Override
    public StudentApply selectStudentApplyById(Long id)
    {
        return studentApplyMapper.selectStudentApplyById(id);
    }

    /**
     * 查询个人申请管理列表
     * 
     * @param studentApply 个人申请管理
     * @return 个人申请管理
     */
    @Override
    public List<StudentApply> selectStudentApplyList(StudentApply studentApply)
    {
        return studentApplyMapper.selectStudentApplyList(studentApply);
    }

    /**
     * 新增个人申请管理
     * 
     * @param studentApply 个人申请管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertStudentApply (StudentApply studentApply)
    {
        studentApply.setCheckStatus("0");
        if(studentApply.getStudentId()==null)
        {
            if(ShiroUtils.getSysUser().getStudentId()!=null)
            {
                studentApply.setStudentId(ShiroUtils.getSysUser().getStudentId());
            }
            else
                studentApply.setStudentId(-1L);
        }
        int rows = studentApplyMapper.insertStudentApply(studentApply);
        //insertCourse(studentApply);
        return rows;
    }

    /**
     * 修改个人申请管理
     * 
     * @param studentApply 个人申请管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateStudentApply(StudentApply studentApply)
    {
        //studentApplyMapper.deleteCourseById(studentApply.getId());
        //insertCourse(studentApply);
        //禁止其向Course表插入
        studentApply.setStudentCourseRecordList(new ArrayList<>());
        studentApply.getStudentCourseRecordList().add(new StudentCourseRecord());
        studentApply.getStudentCourseRecordList().get(0).setCourseId(studentApply.getCourseId());
        studentApply.getStudentCourseRecordList().get(0).setStudentId(studentApply.getStudentId());
        studentApply.getStudentCourseRecordList().get(0).setPayStatus("0");
        studentApply.getStudentCourseRecordList().get(0).setSignInStatus("0");
        if(studentApply.getCheckStatus().equals("1"))
            insertStudentCourseRecord(studentApply);
        return studentApplyMapper.updateStudentApply(studentApply);
    }


    /**
     * 批量删除个人申请管理
     * 
     * @param ids 需要删除的个人申请管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteStudentApplyByIds(String ids)
    {
        //studentApplyMapper.deleteCourseByIds(Convert.toStrArray(ids));
        return studentApplyMapper.deleteStudentApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人申请管理信息
     * 
     * @param id 个人申请管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteStudentApplyById(Long id)
    {
        //studentApplyMapper.deleteCourseById(id);
        return studentApplyMapper.deleteStudentApplyById(id);
    }

    /**
     * 新增培训课程管理信息
     * 
     * @param studentApply 个人申请管理对象
     */
    public void insertCourse(StudentApply studentApply)
    {
        List<Course> courseList = studentApply.getCourseList();
        Long id = studentApply.getId();
        if (StringUtils.isNotNull(courseList))
        {
            List<Course> list = new ArrayList<Course>();
            for (Course course : courseList)
            {
                course.setId(id);
                list.add(course);
            }
            if (list.size() > 0)
            {
                studentApplyMapper.batchCourse(list);
            }
        }
    }
    public void insertStudentCourseRecord(StudentApply studentApply)
    {
        List<StudentCourseRecord> studentCourseRecordList = studentApply.getStudentCourseRecordList();
        Long id = studentApply.getId();
        if (StringUtils.isNotNull(studentCourseRecordList))
        {
            List<StudentCourseRecord> list = new ArrayList<StudentCourseRecord>();
            for (StudentCourseRecord studentCourseRecord : studentCourseRecordList)
            {
                studentCourseRecord.setId(id);
                list.add(studentCourseRecord);
            }
            if (list.size() > 0)
            {
                studentApplyMapper.insertStudentCourseRecord(list.get(0));
            }
        }
    }
    public Student selectStudentById(Long id)
    {
        return studentApplyMapper.selectStudentById(id);
    }
}
