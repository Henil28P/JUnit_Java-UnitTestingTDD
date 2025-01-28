package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisabledTest {
	// Test deposition operation
	@Test
	@Disabled("Temporarily disabled due to maintenance") // the test will not run regardless of passing or failing as it is disabled
	// need to provide a reason for disabling which appears in the test report - can add this as an argument on @Disabled (as provided above)
	public void testDeposit(BankAccount bankAccount)
	{
		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(500,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
}
