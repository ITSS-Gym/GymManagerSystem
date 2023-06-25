package com.milotnt.service.impl;

import com.milotnt.mapper.FeedbackMapper;
import com.milotnt.pojo.Feedback;
import com.milotnt.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> findAll() {
        return feedbackMapper.findAll();
    }

    @Override
    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    @Override
    public Boolean insertFeedback(Feedback feedback) {
        return feedbackMapper.insertFeedback(feedback);
    }

    @Override
    public Boolean updateFeedbackByFeedbackId(Feedback feedback) {
        return feedbackMapper.updateFeedbackByFeedbackId(feedback);
    }

    @Override
    public List<Feedback> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    @Override
    public List<Feedback> selectByMemberAccount(Integer memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    @Override
    public List<Feedback> selectByEmployeeAccount(Integer employeeAccount) {
        return feedbackMapper.selectByEmployeeAccount(employeeAccount);
    }
}
