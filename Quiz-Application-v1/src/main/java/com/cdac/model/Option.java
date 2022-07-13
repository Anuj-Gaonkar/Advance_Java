package com.cdac.model;

public class Option {

	private String option;
	private boolean isRightAnswer;
	
	public Option() {
		// Default Constructor
	}

	public Option(String option, boolean isRightAnswer) {	// Parameterized constructor
		super();
		this.option = option;
		this.isRightAnswer = isRightAnswer;
	}

	public String getOption() {		// getter
		return option;
	}

	public void setOption(String option) {		// setter
		this.option = option;
	}

	public boolean isRightAnswer() {
		return isRightAnswer;
	}

	public void setRightAnswer(boolean isRightAnswer) {
		this.isRightAnswer = isRightAnswer;
	}
	
}
