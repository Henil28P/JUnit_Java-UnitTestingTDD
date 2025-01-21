package org.example.junit_unittesting_tdd.basic_junit_tests;

public class BankAccount {
	// Give 2 private properties/fields
	private double balance;
	private double minimumBalance;
	
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
}
