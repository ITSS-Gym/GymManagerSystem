package com.milotnt.mapper;

import com.milotnt.pojo.Feedback;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface FeedbackMapper {

    List<Feedback> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedback(Feedback feedback);

    Boolean updateFeedbackByFeedbackId(Feedback feedback);

    List<Feedback> selectByFeedbackId(Integer feedbackId);
}
