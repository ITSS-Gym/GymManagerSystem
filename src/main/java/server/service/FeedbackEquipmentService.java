package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.FeedbackEquipmentMapper;
import server.pojo.FeedbackEquipment;

import java.util.List;

@Service
public class FeedbackEquipmentService {

    @Autowired
    private FeedbackEquipmentMapper feedbackMapper;

    public List<FeedbackEquipment> findAll() {
        return feedbackMapper.findAll();
    }

    public Boolean deleteByFeedbackId(Integer equipmentId) {
        return feedbackMapper.deleteByFeedbackId(equipmentId);
    }

    public Boolean insertFeedbackEquipment(FeedbackEquipment feedbackEquipment) {
        return feedbackMapper.insertFeedbackEquipment(feedbackEquipment);
    }

    public Boolean updateByFeedbackId(FeedbackEquipment feedbackEquipment) {
        return feedbackMapper.updateByFeedbackId(feedbackEquipment);
    }

    public List<FeedbackEquipment> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    public List<FeedbackEquipment> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    public List<FeedbackEquipment> selectByEquipmentId(Integer EquipmentAccount) {
        return feedbackMapper.selectByEquipmentId(EquipmentAccount);
    }

}