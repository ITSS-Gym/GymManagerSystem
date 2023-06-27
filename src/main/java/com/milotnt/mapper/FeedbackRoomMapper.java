package com.milotnt.mapper;

import com.milotnt.pojo.FeedbackRoom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedbackRoomMapper {

    List<FeedbackRoom> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackRoom(FeedbackRoom feedbackRoom);

    Boolean updateByFeedbackId(FeedbackRoom feedbackRoom);

    List<FeedbackRoom> selectByFeedbackId(Integer feedbackId);

    List<FeedbackRoom> selectByMemberAccount(Integer memberAccount);

    List<FeedbackRoom> selectByRoomId(Integer RoomId);
}
