package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Atm;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		Atm atm = (Atm) ctx.getBean("hdfcAtm");
		atm.withdraw(2020, 10);
	}
}
