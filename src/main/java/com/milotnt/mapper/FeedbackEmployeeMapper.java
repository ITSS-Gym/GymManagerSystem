package com.milotnt.mapper;

import com.milotnt.pojo.FeedbackEmployee;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface FeedbackEmployeeMapper {

    List<FeedbackEmployee> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackEmployee(FeedbackEmployee feedbackEmployee);

    Boolean updateByFeedbackId(FeedbackEmployee feedbackEmployee);

    List<FeedbackEmployee> selectByFeedbackId(Integer feedbackId);


    List<FeedbackEmployee> selectByMemberAccount(Integer memberAccount);

    List<FeedbackEmployee> selectByEmployeeAccount(Integer employeeAccount);

    List<FeedbackEmployee> selectByContent(String content);

    List<FeedbackEmployee> selectByTimeCreate(Timestamp timeCreated);
}
