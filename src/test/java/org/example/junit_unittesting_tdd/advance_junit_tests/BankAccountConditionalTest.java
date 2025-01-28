package org.example.junit_unittesting_tdd.advance_junit_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionalTest {

	// If wanting the test to only run on MacOS
	@Test
	@EnabledOnOs({OS.MAC}) // array of all the OS's the test should be enabled on (such as Mac)
	public void testMac()
	{
		;
	}

	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void testWindows()
	{
		;
	}
	// from the above tests, any 1 of them will be run and pass based on the OS the user runs on
}
