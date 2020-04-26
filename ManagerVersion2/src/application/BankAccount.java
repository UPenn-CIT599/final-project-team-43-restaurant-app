package application;

//Class to hold the funds available to the restaurant
public class BankAccount {
	private double balance;
	private static BankAccount bankAccount = new BankAccount();


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
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static BankAccount getBankAccount() {
		return bankAccount;
	}

	public static void setBankAccount(BankAccount bankAccount) {
		BankAccount.bankAccount = bankAccount;
	}

}
