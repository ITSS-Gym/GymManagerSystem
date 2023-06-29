package server.service.impl;

import server.mapper.FeedbackCourseMapper;
import server.pojo.FeedbackCourse;
import server.service.FeedbackCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackCourseServiceImpl implements FeedbackCourseService {

    @Autowired
    private FeedbackCourseMapper feedbackMapper;

    @Override
    public List<FeedbackCourse> findAll() {
        return feedbackMapper.findAll();
    }

    @Override
    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    @Override
    public Boolean insertFeedbackCourse(FeedbackCourse feedbackCourse) {
        return feedbackMapper.insertFeedbackCourse(feedbackCourse);
    }

    @Override
    public Boolean updateByFeedbackId(FeedbackCourse feedbackCourse) {
        return feedbackMapper.updateByFeedbackId(feedbackCourse);
    }

    @Override
    public List<FeedbackCourse> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    @Override
    public List<FeedbackCourse> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    @Override
    public List<FeedbackCourse> selectByCourseId(Integer CourseAccount) {
        return feedbackMapper.selectByCourseId(CourseAccount);
    }
}