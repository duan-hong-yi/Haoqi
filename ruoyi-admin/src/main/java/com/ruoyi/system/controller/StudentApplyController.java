package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.impl.CourseServiceImpl;
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
import com.ruoyi.system.domain.StudentApply;
import com.ruoyi.system.service.IStudentApplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人申请管理Controller
 * 
 * @author dhy
 * @date 2023-04-05
 */
@Controller
@RequestMapping("/system/studentapply")
public class StudentApplyController extends BaseController
{
    private String prefix = "system/studentapply";

    @Autowired
    private IStudentApplyService studentApplyService;

    @RequiresPermissions("system:studentapply:view")
    @GetMapping()
    public String studentapply()
    {
        return prefix + "/studentapply";
    }

    /**
     * 查询个人申请管理列表
     */
    @RequiresPermissions("system:studentapply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentApply studentApply)
    {
        startPage();
        List<StudentApply> list = studentApplyService.selectStudentApplyList(studentApply);
        for (StudentApply stdApp:list
             ) {
            StudentApply temp  = studentApplyService.selectStudentApplyById(stdApp.getId());
            stdApp.setTopic(temp.getTopic());
            stdApp.setCourseList(temp.getCourseList());
            stdApp.setStudent(studentApplyService.selectStudentById(stdApp.getStudentId()));
            stdApp.setName(stdApp.getStudent().getName());
            List<Course>courseList = stdApp.getCourseList();
            for (Course course:courseList
                 ) {
                if(course.getId()==stdApp.getCourseId())
                {
                    stdApp.setTopic(course.getTopic());
                    break;
                }
            }

        }
        List<SysRole> roleList = ShiroUtils.getSysUser().getRoles();
        boolean flag = false;
        for (SysRole role:roleList
        ) {
            if (role.getRoleKey().equals("LevelB"))
            {
                flag = true;
                break;
            }
            if (role.getRoleKey().equals("LevelA"))
            {
                flag = true;
                break;
            }
            if (role.getRoleKey().equals("admin"))
            {
                flag = true;
                break;
            }
        }

        if(!flag)
        {
            List<StudentApply> list1 = new ArrayList<>();
            Long id = ShiroUtils.getSysUser().getStudentId();
            for (StudentApply stdApp:list
            ) {
                if(stdApp.getStudentId()==id)
                {
                    list1.add(stdApp);
                    break;
                }
            }
            return getDataTable(list1);
        }
        return getDataTable(list);
    }

    /**
     * 导出个人申请管理列表
     */
    @RequiresPermissions("system:studentapply:export")
    @Log(title = "个人申请管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentApply studentApply)
    {
        List<StudentApply> list = studentApplyService.selectStudentApplyList(studentApply);
        ExcelUtil<StudentApply> util = new ExcelUtil<StudentApply>(StudentApply.class);
        return util.exportExcel(list, "个人申请管理数据");
    }

    /**
     * 新增个人申请管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存个人申请管理
     */
    @RequiresPermissions("system:studentapply:add")
    @Log(title = "个人申请管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentApply studentApply)
    {
        return toAjax(studentApplyService.insertStudentApply(studentApply));
    }

    /**
     * 修改个人申请管理
     */
    @RequiresPermissions("system:studentapply:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StudentApply studentApply = studentApplyService.selectStudentApplyById(id);
        Student student = studentApplyService.selectStudentById(studentApply.getStudentId());
        studentApply.setStudent(student);
        mmap.put("studentApply", studentApply);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人申请管理
     */
    @RequiresPermissions("system:studentapply:edit")
    @Log(title = "个人申请管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentApply studentApply)
    {
        return toAjax(studentApplyService.updateStudentApply(studentApply));
    }
    /**
     * 查看个人申请
     */
    @RequiresPermissions("system:studentapply:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        StudentApply studentApply = studentApplyService.selectStudentApplyById(id);
        Student student = studentApplyService.selectStudentById(studentApply.getStudentId());
        studentApply.setStudent(student);
        mmap.put("studentApply", studentApply);
        return prefix + "/detail";
    }
    /**
     * 删除个人申请管理
     */
    @RequiresPermissions("system:studentapply:remove")
    @Log(title = "个人申请管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentApplyService.deleteStudentApplyByIds(ids));
    }
}
