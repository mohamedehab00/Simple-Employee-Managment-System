package com.company.employees.service;

import com.company.employees.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAllEmployees();
    Employee findEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
