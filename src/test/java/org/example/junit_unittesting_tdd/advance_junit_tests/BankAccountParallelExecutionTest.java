package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT) // means all tests will start at the same time (concurrently) but their finishing time depends on their amount of sleeps
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
	// Test deposition operation
	// testDeposit() test method will start at the same time as others (concurrently) and will finish running 1st due to shortest sleep time of 200 ms
	@Test
	@DisplayName("Deposit 500 successfully")
	public void testDeposit(BankAccount bankAccount)
	{
		try
		{
			Thread.sleep(200); // let the method wait for 3000 milliseconds
		} catch (InterruptedException ex) {
			ex.printStackTrace(); // catch the possible InterruptedException
		}
		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(500,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
	
	// Test deposition operation
	// testDeposit3() test method will start at the same time as others (concurrently) but will finish running 3rd (last) due to sleep of 2000 ms
	@Test
	@DisplayName("Deposit 500 successfully")
	public void testDeposit2(BankAccount bankAccount)
	{
		try
		{
			Thread.sleep(2000); // let the method wait for 3000 milliseconds
		} catch (InterruptedException ex) {
			ex.printStackTrace(); // catch the possible InterruptedException
		}
		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(500,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
	
	// Test deposition operation
	// testDeposit3() test method will start at the same time as others (concurrently) but will finish running 2nd due to sleep of 1200 ms
	@Test
	@DisplayName("Deposit 500 successfully")
	public void testDeposit3(BankAccount bankAccount)
	{
		try
		{
			Thread.sleep(1200); // let the method wait for 3000 milliseconds
		} catch (InterruptedException ex) {
			ex.printStackTrace(); // catch the possible InterruptedException
		}
		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(500,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
}
