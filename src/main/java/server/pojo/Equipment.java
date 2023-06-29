package server.pojo;

public class Equipment {

    private Integer equipmentId;
    private String equipmentName;
    private String equipmentStatus;
    private String equipmentMessage;

    private Integer roomId;

    public Equipment(Integer equipmentId, String equipmentName, String equipmentStatus, String equipmentMessage, Integer roomId) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentStatus = equipmentStatus;
        this.equipmentMessage = equipmentMessage;
        this.roomId = roomId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentMessage() {
        return equipmentMessage;
    }

    public void setEquipmentMessage(String equipmentMessage) {
        this.equipmentMessage = equipmentMessage;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentStatus='" + equipmentStatus + '\'' +
                ", equipmentMessage='" + equipmentMessage + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
