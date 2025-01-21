package org.example.junit_unittesting_tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateMethodsTest {
	private CalculateMethods calculateMethods;

	// Initiate calculateMethods before every test
	@BeforeEach
	public void initTest()
	{
		calculateMethods = new CalculateMethods(); // this will run before every test
	}

	// Function to test divide() method in calculateMethods instance
	@Test
	public void testDivide()
	{
		Assertions.assertEquals(10, calculateMethods.divide(100,10)); // assertEquals(expectedResult, function to call with parameters)
	}

	// Test for an exception to occur (eg. when dividing by 0)
	@Test
	public void testDivideByZero()
	{
		Assertions.assertThrows(ArithmeticException.class, () -> calculateMethods.divide(100, 0));
		// assertThrows(<typeOfException>, Executable to implement using Lambda expression that takes no parameter but calls the divide() function)
	}
}
