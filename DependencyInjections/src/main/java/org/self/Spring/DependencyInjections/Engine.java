package org.self.Spring.DependencyInjections;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private String type;

	public Engine(String type) {
		super();
		this.type = type;
	}

	@Override
	public String toString() {
		return "Engine [type=" + type + "]";
	}

}
