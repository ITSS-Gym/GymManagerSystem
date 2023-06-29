package server.service;

import server.pojo.CourseOrder;

import java.util.List;

/**
 * @author MiloTnT [milotntspace@gmail.com]
 * @date 2021/8/11
 */

public interface CourseOrderService {

    // Query all registration form information
    List<CourseOrder> findAll();

    // Add registration information
    Boolean insertCourseOrder(CourseOrder courseOrder);

    // Query the personal registration schedule according to the member account
    List<CourseOrder> selectCourseOrderByMemberAccount(String memberAccount);

    // Delete a reserved course
    Boolean deleteByCourseOrderId(Integer courseOrderId);

    // Check if the member is enrolled in the course
    CourseOrder selectMemberByCourseIdAndMemberAccount(Integer courseId, String memberAccount);

    // Query all registered members according to the course id
    List<CourseOrder> selectMemberOrderList(Integer courseId);

    Boolean updateStatusByOrderId(Integer courseOrderId);

    Boolean deleteOrderByOrderId(Integer courseOrderId);

}
