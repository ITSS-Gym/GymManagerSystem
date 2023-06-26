package com.milotnt.service;

import com.milotnt.pojo.FeedbackEmployee;
import com.milotnt.pojo.FeedbackEmployeeWithName;

import java.util.List;

public interface FeedbackEmployeeService {

    List<FeedbackEmployee> findAll();

    // Delete device by id
    Boolean deleteByFeedbackId(Integer feedbackId);

    // Add equipment
    Boolean insertFeedbackEmployee(FeedbackEmployee feedbackEmployee);

    // Modify device information according to id
    Boolean updateByFeedbackId(FeedbackEmployee feedbackEmployee);

    // Query devices by id
    List<FeedbackEmployee> selectByFeedbackId(Integer feedbackId);

    List<FeedbackEmployee> selectByMemberAccount(Integer memberAccount);

    List<FeedbackEmployee> selectByEmployeeAccount(Integer employeeAccount);
}
