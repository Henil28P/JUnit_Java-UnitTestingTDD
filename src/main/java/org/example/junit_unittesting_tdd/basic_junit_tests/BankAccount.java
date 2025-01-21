package org.example.junit_unittesting_tdd.basic_junit_tests;

public class BankAccount {
	// Give 2 private properties/fields
	private double balance;
	private double minimumBalance;
	private boolean isActive = true; // default isActive to true
	private String holderName; // bank account holder's name
	// Field to return the name of the bank account holder to test with assertNull() and assertNotNull() overloads

	
	// Constructor to set the above 2 fields
	public BankAccount(double balance, double minimumBalance)
	{
		this.balance = balance;
		this.minimumBalance = minimumBalance;
	}

	// Getters for balance and minimumBalance fields as they will be needed later
	public double getBalance() {
		return balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	// create 2 methods for bank operations (withdraw and deposit)
	// withdraw() will return the amount that we are withdrawing, and if not possible, then throw a runtime exception

	public double withdraw(double amount)
	{
		if (balance - amount > minimumBalance)
		{
			balance -= amount; // replace the balance with new balance after withdrawal
			return amount;
		}
		else
		{
			throw new RuntimeException();
		}
	}

	// deposit() - takes the amount to be deposited as parameter, and it will return the new balance after deposition
	public double deposit(double amount)
	{
		return balance+=amount; // return the old balance + amount deposited currently
		// we can also check for negative amounts but later
	}

	// Now test the behaviour of this BankAccount class using JUnit unit testing framework in src/test/java directory
}
