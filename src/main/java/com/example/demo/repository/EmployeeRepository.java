package com.example.demo.repository;

import com.example.demo.models.Employee;
import com.example.demo.payloads.request.EmployeeRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee save(EmployeeRequest employee);
}
