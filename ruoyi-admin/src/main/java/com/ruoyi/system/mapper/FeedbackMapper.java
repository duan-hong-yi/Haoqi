package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Feedback;

/**
 * 课程调查管理Mapper接口
 * 
 * @author dhy
 * @date 2023-04-04
 */
public interface FeedbackMapper 
{
    /**
     * 查询课程调查管理
     * 
     * @param id 课程调查管理主键
     * @return 课程调查管理
     */
    public Feedback selectFeedbackById(Long id);

    /**
     * 查询课程调查管理列表
     * 
     * @param feedback 课程调查管理
     * @return 课程调查管理集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增课程调查管理
     * 
     * @param feedback 课程调查管理
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改课程调查管理
     * 
     * @param feedback 课程调查管理
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 删除课程调查管理
     * 
     * @param id 课程调查管理主键
     * @return 结果
     */
    public int deleteFeedbackById(Long id);

    /**
     * 批量删除课程调查管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeedbackByIds(String[] ids);
}
