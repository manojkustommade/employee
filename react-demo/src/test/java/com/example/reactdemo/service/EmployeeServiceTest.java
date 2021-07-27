package com.example.reactdemo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.reactdemo.exception.EmployeeException;
import com.example.reactdemo.models.Employee;
import com.example.reactdemo.repository.EmployeeRepository;
import com.example.reactdemo.service.Impl.EmployeeServieImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    // mock the employee repository class because it's used in employees service Impl
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServieImpl employeeServie;

    private List<Employee> employees;

    @BeforeEach
    public void getAllMockEmployees() {
        employees = new ArrayList<>();
        Employee employee = new Employee();

        employee.setId(1);
        employee.setEmpCode("HIN123");
        employee.setEmailId("mk@g.com");
        employee.setDesignation("SD");
        employee.setFirstName("MK");
        employee.setLastName("KAST");

        employees.add(employee);
        employee = new Employee();

        employee.setId(2);
        employee.setEmpCode("HIN100");
        employee.setEmailId("mk@gmail.com");
        employee.setDesignation("TEST");
        employee.setFirstName("venkat");
        employee.setLastName("Posh");

        employees.add(employee);
    }

    @Test
    @DisplayName("add employee")
    public void addEmployeeTest() {
        Employee employee = employees.get(0);
        employee.setId(null);

        employeeServie.addEmployee(employee);

        // check is addEmployee method hitting or not to check with times(1) --> 1 time
        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    @DisplayName("find all employees")
    public void getAllEmployeesTest() {
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> employees1 = employeeServie.getAllEmployees();

        Assert.isTrue(employees1.size() == employees.size(), "all employees matched");
    }

    @Test
    @DisplayName("find employee by Id")
    public void getEmployeeByIdTest() {
        Employee employee = employees.get(0);

        // Data preparation
        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Employee employee1 = employeeServie.getEmployeeById(1);

        Assert.notNull(employee, "Employee not found");

        Assertions.assertEquals(1, employee1.getId());
    }

    @Test
    @DisplayName("delete employee by Id")
    public void deleteEmployeeTest() {
        Employee employee = employees.get(0);
        employeeServie.deleteEmployee(employee.getId());

        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(employee.getId());
    }

    @Test
    @DisplayName("Update Employee")
    public void updateEmployeeTest() {
        Employee employee = employees.get(0);
        employee.setFirstName("ManojKasturi");

        employeeServie.updateEmployee(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    @DisplayName("check employee not found exception")
    public void employeeExceptionTest() {
        Mockito.when(employeeRepository.findById(2)).thenReturn(null);

        Assertions.assertThrows(EmployeeException.class,
                () -> {
                    employeeServie.getEmployeeById(2);
                });
    }
}
