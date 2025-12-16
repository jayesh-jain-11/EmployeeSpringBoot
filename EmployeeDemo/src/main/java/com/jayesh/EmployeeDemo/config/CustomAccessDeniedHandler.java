package com.jayesh.EmployeeDemo.config;

import com.jayesh.EmployeeDemo.dto.ApiResponse;
import com.jayesh.EmployeeDemo.dto.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ErrorResponse errorResponse = new ErrorResponse(
                "You do not have permission to access this resource",
                HttpServletResponse.SC_FORBIDDEN
        );

        ApiResponse<ErrorResponse> apiResponse = ApiResponse.failure("Access Denied",errorResponse);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        new ObjectMapper().writeValue(response.getOutputStream(),apiResponse);
    }
}
