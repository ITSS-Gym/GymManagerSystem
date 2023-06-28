package com.milotnt.service.impl;

import com.milotnt.mapper.FeedbackEquipmentMapper;
import com.milotnt.pojo.FeedbackEquipment;
import com.milotnt.service.FeedbackEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackEquipmentServiceImpl implements FeedbackEquipmentService {

    @Autowired
    private FeedbackEquipmentMapper feedbackMapper;

    @Override
    public List<FeedbackEquipment> findAll() {
        return feedbackMapper.findAll();
    }

    @Override
    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    @Override
    public Boolean insertFeedbackEquipment(FeedbackEquipment feedbackEquipment) {
        return feedbackMapper.insertFeedbackEquipment(feedbackEquipment);
    }

    @Override
    public Boolean updateByFeedbackId(FeedbackEquipment feedbackEquipment) {
        return feedbackMapper.updateByFeedbackId(feedbackEquipment);
    }

    @Override
    public List<FeedbackEquipment> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    @Override
    public List<FeedbackEquipment> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    @Override
    public List<FeedbackEquipment> selectByEquipmentId(Integer EquipmentAccount) {
        return feedbackMapper.selectByEquipmentId(EquipmentAccount);
    }
}