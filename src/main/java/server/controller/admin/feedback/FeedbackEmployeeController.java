package server.controller.admin.feedback;

import server.pojo.FeedbackEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.service.EmployeeService;
import server.service.FeedbackEmployeeService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackEmployeeController {

    @Autowired
    private FeedbackEmployeeService feedbackEmployeeService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/selFeedbackEmployee")
    public String selectFeedbackEmployee(Model model) {
        List<FeedbackEmployee> feedbackEmployeeList = feedbackEmployeeService.findAll();
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "selectFeedbackEmployee";
    }

    // Jump to the new course page
    @RequestMapping("/toViewFeedbackEmployee")
    public String toViewFeedbackEmployee(String employeeAccount, Model model) {
        List<FeedbackEmployee> feedbackEmployeeList = feedbackEmployeeService.selectByEmployeeAccount(employeeAccount);
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "selectFeedbackEmployee";
    }
}
