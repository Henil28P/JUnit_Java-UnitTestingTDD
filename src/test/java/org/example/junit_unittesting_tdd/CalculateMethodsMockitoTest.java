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
}
