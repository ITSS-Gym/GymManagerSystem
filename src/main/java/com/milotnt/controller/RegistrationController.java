package com.milotnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    private MemberController memberController;

    @RequestMapping("/toUserRegistration")
    public String toUserLogin() {
        return "userRegistration";
    }
}
