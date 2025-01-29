package com.meska.restdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionGlobalHandler {
    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
//create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exec.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        //return ResposneEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


//     Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exec){
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exec.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        //return ResposneEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
