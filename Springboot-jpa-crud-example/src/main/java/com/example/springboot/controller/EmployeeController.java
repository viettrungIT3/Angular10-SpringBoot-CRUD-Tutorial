package com.example.springboot.controller;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // create new list employee
    @PostMapping("/all")
    public List<Employee> createEmployees(@RequestBody List<Employee> employee) {
        return repository.saveAll(employee);
    }

    // get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok().body(employee);
    }

}
