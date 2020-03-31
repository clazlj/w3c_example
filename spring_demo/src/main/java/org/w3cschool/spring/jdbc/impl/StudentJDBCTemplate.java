package org.w3cschool.spring.jdbc.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3cschool.spring.jdbc.Student;
import org.w3cschool.spring.jdbc.StudentDAO;
import org.w3cschool.spring.jdbc.StudentMapper;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    //还有其他 NamedParameterJdbcTemplate 和 SimpleJdbcTemplate 类的数据库
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void create(String name, Integer age) {
        String sql = "insert into Student(name,age) values(?,?)";
        jdbcTemplate.update(sql, name, age);
        System.out.println("Created Record Name=" + name + " Age=" + age);
    }

    public Student getStudent(Integer id) {
        String sql = "select * from Student where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
    }

    public List<Student> listStudents() {
        String sql = "select * from Student";
        return jdbcTemplate.query(sql, new StudentMapper());
    }

    public void delete(Integer id) {
        String sql = "delete from Student where id=?";
        jdbcTemplate.update(sql, id);
        System.out.println("Deleted Recore with id=" + id);
    }

    public void update(Integer id, Integer age) {
        String sql = "update Student set age=? where id=?";
        jdbcTemplate.update(sql, age, id);
        System.out.println("Updated Record with id=" + id);
    }
}
