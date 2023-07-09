package server.mapper;

import server.model.FeedbackEmployee;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FeedbackEmployeeMapper {

    List<FeedbackEmployee> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackEmployee(FeedbackEmployee feedbackEmployee);

    Boolean updateByFeedbackId(FeedbackEmployee feedbackEmployee);

    List<FeedbackEmployee> selectByFeedbackId(Integer feedbackId);

    List<FeedbackEmployee> selectByMemberAccount(String memberAccount);

    List<FeedbackEmployee> selectByEmployeeId(Integer employeeId);
}
