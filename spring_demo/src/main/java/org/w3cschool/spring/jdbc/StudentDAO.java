package org.w3cschool.spring.jdbc;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    void setDataSource(DataSource ds);

    void create(String name, Integer age);

    Student getStudent(Integer id);

    List<Student> listStudents();

    void delete(Integer id);

    void update(Integer id, Integer age);
}
