package server.controller.admin;

import server.pojo.CourseOrder;
import server.pojo.Course;
import server.service.CourseOrderService;
import server.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOrderService courseOrderService;

    // Inquire about courses
    @RequestMapping("/selCourse")
    public String selectCourse(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "selectCourse";
    }

    // Jump to the new course page
    @RequestMapping("/toAddCourse")
    public String toAddCourse() {
        return "addCourse";
    }

    // New course
    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
        courseService.insertCourse(course);
        return "redirect:selCourse";
    }

    // Delete course
    @RequestMapping("/delCourse")
    public String deleteClass(Integer courseId) {
        courseService.deleteCourseByCourseId(courseId);
        courseService.deleteOrderByCourseId(courseId);
        return "redirect:selCourse";
    }

    // Query course registration information
    @RequestMapping("/selCourseOrder")
    public String selectCourseOrder(Integer courseId, Model model) {
        List<CourseOrder> courseOrderList = courseOrderService.selectMemberOrderList(courseId);
        model.addAttribute("courseOrderList", courseOrderList);
        return "selectCourseOrder";
    }

    @RequestMapping("/updateAcceptCourseOrder")
    public String updateAcceptCourseOrder(Integer courseId, Integer courseOrderId, RedirectAttributes redirectAttributes) {
        courseOrderService.updateStatusByOrderId(courseOrderId);
        redirectAttributes.addAttribute("courseId", courseId);
        return "redirect:selCourseOrder";
    }

    @RequestMapping("/delCourseOrder")
    public String delClassOrder(Integer courseId, Integer courseOrderId, RedirectAttributes redirectAttributes) {
        courseOrderService.deleteOrderByOrderId(courseOrderId);
        redirectAttributes.addAttribute("courseId", courseId);
        return "redirect:selCourseOrder";
    }

}
