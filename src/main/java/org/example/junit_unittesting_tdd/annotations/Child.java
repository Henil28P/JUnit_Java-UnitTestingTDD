package org.example.junit_unittesting_tdd.annotations;

public class Child extends Parent {

	// @Override makes sure that the method is actually an override from another method in the parent class - so with this annotation on top of the method, we cannot change the name of the method or change the number of parameters
	@Override
	public void someMethod()
	{
		System.out.println("Overriding method from the Parent class");
	}
}
