package application;

/**
 * Class to creat a Bank Account object holding funds available to the
 * restaurant
 * 
 * @author porth, yinjiez
 *
 */
public class BankAccount {
	private String balance;
	private static BankAccount bankAccount = new BankAccount();

	// method to make deposits from sales
	public void makeDeposit(double amount) {
		double balanceDouble = Double.parseDouble(this.balance);
		balanceDouble += amount;
		this.balance = String.valueOf(balanceDouble);
	}

	// method to withdraw funds for payments
	public void makePayment(double amount) {
		double balanceDouble = Double.parseDouble(this.balance);
		balanceDouble -= amount;
		this.balance = String.valueOf(balanceDouble);
	}

	// getter for balance
	public String getBalance() {
		return this.balance;
	}

	// setter for balance
	public void setBalance(String balance) {
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
