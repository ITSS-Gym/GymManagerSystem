package server.service.impl;

import server.mapper.RoomMapper;
import server.pojo.Room;
import server.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> findAll() {
        return roomMapper.findAll();
    }

    @Override
    public Boolean deleteByRoomId(Integer roomId) {
        return roomMapper.deleteByRoomId(roomId);
    }

    @Override
    public Boolean insertRoom(Room room) {
        return roomMapper.insertRoom(room);
    }

    @Override
    public Boolean updateRoomByRoomId(Room room) {
        return roomMapper.updateRoomByRoomId(room);
    }

    @Override
    public List<Room> selectByRoomId(Integer roomId) {
        return roomMapper.selectByRoomId(roomId);
    }

    @Override
    public Integer selectTotalCount() {
        return roomMapper.selectTotalCount();
    }
}
