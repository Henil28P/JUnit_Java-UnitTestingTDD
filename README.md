# JUnit_Java-UnitTestingTDD
A Java Unit Testing project with JUnit as main unit testing framework for Java. Includes approach to Test-Driven Development (TDD) and Assertions and other key unit testing components on base level of Testing Pyramid.

# JUnit important topics
- Annotations (start with @, source code metadata)
- Best practices - keep it simple, test the actual unit, clear naming and stick to conventions, low-cyclomatic complexity

# Unit testing and other testing types
1. Unit testing
- Testing smallest pieces of the code
- Unit testing alone is not enough to get a grasp of how the system is working and whether it's really behaving as expected.

2. System testing
- Testing a bigger part (eg. the complete API)

3. Integration testing
- Testing different parts and how they work together

4. Acceptance testing
- Where the end-user(s) come in to see whether they are capable of using the software as intended

5. Performance testing
- Testing whether the application is quick enough to load, handle and respond

6. Regression testing
- Testing everything again whenever small changes to code are made to check if the small change didn't throw over any of the existing functionality.

7. Security testing (Penetration testing)
- Testing to spot weaknesses in the security of the system

8. Load testing
- Test to see whether the application can deal with huge loads of traffic at the same time.

9. End-to-end testing (UI testing)
- Testing the application as a whole --> this can be automated with tools such as Selenium and others.

# Test-Driven Development (TDD)
- Instead of starting with the implementation code, we actually write the unit tests before writing implementation code
- The unit tests should fail the first time as the implementation code has not been written yet
- TDD forces the developer to think about the requirement before implementation.
- TDD ensures tests are not skipped due to time pressure
- TDD ensures that bugs are spotted early
- TDD ensures that developers don't skip the test
- Process: write failing test --> implement code that makes the test pass --> Refactor the code for cleanliness --> (go back to step 1 of writing a new failing test and new feature code needs to be implemented for it)
- Note: TDD only adds the unit tests. In order to properly test to the application, we'll need to have system and integration tests in place as well.

# Advantages of unit testing
- Validate the smallest units of software - zoom in and see if the tiny pieces do what they should be doing
- Enable us to find bugs easy and early, not for only newly written code but also more for code that has already been written and accidentally gets influenced by new code - this way with unit testing, we can easily see whenever a new code is knocking over behaviour that we expect.
- Although unit testing takes a lot of time, it will save money and time as these bugs will be spotted easily and early - this will avoid real trouble on production.
- Unit testing can force developers to write better and cleaner code.
- Note: Be aware that only performing unit testing will not catch all the bugs - we need other tests in place as well to test the software as a whole.

# What is JUnit?
- JUnit is a unit testing framework for Java - this means that JUnit contains many libraries, functions and options for testing the smallest parts of Java program.
- JUnit is not standalone - it is part of the xUnit series for all other sorts of programming languages as well, there are multiple versions of the xUnit series that can be used for testing the units of our code - but JUnit is specifically for Java.
- JUnit enables automated unit testing very easily
- JUnit is a must-have for TDD using Java

# Summary
- We need more testing than just unit testing because unit tests don't test that the application as a whole is functioning as expected.
- Unit testing improves the code quality and ensures that pieces of code behave as expected, because the developer is forced to write testable code.
- Advantages of TDD for our software: TDD forces the developer to think thoroughly about the implementation code before actually implementing a feature, which leads to better code.
- JUnit is a unit testing framework for Java.

# Quick example of a basic Unit test
1. Simple Java class with 1 method
2. Write first unit test for the happy path
3. Write unit test for unhappy path - what happens if we expect an Exception to appear

# Writing our first JUnit test
1. Write some code that we can test
2. Add test class
3. Write test
4. Run test
- For this project, look at `Code` class for this example

