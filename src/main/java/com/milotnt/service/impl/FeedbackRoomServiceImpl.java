package com.milotnt.service.impl;

import com.milotnt.mapper.FeedbackRoomMapper;
import com.milotnt.pojo.FeedbackRoom;
import com.milotnt.service.FeedbackRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackRoomServiceImpl implements FeedbackRoomService {

    @Autowired
    private FeedbackRoomMapper feedbackMapper;

    @Override
    public List<FeedbackRoom> findAll() {
        return feedbackMapper.findAll();
    }

    @Override
    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    @Override
    public Boolean insertFeedbackRoom(FeedbackRoom feedbackRoom) {
        return feedbackMapper.insertFeedbackRoom(feedbackRoom);
    }

    @Override
    public Boolean updateByFeedbackId(FeedbackRoom feedbackRoom) {
        return feedbackMapper.updateByFeedbackId(feedbackRoom);
    }

    @Override
    public List<FeedbackRoom> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    @Override
    public List<FeedbackRoom> selectByMemberAccount(Integer memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    @Override
    public List<FeedbackRoom> selectByRoomId(Integer RoomAccount) {
        return feedbackMapper.selectByRoomId(RoomAccount);
    }
}
