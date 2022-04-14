package com.ncu.Spring_JDBC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// create a spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentDAO dao = context.getBean("studentDaoImpl", StudentDaoImpl.class);

		List<Student> studentList = new ArrayList<Student>();
//		Student student = context.getBean("student", Student.class);
		Student student1 = context.getBean("student",Student.class);
		Student student2 = context.getBean("student",Student.class);
		Student student3 = context.getBean("student",Student.class);
		
		student1.setId(105);
		student1.setName("Gaurav");
		student1.setAddress("Banaras");
		studentList.add(student1);
		System.out.println(student1);
		
		student2.setId(106);
		student2.setName("Nitin");
		student2.setAddress("Haryana");
		studentList.add(student2);
		System.out.println(student2);
		
		student3.setId(107);
		student3.setName("Mittal");
		student3.setAddress("Faridabad");
		studentList.add(student3);
		System.out.println(student3);
		
		System.out.println(studentList);
		// invoke bean methods

		//inserting single record
//		student.setId(100);
//		student.setName("John");
//		student.setAddress("Bond Street");

//		dao.insertRecord(student);
		
		//inserting multiple records
//		dao.batchInsertRecords(studentList);
		
		//updating multiple records
		dao.batchUpdateRecords(studentList);
		
		
		
//        
		System.out.println("================Records Fetched================");

		List<Student> students = dao.getAllRecords();

		for (Student std : students) {
			System.out.println(std);
		}
//        
//		dao.deleteRecord(105);
//		dao.deleteRecord(106);
//		dao.deleteRecord(107);
//
//		student.setName("Manan");
//		student.setAddress("Punjab");
//		student.setId(102);

//		dao.updateRecord(student);

//		System.out.println("================Records Fetched================");
//
//		List<Student> studentss = dao.getAllRecords();
//
//		for (Student std : studentss) {
//			System.out.println(std);
//		}
		// close the context
		context.close();

	}
}
