package com.milotnt.controller;

import com.milotnt.pojo.FeedbackEmployee;
import com.milotnt.service.FeedbackEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackEmployeeService feedbackemployeeService;

    // Query employees
    @RequestMapping("/selFeedbackEmployee")
    public String selectFeedbackEmployee(Model model) {
        List<FeedbackEmployee> feedbackemployeeList = feedbackemployeeService.findAll();
        model.addAttribute("feedbackemployeeList", feedbackemployeeList);
        return "selectFeedbackEmployee";
    }

    // Jump to the new employee page
    @RequestMapping("/toAddFeedbackEmployee")
    public String toAddFeedbackEmployee() {
        return "addFeedbackEmployee";
    }

    // New employee
    @RequestMapping("/addFeedbackEmployee")
    public String addFeedbackEmployee(FeedbackEmployee feedbackemployee) {
        //The job number is randomly generated
        Random random = new Random();
        String account1 = "1010";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        //get current date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        feedbackemployee.setEmployeeAccount(account);
        //feedbackemployee.setEntryTime(nowDay);

        feedbackemployeeService.insertFeedbackEmployee(feedbackemployee);

        return "redirect:selFeedbackEmployee";

    }

    //delete employee
    @RequestMapping("/delFeedbackEmployee")
    public String delFeedbackEmployee(Integer feedbackID) {
        feedbackemployeeService.deleteByFeedbackId(feedbackID);
        return "redirect:selFeedbackEmployee";
    }

    //Jump to the employee modification page
//    @RequestMapping("/toUpdateEmployee")
//    public String toUpdateEmployee(Integer employeeAccount, Model model) {
//        List<Employee> employeeList = employeeService.selectByEmployeeAccount(employeeAccount);
//        model.addAttribute("employeeList", employeeList);
//        return "updateEmployee";
//    }
//
//    //Modify employee information
//    @RequestMapping("/updateEmployee")
//    public String updateEmployee(Employee employee) {
//        employeeService.updateMemberByEmployeeAccount(employee);
//        return "redirect:selEmployee";
//    }
//    @RequestMapping("selFeedbackCourse")
//    public String selectFeedbackCourse(Model model) {
//        List<FeedbackCourse> feedbackcourseList = feedbackcourseService.findAll();
//        model.addAttribute("feedbackcourseList", feedbackcourseList);
//        return "selectFeebackCourse";
//    }
}

