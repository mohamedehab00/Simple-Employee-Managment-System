package com.company.employees.controller;

import com.company.employees.entity.Employee;
import com.company.employees.service.IEmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,editor);
    }
    @GetMapping("")
    public String getAllEmployees(Model  model){

        model.addAttribute("employees",employeeService.findAllEmployees());

        return "EmployeeDirectory";
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/create")
    public String getEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());

        return "EmployeeForm";
    }

    @PostMapping("/save")
    public String addEmployee(
            @Valid
            @ModelAttribute("employee") Employee employee,
            BindingResult result
    ){
        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Integer id){
        System.out.println(id);
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @PostMapping("/update")
    public String showUpdateForm(@RequestParam("id") Integer id, Model model){
        model.addAttribute("employee", employeeService.findEmployeeById(id));

        return "EmployeeForm";
    }
}
