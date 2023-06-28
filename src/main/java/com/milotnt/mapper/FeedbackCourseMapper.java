package com.milotnt.mapper;

import com.milotnt.pojo.FeedbackCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedbackCourseMapper {

    List<FeedbackCourse> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackCourse(FeedbackCourse feedbackCourse);

    Boolean updateByFeedbackId(FeedbackCourse feedbackCourse);

    List<FeedbackCourse> selectByFeedbackId(Integer feedbackId);

    List<FeedbackCourse> selectByMemberAccount(String memberAccount);

    List<FeedbackCourse> selectByCourseId(Integer courseId);
}
