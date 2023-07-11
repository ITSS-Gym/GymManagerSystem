package server.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Course;
import server.model.CourseOrder;
import server.model.Employee;
import server.model.Feedback;
import server.service.CourseOrderService;
import server.service.CourseService;
import server.service.EmployeeService;
import server.service.FeedbackCourseService;

import javax.servlet.http.HttpSession;

import java.util.List;
@Controller
@RequestMapping("/staff")
public class EmployeeCourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FeedbackCourseService feedbackCourseService;

    @Autowired
    private CourseOrderService courseOrderService;

    @RequestMapping("/myCourse")
    public String myCourse(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employee", employee);
        Integer employeeId = employee.getEmployeeId();
        List<Course> courseList = courseService.selectByEmployeeId(employeeId);
        model.addAttribute("courseList", courseList);
        return "employee/selectCourse";
    }

    @RequestMapping("/myRequestedCourse")
    public String myRequestedCourse(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employee", employee);
        Integer employeeId = employee.getEmployeeId();
        List<Course> courseList = courseService.selectByEmployeeId(employeeId);
        model.addAttribute("courseList", courseList);
        return "employee/selectRequestedCourse";
    }

    @RequestMapping("/toSuggestCourse")
    public String toSuggestCourse() {
        return "employee/suggestCourse";
    }

    @RequestMapping("/suggestCourse")
    public String suggestCourse(Course course, Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Integer employeeId = employee.getEmployeeId();
        course.setCoachId(employeeId);
        course.setStatus("waiting");
        courseService.insertCourse(course);
        return "redirect:myCourse";
    }

    // See list of student registered the course
    @RequestMapping("/selCourseOrder")
    public String selectCourseOrder(Integer courseId, Model model) {
        List<CourseOrder> courseOrderList = courseOrderService.selectMemberOrderList(courseId);
        model.addAttribute("courseOrderList", courseOrderList);
        return "employee/selectCourseOrder";
    }

    // See list of feedback for course
    @RequestMapping("/selFeedbackCourse")
    public String selectFeedbackCourse(Integer courseId, Model model) {
        List<Feedback> feedbackCourseList = feedbackCourseService.selectByCourseId(courseId);
        model.addAttribute("feedbackCourseList", feedbackCourseList);
        return "employee/selectFeedbackCourse";
    }



}
