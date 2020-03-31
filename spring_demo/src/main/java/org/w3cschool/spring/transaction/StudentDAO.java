package org.w3cschool.spring.transaction;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    void setDataSource(DataSource ds);

    void create(String name, Integer age, Integer marks, Integer year);

    List<StudentMarks> listStudents();
}
