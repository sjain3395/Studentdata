package com.example.studentdata.controller;

import com.example.studentdata.model.Student;
import com.example.studentdata.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
@Autowired
    StudentServices studentServices;
    @ResponseStatus(value = HttpStatus.OK)                  // 1 Student Data
     @GetMapping(path = "/get-student")
    public Student getStudent(@RequestParam("studentId") String studentId) {
        Student student = studentServices.getStudent(studentId);
        return student;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "/get-students")         // All Student
    public List<Student> getStudents() { return studentServices.getStudents();
    }



    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(path = "/add-student")
   public void addStudent(@RequestBody Student student,
                          @RequestHeader(value ="studentID", required = true) String stdId){
        studentServices.addStudent(student, stdId);
   }

//    @ResponseStatus(value = HttpStatus.OK)
//    @DeleteMapping(path = "/remove-student/{id}")
//    public void removeEmployee( @PathVariable("id")  String stdId)
//    {studentServices.removeStudent(stdId);}

    @RequestMapping(value="/remove-student{id}", method = RequestMethod.DELETE)

    public void removeStudent(@PathVariable("id") String stdId){
        studentServices.removeStudent(stdId);


    }  }
