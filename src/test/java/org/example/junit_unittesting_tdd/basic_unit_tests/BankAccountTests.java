package org.example.junit_unittesting_tdd.basic_unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test BankAccount class")
public class BankAccountTests {
	// Test withdraw operation
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

	@Test
	@DisplayName("Withdraw will become negative")
	public void testWithdrawNotStuckAtZero()
	{
		BankAccount bankAccount = new BankAccount(500,-1000);

		bankAccount.withdraw(800); // should result in -300 as 500-800=-300 (new balance)
		assertNotEquals(0,bankAccount.getBalance()); // should pass as 0 is NOT equal to -300
	}

	// Check if the Bank account is active after creation
	@Test
	@DisplayName("Test activation account after creation")
	public void testActive()
	{
		BankAccount bankAccount = new BankAccount(500,0);

		assertTrue(bankAccount.isActive()); // test will pass as isActive boolean field is set to "true" by default in BankAccount.java class
	}

	// Check if bank account holder's name is set and hence not null using assertNotNull() overload (or not set and hence null using assertNull() overload)
	@Test
	@DisplayName("Test set holder name")
	public void testHolderNameSet()
	{
		BankAccount bankAccount = new BankAccount(500,0);

		bankAccount.setHolderName("Henil"); // set holder name to "Henil" using the setter in bankAccount object
		assertNotNull(bankAccount.getHolderName()); // will pass as holder name string is now "Henil" which is not null
	}

	// Check BankAccount class throwing an exception when we try to withdraw below the minimum
	@Test
	@DisplayName("Test that we can't withdraw below minimum")
	public void testNoWithdrawBelowMinimum()
	{
		BankAccount bankAccount = new BankAccount(500,-1000);

		assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000)); // withdraw 2000 (more than current balance of 500) to throw runtime exception
	}
	
	// Check if executables don't throw an exception regardless of the rest of the result
	@Test
	@DisplayName("Test no exceptions for withdraw and deposit")
	public void testWithdrawAndDepositWithoutExceptions()
	{
		BankAccount bankAccount = new BankAccount(500,-1000);
		
		assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450)); // this doesn't look/assert on the result, it only checks whether an exception is thrown or not for the executables passed in its arguments
	}

	// Check if test takes too long or not using assertTimeout()
	@Test
	@DisplayName("Test speed deposit")
	public void testDepositTimeout()
	{
		BankAccount bankAccount = new BankAccount(400,0);

		assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200)); // test will fail if it takes longer than 1 nanosecond to deposit 200 in the bank account
		assertEquals(0.33,1/3, 0.01); // 0.01 is a delta value range which will result in a pass test as 0.33 is not EXACTLY = to 1/3 but close as 0.01 range
		assertEquals(0.33,1/3,"Oops, not the exact same"); // in this case, when the test is failing, we have a custom message when the test is failing (this message won't be seen when the test is passing)
	}
}
