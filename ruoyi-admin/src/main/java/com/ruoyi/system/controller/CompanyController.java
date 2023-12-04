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
import com.ruoyi.system.domain.Company;
import com.ruoyi.system.service.ICompanyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 委托公司查询Controller
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Controller
@RequestMapping("/system/company")
public class CompanyController extends BaseController
{
    private String prefix = "system/company";

    @Autowired
    private ICompanyService companyService;

    @RequiresPermissions("system:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询委托公司查询列表
     */
    @RequiresPermissions("system:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Company company)
    {
        startPage();
        List<Company> list = companyService.selectCompanyList(company);
        return getDataTable(list);
    }

    /**
     * 导出委托公司查询列表
     */
    @RequiresPermissions("system:company:export")
    @Log(title = "委托公司查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
        List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "委托公司查询数据");
    }

    /**
     * 新增委托公司查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存委托公司查询
     */
    @RequiresPermissions("system:company:add")
    @Log(title = "委托公司查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Company company)
    {
        return toAjax(companyService.insertCompany(company));
    }

    /**
     * 修改委托公司查询
     */
    @RequiresPermissions("system:company:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Company company = companyService.selectCompanyById(id);
        mmap.put("company", company);
        return prefix + "/edit";
    }

    /**
     * 修改保存委托公司查询
     */
    @RequiresPermissions("system:company:edit")
    @Log(title = "委托公司查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Company company)
    {
        return toAjax(companyService.updateCompany(company));
    }

    /**
     * 删除委托公司查询
     */
    @RequiresPermissions("system:company:remove")
    @Log(title = "委托公司查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyService.deleteCompanyByIds(ids));
    }
}
