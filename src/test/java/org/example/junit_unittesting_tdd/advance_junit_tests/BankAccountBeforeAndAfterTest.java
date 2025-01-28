package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BankAccountBeforeAndAfterTest {
	// This class will contain 2 methods: testWithdraw() and testDeposit()
		static BankAccount bankAccount = new BankAccount(500,0); // instead of creating new instance in every test methods, let's give this one a 'static' bank account instead
		
		@Test
		public void testWithdraw()
		{
			// Throw an exception whenever wanting to withdraw more than the minimum balance
			// eg. when min balance is 0, if our withdraw gets called before our deposit, we will get an exception - order matters
			bankAccount.withdraw(300);
			assertEquals(200,bankAccount.getBalance());
		}

		@Test
		public void testDeposit()
		{
			bankAccount.deposit(500);
			assertEquals(700,bankAccount.getBalance());
		}
}
