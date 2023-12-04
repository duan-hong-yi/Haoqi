package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Company;

/**
 * 委托公司查询Mapper接口
 * 
 * @author dhy
 * @date 2023-04-04
 */
public interface CompanyMapper 
{
    /**
     * 查询委托公司查询
     * 
     * @param id 委托公司查询主键
     * @return 委托公司查询
     */
    public Company selectCompanyById(Long id);

    /**
     * 查询委托公司查询列表
     * 
     * @param company 委托公司查询
     * @return 委托公司查询集合
     */
    public List<Company> selectCompanyList(Company company);

    /**
     * 新增委托公司查询
     * 
     * @param company 委托公司查询
     * @return 结果
     */
    public int insertCompany(Company company);

    /**
     * 修改委托公司查询
     * 
     * @param company 委托公司查询
     * @return 结果
     */
    public int updateCompany(Company company);

    /**
     * 删除委托公司查询
     * 
     * @param id 委托公司查询主键
     * @return 结果
     */
    public int deleteCompanyById(Long id);

    /**
     * 批量删除委托公司查询
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyByIds(String[] ids);
}
