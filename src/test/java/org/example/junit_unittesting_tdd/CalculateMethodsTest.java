package org.example.junit_unittesting_tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateMethodsTest {
	private CalculateMethods calculateMethods = new CalculateMethods(); // create a private property of type CalculateMethods and create an instance of it

	// Function to test divide() method in calculateMethods instance
	@Test
	public void testDivide()
	{
		Assertions.assertEquals(10, calculateMethods.divide(100,10)); // assertEquals(expectedResult, function to call with parameters)
	}
}
