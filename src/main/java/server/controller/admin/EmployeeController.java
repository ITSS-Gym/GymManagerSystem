package server.controller.admin;

import server.pojo.Employee;
import server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Query employees
    @RequestMapping("/selEmployee")
    public String selectEmployee(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "selectEmployee";
    }

    // Jump to the new employee page
    @RequestMapping("/toAddEmployee")
    public String toAddEmployee() {
        return "addEmployee";
    }

    // New employee
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee) {

        //get current date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        employee.setEntryTime(nowDay);

        employeeService.insertEmployee(employee);

        return "redirect:selEmployee";

    }

    //delete employee
    @RequestMapping("/delEmployee")
    public String deleteEmployee(Integer employeeId) {
        employeeService.deleteByEmployeeId(employeeId);
        return "redirect:selEmployee";
    }

    //Jump to the employee modification page
    @RequestMapping("/toUpdateEmployee")
    public String toUpdateEmployee(Integer employeeId, Model model) {
        List<Employee> employeeList = employeeService.selectByEmployeeId(employeeId);
        model.addAttribute("employeeList", employeeList);
        return "updateEmployee";
    }

    //Modify employee information
    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee) {
        employeeService.updateMemberByEmployeeId(employee);
        return "redirect:selEmployee";
    }

}
