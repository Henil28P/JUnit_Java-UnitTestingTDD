package org.example.junit_unittesting_tdd.basic_unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountNestedTest {
	// Test withdrawal operation
	@Test
	@DisplayName("Withdraw 500 successfully")
	public void testWithdraw()
	{
		BankAccount bankAccount = new BankAccount(500, -1000); // create a new instance of BankAccount class with starter values of balance as 500 and minimumBalance as -1000
		
		// withdraw 300 and use assertEquals to check expected result of withdraw operation functionality
		bankAccount.withdraw(300);
		assertEquals(200, bankAccount.getBalance()); // check if 500(current balance)-300(withdrew)=200(new balance)
	}

	// Test deposition operation
	@Test
	@DisplayName("Deposit 400 successfully")
	public void testDeposit()
	{
		BankAccount bankAccount = new BankAccount(400,0); // initial balance as 400 and minimumBalance as 0

		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(900,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
}
