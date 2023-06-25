package com.milotnt.controller;

import com.milotnt.pojo.ClassOrder;
import com.milotnt.pojo.ClassTable;
import com.milotnt.service.ClassOrderService;
import com.milotnt.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    // Inquire about courses
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("classList", classList);
        return "selectClass";
    }

    // Jump to the new course page
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    // New course
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable) {
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    // Delete course
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        classTableService.deleteClassByClassId(classId);
        classTableService.deleteOrderByClassId(classId);
        return "redirect:selClass";
    }

    // Query course registration information
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }

    @RequestMapping("/updateAcceptClassOrder")
    public String updateAcceptClassOrder(Integer classId, Integer classOrderId, RedirectAttributes redirectAttributes) {
        classOrderService.updateStatusByOrderId(classOrderId);
        redirectAttributes.addAttribute("classId", classId);
        return "redirect:selClassOrder";
    }

    @RequestMapping("/delClassOrder")
    public String delClassOrder(Integer classId, Integer classOrderId, RedirectAttributes redirectAttributes) {
        classOrderService.deleteOrderByOrderId(classOrderId);
        redirectAttributes.addAttribute("classId", classId);
        return "redirect:selClassOrder";
    }

}
