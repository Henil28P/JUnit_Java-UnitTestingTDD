package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
	// Test deposition operation
	@ParameterizedTest // specify which parameters to use (parameters come from a source) - the source is always an array
	@ValueSource(ints = {100,400,800,1000}) // @ValueSource contains an array of ints
	@DisplayName("Depositing successfully")
	// This test will run 4 times (4 elements in array of ints of @ValueSource)
	public void testDeposit(int amount, BankAccount bankAccount) // now we can deposit multiple values
	{
		bankAccount.deposit(amount); // deposit 500 to current balance of 400 to bankAccount
		assertEquals(amount,bankAccount.getBalance()); // check if 400(current balance) + 500(deposited amount) = 900 (new balance)
	}
}
