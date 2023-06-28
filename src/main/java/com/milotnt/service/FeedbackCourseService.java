package com.milotnt.service;

import com.milotnt.pojo.FeedbackCourse;

import java.util.List;

public interface FeedbackCourseService {

    List<FeedbackCourse> findAll();

    // Delete device by id
    Boolean deleteByFeedbackId(Integer feedbackId);

    // Add equipment
    Boolean insertFeedbackCourse(FeedbackCourse feedbackCourse);

    // Modify device information according to id
    Boolean updateByFeedbackId(FeedbackCourse feedbackCourse);

    // Query devices by id
    List<FeedbackCourse> selectByFeedbackId(Integer feedbackId);

    List<FeedbackCourse> selectByMemberAccount(String memberAccount);

    List<FeedbackCourse> selectByCourseId(Integer CourseId);
}
