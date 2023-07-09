package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.CourseMapper;
import server.model.Course;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    public Boolean deleteCourseByCourseId(Integer courseId) {
        return courseMapper.deleteCourseByCourseId(courseId);
    }

    public Boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    public Boolean updateCourseByCourseId(Course course) { return  courseMapper.updateCourseByCourseId(course); }

    public Course selectByCourseId(Integer courseId) {
        return courseMapper.selectByCourseId(courseId);
    }

    public Boolean deleteOrderByCourseId(Integer courseId) {
        return courseMapper.deleteOrderByCourseId(courseId);
    }
}
