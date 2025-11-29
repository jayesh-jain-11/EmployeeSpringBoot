package com.jayesh.EmployeeDemo.controller;

import com.jayesh.EmployeeDemo.model.Employee;
import com.jayesh.EmployeeDemo.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(service.getEmployees(),HttpStatus.OK);
    }

    @GetMapping("/employee/{empid}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int empid){
        return new ResponseEntity<>(service.getEmployeeById(empid),HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Employee emp = service.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee){
        Employee emp = service.updateEmployeeDetails(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empid){
        Employee emp = service.getEmployeeById(empid);
        if(emp != null){
            service.deleteEmployee(empid);
            return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
        }
    }

}
