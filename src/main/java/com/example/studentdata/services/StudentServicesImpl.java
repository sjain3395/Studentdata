package com.example.studentdata.services;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentServices")

public class StudentServicesImpl implements StudentServices {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student getStudent(String stdId) {
        Student student = studentRepository.getStudent(stdId);
        return student;
    }

    @Override
    public List<Student> getStudents() {

        return studentRepository.getStudents();
    }

    @Override
    public void addStudent(Student student, String stdId) {
        studentRepository.addStudent(student, stdId);


    }

    @Override
    public void removeStudent(String stdId) {
        studentRepository.removeStudent(stdId);
    }
}
