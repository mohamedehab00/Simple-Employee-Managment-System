package com.company.employees.service;

import com.company.employees.DAO.IEmployeeDAO;
import com.company.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDAO.findById(id).orElse(new Employee());
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeDAO.deleteById(id);
    }
}
