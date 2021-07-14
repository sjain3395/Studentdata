package com.example.studentdata.repository;

import com.example.studentdata.model.Student;

import java.util.List;

public interface StudentRepository {
    Student getStudent(String  userId);
    List<Student> getStudents();
    public void addStudent (Student student, String stdId);
    public void removeStudent(String stdId);
}
