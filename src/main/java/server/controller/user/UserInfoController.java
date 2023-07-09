package server.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Employee;
import server.model.FeedbackEmployee;
import server.model.Member;
import server.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private MemberService memberService;

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

