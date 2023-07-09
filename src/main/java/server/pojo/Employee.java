package server.pojo;

public class Employee {

    private Integer employeeId;
    private String employeeName;
    private String employeeGender;
    private Integer employeeAge;
    private String entryTime;
    private String staff;
    private String employeeMessage;

    private boolean active;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String employeeGender, Integer employeeAge, String entryTime, String staff, String employeeMessage) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.employeeAge = employeeAge;
        this.entryTime = entryTime;
        this.staff = staff;
        this.employeeMessage = employeeMessage;
        this.active = true;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getEmployeeMessage() {
        return employeeMessage;
    }

    public void setEmployeeMessage(String employeeMessage) {
        this.employeeMessage = employeeMessage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeAge=" + employeeAge +
                ", entryTime='" + entryTime + '\'' +
                ", staff='" + staff + '\'' +
                ", employeeMessage='" + employeeMessage + '\'' +
                ", active=" + active +
                '}';
    }
}
