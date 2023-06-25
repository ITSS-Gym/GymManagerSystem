package com.milotnt.mapper;

import com.milotnt.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {

    // Query all employees
    List<Employee> findAll();

    // Delete employees based on employee account
    Boolean deleteByEmployeeAccount(Integer employeeAccount);

    // add new employee
    Boolean insertEmployee(Employee employee);

    // Modify member information according to employee account
    Boolean updateMemberByEmployeeAccount(Employee employee);

    // Query employees based on employee account
    List<Employee> selectByEmployeeAccount(Integer employeeAccount);

    // Query the number of employees
    Integer selectTotalCount();

}