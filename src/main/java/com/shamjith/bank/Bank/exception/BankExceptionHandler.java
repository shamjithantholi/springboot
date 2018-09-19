package com.shamjith.bank.Bank.exception;

import org.springframework.stereotype.Component;

@Component
public class BankExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void BankException(Exception e){
		System.out.println("in bank custom excption >>>>>>>>>>>>>> ");
		e.printStackTrace();
	}
}
