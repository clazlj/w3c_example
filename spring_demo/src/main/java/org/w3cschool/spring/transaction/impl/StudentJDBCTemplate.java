package org.w3cschool.spring.transaction.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3cschool.spring.transaction.StudentDAO;
import org.w3cschool.spring.transaction.StudentMarks;
import org.w3cschool.spring.transaction.StudentMarksMapper;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void create(String name, Integer age, Integer marks, Integer year) {
        try {
            String sql = "insert into Student(name,age) values(?,?)";
            jdbcTemplate.update(sql, name, age);

            //Get the latest student id to be used in Marks table
            String sql2 = "select max(id) from Student";
            int sid = jdbcTemplate.queryForObject(sql2, Integer.class);

            String sql3 = "insert into Marks(sid,marks,year) values(?,?,?)";
            jdbcTemplate.update(sql3, sid, marks, year);

            System.out.println(String.format("Created Name=%s,Age=%s", name, age));

            //to simulate the exception
            throw new RuntimeException("simulate Error condition");
        } catch (DataAccessException e) {
            System.out.println("Error in creating record,rolling back");
            throw e;
        }
    }

    public List<StudentMarks> listStudents() {
        String sql = "select * from Student,Marks where Student.id=Marks.sid";
        return jdbcTemplate.query(sql, new StudentMarksMapper());
    }
}
