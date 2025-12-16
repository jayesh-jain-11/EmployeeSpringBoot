package com.jayesh.EmployeeDemo.security;

import com.jayesh.EmployeeDemo.dto.ApiResponse;
import com.jayesh.EmployeeDemo.dto.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ErrorResponse errorResponse = new ErrorResponse(
                "You do not valid Authentication to proceed",
                HttpServletResponse.SC_UNAUTHORIZED
        );

        ApiResponse<ErrorResponse> apiResponse = ApiResponse.failure("Unauthorized request",errorResponse);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        new ObjectMapper().writeValue(response.getOutputStream(),apiResponse);
    }
}
