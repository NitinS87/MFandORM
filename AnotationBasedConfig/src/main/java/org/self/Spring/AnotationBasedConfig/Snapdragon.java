package org.self.Spring.AnotationBasedConfig;

import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements Processor {

	public void process() {
		System.out.println("World's best processor");
	}

}
