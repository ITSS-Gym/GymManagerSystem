package server.service;

import server.pojo.Equipment;

import java.util.List;

public interface EquipmentService {

    // Query all devices
    List<Equipment> findAll();

    // Delete device by id
    Boolean deleteByEquipmentId(Integer equipmentId);

    // Add equipment
    Boolean insertEquipment(Equipment equipment);

    // Modify device information according to id
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    // Query devices by id
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    // Query devices by id
    Integer selectTotalCount();

}
