package com.example.demo.repository;

import com.example.demo.models.Employee_Detail;
import com.example.demo.payloads.request.note.EditRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailRepository extends JpaRepository<Employee_Detail, Long> {
    Employee_Detail save(EditRequest editRequest);
}
