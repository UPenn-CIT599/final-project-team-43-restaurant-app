package application;

/**
 * Class to creat a Bank Account object holding funds available to the
 * restaurant
 * 
 * @author porth
 *
 */
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

	// setter for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// static getter for account
	public static BankAccount getBankAccount() {
		return bankAccount;
	}

	// static setter for account
	public static void setBankAccount(BankAccount bankAccount) {
		BankAccount.bankAccount = bankAccount;
	}

}
