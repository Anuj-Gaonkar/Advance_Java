package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("SimpleClass")
public class SimpleClass {
	public String returnNothing() {
		return "Nothing";
	}
}
