package com.milotnt.controller;

import com.milotnt.pojo.*;
import com.milotnt.service.*;
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
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "updateUserInformation";
    }

    // Modify Personal Information
    @RequestMapping("/updateInfo")
    public String updateUserInformation(HttpSession session, Member member) {
        Member member1 = (Member) session.getAttribute("user");

        member.setMemberAccount(member1.getMemberAccount());
        member.setCardClass(member1.getCardClass());
        member.setCardTime(member1.getCardTime());
        member.setCardNextClass(member1.getCardNextClass());

        memberService.updateMemberByMemberAccount(member);
        return "userInformation";
    }

    // Jump to my course page
    @RequestMapping("/toUserClass")
    public String toUserClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        Integer memberAccount = member.getMemberAccount();
        List<CourseOrder> courseOrderList = courseOrderService.selectCourseOrderByMemberAccount(memberAccount);
        model.addAttribute("classOrderList", courseOrderList);
        return "userClass";
    }

    // Quit class
    @RequestMapping("delUserClass")
    public String deleteUserClass(Integer classOrderId) {
        courseOrderService.deleteByCourseOrderId(classOrderId);
        return "redirect:toUserClass";
    }

    // Jump to the registration page
    @RequestMapping("/toApplyClass")
    public String toUserApplyClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<Course> classList = courseService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("classList", classList);

        Integer memberAccount = member.getMemberAccount();
        List<CourseOrder> courseOrderList = courseOrderService.selectCourseOrderByMemberAccount(memberAccount);
        List<Integer> classOrderIdList = courseOrderList.stream().map(CourseOrder::getClassId).collect(Collectors.toList());
        model.addAttribute("classOrderIdList", classOrderIdList);

        return "userApplyClass";
    }

    // Sign up for courses
    @RequestMapping("/applyClass")
    public String userApplyClass(Integer classId, Model model, HttpSession session) {
        Course course = courseService.selectByCourseId(classId);
        Member member = (Member) session.getAttribute("user");

        Integer classId1 = course.getCourseId();
        String className = course.getCourseName();
        String coach = course.getCoach();
        String classBegin = course.getCourseBegin();
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();

        CourseOrder courseOrder = new CourseOrder(classId1, className, coach, memberName, memberAccount, classBegin);
        Integer memberAccount1 = member.getMemberAccount();
        CourseOrder courseOrder1 = courseOrderService.selectMemberByCourseIdAndMemberAccount(classId1, memberAccount1);

        if (courseOrder1 == null) {
            courseOrderService.insertCourseOrder(courseOrder);
        }

        return "redirect:toUserClass";
    }

    // Jump to User Feedback Page
    @RequestMapping("/toUserFeedback")
    public String toUserFeedback(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        Integer memberAccount = member.getMemberAccount();
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
