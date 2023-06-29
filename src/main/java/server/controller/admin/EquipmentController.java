package server.controller.admin;

import server.pojo.Equipment;
import server.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    // Query equipment
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model, HttpSession session) {
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipment";
    }

    // Delete device
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:selEquipment";
    }

    // Jump to modify equipment page
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);
        return "updateEquipment";
    }

    // Modify equipment
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:selEquipment";
    }

    // Jump to the new equipment page
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment() {
        return "addEquipment";
    }

    // Add new equipment
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
        equipmentService.insertEquipment(equipment);
        return "redirect:selEquipment";
    }

}
