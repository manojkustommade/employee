package com.example.reactdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.Response;

import com.example.reactdemo.models.Employee;
import com.example.reactdemo.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/create")
    public ResponseEntity addEmployee(@RequestBody final Employee employee) {
        employeeService.addEmployee(employee);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody final Employee employee) {
        employeeService.updateEmployee(employee);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "id") final Integer id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") final Integer id) {
        return employeeService.getEmployeeById(id);
    }
}
