package server.controller.admin;

import server.model.CourseOrder;
import server.model.Course;
import server.model.Employee;
import server.service.CourseOrderService;
import server.service.CourseService;
import server.service.EmployeeService;
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

    @Autowired
    private EmployeeService employeeService;

    // Inquire about courses
    @RequestMapping("/selCourse")
    public String selectCourse(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "admin/selectCourse";
    }

    // Jump to the new course page
    @RequestMapping("/toAddCourse")
    public String toAddCourse(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "admin/addCourse";
    }

    // New course
    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
        course.setStatus("accepted");
        courseService.insertCourse(course);
        return "redirect:selCourse";
    }

    // Delete course
    @RequestMapping("/delCourse")
    public String deleteCourse(Integer courseId) {
//        courseService.deleteOrderByCourseId(courseId);
        courseService.deleteCourseByCourseId(courseId);
        return "redirect:selCourse";
    }

    @RequestMapping("/acceptCourse")
    public String acceptCourse(Integer courseId) {
        courseService.acceptCourseByCourseId(courseId);
        return "redirect:selCourse";
    }

    // Query course registration information
    @RequestMapping("/selCourseOrder")
    public String selectCourseOrder(Integer courseId, Model model) {
        List<CourseOrder> courseOrderList = courseOrderService.selectMemberOrderList(courseId);
        model.addAttribute("courseOrderList", courseOrderList);
        return "admin/selectCourseOrder";
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
