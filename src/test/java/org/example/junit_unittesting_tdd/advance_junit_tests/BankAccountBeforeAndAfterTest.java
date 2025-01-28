package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BankAccountBeforeAndAfterTest {
	// This class will contain 2 methods: testWithdraw() and testDeposit()
	static BankAccount bankAccount;

	@BeforeAll // To run code in prepTest() before all other test methods
	public static void prepTest()
	{
		// Initiate the bankAccount in this method instead of top to run before all other test methods
		System.out.println("Hi!");
		bankAccount = new BankAccount(500,0); // instead of creating new instance in every test methods, let's give this one a 'static' bank account instead
	}

	// Hence, the bankAccount will get modified by the 1st method (above) and so with the 2nd as it's the same object
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

	@AfterAll // can also put this method on top
	public static void endTest()
	{
		System.out.println("Bye!");
		// mainly used to close any lingering connections or making sure that the objects get destroyed in the after
	}
}
