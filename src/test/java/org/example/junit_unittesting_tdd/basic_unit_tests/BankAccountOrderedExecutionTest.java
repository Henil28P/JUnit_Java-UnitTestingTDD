package org.example.junit_unittesting_tdd.basic_unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // This tells JUnit5 that the tests in this class is going to be run in the order of the order annotations (if @TestMethodOrder is not added above class, the @Order above each method will be ignored)
public class BankAccountOrderedExecutionTest {
	// This class will contain 2 methods: testWithdraw() and testDeposit()
	static BankAccount bankAccount = new BankAccount(0,0); // instead of creating new instance in every test methods, let's give this one a 'static' bank account instead
	
	@Test
	@Order(2) // this will call testDeposit() test before testWithdraw() which is ordered as 2
	public void testWithdraw()
	{
		// Throw an exception whenever wanting to withdraw more than the minimum balance
		// eg. when min balance is 0, if our withdraw gets called before our deposit, we will get an exception - order matters
		bankAccount.withdraw(300);
		assertEquals(200,bankAccount.getBalance());
	}

	@Test
	@Order(1) // @Order(2) means testWithdraw() will run in 2nd order (after 1st order which is testDeposit())
	public void testDeposit()
	{
		bankAccount.deposit(500);
		assertEquals(500,bankAccount.getBalance());
	}
}
