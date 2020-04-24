package application;

//Class to hold the funds available to the restaurant
public class BankAccount {
	private double balance;

	/**
	 * Constructor sets initial balance to $1000.00
	 */
	public BankAccount() {
		this.balance = 1000.00;
	}

	// method to make deposits from sales
	public void makeDeposit(double amount) {
		this.balance += amount;
	}

	// method to withdraw funds for payments
	public void makePayment(double amount) {
		this.balance -= amount;
	}

	// getter for balance
	public double getBalance() {
		return this.balance;
	}
}
