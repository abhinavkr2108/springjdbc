package com.spring.springjdbc.repository;

import com.spring.springjdbc.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void addStudent(Student student){
        String sql = "insert into student (rollNo, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql,student.getRollNo(),student.getName(),student.getMarks());
        System.out.println(rows+" Rows Affected");

    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));
                return student;
            }
        };
        return jdbc.query(sql,rowMapper);
    }


}
