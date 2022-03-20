package org.self.Spring.AnotationBasedConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Used component to generate beans automatically
@Component
public class Samsung {
	@Autowired

	// qualifier is used to specify which bean is to link
	@Qualifier("snapdragon")
	Processor cpu;

	public Processor getCpu() {
		return cpu;
	}

	public void setCpu(Processor cpu) {
		this.cpu = cpu;
	}

	public void config() {
		System.out.println("Data available");
		cpu.process();
	}
}
