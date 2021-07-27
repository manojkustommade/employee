package com.example.reactdemo.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.example.reactdemo.models.Employee;
import com.example.reactdemo.service.Impl.EmployeeServieImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Resource
    MockMvc mockMvc;

    @MockBean
    EmployeeServieImpl employeeServie;

    @Resource
    ObjectMapper objectMapper;

    List<Employee> employees;

    public RequestBuilder getMockMvcRequestBuilder(String path) {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(path).
                accept(MediaType.APPLICATION_JSON_VALUE);

        return requestBuilder;
    }

    @BeforeEach
    public void initializeData() {
        objectMapper = new ObjectMapper();
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
    @DisplayName("Rest Controller: Find Employee By Id")
    public void getEmployeeByIdTest() throws Exception {
        Employee employee = employees.get(0);

        Mockito.when(employeeServie.getEmployeeById(1)).thenReturn(employee);

        RequestBuilder requestBuilder = this.getMockMvcRequestBuilder("/employee/view/" + 1);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String response = result.getResponse().getContentAsString();

        Employee employee1 = objectMapper.readValue(response, Employee.class);

        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        org.junit.jupiter.api.Assertions.assertTrue(employee.getId() == employee1.getId());
    }

    @Test
    @DisplayName("Rest Controller: Get All Employees")
    public void getAllEmployeesTest() throws Exception {
        Mockito.when(employeeServie.getAllEmployees()).thenReturn(employees);

        RequestBuilder requestBuilder = this.getMockMvcRequestBuilder("/employee");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String responseString = result.getResponse().getContentAsString();

        List<Employee> emp = objectMapper.readValue(responseString, new TypeReference<List<Employee>>() {});

        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        org.junit.jupiter.api.Assertions.assertTrue(employees.size() == emp.size());
    }
}
