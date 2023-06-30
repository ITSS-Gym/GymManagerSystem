package server.controller.user.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.pojo.Room;
import server.pojo.FeedbackRoom;
import server.pojo.Member;
import server.service.RoomService;
import server.service.FeedbackRoomService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserFeedbackRoomController {
    @Autowired
    private FeedbackRoomService feedbackRoomService;

    @Autowired
    private RoomService RoomService;

    @RequestMapping("/userFeedbackRoom")
    public String userFeedbackRoom(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<FeedbackRoom> feedbackRoomList = feedbackRoomService.selectByMemberAccount(memberAccount);
        model.addAttribute("feedbackRoomList", feedbackRoomList);
        return "userFeedbackRoom";
    }

    @RequestMapping("/toAddFeedbackRoom")
    public String toAddRoom(Model model) {
        List<Room> roomList = RoomService.findAll();
        model.addAttribute("roomList", roomList);
        return "addFeedbackRoom";
    }

    @RequestMapping("/addFeedbackRoom")
    public String addFeedbackRoom(FeedbackRoom feedbackRoom, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        feedbackRoom.setMemberAccount(member.getMemberAccount());
        feedbackRoomService.insertFeedbackRoom(feedbackRoom);
        return "redirect:userFeedbackRoom";
    }

    // Jump to the new course page
    @RequestMapping("/delFeedbackRoom")
    public String deleteFeedbackRoom(Integer feedbackId) {
        feedbackRoomService.deleteByFeedbackId(feedbackId);
        return "redirect:userFeedbackRoom";
    }

    @RequestMapping("/toUpdateFeedbackRoom")
    public String toUpdateFeedbackRoom(Integer feedbackId, Model model) {
        List<FeedbackRoom> feedbackRoomList = feedbackRoomService.selectByFeedbackId(feedbackId);
        model.addAttribute("feedbackRoomList", feedbackRoomList);
        return "updateFeedbackRoom";
    }
    @RequestMapping("/updateFeedbackRoom")
    public String updateFeedbackRoom(FeedbackRoom feedbackRoom) {
        feedbackRoomService.updateByFeedbackId(feedbackRoom);
        return "redirect:userFeedbackRoom";
    }
}
