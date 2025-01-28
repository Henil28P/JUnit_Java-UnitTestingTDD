package org.example.junit_unittesting_tdd.advance_junit_tests;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// Class to demonstrate how to use timeout in JUnit5
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {
	@Test
	public void testDepositTimeoutAssertion(BankAccount bankAccount)
	{
		;
	}
	
	@Test
	public void testDepositTimeoutAnnotation(BankAccount bankAccount)
	{
		;
	}
}
