package com.milotnt.service.impl;

import com.milotnt.mapper.FeedbackEmployeeMapper;
import com.milotnt.pojo.FeedbackEmployee;
import com.milotnt.pojo.FeedbackEmployeeWithName;
import com.milotnt.service.FeedbackEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackEmployeeServiceImpl implements FeedbackEmployeeService {

    @Autowired
    private FeedbackEmployeeMapper feedbackMapper;

    @Override
    public List<FeedbackEmployee> findAll() {
        return feedbackMapper.findAll();
    }

    @Override
    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    @Override
    public Boolean insertFeedbackEmployee(FeedbackEmployee feedbackEmployee) {
        return feedbackMapper.insertFeedbackEmployee(feedbackEmployee);
    }

    @Override
    public Boolean updateByFeedbackId(FeedbackEmployee feedbackEmployee) {
        return feedbackMapper.updateByFeedbackId(feedbackEmployee);
    }

    @Override
    public List<FeedbackEmployee> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    @Override
    public List<FeedbackEmployee> selectByMemberAccount(Integer memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    @Override
    public List<FeedbackEmployee> selectByEmployeeAccount(Integer employeeAccount) {
        return feedbackMapper.selectByEmployeeAccount(employeeAccount);
    }
}
