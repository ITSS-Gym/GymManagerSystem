package com.milotnt.mapper;

import com.milotnt.pojo.FeedbackCourse;
import com.milotnt.pojo.FeedbackEmployee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FeedbackCourseMapper {

    List<FeedbackCourse> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackCourse(FeedbackCourse feedbackCourse);

    Boolean updateByFeedbackId(FeedbackCourse feedbackCourse);

    List<FeedbackCourse> selectByFeedbackId(Integer feedbackId);

    List<FeedbackCourse> selectByMemberAccount(Integer memberAccount);

    List<FeedbackEmployee> selectByCourseId(Integer courseId);
}
