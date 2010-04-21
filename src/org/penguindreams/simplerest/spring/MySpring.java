package org.penguindreams.simplerest.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpring {

	//singleton -- static methods only
	private MySpring() {}
	
	private static ApplicationContext ctx = null;

	private static ApplicationContext getContext() {
		if(ctx == null) {
			ctx = new ClassPathXmlApplicationContext("/com/penguindreams/simplerest/spring/applicationContext.xml");
		}
		return ctx;
	}
	
	public static Object getBean(String name) {
		return getContext().getBean(name);
	}
	
}
