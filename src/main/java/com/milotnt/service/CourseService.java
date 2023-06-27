package com.milotnt.service;

import com.milotnt.pojo.Course;

import java.util.List;

public interface CourseService {

    // Find all courses
    List<Course> findAll();

    // Delete course by id
    Boolean deleteCourseByCourseId(Integer courseId);

    // Add course
    Boolean insertCourse(Course course);

    // update course
    Boolean updateCourseByCourseId(Course course);

    // Query the class schedule by id
    Course selectByCourseId(Integer courseId);

    // Delete reserved courses according to id
    Boolean deleteOrderByCourseId(Integer courseId);

}
