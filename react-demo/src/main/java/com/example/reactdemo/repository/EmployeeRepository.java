package com.example.reactdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.reactdemo.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    //List<Employee> findAllActive();
}
