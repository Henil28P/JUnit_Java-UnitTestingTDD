package org.example.junit_unittesting_tdd.advance_junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
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

	// test some sort of enum as we want to use enum source
	@ParameterizedTest
	@EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"}) // the value argument requires the enum that we're using (dayOfWeek built-in enum)
	public void testDayOfWeek(DayOfWeek day)
	{
		assertTrue(day.toString().startsWith("T"));
	}

	@ParameterizedTest
	@CsvSource({"100, Henil", "200, Alex", "50, Alicia"}) // array contains "amount, name" pair
	public void depositAndNameTest(double amount, String name, BankAccount bankAccount)
	{
		bankAccount.deposit(amount);
		bankAccount.setHolderName(name);
		assertEquals(amount, bankAccount.getBalance());
		assertEquals(name, bankAccount.getHolderName());
		// JUnit will try to cause the source to the type of the parameter of test method (eg. 100 will be casted to a double, and Mary to a string)
		// However, if the types and values are not compatible (eg. hi100 instead of 100), it will throw the exception PreconditionViolation
	}
}
