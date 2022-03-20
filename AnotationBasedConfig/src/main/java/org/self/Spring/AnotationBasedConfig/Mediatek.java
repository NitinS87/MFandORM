package org.self.Spring.AnotationBasedConfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

//primary keyword is used to specify the default bean which links automatically
@Primary
public class Mediatek implements Processor {

	public void process() {
		System.out.println("2nd best cpu");
	}

}
