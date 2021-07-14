package com.example.studentdata.repository;

import com.example.studentdata.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Repository("studentRepository")
public class StudentRepoImpl implements StudentRepository {
    final List<Student> studentList = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(StudentRepoImpl.class);


    public Student getStudent(String stdId) {
        List<Student> studentList = getStudentList();
        Student student = new Student();
        for (int i = 0; i < studentList.size(); i++) {
            student = studentList.get(i);
            if (student.getId().equalsIgnoreCase(stdId)) {
                return student;
            }

        }
        return student;
    }



    @Override
    public void addStudent(Student student, String stdId) {

        //add successfully
        try {
            studentList.add(student);
            logger.debug("Student added successfully");
        } catch (Exception e) {
            logger.error("Error in adding student", e);
        }

    }
    @Override
    public List<Student> getStudents() {
        List<Student> studentList = getStudentList();
        return studentList;
    }




    private List<Student> getStudentList(){
        Student student = new Student();
        student.setId("001");
        student.setName("Anup");
        student.setEmail("Anup123@gmail.com");
        student.setAddress("Neemuch");
        studentList.add(student);

        student = new Student();
        student.setId("002");
        student.setName("Rahul");
        student.setEmail("Rahul123@gmail.com");
        student.setAddress("Udaipur");
        studentList.add(student);

        student = new Student();
        student.setId("003");
        student.setName("Jhon");
        student.setEmail("John123@gmail.com");
        student.setAddress("Jaipur");
        studentList.add(student);
        return studentList;

    }



    @Override
    public void removeStudent(String stdId) {
        studentList.remove( stdId);


    }

}
