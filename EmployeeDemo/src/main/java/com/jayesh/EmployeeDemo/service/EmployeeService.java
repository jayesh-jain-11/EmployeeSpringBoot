package com.jayesh.EmployeeDemo.service;


import com.jayesh.EmployeeDemo.exception.ResourceNotFoundException;
import com.jayesh.EmployeeDemo.model.Employee;
import com.jayesh.EmployeeDemo.repo.EmployeeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Page<Employee> getEmployees(Pageable pageable) {
        return repo.findAll(pageable);
    }


    public Employee getEmployeeById(int empid) {
        return repo.findById(empid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + empid));
    }



    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }


    public Employee updateEmployeeDetails(Employee employee) {
        if(!repo.existsById(employee.getEmpid())) {
            throw new ResourceNotFoundException("Employee not Found");
        }
        return repo.save(employee);
    }

    public void deleteEmployee(int empid) {
        if(!repo.existsById(empid)){
            throw new ResourceNotFoundException("Employee not Found");
        }
        repo.deleteById(empid);
    }
}
