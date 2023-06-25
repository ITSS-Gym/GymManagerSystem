package com.milotnt.service;

import com.milotnt.pojo.Equipment;
import com.milotnt.pojo.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> findAll();

    // Delete device by id
    Boolean deleteByFeedbackId(Integer feedbackId);

    // Add equipment
    Boolean insertFeedback(Feedback feedback);

    // Modify device information according to id
    Boolean updateFeedbackByFeedbackId(Feedback feedback);

    // Query devices by id
    List<Feedback> selectByFeedbackId(Integer feedbackId);
}
