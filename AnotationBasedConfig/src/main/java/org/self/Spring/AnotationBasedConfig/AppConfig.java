package org.self.Spring.AnotationBasedConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//used componentScan to generate beans automatically for all the components class in the package
@ComponentScan(basePackages = "org.self.Spring.AnotationBasedConfig")
public class AppConfig {

//	@Bean
//	public Samsung getPhone() {
//		return new Samsung();
//	}
//
//	@Bean
//	public Processor getCpu() {
//		return new Snapdragon();
//	}

}
