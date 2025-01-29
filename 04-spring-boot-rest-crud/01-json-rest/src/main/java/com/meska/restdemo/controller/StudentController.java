package com.meska.restdemo.controller;

import com.meska.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    void loadStudentData(){
        students = new ArrayList<>();

        students.add(new Student("Yousef", "Meska"));
        students.add(new Student("Omar", "Meska"));
        students.add(new Student("Ali", "Meska"));
    }
    @GetMapping("/students")
    List<Student> getStudents(){
        return students;
    }


    @GetMapping("/students/{student_id}")
    public Student getStudent(@PathVariable int student_id){

        //check th student id against the list size

        if(student_id >= students.size() || (student_id < 0)){
            throw new StudentNotFoundException("Student is not found - " + student_id);
        }
        return students.get(student_id);
    }

    // Add an exception handler using @ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exec){
//        //create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exec.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//        //return ResposneEntity
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }

    // Adding another exception handler that catch generic excption, the above one will fail If I've passses a strign instead of integer

//    @ExceptionHandler
//    ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
////create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exec.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//        //return ResposneEntity
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}

/** notes:
 * /students => retrieve all students
 * /studetns/{id} -> retreive single student
 * when we throw the StudentNotFoundException, we catch that exception using that handleException which listen for this one
 * and then add the appropiate error response and extract the message from the exception where we throw it
 */
