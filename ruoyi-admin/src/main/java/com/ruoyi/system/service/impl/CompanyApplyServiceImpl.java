package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.Company;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.domain.EmployeeCourse;
import com.ruoyi.web.controller.tool.TestController;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.aop.UserAnnotationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CompanyApplyMapper;
import com.ruoyi.system.domain.CompanyApply;
import com.ruoyi.system.service.ICompanyApplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业级委托管理Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Service
public class CompanyApplyServiceImpl implements ICompanyApplyService 
{
    @Autowired
    private CompanyApplyMapper companyApplyMapper;

    /**
     * 查询企业级委托管理
     * 
     * @param id 企业级委托管理主键
     * @return 企业级委托管理
     */
    @Override
    public CompanyApply selectCompanyApplyById(Long id)
    {
        return companyApplyMapper.selectCompanyApplyById(id);
    }

    /**
     * 查询企业级委托管理列表
     * 
     * @param companyApply 企业级委托管理
     * @return 企业级委托管理
     */
    @Override
    public List<CompanyApply> selectCompanyApplyList(CompanyApply companyApply)
    {
        return companyApplyMapper.selectCompanyApplyList(companyApply);
    }

    /**
     * 新增企业级委托管理
     * 
     * @param companyApply 企业级委托管理
     * @return 结果
     */
    @Override
    public int insertCompanyApply(CompanyApply companyApply)
    {
        companyApply.setCompanyUserId(ShiroUtils.getUserId());
        return companyApplyMapper.insertCompanyApply(companyApply);
    }

    /**
     * 修改企业级委托管理
     * 
     * @param companyApply 企业级委托管理
     * @return 结果
     */
    @Override
    public int updateCompanyApply(CompanyApply companyApply)
    {
        if(companyApply.getCheckStatus().equals("1"))
            insertCourse(companyApply);
        return companyApplyMapper.updateCompanyApply(companyApply);
    }

    /**
     * 批量删除企业级委托管理
     * 
     * @param ids 需要删除的企业级委托管理主键
     * @return 结果
     */
    @Override
    public int deleteCompanyApplyByIds(String ids)
    {
        return companyApplyMapper.deleteCompanyApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业级委托管理信息
     * 
     * @param id 企业级委托管理主键
     * @return 结果
     */
    @Override
    public int deleteCompanyApplyById(Long id)
    {
        return companyApplyMapper.deleteCompanyApplyById(id);
    }
    public int insertCourse(CompanyApply companyApply)
    {
        Course course = new Course();
        course.setTopic(companyApply.getTopic());
        course.setCourseStatus(0L);
        return companyApplyMapper.insertCourse(course);
    }
    public Company selectCompanyById(Long id)
    {
        return companyApplyMapper.selectCompanyById(id);
    }
}
