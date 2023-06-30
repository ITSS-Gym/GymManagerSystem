package server.controller;

import server.pojo.Admin;
import server.pojo.Member;
import server.service.AdminService;
import server.service.EmployeeService;
import server.service.EquipmentService;
import server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;

    // Home-page, jump to administrator login page
    @RequestMapping("/")
    public String toAdminLogin() {
        return "userLogin";
    }

    // Jump to member login page
    @RequestMapping("/toAdminLogin")
    public String toUserLogin() {
        return "adminLogin";
    }

    // admin login 
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            // number of members
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            // Number of employees
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            // Total number of people
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            // Number of equipment
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
        }
        model.addAttribute("msg", "The account or password you entered is wrong, please re-enter！");
        return "adminLogin";
    }

    // User Login
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "The account or password you entered is wrong, please re-enter!");
        return "userLogin";
    }

    @RequestMapping("/toUserRegistration")
    public String toUserRegistration() {
        return "userRegistration";
    }

    @RequestMapping("/userRegistration")
    public String userRegistration(Member member, Model model, HttpSession session) {
        List<Member> memberList = memberService.selectByMemberAccount(member.getMemberAccount());
        if (memberList.isEmpty()) {
            memberService.insertMember(member);
            model.addAttribute("member", member);
            model.addAttribute("msg", "Register successfully!");
            session.setAttribute("user", member);
            return "userMain";
        }
        else {
            model.addAttribute("msg", "Duplicate account! Please change your Account!");
            return "userRegistration";
        }
    }

    // Jump to admin home page
    @RequestMapping("/toAdminMain")
    public String toAdminMain(Model model, HttpSession session) {
        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
        model.addAttribute("memberTotal", memberTotal);
        model.addAttribute("employeeTotal", employeeTotal);
        model.addAttribute("humanTotal", humanTotal);
        model.addAttribute("equipmentTotal", equipmentTotal);
        return "adminMain";
    }

    // Jump to member home page
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "userLogin";
    }

}
