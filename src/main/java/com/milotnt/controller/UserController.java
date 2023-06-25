package com.milotnt.controller;

import com.milotnt.pojo.*;
import com.milotnt.service.*;
import com.milotnt.pojo.FeedbackByAccount;
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
    private ClassTableService classTableService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ClassOrderService classOrderService;

    @Autowired
    private FeedbackService feedbackService;

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
        List<ClassOrder> classOrderList = classOrderService.selectClassOrderByMemberAccount(memberAccount);
        model.addAttribute("classOrderList", classOrderList);
        return "userClass";
    }

    // Quit class
    @RequestMapping("delUserClass")
    public String deleteUserClass(Integer classOrderId) {
        classOrderService.deleteByClassOrderId(classOrderId);
        return "redirect:toUserClass";
    }

    // Jump to the registration page
    @RequestMapping("/toApplyClass")
    public String toUserApplyClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("classList", classList);

        Integer memberAccount = member.getMemberAccount();
        List<ClassOrder> classOrderList = classOrderService.selectClassOrderByMemberAccount(memberAccount);
        List<Integer> classOrderIdList = classOrderList.stream().map(ClassOrder::getClassId).collect(Collectors.toList());
        model.addAttribute("classOrderIdList", classOrderIdList);

        return "userApplyClass";
    }

    // Sign up for courses
    @RequestMapping("/applyClass")
    public String userApplyClass(Integer classId, Model model, HttpSession session) {
        ClassTable classTable = classTableService.selectByClassId(classId);
        Member member = (Member) session.getAttribute("user");

        Integer classId1 = classTable.getClassId();
        String className = classTable.getClassName();
        String coach = classTable.getCoach();
        String classBegin = classTable.getClassBegin();
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();

        ClassOrder classOrder = new ClassOrder(classId1, className, coach, memberName, memberAccount, classBegin);
        Integer memberAccount1 = member.getMemberAccount();
        ClassOrder classOrder1 = classOrderService.selectMemberByClassIdAndMemberAccount(classId1, memberAccount1);

        if (classOrder1 == null) {
            classOrderService.insertClassOrder(classOrder);
        }

        return "redirect:toUserClass";
    }

    // Jump to User Feedback Page
    @RequestMapping("/toUserFeedback")
    public String toUserFeedback(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        Integer memberAccount = member.getMemberAccount();
        List<FeedbackByAccount> feedbackByAccountList = feedbackService.selectByMemberAccount(memberAccount);
        model.addAttribute("feedbackByAccountList", feedbackByAccountList);
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
    public String addFeedback(Feedback feedback) {
        feedbackService.insertFeedback(feedback);
        return "redirect:userFeedback";
    }

    @RequestMapping("/toUpdateFeedback")
    public String toUpdateUserFeedback(Integer feedbackId, Model model) {
        List<Feedback> feedbackList = feedbackService.selectByFeedbackId(feedbackId);
        model.addAttribute("feedbackList", feedbackList);
        return "updateUserFeedback";
    }

    // Modify Personal Information
    @RequestMapping("/updateFeedback")
    public String updateUserFeedback(Feedback feedback) {
        feedbackService.updateFeedbackByFeedbackId(feedback);
        return "redirect:userFeedback";
    }

    @RequestMapping("delUserFeedback")
    public String deleteUserFeedback(Integer feedbackId) {
        feedbackService.deleteByFeedbackId(feedbackId);
        return "redirect:toUserFeedback";
    }
}
