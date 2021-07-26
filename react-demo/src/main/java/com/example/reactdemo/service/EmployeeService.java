package com.example.reactdemo.service;

import java.util.List;

import com.example.reactdemo.models.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void addEmployee(final Employee employee);

    void updateEmployee(final Employee employee);

    void deleteEmployee(final Integer id);

    Employee getEmployeeById(final Integer id);
}
