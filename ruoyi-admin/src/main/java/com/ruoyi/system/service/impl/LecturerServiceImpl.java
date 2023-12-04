package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LecturerMapper;
import com.ruoyi.system.domain.Lecturer;
import com.ruoyi.system.service.ILecturerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 讲师资料管理Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Service
public class LecturerServiceImpl implements ILecturerService 
{
    @Autowired
    private LecturerMapper lecturerMapper;

    /**
     * 查询讲师资料管理
     * 
     * @param id 讲师资料管理主键
     * @return 讲师资料管理
     */
    @Override
    public Lecturer selectLecturerById(Long id)
    {
        return lecturerMapper.selectLecturerById(id);
    }

    /**
     * 查询讲师资料管理列表
     * 
     * @param lecturer 讲师资料管理
     * @return 讲师资料管理
     */
    @Override
    public List<Lecturer> selectLecturerList(Lecturer lecturer)
    {
        return lecturerMapper.selectLecturerList(lecturer);
    }

    /**
     * 新增讲师资料管理
     * 
     * @param lecturer 讲师资料管理
     * @return 结果
     */
    @Override
    public int insertLecturer(Lecturer lecturer)
    {
        return lecturerMapper.insertLecturer(lecturer);
    }

    /**
     * 修改讲师资料管理
     * 
     * @param lecturer 讲师资料管理
     * @return 结果
     */
    @Override
    public int updateLecturer(Lecturer lecturer)
    {
        return lecturerMapper.updateLecturer(lecturer);
    }

    /**
     * 批量删除讲师资料管理
     * 
     * @param ids 需要删除的讲师资料管理主键
     * @return 结果
     */
    @Override
    public int deleteLecturerByIds(String ids)
    {
        return lecturerMapper.deleteLecturerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除讲师资料管理信息
     * 
     * @param id 讲师资料管理主键
     * @return 结果
     */
    @Override
    public int deleteLecturerById(Long id)
    {
        return lecturerMapper.deleteLecturerById(id);
    }
    public String importLecturer(List<Lecturer> lecturerList, boolean updateSupport, String operName)
    {
        if (StringUtils.isNull(lecturerList) || lecturerList.size() == 0)
        {
            System.out.println("数据为空");
        }
        StringBuilder successMsg = new StringBuilder();
        for (Lecturer lecturer : lecturerList)
        {
            lecturerMapper.insertLecturer(lecturer);
            successMsg.append(lecturer.getName()+"的信息已成功导入"+"\n");
        }

        return successMsg.toString();

    }
}
