package com.spring.springjdbc;

import com.spring.springjdbc.models.Student;
import com.spring.springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcApplication.class, args);

		Student student = context.getBean(Student.class);
		student.setRollNo(101);
		student.setName("Abhinav");
		student.setMarks(80);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student);

		List<Student> studentList = service.getStudents(student);
		System.out.println(studentList);
	}

}
