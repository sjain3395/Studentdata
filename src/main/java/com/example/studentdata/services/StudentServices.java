package com.example.studentdata.services;
import com.example.studentdata.model.Student;

import java.util.List;

public interface StudentServices {
    Student getStudent(String UserId);
    List<Student> getStudents();
    public void addStudent(Student student, String stdId);
    public void removeStudent(String stdId);

}
