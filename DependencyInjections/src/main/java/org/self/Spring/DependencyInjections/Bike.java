package org.self.Spring.DependencyInjections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	// autowired annotation used to take Engine class parameters
	@Autowired
	private Engine engine;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		System.out.println("Bhagg rhi hai...." + engine);
	}
}
