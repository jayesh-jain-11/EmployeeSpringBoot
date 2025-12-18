package com.jayesh.EmployeeDemo.service;

import com.jayesh.EmployeeDemo.dto.LoginRequest;
import com.jayesh.EmployeeDemo.model.Users;
import com.jayesh.EmployeeDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String verifyUser(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        Users user = userRepo.findByUserName(request.getUsername());
        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUsername());
            System.out.println(token);
            return token;
        }
        return "Failed , No User found";
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user) {
        if(null == userRepo.findByUserName(user.getUsername())) {
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        return null;
    }
}
