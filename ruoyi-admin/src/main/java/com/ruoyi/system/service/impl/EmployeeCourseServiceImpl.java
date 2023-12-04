package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmployeeCourseMapper;
import com.ruoyi.system.domain.EmployeeCourse;
import com.ruoyi.system.service.IEmployeeCourseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 执行人工作情况Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-13
 */
@Service
public class EmployeeCourseServiceImpl implements IEmployeeCourseService 
{
    @Autowired
    private EmployeeCourseMapper employeeCourseMapper;

    /**
     * 查询执行人工作情况
     * 
     * @param id 执行人工作情况主键
     * @return 执行人工作情况
     */
    @Override
    public EmployeeCourse selectEmployeeCourseById(Long id)
    {
        return employeeCourseMapper.selectEmployeeCourseById(id);
    }

    /**
     * 查询执行人工作情况列表
     * 
     * @param employeeCourse 执行人工作情况
     * @return 执行人工作情况
     */
    @Override
    public List<EmployeeCourse> selectEmployeeCourseList(EmployeeCourse employeeCourse)
    {
        return employeeCourseMapper.selectEmployeeCourseList(employeeCourse);
    }

    /**
     * 新增执行人工作情况
     * 
     * @param employeeCourse 执行人工作情况
     * @return 结果
     */
    @Override
    public int insertEmployeeCourse(EmployeeCourse employeeCourse)
    {
        return employeeCourseMapper.insertEmployeeCourse(employeeCourse);
    }

    /**
     * 修改执行人工作情况
     * 
     * @param employeeCourse 执行人工作情况
     * @return 结果
     */
    @Override
    public int updateEmployeeCourse(EmployeeCourse employeeCourse)
    {
        return employeeCourseMapper.updateEmployeeCourse(employeeCourse);
    }

    /**
     * 批量删除执行人工作情况
     * 
     * @param ids 需要删除的执行人工作情况主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeCourseByIds(String ids)
    {
        return employeeCourseMapper.deleteEmployeeCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除执行人工作情况信息
     * 
     * @param id 执行人工作情况主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeCourseById(Long id)
    {
        return employeeCourseMapper.deleteEmployeeCourseById(id);
    }
}
