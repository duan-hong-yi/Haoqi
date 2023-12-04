package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.demo.controller.DemoOperateController;
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
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.IStudentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;

/**
 * 管理学员资料Controller
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Controller
@RequestMapping("/system/student")
public class StudentController extends BaseController
{
    private String prefix = "system/student";

    @Autowired
    private IStudentService studentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询管理学员资料列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student)
    {
        startPage();
        List<Student> list = studentService.selectStudentList(student);

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
            List<Student> list1 = new ArrayList<>();
            Long id = ShiroUtils.getSysUser().getStudentId();
            for (Student std:list
                 ) {
                if(std.getId()==id)
                {
                    list1.add(std);
                    break;
                }
            }
            return getDataTable(list1);
        }

        return getDataTable(list);
    }

    /**
     * 导出管理学员资料列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "管理学员资料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Student student)
    {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list, "管理学员资料数据");
    }

    /**
     * 导入管理学员资料列表
     */
    @RequiresPermissions("system:student:import")
    @Log(title = "管理学员资料", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importStudent(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Student> util = new ExcelUtil<>(Student.class);
        List<Student> studentList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = studentService.importStudent(studentList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:student:export")
    @Log(title = "导出模板", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() throws Exception
    {
        ExcelUtil<Student> util = new ExcelUtil<>(Student.class);
        return util.importTemplateExcel("学员资料");
    }
    /**
     * 新增管理学员资料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存管理学员资料
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "管理学员资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Student student)
    {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改管理学员资料
     */
    @RequiresPermissions("system:student:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Student student = studentService.selectStudentById(id);
        mmap.put("student", student);
        return prefix + "/edit";
    }
    /**
     * 修改保存管理学员资料
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "管理学员资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student student)
    {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除管理学员资料
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "管理学员资料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentService.deleteStudentByIds(ids));
    }
}
