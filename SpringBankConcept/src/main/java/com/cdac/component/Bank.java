package com.cdac.component;

public interface Bank {
	public boolean isAccountPresent(int acno);
	public void withdraw(int atmId, int acno, double amount);
}
