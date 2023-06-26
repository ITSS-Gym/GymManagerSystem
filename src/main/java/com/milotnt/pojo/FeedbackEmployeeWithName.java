package com.milotnt.pojo;

import java.sql.Timestamp;

public class FeedbackEmployeeWithName {

    private Integer feedbackId;

    private Timestamp timeCreated;

    private Integer employeeAccount;

    private String name;

    private String content;

    public FeedbackEmployeeWithName(Integer feedbackId, Timestamp timeCreated, Integer employeeAccount, String name, String content) {
        this.feedbackId = feedbackId;
        this.timeCreated = timeCreated;
        this.employeeAccount = employeeAccount;
        this.name = name;
        this.content = content;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Integer getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(Integer employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FeedbackEmployeeWithName{" +
                "feedbackId=" + feedbackId +
                ", timeCreated='" + timeCreated + '\'' +
                ", employeeAccount='" + employeeAccount + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
