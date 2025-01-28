package org.example.junit_unittesting_tdd.advance_junit_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
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

	@Test
	@EnabledOnJre({JRE.JAVA_17}) // test should only be allowed on JRE Java16 (can specify multiple versions in the array)
	public void testJRE()
	{
		;
	}

	@Test
	@DisabledOnJre({JRE.JAVA_8}) // to allow tests to run on JRE except the ones specified in this array of @DisabledOnJre annotation and ignore all tests that use these JRE in this list
	public void testNoJRE8()
	{
		;
	}
}
