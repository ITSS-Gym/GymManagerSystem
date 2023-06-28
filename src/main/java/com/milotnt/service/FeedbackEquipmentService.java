package com.milotnt.service;

import com.milotnt.pojo.FeedbackEquipment;

import java.util.List;

public interface FeedbackEquipmentService {

    List<FeedbackEquipment> findAll();

    // Delete device by id
    Boolean deleteByFeedbackId(Integer feedbackId);

    // Add equipment
    Boolean insertFeedbackEquipment(FeedbackEquipment feedbackEquipment);

    // Modify device information according to id
    Boolean updateByFeedbackId(FeedbackEquipment feedbackEquipment);

    // Query devices by id
    List<FeedbackEquipment> selectByFeedbackId(Integer feedbackId);

    List<FeedbackEquipment> selectByMemberAccount(String memberAccount);

    List<FeedbackEquipment> selectByEquipmentId(Integer EquipmentId);
}