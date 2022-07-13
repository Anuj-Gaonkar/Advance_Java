package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Atm;
import com.cdac.component.Bank;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		Bank bank = (Bank) ctx.getBean("citiBank");
		bank.withdraw(100, 100, 10);
		
		Atm atm = (Atm) ctx.getBean("hdfcAtm");
		atm.withdraw(202020202, 10);
	}
}
