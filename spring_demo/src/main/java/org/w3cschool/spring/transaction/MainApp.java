package org.w3cschool.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("TransactionBeans.xml");
        StudentDAO dao = (StudentDAO) context.getBean("studentJDBCTemplate");
        System.out.println("------Records creation------");
        dao.create("Zara", 11, 99, 2010);
        dao.create("Nuha", 20, 97, 2010);
        dao.create("Ayan", 25, 100, 2011);

        System.out.println("------Listing all the records------");
        List<StudentMarks> studentMarks = dao.listStudents();
        for (StudentMarks record : studentMarks) {
            System.out.println(String.format("ID:%s, Name:%s, Marks:%s, Year:%s, Age:%s",
                    record.getId(), record.getName(), record.getMarks(), record.getYear(), record.getAge()));
        }
    }
}
