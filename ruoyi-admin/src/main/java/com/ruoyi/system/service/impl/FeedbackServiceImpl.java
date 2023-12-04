package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FeedbackMapper;
import com.ruoyi.system.domain.Feedback;
import com.ruoyi.system.service.IFeedbackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 课程调查管理Service业务层处理
 * 
 * @author dhy
 * @date 2023-04-04
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService 
{
    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 查询课程调查管理
     * 
     * @param id 课程调查管理主键
     * @return 课程调查管理
     */
    @Override
    public Feedback selectFeedbackById(Long id)
    {
        return feedbackMapper.selectFeedbackById(id);
    }

    /**
     * 查询课程调查管理列表
     * 
     * @param feedback 课程调查管理
     * @return 课程调查管理
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback)
    {
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增课程调查管理
     * 
     * @param feedback 课程调查管理
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback)
    {
        return feedbackMapper.insertFeedback(feedback);
    }

    /**
     * 修改课程调查管理
     * 
     * @param feedback 课程调查管理
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback)
    {
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 批量删除课程调查管理
     * 
     * @param ids 需要删除的课程调查管理主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByIds(String ids)
    {
        return feedbackMapper.deleteFeedbackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程调查管理信息
     * 
     * @param id 课程调查管理主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackById(Long id)
    {
        return feedbackMapper.deleteFeedbackById(id);
    }
}
