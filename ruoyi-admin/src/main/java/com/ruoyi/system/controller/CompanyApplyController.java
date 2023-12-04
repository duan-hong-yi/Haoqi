package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.StudentApply;
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
import com.ruoyi.system.domain.CompanyApply;
import com.ruoyi.system.service.ICompanyApplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业级委托管理Controller
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Controller
@RequestMapping("/system/companyapply")
public class CompanyApplyController extends BaseController
{
    private String prefix = "system/companyapply";

    @Autowired
    private ICompanyApplyService companyApplyService;

    @RequiresPermissions("system:companyapply:view")
    @GetMapping()
    public String companyapply()
    {
        return prefix + "/companyapply";
    }

    /**
     * 查询企业级委托管理列表
     */
    @RequiresPermissions("system:companyapply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompanyApply companyApply)
    {
        startPage();
        List<CompanyApply> list = companyApplyService.selectCompanyApplyList(companyApply);
        for (CompanyApply cmyapp:list
             ) {
            cmyapp.setCompany(companyApplyService.selectCompanyById(cmyapp.getCompanyId()));
            cmyapp.setCompanyName(cmyapp.getCompany().getName());
        }
        return getDataTable(list);
    }

    /**
     * 导出企业级委托管理列表
     */
    @RequiresPermissions("system:companyapply:export")
    @Log(title = "企业级委托管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyApply companyApply)
    {
        List<CompanyApply> list = companyApplyService.selectCompanyApplyList(companyApply);
        ExcelUtil<CompanyApply> util = new ExcelUtil<CompanyApply>(CompanyApply.class);
        return util.exportExcel(list, "企业级委托管理数据");
    }

    /**
     * 新增企业级委托管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业级委托管理
     */
    @RequiresPermissions("system:companyapply:add")
    @Log(title = "企业级委托管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompanyApply companyApply)
    {
        return toAjax(companyApplyService.insertCompanyApply(companyApply));
    }

    /**
     * 修改企业级委托管理
     */
    @RequiresPermissions("system:companyapply:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CompanyApply companyApply = companyApplyService.selectCompanyApplyById(id);
        mmap.put("companyApply", companyApply);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业级委托管理
     */
    @RequiresPermissions("system:companyapply:edit")
    @Log(title = "企业级委托管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompanyApply companyApply)
    {
        return toAjax(companyApplyService.updateCompanyApply(companyApply));
    }
    /**
     * 查看企业级申请
     */
    @RequiresPermissions("system:companyapply:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        CompanyApply companyApply = companyApplyService.selectCompanyApplyById(id);
        mmap.put("companyApply", companyApply);
        return prefix + "/detail";
    }
    /**
     * 删除企业级委托管理
     */
    @RequiresPermissions("system:companyapply:remove")
    @Log(title = "企业级委托管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyApplyService.deleteCompanyApplyByIds(ids));
    }
}
