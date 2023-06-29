package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.FeedbackRoomMapper;
import server.pojo.FeedbackRoom;

import java.util.List;

@Service
public class FeedbackRoomService {

    @Autowired
    private FeedbackRoomMapper feedbackMapper;

    public List<FeedbackRoom> findAll() {
        return feedbackMapper.findAll();
    }

    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    public Boolean insertFeedbackRoom(FeedbackRoom feedbackRoom) {
        return feedbackMapper.insertFeedbackRoom(feedbackRoom);
    }

    public Boolean updateByFeedbackId(FeedbackRoom feedbackRoom) {
        return feedbackMapper.updateByFeedbackId(feedbackRoom);
    }

    public List<FeedbackRoom> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    public List<FeedbackRoom> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    public List<FeedbackRoom> selectByRoomId(Integer RoomAccount) {
        return feedbackMapper.selectByRoomId(RoomAccount);
    }
}