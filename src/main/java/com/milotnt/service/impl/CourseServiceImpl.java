package com.milotnt.service.impl;

import com.milotnt.mapper.CourseMapper;
import com.milotnt.pojo.Course;
import com.milotnt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public Boolean deleteCourseByCourseId(Integer courseId) {
        return courseMapper.deleteCourseByCourseId(courseId);
    }

    @Override
    public Boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public Boolean updateCourseByCourseId(Course course) { return  courseMapper.updateCourseByCourseId(course); }

    @Override
    public Course selectByCourseId(Integer courseId) {
        return courseMapper.selectByCourseId(courseId);
    }

    @Override
    public Boolean deleteOrderByCourseId(Integer courseId) {
        return courseMapper.deleteOrderByCourseId(courseId);
    }
}
