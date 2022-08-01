package com.example.springboot.controller;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // get all employees
    @GetMapping()
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // create new employee
    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }
}
