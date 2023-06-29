package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.FeedbackEmployeeMapper;
import server.pojo.FeedbackEmployee;

import java.util.List;

@Service
public class FeedbackEmployeeService {

    @Autowired
    private FeedbackEmployeeMapper feedbackMapper;

    public List<FeedbackEmployee> findAll() {
        return feedbackMapper.findAll();
    }

    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    public Boolean insertFeedbackEmployee(FeedbackEmployee feedbackEmployee) {
        return feedbackMapper.insertFeedbackEmployee(feedbackEmployee);
    }

    public Boolean updateByFeedbackId(FeedbackEmployee feedbackEmployee) {
        return feedbackMapper.updateByFeedbackId(feedbackEmployee);
    }

    public List<FeedbackEmployee> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    public List<FeedbackEmployee> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    public List<FeedbackEmployee> selectByEmployeeId(Integer employeeId) {
        return feedbackMapper.selectByEmployeeId(employeeId);
    }
}
