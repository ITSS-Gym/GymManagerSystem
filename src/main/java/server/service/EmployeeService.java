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

    public Boolean deleteByEmployeeId(Integer employeeId) {
        return employeeMapper.deleteByEmployeeId(employeeId);
    }

    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    public Boolean updateMemberByEmployeeId(Employee employee) {
        return employeeMapper.updateMemberByEmployeeId(employee);
    }

    public List<Employee> selectByEmployeeId(Integer employeeId) {
        return employeeMapper.selectByEmployeeId(employeeId);
    }

    public Integer selectTotalCount() {
        return employeeMapper.selectTotalCount();
    }
}
