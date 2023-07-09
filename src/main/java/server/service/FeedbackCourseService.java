package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.FeedbackCourseMapper;
import server.model.FeedbackCourse;

import java.util.List;

@Service
public class FeedbackCourseService {

    @Autowired
    private FeedbackCourseMapper feedbackMapper;

    
    public List<FeedbackCourse> findAll() {
        return feedbackMapper.findAll();
    }

    
    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    
    public Boolean insertFeedbackCourse(FeedbackCourse feedbackCourse) {
        return feedbackMapper.insertFeedbackCourse(feedbackCourse);
    }

    
    public Boolean updateByFeedbackId(FeedbackCourse feedbackCourse) {
        return feedbackMapper.updateByFeedbackId(feedbackCourse);
    }

    
    public List<FeedbackCourse> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    
    public List<FeedbackCourse> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    
    public List<FeedbackCourse> selectByCourseId(Integer courseId) {
        return feedbackMapper.selectByCourseId(courseId);
    }
}
