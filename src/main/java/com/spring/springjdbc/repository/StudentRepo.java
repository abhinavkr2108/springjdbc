package com.spring.springjdbc.repository;

import com.spring.springjdbc.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    public void addStudent(Student student){
        System.out.println("Student added to DB");
    }

    public List<Student> findAll(Student student) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        return studentList;
    }
}
