package com.jayesh.EmployeeDemo.controller;

import com.jayesh.EmployeeDemo.dto.ApiResponse;
import com.jayesh.EmployeeDemo.dto.LoginRequest;
import com.jayesh.EmployeeDemo.dto.LoginResponse;
import com.jayesh.EmployeeDemo.model.Users;
import com.jayesh.EmployeeDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request){
        String token = service.verifyUser(request);

        LoginResponse loginResponse = new LoginResponse(request.getUsername(),token);

        return ResponseEntity.ok(
                ApiResponse.success("Login Successful", loginResponse)
        );

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user){
        Users validUser = service.register(user);
        return ResponseEntity.ok(ApiResponse.success("Registration Successful",validUser));
    }

    @GetMapping("/secured")
    @PreAuthorize("hasRole('ADMIN')")
    public String testAdmin() {
        return "Secret Data";
    }


}