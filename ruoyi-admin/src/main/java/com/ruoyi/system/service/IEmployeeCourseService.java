package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EmployeeCourse;

/**
 * 执行人工作情况Service接口
 * 
 * @author dhy
 * @date 2023-04-13
 */
public interface IEmployeeCourseService 
{
    /**
     * 查询执行人工作情况
     * 
     * @param id 执行人工作情况主键
     * @return 执行人工作情况
     */
    public EmployeeCourse selectEmployeeCourseById(Long id);

    /**
     * 查询执行人工作情况列表
     * 
     * @param employeeCourse 执行人工作情况
     * @return 执行人工作情况集合
     */
    public List<EmployeeCourse> selectEmployeeCourseList(EmployeeCourse employeeCourse);

    /**
     * 新增执行人工作情况
     * 
     * @param employeeCourse 执行人工作情况
     * @return 结果
     */
    public int insertEmployeeCourse(EmployeeCourse employeeCourse);

    /**
     * 修改执行人工作情况
     * 
     * @param employeeCourse 执行人工作情况
     * @return 结果
     */
    public int updateEmployeeCourse(EmployeeCourse employeeCourse);

    /**
     * 批量删除执行人工作情况
     * 
     * @param ids 需要删除的执行人工作情况主键集合
     * @return 结果
     */
    public int deleteEmployeeCourseByIds(String ids);

    /**
     * 删除执行人工作情况信息
     * 
     * @param id 执行人工作情况主键
     * @return 结果
     */
    public int deleteEmployeeCourseById(Long id);
}
