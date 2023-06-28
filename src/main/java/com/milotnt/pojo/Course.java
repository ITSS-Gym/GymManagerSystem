package com.milotnt.pojo;

public class Course {

    private Integer courseId;
    private String courseName;
    private String courseBegin;
    private String courseTime;

    private String coachAccount;
    private String coachName;

    private Integer price;

    private String courseType;

    public Course(Integer courseId, String courseName, String courseBegin, String courseTime, String coachAccount, String coachName, Integer price, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseBegin = courseBegin;
        this.courseTime = courseTime;
        this.coachAccount = coachAccount;
        this.coachName = coachName;
        this.price = price;
        this.courseType = courseType;
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

    public String getCourseBegin() {
        return courseBegin;
    }

    public void setCourseBegin(String courseBegin) {
        this.courseBegin = courseBegin;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCoachAccount() {
        return coachAccount;
    }

    public void setCoachAccount(String coachAccount) {
        this.coachAccount = coachAccount;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseBegin='" + courseBegin + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", coachId=" + coachAccount +
                ", coachName='" + coachName + '\'' +
                ", price=" + price +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
