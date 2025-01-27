package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class) // this will enable us to just use the BankAccount as if it were instantiated already 
// (if we don't use this, it won't know what it needs to inject)
public class BankAccountDITest {
	// Test deposition operation
	@Test
	@DisplayName("Deposit 400 successfully")
	public void testDeposit(BankAccount bankAccount)
	{
		bankAccount.deposit(500); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(500,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
	// the above indicates that we are working with loosely coupled classes and we're avoiding many BankAccount instantiations by using DI
}
