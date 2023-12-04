package com.ruoyi.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.EmployeeCourse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.service.ICourseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 培训课程管理Controller
 * 
 * @author dhy
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/system/course")
public class CourseController extends BaseController
{
    private String prefix = "system/course";

    @Autowired
    private ICourseService courseService;

    @RequiresPermissions("system:course:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    /**
     * 查询培训课程管理列表
     */
    @RequiresPermissions("system:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Course course)
    {
        startPage();
        List<Course> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    /**
     * 导出培训课程管理列表
     */
    @RequiresPermissions("system:course:export")
    @Log(title = "培训课程管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Course course)
    {
        List<Course> list = courseService.selectCourseList(course);
        ExcelUtil<Course> util = new ExcelUtil<Course>(Course.class);
        return util.exportExcel(list, "培训课程管理数据");
    }

    /**
     * 新增培训课程管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存培训课程管理
     */
    @RequiresPermissions("system:course:add")
    @Log(title = "培训课程管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Course course)
    {
        return toAjax(courseService.insertCourse(course));
    }

    /**
     * 修改培训课程管理
     */
    @RequiresPermissions("system:course:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Course course = courseService.selectCourseById(id);
        mmap.put("course", course);
        return prefix + "/edit";
    }

    /**
     * 修改保存培训课程管理
     */
    @RequiresPermissions("system:course:edit")
    @Log(title = "培训课程管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Course course) throws ParseException {
        EmployeeCourse employeeCourse = courseService.selectEmployeeCourseById(course.getId());
        course.setEmployeeCourse(employeeCourse);
        if(course.getEmployeeCourse()!=null)
        {

            if(course.getCourseStatus()==1)
            {
                course.getEmployeeCourse().setStatus(1L);
                Date date = new Date();
                employeeCourse.setCompleteDate(date);
                courseService.updateEmployeeCourse(employeeCourse);
            }
        }
        return toAjax(courseService.updateCourse(course));
    }

    /**
     * 删除培训课程管理
     */
    @RequiresPermissions("system:course:remove")
    @Log(title = "培训课程管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(courseService.deleteCourseByIds(ids));
    }
}
