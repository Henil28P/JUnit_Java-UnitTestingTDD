package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // this allows us to use methods with @BeforeAll and @AfterAll without "static"
public class BankAccountBeforeAndAfterTest {
	// This class will contain 2 methods: testWithdraw() and testDeposit()
	static BankAccount bankAccount;

	// With unit tests, we generally don't want to depend on the test so we could reset the account before every test using @BeforeEach
	// Have to adjust 2nd method though as the outcome will be different since the account balance is different when it enters that method as the previous one will not affect it
	// Also, don't need "static" for @BeforeEach and @AfterEach
	@BeforeEach
	public void prepTest()
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

	@AfterEach
	public void endTest()
	{
		System.out.println("Bye!");
		// mainly used to close any lingering connections or making sure that the objects get destroyed in the after
	}
}
