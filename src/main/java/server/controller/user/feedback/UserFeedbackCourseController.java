package server.controller.user.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.pojo.Course;
import server.pojo.FeedbackCourse;
import server.pojo.Member;
import server.service.CourseService;
import server.service.FeedbackCourseService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserFeedbackCourseController {
    @Autowired
    private FeedbackCourseService feedbackCourseService;

    @Autowired
    private CourseService CourseService;

    @RequestMapping("/userFeedbackCourse")
    public String userFeedbackCourse(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<FeedbackCourse> feedbackCourseList = feedbackCourseService.selectByMemberAccount(memberAccount);
        model.addAttribute("feedbackCourseList", feedbackCourseList);
        return "userFeedbackCourse";
    }

    @RequestMapping("/toAddFeedbackCourse")
    public String toAddCourse(Model model) {
        List<Course> courseList = CourseService.findAll();
        model.addAttribute("courseList", courseList);
        return "addFeedbackCourse";
    }

    @RequestMapping("/addFeedbackCourse")
    public String addFeedbackCourse(FeedbackCourse feedbackCourse, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        feedbackCourse.setMemberAccount(member.getMemberAccount());
        feedbackCourseService.insertFeedbackCourse(feedbackCourse);
        return "redirect:userFeedbackCourse";
    }

    // Jump to the new course page
    @RequestMapping("/delFeedbackCourse")
    public String deleteFeedbackCourse(Integer feedbackId) {
        feedbackCourseService.deleteByFeedbackId(feedbackId);
        return "redirect:userFeedbackCourse";
    }

    @RequestMapping("/toUpdateFeedbackCourse")
    public String toUpdateFeedbackCourse(Integer feedbackId, Model model) {
        List<FeedbackCourse> feedbackCourseList = feedbackCourseService.selectByFeedbackId(feedbackId);
        model.addAttribute("feedbackCourseList", feedbackCourseList);
        return "updateFeedbackCourse";
    }
    @RequestMapping("/updateFeedbackCourse")
    public String updateFeedbackCourse(FeedbackCourse feedbackCourse) {
        feedbackCourseService.updateByFeedbackId(feedbackCourse);
        return "redirect:userFeedbackCourse";
    }

    @RequestMapping("/userOtherFeedbackCourse")
    public String toSelectOtherFeedbackCourse(Integer courseId, Model model) {
        List<FeedbackCourse> feedbackCourseList = feedbackCourseService.selectByCourseId(courseId);
        model.addAttribute("feedbackCourseList", feedbackCourseList);
        model.addAttribute("courseId", courseId);
        return "userOtherFeedbackCourse";
    }

}
