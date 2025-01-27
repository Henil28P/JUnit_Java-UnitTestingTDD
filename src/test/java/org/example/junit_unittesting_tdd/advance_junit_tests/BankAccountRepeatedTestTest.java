package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {
	// Test deposition operation
	@RepeatedTest(5) // this test will now run 5 times (replace @Test with @RepeatedTest(n) to run the test 'n' times)
	@DisplayName("Deposit 400 successfully")
	public void testDeposit(BankAccount bankAccount)
	{
		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(500,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
}
