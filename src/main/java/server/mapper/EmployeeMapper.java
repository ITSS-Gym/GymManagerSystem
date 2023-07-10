package server.mapper;

import server.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {

    // Query all employees
    List<Employee> findAll();

    // Delete employees based on employee account
    Boolean deleteByEmployeeId(Integer employeeId);

    // add new employee
    Boolean insertEmployee(Employee employee);

    // Modify member information according to employee account
    Boolean updateMemberByEmployeeId(Employee employee);

    // Query employees based on employee account
    List<Employee> selectByEmployeeId(Integer employeeId);

    List<Employee> selectByEmployeeAccount(String employeeAccount);

    Employee selectByEmployeeAccountAndPassword(String employeeAccount, String employeePassword);

    // Query the number of employees
    Integer selectTotalCount();

}
