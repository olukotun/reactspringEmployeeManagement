package com.olukotun.springbackend.service;

import com.olukotun.springbackend.exception.ResourceNotFoundException;
import com.olukotun.springbackend.model.Employee;
import com.olukotun.springbackend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public List<Employee> employeeList (){
        return employeeRepository.findAll();
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id " + id + " does not exist"));
        return employee;
    }
    public Employee updateEmployee1( Employee employee){
        Employee employee1 = new Employee();
        employee1.setId(employee.getId());
        employee1.setEmailId(employee.getEmailId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        return employeeRepository.save(employee1);
    }
   public Employee updateEmployee(Long id, Employee employee){
       Employee employee1 = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id " + id + " does not exist"));
       employee1.setEmailId(employee.getEmailId());
       employee1.setFirstName(employee.getFirstName());
       employee1.setLastName(employee.getLastName());
       return employeeRepository.save(employee1);
   }

   public Map<String, Boolean> deleteEmployee(Long id){
        Employee employee =employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id " + id + " does not exist"));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;


   }





}
