package org.example.junit_unittesting_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // to enable Mockito - for now, we don't need to specify a runner and we don't need to enter the mocks explicitly
public class CalculateMethodsMockitoTest {
	@Mock // no need to initialise the object
	CalculateMethods calculateMethods; //  object

	// define how our Mock will behave - it will override functionality
	// Hence, we cannot use price, fields and methods just like this - this is where we need Bio Mock or write our own reflection code
	// For now, it's possible to test private methods

	// Specify what needs to happen when we call our defined methods - to do this, create a method that should run before the tests
	@BeforeEach
	public void setupMock()
	{
		// in the Mockito.when(<specify what needs to happen when doing a certain action>)
		Mockito.when(calculateMethods.divide(6, 3)).thenReturn(2.0); // whenever the divide() is called with parameters 6 and 3, we will return 2.0
	}
}
