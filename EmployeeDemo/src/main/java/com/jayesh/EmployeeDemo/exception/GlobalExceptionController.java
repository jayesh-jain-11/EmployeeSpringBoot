package com.jayesh.EmployeeDemo.exception;


import com.jayesh.EmployeeDemo.dto.ApiResponse;
import com.jayesh.EmployeeDemo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionController {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {

            int statusCode = HttpStatus.NOT_FOUND.value();
            ErrorResponse errorResponse = new ErrorResponse(
                    ex.getMessage(),
                    statusCode
            );

            return new ResponseEntity<>(
                    ApiResponse.failure("Resource Not Found",errorResponse),
                    HttpStatus.NOT_FOUND
            );
        }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGlobalException(Exception ex,WebRequest request){

        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                statusCode
        );

        return new ResponseEntity<>(
                ApiResponse.failure(ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );

    }

}