package org.example.junit_unittesting_tdd.advance_junit_tests;

import org.example.junit_unittesting_tdd.basic_junit_tests.BankAccount;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class BankAccountParameterResolver implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		// TODO Auto-generated method stub
		return parameterContext.getParameter().getType() == BankAccount.class; // this is supported as soon as we're talking about a BankAccount instance
		// if the type is of type BankAccount class, it should return true
	}

	// resolveParameter() will hand the object to us
	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		// TODO Auto-generated method stub
		// make sure resolveParameter() is not resolving the object to null as we don't need all the null pointers in our code
		return new BankAccount(0,0); // return a new bank account
	}
	// Now we can use this dependency in our test and no need to create new instances of BankAccount in there	
}
