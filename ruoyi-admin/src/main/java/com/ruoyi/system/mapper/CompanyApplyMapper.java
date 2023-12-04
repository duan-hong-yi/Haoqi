package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.Company;
import com.ruoyi.system.domain.CompanyApply;
import com.ruoyi.system.domain.Course;

/**
 * 企业级委托管理Mapper接口
 * 
 * @author dhy
 * @date 2023-04-04
 */
public interface CompanyApplyMapper 
{
    /**
     * 查询企业级委托管理
     * 
     * @param id 企业级委托管理主键
     * @return 企业级委托管理
     */
    public CompanyApply selectCompanyApplyById(Long id);

    /**
     * 查询企业级委托管理列表
     * 
     * @param companyApply 企业级委托管理
     * @return 企业级委托管理集合
     */
    public List<CompanyApply> selectCompanyApplyList(CompanyApply companyApply);

    /**
     * 新增企业级委托管理
     * 
     * @param companyApply 企业级委托管理
     * @return 结果
     */
    public int insertCompanyApply(CompanyApply companyApply);

    /**
     * 修改企业级委托管理
     * 
     * @param companyApply 企业级委托管理
     * @return 结果
     */
    public int updateCompanyApply(CompanyApply companyApply);

    /**
     * 删除企业级委托管理
     * 
     * @param id 企业级委托管理主键
     * @return 结果
     */
    public int deleteCompanyApplyById(Long id);

    /**
     * 批量删除企业级委托管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyApplyByIds(String[] ids);
    public int insertCourse(Course course);
    public Company selectCompanyById(Long id);
}
