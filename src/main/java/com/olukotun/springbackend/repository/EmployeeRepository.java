package com.olukotun.springbackend.repository;

import com.olukotun.springbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
