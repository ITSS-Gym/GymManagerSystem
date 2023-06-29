package server.controller.admin.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.pojo.FeedbackEquipment;
import server.service.EquipmentService;
import server.service.FeedbackEquipmentService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackEquipmentController {
    @Autowired
    private FeedbackEquipmentService feedbackEquipmentService;

    @Autowired
    private EquipmentService EquipmentService;

    @RequestMapping("/selFeedbackEquipment")
    public String selectFeedbackEquipment(Model model) {
        List<FeedbackEquipment> feedbackEquipmentList = feedbackEquipmentService.findAll();
        model.addAttribute("feedbackEquipmentList", feedbackEquipmentList);
        return "selectFeedbackEquipment";
    }

    // Jump to the new Equipment page
    @RequestMapping("/toViewFeedbackEquipment")
    public String toViewFeedbackEquipment(Integer EquipmentId, Model model) {
        List<FeedbackEquipment> feedbackEquipmentList = feedbackEquipmentService.selectByEquipmentId(EquipmentId);
        model.addAttribute("feedbackEquipmentList", feedbackEquipmentList);
        return "viewFeedbackEquipment";
    }
}
