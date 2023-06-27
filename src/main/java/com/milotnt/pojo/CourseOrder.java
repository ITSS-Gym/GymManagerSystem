package com.milotnt.pojo;

public class CourseOrder {

    private Integer courseOrderId;
    private Integer courseId;
    private String courseName;
    private Integer coachAccount;
    private String coachName;
    private Integer memberAccount;
    private String memberName;
    private String courseBegin;
    private String status;

    public CourseOrder(Integer courseId, String courseName, Integer coachAccount, String coachName, Integer memberAccount, String memberName, String courseBegin) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coachAccount = coachAccount;
        this.coachName = coachName;
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.courseBegin = courseBegin;
        this.status = "waiting";
    }

    public CourseOrder(Integer courseOrderId, Integer courseId, String courseName, Integer coachAccount, String coachName, Integer memberAccount, String memberName, String courseBegin, String status) {
        this.courseOrderId = courseOrderId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.coachAccount = coachAccount;
        this.coachName = coachName;
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.courseBegin = courseBegin;
        this.status = status;
    }

    public Integer getCourseOrderId() {
        return courseOrderId;
    }

    public void setCourseOrderId(Integer courseOrderId) {
        this.courseOrderId = courseOrderId;
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

    public Integer getCoachAccount() {
        return coachAccount;
    }

    public void setCoachAccount(Integer coachAccount) {
        this.coachAccount = coachAccount;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(Integer memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getCourseBegin() {
        return courseBegin;
    }

    public void setCourseBegin(String courseBegin) {
        this.courseBegin = courseBegin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseOrder{" +
                "courseOrderId=" + courseOrderId +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", coachAccount=" + coachAccount +
                ", coachName='" + coachName + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberAccount=" + memberAccount +
                ", courseBegin='" + courseBegin + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}