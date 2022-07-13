package com.cdac.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.cdac.dao.Dao;
import com.cdac.entity.Customer;
import com.cdac.entity.Transaction;

public class Main {

	public static void main(String[] args) {
		Customer cust = new Customer();
		Transaction txn = new Transaction();
		Dao dao = new Dao();

		/*
		 * cust1.setName("Anuj"); cust1.setEmail("anuj@gmail");
		 * cust1.setAddress("Mumbai, Maharashtra"); dao.addCust(cust1);
		 * 
		 * txn1.setDate(LocalDate.of(2022, 7, 12)); txn1.setTotal(22000);
		 * dao.addTxn(txn1);
		 * 
		 * cust1.setTransaction(txn1); dao.update(cust1);
		 */

		/*
		 * cust1 = dao.fetchCustomersById(2); txn1 = dao.fetchTransactionById(2);
		 * System.out.println(cust1); System.out.println(txn1);
		 */

		/*
		 * cust.setName("Lewis"); cust.setAddress("Stevenage, England");
		 * cust.setEmail("lewis@outlook"); dao.addCust(cust);
		 * 
		 * txn.setDate(LocalDate.of(2022, 1, 6)); txn.setTotal(15000);
		 * 
		 * cust.setTransaction(txn); dao.update(cust);
		 */

		/*
		 * cust = dao.fetchCustomersById(1); System.out.println(cust);
		 * 
		 * txn = dao.fetchTransactionById(1); System.out.println(txn);
		 */

//		List<Customer> list = dao.fetchByName("Anuj");
//		List<Customer> list = dao.fetchByTransactionId(2);
		List<Object[]> list = dao.fetchSomeByTransactionId(2);

		System.out.println(list);
		for (Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		
		
	}
}
