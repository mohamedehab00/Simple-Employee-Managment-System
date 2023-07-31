package com.company.employees.controller;

import com.company.employees.entity.Employee;
import com.company.employees.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("")
    public String getAllEmployees(Model  model){

        model.addAttribute("employees",employeeService.findAllEmployees());

        return "EmployeeDirectory";
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }
}
