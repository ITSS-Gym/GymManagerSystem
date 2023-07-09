package server.controller.admin;

import server.model.Member;
import server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Query members
    @RequestMapping("/selMember")
    public String selectMember(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "selectMember";
    }

    // Jump to the new member page
    @RequestMapping("/toAddMember")
    public String toAddMember() {
        return "addMember";
    }

    // Add new member
    @RequestMapping("/addMember")
    public String addMember(Member member) {
        // Member account randomly generated
        Random random = new Random();
        StringBuilder thisYear = new StringBuilder(new SimpleDateFormat("yyyy").format(new Date()));
        for (int i = 0; i < 5; i++) {
            thisYear.append(random.nextInt(10));
        }
        Integer account = Integer.parseInt(thisYear.toString());

//        member.setMemberAccount(account);
        memberService.insertMember(member);

        return "redirect:selMember";

    }

    // delete member
    @RequestMapping("/delMember")
    public String deleteMember(String memberAccount) {
        memberService.deleteByMemberAccount(memberAccount);
        return "redirect:selMember";
    }

    // Jump to member modification page
    @RequestMapping("/toUpdateMember")
    public String toUpdateMember(String memberAccount, Model model) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberList", memberList);
        return "updateMember";
    }

    // Modify member information
    @RequestMapping("/updateMember")
    public String updateMember(Member member) {
        memberService.updateMemberByMemberAccount(member);
        return "redirect:selMember";
    }


    // Modify member information
    @RequestMapping("/toSelByCard")
    public String toSelectByCardId() {
        return "selectByMemberAccount";
    }

    // Query by membership card number
    @RequestMapping("/selByCard")
    public String selectByCardId(Model model, String memberAccount) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        if (memberList != null) {
            model.addAttribute("memberList", memberList);
        } else {
            String message = "Membership card number does not exist！";
            model.addAttribute("noMessage", message);
        }
        return "selectByMemberAccount";
    }

}
