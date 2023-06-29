package server.mapper;

import server.pojo.FeedbackEquipment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedbackEquipmentMapper {

    List<FeedbackEquipment> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackEquipment(FeedbackEquipment feedbackEquipment);

    Boolean updateByFeedbackId(FeedbackEquipment feedbackEquipment);

    List<FeedbackEquipment> selectByFeedbackId(Integer feedbackId);

    List<FeedbackEquipment> selectByMemberAccount(String memberAccount);

    List<FeedbackEquipment> selectByEquipmentId(Integer EquipmentId);
}
