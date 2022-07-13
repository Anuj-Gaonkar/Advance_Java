package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.User;
import com.cdac.component.UserFunctions;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-cfg.xml");
		
		UserFunctions uf = (UserFunctions) ctx.getBean("userFunction1");
		
		User user = new User();
		user.setName("Lewis");
		user.setEmail("lewis@outlook");
		user.setPassword("LH44");
		
//		uf.add("Anuj", "anuj@gmail", "Dota2");
		uf.find(1);
		uf.add(user);
		
		
		System.out.println("Last line");
		
	}
}
