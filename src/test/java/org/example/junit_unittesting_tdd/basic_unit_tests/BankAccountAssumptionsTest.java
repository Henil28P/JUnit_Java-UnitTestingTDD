package org.example.junit_unittesting_tdd.basic_unit_tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountAssumptionsTest {
	@Test
	@DisplayName("Test activation ccount after creation")
	public void testActive()
	{
		BankAccount bankAccount = new BankAccount(500,0);

		// We don't want the assertion to be tested when bankAccount is null because if it is null, there's no point in testing the assertion
		assumeTrue(bankAccount != null); // assume that bank account is not null is true - this test won't get aborted as bank account is not null
		assumeFalse(bankAccount == null); // test still fails as bank account being null is false hence assumeFalse()

		assertTrue(bankAccount.isActive());
	}
}