# Annotations
- Annotations start with @
- JUnit uses annotations a lot
- Annotations are source code metadata
- One of the use cases for annotations is to make rules for an interface that our compiler will take into account (eg. use `@FunctionalInterface` on top of the interface definition).
1. `@FunctionalAInterface` - this will make sure only 1 abstract method is allowed in that interface.
2. `@Override` - this makes sure that the method is actually an override from another method in the parent class - so with this annotation on top of the method, we cannot change the name of the method or change the number of parameters
3. `@Deprecated` - this will warn developers that are using the code that the method they are using is actually deprecated.

# Naming our tests using `@DisplayName` annotation
- Improve the report that comes out of the test using `@DisplayName`
- `@DisplayName` is an annotation that allows us to replace a default name with a custom name which allows us to make the report more descriptive.
- Adding a `@DisplayName` to all of the tests can make the output better structured
- `@DisplayName` replaces the default name of test class and methods to custom names in the test report
- Note: It is a good practice to have descriptive names for our test methods, but it's even nicer to have a little description with spaces and punctuation instead.

# Advanced Assertions
- Assertions are used to check the outcome of the test
- If the assertion fails, the unit test fails
- Assertions class in `org.junit.jupiter.api` package - use `static` import for this one so that we can use all the methods (eg. assertTrue or assertEquals) without having the Assertions. in front of them
- There are many overloads in Assertions class of JUnit (assertEquals, assertTrue, etc.)
- Note: Not all assertions take 2 arguments for comparison such as assertTrue() and assertFalse() take only 1 argument as boolean condition

1. `assertArrayEquals()` - check whether 2 arrays are equal - if they are arrays of objects, it will check whether they are deeply equal looking at the objects on the array
- It takes an expected array and compares it to the actual array.
2. `assertTrue()` and `assertFalse()` take only 1 argument for testing on boolean condition
3. `assertNull()` and `assertNotNull()` also don't require 2 arguments - there is just 1 value for conclusion which depends on being either null or not.
4. `assertSame()` - to check if variable values are different but they are referring to the exact same object (if wanting to check whether they DON'T point to the same object, then use `assertNotSame()` overload)
5. `assertThrows()` - to check whether a method throws an exception in certain circumstances (eg. BankAccount class throwing an exception when we try to withdraw below the minimum)
6. `assetAll()` - to check whether our executables don't throw an exception regardless of the rest of the result.
7. `assertTimeout()` or `assertTimeoutPreemptively()`- to check whether something takes too long or not.

- Common overloads
1. The overload that has delta parameter - useful when doing calculations and not knowing the very exact result (eg. when it's a fraction)
- When a delta is being added, there is a range on the expected result that will result in a match with the expected value (eg. if wanting to test on 1/3, we can write 0.33)
2. Where the last parameter is a string message

- Note: `fail()` - this method will fail the test regardless if it passes if `fail()` is added to the method and we can insert a message as parameter of the method

# Assumptions
- Assumptions are a way of setting conditions for executing a test
- If the assumption is met, the test will be executed
- If the assumption is not met, the test won't be executed
- Assumptions are in a class in the `org.junit.jupiter.api` package - this class contains methods that will test assumptions

# Difference between Assertions and Assumptions
1. Assumption
- A failed assumption does not lead to a failed test like a failed assertion does, but a failed assumption to an aborted test instead.
- It an assumption is met, the test is run and if an assumption is not met, the test will be aborted

2. Assertion
- If an assertion is met, the test will succeed/PASS. If an assertion is not met, the test will FAIL

- Note: An assumption that is met might still lead to a failed test in case the assertion is false
- Assumptions don't say anything about the outcome of a test, but just about whether the test will actually run or get aborted.
- Check the documentation of Assumptions to see the methods of the Assumptions class (eg. `assumeTrue()`, `assumeFalse()`, `assumingThat()`, etc)
- `assumingThat()` - takes 2 arguments (a Boolean condition and an executable) - if the condition is true, it will execute the executable that may contain the assertion

# Test execution order
- Without specifying, we cannot predict the order
- Usually, this is not a problem as tests should be independent when testing units with JUnit
- In some cases though, we may want to test the order of the execution (eg. when executing more of integration type of test which is where the order of execution starts to matter)
- If we do need to order our tests, JUnit 5 comes with an elegant solution with Annotations
