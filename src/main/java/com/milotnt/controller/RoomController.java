package com.milotnt.controller;

import com.milotnt.pojo.Room;
import com.milotnt.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/selRoom")
    public String selectRoom(Model model, HttpSession session) {
        List<Room> roomList = roomService.findAll();
        session.setAttribute("roomList", roomList);
        model.addAttribute("roomList", roomList);
        return "selectRoom";
    }

    @RequestMapping("/delRoom")
    public String deleteRoom(Integer roomId) {
        roomService.deleteByRoomId(roomId);
        return "redirect:selRoom";
    }

    // Jump to modify room page
    @RequestMapping("/toUpdateRoom")
    public String toUpdateRoom(Integer roomId, Model model) {
        List<Room> roomList = roomService.selectByRoomId(roomId);
        model.addAttribute("roomList", roomList);
        model.addAttribute("roomId", roomId);
        return "updateRoom";
    }

    // Modify room
    @RequestMapping("/updateRoom")
    public String updateRoom(Integer roomId, Room room) {
        room.setRoomId(roomId);
        roomService.updateRoomByRoomId(room);
        return "redirect:../selRoom";
    }

    // Jump to the new room page
    @RequestMapping("/toAddRoom")
    public String toAddRoom() {
        return "addRoom";
    }

    // Add new room
    @RequestMapping("/addRoom")
    public String addRoom(Room room) {
        roomService.insertRoom(room);
        return "redirect:selRoom";
    }
}
