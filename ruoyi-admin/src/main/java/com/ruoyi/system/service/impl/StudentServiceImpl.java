package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentMapper;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.IStudentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 管理学员资料Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Service
public class StudentServiceImpl implements IStudentService 
{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询管理学员资料
     * 
     * @param id 管理学员资料主键
     * @return 管理学员资料
     */
    @Override
    public Student selectStudentById(Long id)
    {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询管理学员资料列表
     * 
     * @param student 管理学员资料
     * @return 管理学员资料
     */
    @Override
    public List<Student> selectStudentList(Student student)
    {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增管理学员资料
     * 
     * @param student 管理学员资料
     * @return 结果
     */
    @Override
    public int insertStudent(Student student)
    {
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改管理学员资料
     * 
     * @param student 管理学员资料
     * @return 结果
     */
    @Override
    public int updateStudent(Student student)
    {
        return studentMapper.updateStudent(student);
    }

    /**
     * 批量删除管理学员资料
     * 
     * @param ids 需要删除的管理学员资料主键
     * @return 结果
     */
    @Override
    public int deleteStudentByIds(String ids)
    {
        return studentMapper.deleteStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除管理学员资料信息
     * 
     * @param id 管理学员资料主键
     * @return 结果
     */
    @Override
    public int deleteStudentById(Long id)
    {
        return studentMapper.deleteStudentById(id);
    }
    public String importStudent(List<Student> studentList, boolean updateSupport, String operName)
    {
        if (StringUtils.isNull(studentList) || studentList.size() == 0)
        {
            System.out.println("数据为空");
        }
        StringBuilder successMsg = new StringBuilder();
        for (Student student : studentList)
        {
            studentMapper.insertStudent(student);
            successMsg.append(student.getName()+"的信息已成功导入"+"\n");
        }

        return successMsg.toString();

    }
}
