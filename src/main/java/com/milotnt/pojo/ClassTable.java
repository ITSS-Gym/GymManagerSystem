package com.milotnt.pojo;

import org.springframework.data.relational.core.sql.In;

/**
 * @author MiloTnT [milotntspace@gmail.com]
 * @date 2021/8/10
 */
public class ClassTable {

    private Integer classId;
    private String className;
    private String classBegin;
    private String classTime;
    private String coach;

    private Integer price;

    private String classType;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassBegin() {
        return classBegin;
    }

    public void setClassBegin(String classBegin) {
        this.classBegin = classBegin;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
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

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "ClassTable{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classBegin='" + classBegin + '\'' +
                ", classTime='" + classTime + '\'' +
                ", coach='" + coach + '\'' +
                ", price='" + price + '\'' +
                ", classType='" + classType + '\'' +
                '}';
    }
}
