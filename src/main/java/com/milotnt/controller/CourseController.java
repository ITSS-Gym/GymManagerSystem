package com.milotnt.controller;

import com.milotnt.pojo.CourseOrder;
import com.milotnt.pojo.Course;
import com.milotnt.service.CourseOrderService;
import com.milotnt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/class")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOrderService courseOrderService;

    // Inquire about courses
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "selectClass";
    }

    // Jump to the new course page
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    // New course
    @RequestMapping("/addClass")
    public String addClass(Course course) {
        courseService.insertCourse(course);
        return "redirect:selClass";
    }

    // Delete course
    @RequestMapping("/delClass")
    public String deleteClass(Integer courseId) {
        courseService.deleteCourseByCourseId(courseId);
        courseService.deleteOrderByCourseId(courseId);
        return "redirect:selClass";
    }

    // Query course registration information
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer courseId, Model model) {
        List<CourseOrder> courseOrderList = courseOrderService.selectMemberOrderList(courseId);
        model.addAttribute("courseOrderList", courseOrderList);
        return "selectClassOrder";
    }

    @RequestMapping("/updateAcceptClassOrder")
    public String updateAcceptClassOrder(Integer courseId, Integer courseOrderId, RedirectAttributes redirectAttributes) {
        courseOrderService.updateStatusByOrderId(courseOrderId);
        redirectAttributes.addAttribute("courseId", courseId);
        return "redirect:selClassOrder";
    }

    @RequestMapping("/delClassOrder")
    public String delClassOrder(Integer courseId, Integer courseOrderId, RedirectAttributes redirectAttributes) {
        courseOrderService.deleteOrderByOrderId(courseOrderId);
        redirectAttributes.addAttribute("courseId", courseId);
        return "redirect:selClassOrder";
    }

}
