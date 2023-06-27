package com.milotnt.pojo;

public class Course {

    private Integer courseId;
    private String courseName;
    private String courseBegin;
    private String courseTime;
    private String coach;

    private Integer price;

    private String courseType;

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

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
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
                ", coach='" + coach + '\'' +
                ", price=" + price +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
