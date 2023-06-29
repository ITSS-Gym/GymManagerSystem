package server.pojo;

import java.sql.Timestamp;

public class FeedbackCourse {
    
    private Integer feedbackId;

    private String memberAccount;

    private String memberName;

    private Integer courseId;
    
    private String courseName;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        return "FeedbackCourse{" +
                "feedbackId=" + feedbackId +
                ", memberAccount='" + memberAccount + '\'' +
                ", memberName='" + memberName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
