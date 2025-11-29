package com.jayesh.EmployeeDemo.repo;

import com.jayesh.EmployeeDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
