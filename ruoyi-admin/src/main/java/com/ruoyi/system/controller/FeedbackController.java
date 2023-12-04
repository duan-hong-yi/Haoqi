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
import com.ruoyi.system.domain.Feedback;
import com.ruoyi.system.service.IFeedbackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程调查管理Controller
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Controller
@RequestMapping("/system/feedback")
public class FeedbackController extends BaseController
{
    private String prefix = "system/feedback";

    @Autowired
    private IFeedbackService feedbackService;

    @RequiresPermissions("system:feedback:view")
    @GetMapping()
    public String feedback()
    {
        return prefix + "/feedback";
    }

    /**
     * 查询课程调查管理列表
     */
    @RequiresPermissions("system:feedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Feedback feedback)
    {
        startPage();
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }

    /**
     * 导出课程调查管理列表
     */
    @RequiresPermissions("system:feedback:export")
    @Log(title = "课程调查管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Feedback feedback)
    {
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        ExcelUtil<Feedback> util = new ExcelUtil<Feedback>(Feedback.class);
        return util.exportExcel(list, "课程调查管理数据");
    }

    /**
     * 新增课程调查管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程调查管理
     */
    @RequiresPermissions("system:feedback:add")
    @Log(title = "课程调查管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Feedback feedback)
    {
        return toAjax(feedbackService.insertFeedback(feedback));
    }

    /**
     * 修改课程调查管理
     */
    @RequiresPermissions("system:feedback:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Feedback feedback = feedbackService.selectFeedbackById(id);
        mmap.put("feedback", feedback);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程调查管理
     */
    @RequiresPermissions("system:feedback:edit")
    @Log(title = "课程调查管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Feedback feedback)
    {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除课程调查管理
     */
    @RequiresPermissions("system:feedback:remove")
    @Log(title = "课程调查管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(feedbackService.deleteFeedbackByIds(ids));
    }
}
