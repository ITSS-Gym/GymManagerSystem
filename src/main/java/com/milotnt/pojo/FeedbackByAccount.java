package com.milotnt.pojo;

import java.sql.Timestamp;

public class FeedbackByAccount {

    private Integer feedbackId;

    private Timestamp timeCreated;

    private Integer account;

    private String name;

    private String content;

    public FeedbackByAccount(Integer feedbackId, Timestamp timeCreated, Integer account, String name, String content) {
        this.feedbackId = feedbackId;
        this.timeCreated = timeCreated;
        this.account = account;
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

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
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
        return "FeedbackByAccount{" +
                "feedbackId=" + feedbackId +
                ", timeCreated='" + timeCreated + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
