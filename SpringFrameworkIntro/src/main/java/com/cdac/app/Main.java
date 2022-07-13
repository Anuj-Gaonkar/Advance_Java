package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Calculator;
import com.cdac.component.HelloWorld;
import com.cdac.component.SimpleClass;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		HelloWorld hw = (HelloWorld) ctx.getBean("hello");
		System.out.println(hw.returnHello("Anuj"));
		
		Calculator calc = (Calculator) ctx.getBean("calc");
		System.out.println(calc.add(10, 20));
		System.out.println(calc.sub(30, 20));
		
		SimpleClass sc = (SimpleClass) ctx.getBean("SimpleClass");
		System.out.println(sc.returnNothing());
	}
}