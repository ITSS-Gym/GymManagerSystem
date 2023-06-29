package server.pojo;

import java.sql.Timestamp;

public class FeedbackEquipment {

    private Integer feedbackId;

    private String memberAccount;

    private String memberName;

    private Integer equipmentId;

    private String equipmentName;

    private String content;
    private Timestamp timeCreated;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "FeedbackEquipment{" +
                "feedbackId=" + feedbackId +
                ", memberAccount='" + memberAccount + '\'' +
                ", memberName='" + memberName + '\'' +
                ", equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
