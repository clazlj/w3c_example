package org.w3cschool.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3cschool.spring.jdbc.impl.StudentJDBCTemplate;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("JdbcBeans.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("------Records Creation------");
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nura", 2);
        studentJDBCTemplate.create("Ayan", 15);

        System.out.println("------Listing Multiple Records------");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.println(String.format("ID:%s,Name:%s,Age:%s", record.getId(), record.getName(), record.getAge()));
        }

        System.out.println("------Updating Record With ID 2------");
        studentJDBCTemplate.update(2, 20);

        System.out.println("------Listing Record With ID 2 ------");
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.println(String.format("ID:%s,Name:%s,Age:%s", student.getId(), student.getName(), student.getAge()));
    }
}
