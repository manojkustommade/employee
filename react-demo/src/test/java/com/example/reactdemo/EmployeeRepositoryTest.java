package com.example.reactdemo;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.example.reactdemo.models.Employee;
import com.example.reactdemo.repository.EmployeeRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

    @Resource
    EmployeeRepository employeeRepository;

    /*@Test
    @Rollback
    @Order(1)
    public void saveEmployee() {
        Employee employee = new Employee();

        employee.setFirstName("ManojKKK");
        employee.setLastName("KKKKKK");
        employee.setDesignation("SDDDDD");
        employee.setEmailId("emndj@kjdfvkndkfnv");
        employee.setEmpCode("hin473r");

        Employee employee1 = employeeRepository.save(employee);

        Assert.isTrue(employee1.getId() != null, "employee created");
    }*/

    /*@Test
    @Rollback
    public void getAllEmployees() {
        Employee employee1 = new Employee();

        employee1.setFirstName("ManojKKK");
        employee1.setLastName("KKKKKK");
        employee1.setDesignation("SDDDDD");
        employee1.setEmailId("emndj@kjdfvkndkfnv");
        employee1.setEmpCode("hin473r");

        Employee sEmp = employeeRepository.save(employee1);

        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee: employees) {
            employeeList.add(employee);
        }

        Assert.isTrue(employeeList.size() > 0, () -> "data created");
    }*/

}
