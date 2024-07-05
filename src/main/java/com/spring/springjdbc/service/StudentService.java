package com.spring.springjdbc.service;

import com.spring.springjdbc.models.Student;
import com.spring.springjdbc.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;
    public void addStudent(Student student){
        System.out.println("Adding Student added to DB...");
        repo.addStudent(student);
    }

    public List<Student> getStudents(Student student) {
        System.out.println("fetching students...");
        return repo.findAll(student);
    }
}
