package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

// Class to demonstrate how to use timeout in JUnit5
@ExtendWith(BankAccountParameterResolver.class)
// For all tests in class to be timed out instead of just 1 individual method
// @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
public class BankAccountTimeoutTest {
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // 2 attributes - the amount it can wait and the unit of time
	public void testDepositTimeoutAssertion(BankAccount bankAccount)
	{
		// make the test method fail first
		try
		{
			Thread.sleep(1000); // let the method wait for 1000 milliseconds
		} catch (InterruptedException ex) {
			ex.printStackTrace(); // catch the possible InterruptedException
		}
		
		bankAccount.deposit(300); // starting current balance from 0 initially, deposit 300 into the bank account
		assertEquals(300, bankAccount.getBalance()); // assert that 300 balance is actual current balance in bank account object
		// This test will fail and a sleep InterruptedException if sleep is 1000 ms, but 200ms would enable test to pass
	}

	@Test
	public void testDepositTimeoutAnnotation(BankAccount bankAccount)
	{
		// make the test method fail first
		try
		{
			Thread.sleep(3000); // let the method wait for 3000 milliseconds
		} catch (InterruptedException ex) {
			ex.printStackTrace(); // catch the possible InterruptedException
		}

		bankAccount.deposit(300); // starting current balance from 0 initially, deposit 300 into the bank account
		assertTimeout(Duration.ofMillis(500), () -> Thread.sleep(10)); // assert that 300 balance is actual current balance in bank account object
		// The test will fail initially as it will sleep for longer than the duration that we specified (will say "Execution exceeded timeout of 500 ms)
		// For the test to pass, we can lower the Thread.sleep() executable to 10ms as the timebox won't expire
	}
}
