package org.example.junit_unittesting_tdd.annotations;

public class Parent {
	public void someMethod()
	{
		;
	}

	// @Deprecated will warn developers that are using the code that the method they are using is actually deprecated.
	@Deprecated
	public void otherMethod()
	{
		System.out.println("Doing interesting stuff...");
	}
}
