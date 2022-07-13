package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.PhoneBook;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		PhoneBook pb = (PhoneBook) ctx.getBean("phoneBookImpl");
		pb.add("Anuj", "9769372064");
		
		
		
	}

}
