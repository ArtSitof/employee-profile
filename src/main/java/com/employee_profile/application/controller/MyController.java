package com.employee_profile.application.controller;

import com.employee_profile.application.entity.Employee;
import com.employee_profile.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    // Add new employee
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee (Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    // Saving an employee at the click of a button
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    // Edite employee
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam ("empId") int id, Model model) {

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    // Delete employee
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam ("empId") int id) {

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
