package com.milotnt.service;

import com.milotnt.pojo.Course;

import java.util.List;

public interface CourseService {

    // Find all courses
    List<Course> findAll();

    // Delete class by id
    Boolean deleteCourseByCourseId(Integer classId);

    // Add course
    Boolean insertCourse(Course course);

    // update course
    Boolean updateCourseByCourseId(Course course);

    // Query the class schedule by id
    Course selectByCourseId(Integer classId);

    // Delete reserved courses according to id
    Boolean deleteOrderByCourseId(Integer classId);

}
