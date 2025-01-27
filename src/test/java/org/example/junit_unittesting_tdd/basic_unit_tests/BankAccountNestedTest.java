package org.example.junit_unittesting_tdd.basic_unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

	// Create an inner class for when balance = 0
	@Nested
	class WhenBalanceEqualsZero
	{
		// Note that when this test file is run, only the 2 methods in the outer class will run and not the ones in this WhenBalanceEqualsZero class
		// This is because we have to add @Nested in order for these to get run as well
		// Also note that running test of a parent class will also execute all of the tests of her child's class (when we add @Nested on the class level - above the class name)
		@Test
		@DisplayName("Withdrawing below minimum balance exception")
		public void testWithdrawMinimumBalanceIs0()
		{
			BankAccount bankAccount = new BankAccount(0,0); // create a BankAccount instance
			// In this case, we expect an exception
			assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500)); // assertThrows because we expect an exception to be thrown
		}

		@Test
		@DisplayName("Withdrawing and getting a negative balance")
		public void testWithdrawMinimumBalanceNegative1000()
		{
			BankAccount bankAccount = new BankAccount(0,-1000);
			bankAccount.withdraw(500);
			// In this case, we get a new balance of -500
			assertEquals(-500, bankAccount.getBalance());
		}
	}
}
