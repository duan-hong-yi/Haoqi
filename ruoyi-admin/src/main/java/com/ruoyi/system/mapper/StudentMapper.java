package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Student;

/**
 * 管理学员资料Mapper接口
 * 
 * @author dhy
 * @date 2023-04-04
 */
public interface StudentMapper 
{
    /**
     * 查询管理学员资料
     * 
     * @param id 管理学员资料主键
     * @return 管理学员资料
     */
    public Student selectStudentById(Long id);

    /**
     * 查询管理学员资料列表
     * 
     * @param student 管理学员资料
     * @return 管理学员资料集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增管理学员资料
     * 
     * @param student 管理学员资料
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改管理学员资料
     * 
     * @param student 管理学员资料
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 删除管理学员资料
     * 
     * @param id 管理学员资料主键
     * @return 结果
     */
    public int deleteStudentById(Long id);

    /**
     * 批量删除管理学员资料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentByIds(String[] ids);
}
