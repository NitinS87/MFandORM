package org.self.Spring.DependencyInjections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//        System.out.println( "Hello World!" );

		// Step 1: Add ApplicationContext interface to the project
		// and add ClassPathXmlApplicationContext("your-XML-file-Name.xml");
		// this file gives us the bean to which should we initialize our object
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// by defining bean
		Vehicle obj = (Vehicle) context.getBean("car");
		obj.drive();

		// using component scan
		Vehicle obj1 = (Vehicle) context.getBean("bike");
		obj1.drive();

		// beans property getters and setters
		Tyre tyre = (Tyre) context.getBean("tyre");
		System.out.println(tyre);

		// constructor injection
		Engine e = (Engine) context.getBean("engine");
		System.out.println(e);

	}
}
