package application;

import java.util.Random;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class has one transaction record for the restaurant
 * 
 * @author yinjiezhang
 *
 */
public class TransactionItem {

	private SimpleStringProperty customerID;
	private SimpleStringProperty date;
	private SimpleStringProperty time;
	private SimpleDoubleProperty transactionAmount;
	private SimpleStringProperty paymentMethod;

	/**
	 * constructor
	 * 
	 * @param customerID
	 * @param date
	 * @param time
	 * @param transactionAmount
	 * @param paymentMethod
	 */
	public TransactionItem(String customerID, String date, String time, double transactionAmount,
			String paymentMethod) {
		this.customerID = new SimpleStringProperty(customerID);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
		this.transactionAmount = new SimpleDoubleProperty(transactionAmount);
		this.paymentMethod = new SimpleStringProperty(paymentMethod);
	}

	public String getCustomerID() {
		return customerID.get();
	}

	public String getDate() {
		return date.get();
	}

	public String getTime() {
		return time.get();
	}

	public double getTransactionAmount() {
		return transactionAmount.get();
	}

	public String getPaymentMethod() {
		return paymentMethod.get();
	}

	/**
	 * This method randomly generate transactions for the application, when in
	 * practical use, it should be input from customerOrder
	 * 
	 * @return transaction all the informations about one transaction
	 */
	public static TransactionItem transactionGenerator() {
		TransactionItem transaction;

		Random rd = new Random();

		String customerID;
		int date;
		String date2;
		String time;
		double transactionAmount;
		String paymentMethod;

		customerID = String.valueOf(rd.nextInt(100000));
		while (true) {
			date = rd.nextInt(31);
			if (date != 0) {
				break;
			}
		}
		date2 = String.valueOf(date);
		time = "" + String.valueOf(rd.nextInt(24)) + ":" + String.valueOf(rd.nextInt(60));
		transactionAmount = Math.round(rd.nextDouble() * 100.0) / 100.0 + rd.nextInt(100);

		// creating random paymentMethod
		String[] banks = { "Visa", "Amex", "Discovery", "MasterCard" };

		paymentMethod = banks[rd.nextInt(4)];

		transaction = new TransactionItem(customerID, date2, time, transactionAmount, paymentMethod);

		return transaction;
	}

}
