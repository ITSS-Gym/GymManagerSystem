package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.EmployeeMapper;
import server.pojo.Employee;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    public Boolean deleteByEmployeeAccount(String employeeAccount) {
        return employeeMapper.deleteByEmployeeAccount(employeeAccount);
    }

    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    public Boolean updateMemberByEmployeeAccount(Employee employee) {
        return employeeMapper.updateMemberByEmployeeAccount(employee);
    }

    public List<Employee> selectByEmployeeAccount(String employeeAccount) {
        return employeeMapper.selectByEmployeeAccount(employeeAccount);
    }

    public Integer selectTotalCount() {
        return employeeMapper.selectTotalCount();
    }
}
