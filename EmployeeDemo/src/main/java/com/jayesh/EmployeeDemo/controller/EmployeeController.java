package com.jayesh.EmployeeDemo.controller;

import com.jayesh.EmployeeDemo.dto.ApiResponse;
import com.jayesh.EmployeeDemo.model.Employee;
import com.jayesh.EmployeeDemo.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse<Map<String,Object>>> getEmployees(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "5") int size,
                                                                    @RequestParam(defaultValue = "empid") String sortBy,
                                                                    @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction
                .equalsIgnoreCase("desc")
                ?Sort.by(sortBy).descending()
                :Sort.by(sortBy).ascending();
        PageRequest pageRequest = PageRequest.of(page,size,sort);
        Page<Employee> pageResponse = service.getEmployees(pageRequest);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("employees",pageResponse.getContent());
        responseData.put("page", pageResponse.getNumber());
        responseData.put("size",pageResponse.getSize());
        responseData.put("totalPages",pageResponse.getTotalPages());
        responseData.put("totalElements",pageResponse.getTotalElements());
        responseData.put("numberOfELements",pageResponse.getNumberOfElements());
        responseData.put("sortBy",sortBy);
        responseData.put("direction",direction);

        return ResponseEntity
                .ok(ApiResponse.success("Employees fetched Successfully",responseData));
    }

    @GetMapping("/employee/{empid}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable int empid) {
        return ResponseEntity
                .ok(ApiResponse.success(service.getEmployeeById(empid)));
    }

    @PostMapping("/employee")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        Employee emp = service.addEmployee(employee);
        return ResponseEntity
                .ok(ApiResponse.success("Employee Created", emp));
    }

    @PutMapping("/employee")
    public ResponseEntity<ApiResponse<Employee>> updateEmployeeDetails(@RequestBody Employee employee) {
        Employee emp = service.updateEmployeeDetails(employee);
        return ResponseEntity
                .ok(ApiResponse.success("Employee Updated", emp));
    }

    @DeleteMapping("/employee/{empid}")
    public ResponseEntity<ApiResponse<?>> deleteEmployee(@PathVariable int empid) {

        Employee emp = service.getEmployeeById(empid);
        service.deleteEmployee(empid);

        return ResponseEntity
                .ok(ApiResponse.success("Employee Deleted successfully", null));
    }

}
