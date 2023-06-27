package com.milotnt.service;

import com.milotnt.pojo.FeedbackRoom;

import java.util.List;

public interface FeedbackRoomService {

    List<FeedbackRoom> findAll();

    // Delete device by id
    Boolean deleteByFeedbackId(Integer feedbackId);

    // Add Room
    Boolean insertFeedbackRoom(FeedbackRoom feedbackRoom);

    // Modify device information according to id
    Boolean updateByFeedbackId(FeedbackRoom feedbackRoom);

    // Query devices by id
    List<FeedbackRoom> selectByFeedbackId(Integer feedbackId);

    List<FeedbackRoom> selectByMemberAccount(Integer memberAccount);

    List<FeedbackRoom> selectByRoomId(Integer RoomId);
}