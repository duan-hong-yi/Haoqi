package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Lecturer;

/**
 * 讲师资料管理Mapper接口
 * 
 * @author dhy
 * @date 2023-04-04
 */
public interface LecturerMapper 
{
    /**
     * 查询讲师资料管理
     * 
     * @param id 讲师资料管理主键
     * @return 讲师资料管理
     */
    public Lecturer selectLecturerById(Long id);

    /**
     * 查询讲师资料管理列表
     * 
     * @param lecturer 讲师资料管理
     * @return 讲师资料管理集合
     */
    public List<Lecturer> selectLecturerList(Lecturer lecturer);

    /**
     * 新增讲师资料管理
     * 
     * @param lecturer 讲师资料管理
     * @return 结果
     */
    public int insertLecturer(Lecturer lecturer);

    /**
     * 修改讲师资料管理
     * 
     * @param lecturer 讲师资料管理
     * @return 结果
     */
    public int updateLecturer(Lecturer lecturer);

    /**
     * 删除讲师资料管理
     * 
     * @param id 讲师资料管理主键
     * @return 结果
     */
    public int deleteLecturerById(Long id);

    /**
     * 批量删除讲师资料管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLecturerByIds(String[] ids);
}
