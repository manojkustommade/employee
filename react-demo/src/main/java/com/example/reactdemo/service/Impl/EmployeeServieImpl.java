package com.example.reactdemo.service.Impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.example.reactdemo.exception.EmployeeException;
import com.example.reactdemo.models.Employee;
import com.example.reactdemo.repository.EmployeeRepository;
import com.example.reactdemo.service.EmployeeService;

@Component
@Transactional
public class EmployeeServieImpl implements EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee: employees) {
            employeeList.add(employee);
        }

        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee == null || !employee.isPresent()) {
            throw new EmployeeException("Employee not found with ID: " + id);
        }

        return employee.get();
    }

}
