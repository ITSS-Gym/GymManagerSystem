package server.controller.user;

import server.pojo.*;
import server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private CourseOrderService courseOrderService;

    @Autowired
    private FeedbackEmployeeService feedbackEmployeeService;

    @Autowired
    private EmployeeService employeeService;


    // Jump to personal information page
    @RequestMapping("/toUserInfo")
    public String toUserInformation(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userInformation";
    }

    // Jump to modify personal information page
    @RequestMapping("/toUpdateInfo")
    public String toUpdateUserInformation(HttpSession session, Model model) {
        Member member1 = (Member) session.getAttribute("user");
        List<Member> member = memberService.selectByMemberAccount(member1.getMemberAccount());
        model.addAttribute("member", member.get(0));
        return "updateUserInformation";
    }

    // Modify Personal Information
    @RequestMapping("/updateInfo")
    public String updateUserInformation(HttpSession session, Member member) {
        Member member1 = (Member) session.getAttribute("user");

        member.setMemberAccount(member1.getMemberAccount());
        System.out.println(member);

        memberService.updateMemberByMemberAccount(member);
        return "userInformation";
    }

    // Jump to my course page
    @RequestMapping("/toUserCourse")
    public String toUserCourse(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<CourseOrder> courseOrderList = courseOrderService.selectCourseOrderByMemberAccount(memberAccount);
        model.addAttribute("courseOrderList", courseOrderList);
        return "userCourse";
    }

    // Quit course
    @RequestMapping("delUserCourse")
    public String deleteUserCourse(Integer courseOrderId) {
        courseOrderService.deleteByCourseOrderId(courseOrderId);
        return "redirect:toUserCourse";
    }

    // Jump to the registration page
    @RequestMapping("/toApplyCourse")
    public String toUserApplyCourse(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<Course> courseList = courseService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("courseList", courseList);

        String memberAccount = member.getMemberAccount();
        List<CourseOrder> courseOrderList = courseOrderService.selectCourseOrderByMemberAccount(memberAccount);
        List<Integer> courseOrderIdList = courseOrderList.stream().map(CourseOrder::getCourseId).collect(Collectors.toList());
        model.addAttribute("courseOrderIdList", courseOrderIdList);

        return "userApplyCourse";
    }

    // Sign up for courses
    @RequestMapping("/applyCourse")
    public String userApplyCourse(Integer courseId, Model model, HttpSession session) {
        Course course = courseService.selectByCourseId(courseId);
        Member member = (Member) session.getAttribute("user");

        Integer courseId1 = course.getCourseId();
        String courseName = course.getCourseName();
        Integer coachId = course.getCoachId();
        String coachName = course.getCoachName();
        String courseBegin = course.getCourseBegin();
        String memberName = member.getMemberName();
        String memberAccount = member.getMemberAccount();

        CourseOrder courseOrder = new CourseOrder(courseId1, courseName, coachId, coachName, memberAccount, memberName, courseBegin);
        String memberAccount1 = member.getMemberAccount();
        CourseOrder courseOrder1 = courseOrderService.selectMemberByCourseIdAndMemberAccount(courseId1, memberAccount1);

        if (courseOrder1 == null) {
            courseOrderService.insertCourseOrder(courseOrder);
        }

        return "redirect:toUserCourse";
    }

    // Jump to User Feedback Page
    @RequestMapping("/toUserFeedback")
    public String toUserFeedback(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<FeedbackEmployee> feedbackEmployeeList = feedbackEmployeeService.selectByMemberAccount(memberAccount);
        model.addAttribute("feedbackByAccountList", feedbackEmployeeList);
        return "userFeedback";
    }

    @RequestMapping("toAddFeedback")
    public String toAddFeedback(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "addFeedback";
    }

    @RequestMapping("addFeedback")
    public String addFeedback(FeedbackEmployee feedbackEmployee) {
        feedbackEmployeeService.insertFeedbackEmployee(feedbackEmployee);
        return "redirect:userFeedback";
    }

    @RequestMapping("/toUpdateFeedback")
    public String toUpdateUserFeedback(Integer feedbackId, Model model) {
        List<FeedbackEmployee> feedbackEmployeeList = feedbackEmployeeService.selectByFeedbackId(feedbackId);
        model.addAttribute("feedbackList", feedbackEmployeeList);
        return "updateUserFeedback";
    }

    // Modify Personal Information
    @RequestMapping("/updateFeedback")
    public String updateUserFeedback(FeedbackEmployee feedbackEmployee) {
        feedbackEmployeeService.updateByFeedbackId(feedbackEmployee);
        return "redirect:userFeedback";
    }

    @RequestMapping("delUserFeedback")
    public String deleteUserFeedback(Integer feedbackId) {
        feedbackEmployeeService.deleteByFeedbackId(feedbackId);
        return "redirect:toUserFeedback";
    }
}
