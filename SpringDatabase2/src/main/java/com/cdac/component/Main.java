package com.cdac.component;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//Loading Spring/IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-cfg.xml");
		
		CarPartsInventory inv = (CarPartsInventory) ctx.getBean("carParts3");
		
//		model/entity classes are not instantiated using Spring
		CarPart cp = new CarPart();
		cp.setPartName("Mirror");
		cp.setCarModel("Maruti 800");
		cp.setPrice(1500);
		cp.setQuantity(25);
		
		long ms1 = System.currentTimeMillis();
		inv.addNewPart(cp);
		long ms2 = System.currentTimeMillis();
		System.out.println("Total time taken : " + (ms2 - ms1) + " ms approx");
		
	}
}
