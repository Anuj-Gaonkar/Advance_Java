package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.CarPart;
import com.cdac.component.CarPartsInventory;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-cfg.xml");
		CarPartsInventory inv = (CarPartsInventory) ctx.getBean("CarParts3");
		
		CarPart cp = new CarPart();
		cp.setPartName("Headlights");
		cp.setPrice(1200);
		cp.setQuantity(10);
		cp.setCarModel("Maruti Suzuki Baleno");
		
		inv.addNewPart(cp);
	}
}
