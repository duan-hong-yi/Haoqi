package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CompanyMapper;
import com.ruoyi.system.domain.Company;
import com.ruoyi.system.service.ICompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 委托公司查询Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Service
public class CompanyServiceImpl implements ICompanyService 
{
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 查询委托公司查询
     * 
     * @param id 委托公司查询主键
     * @return 委托公司查询
     */
    @Override
    public Company selectCompanyById(Long id)
    {
        return companyMapper.selectCompanyById(id);
    }

    /**
     * 查询委托公司查询列表
     * 
     * @param company 委托公司查询
     * @return 委托公司查询
     */
    @Override
    public List<Company> selectCompanyList(Company company)
    {
        return companyMapper.selectCompanyList(company);
    }

    /**
     * 新增委托公司查询
     * 
     * @param company 委托公司查询
     * @return 结果
     */
    @Override
    public int insertCompany(Company company)
    {
        return companyMapper.insertCompany(company);
    }

    /**
     * 修改委托公司查询
     * 
     * @param company 委托公司查询
     * @return 结果
     */
    @Override
    public int updateCompany(Company company)
    {
        return companyMapper.updateCompany(company);
    }

    /**
     * 批量删除委托公司查询
     * 
     * @param ids 需要删除的委托公司查询主键
     * @return 结果
     */
    @Override
    public int deleteCompanyByIds(String ids)
    {
        return companyMapper.deleteCompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除委托公司查询信息
     * 
     * @param id 委托公司查询主键
     * @return 结果
     */
    @Override
    public int deleteCompanyById(Long id)
    {
        return companyMapper.deleteCompanyById(id);
    }
}
