package com.olukotun.springbackend.controller;

import com.olukotun.springbackend.exception.ResourceNotFoundException;
import com.olukotun.springbackend.model.Employee;
import com.olukotun.springbackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

   private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.employeeList();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeService.createEmployee(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee =employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee1);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Map<String, Boolean> response = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(response);
    }


}
