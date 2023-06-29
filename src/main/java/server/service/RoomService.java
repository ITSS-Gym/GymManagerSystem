package server.service;

import server.pojo.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    // Delete device by id
    Boolean deleteByRoomId(Integer roomId);

    // Add room
    Boolean insertRoom(Room room);

    // Modify device information according to id
    Boolean updateRoomByRoomId(Room room);

    // Query devices by id
    List<Room> selectByRoomId(Integer roomId);

    // Query devices by id
    Integer selectTotalCount();
}
