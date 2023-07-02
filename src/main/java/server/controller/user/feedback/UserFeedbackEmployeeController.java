package server.controller.user.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.pojo.Employee;
import server.pojo.FeedbackEmployee;
import server.pojo.Member;
import server.service.EmployeeService;
import server.service.FeedbackEmployeeService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserFeedbackEmployeeController {
    @Autowired
    private FeedbackEmployeeService feedbackEmployeeService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/userFeedbackEmployee")
    public String userFeedbackEmployee(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<FeedbackEmployee> feedbackEmployeeList = feedbackEmployeeService.selectByMemberAccount(memberAccount);
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "userFeedbackEmployee";
    }

    @RequestMapping("/toAddFeedbackEmployee")
    public String toAddEmployee(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "addFeedbackEmployee";
    }

    @RequestMapping("/addFeedbackEmployee")
    public String addFeedbackEmployee(FeedbackEmployee feedbackEmployee, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        feedbackEmployee.setMemberAccount(member.getMemberAccount());
        feedbackEmployeeService.insertFeedbackEmployee(feedbackEmployee);
        return "redirect:userFeedbackEmployee";
    }

    // Jump to the new course page
    @RequestMapping("/delFeedbackEmployee")
    public String deleteFeedbackEmployee(Integer feedbackId) {
        feedbackEmployeeService.deleteByFeedbackId(feedbackId);
        return "redirect:userFeedbackEmployee";
    }

    @RequestMapping("/toUpdateFeedbackEmployee")
    public String toUpdateFeedbackEmployee(Integer feedbackId, Model model) {
        List<FeedbackEmployee> feedbackEmployeeList = feedbackEmployeeService.selectByFeedbackId(feedbackId);
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "updateFeedbackEmployee";
    }
    @RequestMapping("/updateFeedbackEmployee")
    public String updateFeedbackEmployee(FeedbackEmployee feedbackEmployee) {
        feedbackEmployeeService.updateByFeedbackId(feedbackEmployee);
        return "redirect:userFeedbackEmployee";
    }
}