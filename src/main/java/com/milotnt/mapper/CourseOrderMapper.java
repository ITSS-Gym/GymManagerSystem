package com.milotnt.mapper;

import com.milotnt.pojo.CourseOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseOrderMapper {

    // Query all registration form information
    List<CourseOrder> findAll();

    // Add registration information
    Boolean insertCourseOrder(CourseOrder courseOrder);

    // Query the personal registration schedule according to the member account
    List<CourseOrder> selectCourseOrderByMemberAccount(Integer memberAccount);

    // Delete a reserved class
    Boolean deleteByCourseOrderId(Integer classOrderId);

    // Check if the member is enrolled in the course
    CourseOrder selectMemberByCourseIdAndMemberAccount(Integer classId, Integer memberAccount);

    // Query all registered members according to the course id
    List<CourseOrder> selectMemberOrderList(Integer classId);

    Boolean updateStatusByOrderId(Integer classOrderId);

    Boolean deleteOrderByOrderId(Integer classOrderId);
}
