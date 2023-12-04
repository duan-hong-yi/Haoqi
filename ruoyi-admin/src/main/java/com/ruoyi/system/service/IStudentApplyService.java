package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Student;
import com.ruoyi.system.domain.StudentApply;

/**
 * 个人申请管理Service接口
 * 
 * @author dhy
 * @date 2023-04-05
 */
public interface IStudentApplyService 
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
     * 批量删除个人申请管理
     * 
     * @param ids 需要删除的个人申请管理主键集合
     * @return 结果
     */
    public int deleteStudentApplyByIds(String ids);

    /**
     * 删除个人申请管理信息
     * 
     * @param id 个人申请管理主键
     * @return 结果
     */
    public int deleteStudentApplyById(Long id);
    public Student selectStudentById(Long id);
}
