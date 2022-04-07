package com.ncu.Spring_JDBC;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //create a spring container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        StudentDAO dao = context.getBean("studentDaoImpl", StudentDaoImpl.class);
        
//        Student student = context.getBean("student", Student.class);
        
        
        //invoke bean methods
        
//        student.setId(100);
//        student.setName("John");
//        student.setAddress("Bond Street");
        
//        student.setId(102);
//        student.setName("Sethi");
//        student.setAddress("Ludhiana");
        
//        dao.insertRecord(student);
        
        System.out.println("================Records Fetched================");
        
        List<Student> students = dao.getAllRecords();
        
        for(Student student1 : students) {
        	System.out.println(student1);
        }
        
        dao.deleteRecord(100);
        //close the context
        context.close();
        
    }
}
