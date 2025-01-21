package org.example.junit_unittesting_tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; // for using @Test annotation in JUnit 5

public class CodeTest {

	// Function to test sayHello() function in Code class
	@Test
	public void testSayHello()
	{
		Code code = new Code(); // create an instance of Code class
		assertEquals("Hello world!", code.sayHello()); // test whether expected value and actual value returned by 'code' object are equal
	}
}
