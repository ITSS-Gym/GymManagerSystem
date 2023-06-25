package com.milotnt.service;

import com.milotnt.pojo.Equipment;
import com.milotnt.pojo.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> findAll();

    //根据 id 删除器械
    Boolean deleteByFeedbackId(Integer feedbackId);

    //添加器材
    Boolean insertFeedback(Feedback feedback);

    //根据 id 修改器械信息
    Boolean updateFeedbackByFeedbackId(Feedback feedback);

    //根据 id 查询器械
    List<Feedback> selectByFeedbackId(Integer feedbackId);
}
