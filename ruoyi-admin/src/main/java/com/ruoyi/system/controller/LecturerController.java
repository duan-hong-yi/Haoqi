package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.Student;
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
import com.ruoyi.system.domain.Lecturer;
import com.ruoyi.system.service.ILecturerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 讲师资料管理Controller
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Controller
@RequestMapping("/system/lecturer")
public class LecturerController extends BaseController
{
    private String prefix = "system/lecturer";

    @Autowired
    private ILecturerService lecturerService;

    @RequiresPermissions("system:lecturer:view")
    @GetMapping()
    public String lecturer()
    {
        return prefix + "/lecturer";
    }

    /**
     * 查询讲师资料管理列表
     */
    @RequiresPermissions("system:lecturer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Lecturer lecturer)
    {
        startPage();
        List<Lecturer> list = lecturerService.selectLecturerList(lecturer);
        return getDataTable(list);
    }

    /**
     * 导出讲师资料管理列表
     */
    @RequiresPermissions("system:lecturer:export")
    @Log(title = "讲师资料管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Lecturer lecturer)
    {
        List<Lecturer> list = lecturerService.selectLecturerList(lecturer);
        ExcelUtil<Lecturer> util = new ExcelUtil<Lecturer>(Lecturer.class);
        return util.exportExcel(list, "讲师资料管理数据");
    }

    /**
     * 新增讲师资料管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存讲师资料管理
     */
    @RequiresPermissions("system:lecturer:add")
    @Log(title = "讲师资料管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Lecturer lecturer)
    {
        return toAjax(lecturerService.insertLecturer(lecturer));
    }
    /**
     * 导入讲师资料列表
     */
    @RequiresPermissions("system:student:import")
    @Log(title = "讲师资料导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importStudent(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Lecturer> util = new ExcelUtil<>(Lecturer.class);
        List<Lecturer> lecturerList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = lecturerService.importLecturer(lecturerList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * 讲师资料导入模板
     * @return
     * @throws Exception
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "导出模板", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() throws Exception
    {
        ExcelUtil<Lecturer> util = new ExcelUtil<>(Lecturer.class);
        return util.importTemplateExcel("讲师资料");
    }
    /**
    /**
     * 修改讲师资料管理
     */
    @RequiresPermissions("system:lecturer:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Lecturer lecturer = lecturerService.selectLecturerById(id);
        mmap.put("lecturer", lecturer);
        return prefix + "/edit";
    }

    /**
     * 修改保存讲师资料管理
     */
    @RequiresPermissions("system:lecturer:edit")
    @Log(title = "讲师资料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Lecturer lecturer)
    {
        return toAjax(lecturerService.updateLecturer(lecturer));
    }

    /**
     * 删除讲师资料管理
     */
    @RequiresPermissions("system:lecturer:remove")
    @Log(title = "讲师资料管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lecturerService.deleteLecturerByIds(ids));
    }
}
