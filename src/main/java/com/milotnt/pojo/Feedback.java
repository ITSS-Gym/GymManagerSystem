package com.milotnt.pojo;

public class Feedback {

    private Integer feedbackId;

    private Integer memberAccount;

    private Integer employeeAccount;

    private String content;

    public Feedback(Integer feedbackId, Integer memberAccount, Integer employeeAccount, String content) {
        this.feedbackId = feedbackId;
        this.memberAccount = memberAccount;
        this.employeeAccount = employeeAccount;
        this.content = content;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(Integer memberAccount) {
        this.memberAccount = memberAccount;
    }

    public Integer getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(Integer employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", memberAccount='" + memberAccount + '\'' +
                ", employeeAccount='" + employeeAccount + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
