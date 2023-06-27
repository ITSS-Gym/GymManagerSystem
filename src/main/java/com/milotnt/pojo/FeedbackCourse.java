package com.milotnt.pojo;

public class FeedbackCourse extends Feedback {

    private Integer courseId;

    private String courseName;


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

    @Override
    public String toString() {
        return "FeedbackCourse{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", feedbackId=" + feedbackId +
                ", memberAccount=" + memberAccount +
                ", memberName='" + memberName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
