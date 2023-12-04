package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.EmployeeCourse;
import com.ruoyi.system.service.IEmployeeCourseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 执行人工作情况Controller
 * 
 * @author dhy
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/system/employeeCourse")
public class EmployeeCourseController extends BaseController
{
    private String prefix = "system/employeeCourse";

    @Autowired
    private IEmployeeCourseService employeeCourseService;

    @RequiresPermissions("system:employeeCourse:view")
    @GetMapping()
    public String employeeCourse()
    {
        return prefix + "/employeeCourse";
    }

    /**
     * 查询执行人工作情况列表
     */
    @RequiresPermissions("system:employeeCourse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmployeeCourse employeeCourse)
    {
        startPage();
        List<EmployeeCourse> list = employeeCourseService.selectEmployeeCourseList(employeeCourse);
        return getDataTable(list);
    }

    /**
     * 导出执行人工作情况列表
     */
    @RequiresPermissions("system:employeeCourse:export")
    @Log(title = "执行人工作情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EmployeeCourse employeeCourse)
    {
        List<EmployeeCourse> list = employeeCourseService.selectEmployeeCourseList(employeeCourse);
        ExcelUtil<EmployeeCourse> util = new ExcelUtil<EmployeeCourse>(EmployeeCourse.class);
        return util.exportExcel(list, "执行人工作情况数据");
    }

    /**
     * 新增执行人工作情况
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存执行人工作情况
     */
    @RequiresPermissions("system:employeeCourse:add")
    @Log(title = "执行人工作情况", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmployeeCourse employeeCourse)
    {
        return toAjax(employeeCourseService.insertEmployeeCourse(employeeCourse));
    }

    /**
     * 修改执行人工作情况
     */
    @RequiresPermissions("system:employeeCourse:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EmployeeCourse employeeCourse = employeeCourseService.selectEmployeeCourseById(id);
        mmap.put("employeeCourse", employeeCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存执行人工作情况
     */
    @RequiresPermissions("system:employeeCourse:edit")
    @Log(title = "执行人工作情况", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmployeeCourse employeeCourse)
    {
        return toAjax(employeeCourseService.updateEmployeeCourse(employeeCourse));
    }

    /**
     * 删除执行人工作情况
     */
    @RequiresPermissions("system:employeeCourse:remove")
    @Log(title = "执行人工作情况", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(employeeCourseService.deleteEmployeeCourseByIds(ids));
    }
}
