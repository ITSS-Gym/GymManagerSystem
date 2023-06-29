package server.pojo;

public class FeedbackEmployee extends Feedback {

    private String employeeAccount;

    private String employeeName;


    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "FeedbackEmployee{" +
                "employeeAccount=" + employeeAccount +
                ", employeeName='" + employeeName + '\'' +
                ", feedbackId=" + feedbackId +
                ", memberAccount=" + memberAccount +
                ", memberName='" + memberName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
