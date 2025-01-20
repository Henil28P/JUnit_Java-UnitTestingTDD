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
