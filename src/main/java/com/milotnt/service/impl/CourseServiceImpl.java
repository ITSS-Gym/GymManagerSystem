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
    public Boolean deleteCourseByCourseId(Integer classId) {
        return courseMapper.deleteCourseByCourseId(classId);
    }

    @Override
    public Boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public Boolean updateCourseByCourseId(Course course) { return  courseMapper.updateCourseByCourseId(course); }

    @Override
    public Course selectByCourseId(Integer classId) {
        return courseMapper.selectByCourseId(classId);
    }

    @Override
    public Boolean deleteOrderByCourseId(Integer classId) {
        return courseMapper.deleteOrderByCourseId(classId);
    }
}
