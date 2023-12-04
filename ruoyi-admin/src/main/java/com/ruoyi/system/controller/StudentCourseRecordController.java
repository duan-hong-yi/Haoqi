package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.ShiroUtils;
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
import com.ruoyi.system.domain.StudentCourseRecord;
import com.ruoyi.system.service.IStudentCourseRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员课程记录管理Controller
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Controller
@RequestMapping("/system/record")
public class StudentCourseRecordController extends BaseController
{
    private String prefix = "system/record";

    @Autowired
    private IStudentCourseRecordService studentCourseRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询学员课程记录管理列表
     */
    @RequiresPermissions("system:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentCourseRecord studentCourseRecord)
    {
        startPage();
        List<StudentCourseRecord> list = studentCourseRecordService.selectStudentCourseRecordList(studentCourseRecord);
        for (StudentCourseRecord stdCR:list
             ) {
            stdCR.setName(studentCourseRecordService.selectStudentById(stdCR.getStudentId()).getName());
            stdCR.setTopic(studentCourseRecordService.selectCourseById(stdCR.getCourseId()).getTopic());
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
            List<StudentCourseRecord> list1 = new ArrayList<>();
            Long id = ShiroUtils.getSysUser().getStudentId();
            for (StudentCourseRecord stdCR :list
            ) {
                if(stdCR.getStudentId()==id)
                {
                    list1.add(stdCR);
                    break;
                }
            }
            return getDataTable(list1);
        }
        return getDataTable(list);
    }

    /**
     * 导出学员课程记录管理列表
     */
    @RequiresPermissions("system:record:export")
    @Log(title = "学员课程记录管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentCourseRecord studentCourseRecord)
    {
        List<StudentCourseRecord> list = studentCourseRecordService.selectStudentCourseRecordList(studentCourseRecord);
        ExcelUtil<StudentCourseRecord> util = new ExcelUtil<StudentCourseRecord>(StudentCourseRecord.class);
        return util.exportExcel(list, "学员课程记录管理数据");
    }

    /**
     * 新增学员课程记录管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学员课程记录管理
     */
    @RequiresPermissions("system:record:add")
    @Log(title = "学员课程记录管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentCourseRecord studentCourseRecord)
    {
        return toAjax(studentCourseRecordService.insertStudentCourseRecord(studentCourseRecord));
    }

    /**
     * 修改学员课程记录管理
     */
    @RequiresPermissions("system:record:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StudentCourseRecord studentCourseRecord = studentCourseRecordService.selectStudentCourseRecordById(id);
        mmap.put("studentCourseRecord", studentCourseRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存学员课程记录管理
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "学员课程记录管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentCourseRecord studentCourseRecord)
    {
        return toAjax(studentCourseRecordService.updateStudentCourseRecord(studentCourseRecord));
    }

    /**
     * 删除学员课程记录管理
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "学员课程记录管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentCourseRecordService.deleteStudentCourseRecordByIds(ids));
    }
}
