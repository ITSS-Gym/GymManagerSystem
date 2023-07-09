package server.mapper;

import server.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    // Find all courses
    List<Course> findAll();

    // delete class by id
    Boolean deleteCourseByCourseId(Integer courseId);

    // add course
    Boolean insertCourse(Course course);

    // update course
    Boolean updateCourseByCourseId(Course course);

    // Query the class schedule by id
    Course selectByCourseId(Integer courseId);

    // Delete reserved courses according to id
    Boolean deleteOrderByCourseId(Integer courseId);

}
